package org.eclipse.gmf.codegen.templates.application;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class URIEditorInputProxyGenerator
{
  protected static String nl;
  public static synchronized URIEditorInputProxyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    URIEditorInputProxyGenerator result = new URIEditorInputProxyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.emf.common.ui.URIEditorInput;" + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;" + NL + "import org.eclipse.gmf.runtime.common.core.util.HashUtil;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.MEditingDomainElement;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class URIEditorInputProxy extends URIEditorInput implements MEditingDomainElement {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final URIEditorInput delegate;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final TransactionalEditingDomain domain;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic URIEditorInputProxy(URIEditorInput delegate, TransactionalEditingDomain domain) {" + NL + "\t\tsuper(delegate.getURI());" + NL + "\t\tthis.delegate = delegate;" + NL + "\t\tthis.domain = domain;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic TransactionalEditingDomain getEditingDomain() {" + NL + "\t\treturn domain;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean equals(Object obj) {" + NL + "\t\tif (obj instanceof URIEditorInputProxy) {" + NL + "\t\t\tURIEditorInputProxy another = (URIEditorInputProxy) obj;" + NL + "\t\t\treturn eq(delegate.getURI(), another.getURI()) && eq(domain, another.domain);" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static boolean eq(Object obj1, Object obj2) {" + NL + "\t\treturn obj1 == null ? obj2 == null : obj1.equals(obj2);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int hashCode() {" + NL + "\t\treturn HashUtil.hash(HashUtil.hash(delegate), domain);" + NL + "\t}" + NL + "}";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenApplication application = (GenApplication) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    {
	GenDiagram genDiagram = application.getEditorGen().getDiagram();

    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
