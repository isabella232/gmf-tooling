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
  protected final String TEXT_21 = NL;
  protected final String TEXT_22 = NL + NL + "/**" + NL + " * @generated" + NL + " */";
  protected final String TEXT_23 = NL + "public class ";
  protected final String TEXT_24 = " extends ";
  protected final String TEXT_25 = " {";
  protected final String TEXT_26 = NL;
  protected final String TEXT_27 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_28 = ";";
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_31 = " manager;" + NL;
  protected final String TEXT_32 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String defaultText;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_33 = "(View view) {";
  protected final String TEXT_34 = NL + "\t\tsuper(view);";
  protected final String TEXT_35 = NL + "\t\tsetModel(view);";
  protected final String TEXT_36 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {";
  protected final String TEXT_37 = NL;
  protected final String TEXT_38 = "\t\tinstallEditPolicy(";
  protected final String TEXT_39 = ".DIRECT_EDIT_ROLE," + NL + "\t\t\t\tnew ";
  protected final String TEXT_40 = "() {" + NL + "\t\t\t\t\tprotected void showCurrentEditValue(";
  protected final String TEXT_41 = " request) {" + NL + "\t\t\t\t\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\t\t\t\t\tgetLabel().setText(value);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = "\t\t\t\t\tprotected ";
  protected final String TEXT_44 = " getDirectEditCommand(";
  protected final String TEXT_45 = " request) {";
  protected final String TEXT_46 = NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_47 = ".INSTANCE;";
  protected final String TEXT_48 = NL + "\t\t\t\t\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\t\t\t\t\tif (value == null) {" + NL + "\t\t\t\t\t\t\t//Invalid value is transformed into a null by the validator." + NL + "\t\t\t\t\t\t\t//XXX: implement validator" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_49 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tfinal Object[] parseResult;";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\tif (value.length() == 0) {" + NL + "\t\t\t\t\t\t\tparseResult = new Object[] { null };" + NL + "\t\t\t\t\t\t} else {";
  protected final String TEXT_51 = NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tparseResult = new ";
  protected final String TEXT_52 = "(";
  protected final String TEXT_53 = ").parse(value);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_54 = ".INSTANCE;" + NL + "\t\t\t\t\t\t} catch (";
  protected final String TEXT_55 = " e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_56 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\t}";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_59 = " editingDomain = ";
  protected final String TEXT_60 = ".getEditingDomain(";
  protected final String TEXT_61 = ".getDiagram().getElement());" + NL + "\t\t\t\t\t\tif (parseResult.length != ";
  protected final String TEXT_62 = ") {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_63 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_64 = " domainModelCommand = createDomainModelCommand(editingDomain, parseResult);" + NL + "\t\t\t\t\t\treturn new ";
  protected final String TEXT_65 = "(editingDomain, domainModelCommand);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_66 = " createDomainModelCommand(";
  protected final String TEXT_67 = " editingDomain, Object[] values) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_68 = " element = ";
  protected final String TEXT_69 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_70 = " result = new ";
  protected final String TEXT_71 = "();" + NL + "\t\t\t\t\t\tObject valueToSet;";
  protected final String TEXT_72 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_73 = " ";
  protected final String TEXT_74 = "feature = (";
  protected final String TEXT_75 = ") ";
  protected final String TEXT_76 = ".eINSTANCE.get";
  protected final String TEXT_77 = "();" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalueToSet = ";
  protected final String TEXT_78 = ".parseValue(feature, values[";
  protected final String TEXT_79 = "]);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_80 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_81 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_82 = " ";
  protected final String TEXT_83 = "values = new ";
  protected final String TEXT_84 = "();" + NL + "\t\t\t\t\t\tvalues.addAll(element.get";
  protected final String TEXT_85 = "());" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_86 = ".create(editingDomain, element, feature, values));" + NL + "\t\t\t\t\t\tif (valueToSet != null) {" + NL + "\t\t\t\t\t\t\tresult.append(";
  protected final String TEXT_87 = ".create(editingDomain, element, feature, valueToSet));" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_88 = NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_89 = ".create(editingDomain, element, feature, valueToSet == null ? ";
  protected final String TEXT_90 = ".UNSET_VALUE : valueToSet));";
  protected final String TEXT_91 = NL + "\t\t\t\t\t\treturn result;" + NL + "\t\t\t\t\t}";
  protected final String TEXT_92 = NL + "\t\t\t\t});";
  protected final String TEXT_93 = NL;
  protected final String TEXT_94 = NL + "\t\tinstallEditPolicy(\"";
  protected final String TEXT_95 = "\", new ";
  protected final String TEXT_96 = "()); //$NON-NLS-1$";
  protected final String TEXT_97 = NL;
  protected final String TEXT_98 = NL + "\t\tinstallEditPolicy(";
  protected final String TEXT_99 = ".OPEN_ROLE";
  protected final String TEXT_100 = " + \"";
  protected final String TEXT_101 = "\" ";
  protected final String TEXT_102 = ", new ";
  protected final String TEXT_103 = "());";
  protected final String TEXT_104 = NL + "\t}" + NL;
  protected final String TEXT_105 = NL;
  protected final String TEXT_106 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_107 = " req) {";
  protected final String TEXT_108 = NL + "\t\tif (";
  protected final String TEXT_109 = ".REQ_DIRECT_EDIT.equals(req.getType())) {" + NL + "\t\t\tperformDirectEdit();" + NL + "\t\t\treturn;" + NL + "\t\t}";
  protected final String TEXT_110 = NL;
  protected final String TEXT_111 = "if (";
  protected final String TEXT_112 = ".REQ_OPEN.equals(req.getType())) {" + NL + "\t";
  protected final String TEXT_113 = " command = getCommand(req);" + NL + "\tif (command != null && command.canExecute()) {" + NL + "\t\tgetViewer().getEditDomain().getCommandStack().execute(command);" + NL + "\t}" + NL + "\treturn;" + NL + "}" + NL + "\t\tsuper.performRequest(req);" + NL + "\t}";
  protected final String TEXT_114 = NL;
  protected final String TEXT_115 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_116 = " getManager() {" + NL + "\t\tif (manager == null) {" + NL + "\t\t\tmanager = new ";
  protected final String TEXT_117 = "(this, ";
  protected final String TEXT_118 = ".class, new ";
  protected final String TEXT_119 = "() {" + NL + "\t\t\t\tpublic void relocate(";
  protected final String TEXT_120 = " celleditor) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_121 = " rect = getLabel().getTextBounds();" + NL + "\t\t\t\t\tgetLabel().translateToAbsolute(rect);" + NL + "\t\t\t\t\t";
  protected final String TEXT_122 = " zoomManager = (";
  protected final String TEXT_123 = ") getViewer().getProperty(";
  protected final String TEXT_124 = ".class.toString());" + NL + "\t\t\t\t\tdouble zoomLevel = zoomManager == null ? 1.0 : zoomManager.getZoom();" + NL + "\t\t\t\t\tif (zoomLevel > 1.0 && getLabel().getFont() != null) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_125 = "[] datas = getLabel().getFont().getFontData();" + NL + "\t\t\t\t\t\tfor(int i = 0; i < datas.length; i++) {" + NL + "\t\t\t\t\t\t\tdatas[i].height *= zoomLevel;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tfinal ";
  protected final String TEXT_126 = " font = new ";
  protected final String TEXT_127 = "(getLabel().getFont().getDevice(), datas);" + NL + "\t\t\t\t\t\tcelleditor.getControl().setFont(font);" + NL + "\t\t\t\t\t\tcelleditor.getControl().addDisposeListener(new ";
  protected final String TEXT_128 = "() {" + NL + "\t\t\t\t\t\t\tpublic void widgetDisposed(";
  protected final String TEXT_129 = " e) {" + NL + "\t\t\t\t\t\t\t\tfont.dispose();" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t});" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tint avr = ";
  protected final String TEXT_130 = ".getFontMetrics(celleditor.getControl().getFont()).getAverageCharWidth();" + NL + "\t\t\t\t\trect.setSize(new ";
  protected final String TEXT_131 = "(celleditor.getControl().computeSize(";
  protected final String TEXT_132 = ".DEFAULT, ";
  protected final String TEXT_133 = ".DEFAULT)).expand(avr * 2, 0));" + NL + "\t\t\t\t\tcelleditor.getControl().setBounds(rect.x, rect.y, rect.width, rect.height);" + NL + "\t\t\t\t}" + NL + "\t\t\t}) {" + NL + "\t\t\t\tprotected void initCellEditor() {" + NL + "\t\t\t\t\tgetCellEditor().setValue(getLabelEditText());" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "\t\treturn manager;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performDirectEdit() {" + NL + "\t\tgetManager().show();" + NL + "\t}" + NL;
  protected final String TEXT_134 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshLabel();" + NL + "\t\trefreshFont();" + NL + "\t\trefreshFontColor();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshLabel() {" + NL + "\t\tgetLabel().setText(getLabelText());" + NL + "\t\tgetLabel().setIcon(getLabelIcon());" + NL + "\t}" + NL;
  protected final String TEXT_135 = NL;
  protected final String TEXT_136 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String VIEW_PATTERN = \"";
  protected final String TEXT_137 = "\";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String EDIT_PATTERN = \"";
  protected final String TEXT_138 = "\";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelText() {" + NL + "\t\t";
  protected final String TEXT_139 = " element = ";
  protected final String TEXT_140 = ";" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn defaultText;" + NL + "\t\t}" + NL + "\t\tString result = buildTextByPattern(element, VIEW_PATTERN);" + NL + "\t\tif (result == null || result.length() == 0) {" + NL + "\t\t\treturn defaultText;" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelEditText() {" + NL + "\t\t";
  protected final String TEXT_141 = " element = ";
  protected final String TEXT_142 = ";" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn \"\";\t//$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\tString result = buildTextByPattern(element, EDIT_PATTERN);" + NL + "\t\tif (result == null) {" + NL + "\t\t\treturn \"\";\t//$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static String buildTextByPattern(";
  protected final String TEXT_143 = " element, String pattern) {";
  protected final String TEXT_144 = NL + "\t\treturn ";
  protected final String TEXT_145 = ".format(pattern, new Object[] {";
  protected final String TEXT_146 = NL + "\t\t\tnew ";
  protected final String TEXT_147 = "(";
  protected final String TEXT_148 = ")";
  protected final String TEXT_149 = " == null ? \"\" : ";
  protected final String TEXT_150 = ",";
  protected final String TEXT_151 = NL + "\t\t});";
  protected final String TEXT_152 = NL + "\t\t//XXX: unexpected model facet." + NL + "\t\treturn null;";
  protected final String TEXT_153 = NL + "\t}";
  protected final String TEXT_154 = NL;
  protected final String TEXT_155 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFont() {";
  protected final String TEXT_156 = NL + "\t\t";
  protected final String TEXT_157 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_158 = ") ";
  protected final String TEXT_159 = ".getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_160 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_161 = " toDispose = createdFont;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tString fontName = style.getFontName();" + NL + "\t\t\tint fontHeight = style.getFontHeight();" + NL + "\t\t\tint fontStyle = ";
  protected final String TEXT_162 = ".NORMAL;" + NL + "\t\t\tif (style.isBold()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_163 = ".BOLD;" + NL + "\t\t\t}" + NL + "\t\t\tif (style.isItalic()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_164 = ".ITALIC;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_165 = " currentFont = getFigure().getFont();" + NL + "\t\t\tif (currentFont != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_166 = " currentFontData = currentFont.getFontData()[0];" + NL + "\t\t\t\tif (currentFontData.getName().equals(fontName) && currentFontData.getHeight() == fontHeight && currentFontData.getStyle() == fontStyle) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFont = new ";
  protected final String TEXT_167 = "(null, fontName, fontHeight, fontStyle);" + NL + "\t\t\tgetFigure().setFont(createdFont);" + NL + "\t\t} else {" + NL + "\t\t\t//revert to the default font" + NL + "\t\t\tgetFigure().setFont(getViewer().getControl().getFont());" + NL + "\t\t\tcreatedFont = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}";
  protected final String TEXT_168 = "\t" + NL + "\t}";
  protected final String TEXT_169 = NL + NL + "\t/**" + NL + "\t * The font (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned)." + NL + "\t * Whenever another non-default font is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_170 = " createdFont;";
  protected final String TEXT_171 = "\t";
  protected final String TEXT_172 = NL;
  protected final String TEXT_173 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFontColor() {" + NL + "\t\t";
  protected final String TEXT_174 = " style = (";
  protected final String TEXT_175 = ")  ";
  protected final String TEXT_176 = ".getStyle(";
  protected final String TEXT_177 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_178 = " toDispose = createdFontColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint fontColor = style.getFontColor();" + NL + "\t\t\tint red = fontColor & 0x000000FF;" + NL + "\t\t\tint green = (fontColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (fontColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_179 = " currentColor = getLabel().getForegroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFontColor = new ";
  protected final String TEXT_180 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setForegroundColor(createdFontColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setForegroundColor(getViewer().getControl().getForeground());" + NL + "\t\t\tcreatedFontColor = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshFontColor()}) currently assigned to the label." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_181 = " createdFontColor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_182 = " getLabelIcon() {";
  protected final String TEXT_183 = NL + "\t\t";
  protected final String TEXT_184 = " element = resolveSemanticElement();" + NL + "\t\t";
  protected final String TEXT_185 = " imageDescriptor = ";
  protected final String TEXT_186 = ".getInstance().getItemImageDescriptor(element);" + NL + "\t\tif (imageDescriptor != null) {" + NL + "\t\t\treturn imageDescriptor.createImage();" + NL + "\t\t}";
  protected final String TEXT_187 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_188 = " resolveSemanticElement() {" + NL + "\t\tView view = (View) getModel();" + NL + "\t\treturn (view.getElement() instanceof ";
  protected final String TEXT_189 = ") ? (";
  protected final String TEXT_190 = ") view.getElement() : null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_191 = " getUpdatableParent() {" + NL + "\t\tfor(EditPart editPart = getParent(); editPart != null; editPart = editPart.getParent()) {" + NL + "\t\t\tif (editPart instanceof ";
  protected final String TEXT_192 = ") {" + NL + "\t\t\t\treturn (";
  protected final String TEXT_193 = ") editPart;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\t";
  protected final String TEXT_194 = " updatableParent = getUpdatableParent();" + NL + "\t\tif (updatableParent != null) {" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_195 = ".eINSTANCE.getFontStyle_FontColor(), fontColorRefresher);" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_196 = ".eINSTANCE.getFontStyle_FontHeight(), fontRefresher);" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_197 = ".eINSTANCE.getFontStyle_FontName(), fontRefresher);" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_198 = ".eINSTANCE.getFontStyle_Bold(), fontRefresher);" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_199 = ".eINSTANCE.getFontStyle_Italic(), fontRefresher);";
  protected final String TEXT_200 = NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_201 = ".eINSTANCE.getLocation_X(), boundsRefresher);" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_202 = ".eINSTANCE.getLocation_Y(), boundsRefresher);" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_203 = ".eINSTANCE.getSize_Width(), boundsRefresher);" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_204 = ".eINSTANCE.getSize_Height(), boundsRefresher);" + NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_205 = ".eINSTANCE.getNode_LayoutConstraint(), boundsRefresher);";
  protected final String TEXT_206 = NL + "\t\t\tupdatableParent.addRefresher(";
  protected final String TEXT_207 = ".eINSTANCE.get";
  protected final String TEXT_208 = "(), labelRefresher);";
  protected final String TEXT_209 = NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {" + NL + "\t\tsuper.deactivate();" + NL + "\t\t";
  protected final String TEXT_210 = " updatableParent = getUpdatableParent();" + NL + "\t\tif (updatableParent != null) {" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_211 = ".eINSTANCE.getFontStyle_FontColor(), fontColorRefresher);" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_212 = ".eINSTANCE.getFontStyle_FontHeight(), fontRefresher);" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_213 = ".eINSTANCE.getFontStyle_FontName(), fontRefresher);" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_214 = ".eINSTANCE.getFontStyle_Bold(), fontRefresher);" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_215 = ".eINSTANCE.getFontStyle_Italic(), fontRefresher);";
  protected final String TEXT_216 = NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_217 = ".eINSTANCE.getLocation_X(), boundsRefresher);" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_218 = ".eINSTANCE.getLocation_Y(), boundsRefresher);" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_219 = ".eINSTANCE.getSize_Width(), boundsRefresher);" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_220 = ".eINSTANCE.getSize_Height(), boundsRefresher);" + NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_221 = ".eINSTANCE.getNode_LayoutConstraint(), boundsRefresher);";
  protected final String TEXT_222 = NL + "\t\t\tupdatableParent.removeRefresher(";
  protected final String TEXT_223 = ".eINSTANCE.get";
  protected final String TEXT_224 = "(), labelRefresher);";
  protected final String TEXT_225 = NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_226 = ".Refresher labelRefresher = new ";
  protected final String TEXT_227 = ".Refresher() {" + NL + "\t\tpublic void refresh() {" + NL + "\t\t\trefreshLabel();" + NL + "\t\t}" + NL + "\t};" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_228 = ".Refresher fontColorRefresher = new ";
  protected final String TEXT_229 = ".Refresher() {" + NL + "\t\tpublic void refresh() {" + NL + "\t\t\trefreshFontColor();" + NL + "\t\t}" + NL + "\t};" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_230 = ".Refresher fontRefresher = new ";
  protected final String TEXT_231 = ".Refresher() {" + NL + "\t\tpublic void refresh() {" + NL + "\t\t\trefreshFont();" + NL + "\t\t}" + NL + "\t};";
  protected final String TEXT_232 = NL;
  protected final String TEXT_233 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_234 = " createFigure() {" + NL + "\t\t// Parent should assign one using ";
  protected final String TEXT_235 = " method" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_236 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_237 = " createLabel() {";
  protected final String TEXT_238 = NL + "\t\treturn new ";
  protected final String TEXT_239 = "();";
  protected final String TEXT_240 = NL + "\t\treturn ";
  protected final String TEXT_241 = ";";
  protected final String TEXT_242 = NL + "\t\treturn new ";
  protected final String TEXT_243 = "();";
  protected final String TEXT_244 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_245 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_246 = " label = createLabel();";
  protected final String TEXT_247 = NL + "\t\tdefaultText = label.getText();";
  protected final String TEXT_248 = NL + "\t\tdefaultText = \"\";\t//$NON-NLS-1$";
  protected final String TEXT_249 = NL + "\t\treturn label;" + NL + "\t}";
  protected final String TEXT_250 = NL + NL + "\t/**";
  protected final String TEXT_251 = NL + "\t * TODO: reimplement, since the figure used by this editpart is not a Label.";
  protected final String TEXT_252 = NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_253 = " getLabel() {" + NL + "\t\treturn (";
  protected final String TEXT_254 = ") getFigure();" + NL + "\t}" + NL;
  protected final String TEXT_255 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void ";
  protected final String TEXT_256 = "(";
  protected final String TEXT_257 = " figure) {" + NL + "\t\tunregisterVisuals();" + NL + "\t\tsetFigure(figure);";
  protected final String TEXT_258 = NL + "\t\tdefaultText = figure.getText();";
  protected final String TEXT_259 = NL + "\t\tdefaultText = \"\";\t//$NON-NLS-1$";
  protected final String TEXT_260 = NL + "\t\tregisterVisuals();" + NL + "\t\trefreshVisuals();" + NL + "\t}" + NL;
  protected final String TEXT_261 = NL;
  protected final String TEXT_262 = NL;
  protected final String TEXT_263 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MapModeWorkaround {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int DPtoLP(int dp) {" + NL + "\t\t\treturn dp;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static MapModeWorkaround INSTANCE = new MapModeWorkaround();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MapModeWorkaround getMapMode() {" + NL + "\t\treturn MapModeWorkaround.INSTANCE;" + NL + "\t}";
  protected final String TEXT_264 = NL + "}";
  protected final String TEXT_265 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenCommonBase genElement = (GenCommonBase) ((Object[]) argument)[0];
final GenNodeLabel genLabel = (GenNodeLabel) genElement;
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
GenNode genHost = genLabel.getNode();
GenClass underlyingMetaClass = genHost.getDomainMetaClass();
GenDiagram genDiagram = genLabel.getDiagram();
LabelModelFacet labelModelFacet = genLabel.getModelFacet();
final boolean isReadOnly = genLabel.isReadOnly();

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
    stringBuffer.append(TEXT_21);
    
importManager.addImport("org.eclipse.gef.EditPart");
importManager.addImport("org.eclipse.gef.EditPolicy");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_22);
    
 	boolean isExternal;
 	String baseClass;
 	if (genLabel instanceof GenExternalNodeLabel) {
 		isExternal = true;
 		baseClass = genDiagram.getBaseExternalNodeLabelEditPartQualifiedClassName();
 	} else {
 		isExternal = false;
 		baseClass = "org.eclipse.gef.editparts.AbstractGraphicalEditPart";
 	}
 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(baseClass));
    stringBuffer.append(TEXT_25);
    {
GenCommonBase genCommonBase = genLabel;
    stringBuffer.append(TEXT_26);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    
if (!isReadOnly) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_31);
    
}

    stringBuffer.append(TEXT_32);
    stringBuffer.append(genLabel.getEditPartClassName());
    stringBuffer.append(TEXT_33);
    
if (isExternal) {

    stringBuffer.append(TEXT_34);
    
} else {

    stringBuffer.append(TEXT_35);
    
}

    stringBuffer.append(TEXT_36);
    
	final String primaryView = "getUpdatableParent().getDiagramNode()";
	final String resolvedSemanticElement = "resolveSemanticElement()";
	if (!isReadOnly) {
		String editPatternCode = "EDIT_PATTERN";	//declared in labelText.javajetinc, used in directEditCommand.jetinc.

    stringBuffer.append(TEXT_37);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.DirectEditPolicy"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_45);
    
if (labelModelFacet instanceof FeatureLabelModelFacet == false) {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_47);
    
} else {
	FeatureLabelModelFacet featureLabelModelFacet = (FeatureLabelModelFacet) labelModelFacet;
	List metaFeatures = featureLabelModelFacet.getMetaFeatures();

    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_49);
    
	if (metaFeatures.size() == 1 && String.class.equals(((GenFeature) metaFeatures.get(0)).getEcoreFeature().getEType().getInstanceClass())) {

    stringBuffer.append(TEXT_50);
    
	}

    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(editPatternCode);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("java.text.ParseException"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_56);
    
	if (metaFeatures.size() == 1 && String.class.equals(((GenFeature) metaFeatures.get(0)).getEcoreFeature().getEType().getInstanceClass())) {

    stringBuffer.append(TEXT_57);
    
	}

    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(metaFeatures.size());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_71);
    
	boolean haveDeclaredValues = false;
	for(int i = 0; i < metaFeatures.size(); i++) {
		GenFeature nextFeatureToSet = (GenFeature) metaFeatures.get(i);
		EStructuralFeature nextEcoreFeature = nextFeatureToSet.getEcoreFeature();

    stringBuffer.append(TEXT_72);
    if (i == 0) {
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_73);
    }
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName(nextFeatureToSet.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(nextFeatureToSet.getFeatureAccessorName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.ParserUtil"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_80);
    
		if (nextEcoreFeature.isMany()) {

    stringBuffer.append(TEXT_81);
    if (!haveDeclaredValues) { haveDeclaredValues = true;
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.EList"));
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(nextFeatureToSet.getAccessorName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_87);
    
		} else {

    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_90);
    
		}

    
	}

    stringBuffer.append(TEXT_91);
    
}

    stringBuffer.append(TEXT_92);
    
	}

    {
GenCommonBase genCommonBase = genLabel;
    stringBuffer.append(TEXT_93);
    
for (CustomBehaviour behaviour : genCommonBase.getBehaviour(CustomBehaviour.class)) {

    stringBuffer.append(TEXT_94);
    stringBuffer.append(behaviour.getKey());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName(behaviour.getEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_96);
    }
    stringBuffer.append(TEXT_97);
    
{
	List<OpenDiagramBehaviour> behaviours = genCommonBase.getBehaviour(OpenDiagramBehaviour.class);
	for(int i = 0, iMax = behaviours.size(); i < iMax; i++) {
	/*doesn't make sense to install more than one policy for the same role*/ 
		OpenDiagramBehaviour next = behaviours.get(i);

    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.policies.EditPolicyRoles"));
    stringBuffer.append(TEXT_99);
    if (i > 0) {
    stringBuffer.append(TEXT_100);
    stringBuffer.append(i+1);
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName(genCommonBase.getBehaviour(OpenDiagramBehaviour.class).get(0).getEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_103);
    
	}
}

    }
    stringBuffer.append(TEXT_104);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_107);
    
if (!isReadOnly) {

    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_109);
    
}

    stringBuffer.append(TEXT_110);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_113);
    
	if (!isReadOnly) {

    stringBuffer.append(TEXT_114);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.TextCellEditor"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.CellEditorLocator"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.CellEditor"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.ZoomManager"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.ZoomManager"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.ZoomManager"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.DisposeListener"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.DisposeEvent"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FigureUtilities"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_133);
    
	}

    stringBuffer.append(TEXT_134);
    stringBuffer.append(TEXT_135);
    
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
		StringBuffer patternBuffer = new StringBuffer();
		for(int i = 0; i < featureLabelModelFacet.getMetaFeatures().size(); i++) {
			patternBuffer.append("{").append(i).append("} ");
		}
		viewPattern = patternBuffer.toString().trim();
	}
	editPattern = featureLabelModelFacet.getEditPattern();
	if (editPattern == null || editPattern.length() == 0) {
		StringBuffer patternBuffer = new StringBuffer();
		for(int i = 0; i < featureLabelModelFacet.getMetaFeatures().size(); i++) {
			patternBuffer.append("{").append(i).append("} ");
		}
		editPattern = patternBuffer.toString().trim();
	}
}

    stringBuffer.append(TEXT_136);
    stringBuffer.append(viewPattern);
    stringBuffer.append(TEXT_137);
    stringBuffer.append(editPattern);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_143);
    
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	FeatureLabelModelFacet featureLabelModelFacet = (FeatureLabelModelFacet) labelModelFacet;

    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_145);
    
	for(Iterator it = featureLabelModelFacet.getMetaFeatures().iterator(); it.hasNext(); ) {
		GenFeature next = (GenFeature) it.next();
		if (next.isPrimitiveType()) {

    stringBuffer.append(TEXT_146);
    stringBuffer.append(primitiveTypeToWrapperClassName.get(next.getTypeGenClassifier().getEcoreClassifier().getInstanceClass()));
    stringBuffer.append(TEXT_147);
    
		}
		myFeatureGetAccessorHelper.appendFeatureValueGetter("element", next, underlyingMetaClass, false);
		if (next.isPrimitiveType()) {

    stringBuffer.append(TEXT_148);
    
		} else {
			if (String.class.equals(next.getEcoreFeature().getEType().getInstanceClass())) {

    stringBuffer.append(TEXT_149);
    
				myFeatureGetAccessorHelper.appendFeatureValueGetter("element", next, underlyingMetaClass, false);
			}
		}
		if (it.hasNext()) {
    stringBuffer.append(TEXT_150);
    }
    
	}

    stringBuffer.append(TEXT_151);
    
} else {

    stringBuffer.append(TEXT_152);
    
}

    stringBuffer.append(TEXT_153);
    stringBuffer.append(TEXT_154);
    
