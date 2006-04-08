package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;

public class EditPartProviderGenerator
{
  protected static String nl;
  public static synchronized EditPartProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    EditPartProviderGenerator result = new EditPartProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL + "" + NL + "import java.lang.ref.WeakReference;" + NL + "" + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gef.EditPartFactory;" + NL + "import org.eclipse.gmf.runtime.common.core.service.IOperation;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import ";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ";" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends AbstractEditPartProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EditPartFactory factory;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean allowCaching;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate WeakReference cachedPart;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate WeakReference cachedView;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_9 = "() {" + NL + "\t\tsetFactory(new ";
  protected final String TEXT_10 = "());" + NL + "\t\tsetAllowCaching(true);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic final EditPartFactory getFactory() {" + NL + "\t\treturn factory;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setFactory(EditPartFactory factory) {" + NL + "\t\tthis.factory = factory;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic final boolean isAllowCaching() {" + NL + "\t\treturn allowCaching;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected synchronized void setAllowCaching(boolean allowCaching) {" + NL + "\t\tthis.allowCaching = allowCaching;" + NL + "\t\tif (!allowCaching) {" + NL + "\t\t\tcachedPart = null;" + NL + "\t\t\tcachedView = null;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IGraphicalEditPart createEditPart(View view) {" + NL + "\t\tEditPart part = factory.createEditPart(null, view);" + NL + "\t\tif (part instanceof IGraphicalEditPart) {" + NL + "\t\t\treturn (IGraphicalEditPart) part;" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IGraphicalEditPart getCachedPart(View view) {" + NL + "\t\tif (cachedView != null && cachedView.get() == view) {" + NL + "\t\t\treturn (IGraphicalEditPart) cachedPart.get();" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic synchronized IGraphicalEditPart createGraphicEditPart(View view) {" + NL + "\t\tif (isAllowCaching()) {" + NL + "\t\t\tIGraphicalEditPart part = getCachedPart(view);" + NL + "\t\t\tcachedPart = null;" + NL + "\t\t\tcachedView = null;" + NL + "\t\t\tif (part != null) {" + NL + "\t\t\t\treturn part;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn createEditPart(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic synchronized boolean provides(IOperation operation) {" + NL + "\t\tif (operation instanceof CreateGraphicEditPartOperation) {" + NL + "\t\t\tView view = ((CreateGraphicEditPartOperation) operation).getView();" + NL + "\t\t\tif (isAllowCaching() && getCachedPart(view) != null) {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t\tIGraphicalEditPart part = createEditPart(view);" + NL + "\t\t\tif (part != null) {" + NL + "\t\t\t\tif (isAllowCaching()) {" + NL + "\t\t\t\t\tcachedPart = new WeakReference(part);" + NL + "\t\t\t\t\tcachedView = new WeakReference(view);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "}";
  protected final String TEXT_11 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getEditPartFactoryClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getEditPartProviderClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getEditPartProviderClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genDiagram.getEditPartFactoryClassName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
