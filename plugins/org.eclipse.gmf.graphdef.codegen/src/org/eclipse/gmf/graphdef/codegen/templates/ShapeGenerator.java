package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import org.eclipse.gmf.common.codegen.*;
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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends ";
  protected final String TEXT_4 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_5 = "() {";
  protected final String TEXT_6 = NL;
  protected final String TEXT_7 = NL + "\t\t";
  protected final String TEXT_8 = ".setFill(";
  protected final String TEXT_9 = ");";
  protected final String TEXT_10 = NL + "\t\t";
  protected final String TEXT_11 = ".setOutline(";
  protected final String TEXT_12 = ");";
  protected final String TEXT_13 = NL + "\t\t";
  protected final String TEXT_14 = ".setLineWidth(";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL + "\t\t";
  protected final String TEXT_17 = ".setLineStyle(org.eclipse.draw2d.Graphics.";
  protected final String TEXT_18 = ");";
  protected final String TEXT_19 = NL + "\t\t";
  protected final String TEXT_20 = ".setFillXOR(";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "\t\t";
  protected final String TEXT_23 = ".setOutlineXOR(";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t\t";
  protected final String TEXT_26 = ".addPoint(new org.eclipse.draw2d.geometry.Point(";
  protected final String TEXT_27 = ", ";
  protected final String TEXT_28 = "));";
  protected final String TEXT_29 = NL + "\t\t";
  protected final String TEXT_30 = ".setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(";
  protected final String TEXT_31 = "), getMapMode().DPtoLP(";
  protected final String TEXT_32 = ")));";
  protected final String TEXT_33 = NL + "\t\t";
  protected final String TEXT_34 = ".setForegroundColor(";
  protected final String TEXT_35 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_36 = ", ";
  protected final String TEXT_37 = ", ";
  protected final String TEXT_38 = ")";
  protected final String TEXT_39 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\t\t";
  protected final String TEXT_42 = ".setBackgroundColor(";
  protected final String TEXT_43 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_44 = ", ";
  protected final String TEXT_45 = ", ";
  protected final String TEXT_46 = ")";
  protected final String TEXT_47 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "\t\t";
  protected final String TEXT_50 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_51 = "), getMapMode().DPtoLP(";
  protected final String TEXT_52 = "));";
  protected final String TEXT_53 = NL + "\t\tsetFigure";
  protected final String TEXT_54 = "(createFigure";
  protected final String TEXT_55 = "());" + NL + "\t\tadd(getFigure";
  protected final String TEXT_56 = "());";
  protected final String TEXT_57 = NL + "\t}" + NL;
  protected final String TEXT_58 = NL + NL + "\tprivate IFigure f";
  protected final String TEXT_59 = "; " + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getFigure";
  protected final String TEXT_60 = "() {" + NL + "\t\treturn f";
  protected final String TEXT_61 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setFigure";
  protected final String TEXT_62 = "(IFigure figure) {" + NL + "\t\tf";
  protected final String TEXT_63 = " = figure;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure createFigure";
  protected final String TEXT_64 = "() {";
  protected final String TEXT_65 = NL;
  protected final String TEXT_66 = NL + "\t\t";
  protected final String TEXT_67 = " ";
  protected final String TEXT_68 = " = new ";
  protected final String TEXT_69 = "();";
  protected final String TEXT_70 = NL;
  protected final String TEXT_71 = NL + "\t\t";
  protected final String TEXT_72 = ".setForegroundColor(";
  protected final String TEXT_73 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_74 = ", ";
  protected final String TEXT_75 = ", ";
  protected final String TEXT_76 = ")";
  protected final String TEXT_77 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_78 = ");";
  protected final String TEXT_79 = NL + "\t\t";
  protected final String TEXT_80 = ".setBackgroundColor(";
  protected final String TEXT_81 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_82 = ", ";
  protected final String TEXT_83 = ", ";
  protected final String TEXT_84 = ")";
  protected final String TEXT_85 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_86 = ");";
  protected final String TEXT_87 = NL + "\t\t";
  protected final String TEXT_88 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_89 = "), getMapMode().DPtoLP(";
  protected final String TEXT_90 = "));";
  protected final String TEXT_91 = NL + "\t\t";
  protected final String TEXT_92 = " ";
  protected final String TEXT_93 = " = new ";
  protected final String TEXT_94 = "();";
  protected final String TEXT_95 = NL;
  protected final String TEXT_96 = NL + "\t\t";
  protected final String TEXT_97 = ".setFill(";
  protected final String TEXT_98 = ");";
  protected final String TEXT_99 = NL + "\t\t";
  protected final String TEXT_100 = ".setOutline(";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "\t\t";
  protected final String TEXT_103 = ".setLineWidth(";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = NL + "\t\t";
  protected final String TEXT_106 = ".setLineStyle(org.eclipse.draw2d.Graphics.";
  protected final String TEXT_107 = ");";
  protected final String TEXT_108 = NL + "\t\t";
  protected final String TEXT_109 = ".setFillXOR(";
  protected final String TEXT_110 = ");";
  protected final String TEXT_111 = NL + "\t\t";
  protected final String TEXT_112 = ".setOutlineXOR(";
  protected final String TEXT_113 = ");";
  protected final String TEXT_114 = NL + "\t\t";
  protected final String TEXT_115 = ".addPoint(new org.eclipse.draw2d.geometry.Point(";
  protected final String TEXT_116 = ", ";
  protected final String TEXT_117 = "));";
  protected final String TEXT_118 = NL + "\t\t";
  protected final String TEXT_119 = ".setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(";
  protected final String TEXT_120 = "), getMapMode().DPtoLP(";
  protected final String TEXT_121 = ")));";
  protected final String TEXT_122 = NL + "\t\t";
  protected final String TEXT_123 = ".setForegroundColor(";
  protected final String TEXT_124 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_125 = ", ";
  protected final String TEXT_126 = ", ";
  protected final String TEXT_127 = ")";
  protected final String TEXT_128 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_129 = ");";
  protected final String TEXT_130 = NL + "\t\t";
  protected final String TEXT_131 = ".setBackgroundColor(";
  protected final String TEXT_132 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_133 = ", ";
  protected final String TEXT_134 = ", ";
  protected final String TEXT_135 = ")";
  protected final String TEXT_136 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_137 = ");";
  protected final String TEXT_138 = NL + "\t\t";
  protected final String TEXT_139 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_140 = "), getMapMode().DPtoLP(";
  protected final String TEXT_141 = "));";
  protected final String TEXT_142 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_143 = " = new ";
  protected final String TEXT_144 = "();";
  protected final String TEXT_145 = NL + "\t\t";
  protected final String TEXT_146 = " ";
  protected final String TEXT_147 = " = new ";
  protected final String TEXT_148 = "();" + NL + "\t\t";
  protected final String TEXT_149 = ".setText(\"";
  protected final String TEXT_150 = "\");";
  protected final String TEXT_151 = NL;
  protected final String TEXT_152 = NL + "\t\t";
  protected final String TEXT_153 = ".setForegroundColor(";
  protected final String TEXT_154 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_155 = ", ";
  protected final String TEXT_156 = ", ";
  protected final String TEXT_157 = ")";
  protected final String TEXT_158 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_159 = ");";
  protected final String TEXT_160 = NL + "\t\t";
  protected final String TEXT_161 = ".setBackgroundColor(";
  protected final String TEXT_162 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_163 = ", ";
  protected final String TEXT_164 = ", ";
  protected final String TEXT_165 = ")";
  protected final String TEXT_166 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_167 = ");";
  protected final String TEXT_168 = NL + "\t\t";
  protected final String TEXT_169 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_170 = "), getMapMode().DPtoLP(";
  protected final String TEXT_171 = "));";
  protected final String TEXT_172 = NL;
  protected final String TEXT_173 = NL;
  protected final String TEXT_174 = NL + "\t\t";
  protected final String TEXT_175 = " ";
  protected final String TEXT_176 = " = new ";
  protected final String TEXT_177 = "();";
  protected final String TEXT_178 = NL;
  protected final String TEXT_179 = NL + "\t\t";
  protected final String TEXT_180 = ".setForegroundColor(";
  protected final String TEXT_181 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_182 = ", ";
  protected final String TEXT_183 = ", ";
  protected final String TEXT_184 = ")";
  protected final String TEXT_185 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_186 = ");";
  protected final String TEXT_187 = NL + "\t\t";
  protected final String TEXT_188 = ".setBackgroundColor(";
  protected final String TEXT_189 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_190 = ", ";
  protected final String TEXT_191 = ", ";
  protected final String TEXT_192 = ")";
  protected final String TEXT_193 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_194 = ");";
  protected final String TEXT_195 = NL + "\t\t";
  protected final String TEXT_196 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_197 = "), getMapMode().DPtoLP(";
  protected final String TEXT_198 = "));";
  protected final String TEXT_199 = NL + "\t\t";
  protected final String TEXT_200 = " ";
  protected final String TEXT_201 = " = new ";
  protected final String TEXT_202 = "();";
  protected final String TEXT_203 = NL;
  protected final String TEXT_204 = NL + "\t\t";
  protected final String TEXT_205 = ".setFill(";
  protected final String TEXT_206 = ");";
  protected final String TEXT_207 = NL + "\t\t";
  protected final String TEXT_208 = ".setOutline(";
  protected final String TEXT_209 = ");";
  protected final String TEXT_210 = NL + "\t\t";
  protected final String TEXT_211 = ".setLineWidth(";
  protected final String TEXT_212 = ");";
  protected final String TEXT_213 = NL + "\t\t";
  protected final String TEXT_214 = ".setLineStyle(org.eclipse.draw2d.Graphics.";
  protected final String TEXT_215 = ");";
  protected final String TEXT_216 = NL + "\t\t";
  protected final String TEXT_217 = ".setFillXOR(";
  protected final String TEXT_218 = ");";
  protected final String TEXT_219 = NL + "\t\t";
  protected final String TEXT_220 = ".setOutlineXOR(";
  protected final String TEXT_221 = ");";
  protected final String TEXT_222 = NL + "\t\t";
  protected final String TEXT_223 = ".addPoint(new org.eclipse.draw2d.geometry.Point(";
  protected final String TEXT_224 = ", ";
  protected final String TEXT_225 = "));";
  protected final String TEXT_226 = NL + "\t\t";
  protected final String TEXT_227 = ".setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(";
  protected final String TEXT_228 = "), getMapMode().DPtoLP(";
  protected final String TEXT_229 = ")));";
  protected final String TEXT_230 = NL + "\t\t";
  protected final String TEXT_231 = ".setForegroundColor(";
  protected final String TEXT_232 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_233 = ", ";
  protected final String TEXT_234 = ", ";
  protected final String TEXT_235 = ")";
  protected final String TEXT_236 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_237 = ");";
  protected final String TEXT_238 = NL + "\t\t";
  protected final String TEXT_239 = ".setBackgroundColor(";
  protected final String TEXT_240 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_241 = ", ";
  protected final String TEXT_242 = ", ";
  protected final String TEXT_243 = ")";
  protected final String TEXT_244 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_245 = ");";
  protected final String TEXT_246 = NL + "\t\t";
  protected final String TEXT_247 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_248 = "), getMapMode().DPtoLP(";
  protected final String TEXT_249 = "));";
  protected final String TEXT_250 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_251 = " = new ";
  protected final String TEXT_252 = "();";
  protected final String TEXT_253 = NL + "\t\t";
  protected final String TEXT_254 = " ";
  protected final String TEXT_255 = " = new ";
  protected final String TEXT_256 = "();" + NL + "\t\t";
  protected final String TEXT_257 = ".setText(\"";
  protected final String TEXT_258 = "\");";
  protected final String TEXT_259 = NL;
  protected final String TEXT_260 = NL + "\t\t";
  protected final String TEXT_261 = ".setForegroundColor(";
  protected final String TEXT_262 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_263 = ", ";
  protected final String TEXT_264 = ", ";
  protected final String TEXT_265 = ")";
  protected final String TEXT_266 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_267 = ");";
  protected final String TEXT_268 = NL + "\t\t";
  protected final String TEXT_269 = ".setBackgroundColor(";
  protected final String TEXT_270 = "new org.eclipse.swt.graphics.Color(null, ";
  protected final String TEXT_271 = ", ";
  protected final String TEXT_272 = ", ";
  protected final String TEXT_273 = ")";
  protected final String TEXT_274 = "org.eclipse.draw2d.ColorConstants.";
  protected final String TEXT_275 = ");";
  protected final String TEXT_276 = NL + "\t\t";
  protected final String TEXT_277 = ".setPreferredSize(getMapMode().DPtoLP(";
  protected final String TEXT_278 = "), getMapMode().DPtoLP(";
  protected final String TEXT_279 = "));";
  protected final String TEXT_280 = NL + "\t\t";
  protected final String TEXT_281 = ".add(";
  protected final String TEXT_282 = ");";
  protected final String TEXT_283 = NL + "\t\treturn ";
  protected final String TEXT_284 = ";" + NL + "\t}" + NL;
  protected final String TEXT_285 = NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
