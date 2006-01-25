package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import java.util.*;

public class ShapeGenerator
{
  protected static String nl;
  public static synchronized ShapeGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ShapeGenerator result = new ShapeGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_2 = " extends ";
  protected final String TEXT_3 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_4 = "() {";
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = ".setFill(";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "\t\t";
  protected final String TEXT_10 = ".setOutline(";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\t\t";
  protected final String TEXT_13 = ".setLineWidth(";
  protected final String TEXT_14 = ");";
  protected final String TEXT_15 = NL + "\t\t";
  protected final String TEXT_16 = ".setLineStyle(org.eclipse.draw2d.Graphics.";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "\t\t";
  protected final String TEXT_19 = ".setFillXOR(";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\t";
  protected final String TEXT_22 = ".setOutlineXOR(";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "\t\t";
  protected final String TEXT_25 = ".addPoint(new org.eclipse.draw2d.geometry.Point(";
  protected final String TEXT_26 = ", ";
  protected final String TEXT_27 = "));";
  protected final String TEXT_28 = NL + "\t\t";
  protected final String TEXT_29 = ".setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(";
  protected final String TEXT_30 = "), getMapMode().DPtoLP(";
  protected final String TEXT_31 = ")));";
  protected final String TEXT_32 = NL + "\t\t";
  protected final String TEXT_33 = ".setForegroundColor(";
  protected final String TEXT_34 = "new Color(null, ";
  protected final String TEXT_35 = ", ";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = ")";
  protected final String TEXT_38 = "ColorConstants.";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = NL + "\t\t";
  protected final String TEXT_41 = ".setBackgroundColor(";
  protected final String TEXT_42 = "new Color(null, ";
  protected final String TEXT_43 = ", ";
  protected final String TEXT_44 = ", ";
  protected final String TEXT_45 = ")";
  protected final String TEXT_46 = "ColorConstants.";
  protected final String TEXT_47 = ");";
  protected final String TEXT_48 = NL + "\t\t";
  protected final String TEXT_49 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_50 = "), getMapMode().DPtoLP(";
  protected final String TEXT_51 = "));";
  protected final String TEXT_52 = NL + "\t\tsetFigure";
  protected final String TEXT_53 = "(createFigure";
  protected final String TEXT_54 = "());" + NL + "\t\tadd(getFigure";
  protected final String TEXT_55 = "());";
  protected final String TEXT_56 = NL + "\t}" + NL;
  protected final String TEXT_57 = NL + NL + "\tprivate IFigure f";
  protected final String TEXT_58 = "; " + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getFigure";
  protected final String TEXT_59 = "() {" + NL + "\t\treturn f";
  protected final String TEXT_60 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setFigure";
  protected final String TEXT_61 = "(IFigure figure) {" + NL + "\t\tf";
  protected final String TEXT_62 = " = figure;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure createFigure";
  protected final String TEXT_63 = "() {";
  protected final String TEXT_64 = NL;
  protected final String TEXT_65 = NL + "\t\t";
  protected final String TEXT_66 = " ";
  protected final String TEXT_67 = " = new ";
  protected final String TEXT_68 = "();";
  protected final String TEXT_69 = NL;
  protected final String TEXT_70 = NL + "\t\t";
  protected final String TEXT_71 = ".setForegroundColor(";
  protected final String TEXT_72 = "new Color(null, ";
  protected final String TEXT_73 = ", ";
  protected final String TEXT_74 = ", ";
  protected final String TEXT_75 = ")";
  protected final String TEXT_76 = "ColorConstants.";
  protected final String TEXT_77 = ");";
  protected final String TEXT_78 = NL + "\t\t";
  protected final String TEXT_79 = ".setBackgroundColor(";
  protected final String TEXT_80 = "new Color(null, ";
  protected final String TEXT_81 = ", ";
  protected final String TEXT_82 = ", ";
  protected final String TEXT_83 = ")";
  protected final String TEXT_84 = "ColorConstants.";
  protected final String TEXT_85 = ");";
  protected final String TEXT_86 = NL + "\t\t";
  protected final String TEXT_87 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_88 = "), getMapMode().DPtoLP(";
  protected final String TEXT_89 = "));";
  protected final String TEXT_90 = NL + "\t\t";
  protected final String TEXT_91 = " ";
  protected final String TEXT_92 = " = new ";
  protected final String TEXT_93 = "();";
  protected final String TEXT_94 = NL;
  protected final String TEXT_95 = NL + "\t\t";
  protected final String TEXT_96 = ".setFill(";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "\t\t";
  protected final String TEXT_99 = ".setOutline(";
  protected final String TEXT_100 = ");";
  protected final String TEXT_101 = NL + "\t\t";
  protected final String TEXT_102 = ".setLineWidth(";
  protected final String TEXT_103 = ");";
  protected final String TEXT_104 = NL + "\t\t";
  protected final String TEXT_105 = ".setLineStyle(org.eclipse.draw2d.Graphics.";
  protected final String TEXT_106 = ");";
  protected final String TEXT_107 = NL + "\t\t";
  protected final String TEXT_108 = ".setFillXOR(";
  protected final String TEXT_109 = ");";
  protected final String TEXT_110 = NL + "\t\t";
  protected final String TEXT_111 = ".setOutlineXOR(";
  protected final String TEXT_112 = ");";
  protected final String TEXT_113 = NL + "\t\t";
  protected final String TEXT_114 = ".addPoint(new org.eclipse.draw2d.geometry.Point(";
  protected final String TEXT_115 = ", ";
  protected final String TEXT_116 = "));";
  protected final String TEXT_117 = NL + "\t\t";
  protected final String TEXT_118 = ".setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(";
  protected final String TEXT_119 = "), getMapMode().DPtoLP(";
  protected final String TEXT_120 = ")));";
  protected final String TEXT_121 = NL + "\t\t";
  protected final String TEXT_122 = ".setForegroundColor(";
  protected final String TEXT_123 = "new Color(null, ";
  protected final String TEXT_124 = ", ";
  protected final String TEXT_125 = ", ";
  protected final String TEXT_126 = ")";
  protected final String TEXT_127 = "ColorConstants.";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "\t\t";
  protected final String TEXT_130 = ".setBackgroundColor(";
  protected final String TEXT_131 = "new Color(null, ";
  protected final String TEXT_132 = ", ";
  protected final String TEXT_133 = ", ";
  protected final String TEXT_134 = ")";
  protected final String TEXT_135 = "ColorConstants.";
  protected final String TEXT_136 = ");";
  protected final String TEXT_137 = NL + "\t\t";
  protected final String TEXT_138 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_139 = "), getMapMode().DPtoLP(";
  protected final String TEXT_140 = "));";
  protected final String TEXT_141 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_142 = " = new ";
  protected final String TEXT_143 = "();";
  protected final String TEXT_144 = NL + "\t\t";
  protected final String TEXT_145 = " ";
  protected final String TEXT_146 = " = new ";
  protected final String TEXT_147 = "();" + NL + "\t\t";
  protected final String TEXT_148 = ".setText(\"";
  protected final String TEXT_149 = "\");";
  protected final String TEXT_150 = NL;
  protected final String TEXT_151 = NL + "\t\t";
  protected final String TEXT_152 = ".setForegroundColor(";
  protected final String TEXT_153 = "new Color(null, ";
  protected final String TEXT_154 = ", ";
  protected final String TEXT_155 = ", ";
  protected final String TEXT_156 = ")";
  protected final String TEXT_157 = "ColorConstants.";
  protected final String TEXT_158 = ");";
  protected final String TEXT_159 = NL + "\t\t";
  protected final String TEXT_160 = ".setBackgroundColor(";
  protected final String TEXT_161 = "new Color(null, ";
  protected final String TEXT_162 = ", ";
  protected final String TEXT_163 = ", ";
  protected final String TEXT_164 = ")";
  protected final String TEXT_165 = "ColorConstants.";
  protected final String TEXT_166 = ");";
  protected final String TEXT_167 = NL + "\t\t";
  protected final String TEXT_168 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_169 = "), getMapMode().DPtoLP(";
  protected final String TEXT_170 = "));";
  protected final String TEXT_171 = NL;
  protected final String TEXT_172 = NL;
  protected final String TEXT_173 = NL + "\t\t";
  protected final String TEXT_174 = " ";
  protected final String TEXT_175 = " = new ";
  protected final String TEXT_176 = "();";
  protected final String TEXT_177 = NL;
  protected final String TEXT_178 = NL + "\t\t";
  protected final String TEXT_179 = ".setForegroundColor(";
  protected final String TEXT_180 = "new Color(null, ";
  protected final String TEXT_181 = ", ";
  protected final String TEXT_182 = ", ";
  protected final String TEXT_183 = ")";
  protected final String TEXT_184 = "ColorConstants.";
  protected final String TEXT_185 = ");";
  protected final String TEXT_186 = NL + "\t\t";
  protected final String TEXT_187 = ".setBackgroundColor(";
  protected final String TEXT_188 = "new Color(null, ";
  protected final String TEXT_189 = ", ";
  protected final String TEXT_190 = ", ";
  protected final String TEXT_191 = ")";
  protected final String TEXT_192 = "ColorConstants.";
  protected final String TEXT_193 = ");";
  protected final String TEXT_194 = NL + "\t\t";
  protected final String TEXT_195 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_196 = "), getMapMode().DPtoLP(";
  protected final String TEXT_197 = "));";
  protected final String TEXT_198 = NL + "\t\t";
  protected final String TEXT_199 = " ";
  protected final String TEXT_200 = " = new ";
  protected final String TEXT_201 = "();";
  protected final String TEXT_202 = NL;
  protected final String TEXT_203 = NL + "\t\t";
  protected final String TEXT_204 = ".setFill(";
  protected final String TEXT_205 = ");";
  protected final String TEXT_206 = NL + "\t\t";
  protected final String TEXT_207 = ".setOutline(";
  protected final String TEXT_208 = ");";
  protected final String TEXT_209 = NL + "\t\t";
  protected final String TEXT_210 = ".setLineWidth(";
  protected final String TEXT_211 = ");";
  protected final String TEXT_212 = NL + "\t\t";
  protected final String TEXT_213 = ".setLineStyle(org.eclipse.draw2d.Graphics.";
  protected final String TEXT_214 = ");";
  protected final String TEXT_215 = NL + "\t\t";
  protected final String TEXT_216 = ".setFillXOR(";
  protected final String TEXT_217 = ");";
  protected final String TEXT_218 = NL + "\t\t";
  protected final String TEXT_219 = ".setOutlineXOR(";
  protected final String TEXT_220 = ");";
  protected final String TEXT_221 = NL + "\t\t";
  protected final String TEXT_222 = ".addPoint(new org.eclipse.draw2d.geometry.Point(";
  protected final String TEXT_223 = ", ";
  protected final String TEXT_224 = "));";
  protected final String TEXT_225 = NL + "\t\t";
  protected final String TEXT_226 = ".setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(";
  protected final String TEXT_227 = "), getMapMode().DPtoLP(";
  protected final String TEXT_228 = ")));";
  protected final String TEXT_229 = NL + "\t\t";
  protected final String TEXT_230 = ".setForegroundColor(";
  protected final String TEXT_231 = "new Color(null, ";
  protected final String TEXT_232 = ", ";
  protected final String TEXT_233 = ", ";
  protected final String TEXT_234 = ")";
  protected final String TEXT_235 = "ColorConstants.";
  protected final String TEXT_236 = ");";
  protected final String TEXT_237 = NL + "\t\t";
  protected final String TEXT_238 = ".setBackgroundColor(";
  protected final String TEXT_239 = "new Color(null, ";
  protected final String TEXT_240 = ", ";
  protected final String TEXT_241 = ", ";
  protected final String TEXT_242 = ")";
  protected final String TEXT_243 = "ColorConstants.";
  protected final String TEXT_244 = ");";
  protected final String TEXT_245 = NL + "\t\t";
  protected final String TEXT_246 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_247 = "), getMapMode().DPtoLP(";
  protected final String TEXT_248 = "));";
  protected final String TEXT_249 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_250 = " = new ";
  protected final String TEXT_251 = "();";
  protected final String TEXT_252 = NL + "\t\t";
  protected final String TEXT_253 = " ";
  protected final String TEXT_254 = " = new ";
  protected final String TEXT_255 = "();" + NL + "\t\t";
  protected final String TEXT_256 = ".setText(\"";
  protected final String TEXT_257 = "\");";
  protected final String TEXT_258 = NL;
  protected final String TEXT_259 = NL + "\t\t";
  protected final String TEXT_260 = ".setForegroundColor(";
  protected final String TEXT_261 = "new Color(null, ";
  protected final String TEXT_262 = ", ";
  protected final String TEXT_263 = ", ";
  protected final String TEXT_264 = ")";
  protected final String TEXT_265 = "ColorConstants.";
  protected final String TEXT_266 = ");";
  protected final String TEXT_267 = NL + "\t\t";
  protected final String TEXT_268 = ".setBackgroundColor(";
  protected final String TEXT_269 = "new Color(null, ";
  protected final String TEXT_270 = ", ";
  protected final String TEXT_271 = ", ";
  protected final String TEXT_272 = ")";
  protected final String TEXT_273 = "ColorConstants.";
  protected final String TEXT_274 = ");";
  protected final String TEXT_275 = NL + "\t\t";
  protected final String TEXT_276 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_277 = "), getMapMode().DPtoLP(";
  protected final String TEXT_278 = "));";
  protected final String TEXT_279 = NL + "\t\t";
  protected final String TEXT_280 = ".add(";
  protected final String TEXT_281 = ");";
  protected final String TEXT_282 = NL + "\t\treturn ";
  protected final String TEXT_283 = ";" + NL + "\t}" + NL;
  protected final String TEXT_284 = NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
Shape shapeFig = (Shape) argument;
final GMFGraphSwitch fqnSwitch = new FigureQualifiedNameSwitch();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(shapeFig.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(fqnSwitch.doSwitch(shapeFig));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(shapeFig.getName());
    stringBuffer.append(TEXT_4);
    
{
Shape figureInstance = shapeFig;
String figureVarName = "this";

    stringBuffer.append(TEXT_5);
    
// PERHAPS, do this with reflection?

    if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(figureInstance.isFill());
    stringBuffer.append(TEXT_8);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(figureInstance.isOutline());
    stringBuffer.append(TEXT_11);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(figureInstance.getLineWidth());
    stringBuffer.append(TEXT_14);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(figureInstance.getLineKind().getName());
    stringBuffer.append(TEXT_17);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(figureInstance.isXorFill());
    stringBuffer.append(TEXT_20);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(figureInstance.isXorOutline());
    stringBuffer.append(TEXT_23);
    } if (figureInstance instanceof Polyline && !((Polyline) figureInstance).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) figureInstance).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_24);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_27);
    }
    } else if (figureInstance instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) figureInstance;
    stringBuffer.append(TEXT_28);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_31);
    }
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_32);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_33);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_37);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_39);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_40);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_41);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_45);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_47);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_48);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_51);
    }
    
}for (Iterator it = shapeFig.getResolvedChildren().iterator(); it.hasNext();) {
		Figure next = (Figure) it.next();
    stringBuffer.append(TEXT_52);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_55);
    }
    stringBuffer.append(TEXT_56);
    
