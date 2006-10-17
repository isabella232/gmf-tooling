package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class LinkLabelEditPartGenerator
{
  protected static String nl;
  public static synchronized LinkLabelEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LinkLabelEditPartGenerator result = new LinkLabelEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.draw2d.ConnectionLocator;" + NL + "import org.eclipse.draw2d.geometry.Point;" + NL + "import org.eclipse.gef.EditPolicy;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends LabelEditPart implements ITextAwareEditPart {";
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_12 = " manager;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_13 = " parser;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_14 = " parserElements;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String defaultText;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic {";
  protected final String TEXT_15 = NL + "\t\tregisterSnapBackPosition(";
  protected final String TEXT_16 = ".getType(";
  protected final String TEXT_17 = ".VISUAL_ID), new Point(";
  protected final String TEXT_18 = ", ";
  protected final String TEXT_19 = "));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_20 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {" + NL + "\t\tsuper.createDefaultEditPolicies();" + NL + "\t\tinstallEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());";
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = NL + "\t\tinstallEditPolicy(\"";
  protected final String TEXT_23 = "\", new ";
  protected final String TEXT_24 = "()); //$NON-NLS-1$";
  protected final String TEXT_25 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getKeyPoint() {" + NL + "\t\treturn ConnectionLocator.";
  protected final String TEXT_26 = ";" + NL + "\t}" + NL;
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelTextHelper(";
  protected final String TEXT_29 = " figure) {" + NL + "\t\tif (figure instanceof ";
  protected final String TEXT_30 = ") {" + NL + "\t\t\treturn ((";
  protected final String TEXT_31 = ") figure).getText();" + NL + "\t\t} else {" + NL + "\t\t\treturn ((";
  protected final String TEXT_32 = ") figure).getText();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setLabelTextHelper(";
  protected final String TEXT_33 = " figure, String text) {" + NL + "\t\tif (figure instanceof ";
  protected final String TEXT_34 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_35 = ") figure).setText(text);" + NL + "\t\t} else {" + NL + "\t\t\t((";
  protected final String TEXT_36 = ") figure).setText(text);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Image getLabelIconHelper(";
  protected final String TEXT_37 = " figure) {" + NL + "\t\tif (figure instanceof ";
  protected final String TEXT_38 = ") {" + NL + "\t\t\treturn ((";
  protected final String TEXT_39 = ") figure).getIcon();" + NL + "\t\t} else {" + NL + "\t\t\treturn ((";
  protected final String TEXT_40 = ") figure).getIcon();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setLabelIconHelper(";
  protected final String TEXT_41 = " figure, Image icon) {" + NL + "\t\tif (figure instanceof ";
  protected final String TEXT_42 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_43 = ") figure).setIcon(icon);" + NL + "\t\t} else {" + NL + "\t\t\t((";
  protected final String TEXT_44 = ") figure).setIcon(icon);" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_45 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void ";
  protected final String TEXT_46 = "(";
  protected final String TEXT_47 = " figure) {" + NL + "\t\tunregisterVisuals();" + NL + "\t\tsetFigure(figure);" + NL + "\t\tdefaultText = getLabelTextHelper(figure);" + NL + "\t\tregisterVisuals();" + NL + "\t\trefreshVisuals();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_48 = " getModelChildren() {" + NL + "\t\treturn ";
  protected final String TEXT_49 = ".EMPTY_LIST;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_50 = " getChildBySemanticHint(String semanticHint) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject getParserElement() {" + NL + "\t\t";
  protected final String TEXT_51 = " element = resolveSemanticElement();" + NL + "\t\treturn element != null ? element : (";
  protected final String TEXT_52 = ") getModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_53 = " getLabelIcon() {";
  protected final String TEXT_54 = NL + "\t\t";
  protected final String TEXT_55 = " descriptor =" + NL + "\t\t\t";
  protected final String TEXT_56 = ".getInstance().getItemImageDescriptor(getParserElement());" + NL + "\t\tif (descriptor == null) {" + NL + "\t\t\tdescriptor = ";
  protected final String TEXT_57 = ".getMissingImageDescriptor();" + NL + "\t\t}" + NL + "\t\treturn descriptor.createImage();";
  protected final String TEXT_58 = NL + "\t\treturn null;";
  protected final String TEXT_59 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelText() {" + NL + "\t\tString text = null;" + NL + "\t\tif (getParser() != null) {" + NL + "\t\t\ttext = getParser().getPrintString(new ";
  protected final String TEXT_60 = "(getParserElement())," + NL + "\t\t\t\tgetParserOptions().intValue());" + NL + "\t\t}" + NL + "\t\tif (text == null || text.length() == 0) {" + NL + "\t\t\ttext = defaultText;" + NL + "\t\t}" + NL + "\t\treturn text;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setLabelText(String text) {" + NL + "\t\tsetLabelTextHelper(getFigure(), text);" + NL + "\t\tObject pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);" + NL + "\t\tif (pdEditPolicy instanceof ";
  protected final String TEXT_61 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_62 = ") pdEditPolicy).refreshFeedback();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getEditText() {" + NL + "\t\tif (getParser() == null) {" + NL + "\t\t\treturn \"\"; //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\treturn getParser().getEditString(new ";
  protected final String TEXT_63 = "(getParserElement())," + NL + "\t\t\tgetParserOptions().intValue());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isEditable() {";
  protected final String TEXT_64 = NL + "\t\treturn getEditText() != null;";
  protected final String TEXT_65 = NL + "\t\treturn false;";
  protected final String TEXT_66 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_67 = " getEditTextValidator() {" + NL + "\t\treturn new ";
  protected final String TEXT_68 = "() {" + NL + "" + NL + "\t\t\tpublic String isValid(final Object value) {" + NL + "\t\t\t\tif (value instanceof String) {" + NL + "\t\t\t\t\tfinal ";
  protected final String TEXT_69 = " element = getParserElement();" + NL + "\t\t\t\t\tfinal ";
  protected final String TEXT_70 = " parser = getParser();" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_71 = " valid =" + NL + "\t\t\t\t\t\t\t(";
  protected final String TEXT_72 = ") getEditingDomain().runExclusive(" + NL + "\t\t\t\t\t\t\t\tnew ";
  protected final String TEXT_73 = ".Impl() {" + NL + "" + NL + "\t\t\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t\t\tsetResult(parser.isValidEditString(" + NL + "\t\t\t\t\t\t\t\t\tnew ";
  protected final String TEXT_74 = "(element), (String) value));" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t});" + NL + "\t\t\t\t\t\treturn valid.getCode() == ";
  protected final String TEXT_75 = ".EDITABLE ?" + NL + "\t\t\t\t\t\t\tnull : valid.getMessage();" + NL + "\t\t\t\t\t} catch (InterruptedException ie) {" + NL + "\t\t\t\t\t\tie.printStackTrace();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\t// shouldn't get here" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_76 = " getCompletionProcessor() {" + NL + "\t\tif (getParser() == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn getParser().getCompletionProcessor(new ";
  protected final String TEXT_77 = "(getParserElement()));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_78 = " getParserOptions() {" + NL + "\t\treturn ";
  protected final String TEXT_79 = ".NONE;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_80 = " getParser() {" + NL + "\t\tif (parser == null) {" + NL + "\t\t\tString parserHint =";
  protected final String TEXT_81 = NL + "\t\t\t\t";
  protected final String TEXT_82 = ".DESCRIPTION;";
  protected final String TEXT_83 = NL + "\t\t\t\t((";
  protected final String TEXT_84 = ") getModel()).getType();";
  protected final String TEXT_85 = NL + "\t\t\t";
  protected final String TEXT_86 = " hintAdapter =" + NL + "\t\t\t\tnew ";
  protected final String TEXT_87 = "(getParserElement(), parserHint) {" + NL + "" + NL + "\t\t\t\tpublic Object getAdapter(Class adapter) {" + NL + "\t\t\t\t\tif (";
  protected final String TEXT_88 = ".class.equals(adapter)) {" + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = ";" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn super.getAdapter(adapter);" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tparser = ";
  protected final String TEXT_91 = ".getInstance().getParser(hintAdapter);" + NL + "\t\t}" + NL + "\t\treturn parser;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_92 = " getManager() {" + NL + "\t\tif (manager == null) {" + NL + "\t\t\tsetManager(new ";
  protected final String TEXT_93 = "(this," + NL + "\t\t\t\t";
  protected final String TEXT_94 = ".getTextCellEditorClass(this)," + NL + "\t\t\t\t";
  protected final String TEXT_95 = ".getTextCellEditorLocator(this)));" + NL + "\t\t}" + NL + "\t\treturn manager;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setManager(";
  protected final String TEXT_96 = " manager) {" + NL + "\t\tthis.manager = manager;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performDirectEdit() {" + NL + "\t\tgetManager().show();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performDirectEdit(";
  protected final String TEXT_97 = " eventLocation) {" + NL + "\t\tif (getManager().getClass() == ";
  protected final String TEXT_98 = ".class) {" + NL + "\t\t\t((";
  protected final String TEXT_99 = ") getManager()).show(eventLocation.getSWTPoint());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void performDirectEdit(char initialCharacter) {" + NL + "\t\tif (getManager() instanceof ";
  protected final String TEXT_100 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_101 = ") getManager()).show(initialCharacter);" + NL + "\t\t} else {" + NL + "\t\t\tperformDirectEdit();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performDirectEditRequest(";
  protected final String TEXT_102 = " request) {" + NL + "\t\tfinal ";
  protected final String TEXT_103 = " theRequest = request;" + NL + "\t\ttry {" + NL + "\t\t\tgetEditingDomain().runExclusive(new Runnable() {" + NL + "" + NL + "\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\tif (isActive() && isEditable()) {" + NL + "\t\t\t\t\t\tif (theRequest.getExtendedData().get(";
  protected final String TEXT_104 = ".REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {" + NL + "\t\t\t\t\t\t\tCharacter initialChar = (Character) theRequest.getExtendedData().get(";
  protected final String TEXT_105 = ".REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);" + NL + "\t\t\t\t\t\t\tperformDirectEdit(initialChar.charValue());" + NL + "\t\t\t\t\t\t} else if ((theRequest instanceof ";
  protected final String TEXT_106 = ") && (getEditText().equals(getLabelText()))) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_107 = " editRequest =" + NL + "\t\t\t\t\t\t\t\t(";
  protected final String TEXT_108 = ") theRequest;" + NL + "\t\t\t\t\t\t\tperformDirectEdit(editRequest.getLocation());" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tperformDirectEdit();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t} catch (InterruptedException e) {" + NL + "\t\t\te.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshLabel();" + NL + "\t\trefreshFont();" + NL + "\t\trefreshFontColor();" + NL + "\t\trefreshUnderline();" + NL + "\t\trefreshStrikeThrough();";
  protected final String TEXT_109 = NL + "\t\trefreshBounds();";
  protected final String TEXT_110 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshLabel() {" + NL + "\t\tsetLabelTextHelper(getFigure(), getLabelText());" + NL + "\t\tsetLabelIconHelper(getFigure(), getLabelIcon());" + NL + "\t\tObject pdEditPolicy = getEditPolicy(";
  protected final String TEXT_111 = ".PRIMARY_DRAG_ROLE);" + NL + "\t\tif (pdEditPolicy instanceof ";
  protected final String TEXT_112 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_113 = ") pdEditPolicy).refreshFeedback();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshUnderline() {" + NL + "\t\t";
  protected final String TEXT_114 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_115 = ") getFontStyleOwnerView().getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_116 = ".eINSTANCE.getFontStyle());" + NL + "\t\tif (style != null && getFigure() instanceof ";
  protected final String TEXT_117 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_118 = ") getFigure()).setTextUnderline(style.isUnderline());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshStrikeThrough() {" + NL + "\t\t";
  protected final String TEXT_119 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_120 = ") getFontStyleOwnerView().getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_121 = ".eINSTANCE.getFontStyle());" + NL + "\t\tif (style != null && getFigure() instanceof ";
  protected final String TEXT_122 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_123 = ") getFigure()).setTextStrikeThrough(style.isStrikeThrough());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFont() {" + NL + "\t\t";
  protected final String TEXT_124 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_125 = ") getFontStyleOwnerView().getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_126 = ".eINSTANCE.getFontStyle());" + NL + "\t\tif (style != null) {" + NL + "\t\t\t";
  protected final String TEXT_127 = " fontData = new ";
  protected final String TEXT_128 = "(" + NL + "\t\t\t\tstyle.getFontName(), style.getFontHeight()," + NL + "\t\t\t\t(style.isBold() ? ";
  protected final String TEXT_129 = ".BOLD : ";
  protected final String TEXT_130 = ".NORMAL) |" + NL + "\t\t\t\t(style.isItalic() ? ";
  protected final String TEXT_131 = ".ITALIC : ";
  protected final String TEXT_132 = ".NORMAL));" + NL + "\t\t\tsetFont(fontData);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setFontColor(";
  protected final String TEXT_133 = " color) {" + NL + "\t\tgetFigure().setForegroundColor(color);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addSemanticListeners() {" + NL + "\t\tif (getParser() instanceof ";
  protected final String TEXT_134 = ") {" + NL + "\t\t\t";
  protected final String TEXT_135 = " element = resolveSemanticElement();" + NL + "\t\t\tparserElements = ((";
  protected final String TEXT_136 = ") getParser()).getSemanticElementsBeingParsed(element);" + NL + "\t\t\tfor (int i = 0; i < parserElements.size(); i++) {" + NL + "\t\t\t\taddListenerFilter(\"SemanticModel\" + i, this, (";
  protected final String TEXT_137 = ") parserElements.get(i)); //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tsuper.addSemanticListeners();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void removeSemanticListeners() {" + NL + "\t\tif (parserElements != null) {" + NL + "\t\t\tfor (int i = 0; i < parserElements.size(); i++) {" + NL + "\t\t\t\tremoveListenerFilter(\"SemanticModel\" + i); //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t} else {" + NL + "\t\t\tsuper.removeSemanticListeners();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_138 = " getAccessibleEditPart() {" + NL + "\t\tif (accessibleEP == null) {" + NL + "\t\t\taccessibleEP = new AccessibleGraphicalEditPart() {" + NL + "" + NL + "\t\t\t\tpublic void getName(";
  protected final String TEXT_139 = " e) {" + NL + "\t\t\t\t\te.result = getLabelTextHelper(getFigure());" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "\t\treturn accessibleEP;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_140 = " getFontStyleOwnerView() {";
  protected final String TEXT_141 = NL + "\t\treturn (";
  protected final String TEXT_142 = ")getModel();";
  protected final String TEXT_143 = NL + "\t\treturn getPrimaryView();";
  protected final String TEXT_144 = NL + "\t }" + NL + "\t" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void handleNotificationEvent(";
  protected final String TEXT_145 = " event) {" + NL + "\t\tObject feature = event.getFeature();";
  protected final String TEXT_146 = NL;
  protected final String TEXT_147 = "\t\tif (";
  protected final String TEXT_148 = ".eINSTANCE.getFontStyle_FontColor().equals(feature)) {" + NL + "\t\t\tInteger c = (Integer) event.getNewValue();" + NL + "\t\t\tsetFontColor(";
  protected final String TEXT_149 = ".getInstance().getColor(c));" + NL + "\t\t} else if (";
  protected final String TEXT_150 = ".eINSTANCE.getFontStyle_Underline().equals(feature)) {" + NL + "\t\t\trefreshUnderline();" + NL + "\t\t} else if (";
  protected final String TEXT_151 = ".eINSTANCE.getFontStyle_StrikeThrough().equals(feature)) {" + NL + "\t\t\trefreshStrikeThrough();" + NL + "\t\t} else if (";
  protected final String TEXT_152 = ".eINSTANCE.getFontStyle_FontHeight().equals(feature) ||" + NL + "\t\t\t\t";
  protected final String TEXT_153 = ".eINSTANCE.getFontStyle_FontName().equals(feature) ||" + NL + "\t\t\t\t";
  protected final String TEXT_154 = ".eINSTANCE.getFontStyle_Bold().equals(feature) ||" + NL + "\t\t\t\t";
  protected final String TEXT_155 = ".eINSTANCE.getFontStyle_Italic().equals(feature)) {" + NL + "\t\t\trefreshFont();" + NL + "\t\t} else {" + NL + "\t\t\tif (getParser() != null && getParser().isAffectingEvent(event, getParserOptions().intValue())) {" + NL + "\t\t\t\trefreshLabel();" + NL + "\t\t\t}" + NL + "\t\t\tif (getParser() instanceof ISemanticParser) {" + NL + "\t\t\t\t";
  protected final String TEXT_156 = " modelParser =" + NL + "\t\t\t\t\t(";
  protected final String TEXT_157 = ") getParser();" + NL + "\t\t\t\tif (modelParser.areSemanticElementsAffected(null, event)) {" + NL + "\t\t\t\t\tremoveSemanticListeners();" + NL + "\t\t\t\t\tif (resolveSemanticElement() != null) {" + NL + "\t\t\t\t\t\taddSemanticListeners();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\trefreshLabel();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsuper.handleNotificationEvent(event);" + NL + "\t}";
  protected final String TEXT_158 = NL;
  protected final String TEXT_159 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_160 = " createFigure() {" + NL + "\t\t// Parent should assign one using ";
  protected final String TEXT_161 = " method" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_162 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_163 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_164 = " label = createFigurePrim();" + NL + "\t\tdefaultText = getLabelTextHelper(label);" + NL + "\t\treturn label;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_165 = " createFigurePrim() {";
  protected final String TEXT_166 = NL + "\t\treturn new ";
  protected final String TEXT_167 = "();";
  protected final String TEXT_168 = NL + "\t\treturn ";
  protected final String TEXT_169 = ";";
  protected final String TEXT_170 = NL + "\t\treturn new ";
  protected final String TEXT_171 = "();";
  protected final String TEXT_172 = NL + "\t}" + NL;
  protected final String TEXT_173 = NL;
  protected final String TEXT_174 = NL + "}";
  protected final String TEXT_175 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenLinkLabel genLabel = (GenLinkLabel) ((Object[]) argument)[0];
ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
GenCommonBase genHost = genLabel.getLink();
GenDiagram genDiagram = genLabel.getDiagram();

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
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    {	GenCommonBase genCommonBase = genLabel;
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.IParser"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_14);
    
int labelOffsetX = 0;
int labelOffsetY = 0;
LabelOffsetAttributes labelOffset = (LabelOffsetAttributes) genLabel.getViewmap().find(LabelOffsetAttributes.class);
if (labelOffset != null) {
	labelOffsetX = labelOffset.getX();
	labelOffsetY = labelOffset.getY();
}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName(genLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(labelOffsetX);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(labelOffsetY);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_20);
    {	GenCommonBase genCommonBase = genLabel;
    stringBuffer.append(TEXT_21);
    
for (CustomBehaviour behaviour : genCommonBase.getBehaviour(CustomBehaviour.class)) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(behaviour.getKey());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName(behaviour.getEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_24);
    }
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genLabel.getAlignment());
    stringBuffer.append(TEXT_26);
    
final boolean needsRefreshBounds = false;
final boolean readOnly = genLabel.getModelFacet() != null && genLabel.getModelFacet().isReadOnly();
final boolean useElementIcon = genLabel.isElementIcon();
final boolean designLabel = genLabel.getModelFacet() instanceof DesignLabelModelFacet;

    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_44);
    
String labelSetterName = "setLabel"; // same assumption in NodeEditPart
String labelFigureClassName = "org.eclipse.draw2d.IFigure";
if (genLabel.getViewmap() instanceof ParentAssignedViewmap) {
	ParentAssignedViewmap viewmap = (ParentAssignedViewmap) genLabel.getViewmap();
	if (viewmap.getSetterName() != null) {
		labelSetterName = viewmap.getSetterName();
	}
	if (viewmap.getFigureQualifiedClassName() != null) {
		labelFigureClassName = viewmap.getFigureQualifiedClassName();
	}
} // FIXME perhaps, there's no sense to have setLabel for any other viewmap than ParentAssigned?

    stringBuffer.append(TEXT_45);
    stringBuffer.append(labelSetterName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName(labelFigureClassName));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_53);
    if (useElementIcon) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_57);
    } else {
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName(genDiagram.getTextSelectionEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName(genDiagram.getTextSelectionEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_63);
    if (!readOnly) {
    stringBuffer.append(TEXT_64);
    } else {
    stringBuffer.append(TEXT_65);
    }
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.ICellEditorValidator"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.ICellEditorValidator"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.IParser"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.RunnableWithResult"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.text.contentassist.IContentAssistProcessor"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.IParser"));
    stringBuffer.append(TEXT_80);
    if (designLabel) {
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.CommonParserHint"));
    stringBuffer.append(TEXT_82);
    } else {
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_84);
    }
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(genHost.getUniqueIdentifier());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.parser.ParserService"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_108);
    if (needsRefreshBounds) {
    stringBuffer.append(TEXT_109);
    }
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName(genDiagram.getTextSelectionEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName(genDiagram.getTextSelectionEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.AccessibleEditPart"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.accessibility.AccessibleEvent"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_140);
    
boolean fixedFont;
{ //namespace
Viewmap viewmap = genLabel.getViewmap();
StyleAttributes styleAttributes = (viewmap == null) ? null : (StyleAttributes)viewmap.find(StyleAttributes.class);
fixedFont = styleAttributes != null && styleAttributes.isFixedFont();
}
if (fixedFont) {

    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_142);
    
} else {

    stringBuffer.append(TEXT_143);
    
}

    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(TEXT_158);
    if (genLabel.getViewmap() instanceof ParentAssignedViewmap) {
	final ParentAssignedViewmap viewmap = (ParentAssignedViewmap) genLabel.getViewmap();
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append((viewmap.getSetterName() == null ? "setLabel" : viewmap.getSetterName()));
    stringBuffer.append(TEXT_161);
    } else { 
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_165);
    
String figureQualifiedClassName = null;
Viewmap viewmap = genLabel.getViewmap();
if (viewmap instanceof FigureViewmap) {
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.draw2d.Label";
	}

    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_167);
    } // instanceof FigureViewmap
 else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_168);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_169);
    } // instanceof SnippetViewmap; FIXME : obtain figure class name to generate getter
 else if (viewmap instanceof InnerClassViewmap) {
 	figureQualifiedClassName = ((InnerClassViewmap) viewmap).getClassName();

    stringBuffer.append(TEXT_170);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_171);
    }
    stringBuffer.append(TEXT_172);
    if (genLabel.getViewmap() instanceof InnerClassViewmap) {
    stringBuffer.append(TEXT_173);
    stringBuffer.append(((InnerClassViewmap) genLabel.getViewmap()).getClassBody());
    } /* if inner */
} /*else if !ParentAssignedViewmap */ 
    stringBuffer.append(TEXT_174);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_175);
    return stringBuffer.toString();
  }
}
