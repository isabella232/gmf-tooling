package org.eclipse.gmf.codegen.templates.lite.parts;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.ecore.*;

public class ChildNodeEditPartGenerator
{
  protected static String nl;
  public static synchronized ChildNodeEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ChildNodeEditPartGenerator result = new ChildNodeEditPartGenerator();
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
  protected final String TEXT_7 = " implements IUpdatableEditPart {";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_10 = ";";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_14 = " manager;" + NL;
  protected final String TEXT_15 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String defaultText;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_16 = "(View view) {" + NL + "\t\tsetModel(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_17 = " getDiagramNode() {" + NL + "\t\treturn (";
  protected final String TEXT_18 = ") getModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {" + NL + "\t\t//XXX: install correct edit policies!";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = "\t\tinstallEditPolicy(";
  protected final String TEXT_21 = ".DIRECT_EDIT_ROLE," + NL + "\t\t\t\tnew ";
  protected final String TEXT_22 = "() {" + NL + "\t\t\t\t\tprotected void showCurrentEditValue(";
  protected final String TEXT_23 = " request) {" + NL + "\t\t\t\t\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\t\t\t\t\tgetLabel().setText(value);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprotected ";
  protected final String TEXT_24 = " getDirectEditCommand(";
  protected final String TEXT_25 = " request) {" + NL + "\t\t\t\t\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\t\t\t\t\tif (value == null) {" + NL + "\t\t\t\t\t\t\t//Invalid value is transformed into a null by the validator." + NL + "\t\t\t\t\t\t\t//XXX: implement validator" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_26 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tfinal Object[] parseResult;" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tparseResult = new ";
  protected final String TEXT_27 = "(EDIT_PATTERN).parse(value);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_28 = ".INSTANCE;" + NL + "\t\t\t\t\t\t} catch (";
  protected final String TEXT_29 = " e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_30 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_31 = " editingDomain = ";
  protected final String TEXT_32 = ".getEditingDomain(";
  protected final String TEXT_33 = ".getDiagram().getElement());";
  protected final String TEXT_34 = NL + "\t\t\t\t\t\tif (parseResult.length != 1) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_35 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_36 = " domainModelCommand = createDomainModelCommand(editingDomain, parseResult[0]);" + NL + "\t\t\t\t\t\treturn new WrappingCommand(editingDomain, domainModelCommand);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_37 = " createDomainModelCommand(";
  protected final String TEXT_38 = " editingDomain, Object value) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_39 = " element = ";
  protected final String TEXT_40 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_41 = " feature = (";
  protected final String TEXT_42 = ") ";
  protected final String TEXT_43 = ".eINSTANCE.get";
  protected final String TEXT_44 = "();" + NL + "\t\t\t\t\t\tObject valueToSet;" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalueToSet = ";
  protected final String TEXT_45 = ".parseValue(feature, value);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_46 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_47 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_48 = " result = new ";
  protected final String TEXT_49 = "();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_50 = " values = new ";
  protected final String TEXT_51 = "();" + NL + "\t\t\t\t\t\tvalues.addAll(element.get";
  protected final String TEXT_52 = "());" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_53 = ".create(editingDomain, element, feature, values));" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_54 = ".create(editingDomain, element, feature, valueToSet));" + NL + "\t\t\t\t\t\treturn result;";
  protected final String TEXT_55 = NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_56 = ".create(editingDomain, element, feature, valueToSet);";
  protected final String TEXT_57 = NL + "\t\t\t\t\t}";
  protected final String TEXT_58 = NL + "\t\t\t\t\t\tif (parseResult.length != ";
  protected final String TEXT_59 = ") {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_60 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_61 = " domainModelCommand = createDomainModelCommand(editingDomain, parseResult);" + NL + "\t\t\t\t\t\treturn new WrappingCommand(editingDomain, domainModelCommand);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_62 = " createDomainModelCommand(";
  protected final String TEXT_63 = " editingDomain, Object[] values) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_64 = " element = ";
  protected final String TEXT_65 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_66 = " result = new ";
  protected final String TEXT_67 = "();" + NL + "\t\t\t\t\t\tObject valueToSet;";
  protected final String TEXT_68 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_69 = " ";
  protected final String TEXT_70 = "feature = (";
  protected final String TEXT_71 = ") ";
  protected final String TEXT_72 = ".eINSTANCE.get";
  protected final String TEXT_73 = "();" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalueToSet = ";
  protected final String TEXT_74 = ".parseValue(feature, values[";
  protected final String TEXT_75 = "]);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_76 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_77 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_78 = " ";
  protected final String TEXT_79 = "values = new ";
  protected final String TEXT_80 = "();" + NL + "\t\t\t\t\t\tvalues.addAll(element.get";
  protected final String TEXT_81 = "());" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_82 = ".create(editingDomain, element, feature, values));" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_83 = ".create(editingDomain, element, feature, valueToSet));";
  protected final String TEXT_84 = NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_85 = ".create(editingDomain, element, feature, valueToSet));";
  protected final String TEXT_86 = NL + "\t\t\t\t\t\treturn result;" + NL + "\t\t\t\t\t}";
  protected final String TEXT_87 = NL + "\t\t\t\t});";
  protected final String TEXT_88 = NL;
  protected final String TEXT_89 = "\t\tinstallEditPolicy(";
  protected final String TEXT_90 = ".COMPONENT_ROLE, new ";
  protected final String TEXT_91 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_92 = " createDeleteCommand(";
  protected final String TEXT_93 = " deleteRequest) {" + NL + "\t\t\t\t";
  protected final String TEXT_94 = " editingDomain = ";
  protected final String TEXT_95 = ".getEditingDomain(getDiagramNode().getDiagram().getElement());" + NL + "\t\t\t\t";
  protected final String TEXT_96 = " cc = new ";
  protected final String TEXT_97 = "();" + NL + "\t\t\t\tcc.append(getDomainModelRemoveCommand(editingDomain));" + NL + "\t\t\t\tcc.append(";
  protected final String TEXT_98 = ".create(editingDomain, getDiagramNode()));" + NL + "\t\t\t\treturn new WrappingCommand(editingDomain, cc);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprivate org.eclipse.emf.common.command.Command getDomainModelRemoveCommand(";
  protected final String TEXT_99 = " editingDomain) {";
  protected final String TEXT_100 = NL + "\t\t\t\t";
  protected final String TEXT_101 = " result = new ";
  protected final String TEXT_102 = "();";
  protected final String TEXT_103 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_104 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_105 = ".eINSTANCE.get";
  protected final String TEXT_106 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_107 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_108 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_109 = ".eINSTANCE.get";
  protected final String TEXT_110 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_111 = ".UNSET_VALUE));";
  protected final String TEXT_112 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_113 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_114 = ".eINSTANCE.get";
  protected final String TEXT_115 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_116 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_117 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_118 = ".eINSTANCE.get";
  protected final String TEXT_119 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_120 = ".UNSET_VALUE));";
  protected final String TEXT_121 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_122 = NL + "\t\t\t\treturn ";
  protected final String TEXT_123 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_124 = ".eINSTANCE.get";
  protected final String TEXT_125 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement());";
  protected final String TEXT_126 = NL + "\t\t\t\treturn ";
  protected final String TEXT_127 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_128 = ".eINSTANCE.get";
  protected final String TEXT_129 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_130 = ".UNSET_VALUE);";
  protected final String TEXT_131 = NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_132 = NL + "\t}" + NL;
  protected final String TEXT_133 = NL;
  protected final String TEXT_134 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_135 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_136 = ".REQ_DIRECT_EDIT == req.getType()) {" + NL + "\t\t\tperformDirectEdit();" + NL + "\t\t} else {" + NL + "\t\t\tsuper.performRequest(req);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_137 = " getManager() {" + NL + "\t\tif (manager == null) {" + NL + "\t\t\tmanager = new ";
  protected final String TEXT_138 = "(this, ";
  protected final String TEXT_139 = ".class, new ";
  protected final String TEXT_140 = "() {" + NL + "\t\t\t\tpublic void relocate(";
  protected final String TEXT_141 = " celleditor) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_142 = " rect = getLabel().getTextBounds();" + NL + "\t\t\t\t\tgetLabel().translateToAbsolute(rect);" + NL + "\t\t\t\t\tcelleditor.getControl().setBounds(rect.x, rect.y, rect.width, rect.height);" + NL + "\t\t\t\t}" + NL + "\t\t\t}) {" + NL + "\t\t\t\tprotected void initCellEditor() {" + NL + "\t\t\t\t\tgetCellEditor().setValue(getLabelEditText());" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "\t\treturn manager;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performDirectEdit() {" + NL + "\t\tgetManager().show();" + NL + "\t}" + NL;
  protected final String TEXT_143 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getModelChildren() {" + NL + "\t\treturn ((View)getModel()).getVisibleChildren();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getModelSourceConnections() {" + NL + "\t\treturn ((View)getModel()).getSourceEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getModelTargetConnections() {" + NL + "\t\treturn ((View)getModel()).getTargetEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshLabel();" + NL + "\t\trefreshFont();" + NL + "\t\trefreshFontColor();" + NL + "\t\trefreshVisibility();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshLabel() {" + NL + "\t\tgetLabel().setText(getLabelText());" + NL + "\t\tgetLabel().setIcon(getLabelIcon());" + NL + "\t}";
  protected final String TEXT_144 = NL;
  protected final String TEXT_145 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final String VIEW_PATTERN = \"";
  protected final String TEXT_146 = "\";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final String EDIT_PATTERN = \"";
  protected final String TEXT_147 = "\";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelText() {" + NL + "\t\t";
  protected final String TEXT_148 = " element = ";
  protected final String TEXT_149 = ";" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn defaultText;" + NL + "\t\t}" + NL + "\t\treturn buildTextByPattern(element, VIEW_PATTERN);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelEditText() {" + NL + "\t\t";
  protected final String TEXT_150 = " element = ";
  protected final String TEXT_151 = ";" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn defaultText;" + NL + "\t\t}" + NL + "\t\treturn buildTextByPattern(element, EDIT_PATTERN);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String buildTextByPattern(";
  protected final String TEXT_152 = " element, String pattern) {";
  protected final String TEXT_153 = NL + "\t\tif (element.get";
  protected final String TEXT_154 = "() == null) {" + NL + "\t\t\treturn defaultText;" + NL + "\t\t}";
  protected final String TEXT_155 = NL + "\t\treturn ";
  protected final String TEXT_156 = ".format(pattern, new Object[] {";
  protected final String TEXT_157 = NL + "\t\t\t";
  protected final String TEXT_158 = NL + "\t\t});";
  protected final String TEXT_159 = NL + "\t\treturn ";
  protected final String TEXT_160 = ".format(pattern, new Object[] {";
  protected final String TEXT_161 = NL + "\t\t";
  protected final String TEXT_162 = ",";
  protected final String TEXT_163 = NL + "\t\t});";
  protected final String TEXT_164 = NL + "\t\t//XXX: unexpected model facet." + NL + "\t\treturn defaultText;";
  protected final String TEXT_165 = NL + "\t}";
  protected final String TEXT_166 = NL;
  protected final String TEXT_167 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFont() {";
  protected final String TEXT_168 = NL + "\t\t";
  protected final String TEXT_169 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_170 = ") ";
  protected final String TEXT_171 = ".getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_172 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_173 = " toDispose = createdFont;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tString fontName = style.getFontName();" + NL + "\t\t\tint fontHeight = style.getFontHeight();" + NL + "\t\t\tint fontStyle = ";
  protected final String TEXT_174 = ".NORMAL;" + NL + "\t\t\tif (style.isBold()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_175 = ".BOLD;" + NL + "\t\t\t}" + NL + "\t\t\tif (style.isItalic()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_176 = ".ITALIC;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_177 = " currentFont = getFigure().getFont();" + NL + "\t\t\tif (currentFont != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_178 = " currentFontData = currentFont.getFontData()[0];" + NL + "\t\t\t\tif (currentFontData.getName().equals(fontName) && currentFontData.getHeight() == fontHeight && currentFontData.getStyle() == fontStyle) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFont = new ";
  protected final String TEXT_179 = "(null, fontName, fontHeight, fontStyle);" + NL + "\t\t\tgetFigure().setFont(createdFont);" + NL + "\t\t} else {" + NL + "\t\t\t//revert to the default font" + NL + "\t\t\tgetFigure().setFont(getViewer().getControl().getFont());" + NL + "\t\t\tcreatedFont = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}";
  protected final String TEXT_180 = "\t" + NL + "\t}";
  protected final String TEXT_181 = NL + NL + "\t/**" + NL + "\t * The font (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned)." + NL + "\t * Whenever another non-default font is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_182 = " createdFont;";
  protected final String TEXT_183 = "\t";
  protected final String TEXT_184 = NL;
  protected final String TEXT_185 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFontColor() {" + NL + "\t\t";
  protected final String TEXT_186 = " style = (";
  protected final String TEXT_187 = ")  ";
  protected final String TEXT_188 = ".getStyle(";
  protected final String TEXT_189 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_190 = " toDispose = createdFontColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint fontColor = style.getFontColor();" + NL + "\t\t\tint red = fontColor & 0x000000FF;" + NL + "\t\t\tint green = (fontColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (fontColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_191 = " currentColor = getLabel().getForegroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFontColor = new ";
  protected final String TEXT_192 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setForegroundColor(createdFontColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setForegroundColor(getViewer().getControl().getForeground());" + NL + "\t\t\tcreatedFontColor = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshFontColor()}) currently assigned to the label." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_193 = " createdFontColor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_194 = " getLabelIcon() {";
  protected final String TEXT_195 = NL + "\t\t";
  protected final String TEXT_196 = " imageDescriptor = ";
  protected final String TEXT_197 = ".getInstance().getItemImageDescriptor(getDiagramNode().getElement());" + NL + "\t\tif (imageDescriptor != null) {" + NL + "\t\t\treturn imageDescriptor.createImage();" + NL + "\t\t}";
  protected final String TEXT_198 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisibility() {" + NL + "\t\tboolean isVisible = getDiagramNode().isVisible();" + NL + "\t\tboolean wasVisible = getFigure().isVisible();" + NL + "\t\tif (isVisible == wasVisible) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (!isVisible && (getSelected() != SELECTED_NONE)) {" + NL + "\t\t\tgetViewer().deselect(this);" + NL + "\t\t}" + NL + "" + NL + "\t\tgetFigure().setVisible(isVisible);" + NL + "\t\tgetFigure().revalidate();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class key) {";
  protected final String TEXT_199 = NL + "\t\treturn super.getAdapter(key);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tgetDiagramNode().getElement().eAdapters().add(domainModelRefresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {" + NL + "\t\tgetDiagramNode().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\tsuper.deactivate();" + NL + "\t}" + NL;
  protected final String TEXT_200 = NL;
  protected final String TEXT_201 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate DomainModelRefresher domainModelRefresher = new DomainModelRefresher();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class DomainModelRefresher extends ";
  protected final String TEXT_202 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void notifyChanged(";
  protected final String TEXT_203 = " msg) {" + NL + "\t\t\tsuper.notifyChanged(msg);" + NL + "\t\t\tif (msg.isTouch()) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tRefresher refresher = getRefresher((";
  protected final String TEXT_204 = ") msg.getFeature(), msg);" + NL + "\t\t\tif (refresher != null) {" + NL + "\t\t\t\trefresher.refresh();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_205 = NL;
  protected final String TEXT_206 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_207 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_208 = " feature, ";
  protected final String TEXT_209 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new HashMap();";
  protected final String TEXT_210 = NL;
  protected final String TEXT_211 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_212 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_213 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);";
  protected final String TEXT_214 = NL;
  protected final String TEXT_215 = "\t\tRefresher visibilityRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshVisibility();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_216 = ".eINSTANCE.getView_Visible(), visibilityRefresher);" + NL + "\t\tRefresher labelRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshLabel();" + NL + "\t\t\t}" + NL + "\t\t};";
  protected final String TEXT_217 = NL + "\t\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_218 = ".eINSTANCE.get";
  protected final String TEXT_219 = "(), labelRefresher);";
  protected final String TEXT_220 = NL + "\t\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_221 = ".eINSTANCE.get";
  protected final String TEXT_222 = "(), labelRefresher);";
  protected final String TEXT_223 = NL;
  protected final String TEXT_224 = "\t\tRefresher fontRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshFont();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_225 = ".eINSTANCE.getFontStyle_FontHeight(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_226 = ".eINSTANCE.getFontStyle_FontName(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_227 = ".eINSTANCE.getFontStyle_Bold(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_228 = ".eINSTANCE.getFontStyle_Italic(), fontRefresher);" + NL + "\t\t";
  protected final String TEXT_229 = NL;
  protected final String TEXT_230 = "\t\tRefresher fontColorRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshFontColor();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_231 = ".eINSTANCE.getFontStyle_FontColor(), fontColorRefresher);" + NL + "\t}" + NL;
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
final GenChildLabelNode genChildNode = (GenChildLabelNode)genElement;
GenNode genHost = genChildNode;
GenNode genNode = genChildNode;	/*var used by componentEditPolicy.javajetinc*/
GenClass underlyingMetaClass = genHost.getDomainMetaClass();
GenDiagram genDiagram = genChildNode.getDiagram();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
LabelModelFacet labelModelFacet = genChildNode.getLabelModelFacet();
final boolean isReadOnly = genChildNode.isLabelReadOnly();

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    importManager.emitPackageStatement(stringBuffer);

importManager.addImport("org.eclipse.gef.EditPolicy");
importManager.addImport("org.eclipse.gef.Request");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.addImport("org.eclipse.gmf.runtime.notation.NotationPackage");
importManager.addImport("java.util.List");

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_5);
    stringBuffer.append(genChildNode.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.AbstractGraphicalEditPart"));
    stringBuffer.append(TEXT_7);
    {
GenCommonBase genCommonBase = genChildNode;
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(TEXT_12);
    
if (!isReadOnly) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_14);
    
}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(genChildNode.getEditPartClassName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_18);
    
	String resolvedSemanticElement = "(" + importManager.getImportedName(genHost.getDomainMetaClass().getQualifiedInterfaceName()) + ") getDiagramNode().getElement()";
	final String primaryView = "getDiagramNode()";

    
if (!isReadOnly) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.DirectEditPolicy"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("java.text.ParseException"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_33);
    
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	GenFeature featureToSet = ((FeatureLabelModelFacet)labelModelFacet).getMetaFeature();
	EStructuralFeature ecoreFeature = featureToSet.getEcoreFeature();

    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName(featureToSet.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(featureToSet.getFeatureAccessorName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(genDiagram.getAbstractParserQualifiedClassName()));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_46);
    
	if (ecoreFeature.isMany()) {

    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.EList"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(featureToSet.getAccessorName());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_54);
    
	} else {

    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_56);
    
	}

    stringBuffer.append(TEXT_57);
    
} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
	CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;
	List metaFeatures = compositeFeatureLabelModelFacet.getMetaFeatures();

    stringBuffer.append(TEXT_58);
    stringBuffer.append(metaFeatures.size());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_67);
    
	boolean haveDeclaredValues = false;
	for(int i = 0; i < metaFeatures.size(); i++) {
		GenFeature nextFeatureToSet = (GenFeature) metaFeatures.get(i);
		EStructuralFeature nextEcoreFeature = nextFeatureToSet.getEcoreFeature();

    stringBuffer.append(TEXT_68);
    if (i == 0) {
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName(nextFeatureToSet.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(nextFeatureToSet.getFeatureAccessorName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName(genDiagram.getAbstractParserQualifiedClassName()));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_76);
    
		if (nextEcoreFeature.isMany()) {

    stringBuffer.append(TEXT_77);
    if (!haveDeclaredValues) { haveDeclaredValues = true;
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.EList"));
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(nextFeatureToSet.getAccessorName());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_83);
    
		} else {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_85);
    
		}

    
	}

    stringBuffer.append(TEXT_86);
    
}

