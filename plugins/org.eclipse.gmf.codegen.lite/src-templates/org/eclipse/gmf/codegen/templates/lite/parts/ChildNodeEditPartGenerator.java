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
  protected final String TEXT_23 = " implements ";
  protected final String TEXT_24 = " {";
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_27 = ";";
  protected final String TEXT_28 = NL;
  protected final String TEXT_29 = NL;
  protected final String TEXT_30 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_31 = " manager;" + NL;
  protected final String TEXT_32 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String defaultText;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_33 = "(View view) {" + NL + "\t\tsetModel(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_34 = " getDiagramNode() {" + NL + "\t\treturn (";
  protected final String TEXT_35 = ") getModel();" + NL + "\t}" + NL;
  protected final String TEXT_36 = NL;
  protected final String TEXT_37 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void registerModel() {" + NL + "\t\tsuper.registerModel();" + NL + "\t\t";
  protected final String TEXT_38 = " view = (";
  protected final String TEXT_39 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().put(view.getElement(), this);\t" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void unregisterModel() {" + NL + "\t\tsuper.unregisterModel();" + NL + "\t\t";
  protected final String TEXT_40 = " view = (";
  protected final String TEXT_41 = ") getModel();" + NL + "\t\tif (view != null && view.isSetElement() && view.getElement() != null && getViewer().getEditPartRegistry().get(view.getElement()) == this) {" + NL + "\t\t\tgetViewer().getEditPartRegistry().remove(view.getElement());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createEditPolicies() {" + NL + "\t\t//XXX: install correct edit policies!";
  protected final String TEXT_42 = NL;
  protected final String TEXT_43 = "\t\tinstallEditPolicy(";
  protected final String TEXT_44 = ".DIRECT_EDIT_ROLE," + NL + "\t\t\t\tnew ";
  protected final String TEXT_45 = "() {" + NL + "\t\t\t\t\tprotected void showCurrentEditValue(";
  protected final String TEXT_46 = " request) {" + NL + "\t\t\t\t\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\t\t\t\t\tgetLabel().setText(value);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprotected ";
  protected final String TEXT_47 = " getDirectEditCommand(";
  protected final String TEXT_48 = " request) {" + NL + "\t\t\t\t\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\t\t\t\t\tif (value == null) {" + NL + "\t\t\t\t\t\t\t//Invalid value is transformed into a null by the validator." + NL + "\t\t\t\t\t\t\t//XXX: implement validator" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_49 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tfinal Object[] parseResult;" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tparseResult = new ";
  protected final String TEXT_50 = "(EDIT_PATTERN).parse(value);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_51 = ".INSTANCE;" + NL + "\t\t\t\t\t\t} catch (";
  protected final String TEXT_52 = " e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_53 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_54 = " editingDomain = ";
  protected final String TEXT_55 = ".getEditingDomain(";
  protected final String TEXT_56 = ".getDiagram().getElement());";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\tif (parseResult.length != 1) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_58 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_59 = " domainModelCommand = createDomainModelCommand(editingDomain, parseResult[0]);" + NL + "\t\t\t\t\t\treturn new ";
  protected final String TEXT_60 = "(editingDomain, domainModelCommand);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_61 = " createDomainModelCommand(";
  protected final String TEXT_62 = " editingDomain, Object value) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_63 = " element = ";
  protected final String TEXT_64 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_65 = " feature = (";
  protected final String TEXT_66 = ") ";
  protected final String TEXT_67 = ".eINSTANCE.get";
  protected final String TEXT_68 = "();" + NL + "\t\t\t\t\t\tObject valueToSet;" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalueToSet = ";
  protected final String TEXT_69 = ".parseValue(feature, value);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_70 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_71 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_72 = " result = new ";
  protected final String TEXT_73 = "();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_74 = " values = new ";
  protected final String TEXT_75 = "();" + NL + "\t\t\t\t\t\tvalues.addAll(element.get";
  protected final String TEXT_76 = "());" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_77 = ".create(editingDomain, element, feature, values));" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_78 = ".create(editingDomain, element, feature, valueToSet));" + NL + "\t\t\t\t\t\treturn result;";
  protected final String TEXT_79 = NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_80 = ".create(editingDomain, element, feature, valueToSet);";
  protected final String TEXT_81 = NL + "\t\t\t\t\t}";
  protected final String TEXT_82 = NL + "\t\t\t\t\t\tif (parseResult.length != ";
  protected final String TEXT_83 = ") {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_84 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_85 = " domainModelCommand = createDomainModelCommand(editingDomain, parseResult);" + NL + "\t\t\t\t\t\treturn new ";
  protected final String TEXT_86 = "(editingDomain, domainModelCommand);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_87 = " createDomainModelCommand(";
  protected final String TEXT_88 = " editingDomain, Object[] values) {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_89 = " element = ";
  protected final String TEXT_90 = ";" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_91 = " result = new ";
  protected final String TEXT_92 = "();" + NL + "\t\t\t\t\t\tObject valueToSet;";
  protected final String TEXT_93 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_94 = " ";
  protected final String TEXT_95 = "feature = (";
  protected final String TEXT_96 = ") ";
  protected final String TEXT_97 = ".eINSTANCE.get";
  protected final String TEXT_98 = "();" + NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\tvalueToSet = ";
  protected final String TEXT_99 = ".parseValue(feature, values[";
  protected final String TEXT_100 = "]);" + NL + "\t\t\t\t\t\t} catch (IllegalArgumentException e) {" + NL + "\t\t\t\t\t\t\treturn ";
  protected final String TEXT_101 = ".INSTANCE;" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_102 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_103 = " ";
  protected final String TEXT_104 = "values = new ";
  protected final String TEXT_105 = "();" + NL + "\t\t\t\t\t\tvalues.addAll(element.get";
  protected final String TEXT_106 = "());" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_107 = ".create(editingDomain, element, feature, values));" + NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_108 = ".create(editingDomain, element, feature, valueToSet));";
  protected final String TEXT_109 = NL + "\t\t\t\t\t\tresult.append(";
  protected final String TEXT_110 = ".create(editingDomain, element, feature, valueToSet));";
  protected final String TEXT_111 = NL + "\t\t\t\t\t\treturn result;" + NL + "\t\t\t\t\t}";
  protected final String TEXT_112 = NL + "\t\t\t\t});";
  protected final String TEXT_113 = NL;
  protected final String TEXT_114 = "\t\tinstallEditPolicy(";
  protected final String TEXT_115 = ".COMPONENT_ROLE, new ";
  protected final String TEXT_116 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_117 = " createDeleteCommand(";
  protected final String TEXT_118 = " deleteRequest) {" + NL + "\t\t\t\t";
  protected final String TEXT_119 = " editingDomain = ";
  protected final String TEXT_120 = ".getEditingDomain(getDiagramNode().getDiagram().getElement());" + NL + "\t\t\t\t";
  protected final String TEXT_121 = " cc = new ";
  protected final String TEXT_122 = "();" + NL + "\t\t\t\tcc.append(getDomainModelRemoveCommand(editingDomain));" + NL + "\t\t\t\tcc.append(";
  protected final String TEXT_123 = ".create(editingDomain, getDiagramNode()));" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_124 = "(editingDomain, cc);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprivate org.eclipse.emf.common.command.Command getDomainModelRemoveCommand(";
  protected final String TEXT_125 = " editingDomain) {";
  protected final String TEXT_126 = NL + "\t\t\t\t";
  protected final String TEXT_127 = " result = new ";
  protected final String TEXT_128 = "();";
  protected final String TEXT_129 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_130 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_131 = ".eINSTANCE.get";
  protected final String TEXT_132 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_133 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_134 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_135 = ".eINSTANCE.get";
  protected final String TEXT_136 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_137 = ".UNSET_VALUE));";
  protected final String TEXT_138 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_139 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_140 = ".eINSTANCE.get";
  protected final String TEXT_141 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement()));";
  protected final String TEXT_142 = NL + "\t\t\t\tresult.append(";
  protected final String TEXT_143 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_144 = ".eINSTANCE.get";
  protected final String TEXT_145 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_146 = ".UNSET_VALUE));";
  protected final String TEXT_147 = NL + "\t\t\t\treturn result;";
  protected final String TEXT_148 = NL + "\t\t\t\treturn ";
  protected final String TEXT_149 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_150 = ".eINSTANCE.get";
  protected final String TEXT_151 = "()," + NL + "\t\t\t\t\tgetDiagramNode().getElement());";
  protected final String TEXT_152 = NL + "\t\t\t\treturn ";
  protected final String TEXT_153 = ".create(" + NL + "\t\t\t\t\teditingDomain, " + NL + "\t\t\t\t\tgetDiagramNode().getElement().eContainer(), ";
  protected final String TEXT_154 = ".eINSTANCE.get";
  protected final String TEXT_155 = "()," + NL + "\t\t\t\t\t";
  protected final String TEXT_156 = ".UNSET_VALUE);";
  protected final String TEXT_157 = NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_158 = NL + "\t}" + NL;
  protected final String TEXT_159 = NL;
  protected final String TEXT_160 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void performRequest(";
  protected final String TEXT_161 = " req) {" + NL + "\t\tif (";
  protected final String TEXT_162 = ".REQ_DIRECT_EDIT == req.getType()) {" + NL + "\t\t\tperformDirectEdit();" + NL + "\t\t} else {" + NL + "\t\t\tsuper.performRequest(req);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_163 = " getManager() {" + NL + "\t\tif (manager == null) {" + NL + "\t\t\tmanager = new ";
  protected final String TEXT_164 = "(this, ";
  protected final String TEXT_165 = ".class, new ";
  protected final String TEXT_166 = "() {" + NL + "\t\t\t\tpublic void relocate(";
  protected final String TEXT_167 = " celleditor) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_168 = " rect = getLabel().getTextBounds();" + NL + "\t\t\t\t\tgetLabel().translateToAbsolute(rect);" + NL + "\t\t\t\t\tcelleditor.getControl().setBounds(rect.x, rect.y, rect.width, rect.height);" + NL + "\t\t\t\t}" + NL + "\t\t\t}) {" + NL + "\t\t\t\tprotected void initCellEditor() {" + NL + "\t\t\t\t\tgetCellEditor().setValue(getLabelEditText());" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t}" + NL + "\t\treturn manager;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void performDirectEdit() {" + NL + "\t\tgetManager().show();" + NL + "\t}" + NL;
  protected final String TEXT_169 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getModelChildren() {" + NL + "\t\treturn ((View)getModel()).getVisibleChildren();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getModelSourceConnections() {" + NL + "\t\treturn ((View)getModel()).getSourceEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getModelTargetConnections() {" + NL + "\t\treturn ((View)getModel()).getTargetEdges();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisuals() {" + NL + "\t\tsuper.refreshVisuals();" + NL + "\t\trefreshLabel();" + NL + "\t\trefreshFont();" + NL + "\t\trefreshFontColor();" + NL + "\t\trefreshVisibility();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshLabel() {" + NL + "\t\tgetLabel().setText(getLabelText());" + NL + "\t\tgetLabel().setIcon(getLabelIcon());" + NL + "\t}";
  protected final String TEXT_170 = NL;
  protected final String TEXT_171 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final String VIEW_PATTERN = \"";
  protected final String TEXT_172 = "\";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final String EDIT_PATTERN = \"";
  protected final String TEXT_173 = "\";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelText() {" + NL + "\t\t";
  protected final String TEXT_174 = " element = ";
  protected final String TEXT_175 = ";" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn defaultText;" + NL + "\t\t}" + NL + "\t\treturn buildTextByPattern(element, VIEW_PATTERN);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getLabelEditText() {" + NL + "\t\t";
  protected final String TEXT_176 = " element = ";
  protected final String TEXT_177 = ";" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn defaultText;" + NL + "\t\t}" + NL + "\t\treturn buildTextByPattern(element, EDIT_PATTERN);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String buildTextByPattern(";
  protected final String TEXT_178 = " element, String pattern) {";
  protected final String TEXT_179 = NL + "\t\tif (";
  protected final String TEXT_180 = " == null) {" + NL + "\t\t\treturn defaultText;" + NL + "\t\t}";
  protected final String TEXT_181 = NL + "\t\treturn ";
  protected final String TEXT_182 = ".format(pattern, new Object[] {";
  protected final String TEXT_183 = NL + "\t\t\tnew ";
  protected final String TEXT_184 = "(";
  protected final String TEXT_185 = ")";
  protected final String TEXT_186 = NL + "\t\t});";
  protected final String TEXT_187 = NL + "\t\treturn ";
  protected final String TEXT_188 = ".format(pattern, new Object[] {";
  protected final String TEXT_189 = NL + "\t\t\tnew ";
  protected final String TEXT_190 = "(";
  protected final String TEXT_191 = ")";
  protected final String TEXT_192 = ",";
  protected final String TEXT_193 = NL + "\t\t});";
  protected final String TEXT_194 = NL + "\t\t//XXX: unexpected model facet." + NL + "\t\treturn defaultText;";
  protected final String TEXT_195 = NL + "\t}";
  protected final String TEXT_196 = NL;
  protected final String TEXT_197 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFont() {";
  protected final String TEXT_198 = NL + "\t\t";
  protected final String TEXT_199 = " style =" + NL + "\t\t\t(";
  protected final String TEXT_200 = ") ";
  protected final String TEXT_201 = ".getStyle(" + NL + "\t\t\t\t";
  protected final String TEXT_202 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_203 = " toDispose = createdFont;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tString fontName = style.getFontName();" + NL + "\t\t\tint fontHeight = style.getFontHeight();" + NL + "\t\t\tint fontStyle = ";
  protected final String TEXT_204 = ".NORMAL;" + NL + "\t\t\tif (style.isBold()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_205 = ".BOLD;" + NL + "\t\t\t}" + NL + "\t\t\tif (style.isItalic()) {" + NL + "\t\t\t\tfontStyle |= ";
  protected final String TEXT_206 = ".ITALIC;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_207 = " currentFont = getFigure().getFont();" + NL + "\t\t\tif (currentFont != null) {" + NL + "\t\t\t\t";
  protected final String TEXT_208 = " currentFontData = currentFont.getFontData()[0];" + NL + "\t\t\t\tif (currentFontData.getName().equals(fontName) && currentFontData.getHeight() == fontHeight && currentFontData.getStyle() == fontStyle) {" + NL + "\t\t\t\t\treturn;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFont = new ";
  protected final String TEXT_209 = "(null, fontName, fontHeight, fontStyle);" + NL + "\t\t\tgetFigure().setFont(createdFont);" + NL + "\t\t} else {" + NL + "\t\t\t//revert to the default font" + NL + "\t\t\tgetFigure().setFont(getViewer().getControl().getFont());" + NL + "\t\t\tcreatedFont = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}";
  protected final String TEXT_210 = "\t" + NL + "\t}";
  protected final String TEXT_211 = NL + NL + "\t/**" + NL + "\t * The font (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned)." + NL + "\t * Whenever another non-default font is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_212 = " createdFont;";
  protected final String TEXT_213 = "\t";
  protected final String TEXT_214 = NL;
  protected final String TEXT_215 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFontColor() {" + NL + "\t\t";
  protected final String TEXT_216 = " style = (";
  protected final String TEXT_217 = ")  ";
  protected final String TEXT_218 = ".getStyle(";
  protected final String TEXT_219 = ".eINSTANCE.getFontStyle());" + NL + "\t\t";
  protected final String TEXT_220 = " toDispose = createdFontColor;" + NL + "\t\tif (style != null) {" + NL + "\t\t\tint fontColor = style.getFontColor();" + NL + "\t\t\tint red = fontColor & 0x000000FF;" + NL + "\t\t\tint green = (fontColor & 0x0000FF00) >> 8;" + NL + "\t\t\tint blue = (fontColor & 0x00FF0000) >> 16;" + NL + "\t\t\t";
  protected final String TEXT_221 = " currentColor = getLabel().getForegroundColor();" + NL + "\t\t\tif (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tcreatedFontColor = new ";
  protected final String TEXT_222 = "(null, red, green, blue);" + NL + "\t\t\tgetFigure().setForegroundColor(createdFontColor);" + NL + "\t\t} else {" + NL + "\t\t\tgetFigure().setForegroundColor(getViewer().getControl().getForeground());" + NL + "\t\t\tcreatedFontColor = null;" + NL + "\t\t}" + NL + "\t\tif (toDispose != null) {" + NL + "\t\t\ttoDispose.dispose();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * The color (created by {@link #refreshFontColor()}) currently assigned to the label." + NL + "\t * Whenever another color is assigned to it, it is safe to dispose the previous one." + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_223 = " createdFontColor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_224 = " getLabelIcon() {";
  protected final String TEXT_225 = NL + "\t\t";
  protected final String TEXT_226 = " imageDescriptor = ";
  protected final String TEXT_227 = ".getInstance().getItemImageDescriptor(getDiagramNode().getElement());" + NL + "\t\tif (imageDescriptor != null) {" + NL + "\t\t\treturn imageDescriptor.createImage();" + NL + "\t\t}";
  protected final String TEXT_228 = NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshVisibility() {" + NL + "\t\tboolean isVisible = getDiagramNode().isVisible();" + NL + "\t\tboolean wasVisible = getFigure().isVisible();" + NL + "\t\tif (isVisible == wasVisible) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (!isVisible && (getSelected() != SELECTED_NONE)) {" + NL + "\t\t\tgetViewer().deselect(this);" + NL + "\t\t}" + NL + "" + NL + "\t\tgetFigure().setVisible(isVisible);" + NL + "\t\tgetFigure().revalidate();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object getAdapter(Class key) {";
  protected final String TEXT_229 = NL + "\t\treturn super.getAdapter(key);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tgetDiagramNode().getElement().eAdapters().add(domainModelRefresher);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {" + NL + "\t\tgetDiagramNode().getElement().eAdapters().remove(domainModelRefresher);" + NL + "\t\tsuper.deactivate();" + NL + "\t}" + NL;
  protected final String TEXT_230 = NL;
  protected final String TEXT_231 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_232 = " domainModelRefresher = new ";
  protected final String TEXT_233 = "(this);" + NL;
  protected final String TEXT_234 = NL;
  protected final String TEXT_235 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_236 = " structuralFeatures2Refresher;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(";
  protected final String TEXT_237 = " feature, ";
  protected final String TEXT_238 = " msg) {" + NL + "\t\tif (structuralFeatures2Refresher == null) {" + NL + "\t\t\tcreateRefreshers();" + NL + "\t\t}" + NL + "\t\treturn (Refresher) structuralFeatures2Refresher.get(feature);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createRefreshers() {" + NL + "\t\tstructuralFeatures2Refresher = new HashMap();";
  protected final String TEXT_239 = NL;
  protected final String TEXT_240 = "\t\tRefresher childrenRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshChildren();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_241 = ".eINSTANCE.getView_PersistedChildren(), childrenRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_242 = ".eINSTANCE.getView_TransientChildren(), childrenRefresher);";
  protected final String TEXT_243 = NL;
  protected final String TEXT_244 = "\t\tRefresher visibilityRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshVisibility();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_245 = ".eINSTANCE.getView_Visible(), visibilityRefresher);" + NL + "\t\tRefresher labelRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshLabel();" + NL + "\t\t\t}" + NL + "\t\t};";
  protected final String TEXT_246 = NL + "\t\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_247 = ".eINSTANCE.get";
  protected final String TEXT_248 = "(), labelRefresher);";
  protected final String TEXT_249 = NL + "\t\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_250 = ".eINSTANCE.get";
  protected final String TEXT_251 = "(), labelRefresher);";
  protected final String TEXT_252 = NL;
  protected final String TEXT_253 = "\t\tRefresher fontRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshFont();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_254 = ".eINSTANCE.getFontStyle_FontHeight(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_255 = ".eINSTANCE.getFontStyle_FontName(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_256 = ".eINSTANCE.getFontStyle_Bold(), fontRefresher);" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_257 = ".eINSTANCE.getFontStyle_Italic(), fontRefresher);" + NL + "\t\t";
  protected final String TEXT_258 = NL;
  protected final String TEXT_259 = "\t\tRefresher fontColorRefresher = new Refresher() {" + NL + "\t\t\tpublic void refresh() {" + NL + "\t\t\t\trefreshFontColor();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\tstructuralFeatures2Refresher.put(";
  protected final String TEXT_260 = ".eINSTANCE.getFontStyle_FontColor(), fontColorRefresher);" + NL + "\t}" + NL;
  protected final String TEXT_261 = NL;
  protected final String TEXT_262 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_263 = " createFigure() {" + NL + "\t\t// Parent should assign one using ";
  protected final String TEXT_264 = " method" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_265 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_266 = " createLabel() {";
  protected final String TEXT_267 = NL + "\t\treturn new ";
  protected final String TEXT_268 = "();";
  protected final String TEXT_269 = NL + "\t\treturn ";
  protected final String TEXT_270 = ";";
  protected final String TEXT_271 = NL + "\t\treturn new ";
  protected final String TEXT_272 = "();";
  protected final String TEXT_273 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_274 = " createFigure() {" + NL + "\t\t";
  protected final String TEXT_275 = " label = createLabel();";
  protected final String TEXT_276 = NL + "\t\tdefaultText = label.getText();";
  protected final String TEXT_277 = NL + "\t\tdefaultText = \"\";\t//$NON-NLS-1$";
  protected final String TEXT_278 = NL + "\t\treturn label;" + NL + "\t}";
  protected final String TEXT_279 = NL + NL + "\t/**";
  protected final String TEXT_280 = NL + "\t * TODO: reimplement, since the figure used by this editpart is not a Label.";
  protected final String TEXT_281 = NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_282 = " getLabel() {" + NL + "\t\treturn (";
  protected final String TEXT_283 = ") getFigure();" + NL + "\t}" + NL;
  protected final String TEXT_284 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void ";
  protected final String TEXT_285 = "(";
  protected final String TEXT_286 = " figure) {" + NL + "\t\tunregisterVisuals();" + NL + "\t\tsetFigure(figure);";
  protected final String TEXT_287 = NL + "\t\tdefaultText = figure.getText();";
  protected final String TEXT_288 = NL + "\t\tdefaultText = \"\";\t//$NON-NLS-1$";
  protected final String TEXT_289 = NL + "\t\tregisterVisuals();" + NL + "\t\trefreshVisuals();" + NL + "\t}" + NL;
  protected final String TEXT_290 = NL;
  protected final String TEXT_291 = NL;
  protected final String TEXT_292 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MapModeWorkaround {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int DPtoLP(int dp) {" + NL + "\t\t\treturn dp;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static MapModeWorkaround INSTANCE = new MapModeWorkaround();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MapModeWorkaround getMapMode() {" + NL + "\t\treturn MapModeWorkaround.INSTANCE;" + NL + "\t}";
  protected final String TEXT_293 = NL + "}";
  protected final String TEXT_294 = NL;

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

importManager.addImport("org.eclipse.gef.EditPolicy");
importManager.addImport("org.eclipse.gef.Request");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.addImport("org.eclipse.gmf.runtime.notation.NotationPackage");
importManager.addImport("java.util.List");

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_21);
    stringBuffer.append(genChildNode.getEditPartClassName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.AbstractGraphicalEditPart"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart"));
    stringBuffer.append(TEXT_24);
    {
GenCommonBase genCommonBase = genChildNode;
    stringBuffer.append(TEXT_25);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(TEXT_29);
    
if (!isReadOnly) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_31);
    
}

    stringBuffer.append(TEXT_32);
    stringBuffer.append(genChildNode.getEditPartClassName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_41);
    
	String resolvedSemanticElement = "(" + importManager.getImportedName(genHost.getDomainMetaClass().getQualifiedInterfaceName()) + ") getDiagramNode().getElement()";
	final String primaryView = "getDiagramNode()";

    
if (!isReadOnly) {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.DirectEditPolicy"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.DirectEditRequest"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("java.text.ParseException"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_56);
    
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	GenFeature featureToSet = ((FeatureLabelModelFacet)labelModelFacet).getMetaFeature();
	EStructuralFeature ecoreFeature = featureToSet.getEcoreFeature();

    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(featureToSet.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(featureToSet.getFeatureAccessorName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.ParserUtil"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_70);
    
	if (ecoreFeature.isMany()) {

    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.EList"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(featureToSet.getAccessorName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_78);
    
	} else {

    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_80);
    
	}

    stringBuffer.append(TEXT_81);
    
} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
	CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;
	List metaFeatures = compositeFeatureLabelModelFacet.getMetaFeatures();

    stringBuffer.append(TEXT_82);
    stringBuffer.append(metaFeatures.size());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.UnexecutableCommand"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_92);
    
	boolean haveDeclaredValues = false;
	for(int i = 0; i < metaFeatures.size(); i++) {
		GenFeature nextFeatureToSet = (GenFeature) metaFeatures.get(i);
		EStructuralFeature nextEcoreFeature = nextFeatureToSet.getEcoreFeature();

    stringBuffer.append(TEXT_93);
    if (i == 0) {
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_94);
    }
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAttribute"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName(nextFeatureToSet.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(nextFeatureToSet.getFeatureAccessorName());
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.services.ParserUtil"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.UnexecutableCommand"));
    stringBuffer.append(TEXT_101);
    
		if (nextEcoreFeature.isMany()) {

    stringBuffer.append(TEXT_102);
    if (!haveDeclaredValues) { haveDeclaredValues = true;
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.EList"));
    stringBuffer.append(TEXT_103);
    }
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.BasicEList"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(nextFeatureToSet.getAccessorName());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.AddCommand"));
    stringBuffer.append(TEXT_108);
    
		} else {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_110);
    
		}

    
	}

    stringBuffer.append(TEXT_111);
    
}

    stringBuffer.append(TEXT_112);
    
}

    stringBuffer.append(TEXT_113);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.ComponentEditPolicy"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.GroupRequest"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_125);
    
{
TypeModelFacet facet = genNode.getModelFacet();
GenFeature childFeature = facet.getChildMetaFeature();
GenFeature containmentFeature = facet.getContainmentMetaFeature();
if (childFeature != null && childFeature != containmentFeature && !childFeature.isDerived()) {

    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_128);
    
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_132);
    
	} else {

    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_137);
    
	}

    
	if (childFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_141);
    
	} else {

    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName(childFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(childFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_146);
    
	}

    stringBuffer.append(TEXT_147);
    
} else {
	if (containmentFeature.getEcoreFeature().isMany()) {

    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.RemoveCommand"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_151);
    
	} else {

    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName(containmentFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(containmentFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.command.SetCommand"));
    stringBuffer.append(TEXT_156);
    
	}
}

    stringBuffer.append(TEXT_157);
    
}	/*restrict local vars used in component edit policy*/

    stringBuffer.append(TEXT_158);
    
if (!isReadOnly) {

    stringBuffer.append(TEXT_159);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.DirectEditManager"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.TextCellEditor"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.tools.CellEditorLocator"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.CellEditor"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_168);
    
}

    stringBuffer.append(TEXT_169);
    stringBuffer.append(TEXT_170);
    
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

    stringBuffer.append(TEXT_171);
    stringBuffer.append(viewPattern);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(editPattern);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(resolvedSemanticElement);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName(underlyingMetaClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_178);
    
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	FeatureLabelModelFacet featureLabelModelFacet = (FeatureLabelModelFacet) labelModelFacet;
	GenFeature feature = featureLabelModelFacet.getMetaFeature();
	if (!feature.isPrimitiveType()) {

    stringBuffer.append(TEXT_179);
    myFeatureGetAccessorHelper.appendFeatureValueGetter("element", feature, underlyingMetaClass, false);
    stringBuffer.append(TEXT_180);
    
	}

    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_182);
    
		if (feature.isPrimitiveType()) {

    stringBuffer.append(TEXT_183);
    stringBuffer.append(primitiveTypeToWrapperClassName.get(feature.getTypeGenClassifier().getEcoreClassifier().getInstanceClass()));
    stringBuffer.append(TEXT_184);
    
		}
		myFeatureGetAccessorHelper.appendFeatureValueGetter("element", feature, underlyingMetaClass, false);
		if (feature.isPrimitiveType()) {

    stringBuffer.append(TEXT_185);
    
		}

    stringBuffer.append(TEXT_186);
    
} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
	CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;

    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("java.text.MessageFormat"));
    stringBuffer.append(TEXT_188);
    
	for(Iterator it = compositeFeatureLabelModelFacet.getMetaFeatures().iterator(); it.hasNext(); ) {
		GenFeature next = (GenFeature) it.next();
		if (next.isPrimitiveType()) {

    stringBuffer.append(TEXT_189);
    stringBuffer.append(primitiveTypeToWrapperClassName.get(next.getTypeGenClassifier().getEcoreClassifier().getInstanceClass()));
    stringBuffer.append(TEXT_190);
    
		}
		myFeatureGetAccessorHelper.appendFeatureValueGetter("element", next, underlyingMetaClass, false);
		if (next.isPrimitiveType()) {

    stringBuffer.append(TEXT_191);
    
		}
		if (it.hasNext()) {
    stringBuffer.append(TEXT_192);
    }
    
	}

    stringBuffer.append(TEXT_193);
    
} else {

    stringBuffer.append(TEXT_194);
    
}

    stringBuffer.append(TEXT_195);
    stringBuffer.append(TEXT_196);
    
