/**
 * Copyright (c) 2015 Montages AG
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Inspired by org.eclipse.tycho.surefire.TestMojo
 */
package org.eclipse.gmf.tooling.codegen.maven;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.maven.execution.MavenSession;
import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.apache.maven.toolchain.Toolchain;
import org.apache.maven.toolchain.ToolchainManager;
import org.eclipse.gmf.tooling.codegen.launcher.GMFLauncherConstants;
import org.eclipse.sisu.equinox.launching.BundleStartLevel;
import org.eclipse.sisu.equinox.launching.DefaultEquinoxInstallationDescription;
import org.eclipse.sisu.equinox.launching.EquinoxInstallation;
import org.eclipse.sisu.equinox.launching.EquinoxInstallationDescription;
import org.eclipse.sisu.equinox.launching.EquinoxInstallationFactory;
import org.eclipse.sisu.equinox.launching.EquinoxLauncher;
import org.eclipse.sisu.equinox.launching.internal.EquinoxLaunchConfiguration;
import org.eclipse.tycho.ArtifactDescriptor;
import org.eclipse.tycho.ArtifactType;
import org.eclipse.tycho.ReactorProject;
import org.eclipse.tycho.artifacts.DependencyArtifacts;
import org.eclipse.tycho.core.DependencyResolver;
import org.eclipse.tycho.core.DependencyResolverConfiguration;
import org.eclipse.tycho.core.TargetPlatformConfiguration;
import org.eclipse.tycho.core.TychoConstants;
import org.eclipse.tycho.core.maven.ToolchainProvider;
import org.eclipse.tycho.core.maven.ToolchainProvider.JDKUsage;
import org.eclipse.tycho.core.osgitools.DefaultReactorProject;
import org.eclipse.tycho.core.resolver.DefaultDependencyResolverFactory;
import org.eclipse.tycho.core.resolver.shared.OptionalResolutionAction;
import org.eclipse.tycho.core.resolver.shared.PlatformPropertiesUtils;
import org.eclipse.tycho.core.utils.TychoProjectUtils;

@Mojo(name = "generate", defaultPhase=LifecyclePhase.GENERATE_SOURCES, requiresProject=true)
public class MavenGenerator extends AbstractMojo {

	public static final String SEPARATOR = File.separator;

	@Parameter(property = "session", readonly = true, required = true)
	private MavenSession session;

	@Parameter(defaultValue = "SYSTEM")
	private JDKUsage useJDK;

	@Parameter
	private BundleStartLevel defaultStartLevel;

	@Parameter(required = true)
	private String gmfgen;

	@Parameter(defaultValue = "${basedir}")
	private String output;

	@Parameter
	private File[] relatedProjects;

	@Parameter
	private File formatter;

	@Parameter
	private String customEmitter;

	@Parameter
	private String customEmitterBundle;

	@Parameter(property = "project", readonly = true)
	private MavenProject project;

	@Parameter(defaultValue = "${basedir}/../target/work")
	private File work;

	@Parameter(defaultValue = "${basedir}/../target/osgi/")
	private File osgiDataDirectory;

	@Component
	private ToolchainManager toolchainManager;

	@Component
	private ToolchainProvider toolchainProvider;

	@Component
	private EquinoxInstallationFactory installationFactory;

	@Component
	private DefaultDependencyResolverFactory dependencyResolverLocator;

	@Parameter
	private Dependency[] dependencies;

	@Component
	private EquinoxLauncher launcher;

