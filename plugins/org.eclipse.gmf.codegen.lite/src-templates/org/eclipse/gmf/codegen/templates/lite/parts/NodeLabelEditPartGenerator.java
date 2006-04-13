package org.eclipse.gmf.codegen.templates.lite.parts;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.ecore.*;

public class NodeLabelEditPartGenerator
{
  protected static String nl;
  public static synchronized NodeLabelEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NodeLabelEditPartGenerator result = new NodeLabelEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_10 = " manager;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String defaultText;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_11 = "(View view) {" + NL + "\t\tsetModel(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = "\t\tinstallEditPolicy(";
  protected final String TEXT_14 = ".DIRECT_EDIT_ROLE," + NL + "\t\t\t\tnew ";
  protected final String TEXT_15 = "() {" + NL + "\t\t\t\t\tprotected void showCurrentEditValue(";
  protected final String TEXT_16 = " request) {" + NL + "\t\t\t\t\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\t\t\t\t\tgetLabel().setText(value);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprotected ";
  protected final String TEXT_17 = " getDirectEditCommand(";
  protected final String TEXT_18 = " request) {" + NL + "\t\t\t\t\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\t\t\t\t\tif (value == null) {" + NL + "\t\t\t\t\t\t\t//Invalid value is transformed into a null by the validator." + NL + "\t\t\t\t\t\t\t//XXX: implement validator" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_19 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tfinal Object[] parseResult;" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tparseResult = new ";
  protected final String TEXT_20 = "(EDIT_PATTERN).parse(value);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_21 = ".INSTANCE;" + NL + "\t\t\t\t\t\t} catch (";
  protected final String TEXT_22 = " e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_23 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\tif (parseResult.length != 1) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_25 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn new ";
  protected final String TEXT_26 = "() {" + NL + "\t\t\t\t\t\t\tprivate ";
  protected final String TEXT_27 = " element = ";
  protected final String TEXT_28 = ";" + NL + "\t\t\t\t\t\t\tprivate ";
  protected final String TEXT_29 = " domainModelCommand = createDomainModelCommand();" + NL + "\t\t\t\t\t\t\tprivate ";
  protected final String TEXT_30 = " createDomainModelCommand() {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_31 = " domainModelEditDomain = ";
  protected final String TEXT_32 = ".getEditingDomainFor(";
  protected final String TEXT_33 = ".getDiagram().getElement());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_34 = " feature = (";
  protected final String TEXT_35 = ") ";
  protected final String TEXT_36 = ".eINSTANCE.get";
  protected final String TEXT_37 = "();" + NL + "\t\t\t\t\t\t\t\tObject valueToSet;" + NL + "\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\tvalueToSet = ";
  protected final String TEXT_38 = ".parseValue(feature, parseResult[0]);" + NL + "\t\t\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\t\t\treturn ";
  protected final String TEXT_39 = ".INSTANCE;" + NL + "\t\t\t\t\t\t\t\t}";
  protected final String TEXT_40 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_41 = " result = new ";
  protected final String TEXT_42 = "();" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_43 = " values = new ";
  protected final String TEXT_44 = "();" + NL + "\t\t\t\t\t\t\t\tvalues.addAll(element.get";
  protected final String TEXT_45 = "());" + NL + "\t\t\t\t\t\t\t\tresult.append(";
  protected final String TEXT_46 = ".create(domainModelEditDomain, element, feature, values));" + NL + "\t\t\t\t\t\t\t\tresult.append(";
  protected final String TEXT_47 = ".create(domainModelEditDomain, element, feature, valueToSet));" + NL + "\t\t\t\t\t\t\t\treturn result;";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\t\t\treturn ";
  protected final String TEXT_49 = ".create(domainModelEditDomain, element, feature, valueToSet);";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_51 = NL + "\t\t\t\t\t\tif (parseResult.length != ";
  protected final String TEXT_52 = ") {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_53 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\treturn new ";
  protected final String TEXT_54 = "() {" + NL + "\t\t\t\t\t\t\tprivate ";
  protected final String TEXT_55 = " element = ";
  protected final String TEXT_56 = ";" + NL + "\t\t\t\t\t\t\tprivate ";
  protected final String TEXT_57 = " domainModelCommand = createDomainModelCommand();" + NL + "\t\t\t\t\t\t\tprivate ";
  protected final String TEXT_58 = " createDomainModelCommand() {" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_59 = " domainModelEditDomain = ";
  protected final String TEXT_60 = ".getEditingDomainFor(";
  protected final String TEXT_61 = ".getDiagram().getElement());" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_62 = " result = new ";
  protected final String TEXT_63 = "();" + NL + "\t\t\t\t\t\t\t\tObject valueToSet;";
  protected final String TEXT_64 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_65 = " ";
  protected final String TEXT_66 = "feature = (";
  protected final String TEXT_67 = ") ";
  protected final String TEXT_68 = ".eINSTANCE.get";
  protected final String TEXT_69 = "();" + NL + "\t\t\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t\t\tvalueToSet = ";
  protected final String TEXT_70 = ".parseValue(feature, parseResult[";
  protected final String TEXT_71 = "]);" + NL + "\t\t\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\t\t\treturn ";
  protected final String TEXT_72 = ".INSTANCE;" + NL + "\t\t\t\t\t\t\t\t}";
  protected final String TEXT_73 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_74 = " ";
  protected final String TEXT_75 = "values = new ";
  protected final String TEXT_76 = "();" + NL + "\t\t\t\t\t\t\t\tvalues.addAll(element.get";
  protected final String TEXT_77 = "());" + NL + "\t\t\t\t\t\t\t\tresult.append(";
  protected final String TEXT_78 = ".create(domainModelEditDomain, element, feature, values));" + NL + "\t\t\t\t\t\t\t\tresult.append(";
  protected final String TEXT_79 = ".create(domainModelEditDomain, element, feature, valueToSet));";
  protected final String TEXT_80 = NL + "\t\t\t\t\t\t\t\tresult.append(";
  protected final String TEXT_81 = ".create(domainModelEditDomain, element, feature, valueToSet));";
  protected final String TEXT_82 = NL + "\t\t\t\t\t\t\t\treturn result;" + NL + "\t\t\t\t\t\t\t}";
  protected final String TEXT_83 = NL + "\t\t\t\t\t\t\tpublic void undo() {" + NL + "\t\t\t\t\t\t\t\tdomainModelCommand.undo();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tpublic void execute() {" + NL + "\t\t\t\t\t\t\t\tdomainModelCommand.execute();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tpublic boolean canUndo() {" + NL + "\t\t\t\t\t\t\t\treturn element != null && domainModelCommand != null && domainModelCommand.canUndo();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tpublic boolean canExecute() {" + NL + "\t\t\t\t\t\t\t\treturn element != null && domainModelCommand != null && domainModelCommand.canExecute();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t};" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t});" + NL + "\t}" + NL;
  protected final String TEXT_84 = NL;
  protected final String TEXT_85 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_86 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_87 = ".REQ_DIRECT_EDIT == req.getType()) {" + NL + "\t\t\tperformDirectEdit();" + NL + "\t\t} else {" + NL + "\t\t\tsuper.performRequest(req);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_88 = " getManager() {" + NL + "\t\tif (manager == null) {" + NL + "\t\t\tmanager = new ";
  protected final String TEXT_89 = "(this, ";
  protected final String TEXT_90 = ".class, new ";
  protected final String TEXT_91 = "() {" + NL + "\t\t\t\tpublic void relocate(";
  protected final String TEXT_92 = " celleditor) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_93 = " rect = getLabel().getTextBounds();" + NL + "\t\t\t\t\tgetLabel().translateToAbsolute(rect);" + NL + "\t\t\t\t\tcelleditor.getControl().setBounds(rect.x, rect.y, rect.width, rect.height);" + NL + "\t\t\t\t}" + NL + "\t\t\t}) {" + NL + "\t\t\t\tprotected void initCellEditor() {" + NL + "\t\t\t\t\tgetCellEditor().setValue(getLabelEditText());" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "\t\treturn manager;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performDirectEdit() {" + NL + "\t\tgetManager().show();" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshLabel();" + NL + "\t\trefreshFont();" + NL + "\t\trefreshFontColor();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshLabel() {" + NL + "\t\tgetLabel().setText(getLabelText());" + NL + "\t\tgetLabel().setIcon(getLabelIcon());" + NL + "\t}" + NL;
  protected final String TEXT_94 = NL;
  protected final String TEXT_95 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final String VIEW_PATTERN = \"";
  protected final String TEXT_96 = "\";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final String EDIT_PATTERN = \"";
  protected final String TEXT_97 = "\";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelText() {" + NL + "\t\t";
  protected final String TEXT_98 = " element = ";
  protected final String TEXT_99 = ";" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn defaultText;" + NL + "\t\t}" + NL + "\t\treturn buildTextByPattern(element, VIEW_PATTERN);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelEditText() {" + NL + "\t\t";
  protected final String TEXT_100 = " element = ";
  protected final String TEXT_101 = ";" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn defaultText;" + NL + "\t\t}" + NL + "\t\treturn buildTextByPattern(element, EDIT_PATTERN);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String buildTextByPattern(";
  protected final String TEXT_102 = " element, String pattern) {";
  protected final String TEXT_103 = NL + "\t\tif (element.get";
  protected final String TEXT_104 = "() == null) {" + NL + "\t\t\treturn defaultText;" + NL + "\t\t}";
  protected final String TEXT_105 = NL + "\t\treturn ";
  protected final String TEXT_106 = ".format(pattern, new Object[] {";
  protected final String TEXT_107 = NL + "\t\t\t";
  protected final String TEXT_108 = NL + "\t\t});";
  protected final String TEXT_109 = NL + "\t\treturn ";
  protected final String TEXT_110 = ".format(pattern, new Object[] {";
  protected final String TEXT_111 = NL + "\t\t";
  protected final String TEXT_112 = ",";
  protected final String TEXT_113 = NL + "\t\t});";
  protected final String TEXT_114 = NL + "\t\t//XXX: unexpected model facet." + NL + "\t\treturn defaultText;";
  protected final String TEXT_115 = NL + "\t}";
  protected final String TEXT_116 = NL;
  protected final String TEXT_117 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFont() {" + NL + "\t\t";
  protected final String TEXT_118 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_119 = ") ";
  protected final String TEXT_120 = ".getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_121 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_122 = " toDispose = createdFont;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tString fontName = style.getFontName();" + NL + "\t\t\tint fontHeight = style.getFontHeight();" + NL + "\t\t\tint fontStyle = ";
  protected final String TEXT_123 = ".NORMAL;" + NL + "\t\t\tif (style.isBold()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_124 = ".BOLD;" + NL + "\t\t\t}" + NL + "\t\t\tif (style.isItalic()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_125 = ".ITALIC;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_126 = " currentFont = getFigure().getFont();" + NL + "\t\t\tif (currentFont != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_127 = " currentFontData = currentFont.getFontData()[0];" + NL + "\t\t\t\tif (currentFontData.getName().equals(fontName) && currentFontData.getHeight() == fontHeight && currentFontData.getStyle() == fontStyle) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFont = new ";
  protected final String TEXT_128 = "(null, fontName, fontHeight, fontStyle);" + NL + "\t\t\tgetFigure().setFont(createdFont);" + NL + "\t\t} else {" + NL + "\t\t\t//revert to the default font" + NL + "\t\t\tgetFigure().setFont(getViewer().getControl().getFont());" + NL + "\t\t\tcreatedFont = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The font (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned)." + NL + "\t * Whenever another non-default font is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_129 = " createdFont;";
  protected final String TEXT_130 = NL;
  protected final String TEXT_131 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFontColor() {" + NL + "\t\t";
  protected final String TEXT_132 = " style = (";
  protected final String TEXT_133 = ")  ";
  protected final String TEXT_134 = ".getStyle(";
  protected final String TEXT_135 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_136 = " toDispose = createdFontColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint fontColor = style.getFontColor();" + NL + "\t\t\tint red = fontColor & 0x000000FF;" + NL + "\t\t\tint green = (fontColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (fontColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_137 = " currentColor = getLabel().getForegroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFontColor = new ";
  protected final String TEXT_138 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setForegroundColor(createdFontColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setForegroundColor(getViewer().getControl().getForeground());" + NL + "\t\t\tcreatedFontColor = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshFontColor()}) currently assigned to the label." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_139 = " createdFontColor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_140 = " getLabelIcon() {" + NL + "\t\t";
  protected final String TEXT_141 = " element = resolveSemanticElement();" + NL + "\t\t";
  protected final String TEXT_142 = " imageDescriptor = ";
  protected final String TEXT_143 = ".getInstance().getItemImageDescriptor(element);" + NL + "\t\tif (imageDescriptor != null) {" + NL + "\t\t\treturn imageDescriptor.createImage();" + NL + "\t\t}" + NL + "\t\treturn ";
  protected final String TEXT_144 = ".getMissingImageDescriptor().createImage();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_145 = " resolveSemanticElement() {" + NL + "\t\tfor(EditPart editPart = this; editPart != null; editPart = editPart.getParent()) {" + NL + "\t\t\tView view = (View)editPart.getModel();" + NL + "\t\t\tif (view != null && view.getElement() != null) {" + NL + "\t\t\t\treturn (";
  protected final String TEXT_146 = ") view.getElement();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_147 = " getUpdatableParent() {" + NL + "\t\tfor(EditPart editPart = getParent(); editPart != null; editPart = editPart.getParent()) {" + NL + "\t\t\tif (editPart instanceof ";
  protected final String TEXT_148 = ") {" + NL + "\t\t\t\treturn (";
  protected final String TEXT_149 = ") editPart;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\t";
  protected final String TEXT_150 = " updatableParent = getUpdatableParent();" + NL + "\t\tif (updatableParent != null) {" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_151 = ".eINSTANCE.getFontStyle_FontColor(), fontColorRefresher);" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_152 = ".eINSTANCE.getFontStyle_FontHeight(), fontRefresher);" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_153 = ".eINSTANCE.getFontStyle_FontName(), fontRefresher);" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_154 = ".eINSTANCE.getFontStyle_Bold(), fontRefresher);" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_155 = ".eINSTANCE.getFontStyle_Italic(), fontRefresher);";
  protected final String TEXT_156 = NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_157 = ".eINSTANCE.get";
  protected final String TEXT_158 = "(), labelRefresher);";
  protected final String TEXT_159 = NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_160 = ".eINSTANCE.get";
  protected final String TEXT_161 = "(), labelRefresher);";
  protected final String TEXT_162 = NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {" + NL + "\t\tsuper.deactivate();" + NL + "\t\t";
  protected final String TEXT_163 = " updatableParent = getUpdatableParent();" + NL + "\t\tif (updatableParent != null) {" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_164 = ".eINSTANCE.getFontStyle_FontColor(), fontColorRefresher);" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_165 = ".eINSTANCE.getFontStyle_FontHeight(), fontRefresher);" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_166 = ".eINSTANCE.getFontStyle_FontName(), fontRefresher);" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_167 = ".eINSTANCE.getFontStyle_Bold(), fontRefresher);" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_168 = ".eINSTANCE.getFontStyle_Italic(), fontRefresher);";
  protected final String TEXT_169 = NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_170 = ".eINSTANCE.get";
  protected final String TEXT_171 = "(), labelRefresher);";
  protected final String TEXT_172 = NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_173 = ".eINSTANCE.get";
  protected final String TEXT_174 = "(), labelRefresher);";
  protected final String TEXT_175 = NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IUpdatableEditPart.Refresher labelRefresher = new IUpdatableEditPart.Refresher() {" + NL + "\t\tpublic void refresh() {" + NL + "\t\t\trefreshLabel();" + NL + "\t\t}" + NL + "\t};" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IUpdatableEditPart.Refresher fontColorRefresher = new IUpdatableEditPart.Refresher() {" + NL + "\t\tpublic void refresh() {" + NL + "\t\t\trefreshFontColor();" + NL + "\t\t}" + NL + "\t};" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IUpdatableEditPart.Refresher fontRefresher = new IUpdatableEditPart.Refresher() {" + NL + "\t\tpublic void refresh() {" + NL + "\t\t\trefreshFont();" + NL + "\t\t}" + NL + "\t};";
  protected final String TEXT_176 = NL;
  protected final String TEXT_177 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_178 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_179 = " label = createLabel();" + NL + "\t\tdefaultText = label.getText();" + NL + "\t\treturn label;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_180 = " createLabel() {";
  protected final String TEXT_181 = NL + "\t\treturn new ";
  protected final String TEXT_182 = "();";
  protected final String TEXT_183 = NL + "\t\treturn ";
  protected final String TEXT_184 = ";";
  protected final String TEXT_185 = NL + "\t\treturn new ";
  protected final String TEXT_186 = "();";
  protected final String TEXT_187 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_188 = " getLabel() {" + NL + "\t\treturn (";
  protected final String TEXT_189 = ") getFigure();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setLabel(";
  protected final String TEXT_190 = " figure) {" + NL + "\t\tunregisterVisuals();" + NL + "\t\tsetFigure(figure);" + NL + "\t\tdefaultText = figure.getText();" + NL + "\t\tregisterVisuals();" + NL + "\t\trefreshVisuals();" + NL + "\t}" + NL;
  protected final String TEXT_191 = NL;
  protected final String TEXT_192 = NL;
  protected final String TEXT_193 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MapModeWorkaround {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int DPtoLP(int dp) {" + NL + "\t\t\treturn dp;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static MapModeWorkaround INSTANCE = new MapModeWorkaround();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MapModeWorkaround getMapMode() {" + NL + "\t\treturn MapModeWorkaround.INSTANCE;" + NL + "\t}";
  protected final String TEXT_194 = NL + "}";
  protected final String TEXT_195 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenNodeLabel genLabel = (GenNodeLabel) ((Object[]) argument)[0];
ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
GenNode genHost = genLabel.getNode();
GenClass underlyingMetaClass = genHost.getDomainMetaClass();
GenDiagram genDiagram = genLabel.getDiagram();
LabelModelFacet labelModelFacet = genLabel.getModelFacet();

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    
importManager.addImport("org.eclipse.gef.EditPart");
importManager.addImport("org.eclipse.gef.EditPolicy");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_5);
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.AbstractGraphicalEditPart"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_11);
    
	final String primaryView = "getUpdatableParent().getDiagramNode()";
	final String resolvedSemanticElement = "resolveSemanticElement()";

    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.DirectEditPolicy"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("java.text.ParseException"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_23);
    
if (labelModelFacet instanceof FeatureLabelModelFacet && !genLabel.isReadOnly()) {
	GenFeature featureToSet = ((FeatureLabelModelFacet)labelModelFacet).getMetaFeature();
	EStructuralFeature ecoreFeature = featureToSet.getEcoreFeature();

    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.EditingDomain"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName(featureToSet.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(featureToSet.getFeatureAccessorName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName(genDiagram.getAbstractParserQualifiedClassName()));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_39);
    
	if (ecoreFeature.isMany()) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.EList"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(featureToSet.getAccessorName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_47);
    
	} else {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_49);
    
	}

    stringBuffer.append(TEXT_50);
    
} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
	CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;
	List metaFeatures = compositeFeatureLabelModelFacet.getMetaFeatures();

    stringBuffer.append(TEXT_51);
    stringBuffer.append(metaFeatures.size());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.EditingDomain"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_63);
    
	boolean haveDeclaredValues = false;
	for(int i = 0; i < metaFeatures.size(); i++) {
		GenFeature nextFeatureToSet = (GenFeature) metaFeatures.get(i);
		EStructuralFeature nextEcoreFeature = nextFeatureToSet.getEcoreFeature();

    stringBuffer.append(TEXT_64);
    if (i == 0) {
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_65);
    }
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName(nextFeatureToSet.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(nextFeatureToSet.getFeatureAccessorName());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName(genDiagram.getAbstractParserQualifiedClassName()));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_72);
    
		if (nextEcoreFeature.isMany()) {

    stringBuffer.append(TEXT_73);
    if (!haveDeclaredValues) { haveDeclaredValues = true;
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.EList"));
    stringBuffer.append(TEXT_74);
    }
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(nextFeatureToSet.getAccessorName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_79);
    
		} else {

    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_81);
    
		}

    
	}

    stringBuffer.append(TEXT_82);
    
}

    stringBuffer.append(TEXT_83);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.TextCellEditor"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.CellEditorLocator"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.CellEditor"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(TEXT_94);
    
/*genFeature.getObjectType() throws NPE on primitive types. This is a workaround. */
HashMap primitiveTypeToWrapperClassName = new HashMap();
primitiveTypeToWrapperClassName.put(Boolean.TYPE, "Boolean");
primitiveTypeToWrapperClassName.put(Byte.TYPE, "Byte");
primitiveTypeToWrapperClassName.put(Character.TYPE, "Character");
primitiveTypeToWrapperClassName.put(Double.TYPE, "Double");
primitiveTypeToWrapperClassName.put(Float.TYPE, "Float");
primitiveTypeToWrapperClassName.put(Integer.TYPE, "Integer");
primitiveTypeToWrapperClassName.put(Long.TYPE, "Long");
primitiveTypeToWrapperClassName.put(Short.TYPE, "Short");
String viewPattern = null;
String editPattern = null;
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	FeatureLabelModelFacet featureLabelModelFacet = (FeatureLabelModelFacet) labelModelFacet;
	viewPattern = featureLabelModelFacet.getViewPattern();
	if (viewPattern == null || viewPattern.length() == 0) {
		viewPattern = "{0}";
	}
	editPattern = featureLabelModelFacet.getEditPattern();
	if (editPattern == null || editPattern.length() == 0) {
		editPattern = "{0}";
	}
} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
	CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;
	viewPattern = compositeFeatureLabelModelFacet.getViewPattern();
	if (viewPattern == null || viewPattern.length() == 0) {
		StringBuffer patternBuffer = new StringBuffer();
		for(int i = 0; i < compositeFeatureLabelModelFacet.getMetaFeatures().size(); i++) {
			patternBuffer.append("{").append(i).append("} ");
		}
		viewPattern = patternBuffer.toString().trim();
	}
	editPattern = compositeFeatureLabelModelFacet.getEditPattern();
	if (editPattern == null || editPattern.length() == 0) {
		StringBuffer patternBuffer = new StringBuffer();
		for(int i = 0; i < compositeFeatureLabelModelFacet.getMetaFeatures().size(); i++) {
			patternBuffer.append("{").append(i).append("} ");
		}
		editPattern = patternBuffer.toString().trim();
	}
}

    stringBuffer.append(TEXT_95);
    stringBuffer.append(viewPattern);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(editPattern);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_102);
    
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	FeatureLabelModelFacet featureLabelModelFacet = (FeatureLabelModelFacet) labelModelFacet;
	GenFeature feature = featureLabelModelFacet.getMetaFeature();
	if (!feature.isPrimitiveType()) {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(feature.getCapName());
    stringBuffer.append(TEXT_104);
    
	}

    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_106);
    
		String value = "element.get" + feature.getCapName() + "()";	/*XXX: getTypedKey is not a part of public API!*/
		if (feature.isPrimitiveType()) {
			value = "new " + primitiveTypeToWrapperClassName.get(feature.getTypeGenClassifier().getEcoreClassifier().getInstanceClass()) + "(" + value + ")";
		}

    stringBuffer.append(TEXT_107);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_108);
    
} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
	CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;

    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_110);
    
	for(Iterator it = compositeFeatureLabelModelFacet.getMetaFeatures().iterator(); it.hasNext(); ) {
		GenFeature next = (GenFeature) it.next();
		String value = "element.get" + next.getCapName() + "()";	/*XXX: getTypedKey is not a part of public API!*/
		if (next.isPrimitiveType()) {
			value = "new " + primitiveTypeToWrapperClassName.get(next.getTypeGenClassifier().getEcoreClassifier().getInstanceClass()) + "(" + value + ")";
		}

    stringBuffer.append(TEXT_111);
    stringBuffer.append(value);
    if (it.hasNext()) {
    stringBuffer.append(TEXT_112);
    }
    
	}

    stringBuffer.append(TEXT_113);
    
} else {

    stringBuffer.append(TEXT_114);
    
}

    stringBuffer.append(TEXT_115);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName(genHost.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName(genHost.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName(genHost.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
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
    
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	GenFeature feature = ((FeatureLabelModelFacet)labelModelFacet).getMetaFeature();

    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_158);
    
} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
	CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;
	for(Iterator it = compositeFeatureLabelModelFacet.getMetaFeatures().iterator(); it.hasNext(); ) {
		GenFeature next = (GenFeature) it.next();

    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName(next.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(next.getFeatureAccessorName());
    stringBuffer.append(TEXT_161);
    
	}
}

    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_168);
    
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	GenFeature feature = ((FeatureLabelModelFacet)labelModelFacet).getMetaFeature();

    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_171);
    
} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
	CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;
	for(Iterator it = compositeFeatureLabelModelFacet.getMetaFeatures().iterator(); it.hasNext(); ) {
		GenFeature next = (GenFeature) it.next();

    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName(next.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(next.getFeatureAccessorName());
    stringBuffer.append(TEXT_174);
    
	}
}

    stringBuffer.append(TEXT_175);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_180);
    
String figureQualifiedClassName = null;
Viewmap viewmap = genLabel.getViewmap();
if (viewmap instanceof FigureViewmap) {
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.draw2d.Label";
	}

    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_182);
    } // instanceof FigureViewmap
 else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_183);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_184);
    } // instanceof SnippetViewmap; FIXME : obtain figure class name to generate getter
 else if (viewmap instanceof InnerClassViewmap) {
 	figureQualifiedClassName = ((InnerClassViewmap) viewmap).getClassName();

    stringBuffer.append(TEXT_185);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_186);
    }
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_190);
    
if (genLabel.getViewmap() instanceof InnerClassViewmap) {
	String classBody = ((InnerClassViewmap) genLabel.getViewmap()).getClassBody();

    stringBuffer.append(TEXT_191);
    stringBuffer.append(classBody);
    stringBuffer.append(TEXT_192);
    
if (classBody.indexOf("DPtoLP") != -1) {

    stringBuffer.append(TEXT_193);
    
}

    
}

    stringBuffer.append(TEXT_194);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_195);
    return stringBuffer.toString();
  }
}
