package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class ElementTypesGenerator
{
  protected static String nl;
  public static synchronized ElementTypesGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ElementTypesGenerator result = new ElementTypesGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gmf.runtime.common.core.command.CommandResult;" + NL + "import org.eclipse.gmf.runtime.common.core.command.ICommand;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.edithelpers.MSLEditHelper;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.GetEditContextCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ElementTypes {" + NL;
  protected final String TEXT_5 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_6 = "_EditHelper extends BaseEditHelper {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ICommand getConfigureCommand(ConfigureRequest req) {" + NL + "\t\t\treturn new ConfigureElementCommand(req) {" + NL + "\t\t\t\tprotected CommandResult doExecute(IProgressMonitor progressMonitor) {" + NL + "//\tWrite new object initialization code here. Use getElementToEdit() to get created element." + NL + "\t\t\t\t\treturn newOKCommandResult();" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "\t\t" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final IMetamodelType ";
  protected final String TEXT_7 = " = new MetamodelType(" + NL + "\t\t\"";
  protected final String TEXT_8 = "\",\tnull, null," + NL + "\t\t";
  protected final String TEXT_9 = ".eINSTANCE.get";
  protected final String TEXT_10 = "()," + NL + "\t\tnew ";
  protected final String TEXT_11 = "_EditHelper());";
  protected final String TEXT_12 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void register() {";
  protected final String TEXT_13 = NL + "\t\tElementTypeRegistry.getInstance().register(";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class BaseEditHelper extends MSLEditHelper {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ICommand getEditContextCommand(GetEditContextRequest req) {" + NL + "\t\t\tGetEditContextCommand result = null;" + NL + "\t\t\tIEditCommandRequest editRequest = req.getEditCommandRequest();" + NL + "\t\t\tif (editRequest instanceof CreateElementRequest) {" + NL + "\t\t\t\tresult = new GetEditContextCommand(req);" + NL + "\t\t\t\tEObject container = ((CreateElementRequest) editRequest).getContainer();" + NL + "\t\t\t\tif (container instanceof View) {" + NL + "\t\t\t\t\tcontainer = ((View) container).getElement();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tresult.setEditContext(container);" + NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    
List types = new ArrayList();
GenPackage genPackage = genDiagram.getDomainMetaModel();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());
Iterator entities = AccessUtil.getGenEntities(genDiagram);
while (entities.hasNext()) {
	GenCommonBase entity = (GenCommonBase) entities.next();
	String semanticNodeInterfaceName;
	if (entity instanceof GenDiagram) {
		semanticNodeInterfaceName = genDiagram.getDomainDiagramElement().getName();
	} else if (entity instanceof GenNode) {
		GenNode genNode = (GenNode) entity;
		semanticNodeInterfaceName = genNode.getDomainMetaClass().getName();
	} else if (entity instanceof GenLinkWithClass) {
		GenLinkWithClass genLinkWithClass = (GenLinkWithClass) entity;
		semanticNodeInterfaceName = genLinkWithClass.getDomainMetaClass().getName();
	} else {
		continue;
	}
	types.add(entity.getUniqueIdentifier());

    stringBuffer.append(TEXT_5);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(entity.getUniqueIdentifier());
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    for (int i = 0; i < types.size(); i++) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(types.get(i));
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