boolean isFixedFontSetInFigure;
{
	StyleAttributes styleAttributes = (genElement.getViewmap() == null) ? null : (StyleAttributes)genElement.getViewmap().find(StyleAttributes.class);
	isFixedFontSetInFigure = styleAttributes != null && styleAttributes.isFixedFont();
}

    stringBuffer.append(TEXT_197);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_198);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_204);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_205);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.SWT"));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.FontData"));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_209);
    
}

    stringBuffer.append(TEXT_210);
    
if (!isFixedFontSetInFigure) {

    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Font"));
    stringBuffer.append(TEXT_212);
    
}

    stringBuffer.append(TEXT_213);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(TEXT_215);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_216);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.FontStyle"));
    stringBuffer.append(TEXT_217);
    stringBuffer.append(primaryView);
    stringBuffer.append(TEXT_218);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_219);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_220);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_221);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_224);
    
if (genChildNode.isLabelElementIcon()) {

    stringBuffer.append(TEXT_225);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_226);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_227);
    
}

    stringBuffer.append(TEXT_228);
    /*@ include file="adapters/propertySource.javajetinc"*/
    stringBuffer.append(TEXT_229);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_232);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter"));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.notify.Notification"));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(TEXT_239);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_241);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_245);
    
if (labelModelFacet instanceof FeatureLabelModelFacet) {
	GenFeature feature = ((FeatureLabelModelFacet)labelModelFacet).getMetaFeature();

    stringBuffer.append(TEXT_246);
    stringBuffer.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_247);
    stringBuffer.append(feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_248);
    
} else if (labelModelFacet instanceof CompositeFeatureLabelModelFacet) {
	CompositeFeatureLabelModelFacet compositeFeatureLabelModelFacet = (CompositeFeatureLabelModelFacet) labelModelFacet;
	for(Iterator it = compositeFeatureLabelModelFacet.getMetaFeatures().iterator(); it.hasNext(); ) {
		GenFeature next = (GenFeature) it.next();

    stringBuffer.append(TEXT_249);
    stringBuffer.append(importManager.getImportedName(next.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(next.getFeatureAccessorName());
    stringBuffer.append(TEXT_251);
    
	}
}

    stringBuffer.append(TEXT_252);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_254);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_256);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_257);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(TEXT_259);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_260);
    