	public void execute() throws MojoExecutionException {
		checkOverlapPath(work, project.getBasedir(), "Work dir", "Project dir");
		checkOverlapPath(osgiDataDirectory, project.getBasedir(), "OSGi dir", "Project dir");

		checkOverlapPath(work, output, "Work dir", "Path to generated plugin");
		checkOverlapPath(osgiDataDirectory, output, "OSGi dir", "Path to generated plugin");

		EquinoxInstallation gmfGenerationInstallation = createGMFGenerationIntallation();
		EquinoxLaunchConfiguration cli = new EquinoxLaunchConfiguration(gmfGenerationInstallation);

		String executable = null;
		Toolchain tc = getToolchain();
		if (tc != null) {
			executable = tc.findTool("java");
		}
		cli.setJvmExecutable(executable);
		cli.setWorkingDirectory(project.getBasedir());

		Properties properties = (Properties) project.getContextValue(TychoConstants.CTX_MERGED_PROPERTIES);
		cli.addVMArguments("-Dosgi.os=" + PlatformPropertiesUtils.getOS(properties), //
				"-Dosgi.ws=" + PlatformPropertiesUtils.getWS(properties), //
				"-Dosgi.arch=" + PlatformPropertiesUtils.getArch(properties));

		cli.addProgramArguments("-data", osgiDataDirectory.getAbsolutePath(), //
				"-install", gmfGenerationInstallation.getLocation().getAbsolutePath(), //
				"-application", "org.eclipse.gmf.tooling.codegen.launcher.GMFGenerateApplication",
				"-configuration", gmfGenerationInstallation.getConfigurationLocation().getAbsolutePath());
		
		String workDirPath = work.getAbsolutePath();
		StringBuilder tempFile = new StringBuilder(workDirPath);
		if (!workDirPath.endsWith(SEPARATOR)) {
			tempFile.append(SEPARATOR);
		}
		tempFile.append("gmflauncher.properties");
		String tempFilePath = tempFile.toString();
		prepareGeneratePropertyFile(tempFilePath);

		cli.addProgramArguments(GMFLauncherConstants.KEY_GENERATION_PROPERTIES, tempFilePath);

		int result = launcher.execute(cli, 0);

		if (result != 0) {
			throw new MojoExecutionException("Generation error");
		}
	}

	protected Toolchain getToolchain() throws MojoExecutionException {
		if (JDKUsage.SYSTEM.equals(useJDK)) {
			if (toolchainManager != null) {
				return toolchainManager.getToolchainFromBuildContext("jdk", session);
			}
			return null;
		}
		String profileName = TychoProjectUtils.getExecutionEnvironmentConfiguration(project).getProfileName();
		Toolchain toolChain = toolchainProvider.findMatchingJavaToolChain(session, profileName);
		if (toolChain == null) {
			throw new MojoExecutionException("useJDK = BREE configured, but no toolchain of type 'jdk' with id '"
					+ profileName + "' found. See http://maven.apache.org/guides/mini/guide-using-toolchains.html");
		}
		return toolChain;
	}

	EquinoxInstallation createGMFGenerationIntallation() throws MojoExecutionException {
		DependencyResolver platformResolver = dependencyResolverLocator.lookupDependencyResolver(project);
		final List<Dependency> extraDependencies = getExtraDependencies();
		List<ReactorProject> reactorProjects = getReactorProjects();

		final DependencyResolverConfiguration resolverConfiguration = new DependencyResolverConfiguration() {
			@Override
			public OptionalResolutionAction getOptionalResolutionAction() {
				return OptionalResolutionAction.IGNORE;
			}

			@Override
			public List<Dependency> getExtraRequirements() {
				return extraDependencies;
			}
		};

		DependencyArtifacts generateRuntimeArtifacts = platformResolver.resolveDependencies(session, project, null,
				reactorProjects, resolverConfiguration);

		if (generateRuntimeArtifacts == null) {
			throw new MojoExecutionException("Cannot determinate build target platform location -- code not generated");
		}

		work.mkdirs();
		
		EquinoxInstallationDescription generateAppDescr = new DefaultEquinoxInstallationDescription();
		generateAppDescr.setDefaultBundleStartLevel(defaultStartLevel);
		generateAppDescr.addBundlesToExplode(new LinkedList<String>());
		generateAppDescr.addFrameworkExtensions(new LinkedList<File>());
		for (ArtifactDescriptor artifact : generateRuntimeArtifacts.getArtifacts(ArtifactType.TYPE_ECLIPSE_PLUGIN)) {

			ReactorProject otherProject = artifact.getMavenProject();
			if (otherProject != null) {
				if (otherProject.sameProject(project)) {
					generateAppDescr.addBundle(artifact.getKey(), project.getBasedir());
					continue;
				}
				File file = otherProject.getArtifact(artifact.getClassifier());
				if (file != null) {
					generateAppDescr.addBundle(artifact.getKey(), file);
					continue;
				}
			}
			generateAppDescr.addBundle(artifact);
		}

		return installationFactory.createInstallation(generateAppDescr, work);
	}

