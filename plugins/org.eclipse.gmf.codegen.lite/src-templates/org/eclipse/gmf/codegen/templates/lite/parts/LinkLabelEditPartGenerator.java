package org.eclipse.gmf.codegen.templates.lite.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.ecore.*;

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
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = "((";
  protected final String TEXT_7 = ")";
  protected final String TEXT_8 = "((";
  protected final String TEXT_9 = ")";
  protected final String TEXT_10 = ")";
  protected final String TEXT_11 = ".eGet(";
  protected final String TEXT_12 = ".eINSTANCE.get";
  protected final String TEXT_13 = "())";
  protected final String TEXT_14 = ")";
  protected final String TEXT_15 = "((";
  protected final String TEXT_16 = ")";
  protected final String TEXT_17 = ")";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = "()";
  protected final String TEXT_20 = NL;
  protected final String TEXT_21 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_22 = " extends ";
  protected final String TEXT_23 = " {";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_30 = " manager;" + NL;
  protected final String TEXT_31 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String defaultText;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_32 = "(View view) {" + NL + "\t\tassert view instanceof Node;" + NL + "\t\tsetModel(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Node getDiagramNode() {" + NL + "\t\treturn (Node)getModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {";
  protected final String TEXT_33 = NL + "\t\tinstallEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE, new ";
  protected final String TEXT_34 = "() {" + NL + "\t\t\tpublic EditPart getHost() {" + NL + "\t\t\t\treturn getUpdatableParent();" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_35 = NL;
  protected final String TEXT_36 = "\t\tinstallEditPolicy(";
  protected final String TEXT_37 = ".DIRECT_EDIT_ROLE," + NL + "\t\t\t\tnew ";
  protected final String TEXT_38 = "() {" + NL + "\t\t\t\t\tprotected void showCurrentEditValue(";
  protected final String TEXT_39 = " request) {" + NL + "\t\t\t\t\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\t\t\t\t\tgetLabel().setText(value);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_40 = NL;
  protected final String TEXT_41 = "\t\t\t\t\tprotected ";
  protected final String TEXT_42 = " getDirectEditCommand(";
  protected final String TEXT_43 = " request) {" + NL + "\t\t\t\t\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\t\t\t\t\tif (value == null) {" + NL + "\t\t\t\t\t\t\t//Invalid value is transformed into a null by the validator." + NL + "\t\t\t\t\t\t\t//XXX: implement validator" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_44 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tfinal Object[] parseResult;" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tparseResult = new ";
  protected final String TEXT_45 = "(";
  protected final String TEXT_46 = ").parse(value);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_47 = ".INSTANCE;" + NL + "\t\t\t\t\t\t} catch (";
  protected final String TEXT_48 = " e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_49 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_50 = " editingDomain = ";
  protected final String TEXT_51 = ".getEditingDomain(";
  protected final String TEXT_52 = ".getDiagram().getElement());";
  protected final String TEXT_53 = NL + "\t\t\t\t\t\tif (parseResult.length != 1) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_54 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_55 = " domainModelCommand = createDomainModelCommand(editingDomain, parseResult[0]);" + NL + "\t\t\t\t\t\treturn new ";
  protected final String TEXT_56 = "(editingDomain, domainModelCommand);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_57 = " createDomainModelCommand(";
  protected final String TEXT_58 = " editingDomain, Object value) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_59 = " element = ";
  protected final String TEXT_60 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_61 = " feature = (";
  protected final String TEXT_62 = ") ";
  protected final String TEXT_63 = ".eINSTANCE.get";
  protected final String TEXT_64 = "();" + NL + "\t\t\t\t\t\tObject valueToSet;" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalueToSet = ";
  protected final String TEXT_65 = ".parseValue(feature, value);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_66 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_67 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_68 = " result = new ";
  protected final String TEXT_69 = "();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_70 = " values = new ";
  protected final String TEXT_71 = "();" + NL + "\t\t\t\t\t\tvalues.addAll(element.get";
  protected final String TEXT_72 = "());" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_73 = ".create(editingDomain, element, feature, values));" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_74 = ".create(editingDomain, element, feature, valueToSet));" + NL + "\t\t\t\t\t\treturn result;";
  protected final String TEXT_75 = NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_76 = ".create(editingDomain, element, feature, valueToSet);";
  protected final String TEXT_77 = NL + "\t\t\t\t\t}";
  protected final String TEXT_78 = NL + "\t\t\t\t\t\tif (parseResult.length != ";
  protected final String TEXT_79 = ") {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_80 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_81 = " domainModelCommand = createDomainModelCommand(editingDomain, parseResult);" + NL + "\t\t\t\t\t\treturn new ";
  protected final String TEXT_82 = "(editingDomain, domainModelCommand);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_83 = " createDomainModelCommand(";
  protected final String TEXT_84 = " editingDomain, Object[] values) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_85 = " element = ";
  protected final String TEXT_86 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_87 = " result = new ";
  protected final String TEXT_88 = "();" + NL + "\t\t\t\t\t\tObject valueToSet;";
  protected final String TEXT_89 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_90 = " ";
  protected final String TEXT_91 = "feature = (";
  protected final String TEXT_92 = ") ";
  protected final String TEXT_93 = ".eINSTANCE.get";
  protected final String TEXT_94 = "();" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalueToSet = ";
  protected final String TEXT_95 = ".parseValue(feature, values[";
  protected final String TEXT_96 = "]);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_97 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_98 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_99 = " ";
  protected final String TEXT_100 = "values = new ";
  protected final String TEXT_101 = "();" + NL + "\t\t\t\t\t\tvalues.addAll(element.get";
  protected final String TEXT_102 = "());" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_103 = ".create(editingDomain, element, feature, values));" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_104 = ".create(editingDomain, element, feature, valueToSet));";
  protected final String TEXT_105 = NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_106 = ".create(editingDomain, element, feature, valueToSet));";
  protected final String TEXT_107 = NL + "\t\t\t\t\t\treturn result;" + NL + "\t\t\t\t\t}";
  protected final String TEXT_108 = NL + "\t\t\t\t});";
  protected final String TEXT_109 = NL + "\t}" + NL;
  protected final String TEXT_110 = NL;
  protected final String TEXT_111 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_112 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_113 = ".REQ_DIRECT_EDIT == req.getType()) {" + NL + "\t\t\tperformDirectEdit();" + NL + "\t\t} else {" + NL + "\t\t\tsuper.performRequest(req);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_114 = " getManager() {" + NL + "\t\tif (manager == null) {" + NL + "\t\t\tmanager = new ";
  protected final String TEXT_115 = "(this, ";
  protected final String TEXT_116 = ".class, new ";
  protected final String TEXT_117 = "() {" + NL + "\t\t\t\tpublic void relocate(";
  protected final String TEXT_118 = " celleditor) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_119 = " rect = getLabel().getTextBounds();" + NL + "\t\t\t\t\tgetLabel().translateToAbsolute(rect);" + NL + "\t\t\t\t\tcelleditor.getControl().setBounds(rect.x, rect.y, rect.width, rect.height);" + NL + "\t\t\t\t}" + NL + "\t\t\t}) {" + NL + "\t\t\t\tprotected void initCellEditor() {" + NL + "\t\t\t\t\tgetCellEditor().setValue(getLabelEditText());" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "\t\treturn manager;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performDirectEdit() {" + NL + "\t\tgetManager().show();" + NL + "\t}" + NL;
  protected final String TEXT_120 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshLabel();" + NL + "\t\trefreshFont();" + NL + "\t\trefreshFontColor();" + NL + "\t\trefreshBounds();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshBounds() {" + NL + "\t\tNode node = getDiagramNode();" + NL + "\t\tassert node.getLayoutConstraint() instanceof Location;" + NL + "\t\tfinal Location location = (Location) node.getLayoutConstraint();" + NL + "\t\t";
  protected final String TEXT_121 = " parent = getUpdatableParent();" + NL + "\t\t";
  protected final String TEXT_122 = " connection = (";
  protected final String TEXT_123 = ") parent.getFigure();";
  protected final String TEXT_124 = NL + "\t\t((";
  protected final String TEXT_125 = ") getParent()).setLayoutConstraint(this," + NL + "\t\t\t\tgetFigure(), new ";
  protected final String TEXT_126 = "(connection, ";
  protected final String TEXT_127 = ".";
  protected final String TEXT_128 = ") {" + NL + "\t\t\t\t\tprotected ";
  protected final String TEXT_129 = " getReferencePoint() {" + NL + "\t\t\t\t\t\treturn super.getReferencePoint().translate(location.getX(), location.getY());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t});" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshLabel() {" + NL + "\t\tgetLabel().setText(getLabelText());" + NL + "\t\tgetLabel().setIcon(getLabelIcon());" + NL + "\t}" + NL;
  protected final String TEXT_130 = NL;
  protected final String TEXT_131 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final String VIEW_PATTERN = \"";
  protected final String TEXT_132 = "\";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String EDIT_PATTERN = \"";
  protected final String TEXT_133 = "\";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelText() {" + NL + "\t\t";
  protected final String TEXT_134 = " element = ";
  protected final String TEXT_135 = ";" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn defaultText;" + NL + "\t\t}" + NL + "\t\treturn buildTextByPattern(element, VIEW_PATTERN);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelEditText() {" + NL + "\t\t";
  protected final String TEXT_136 = " element = ";
  protected final String TEXT_137 = ";" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn defaultText;" + NL + "\t\t}" + NL + "\t\treturn buildTextByPattern(element, EDIT_PATTERN);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String buildTextByPattern(";
  protected final String TEXT_138 = " element, String pattern) {";
  protected final String TEXT_139 = NL + "\t\tif (";
  protected final String TEXT_140 = " == null) {" + NL + "\t\t\treturn defaultText;" + NL + "\t\t}";
  protected final String TEXT_141 = NL + "\t\treturn ";
  protected final String TEXT_142 = ".format(pattern, new Object[] {";
  protected final String TEXT_143 = NL + "\t\t\tnew ";
  protected final String TEXT_144 = "(";
  protected final String TEXT_145 = ")";
  protected final String TEXT_146 = NL + "\t\t});";
  protected final String TEXT_147 = NL + "\t\treturn ";
  protected final String TEXT_148 = ".format(pattern, new Object[] {";
  protected final String TEXT_149 = NL + "\t\t\tnew ";
  protected final String TEXT_150 = "(";
  protected final String TEXT_151 = ")";
  protected final String TEXT_152 = ",";
  protected final String TEXT_153 = NL + "\t\t});";
  protected final String TEXT_154 = NL + "\t\t//XXX: unexpected model facet." + NL + "\t\treturn defaultText;";
  protected final String TEXT_155 = NL + "\t}";
  protected final String TEXT_156 = NL;
  protected final String TEXT_157 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFont() {";
  protected final String TEXT_158 = NL + "\t\t";
  protected final String TEXT_159 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_160 = ") ";
  protected final String TEXT_161 = ".getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_162 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_163 = " toDispose = createdFont;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tString fontName = style.getFontName();" + NL + "\t\t\tint fontHeight = style.getFontHeight();" + NL + "\t\t\tint fontStyle = ";
  protected final String TEXT_164 = ".NORMAL;" + NL + "\t\t\tif (style.isBold()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_165 = ".BOLD;" + NL + "\t\t\t}" + NL + "\t\t\tif (style.isItalic()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_166 = ".ITALIC;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_167 = " currentFont = getFigure().getFont();" + NL + "\t\t\tif (currentFont != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_168 = " currentFontData = currentFont.getFontData()[0];" + NL + "\t\t\t\tif (currentFontData.getName().equals(fontName) && currentFontData.getHeight() == fontHeight && currentFontData.getStyle() == fontStyle) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFont = new ";
  protected final String TEXT_169 = "(null, fontName, fontHeight, fontStyle);" + NL + "\t\t\tgetFigure().setFont(createdFont);" + NL + "\t\t} else {" + NL + "\t\t\t//revert to the default font" + NL + "\t\t\tgetFigure().setFont(getViewer().getControl().getFont());" + NL + "\t\t\tcreatedFont = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}";
  protected final String TEXT_170 = "\t" + NL + "\t}";
  protected final String TEXT_171 = NL + NL + "\t/**" + NL + "\t * The font (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned)." + NL + "\t * Whenever another non-default font is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_172 = " createdFont;";
  protected final String TEXT_173 = "\t";
  protected final String TEXT_174 = NL;
  protected final String TEXT_175 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFontColor() {" + NL + "\t\t";
  protected final String TEXT_176 = " style = (";
  protected final String TEXT_177 = ")  ";
  protected final String TEXT_178 = ".getStyle(";
  protected final String TEXT_179 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_180 = " toDispose = createdFontColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint fontColor = style.getFontColor();" + NL + "\t\t\tint red = fontColor & 0x000000FF;" + NL + "\t\t\tint green = (fontColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (fontColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_181 = " currentColor = getLabel().getForegroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFontColor = new ";
  protected final String TEXT_182 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setForegroundColor(createdFontColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setForegroundColor(getViewer().getControl().getForeground());" + NL + "\t\t\tcreatedFontColor = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshFontColor()}) currently assigned to the label." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_183 = " createdFontColor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_184 = " getLabelIcon() {";
  protected final String TEXT_185 = NL + "\t\t";
  protected final String TEXT_186 = " imageDescriptor = ";
  protected final String TEXT_187 = ".getInstance().getItemImageDescriptor(resolveSemanticElement());" + NL + "\t\tif (imageDescriptor != null) {" + NL + "\t\t\treturn imageDescriptor.createImage();" + NL + "\t\t}";
  protected final String TEXT_188 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_189 = " resolveSemanticElement() {" + NL + "\t\t";
  protected final String TEXT_190 = " parent = getUpdatableParent();" + NL + "\t\tif (parent == null || parent.getModel() instanceof ";
  protected final String TEXT_191 = " == false) {" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_192 = NL + "\t\t";
  protected final String TEXT_193 = " view = (";
  protected final String TEXT_194 = ") parent.getModel();" + NL + "\t\treturn (";
  protected final String TEXT_195 = ") view.getElement();";
  protected final String TEXT_196 = NL + "\t\t";
  protected final String TEXT_197 = " target = ((";
  protected final String TEXT_198 = ") parent.getModel()).getTarget();" + NL + "\t\treturn (target != null && target.getElement() instanceof ";
  protected final String TEXT_199 = ") ? (";
  protected final String TEXT_200 = ") target.getElement() : null;";
  protected final String TEXT_201 = NL + "\t\treturn null;";
  protected final String TEXT_202 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_203 = " getUpdatableParent() {" + NL + "\t\tfor(EditPart editPart = getParent(); editPart != null; editPart = editPart.getParent()) {" + NL + "\t\t\tif (editPart instanceof ";
  protected final String TEXT_204 = ") {" + NL + "\t\t\t\treturn (";
  protected final String TEXT_205 = ") editPart;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\t";
  protected final String TEXT_206 = " updatableParent = getUpdatableParent();" + NL + "\t\tif (updatableParent != null) {" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_207 = ".eINSTANCE.getFontStyle_FontColor(), fontColorRefresher);" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_208 = ".eINSTANCE.getFontStyle_FontHeight(), fontRefresher);" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_209 = ".eINSTANCE.getFontStyle_FontName(), fontRefresher);" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_210 = ".eINSTANCE.getFontStyle_Bold(), fontRefresher);" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_211 = ".eINSTANCE.getFontStyle_Italic(), fontRefresher);";
  protected final String TEXT_212 = NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_213 = ".eINSTANCE.get";
  protected final String TEXT_214 = "(), labelRefresher);";
  protected final String TEXT_215 = NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_216 = ".eINSTANCE.get";
  protected final String TEXT_217 = "(), labelRefresher);";
  protected final String TEXT_218 = NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {" + NL + "\t\tsuper.deactivate();" + NL + "\t\t";
  protected final String TEXT_219 = " updatableParent = getUpdatableParent();" + NL + "\t\tif (updatableParent != null) {" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_220 = ".eINSTANCE.getFontStyle_FontColor(), fontColorRefresher);" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_221 = ".eINSTANCE.getFontStyle_FontHeight(), fontRefresher);" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_222 = ".eINSTANCE.getFontStyle_FontName(), fontRefresher);" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_223 = ".eINSTANCE.getFontStyle_Bold(), fontRefresher);" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_224 = ".eINSTANCE.getFontStyle_Italic(), fontRefresher);";
  protected final String TEXT_225 = NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_226 = ".eINSTANCE.get";
  protected final String TEXT_227 = "(), labelRefresher);";
  protected final String TEXT_228 = NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_229 = ".eINSTANCE.get";
  protected final String TEXT_230 = "(), labelRefresher);";
  protected final String TEXT_231 = NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_232 = ".Refresher labelRefresher = new ";
  protected final String TEXT_233 = ".Refresher() {" + NL + "\t\tpublic void refresh() {" + NL + "\t\t\trefreshLabel();" + NL + "\t\t}" + NL + "\t};" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_234 = ".Refresher fontColorRefresher = new ";
  protected final String TEXT_235 = ".Refresher() {" + NL + "\t\tpublic void refresh() {" + NL + "\t\t\trefreshFontColor();" + NL + "\t\t}" + NL + "\t};" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_236 = ".Refresher fontRefresher = new ";
  protected final String TEXT_237 = ".Refresher() {" + NL + "\t\tpublic void refresh() {" + NL + "\t\t\trefreshFont();" + NL + "\t\t}" + NL + "\t};" + NL;
  protected final String TEXT_238 = NL;
  protected final String TEXT_239 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_240 = " createFigure() {" + NL + "\t\t// Parent should assign one using ";
  protected final String TEXT_241 = " method" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_242 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_243 = " createLabel() {";
  protected final String TEXT_244 = NL + "\t\treturn new ";
  protected final String TEXT_245 = "();";
  protected final String TEXT_246 = NL + "\t\treturn ";
  protected final String TEXT_247 = ";";
  protected final String TEXT_248 = NL + "\t\treturn new ";
  protected final String TEXT_249 = "();";
  protected final String TEXT_250 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_251 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_252 = " label = createLabel();";
  protected final String TEXT_253 = NL + "\t\tdefaultText = label.getText();";
  protected final String TEXT_254 = NL + "\t\tdefaultText = \"\";\t//$NON-NLS-1$";
  protected final String TEXT_255 = NL + "\t\treturn label;" + NL + "\t}";
  protected final String TEXT_256 = NL + NL + "\t/**";
  protected final String TEXT_257 = NL + "\t * TODO: reimplement, since the figure used by this editpart is not a Label.";
  protected final String TEXT_258 = NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_259 = " getLabel() {" + NL + "\t\treturn (";
  protected final String TEXT_260 = ") getFigure();" + NL + "\t}" + NL;
  protected final String TEXT_261 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void ";
  protected final String TEXT_262 = "(";
  protected final String TEXT_263 = " figure) {" + NL + "\t\tunregisterVisuals();" + NL + "\t\tsetFigure(figure);";
  protected final String TEXT_264 = NL + "\t\tdefaultText = figure.getText();";
  protected final String TEXT_265 = NL + "\t\tdefaultText = \"\";\t//$NON-NLS-1$";
  protected final String TEXT_266 = NL + "\t\tregisterVisuals();" + NL + "\t\trefreshVisuals();" + NL + "\t}" + NL;
  protected final String TEXT_267 = NL;
  protected final String TEXT_268 = NL;
  protected final String TEXT_269 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MapModeWorkaround {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int DPtoLP(int dp) {" + NL + "\t\t\treturn dp;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static MapModeWorkaround INSTANCE = new MapModeWorkaround();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MapModeWorkaround getMapMode() {" + NL + "\t\treturn MapModeWorkaround.INSTANCE;" + NL + "\t}";
  protected final String TEXT_270 = NL + "}";
  protected final String TEXT_271 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenCommonBase genElement = (GenCommonBase) ((Object[]) argument)[0];
final GenLinkLabel genLabel = (GenLinkLabel)genElement;
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
GenLink genHost = genLabel.getLink();
GenDiagram genDiagram = genLabel.getDiagram();
LabelModelFacet labelModelFacet = genLabel.getModelFacet();
GenClass underlyingMetaClass;
if (genHost.getModelFacet() instanceof TypeLinkModelFacet) {
	TypeLinkModelFacet typeLinkModelFacet = (TypeLinkModelFacet) genHost.getModelFacet();
	underlyingMetaClass = typeLinkModelFacet.getMetaClass();
} else if (genHost.getModelFacet() instanceof FeatureLinkModelFacet) {
	FeatureLinkModelFacet featureLinkModelFacet = (FeatureLinkModelFacet) genHost.getModelFacet();
	underlyingMetaClass = featureLinkModelFacet.getMetaFeature().getTypeGenClass();
} else {
	underlyingMetaClass = null;
}
final boolean isReadOnly = genLabel.getModelFacet() != null && genLabel.getModelFacet().isReadOnly();

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    
class FeatureGetAccessorHelper {
	/**
	 * @param containerName the name of the container
	 * @param feature the feature whose value is in interest
	 * @param containerMetaClass the <code>GenClass</code> of the container, or <code>null</code>, if the container is declared as an <code>EObject</code>.
	 * @param needsCastToResultType whether the cast to the result type is required (this parameter is only used if the <code>EClass</code> this feature belongs to is an external interface). 
	 */
	public void appendFeatureValueGetter(String containerName, GenFeature feature, GenClass containerMetaClass, boolean needsCastToResultType) {
		if (feature.getGenClass().isExternalInterface()) {
			boolean needsCastToEObject = containerMetaClass != null && containerMetaClass.isExternalInterface();
			if (needsCastToResultType) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(feature.isListType() ? "java.util.Collection" : feature.getTypeGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_7);
    
			}
			if (needsCastToEObject) {

    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_9);
    
			}

    stringBuffer.append(containerName);
    
			if (needsCastToEObject) {

    stringBuffer.append(TEXT_10);
    
			}

    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_13);
    
			if (needsCastToResultType) {

    stringBuffer.append(TEXT_14);
    
			}
		} else {
			boolean needsCastToFeatureGenType = containerMetaClass == null || containerMetaClass.isExternalInterface();
			if (needsCastToFeatureGenType) {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_16);
    
			}

    stringBuffer.append(containerName);
    
			if (needsCastToFeatureGenType) {

    stringBuffer.append(TEXT_17);
    
			}

    stringBuffer.append(TEXT_18);
    stringBuffer.append(feature.getGetAccessor());
    stringBuffer.append(TEXT_19);
    
		}
	}
}
final FeatureGetAccessorHelper myFeatureGetAccessorHelper = new FeatureGetAccessorHelper();

    stringBuffer.append(TEXT_20);
    importManager.emitPackageStatement(stringBuffer);
importManager.addImport("org.eclipse.draw2d.geometry.Point");
importManager.addImport("org.eclipse.gef.EditPart");
importManager.addImport("org.eclipse.gef.EditPolicy");
importManager.addImport("org.eclipse.gmf.runtime.notation.Location");
importManager.addImport("org.eclipse.gmf.runtime.notation.Node");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_21);
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.AbstractGraphicalEditPart"));
    stringBuffer.append(TEXT_23);
    {
GenCommonBase genCommonBase = genLabel;
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    
if (!isReadOnly) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_30);
    
}

    stringBuffer.append(TEXT_31);
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_32);
    
final String primaryView = "getUpdatableParent().getDiagramEdge()";
final String resolvedSemanticElement = "resolveSemanticElement()";

    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy"));
    stringBuffer.append(TEXT_34);
    
if (labelModelFacet instanceof FeatureLabelModelFacet || labelModelFacet instanceof CompositeFeatureLabelModelFacet && !isReadOnly) {
		String editPatternCode = "EDIT_PATTERN";	//declared in labelText.javajetinc, used in directEditCommand.jetinc.

    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.DirectEditPolicy"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(editPatternCode);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("java.text.ParseException"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_52);
    
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	GenFeature featureToSet = ((FeatureLabelModelFacet)labelModelFacet).getMetaFeature();
	EStructuralFeature ecoreFeature = featureToSet.getEcoreFeature();

    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName(featureToSet.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(featureToSet.getFeatureAccessorName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.ParserUtil"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_66);
    
	if (ecoreFeature.isMany()) {

    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.EList"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(featureToSet.getAccessorName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_74);
    
	} else {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_76);
    
	}

    stringBuffer.append(TEXT_77);
    
} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
	CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;
	List metaFeatures = compositeFeatureLabelModelFacet.getMetaFeatures();

    stringBuffer.append(TEXT_78);
    stringBuffer.append(metaFeatures.size());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_88);
    
	boolean haveDeclaredValues = false;
	for(int i = 0; i < metaFeatures.size(); i++) {
		GenFeature nextFeatureToSet = (GenFeature) metaFeatures.get(i);
		EStructuralFeature nextEcoreFeature = nextFeatureToSet.getEcoreFeature();

    stringBuffer.append(TEXT_89);
    if (i == 0) {
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName(nextFeatureToSet.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(nextFeatureToSet.getFeatureAccessorName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.ParserUtil"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_97);
    
		if (nextEcoreFeature.isMany()) {

    stringBuffer.append(TEXT_98);
    if (!haveDeclaredValues) { haveDeclaredValues = true;
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.EList"));
    stringBuffer.append(TEXT_99);
    }
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(nextFeatureToSet.getAccessorName());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_104);
    
		} else {

    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_106);
    
		}

    
	}

    stringBuffer.append(TEXT_107);
    
}

    stringBuffer.append(TEXT_108);
    
}

    stringBuffer.append(TEXT_109);
    
if (labelModelFacet instanceof FeatureLabelModelFacet || labelModelFacet instanceof CompositeFeatureLabelModelFacet && !isReadOnly) {

    stringBuffer.append(TEXT_110);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.TextCellEditor"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.CellEditorLocator"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.CellEditor"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_119);
    
}

    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Connection"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Connection"));
    stringBuffer.append(TEXT_123);
    
	final String alignment;
	LinkLabelAlignment genAlignment = genLabel.getAlignment();
	if (genAlignment == null) {
		alignment = "MIDDLE";
	} else {
		switch (genAlignment.getValue()) {
		case LinkLabelAlignment.MIDDLE:
			alignment = "MIDDLE";
			break;
		case LinkLabelAlignment.TARGET:
			alignment = "TARGET";
			break;
		case LinkLabelAlignment.SOURCE:
			alignment = "SOURCE";
			break;
		default:
			alignment = "MIDDLE";
			break;
		}
	}

    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionLocator"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ConnectionLocator"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(alignment);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(TEXT_130);
    
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

    stringBuffer.append(TEXT_131);
    stringBuffer.append(viewPattern);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(editPattern);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_138);
    
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	FeatureLabelModelFacet featureLabelModelFacet = (FeatureLabelModelFacet) labelModelFacet;
	GenFeature feature = featureLabelModelFacet.getMetaFeature();
	if (!feature.isPrimitiveType()) {

    stringBuffer.append(TEXT_139);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("element", feature, underlyingMetaClass, false);
    stringBuffer.append(TEXT_140);
    
	}

    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_142);
    
		if (feature.isPrimitiveType()) {

    stringBuffer.append(TEXT_143);
    stringBuffer.append(primitiveTypeToWrapperClassName.get(feature.getTypeGenClassifier().getEcoreClassifier().getInstanceClass()));
    stringBuffer.append(TEXT_144);
    
		}
		myFeatureGetAccessorHelper.appendFeatureValueGetter("element", feature, underlyingMetaClass, false);
		if (feature.isPrimitiveType()) {

    stringBuffer.append(TEXT_145);
    
		}

    stringBuffer.append(TEXT_146);
    
} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
	CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;

    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_148);
    
	for(Iterator it = compositeFeatureLabelModelFacet.getMetaFeatures().iterator(); it.hasNext(); ) {
		GenFeature next = (GenFeature) it.next();
		if (next.isPrimitiveType()) {

    stringBuffer.append(TEXT_149);
    stringBuffer.append(primitiveTypeToWrapperClassName.get(next.getTypeGenClassifier().getEcoreClassifier().getInstanceClass()));
    stringBuffer.append(TEXT_150);
    
		}
		myFeatureGetAccessorHelper.appendFeatureValueGetter("element", next, underlyingMetaClass, false);
		if (next.isPrimitiveType()) {

    stringBuffer.append(TEXT_151);
    
		}
		if (it.hasNext()) {
    stringBuffer.append(TEXT_152);
    }
    
	}

    stringBuffer.append(TEXT_153);
    
} else {

    stringBuffer.append(TEXT_154);
    
}

    stringBuffer.append(TEXT_155);
    stringBuffer.append(TEXT_156);
    
