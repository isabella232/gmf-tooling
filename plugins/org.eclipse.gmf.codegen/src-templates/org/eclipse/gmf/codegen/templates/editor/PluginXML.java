package org.eclipse.gmf.codegen.templates.editor;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class PluginXML
{
  protected static String nl;
  public static synchronized PluginXML create(String lineSeparator)
  {
    nl = lineSeparator;
    PluginXML result = new PluginXML();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "<extension point=\"org.eclipse.emf.validation.constraintProviders\">" + NL + "\t<?gmfgen generated=\"true\"?>";
  protected final String TEXT_4 = NL + "\t<category" + NL + "\t\tid=\"";
  protected final String TEXT_5 = "\"" + NL + "\t\tmandatory=\"false\"" + NL + "\t\tname=\"";
  protected final String TEXT_6 = "\">" + NL + "\t<![CDATA[";
  protected final String TEXT_7 = "]]>" + NL + "\t</category>\t\t";
  protected final String TEXT_8 = NL + "\t<constraintProvider cache=\"true\">";
  protected final String TEXT_9 = NL + "\t\t<package namespaceUri=\"";
  protected final String TEXT_10 = "\"/>";
  protected final String TEXT_11 = NL + "\t\t<constraints categories=\"";
  protected final String TEXT_12 = "\">\t\t";
  protected final String TEXT_13 = NL + "\t\t\t<constraint id=\"";
  protected final String TEXT_14 = "\"";
  protected final String TEXT_15 = NL + "\t\t\t\tlang=\"Java\" class=\"";
  protected final String TEXT_16 = "\"";
  protected final String TEXT_17 = NL + "\t\t\t\tlang=\"OCL\"";
  protected final String TEXT_18 = NL + "\t\t\t\tname=\"";
  protected final String TEXT_19 = "\" mode=\"";
  protected final String TEXT_20 = "\"" + NL + "\t\t\t\tseverity=\"";
  protected final String TEXT_21 = "\" statusCode=\"";
  protected final String TEXT_22 = "\">";
  protected final String TEXT_23 = NL + "\t\t\t\t<![CDATA[";
  protected final String TEXT_24 = "]]>";
  protected final String TEXT_25 = "\t\t\t" + NL + "\t            <description><![CDATA[";
  protected final String TEXT_26 = "]]></description>" + NL + "\t            <message><![CDATA[";
  protected final String TEXT_27 = "]]></message>" + NL + "\t\t\t\t<target class=\"";
  protected final String TEXT_28 = "\"/>" + NL + "\t\t\t</constraint>";
  protected final String TEXT_29 = NL + "\t\t</constraints>";
  protected final String TEXT_30 = NL + "\t</constraintProvider>" + NL + "</extension>" + NL + "" + NL + "<extension point=\"org.eclipse.emf.validation.constraintBindings\">" + NL + "\t<?gmfgen generated=\"true\"?>";
  protected final String TEXT_31 = NL + "\t<clientContext default=\"false\" id=\"";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = "\">" + NL + "\t\t<selector class=\"";
  protected final String TEXT_34 = "\"/>" + NL + "\t</clientContext>" + NL + "\t<binding context=\"";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = "\">";
  protected final String TEXT_37 = "\t" + NL + "\t\t<constraint ref=\"";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = "\"/>";
  protected final String TEXT_40 = NL + "\t</binding>";
  protected final String TEXT_41 = "\t\t" + NL + "</extension>" + NL;
  protected final String TEXT_42 = NL + "<extension point=\"org.eclipse.emf.validation.ui.UIRegisteredClientContext\">" + NL + "\t<?gmfgen generated=\"true\"?>";
  protected final String TEXT_43 = NL + "\t<clientContext id=\"";
  protected final String TEXT_44 = "\"/>";
  protected final String TEXT_45 = NL + "</extension>";
  protected final String TEXT_46 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenPlugin genPlugin = (GenPlugin) argument;
final GenEditorGenerator editorGen = genPlugin.getEditorGen();
final GenDiagram genDiagram = editorGen.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
GenAuditContainer rootContainer = genDiagram.getEditorGen().getAudits();
if (genDiagram.getEditorGen().hasAudits()) {
	java.util.List containers = rootContainer.getAllAuditContainers();

    stringBuffer.append(TEXT_3);
    
	java.util.HashMap<GenAuditContainer, String> idMap = new java.util.HashMap<GenAuditContainer, String>();
	for(int i = 0; i < containers.size(); i++) {
		GenAuditContainer container = (GenAuditContainer)containers.get(i);
		idMap.put(container, container.getId() != null ? container.getId() : "category" + Integer.toString(i + 1));
	}
	java.util.HashMap<GenAuditContainer, String> pathMap = new java.util.HashMap<GenAuditContainer, String>();
	for(int i = 0; i < containers.size(); i++) {
		GenAuditContainer category = (GenAuditContainer)containers.get(i);
		java.util.List path = category.getPath();
		StringBuffer id = new StringBuffer();
		for(int pathPos = 0; pathPos < path.size(); pathPos++) {
			if(pathPos > 0) id.append('/');
			id.append(idMap.get(path.get(pathPos)));
		}
		pathMap.put(category, id.toString());

    stringBuffer.append(TEXT_4);
    stringBuffer.append(org.eclipse.gmf.internal.common.codegen.Conversions.escapeXML(id.toString()));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(org.eclipse.gmf.internal.common.codegen.Conversions.escapeXML(category.getName() != null ? category.getName() : id.toString()));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(category.getDescription() != null ? category.getDescription():"");
    stringBuffer.append(TEXT_7);
    
	} // end of categories loop

    stringBuffer.append(TEXT_8);
    
	for(java.util.Iterator packageIt = rootContainer.getAllTargetedModelPackages().iterator(); packageIt.hasNext();) {
		GenPackage genPackage = (GenPackage)packageIt.next();

    stringBuffer.append(TEXT_9);
    stringBuffer.append(genPackage.getNSURI());
    stringBuffer.append(TEXT_10);
    
	} // end of used model packages iteration
	int rulePos = 0;
	for(java.util.Iterator catIt = containers.iterator(); catIt.hasNext();) {
		GenAuditContainer category = (GenAuditContainer)catIt.next();

    stringBuffer.append(TEXT_11);
    stringBuffer.append(org.eclipse.gmf.internal.common.codegen.Conversions.escapeXML(pathMap.get(category).toString()));
    stringBuffer.append(TEXT_12);
    
		for(java.util.Iterator it = category.getAudits().iterator(); it.hasNext(); rulePos++) {
			GenAuditRule audit = (GenAuditRule)it.next();
			if(audit.getTarget() == null || (audit.getTarget().getTargetClass() == null)) continue;
			String targetClassName = audit.getTarget().getTargetClassModelQualifiedName();
			String modeAttr = audit.isUseInLiveMode() ? "Live" : "Batch";
			String name = audit.getName() != null ? audit.getName() : audit.getId();
			String message = audit.getMessage() != null ? audit.getMessage() : name + " audit violated";

    stringBuffer.append(TEXT_13);
    stringBuffer.append(org.eclipse.gmf.internal.common.codegen.Conversions.escapeXML(audit.getId()));
    stringBuffer.append(TEXT_14);
    			if(audit.requiresConstraintAdapter()) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(audit.getConstraintAdapterQualifiedClassName());
    stringBuffer.append(TEXT_16);
    			} else { 
    stringBuffer.append(TEXT_17);
    			} 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(org.eclipse.gmf.internal.common.codegen.Conversions.escapeXML(name));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(modeAttr);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(audit.getSeverity().getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(Integer.toString(200 + rulePos));
    stringBuffer.append(TEXT_22);
    			if(!audit.requiresConstraintAdapter()) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(audit.getRule() != null ? audit.getRule().getBody() : "");
    stringBuffer.append(TEXT_24);
    			} 
    stringBuffer.append(TEXT_25);
    stringBuffer.append(audit.getDescription() != null ? audit.getDescription():"");
    stringBuffer.append(TEXT_26);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(targetClassName);
    stringBuffer.append(TEXT_28);
    
		} // end of audits in category

    stringBuffer.append(TEXT_29);
    		
	} // end of category loop

    stringBuffer.append(TEXT_30);
    
	String pluginID = genDiagram.getEditorGen().getPlugin().getID();
	for(java.util.Iterator it = rootContainer.getAllRulesToTargetContextMap().entrySet().iterator(); it.hasNext();) {
		java.util.Map.Entry ctx2Rules = (java.util.Map.Entry)it.next();
		java.util.List rules = (java.util.List)ctx2Rules.getValue();
		if(rules.isEmpty()) continue;
		String ctxID = (String)ctx2Rules.getKey();
		GenAuditRule ruleTarget = (GenAuditRule)rules.get(0);

    stringBuffer.append(TEXT_31);
    stringBuffer.append(pluginID);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(ctxID);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(ruleTarget.getContextSelectorQualifiedClassName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(pluginID);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(ctxID);
    stringBuffer.append(TEXT_36);
    
		for(java.util.Iterator ruleIt = rules.iterator(); ruleIt.hasNext();) {
			GenAuditRule nextRule = (GenAuditRule)ruleIt.next();

    stringBuffer.append(TEXT_37);
    stringBuffer.append(pluginID);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(org.eclipse.gmf.internal.common.codegen.Conversions.escapeXML(nextRule.getId()));
    stringBuffer.append(TEXT_39);
    
		} // end of rules in context

    stringBuffer.append(TEXT_40);
    
	} // end of contexts iteration

    stringBuffer.append(TEXT_41);
    
	if(genDiagram.isLiveValidationUIFeedback()) { // UIRegisteredClientContext

    stringBuffer.append(TEXT_42);
    
		for(java.util.Iterator it = rootContainer.getAllRulesToTargetContextMap().keySet().iterator(); it.hasNext();) {
			String qualifiedCtxID = pluginID + "." + (String)it.next();

    stringBuffer.append(TEXT_43);
    stringBuffer.append(qualifiedCtxID);
    stringBuffer.append(TEXT_44);
    
		} // URI registered ctx iteration

    stringBuffer.append(TEXT_45);
    
	} // UIRegisteredClientContext

    
}

    stringBuffer.append(TEXT_46);
    return stringBuffer.toString();
  }
}
