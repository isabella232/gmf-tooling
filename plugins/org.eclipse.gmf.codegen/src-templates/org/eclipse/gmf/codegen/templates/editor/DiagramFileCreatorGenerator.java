package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.ImportUtil;

public class DiagramFileCreatorGenerator
{
  protected static String nl;
  public static synchronized DiagramFileCreatorGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramFileCreatorGenerator result = new DiagramFileCreatorGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.util.IDEEditorFileCreator;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;";
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_4 = " extends IDEEditorFileCreator {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ";
  protected final String TEXT_5 = " INSTANCE = new ";
  protected final String TEXT_6 = "();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static DiagramFileCreator getInstance() {" + NL + "\t\treturn INSTANCE;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getExtension() {" + NL + "\t\treturn \".";
  protected final String TEXT_7 = "\"; //$NON-NLS-1$" + NL + "\t}" + NL + "\t";
  protected final String TEXT_8 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getUniqueFileName(";
  protected final String TEXT_9 = " containerPath, String fileName) {" + NL + "\t\tint nFileNumber = 1;" + NL + "\t\tfileName = removeExtensionFromFileName(fileName);" + NL + "\t\tString newFileName = fileName;" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_10 = " diagramFilePath = containerPath.append(appendExtensionToFileName(newFileName));" + NL + "\t\t";
  protected final String TEXT_11 = " modelFilePath = containerPath.append(appendExtensionToModelFileName(newFileName));" + NL + "\t\t";
  protected final String TEXT_12 = " workspaceRoot = ";
  protected final String TEXT_13 = ".getWorkspace().getRoot();" + NL + "\t\t" + NL + "\t\twhile (workspaceRoot.exists(diagramFilePath) || workspaceRoot.exists(modelFilePath)) {" + NL + "\t\t\tnFileNumber++;" + NL + "\t\t\tnewFileName = fileName + nFileNumber;" + NL + "\t\t\tdiagramFilePath = containerPath.append(appendExtensionToFileName(newFileName));" + NL + "\t\t\tmodelFilePath = containerPath.append(appendExtensionToModelFileName(newFileName));" + NL + "\t\t}" + NL + "\t\treturn newFileName;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String removeExtensionFromFileName(String fileName) {" + NL + "\t\tif (fileName.endsWith(getExtension())) {" + NL + "\t\t\treturn fileName.substring(0, fileName.length() - getExtension().length());" + NL + "\t\t}" + NL + "\t\treturn fileName;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String appendExtensionToModelFileName(String fileName) {" + NL + "\t\treturn fileName + \".";
  protected final String TEXT_14 = "\";" + NL + "\t}" + NL + "\t";
  protected final String TEXT_15 = NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    
ImportUtil importManager = new ImportUtil(genDiagram.getEditorPackageName());
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getDiagramFileCreatorClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getDiagramFileCreatorClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getDiagramFileCreatorClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getDiagramFileExtension());
    stringBuffer.append(TEXT_7);
    if (!genDiagram.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IPath"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IPath"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IPath"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IWorkspaceRoot"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.ResourcesPlugin"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getGenPackage().getPrefix().toLowerCase());
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