boolean isFixedFontSetInFigure;
{
	StyleAttributes styleAttributes = (genElement.getViewmap() == null) ? null : (StyleAttributes)genElement.getViewmap().find(StyleAttributes.class);
	isFixedFontSetInFigure = styleAttributes != null && styleAttributes.isFixedFont();
}

    stringBuffer.append(TEXT_155);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_167);
    
}

    stringBuffer.append(TEXT_168);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_170);
    
}

    stringBuffer.append(TEXT_171);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_182);
    
if (genLabel.isElementIcon()) {

    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName(genHost.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_186);
    
}

    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName(genHost.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName(genHost.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName(genHost.getDomainMetaClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_194);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_199);
    
if (isExternal) {

    stringBuffer.append(TEXT_200);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_205);
    
}
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	FeatureLabelModelFacet featureLabelModelFacet = (FeatureLabelModelFacet) labelModelFacet;
	for(Iterator it = featureLabelModelFacet.getMetaFeatures().iterator(); it.hasNext(); ) {
		GenFeature next = (GenFeature) it.next();

    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName(next.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(next.getFeatureAccessorName());
    stringBuffer.append(TEXT_208);
    
	}
}

    stringBuffer.append(TEXT_209);
    stringBuffer.append(importManager.getImportedName(genHost.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_210);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_215);
    
