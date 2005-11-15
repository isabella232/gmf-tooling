package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;

public class CreationWizardPageGenerator
{
  protected static String nl;
  public static synchronized CreationWizardPageGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CreationWizardPageGenerator result = new CreationWizardPageGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.io.InputStream;" + NL + "" + NL + "import org.eclipse.core.resources.IFile;" + NL + "import org.eclipse.core.runtime.IPath;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorWizardPage;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.util.DiagramFileCreator;" + NL + "import org.eclipse.jface.viewers.IStructuredSelection;" + NL + "import org.eclipse.ui.IWorkbench;" + NL + "import org.eclipse.ui.IWorkbenchWindow;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class CreationWizardPage extends EditorWizardPage {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic CreationWizardPage(IWorkbench workbench, IStructuredSelection selection) {" + NL + "\t\tsuper(\"CreationWizardPage\", workbench, selection); //$NON-NLS-1$" + NL + "\t\tsetTitle(\"Create ";
  protected final String TEXT_3 = " Diagram\"); //$NON-NLS-1$" + NL + "\t\tsetDescription(\"Create a new ";
  protected final String TEXT_4 = " diagram.\"); //$NON-NLS-1$" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFile createAndOpenDiagram(IPath containerPath, String fileName, InputStream initialContents, String kind, IWorkbenchWindow dWindow, IProgressMonitor progressMonitor, boolean saveDiagram) {" + NL + "\t\treturn DiagramEditorUtil.createAndOpenDiagram(getDiagramFileCreator(), containerPath, fileName, initialContents, kind, dWindow, progressMonitor, isOpenNewlyCreatedDiagramEditor(), saveDiagram);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getDefaultFileName() {" + NL + "\t\treturn \"default\"; //$NON-NLS-1$" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic DiagramFileCreator getDiagramFileCreator() {" + NL + "\t\treturn DiagramFileCreatorBis.getInstance();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getDiagramKind() {" + NL + "\t\treturn \"";
  protected final String TEXT_5 = "\"; //$NON-NLS-1$" + NL + "\t}" + NL + "}";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    GenModel genModel = genDiagram.getEMFGenModel();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
