package org.eclipse.gmf.internal.graphdef.codegen;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.gmf.graphdef.codegen.MapModeCodeGenStrategy;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.XpandFacade;
import org.eclipse.gmf.internal.xpand.expression.Variable;
import org.eclipse.gmf.internal.xpand.model.Output;
import org.eclipse.gmf.internal.xpand.model.XpandExecutionContext;
import org.eclipse.gmf.internal.xpand.model.XpandExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.util.BundleResourceManager;
import org.eclipse.gmf.internal.xpand.util.ContextFactory;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {
	private static Activator instance;

	public Activator() {
		instance = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		instance = null;
		super.stop(context);
	}

	public static XpandFacade createTemplateEngine(MapModeCodeGenStrategy strategy, Output output, Collection<Variable> globals) {
		try {
			URL baseURL = instance.getBundle().getEntry("/templates/");
			ArrayList<URL> urls = new ArrayList<URL>(3);
			if (strategy.getToken().length() > 0) {
				urls.add(new URL(baseURL, strategy.getToken() + '/'));
			}
			urls.add(baseURL);
			ResourceManager resourceManager = new BundleResourceManager(urls.toArray(new URL[urls.size()]));
			final XpandExecutionContext xpandContext = ContextFactory.createXpandContext(resourceManager, output, globals);
			((XpandExecutionContextImpl) xpandContext).setContextClassLoader(instance.getClass().getClassLoader());
			return new XpandFacade(xpandContext);
		} catch (MalformedURLException ex) {
			throw new Error();
		}
	}
}