boolean isFixedFontSetInFigure;
{
	StyleAttributes styleAttributes = (genElement.getViewmap() == null) ? null : (StyleAttributes)genElement.getViewmap().find(StyleAttributes.class);
	isFixedFontSetInFigure = styleAttributes != null && styleAttributes.isFixedFont();
}

    stringBuffer.append(TEXT_157);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_169);
    
}

    stringBuffer.append(TEXT_170);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_172);
    
}

    stringBuffer.append(TEXT_173);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_184);
    
if (genLabel.isElementIcon()) {

    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_187);
    
}

    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_191);
    
if (genHost.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_195);
    
} else if (genHost.getModelFacet() instanceof FeatureLinkModelFacet) {

    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_200);
    
} else {

    stringBuffer.append(TEXT_201);
    
}

    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_211);
    
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	GenFeature feature = ((FeatureLabelModelFacet)labelModelFacet).getMetaFeature();

    stringBuffer.append(TEXT_212);
    stringBuffer.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_214);
    
} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
	CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;
	for(Iterator it = compositeFeatureLabelModelFacet.getMetaFeatures().iterator(); it.hasNext(); ) {
		GenFeature next = (GenFeature) it.next();

    stringBuffer.append(TEXT_215);
    stringBuffer.append(importManager.getImportedName(next.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(next.getFeatureAccessorName());
    stringBuffer.append(TEXT_217);
    
	}
}

    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_224);
    
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	GenFeature feature = ((FeatureLabelModelFacet)labelModelFacet).getMetaFeature();

    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_227);
    
} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
	CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;
	for(Iterator it = compositeFeatureLabelModelFacet.getMetaFeatures().iterator(); it.hasNext(); ) {
		GenFeature next = (GenFeature) it.next();

    stringBuffer.append(TEXT_228);
    stringBuffer.append(importManager.getImportedName(next.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(next.getFeatureAccessorName());
    stringBuffer.append(TEXT_230);
    
	}
}

    stringBuffer.append(TEXT_231);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_234);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_235);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_237);
    