if (isExternal) {

    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_221);
    
}
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	FeatureLabelModelFacet featureLabelModelFacet = (FeatureLabelModelFacet) labelModelFacet;
	for(Iterator it = featureLabelModelFacet.getMetaFeatures().iterator(); it.hasNext(); ) {
		GenFeature next = (GenFeature) it.next();

    stringBuffer.append(TEXT_222);
    stringBuffer.append(importManager.getImportedName(next.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(next.getFeatureAccessorName());
    stringBuffer.append(TEXT_224);
    
	}
}

    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_230);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_231);
    
final Viewmap viewmap = genLabel.getViewmap();

    stringBuffer.append(TEXT_232);
    
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

    stringBuffer.append(TEXT_233);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_234);
    stringBuffer.append((parentAssignedViewmap.getSetterName() == null ? "setLabel" : parentAssignedViewmap.getSetterName()));
    stringBuffer.append(TEXT_235);
    } else { 
    stringBuffer.append(TEXT_236);
    stringBuffer.append(figureImportedName);
    stringBuffer.append(TEXT_237);
    
if (viewmap instanceof FigureViewmap) {

    stringBuffer.append(TEXT_238);
    stringBuffer.append(figureImportedName);
    stringBuffer.append(TEXT_239);
    } // instanceof FigureViewmap
 else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_240);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_241);
    } // instanceof SnippetViewmap; FIXME : obtain figure class name to generate getter
 else if (viewmap instanceof InnerClassViewmap) {

    stringBuffer.append(TEXT_242);
    stringBuffer.append(figureImportedName);
    stringBuffer.append(TEXT_243);
    }
    stringBuffer.append(TEXT_244);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(figureImportedName);
    stringBuffer.append(TEXT_246);
    
