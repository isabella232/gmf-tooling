package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ShortcutsDecoratorProviderGenerator
{
  protected static String nl;
  public static synchronized ShortcutsDecoratorProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ShortcutsDecoratorProviderGenerator result = new ShortcutsDecoratorProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.emf.ecore.EAnnotation;" + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;" + NL + "import org.eclipse.gmf.runtime.common.core.service.IOperation;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.swt.graphics.Image;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends AbstractProvider implements IDecoratorProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String SHORTCUTS_DECORATOR_ID = \"shortcuts\"; //$NON-NLS-1$" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean provides(IOperation operation) {" + NL + "\t\tif (!(operation instanceof CreateDecoratorsOperation)) {" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\tIDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation) operation).getDecoratorTarget();" + NL + "\t\tView view = (View) decoratorTarget.getAdapter(View.class);" + NL + "\t\treturn view != null && ";
  protected final String TEXT_7 = ".MODEL_ID.equals(";
  protected final String TEXT_8 = ".getModelID(view));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void createDecorators(IDecoratorTarget decoratorTarget) {" + NL + "\t\tView view = (View) decoratorTarget.getAdapter(View.class);" + NL + "\t\tif (view != null) {" + NL + "\t\t\tEAnnotation annotation = view.getEAnnotation(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\t\tif (annotation != null) {" + NL + "\t\t\t\tdecoratorTarget.installDecorator(SHORTCUTS_DECORATOR_ID, new ShortcutsDecorator(decoratorTarget));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected class ShortcutsDecorator extends AbstractDecorator {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ShortcutsDecorator(IDecoratorTarget decoratorTarget) {" + NL + "\t\t\tsuper(decoratorTarget);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void activate() {" + NL + "\t\t\trefresh();" + NL + "\t\t\tEditPart editPart = (EditPart) getDecoratorTarget().getAdapter(EditPart.class);" + NL + "\t\t\tImage image = ";
  protected final String TEXT_9 = ".getInstance().getBundledImage(\"icons/shortcut.gif\"); //$NON-NLS-1$" + NL + "\t\t\tif (editPart instanceof ShapeEditPart) {" + NL + "\t\t\t\tsetDecoration(getDecoratorTarget().addShapeDecoration(image, IDecoratorTarget.Direction.SOUTH_WEST, 0, false));" + NL + "\t\t\t} else if (editPart instanceof ConnectionEditPart) {" + NL + "\t\t\t\tsetDecoration(getDecoratorTarget().addConnectionDecoration(image, 50, false));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void refresh() {" + NL + "\t\t\tremoveDecoration();" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getShortcutsDecoratorProviderClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}
