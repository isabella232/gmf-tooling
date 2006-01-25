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
  protected final String TEXT_48 = NL + "\t\tsetFigure";
  protected final String TEXT_49 = "(createFigure";
  protected final String TEXT_50 = "());" + NL + "\t\tadd(getFigure";
  protected final String TEXT_51 = "());";
  protected final String TEXT_52 = NL + "\t}" + NL;
  protected final String TEXT_53 = NL + NL + "\tprivate IFigure f";
  protected final String TEXT_54 = "; " + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getFigure";
  protected final String TEXT_55 = "() {" + NL + "\t\treturn f";
  protected final String TEXT_56 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setFigure";
  protected final String TEXT_57 = "(IFigure figure) {" + NL + "\t\tf";
  protected final String TEXT_58 = " = figure;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure createFigure";
  protected final String TEXT_59 = "() {";
  protected final String TEXT_60 = NL;
  protected final String TEXT_61 = NL + "\t\t";
  protected final String TEXT_62 = " ";
  protected final String TEXT_63 = " = new ";
  protected final String TEXT_64 = "();";
  protected final String TEXT_65 = NL;
  protected final String TEXT_66 = NL + "\t\t";
  protected final String TEXT_67 = ".setForegroundColor(";
  protected final String TEXT_68 = "new Color(null, ";
  protected final String TEXT_69 = ", ";
  protected final String TEXT_70 = ", ";
  protected final String TEXT_71 = ")";
  protected final String TEXT_72 = "ColorConstants.";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "\t\t";
  protected final String TEXT_75 = ".setBackgroundColor(";
  protected final String TEXT_76 = "new Color(null, ";
  protected final String TEXT_77 = ", ";
  protected final String TEXT_78 = ", ";
  protected final String TEXT_79 = ")";
  protected final String TEXT_80 = "ColorConstants.";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL + "\t\t";
  protected final String TEXT_83 = " ";
  protected final String TEXT_84 = " = new ";
  protected final String TEXT_85 = "();";
  protected final String TEXT_86 = NL;
  protected final String TEXT_87 = NL + "\t\t";
  protected final String TEXT_88 = ".setFill(";
  protected final String TEXT_89 = ");";
  protected final String TEXT_90 = NL + "\t\t";
  protected final String TEXT_91 = ".setOutline(";
  protected final String TEXT_92 = ");";
  protected final String TEXT_93 = NL + "\t\t";
  protected final String TEXT_94 = ".setLineWidth(";
  protected final String TEXT_95 = ");";
  protected final String TEXT_96 = NL + "\t\t";
  protected final String TEXT_97 = ".setLineStyle(org.eclipse.draw2d.Graphics.";
  protected final String TEXT_98 = ");";
  protected final String TEXT_99 = NL + "\t\t";
  protected final String TEXT_100 = ".setFillXOR(";
  protected final String TEXT_101 = ");";
  protected final String TEXT_102 = NL + "\t\t";
  protected final String TEXT_103 = ".setOutlineXOR(";
  protected final String TEXT_104 = ");";
  protected final String TEXT_105 = NL + "\t\t";
  protected final String TEXT_106 = ".addPoint(new org.eclipse.draw2d.geometry.Point(";
  protected final String TEXT_107 = ", ";
  protected final String TEXT_108 = "));";
  protected final String TEXT_109 = NL + "\t\t";
  protected final String TEXT_110 = ".setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(";
  protected final String TEXT_111 = "), getMapMode().DPtoLP(";
  protected final String TEXT_112 = ")));";
  protected final String TEXT_113 = NL + "\t\t";
  protected final String TEXT_114 = ".setForegroundColor(";
  protected final String TEXT_115 = "new Color(null, ";
  protected final String TEXT_116 = ", ";
  protected final String TEXT_117 = ", ";
  protected final String TEXT_118 = ")";
  protected final String TEXT_119 = "ColorConstants.";
  protected final String TEXT_120 = ");";
  protected final String TEXT_121 = NL + "\t\t";
  protected final String TEXT_122 = ".setBackgroundColor(";
  protected final String TEXT_123 = "new Color(null, ";
  protected final String TEXT_124 = ", ";
  protected final String TEXT_125 = ", ";
  protected final String TEXT_126 = ")";
  protected final String TEXT_127 = "ColorConstants.";
  protected final String TEXT_128 = ");";
  protected final String TEXT_129 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_130 = " = new ";
  protected final String TEXT_131 = "();";
  protected final String TEXT_132 = NL + "\t\t";
  protected final String TEXT_133 = " ";
  protected final String TEXT_134 = " = new ";
  protected final String TEXT_135 = "();" + NL + "\t\t";
  protected final String TEXT_136 = ".setText(\"";
  protected final String TEXT_137 = "\");";
  protected final String TEXT_138 = NL;
  protected final String TEXT_139 = NL + "\t\t";
  protected final String TEXT_140 = ".setForegroundColor(";
  protected final String TEXT_141 = "new Color(null, ";
  protected final String TEXT_142 = ", ";
  protected final String TEXT_143 = ", ";
  protected final String TEXT_144 = ")";
  protected final String TEXT_145 = "ColorConstants.";
  protected final String TEXT_146 = ");";
  protected final String TEXT_147 = NL + "\t\t";
  protected final String TEXT_148 = ".setBackgroundColor(";
  protected final String TEXT_149 = "new Color(null, ";
  protected final String TEXT_150 = ", ";
  protected final String TEXT_151 = ", ";
  protected final String TEXT_152 = ")";
  protected final String TEXT_153 = "ColorConstants.";
  protected final String TEXT_154 = ");";
  protected final String TEXT_155 = NL;
  protected final String TEXT_156 = NL;
  protected final String TEXT_157 = NL + "\t\t";
  protected final String TEXT_158 = " ";
  protected final String TEXT_159 = " = new ";
  protected final String TEXT_160 = "();";
  protected final String TEXT_161 = NL;
  protected final String TEXT_162 = NL + "\t\t";
  protected final String TEXT_163 = ".setForegroundColor(";
  protected final String TEXT_164 = "new Color(null, ";
  protected final String TEXT_165 = ", ";
  protected final String TEXT_166 = ", ";
  protected final String TEXT_167 = ")";
  protected final String TEXT_168 = "ColorConstants.";
  protected final String TEXT_169 = ");";
  protected final String TEXT_170 = NL + "\t\t";
  protected final String TEXT_171 = ".setBackgroundColor(";
  protected final String TEXT_172 = "new Color(null, ";
  protected final String TEXT_173 = ", ";
  protected final String TEXT_174 = ", ";
  protected final String TEXT_175 = ")";
  protected final String TEXT_176 = "ColorConstants.";
  protected final String TEXT_177 = ");";
  protected final String TEXT_178 = NL + "\t\t";
  protected final String TEXT_179 = " ";
  protected final String TEXT_180 = " = new ";
  protected final String TEXT_181 = "();";
  protected final String TEXT_182 = NL;
  protected final String TEXT_183 = NL + "\t\t";
  protected final String TEXT_184 = ".setFill(";
  protected final String TEXT_185 = ");";
  protected final String TEXT_186 = NL + "\t\t";
  protected final String TEXT_187 = ".setOutline(";
  protected final String TEXT_188 = ");";
  protected final String TEXT_189 = NL + "\t\t";
  protected final String TEXT_190 = ".setLineWidth(";
  protected final String TEXT_191 = ");";
  protected final String TEXT_192 = NL + "\t\t";
  protected final String TEXT_193 = ".setLineStyle(org.eclipse.draw2d.Graphics.";
  protected final String TEXT_194 = ");";
  protected final String TEXT_195 = NL + "\t\t";
  protected final String TEXT_196 = ".setFillXOR(";
  protected final String TEXT_197 = ");";
  protected final String TEXT_198 = NL + "\t\t";
  protected final String TEXT_199 = ".setOutlineXOR(";
  protected final String TEXT_200 = ");";
  protected final String TEXT_201 = NL + "\t\t";
  protected final String TEXT_202 = ".addPoint(new org.eclipse.draw2d.geometry.Point(";
  protected final String TEXT_203 = ", ";
  protected final String TEXT_204 = "));";
  protected final String TEXT_205 = NL + "\t\t";
  protected final String TEXT_206 = ".setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(getMapMode().DPtoLP(";
  protected final String TEXT_207 = "), getMapMode().DPtoLP(";
  protected final String TEXT_208 = ")));";
  protected final String TEXT_209 = NL + "\t\t";
  protected final String TEXT_210 = ".setForegroundColor(";
  protected final String TEXT_211 = "new Color(null, ";
  protected final String TEXT_212 = ", ";
  protected final String TEXT_213 = ", ";
  protected final String TEXT_214 = ")";
  protected final String TEXT_215 = "ColorConstants.";
  protected final String TEXT_216 = ");";
  protected final String TEXT_217 = NL + "\t\t";
  protected final String TEXT_218 = ".setBackgroundColor(";
  protected final String TEXT_219 = "new Color(null, ";
  protected final String TEXT_220 = ", ";
  protected final String TEXT_221 = ", ";
  protected final String TEXT_222 = ")";
  protected final String TEXT_223 = "ColorConstants.";
  protected final String TEXT_224 = ");";
  protected final String TEXT_225 = NL + "\t\torg.eclipse.draw2d.IFigure ";
  protected final String TEXT_226 = " = new ";
  protected final String TEXT_227 = "();";
  protected final String TEXT_228 = NL + "\t\t";
  protected final String TEXT_229 = " ";
  protected final String TEXT_230 = " = new ";
  protected final String TEXT_231 = "();" + NL + "\t\t";
  protected final String TEXT_232 = ".setText(\"";
  protected final String TEXT_233 = "\");";
  protected final String TEXT_234 = NL;
  protected final String TEXT_235 = NL + "\t\t";
  protected final String TEXT_236 = ".setForegroundColor(";
  protected final String TEXT_237 = "new Color(null, ";
  protected final String TEXT_238 = ", ";
  protected final String TEXT_239 = ", ";
  protected final String TEXT_240 = ")";
  protected final String TEXT_241 = "ColorConstants.";
  protected final String TEXT_242 = ");";
  protected final String TEXT_243 = NL + "\t\t";
  protected final String TEXT_244 = ".setBackgroundColor(";
  protected final String TEXT_245 = "new Color(null, ";
  protected final String TEXT_246 = ", ";
  protected final String TEXT_247 = ", ";
  protected final String TEXT_248 = ")";
  protected final String TEXT_249 = "ColorConstants.";
  protected final String TEXT_250 = ");";
  protected final String TEXT_251 = NL + "\t\t";
  protected final String TEXT_252 = ".add(";
  protected final String TEXT_253 = ");";
  protected final String TEXT_254 = NL + "\t\treturn ";
  protected final String TEXT_255 = ";" + NL + "\t}" + NL;
  protected final String TEXT_256 = NL + "}";

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
    }
    
}for (Iterator it = shapeFig.getResolvedChildren().iterator(); it.hasNext();) {
		Figure next = (Figure) it.next();
    stringBuffer.append(TEXT_48);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
    
int fc = 0;
for (Iterator it = shapeFig.getResolvedChildren().iterator(); it.hasNext(); fc++) {
	Figure figure = (Figure) it.next();
    stringBuffer.append(TEXT_53);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_59);
    
String parentFigureVarName = "rv" + fc;
{ // scope
FigureMarker figureMarker = figure;
String figureVarName = parentFigureVarName;
    stringBuffer.append(TEXT_60);
    
// FigureMarker:  figureMarker
// String:        figureVarName
if (figureMarker instanceof CustomFigure) {
	CustomFigure figureInstance = (CustomFigure) figureMarker;

    stringBuffer.append(TEXT_61);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(TEXT_65);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_66);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_67);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_68);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_71);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_73);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_74);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_75);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_79);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_80);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_81);
    }
    } else if (figureMarker instanceof Shape) {
Shape figureInstance = (Shape) figureMarker;
    stringBuffer.append(TEXT_82);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(TEXT_86);
    
// PERHAPS, do this with reflection?

    if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_87);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(figureInstance.isFill());
    stringBuffer.append(TEXT_89);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(figureInstance.isOutline());
    stringBuffer.append(TEXT_92);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(figureInstance.getLineWidth());
    stringBuffer.append(TEXT_95);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_96);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(figureInstance.getLineKind().getName());
    stringBuffer.append(TEXT_98);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(figureInstance.isXorFill());
    stringBuffer.append(TEXT_101);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_102);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(figureInstance.isXorOutline());
    stringBuffer.append(TEXT_104);
    } if (figureInstance instanceof Polyline && !((Polyline) figureInstance).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) figureInstance).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_105);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_107);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_108);
    }
    } else if (figureInstance instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) figureInstance;
    stringBuffer.append(TEXT_109);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_112);
    }
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_113);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_114);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_115);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_117);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_118);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_119);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_120);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
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
    }
    } else if (figureMarker instanceof FigureRef) {
    stringBuffer.append(TEXT_129);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(((FigureRef) figureMarker).getFigure().getName());
    stringBuffer.append(TEXT_131);
    } else if (figureMarker instanceof Label) {
	Label figureInstance = (Label) figureMarker;

    stringBuffer.append(TEXT_132);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_134);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(((Label) figureMarker).getText());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(TEXT_138);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_139);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_140);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_141);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_142);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_144);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_145);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_146);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_147);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_148);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_149);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_150);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_151);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_152);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_153);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_154);
    }
    }
    }
    stringBuffer.append(TEXT_155);
    
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
    stringBuffer.append(TEXT_156);
    