if ("org.eclipse.draw2d.Label".equals(figureQualifiedClassName) || viewmap instanceof InnerClassViewmap) {

    stringBuffer.append(TEXT_247);
    
} else {

    stringBuffer.append(TEXT_248);
    
}

    stringBuffer.append(TEXT_249);
    }	/*not parent-assigned*/
    stringBuffer.append(TEXT_250);
    
if (!"org.eclipse.draw2d.Label".equals(figureQualifiedClassName) && viewmap instanceof InnerClassViewmap==false) {

    stringBuffer.append(TEXT_251);
    
}

    stringBuffer.append(TEXT_252);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_253);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_254);
    
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

    stringBuffer.append(TEXT_255);
    stringBuffer.append(labelSetterName);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(importManager.getImportedName(labelFigureClassName));
    stringBuffer.append(TEXT_257);
    
if ("org.eclipse.draw2d.Label".equals(labelFigureClassName)) {

    stringBuffer.append(TEXT_258);
    
} else {

    stringBuffer.append(TEXT_259);
    
}

    stringBuffer.append(TEXT_260);
    
if (viewmap instanceof InnerClassViewmap) {
	String classBody = ((InnerClassViewmap) viewmap).getClassBody();

    stringBuffer.append(TEXT_261);
    stringBuffer.append(classBody);
    stringBuffer.append(TEXT_262);
    
if (classBody.indexOf("DPtoLP") != -1) {

    stringBuffer.append(TEXT_263);
    
}

    
}

    stringBuffer.append(TEXT_264);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_265);
    return stringBuffer.toString();
  }
}