Object[] args = (Object[]) argument;
Shape shapeFig = (Shape) args[0];
final ImportAssistant importManager = (ImportAssistant) args[1];
final GMFGraphSwitch fqnSwitch = new FigureQualifiedNameSwitch();

    stringBuffer.append(TEXT_1);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(shapeFig.getName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName((String) fqnSwitch.doSwitch(shapeFig)));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(shapeFig.getName());
    stringBuffer.append(TEXT_5);
    
{
Shape figureInstance = shapeFig;
String figureVarName = "this";

    stringBuffer.append(TEXT_6);
    
// PERHAPS, do this with reflection?

    if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_7);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(figureInstance.isFill());
    stringBuffer.append(TEXT_9);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(figureInstance.isOutline());
    stringBuffer.append(TEXT_12);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(figureInstance.getLineWidth());
    stringBuffer.append(TEXT_15);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(figureInstance.getLineKind().getName());
    stringBuffer.append(TEXT_18);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(figureInstance.isXorFill());
    stringBuffer.append(TEXT_21);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(figureInstance.isXorOutline());
    stringBuffer.append(TEXT_24);
    } if (figureInstance instanceof Polyline && !((Polyline) figureInstance).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) figureInstance).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_25);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_28);
    }
    } else if (figureInstance instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) figureInstance;
    stringBuffer.append(TEXT_29);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_32);
    }
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_33);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_34);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_38);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_40);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_41);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_42);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_46);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_48);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_49);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_52);
    }
    
}for (Iterator it = shapeFig.getResolvedChildren().iterator(); it.hasNext();) {
		Figure next = (Figure) it.next();
    stringBuffer.append(TEXT_53);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    
int fc = 0;
for (Iterator it = shapeFig.getResolvedChildren().iterator(); it.hasNext(); fc++) {
	Figure figure = (Figure) it.next();
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
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_64);
    
String parentFigureVarName = "rv" + fc;
{ // scope
FigureMarker figureMarker = figure;
String figureVarName = parentFigureVarName;
    stringBuffer.append(TEXT_65);
    
// FigureMarker:  figureMarker
// String:        figureVarName
if (figureMarker instanceof CustomFigure) {
	CustomFigure figureInstance = (CustomFigure) figureMarker;

    stringBuffer.append(TEXT_66);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(TEXT_70);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_71);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_72);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_73);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_76);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_77);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_78);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_79);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_80);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_81);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_84);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_85);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_86);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_87);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_90);
    }
    } else if (figureMarker instanceof Shape) {
Shape figureInstance = (Shape) figureMarker;
    stringBuffer.append(TEXT_91);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(TEXT_95);
    
// PERHAPS, do this with reflection?

    if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_96);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(figureInstance.isFill());
    stringBuffer.append(TEXT_98);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(figureInstance.isOutline());
    stringBuffer.append(TEXT_101);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_102);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(figureInstance.getLineWidth());
    stringBuffer.append(TEXT_104);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_105);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(figureInstance.getLineKind().getName());
    stringBuffer.append(TEXT_107);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_108);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(figureInstance.isXorFill());
    stringBuffer.append(TEXT_110);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_111);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(figureInstance.isXorOutline());
    stringBuffer.append(TEXT_113);
    } if (figureInstance instanceof Polyline && !((Polyline) figureInstance).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) figureInstance).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_114);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_117);
    }
    } else if (figureInstance instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) figureInstance;
    stringBuffer.append(TEXT_118);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_121);
    }
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_122);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_123);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_124);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_126);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_127);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_128);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_129);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_130);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_131);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_132);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_135);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_136);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_137);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_138);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_141);
    }
    } else if (figureMarker instanceof FigureRef) {
    stringBuffer.append(TEXT_142);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(((FigureRef) figureMarker).getFigure().getName());
    stringBuffer.append(TEXT_144);
    } else if (figureMarker instanceof Label) {
	Label figureInstance = (Label) figureMarker;

    stringBuffer.append(TEXT_145);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_147);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(((Label) figureMarker).getText());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(TEXT_151);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_152);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_153);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_154);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_155);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_156);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_157);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_158);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_159);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_160);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_161);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_162);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_163);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_164);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_165);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_166);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_167);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_168);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_170);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_171);
    }
    }
    }
    stringBuffer.append(TEXT_172);
    
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
    stringBuffer.append(TEXT_173);
    
