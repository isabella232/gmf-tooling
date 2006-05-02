package org.eclipse.gmf.graphdef.codegen.templates;

import org.eclipse.gmf.gmfgraph.*;
import org.eclipse.gmf.graphdef.codegen.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.gmfgraph.util.*;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import java.util.*;

public class FigureChildrenGenerator
{
  protected static String nl;
  public static synchronized FigureChildrenGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    FigureChildrenGenerator result = new FigureChildrenGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createContents(){";
  protected final String TEXT_2 = NL + "\t\t";
  protected final String TEXT_3 = NL + "\t\tsetFigure";
  protected final String TEXT_4 = "(";
  protected final String TEXT_5 = ");";
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = NL + "\t\t";
  protected final String TEXT_8 = ".add(";
  protected final String TEXT_9 = ", ";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\t}" + NL + "\t";
  protected final String TEXT_12 = NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_13 = " f";
  protected final String TEXT_14 = "; " + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_15 = " getFigure";
  protected final String TEXT_16 = "() {" + NL + "\t\treturn f";
  protected final String TEXT_17 = ";" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void setFigure";
  protected final String TEXT_18 = "(";
  protected final String TEXT_19 = " fig){" + NL + "\t\tf";
  protected final String TEXT_20 = " = fig;" + NL + "\t}" + NL;
  protected final String TEXT_21 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GraphDefDispatcher.LayoutArgs parentArgs = (GraphDefDispatcher.LayoutArgs) argument;
final Figure root = parentArgs.getFigure();
final GraphDefDispatcher dispatcher = parentArgs.getDispatcher();
final ImportAssistant importManager = dispatcher.getImportManager();

final List/*<Figure>*/ fieldsRequired = new LinkedList/*<Figure>*/();
final Stack/*GraphDefDispatcher.LayoutArgs*/ contextStack = new Stack/*GraphDefDispatcher.LayoutArgs*/();
final LinkedList queue = new LinkedList();
final Object marker = new Object();

class FieldSupport {
	private final Figure myRoot;

	public FieldSupport(Figure root){
		myRoot = root;
	}
	
	public boolean isFieldRequired(Figure descendant){
		return myRoot.equals(descendant.getParent()) || !descendant.getReferencingElements().isEmpty();
	}
}
final FieldSupport fieldSupport = new FieldSupport(root);


    stringBuffer.append(TEXT_1);
    
queue.addAll(root.getChildren());
int figureCount = 0;
while (!queue.isEmpty()){
	Object _nxt = queue.removeFirst();
	if (_nxt == marker){
		parentArgs = (GraphDefDispatcher.LayoutArgs)contextStack.pop();
		continue;
	}
	if (_nxt instanceof FigureRef) {
		throw new IllegalStateException("FIXME: sorry, don't support FigureRef for a while");
	}
	final Figure nextChild = (Figure) _nxt;	
	final String childVarName = "fig_" + figureCount;
	final String childLayoutManager = "layouter" + figureCount;
	final String childConstraint = "layData" + figureCount;
	figureCount++;
	
	// FIXME instantiate - FigureRef - dispatch to 'instantiate' template?
	GraphDefDispatcher.LayoutArgs nextLevelArgs = dispatcher.createLayoutArgs(nextChild, childVarName, childLayoutManager, childConstraint);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(dispatcher.dispatch("instantiate", nextLevelArgs));
    
if (fieldSupport.isFieldRequired(nextChild)){
	fieldsRequired.add(nextChild); 
    stringBuffer.append(TEXT_3);
    stringBuffer.append(nextChild.getName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(childVarName);
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    stringBuffer.append(dispatcher.dispatch("createLayoutData", nextLevelArgs));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(parentArgs.getVariableName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(childVarName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(childConstraint);
    stringBuffer.append(TEXT_10);
    
	if (!nextChild.getChildren().isEmpty()) {
		queue.addFirst(marker);
		queue.addAll(0, nextChild.getChildren());
		contextStack.push(parentArgs);
		parentArgs = nextLevelArgs; // go on processing children of new parentFigure
	} 
} // while

    stringBuffer.append(TEXT_11);
    
	final FigureQualifiedNameSwitch fqnSwitch = dispatcher.getFQNSwitch();
	for (Iterator fieldFigures = fieldsRequired.iterator(); fieldFigures.hasNext();){
		Figure next = (Figure)fieldFigures.next(); 
		final String nextClassName = fqnSwitch.get(next, importManager);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(nextClassName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(CodeGenUtil.capName(next.getName()));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(nextClassName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(CodeGenUtil.capName(next.getName()));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(next.getName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(nextClassName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(CodeGenUtil.capName(next.getName()));
    stringBuffer.append(TEXT_20);
    	}
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
