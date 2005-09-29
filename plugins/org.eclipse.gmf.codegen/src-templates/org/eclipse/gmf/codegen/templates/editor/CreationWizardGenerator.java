package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;

public class CreationWizardGenerator
{
  protected static String nl;
  public static synchronized CreationWizardGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CreationWizardGenerator result = new CreationWizardGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.wizards.EditorCreationWizard;" + NL + "import org.eclipse.jface.viewers.IStructuredSelection;" + NL + "import org.eclipse.ui.IWorkbench;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class CreationWizard extends EditorCreationWizard {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addPages() {" + NL + "\t\tsuper.addPages();" + NL + "\t\tif (page == null) {" + NL + "\t\t\tpage = new CreationWizardPage(getWorkbench(), getSelection());" + NL + "\t\t}" + NL + "\t\taddPage(page);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void init(IWorkbench workbench, IStructuredSelection selection) {" + NL + "\t\tsuper.init(workbench, selection);" + NL + "\t\tsetWindowTitle(\"New ";
  protected final String TEXT_3 = " Diagram\"); //$NON-NLS-1$" + NL + "\t\tsetDefaultPageImageDescriptor(";
  protected final String TEXT_4 = ".getImageDescriptor(" + NL + "\t\t\t\"icons/full/wizban/New";
  protected final String TEXT_5 = ".gif\")); //$NON-NLS-1$" + NL + "\t\tsetNeedsProgressMonitor(true);" + NL + "\t}" + NL + "}";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    GenModel genModel = genDiagram.getEmfGenModel();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getPluginQualifiedClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
