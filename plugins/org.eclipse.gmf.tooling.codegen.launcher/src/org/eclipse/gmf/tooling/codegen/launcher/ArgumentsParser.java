package org.eclipse.gmf.tooling.codegen.launcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.UnexpectedException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.eclipse.core.runtime.Path;
import org.eclipse.equinox.app.IApplicationContext;


public class ArgumentsParser {

	private String myGMFProjectLocation, myResourceLocation, myGenerateProject, myFormatter, myCustomEmitter, myCustomEmitterBundleName;

	private List<String> myRelatedProjects;

	private boolean myShouldUseConsole;

	public String getGMFGENProjectLocation() {
		return myGMFProjectLocation;
	}

	public String getGMFGENResourceLocation() {
		return myResourceLocation;
	}

	public String getGenerateProjectLocation() {
		return myGenerateProject;
	}

	public List<String> getRelatedProjects() {
		return myRelatedProjects;
	}

	public String getFormatter() {
		return myFormatter;
	}

	public boolean shouldTrace() {
		return myShouldUseConsole;
	}

	public String getCustomEmitterClassName() {
		return myCustomEmitter;
	}

	public String getCustomEmitterBundleName() {
		return myCustomEmitterBundleName;
	}

	public ArgumentsParser(IApplicationContext context) throws UnexpectedException {
		parsArguments(context);
	}

	private void parsArguments(IApplicationContext context) throws UnexpectedException {
		String[] args = (String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS);
		if (args != null) {
			List<String> argList = Arrays.asList(args);

			String generationProperties = getPathValueFromArgs(argList, GMFLauncherConstants.KEY_GENERATION_PROPERTIES);
			Properties prop = new Properties();
			InputStream input = null;

			try {
				File propertiesFile = new File(generationProperties);
				input = new FileInputStream(propertiesFile);

				prop.load(input);


			} catch (IOException ex) {
				throw new RuntimeException(ex);
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						throw new RuntimeException(e);
					}
				}
			}

			myRelatedProjects = getRelatedProjects(prop);
			myGMFProjectLocation = getRequiredPathValueFromParoperties(prop, GMFLauncherConstants.PROPERTY_GMFGEN_PROJECT_LOCATION);
			myResourceLocation = getRequiredPathValueFromParoperties(prop, GMFLauncherConstants.PROPERTY_GMFGEN_MODEL);
			myGenerateProject = getRequiredPathValueFromParoperties(prop, GMFLauncherConstants.PROPERTY_GENERATE_PROJECT_LOCATION);
			myFormatter = getPathValueFromParoperties(prop, GMFLauncherConstants.PROPERTY_FORMATTER, false);
			myShouldUseConsole = getBooleanValue(prop,GMFLauncherConstants.PROPERTY_TRACE);
			myCustomEmitter = prop.getProperty(GMFLauncherConstants.PROPERTY_CUSTOM_EMITTER, null);
			myCustomEmitterBundleName = prop.getProperty(GMFLauncherConstants.PROPERTY_CUSTOM_EMITTER_BUNDLE, null);
		}
	}

	private String getPathValueFromArgs(List<String> argList, String key) throws UnexpectedException {
		for (Iterator<String> it = argList.iterator(); it.hasNext();) {
			String arg = it.next();
			if (!arg.equals(key)) {
				continue;
			}
			if (!it.hasNext()) {
				throw new UnexpectedException("Value for key:" + key + " is not setted");
			}
			String value = it.next();
			if (isKey(value)) {
				throw new UnexpectedException("Value for key:" + key + " is not setted");
			}
			if (false == new Path(value).isValidPath(value)) {
				throw new UnexpectedException("Value:" + value + " for key:" + key + " is not path");
			}
			return value;
		}
		throw new UnexpectedException("Key " + key + " is not setted");
	}

	private String getRequiredPathValueFromParoperties(Properties props, String key) throws UnexpectedException {
		return getPathValueFromParoperties(props, key, true);
	}

	private String getPathValueFromParoperties(Properties props, String key, boolean required) throws UnexpectedException {
		String value = props.getProperty(key);
		if (value == null || value.isEmpty()) {
			if (required) {
				throw new UnexpectedException("Value:" + value + " for property:" + key + " is not path");
			} else {
				return null;
			}
		}
		if (false == new Path(value).isValidPath(value)) {
			throw new UnexpectedException("Value:" + value + " for property:" + key + " is not path");
		}
		return value;
	}
	
	private List<String> getRelatedProjects(Properties props) throws UnexpectedException {
		String value = props.getProperty(GMFLauncherConstants.PROPERTY_RELATED_PROJECTS);
		if (value == null || value.isEmpty()) {
			return Collections.emptyList();
		}
		String[] relatedProjects = value.split(",");
		return Arrays.asList(relatedProjects);
	}

	private boolean getBooleanValue(Properties props, String key) {
		String value = props.getProperty(key);
		return Boolean.parseBoolean(value);
	}

	private boolean isKey(String value) {
		return value != null && value.startsWith("-");
	}
}
