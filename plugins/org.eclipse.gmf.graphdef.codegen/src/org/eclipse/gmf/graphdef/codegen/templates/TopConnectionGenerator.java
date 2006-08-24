package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.graphdef.codegen.*;
import org.eclipse.emf.ecore.*;
import java.util.Iterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.codegen.util.CodeGenUtil;;

public class TopConnectionGenerator
{
  protected static String nl;
  public static synchronized TopConnectionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    TopConnectionGenerator result = new TopConnectionGenerator();
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
  protected final String TEXT_9 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_10 = "() {";
  protected final String TEXT_11 = NL;
  protected final String TEXT_12 = NL + "\t\tsetSourceDecoration(createSourceDecoration());";
  protected final String TEXT_13 = NL + "\t\tsetTargetDecoration(createTargetDecoration());";
  protected final String TEXT_14 = NL + "\t}" + NL;
  protected final String TEXT_15 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_16 = " createSourceDecoration() {";
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL + "\t\treturn df;" + NL + "\t}";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_21 = " createTargetDecoration() {";
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = NL + "\t\treturn df;" + NL + "\t}";
  protected final String TEXT_24 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GraphDefDispatcher.Args innerArgs = (GraphDefDispatcher.Args) ((Object[]) argument)[0];
final PolylineConnection figure = (PolylineConnection)innerArgs.getFigure();
final GraphDefDispatcher dispatcher = innerArgs.getDispatcher();
final ImportAssistant importManager = dispatcher.getImportManager();
final FigureQualifiedNameSwitch fqnSwitch = dispatcher.getFQNSwitch();

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

    stringBuffer.append(TEXT_9);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(dispatcher.dispatch("Shape", dispatcher.create(figure, "this")));
    if (figure.getSourceDecoration() != null) {
    stringBuffer.append(TEXT_12);
    }
if (figure.getTargetDecoration() != null) {
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    if (figure.getSourceDecoration() != null) {
	final String className = fqnSwitch.get(figure.getSourceDecoration(), importManager);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dispatcher.dispatch("instantiate", dispatcher.create(figure.getSourceDecoration(), "df")));
    stringBuffer.append(TEXT_18);
    } /*if sourceDecoration != null */ 
    stringBuffer.append(TEXT_19);
    if (figure.getTargetDecoration() != null) {
	final String className = fqnSwitch.get(figure.getTargetDecoration(), importManager);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(dispatcher.dispatch("instantiate", dispatcher.create(figure.getTargetDecoration(), "df")));
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    return stringBuffer.toString();
  }
}