    stringBuffer.append(TEXT_87);
    
}

    stringBuffer.append(TEXT_88);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ComponentEditPolicy"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.GroupRequest"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_99);
    
{
TypeModelFacet facet = genNode.getModelFacet();
GenFeature childFeature = facet.getChildMetaFeature();
GenFeature containmentFeature = facet.getContainmentMetaFeature();
if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_102);
    
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_106);
    
	} else {

    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_111);
    
	}

    
	if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_115);
    
	} else {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_120);
    
	}

    stringBuffer.append(TEXT_121);
    
} else {
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_125);
    
	} else {

    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_130);
    
	}
}

    stringBuffer.append(TEXT_131);
    
}	/*restrict local vars used in component edit policy*/

    stringBuffer.append(TEXT_132);
    
if (!isReadOnly) {

    stringBuffer.append(TEXT_133);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.TextCellEditor"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.CellEditorLocator"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.CellEditor"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_142);
    
}

    stringBuffer.append(TEXT_143);
    stringBuffer.append(TEXT_144);
    
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

    stringBuffer.append(TEXT_145);
    stringBuffer.append(viewPattern);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(editPattern);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_152);
    
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	FeatureLabelModelFacet featureLabelModelFacet = (FeatureLabelModelFacet) labelModelFacet;
	GenFeature feature = featureLabelModelFacet.getMetaFeature();
	if (!feature.isPrimitiveType()) {

    stringBuffer.append(TEXT_153);
    stringBuffer.append(feature.getCapName());
    stringBuffer.append(TEXT_154);
    
	}

    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_156);
    
		String value = "element.get" + feature.getCapName() + "()";	/*XXX: getTypedKey is not a part of public API!*/
		if (feature.isPrimitiveType()) {
			value = "new " + primitiveTypeToWrapperClassName.get(feature.getTypeGenClassifier().getEcoreClassifier().getInstanceClass()) + "(" + value + ")";
		}

    stringBuffer.append(TEXT_157);
    stringBuffer.append(value);
    stringBuffer.append(TEXT_158);
    
} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
	CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;

    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_160);
    
	for(Iterator it = compositeFeatureLabelModelFacet.getMetaFeatures().iterator(); it.hasNext(); ) {
		GenFeature next = (GenFeature) it.next();
		String value = "element.get" + next.getCapName() + "()";	/*XXX: getTypedKey is not a part of public API!*/
		if (next.isPrimitiveType()) {
			value = "new " + primitiveTypeToWrapperClassName.get(next.getTypeGenClassifier().getEcoreClassifier().getInstanceClass()) + "(" + value + ")";
		}

    stringBuffer.append(TEXT_161);
    stringBuffer.append(value);
    if (it.hasNext()) {
    stringBuffer.append(TEXT_162);
    }
    
	}

    stringBuffer.append(TEXT_163);
    
} else {

    stringBuffer.append(TEXT_164);
    
}

    stringBuffer.append(TEXT_165);
    stringBuffer.append(TEXT_166);
    
