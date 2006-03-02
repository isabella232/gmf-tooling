package org.eclipse.gmf.graphdef.codegen.standalone.templates;

import java.util.*;
import org.eclipse.gmf.graphdef.codegen.*;

public class ManifestMFGenerator
{
  protected static String nl;
  public static synchronized ManifestMFGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ManifestMFGenerator result = new ManifestMFGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "Manifest-Version: 1.0" + NL + "Bundle-ManifestVersion: 2" + NL + "Bundle-Name: %pluginName" + NL + "Bundle-SymbolicName: ";
  protected final String TEXT_2 = "; singleton:=true" + NL + "Bundle-Version: 1.0.0" + NL + "Bundle-Vendor: %providerName" + NL + "Bundle-Localization: plugin";
  protected final String TEXT_3 = NL + "Export-Package: ";
  protected final String TEXT_4 = NL + "Require-Bundle: ";
  protected final String TEXT_5 = NL + "Eclipse-LazyStart: true";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
final Object[] passedArgs = (Object[]) argument;
final StandaloneGenerator.Config config = (StandaloneGenerator.Config) passedArgs[0];
final String[] requiredBundles = (String[]) passedArgs[1];


class ListComposer {
	public String composeList(Collection strings){
		StringBuffer result = new StringBuffer();
		for (Iterator it = strings.iterator(); it.hasNext();){
			result.append(" "); //do not miss required space here
			result.append(it.next());
			if (it.hasNext()){
				result.append(", " + NL);
			}
		}
		return result.toString();
	}
}

final ListComposer listComposer = new ListComposer();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(config.getPluginID());
    stringBuffer.append(TEXT_2);
    
	HashSet exportedPackages = new HashSet();
	exportedPackages.add(config.getMainPackageName());
	exportedPackages.add(config.getPluginActivatorPackageName());

    stringBuffer.append(TEXT_3);
    stringBuffer.append(listComposer.composeList(exportedPackages));
    
final Set allRequiredBundles = new LinkedHashSet();
allRequiredBundles.add("org.eclipse.gef");
allRequiredBundles.add("org.eclipse.draw2d");
allRequiredBundles.add("org.eclipse.osgi");
allRequiredBundles.add("org.eclipse.core.runtime");
allRequiredBundles.addAll(java.util.Arrays.asList(requiredBundles));
if (config.needsMapMode()) {
	allRequiredBundles.add("org.eclipse.gmf.runtime.draw2d.ui");
}

    stringBuffer.append(TEXT_4);
    stringBuffer.append(listComposer.composeList(allRequiredBundles));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
