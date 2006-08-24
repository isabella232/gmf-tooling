package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.gmfgraph.util.*;
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
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends ";
  protected final String TEXT_4 = " {" + NL;
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_7 = " ";
  protected final String TEXT_8 = "() {" + NL + "\t\t";
  protected final String TEXT_9 = " result = new ";
  protected final String TEXT_10 = "();" + NL + "\t\t";
  protected final String TEXT_11 = NL + "\t\treturn result;" + NL + "\t}";
  protected final String TEXT_12 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_13 = "() {";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = NL + "\t\t";
  protected final String TEXT_16 = NL + "\t\tcreateContents();" + NL + "\t}" + NL;
  protected final String TEXT_17 = NL;
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean myUseLocalCoordinates = ";
  protected final String TEXT_21 = ";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean useLocalCoordinates() {" + NL + "\t\treturn myUseLocalCoordinates;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void setUseLocalCoordinates(boolean useLocalCoordinates) {" + NL + "\t\tmyUseLocalCoordinates = useLocalCoordinates;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = NL + "}" + NL + "\t";
  protected final String TEXT_24 = NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_25 = " ";
  protected final String TEXT_26 = " = ";
  protected final String TEXT_27 = ";";
  protected final String TEXT_28 = NL + "\t";
  protected final String TEXT_29 = NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_30 = " ";
  protected final String TEXT_31 = " = ";
  protected final String TEXT_32 = ";";
  protected final String TEXT_33 = NL + "}";
  protected final String TEXT_34 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
Object[] args = (Object[]) argument;
Figure figure = (Figure) args[0];
final ImportAssistant importManager = (ImportAssistant) args[1];
final FigureQualifiedNameSwitch fqnSwitch = (FigureQualifiedNameSwitch) args[2];
final GraphDefDispatcher dispatcher = (GraphDefDispatcher) args[3];

//[MG] FIXME: Why we need this? Is it in use somewhere?
final boolean isInnerClass = ((Boolean) args[4]).booleanValue();

    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_1);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(fqnSwitch.get(figure, importManager));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    
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
		

    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Border"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(bfmNextMethodName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(bfmNextImplClass);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(bfmNextImplClass);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(dispatcher.dispatch("customAttributes", new Object[] {bfmNext, dispatcher, "result"} ));
    stringBuffer.append(TEXT_11);
    		
		dispatcher.getAuxiliaryDataStorage().registerData(bfmNext, bfmNextMethodName);
	}
} //end of namespace

    stringBuffer.append(TEXT_12);
    stringBuffer.append(figure.getName());
    stringBuffer.append(TEXT_13);
    
GraphDefDispatcher.LayoutArgs dispatcherArgs = dispatcher.createLayoutArgs(figure, "this", "myGenLayoutManager", null);

    stringBuffer.append(TEXT_14);
    stringBuffer.append(dispatcher.dispatch("createLayout", dispatcherArgs));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(dispatcher.dispatch(figure, dispatcherArgs));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(dispatcher.dispatch("Children", dispatcherArgs));
    stringBuffer.append(TEXT_18);
    if (false == figure instanceof Polyline) {/*no much sense to define useLocalCoordinates for polyline and its descendants*/
    stringBuffer.append(TEXT_19);
    
// simple heuristic to detect need for local coordinates
boolean useLocalDefaultValue = false;
for (java.util.Iterator it = figure.getChildren().iterator(); it.hasNext(); ) {
	if (it.next() instanceof Polyline) {
		useLocalDefaultValue = true;
		break;
	}
}

    stringBuffer.append(TEXT_20);
    stringBuffer.append(useLocalDefaultValue);
    stringBuffer.append(TEXT_21);
    }
    stringBuffer.append(TEXT_22);
    
//input: [oeg].graphdef.codegen GraphDefDispatcher dispatcher
//input: boolean isInnerClass
if (isInnerClass){ /*put fields out of inner class body*/ 
    stringBuffer.append(TEXT_23);
    
//input: [oeg].graphdef.codegen GraphDefDispatcher dispatcher
for (Iterator allFields = dispatcher.getStaticFieldsManager().allFields(); allFields.hasNext();) {
	StaticFieldsManager.StaticField next = (StaticFieldsManager.StaticField)allFields.next(); 
    stringBuffer.append(TEXT_24);
    stringBuffer.append(next.getType());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(next.getValue());
    stringBuffer.append(TEXT_27);
    
}

     } else { 
    stringBuffer.append(TEXT_28);
    
//input: [oeg].graphdef.codegen GraphDefDispatcher dispatcher
for (Iterator allFields = dispatcher.getStaticFieldsManager().allFields(); allFields.hasNext();) {
	StaticFieldsManager.StaticField next = (StaticFieldsManager.StaticField)allFields.next(); 
    stringBuffer.append(TEXT_29);
    stringBuffer.append(next.getType());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(next.getValue());
    stringBuffer.append(TEXT_32);
    
}

    stringBuffer.append(TEXT_33);
    }
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_34);
    return stringBuffer.toString();
  }
}
