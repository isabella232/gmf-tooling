package org.eclipse.gmf.codegen.templates.policies;

import org.eclipse.gmf.codegen.gmfgen.*;

public class NonResizableTextEditPolicyGenerator
{
  protected static String nl;
  public static synchronized NonResizableTextEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NonResizableTextEditPolicyGenerator result = new NonResizableTextEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL + "" + NL + "import java.util.Collections;" + NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.gef.GraphicalEditPart;" + NL + "import org.eclipse.gef.handles.MoveHandle;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;" + NL + "import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class NonResizableTextEditPolicy\textends NonResizableEditPolicyEx {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate WrapLabel getLabel() {" + NL + "\t\treturn (WrapLabel) ((GraphicalEditPart) getHost()).getFigure();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void hideFocus() {" + NL + "\t\tgetLabel().setFocus(false);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void hideSelection() {" + NL + "\t\tgetLabel().setSelected(false);" + NL + "\t\tgetLabel().setFocus(false);" + NL + "\t\tsuper.hideSelection();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void showFocus() {" + NL + "\t\tgetLabel().setFocus(true);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void showPrimarySelection() {" + NL + "\t\tsuper.showPrimarySelection();" + NL + "\t\tgetLabel().setFocus(true);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void showSelection() {" + NL + "\t\tsuper.showSelection();" + NL + "\t\tgetLabel().setSelected(true);" + NL + "\t\tgetLabel().setFocus(false);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List createSelectionHandles() {" + NL + "\t\tMoveHandle moveHandle = new MoveHandle((GraphicalEditPart) getHost());" + NL + "\t\tmoveHandle.setBorder(null);" + NL + "\t\tmoveHandle.setDragTracker(new DragEditPartsTrackerEx(getHost()));" + NL + "\t\treturn Collections.singletonList(moveHandle);" + NL + "\t}" + NL + "}";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