final Viewmap viewmap = genChildNode.getViewmap();

    stringBuffer.append(TEXT_261);
    
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

    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_263);
    stringBuffer.append((parentAssignedViewmap.getSetterName() == null ? "setLabel" : parentAssignedViewmap.getSetterName()));
    stringBuffer.append(TEXT_264);
    } else { 
    stringBuffer.append(TEXT_265);
    stringBuffer.append(figureImportedName);
    stringBuffer.append(TEXT_266);
    
if (viewmap instanceof FigureViewmap) {

    stringBuffer.append(TEXT_267);
    stringBuffer.append(figureImportedName);
    stringBuffer.append(TEXT_268);
    } // instanceof FigureViewmap
 else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_269);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_270);
    } // instanceof SnippetViewmap; FIXME : obtain figure class name to generate getter
 else if (viewmap instanceof InnerClassViewmap) {

    stringBuffer.append(TEXT_271);
    stringBuffer.append(figureImportedName);
    stringBuffer.append(TEXT_272);
    }
    stringBuffer.append(TEXT_273);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.IFigure"));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(figureImportedName);
    stringBuffer.append(TEXT_275);
    
if ("org.eclipse.draw2d.Label".equals(figureQualifiedClassName) || viewmap instanceof InnerClassViewmap) {

    stringBuffer.append(TEXT_276);
    
} else {

    stringBuffer.append(TEXT_277);
    
}

    stringBuffer.append(TEXT_278);
    }	/*not parent-assigned*/
    stringBuffer.append(TEXT_279);
    