	private List<Dependency> getExtraDependencies() {
		final List<Dependency> dependencies = new ArrayList<Dependency>();
		if (this.dependencies != null) {
			dependencies.addAll(Arrays.asList(this.dependencies));
		}
		TargetPlatformConfiguration configuration = TychoProjectUtils.getTargetPlatformConfiguration(project);
		dependencies.addAll(configuration.getDependencyResolverConfiguration().getExtraRequirements());
		dependencies.add(newBundleDependency("org.eclipse.osgi"));
		dependencies.add(newBundleDependency(EquinoxInstallationDescription.EQUINOX_LAUNCHER));
		dependencies.add(newBundleDependency("org.eclipse.core.runtime"));
		dependencies.add(newBundleDependency("org.eclipse.gmf.tooling.codegen.launcher"));
		return dependencies;
	}

	protected Dependency newBundleDependency(String bundleId) {
		Dependency ideapp = new Dependency();
		ideapp.setArtifactId(bundleId);
		ideapp.setType(ArtifactType.TYPE_ECLIPSE_PLUGIN);
		return ideapp;
	}

	private List<ReactorProject> getReactorProjects() {
		return DefaultReactorProject.adapt(session);
	}

	private void checkOverlapPath(File containerDir, File overlapDir, String containerName, String overlapDirName) throws MojoExecutionException {
		checkOverlapPath(containerDir, overlapDir.getAbsolutePath(), containerName, overlapDirName);
	}

	private void checkOverlapPath(File containerDir, String overlapDirPath, String containerName, String overlapDirName) throws MojoExecutionException {
		String containerDirPath = containerDir.getAbsolutePath();
		if (containerDirPath.startsWith(overlapDirPath)) {
			throw new MojoExecutionException(containerDir + ":" + containerDir + " cannot be located in:" + overlapDirName +":"+ overlapDirPath);
		}
	}

	public void prepareGeneratePropertyFile(String tempFile) throws MojoExecutionException {
		Properties prop = new Properties();
		OutputStream outputStrem = null;

		try {
			File outputFile = new File(tempFile);
			outputStrem = new FileOutputStream(outputFile);

			// set the properties value
			prop.setProperty(GMFLauncherConstants.PROPERTY_GMFGEN_MODEL, gmfgen);
			prop.setProperty(GMFLauncherConstants.PROPERTY_GENERATE_PROJECT_LOCATION, output);
			prop.setProperty(GMFLauncherConstants.PROPERTY_GMFGEN_PROJECT_LOCATION, project.getBasedir().getAbsolutePath());

			if (relatedProjects != null && relatedProjects.length > 0) {
				StringBuilder sb = new StringBuilder(relatedProjects[0].getAbsolutePath());
				for (int i = 1; i < relatedProjects.length; i++) {
					sb.append(',');
					sb.append(relatedProjects[i].getAbsolutePath());
				}
				prop.setProperty(GMFLauncherConstants.PROPERTY_RELATED_PROJECTS, sb.toString());
			}

			if (formatter.exists()) {
				prop.setProperty(GMFLauncherConstants.PROPERTY_FORMATTER, formatter.getAbsolutePath());
			}

			if (customEmitterBundle != null && !customEmitterBundle.isEmpty()
					&& customEmitter != null && !customEmitter.isEmpty()) {
				prop.setProperty(GMFLauncherConstants.PROPERTY_CUSTOM_EMITTER, customEmitter);
				prop.setProperty(GMFLauncherConstants.PROPERTY_CUSTOM_EMITTER_BUNDLE, customEmitterBundle);
			}

			prop.setProperty(GMFLauncherConstants.PROPERTY_TRACE, new Boolean(getLog().isDebugEnabled()).toString());

			prop.store(outputStrem, null);

		} catch (FileNotFoundException e) {
			throw new MojoExecutionException(e.getMessage());
		} catch (IOException e) {
			throw new MojoExecutionException(e.getMessage());
		} finally {
			if (outputStrem != null) {
				try {
					outputStrem.close();
				} catch (IOException e) {
					throw new MojoExecutionException(e.getMessage());
				}
			}

		}
	}
}