// FigureMarker:  figureMarker
// String:        figureVarName
if (figureMarker instanceof CustomFigure) {
	CustomFigure figureInstance = (CustomFigure) figureMarker;

    stringBuffer.append(TEXT_174);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(TEXT_178);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_179);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_180);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_181);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_182);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_183);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_184);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_185);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_186);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_187);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_188);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_189);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_190);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_191);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_192);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_193);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_194);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_195);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_198);
    }
    } else if (figureMarker instanceof Shape) {
Shape figureInstance = (Shape) figureMarker;
    stringBuffer.append(TEXT_199);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_200);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_202);
    stringBuffer.append(TEXT_203);
    
// PERHAPS, do this with reflection?

    if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_204);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(figureInstance.isFill());
    stringBuffer.append(TEXT_206);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_207);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(figureInstance.isOutline());
    stringBuffer.append(TEXT_209);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_210);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(figureInstance.getLineWidth());
    stringBuffer.append(TEXT_212);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_213);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(figureInstance.getLineKind().getName());
    stringBuffer.append(TEXT_215);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_216);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(figureInstance.isXorFill());
    stringBuffer.append(TEXT_218);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_219);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(figureInstance.isXorOutline());
    stringBuffer.append(TEXT_221);
    } if (figureInstance instanceof Polyline && !((Polyline) figureInstance).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) figureInstance).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_222);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_224);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_225);
    }
    } else if (figureInstance instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) figureInstance;
    stringBuffer.append(TEXT_226);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_227);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_228);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_229);
    }
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_230);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_231);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_232);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_233);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_234);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_235);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_236);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_237);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_238);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_239);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_240);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_241);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_242);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_243);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_244);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_245);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_246);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_248);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_249);
    }
    } else if (figureMarker instanceof FigureRef) {
    stringBuffer.append(TEXT_250);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(((FigureRef) figureMarker).getFigure().getName());
    stringBuffer.append(TEXT_252);
    } else if (figureMarker instanceof Label) {
	Label figureInstance = (Label) figureMarker;

    stringBuffer.append(TEXT_253);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_254);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_256);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(((Label) figureMarker).getText());
    stringBuffer.append(TEXT_258);
    stringBuffer.append(TEXT_259);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_260);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_261);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_262);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_263);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_264);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_265);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_266);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_267);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_268);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_269);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_270);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_271);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_272);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_273);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_274);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_275);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_PreferredSize())) {
		Dimension d = figureInstance.getPreferredSize();
    stringBuffer.append(TEXT_276);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_277);
    stringBuffer.append(d.getDx());
    stringBuffer.append(TEXT_278);
    stringBuffer.append(d.getDy());
    stringBuffer.append(TEXT_279);
    }
    }
    stringBuffer.append(TEXT_280);
    stringBuffer.append(parentFigureVarName);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_282);
    
if (_nxt instanceof Figure && !((Figure) _nxt).getChildren().isEmpty()) {
	l.addFirst(marker);
	l.addAll(0, ((Figure) _nxt).getChildren());
	figureVarNamesStack.push(parentFigureVarName);
	parentFigureVarName = figureVarName; // go on processing children of new parentFigure
}

    
} // while

    stringBuffer.append(TEXT_283);
    stringBuffer.append(parentFigureVarName);
    stringBuffer.append(TEXT_284);
    }
    stringBuffer.append(TEXT_285);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
