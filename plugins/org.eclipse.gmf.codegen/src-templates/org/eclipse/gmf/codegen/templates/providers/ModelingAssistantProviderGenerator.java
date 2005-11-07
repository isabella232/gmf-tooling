package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class ModelingAssistantProviderGenerator
{
  protected static String nl;
  public static synchronized ModelingAssistantProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ModelingAssistantProviderGenerator result = new ModelingAssistantProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import java.util.ArrayList;" + NL + "import java.util.Collections;" + NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;" + NL + "import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ModelingAssistantProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List getTypesForPopupBar(IAdaptable host) {" + NL + "\t\tObject editPart = host.getAdapter(IGraphicalEditPart.class);";
  protected final String TEXT_6 = NL + "\t\tif (editPart instanceof ";
  protected final String TEXT_7 = ") {" + NL + "\t\t\tList children = new ArrayList();";
  protected final String TEXT_8 = NL + "\t\t\tchildren.add(ElementTypes.";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\t\t\treturn children;" + NL + "\t\t}";
  protected final String TEXT_11 = NL + "\t\treturn Collections.EMPTY_LIST;" + NL + "\t}" + NL + "}";
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram diagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(diagram.getProvidersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(diagram.getProvidersPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(diagram.getModelingAssistantProviderClassName());
    stringBuffer.append(TEXT_5);
    
Iterator entities = AccessUtil.getGenEntities(diagram);
while (entities.hasNext()) {
	GenCommonBase entity = (GenCommonBase) entities.next();
	List children = Collections.EMPTY_LIST;
	if (entity instanceof GenDiagram) {
		children = diagram.getNodes();
	} else if (entity instanceof GenNode) {
		children = AccessUtil.getAllChildNodes((GenNode) entity);
	}
	if (children.isEmpty()) {
		continue;
	}
	String editPartClassName = importManager.getImportedName(entity.getEditPartQualifiedClassName());

    stringBuffer.append(TEXT_6);
    stringBuffer.append(editPartClassName);
    stringBuffer.append(TEXT_7);
    	for (int i = 0; i < children.size(); i++) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(((GenNode) children.get(i)).getUniqueIdentifier());
    stringBuffer.append(TEXT_9);
    	}
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