if (!"org.eclipse.draw2d.Label".equals(figureQualifiedClassName) && viewmap instanceof InnerClassViewmap==false) {

    stringBuffer.append(TEXT_280);
    
}

    stringBuffer.append(TEXT_281);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_282);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Label"));
    stringBuffer.append(TEXT_283);
    
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

    stringBuffer.append(TEXT_284);
    stringBuffer.append(labelSetterName);
    stringBuffer.append(TEXT_285);
    stringBuffer.append(importManager.getImportedName(labelFigureClassName));
    stringBuffer.append(TEXT_286);
    
if ("org.eclipse.draw2d.Label".equals(labelFigureClassName)) {

    stringBuffer.append(TEXT_287);
    
} else {

    stringBuffer.append(TEXT_288);
    
}

    stringBuffer.append(TEXT_289);
    
if (viewmap instanceof InnerClassViewmap) {
	String classBody = ((InnerClassViewmap) viewmap).getClassBody();

    stringBuffer.append(TEXT_290);
    stringBuffer.append(classBody);
    stringBuffer.append(TEXT_291);
    
if (classBody.indexOf("DPtoLP") != -1) {

    stringBuffer.append(TEXT_292);
    
}

    
}

    stringBuffer.append(TEXT_293);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_294);
    return stringBuffer.toString();
  }
}
