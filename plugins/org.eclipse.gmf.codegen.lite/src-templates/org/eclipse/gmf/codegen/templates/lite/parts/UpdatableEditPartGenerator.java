package org.eclipse.gmf.codegen.templates.lite.parts;

import org.eclipse.gmf.common.codegen.*;

public class UpdatableEditPartGenerator
{
  protected static String nl;
  public static synchronized UpdatableEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    UpdatableEditPartGenerator result = new UpdatableEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "import java.util.ArrayList;" + NL + "import java.util.Collection;" + NL + "import java.util.Iterator;" + NL + "" + NL + "import org.eclipse.emf.common.notify.Notification;" + NL + "import org.eclipse.emf.ecore.EStructuralFeature;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public interface IUpdatableEditPart {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Refresher getRefresher(EStructuralFeature feature, Notification msg);" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic interface Refresher {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void refresh();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic class CompositeRefresher implements Refresher {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void addRefresher(Refresher refresher) {" + NL + "\t\t\trefreshers.add(refresher);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void removeRefresher(Refresher refresher) {" + NL + "\t\t\trefreshers.remove(refresher);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void refresh() {" + NL + "\t\t\tfor(Iterator it = refreshers.iterator(); it.hasNext(); ) {" + NL + "\t\t\t\tRefresher next = (Refresher) it.next();" + NL + "\t\t\t\tnext.refresh();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate Collection/*<Refresher>*/ refreshers = new ArrayList();" + NL + "\t}" + NL + "}";
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
importManager.emitPackageStatement(stringBuffer);

    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