boolean isFixedFontSetInFigure;
{
	StyleAttributes styleAttributes = (genElement.getViewmap() == null) ? null : (StyleAttributes)genElement.getViewmap().find(StyleAttributes.class);
	isFixedFontSetInFigure = styleAttributes != null && styleAttributes.isFixedFont();
}

    stringBuffer.append(TEXT_167);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_179);
    
}

    stringBuffer.append(TEXT_180);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_182);
    
}

    stringBuffer.append(TEXT_183);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_194);
    
if (genChildNode.isLabelElementIcon()) {

    stringBuffer.append(TEXT_195);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_196);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_197);
    
}

    stringBuffer.append(TEXT_198);
    /*@ include file="adapters/propertySource.javajetinc"*/
    stringBuffer.append(TEXT_199);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.impl.AdapterImpl"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_209);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_213);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_216);
    
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	GenFeature feature = ((FeatureLabelModelFacet)labelModelFacet).getMetaFeature();

    stringBuffer.append(TEXT_217);
    stringBuffer.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_219);
    
} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
	CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;
	for(Iterator it = compositeFeatureLabelModelFacet.getMetaFeatures().iterator(); it.hasNext(); ) {
		GenFeature next = (GenFeature) it.next();

    stringBuffer.append(TEXT_220);
    stringBuffer.append(importManager.getImportedName(next.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(next.getFeatureAccessorName());
    stringBuffer.append(TEXT_222);
    
	}
}

    stringBuffer.append(TEXT_223);
    stringBuffer.append(TEXT_224);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_227);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_228);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_231);
    
final Viewmap viewmap = genChildNode.getViewmap();

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