int fc = 0;
for (Iterator it = shapeFig.getResolvedChildren().iterator(); it.hasNext(); fc++) {
	Figure figure = (Figure) it.next();
    stringBuffer.append(TEXT_57);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_63);
    
String parentFigureVarName = "rv" + fc;
{ // scope
FigureMarker figureMarker = figure;
String figureVarName = parentFigureVarName;
    stringBuffer.append(TEXT_64);
    
// FigureMarker:  figureMarker
// String:        figureVarName
if (figureMarker instanceof CustomFigure) {
	CustomFigure figureInstance = (CustomFigure) figureMarker;

    stringBuffer.append(TEXT_65);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(TEXT_69);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_70);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_71);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_75);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_77);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_78);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_79);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_80);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_81);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_83);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_85);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_86);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_89);
    }
    } else if (figureMarker instanceof Shape) {
Shape figureInstance = (Shape) figureMarker;
    stringBuffer.append(TEXT_90);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(TEXT_94);
    
// PERHAPS, do this with reflection?

    if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_95);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(figureInstance.isFill());
    stringBuffer.append(TEXT_97);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_98);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(figureInstance.isOutline());
    stringBuffer.append(TEXT_100);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_101);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(figureInstance.getLineWidth());
    stringBuffer.append(TEXT_103);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_104);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(figureInstance.getLineKind().getName());
    stringBuffer.append(TEXT_106);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(figureInstance.isXorFill());
    stringBuffer.append(TEXT_109);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_110);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(figureInstance.isXorOutline());
    stringBuffer.append(TEXT_112);
    } if (figureInstance instanceof Polyline && !((Polyline) figureInstance).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) figureInstance).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_113);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_116);
    }
    } else if (figureInstance instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) figureInstance;
    stringBuffer.append(TEXT_117);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_120);
    }
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_121);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_122);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_123);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_126);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_127);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_128);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_129);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_130);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_131);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_134);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_135);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_136);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_137);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_140);
    }
    } else if (figureMarker instanceof FigureRef) {
    stringBuffer.append(TEXT_141);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(((FigureRef) figureMarker).getFigure().getName());
    stringBuffer.append(TEXT_143);
    } else if (figureMarker instanceof Label) {
	Label figureInstance = (Label) figureMarker;

    stringBuffer.append(TEXT_144);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_146);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(((Label) figureMarker).getText());
    stringBuffer.append(TEXT_149);
    stringBuffer.append(TEXT_150);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_151);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_152);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_153);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_154);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_156);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_157);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_158);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_159);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_160);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_161);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_162);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_163);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_164);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_165);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_166);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_167);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_169);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_170);
    }
    }
    }
    stringBuffer.append(TEXT_171);
    