// FigureMarker:  figureMarker
// String:        figureVarName
if (figureMarker instanceof CustomFigure) {
	CustomFigure figureInstance = (CustomFigure) figureMarker;

    stringBuffer.append(TEXT_157);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(TEXT_161);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_162);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_163);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_164);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_165);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_167);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_168);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_169);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_170);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_171);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_172);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_173);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_174);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_175);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_176);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_177);
    }
    } else if (figureMarker instanceof Shape) {
Shape figureInstance = (Shape) figureMarker;
    stringBuffer.append(TEXT_178);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(TEXT_182);
    
// PERHAPS, do this with reflection?

    if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Fill())) {
    stringBuffer.append(TEXT_183);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(figureInstance.isFill());
    stringBuffer.append(TEXT_185);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_Outline())) {
    stringBuffer.append(TEXT_186);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(figureInstance.isOutline());
    stringBuffer.append(TEXT_188);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineWidth())) {
    stringBuffer.append(TEXT_189);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(figureInstance.getLineWidth());
    stringBuffer.append(TEXT_191);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_LineKind())) {
    stringBuffer.append(TEXT_192);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(figureInstance.getLineKind().getName());
    stringBuffer.append(TEXT_194);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorFill())) {
    stringBuffer.append(TEXT_195);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(figureInstance.isXorFill());
    stringBuffer.append(TEXT_197);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getShape_XorOutline())) {
    stringBuffer.append(TEXT_198);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(figureInstance.isXorOutline());
    stringBuffer.append(TEXT_200);
    } if (figureInstance instanceof Polyline && !((Polyline) figureInstance).getTemplate().isEmpty()) {
	for (Iterator pointIt = ((Polyline) figureInstance).getTemplate().iterator(); pointIt.hasNext(); ) {
		Point p = (Point) pointIt.next();
    stringBuffer.append(TEXT_201);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(p.getX());
    stringBuffer.append(TEXT_203);
    stringBuffer.append(p.getY());
    stringBuffer.append(TEXT_204);
    }
    } else if (figureInstance instanceof RoundedRectangle) {
		RoundedRectangle rrFigure = (RoundedRectangle) figureInstance;
    stringBuffer.append(TEXT_205);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(rrFigure.getCornerWidth());
    stringBuffer.append(TEXT_207);
    stringBuffer.append(rrFigure.getCornerHeight());
    stringBuffer.append(TEXT_208);
    }
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_209);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_210);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_211);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_212);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_213);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_214);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_215);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_216);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_217);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_218);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_219);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_220);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_221);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_222);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_223);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_224);
    }
    } else if (figureMarker instanceof FigureRef) {
    stringBuffer.append(TEXT_225);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(((FigureRef) figureMarker).getFigure().getName());
    stringBuffer.append(TEXT_227);
    } else if (figureMarker instanceof Label) {
	Label figureInstance = (Label) figureMarker;

    stringBuffer.append(TEXT_228);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_229);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_230);
    stringBuffer.append(fqnSwitch.doSwitch(figureMarker));
    stringBuffer.append(TEXT_231);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(((Label) figureMarker).getText());
    stringBuffer.append(TEXT_233);
    stringBuffer.append(TEXT_234);
    Color colorVal;
