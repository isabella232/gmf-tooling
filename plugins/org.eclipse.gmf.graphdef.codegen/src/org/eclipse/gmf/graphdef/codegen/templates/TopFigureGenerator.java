package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.graphdef.codegen.*;
import org.eclipse.emf.ecore.*;
import java.util.Iterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.codegen.util.CodeGenUtil;;

public class TopFigureGenerator
{
  protected static String nl;
  public static synchronized TopFigureGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    TopFigureGenerator result = new TopFigureGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_4 = " ";
  protected final String TEXT_5 = "() {" + NL + "\t\t";
  protected final String TEXT_6 = " result = new ";
  protected final String TEXT_7 = "();" + NL + "\t\t";
  protected final String TEXT_8 = NL + "\t\treturn result;" + NL + "\t}";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final org.eclipse.draw2d.geometry.PointList myTemplate = new org.eclipse.draw2d.geometry.PointList();" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate org.eclipse.draw2d.geometry.Rectangle myTemplateBounds;" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void addPoint(org.eclipse.draw2d.geometry.Point point){" + NL + "\t\tmyTemplate.addPoint(point);" + NL + "\t\tmyTemplateBounds = null;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void fillShape(org.eclipse.draw2d.Graphics graphics) {" + NL + "\t\torg.eclipse.draw2d.geometry.Rectangle bounds = getBounds();" + NL + "\t\tgraphics.pushState();" + NL + "\t\tgraphics.translate(bounds.x, bounds.y);" + NL + "\t\tgraphics.fillPolygon(scalePointList());" + NL + "\t\tgraphics.popState();" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void outlineShape(org.eclipse.draw2d.Graphics graphics) {" + NL + "\t\torg.eclipse.draw2d.geometry.Rectangle bounds = getBounds();" + NL + "\t\tgraphics.pushState();" + NL + "\t\tgraphics.translate(bounds.x, bounds.y);" + NL + "\t\tgraphics.drawPolygon(scalePointList());" + NL + "\t\tgraphics.popState();" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate org.eclipse.draw2d.geometry.Rectangle getTemplateBounds(){" + NL + "\t\tif (myTemplateBounds == null) {" + NL + "\t\t\tmyTemplateBounds = myTemplate.getBounds().getCopy().union(0, 0);" + NL + "\t\t\t//just safety -- we are going to use this as divider " + NL + "\t\t\tif (myTemplateBounds.width < 1){" + NL + "\t\t\t\tmyTemplateBounds.width = 1;" + NL + "\t\t\t}" + NL + "\t\t\tif (myTemplateBounds.height < 1){" + NL + "\t\t\t\tmyTemplateBounds.height = 1;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn myTemplateBounds;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int[] scalePointList() {" + NL + "\t\torg.eclipse.draw2d.geometry.Rectangle pointsBounds = getTemplateBounds();" + NL + "\t\torg.eclipse.draw2d.geometry.Rectangle actualBounds = getBounds();" + NL + "" + NL + "\t\tfloat xScale = ((float) actualBounds.width) / pointsBounds.width;" + NL + "\t\tfloat yScale = ((float) actualBounds.height) / pointsBounds.height;" + NL + "" + NL + "\t\tif (xScale == 1 && yScale == 1) {" + NL + "\t\t\treturn myTemplate.toIntArray();" + NL + "\t\t}" + NL + "\t\tint[] scaled = (int[]) myTemplate.toIntArray().clone();" + NL + "\t\tfor (int i = 0; i < scaled.length; i += 2) {" + NL + "\t\t\tscaled[i] = (int) Math.floor(scaled[i] * xScale);" + NL + "\t\t\tscaled[i + 1] = (int) Math.floor(scaled[i + 1] * yScale);" + NL + "\t\t}" + NL + "\t\treturn scaled;" + NL + "\t}";
  protected final String TEXT_11 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_12 = "() {";
  protected final String TEXT_13 = NL + "\t\t";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = NL + "\t\tcreateContents();" + NL + "\t}" + NL;
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean myUseLocalCoordinates = ";
  protected final String TEXT_20 = ";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean useLocalCoordinates() {" + NL + "\t\treturn myUseLocalCoordinates;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setUseLocalCoordinates(boolean useLocalCoordinates) {" + NL + "\t\tmyUseLocalCoordinates = useLocalCoordinates;" + NL + "\t}" + NL + "\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GraphDefDispatcher.Args innerArgs = (GraphDefDispatcher.Args) ((Object[]) argument)[0];
final Figure figure = innerArgs.getFigure();
final GraphDefDispatcher dispatcher = innerArgs.getDispatcher();
final ImportAssistant importManager = dispatcher.getImportManager();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
//input: [oeg].common.codegen.ImportAssistant importManager 
//input: [oeg].graphdef.codegen GraphDefDispatcher dispatcher
//input: [oeg].gmfgraph.Figure figure
 
{ //namespace -- use "bfm" (stands for BorderFactoryMethod) to avoid name clashes
	int bfmNextIndex = 1;
	String bfmLastFigureName = "";
	for (Iterator bfmAllCustomBorders = EcoreUtil.getAllContents(figure, false); bfmAllCustomBorders.hasNext();){
		EObject bfmNext = (EObject)bfmAllCustomBorders.next();
		if (GMFGraphPackage.eINSTANCE.getFigure().isSuperTypeOf(bfmNext.eClass())){
			bfmLastFigureName = (String)bfmNext.eGet(GMFGraphPackage.eINSTANCE.getIdentity_Name());
			if (bfmLastFigureName == null){
				bfmLastFigureName = "";
			}
		}
		// XXX [artem] why not do this with ((Figure) bfmNext).getBorder()? 
		if (bfmNext.eClass().getClassifierID() != GMFGraphPackage.CUSTOM_BORDER){
			continue;
		}
		
		String bfmNextImplClass = dispatcher.getFQNSwitch().get(bfmNext, importManager);	
		String bfmNextMethodName = "createBorder_" + CodeGenUtil.capName(bfmLastFigureName) + "_" + (bfmNextIndex++);
		

    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Border"));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(bfmNextMethodName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(bfmNextImplClass);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(bfmNextImplClass);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(dispatcher.dispatch("customAttributes", new Object[] {bfmNext, dispatcher, "result"} ));
    stringBuffer.append(TEXT_8);
    		
		dispatcher.getAuxiliaryDataStorage().registerData(bfmNext, bfmNextMethodName);
	}
} //end of namespace

    if (figure instanceof ScalablePolygon) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_12);
    
GraphDefDispatcher.LayoutArgs dispatcherArgs = dispatcher.createLayoutArgs(figure, "this", "myGenLayoutManager", null);

    stringBuffer.append(TEXT_13);
    stringBuffer.append(dispatcher.dispatch("createLayout", dispatcherArgs));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(dispatcher.dispatch(figure, dispatcherArgs));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(dispatcher.dispatch("Children", dispatcherArgs));
    stringBuffer.append(TEXT_17);
    if (false == figure instanceof Polyline) {/*no much sense to define useLocalCoordinates for polyline and its descendants*/
    stringBuffer.append(TEXT_18);
    
// simple heuristic to detect need for local coordinates
boolean useLocalDefaultValue = false;
for (java.util.Iterator it = figure.getChildren().iterator(); it.hasNext(); ) {
	if (it.next() instanceof Polyline) {
		useLocalDefaultValue = true;
		break;
	}
}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(useLocalDefaultValue);
    stringBuffer.append(TEXT_20);
    }
    return stringBuffer.toString();
  }
}