LinkedList l = new LinkedList();
l.addAll(figure.getChildren());
final Object marker = new Object();
Stack figureVarNamesStack = new Stack();
int figureCount = 0;
while (!l.isEmpty()) {
	Object _nxt = l.removeFirst();
	if (_nxt == marker) {
		parentFigureVarName = (String) figureVarNamesStack.pop();
		continue;
	}
	FigureMarker figureMarker = (FigureMarker) _nxt;
	String figureVarName = "fig" + (figureCount++);
    stringBuffer.append(TEXT_172);
    
// FigureMarker:  figureMarker
// String:        figureVarName
if (figureMarker instanceof CustomFigure) {
	CustomFigure figureInstance = (CustomFigure) figureMarker;

    stringBuffer.append(TEXT_173);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(TEXT_177);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_178);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_179);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_180);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_181);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_182);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_183);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_184);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_185);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_186);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_187);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_188);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_189);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_191);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_192);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_193);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_194);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_196);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_197);
    }
    } else if (figureMarker instanceof Shape) {
Shape figureInstance = (Shape) figureMarker;
    stringBuffer.append(TEXT_198);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_201);
    stringBuffer.append(TEXT_202);
    
// PERHAPS, do this with reflection?

    if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_203);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(figureInstance.isFill());
    stringBuffer.append(TEXT_205);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_206);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(figureInstance.isOutline());
    stringBuffer.append(TEXT_208);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_209);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(figureInstance.getLineWidth());
    stringBuffer.append(TEXT_211);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_212);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(figureInstance.getLineKind().getName());
    stringBuffer.append(TEXT_214);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_215);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(figureInstance.isXorFill());
    stringBuffer.append(TEXT_217);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_218);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(figureInstance.isXorOutline());
    stringBuffer.append(TEXT_220);
    } if (figureInstance instanceof Polyline && !((Polyline) figureInstance).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) figureInstance).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_221);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_223);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_224);
    }
    } else if (figureInstance instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) figureInstance;
    stringBuffer.append(TEXT_225);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_227);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_228);
    }
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_229);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_230);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_231);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_232);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_233);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_234);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_235);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_236);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_237);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_238);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_239);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_240);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_241);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_242);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_243);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_244);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_245);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_247);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_248);
    }
    } else if (figureMarker instanceof FigureRef) {
    stringBuffer.append(TEXT_249);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(((FigureRef) figureMarker).getFigure().getName());
    stringBuffer.append(TEXT_251);
    } else if (figureMarker instanceof Label) {
	Label figureInstance = (Label) figureMarker;

    stringBuffer.append(TEXT_252);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_253);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_255);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(((Label) figureMarker).getText());
    stringBuffer.append(TEXT_257);
    stringBuffer.append(TEXT_258);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_259);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_260);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_261);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_262);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_263);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_264);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_265);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_266);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_267);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_268);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_269);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_270);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_271);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_272);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_273);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_274);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_275);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_276);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_277);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_278);
    }
    }
    stringBuffer.append(TEXT_279);
    stringBuffer.append(parentFigureVarName);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_281);
    
if (_nxt instanceof Figure && !((Figure) _nxt).getChildren().isEmpty()) {
	l.addFirst(marker);
	l.addAll(0, ((Figure) _nxt).getChildren());
	figureVarNamesStack.push(parentFigureVarName);
	parentFigureVarName = figureVarName; // go on processing children of new parentFigure
}

    
} // while

    stringBuffer.append(TEXT_282);
    stringBuffer.append(parentFigureVarName);
    stringBuffer.append(TEXT_283);
    }
    stringBuffer.append(TEXT_284);
    return stringBuffer.toString();
  }
}