if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_ForegroundColor())) {
		colorVal = figureInstance.getForegroundColor();
    stringBuffer.append(TEXT_235);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_236);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_237);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_238);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_239);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_240);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_241);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_242);
    } if (figureInstance.eIsSet(GMFGraphPackage.eINSTANCE.getFigure_BackgroundColor())) {
		colorVal = figureInstance.getBackgroundColor();
    stringBuffer.append(TEXT_243);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_244);
    if (colorVal instanceof RGBColor) {
    stringBuffer.append(TEXT_245);
    stringBuffer.append(((RGBColor) colorVal).getRed());
    stringBuffer.append(TEXT_246);
    stringBuffer.append(((RGBColor) colorVal).getGreen());
    stringBuffer.append(TEXT_247);
    stringBuffer.append(((RGBColor) colorVal).getBlue());
    stringBuffer.append(TEXT_248);
    } else if (colorVal instanceof ConstantColor) {
    stringBuffer.append(TEXT_249);
    stringBuffer.append(((ConstantColor) colorVal).getValue().getLiteral());
    }
    stringBuffer.append(TEXT_250);
    }
    }
    stringBuffer.append(TEXT_251);
    stringBuffer.append(parentFigureVarName);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(figureVarName);
    stringBuffer.append(TEXT_253);
    
if (_nxt instanceof Figure && !((Figure) _nxt).getChildren().isEmpty()) {
	l.addFirst(marker);
	l.addAll(0, ((Figure) _nxt).getChildren());
	figureVarNamesStack.push(parentFigureVarName);
	parentFigureVarName = figureVarName; // go on processing children of new parentFigure
}

    
} // while

    stringBuffer.append(TEXT_254);
    stringBuffer.append(parentFigureVarName);
    stringBuffer.append(TEXT_255);
    }
    stringBuffer.append(TEXT_256);
    return stringBuffer.toString();
  }
}