final Viewmap viewmap = genLabel.getViewmap();

    stringBuffer.append(TEXT_238);
    
final String figureQualifiedClassName;
if (viewmap instanceof ParentAssignedViewmap) {
	ParentAssignedViewmap parentAssignedViewmap = (ParentAssignedViewmap) viewmap;
	figureQualifiedClassName = parentAssignedViewmap.getFigureQualifiedClassName() == null ? "org.eclipse.draw2d.IFigure" : parentAssignedViewmap.getFigureQualifiedClassName();
} else if (viewmap instanceof FigureViewmap) {
	String figureQualifiedClassNameCandidate = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassNameCandidate == null || figureQualifiedClassNameCandidate.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.draw2d.Label";
	} else {
		figureQualifiedClassName = figureQualifiedClassNameCandidate;
	}
} else if (viewmap instanceof SnippetViewmap) {
	figureQualifiedClassName = "org.eclipse.draw2d.IFigure";
} else if (viewmap instanceof InnerClassViewmap) {
	figureQualifiedClassName = ((InnerClassViewmap) viewmap).getClassName();
} else {
	figureQualifiedClassName = "org.eclipse.draw2d.IFigure";
}
final String figureImportedName;
if (viewmap instanceof InnerClassViewmap) {
	figureImportedName = figureQualifiedClassName;	//do not import inner class
} else {
	figureImportedName = importManager.getImportedName(figureQualifiedClassName);
}
if (viewmap instanceof ParentAssignedViewmap) {
	final ParentAssignedViewmap parentAssignedViewmap = (ParentAssignedViewmap) viewmap;

    stringBuffer.append(TEXT_239);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_240);
    stringBuffer.append((parentAssignedViewmap.getSetterName() == null ? "setLabel" : parentAssignedViewmap.getSetterName()));
    stringBuffer.append(TEXT_241);
    } else { 
    stringBuffer.append(TEXT_242);
    stringBuffer.append(figureImportedName);
    stringBuffer.append(TEXT_243);
    
if (viewmap instanceof FigureViewmap) {

    stringBuffer.append(TEXT_244);
    stringBuffer.append(figureImportedName);
    stringBuffer.append(TEXT_245);
    } // instanceof FigureViewmap
 else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_246);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_247);
    } // instanceof SnippetViewmap; FIXME : obtain figure class name to generate getter
 else if (viewmap instanceof InnerClassViewmap) {

    stringBuffer.append(TEXT_248);
    stringBuffer.append(figureImportedName);
    stringBuffer.append(TEXT_249);
    }
    stringBuffer.append(TEXT_250);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_251);
    stringBuffer.append(figureImportedName);
    stringBuffer.append(TEXT_252);
    
if ("org.eclipse.draw2d.Label".equals(figureQualifiedClassName) || viewmap instanceof InnerClassViewmap) {

    stringBuffer.append(TEXT_253);
    
} else {

    stringBuffer.append(TEXT_254);
    
}

    stringBuffer.append(TEXT_255);
    }	/*not parent-assigned*/
    stringBuffer.append(TEXT_256);
    
if (!"org.eclipse.draw2d.Label".equals(figureQualifiedClassName) && viewmap instanceof InnerClassViewmap==false) {

    stringBuffer.append(TEXT_257);
    
}

    stringBuffer.append(TEXT_258);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_259);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_260);
    
String labelSetterName = "setLabel"; // same assumption in NodeEditPart
String labelFigureClassName = "org.eclipse.draw2d.IFigure";
if (viewmap instanceof ParentAssignedViewmap) {
	ParentAssignedViewmap parentAssignedViewmap = (ParentAssignedViewmap) viewmap;
	if (parentAssignedViewmap.getSetterName() != null) {
		labelSetterName = parentAssignedViewmap.getSetterName();
	}
	if (parentAssignedViewmap.getFigureQualifiedClassName() != null) {
		labelFigureClassName = parentAssignedViewmap.getFigureQualifiedClassName();
	}
} // FIXME perhaps, there's no sense to have setLabel for any other viewmap than ParentAssigned?

    stringBuffer.append(TEXT_261);
    stringBuffer.append(labelSetterName);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName(labelFigureClassName));
    stringBuffer.append(TEXT_263);
    
if ("org.eclipse.draw2d.Label".equals(labelFigureClassName)) {

    stringBuffer.append(TEXT_264);
    
} else {

    stringBuffer.append(TEXT_265);
    
}

    stringBuffer.append(TEXT_266);
    
if (viewmap instanceof InnerClassViewmap) {
	String classBody = ((InnerClassViewmap) viewmap).getClassBody();

    stringBuffer.append(TEXT_267);
    stringBuffer.append(classBody);
    stringBuffer.append(TEXT_268);
    
if (classBody.indexOf("DPtoLP") != -1) {

    stringBuffer.append(TEXT_269);
    
}

    
}

    stringBuffer.append(TEXT_270);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_271);
    return stringBuffer.toString();
  }
}
