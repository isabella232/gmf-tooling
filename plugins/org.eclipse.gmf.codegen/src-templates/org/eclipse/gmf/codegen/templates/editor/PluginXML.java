package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;

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
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.0\"?>" + NL + "<plugin" + NL + "    name=\"";
  protected final String TEXT_2 = "\"" + NL + "    id=\"";
  protected final String TEXT_3 = "\"" + NL + "    version=\"1.0.0\"" + NL + "    class=\"";
  protected final String TEXT_4 = "\"" + NL + "    provider-name = \"";
  protected final String TEXT_5 = "\">" + NL + "" + NL + "  <requires>" + NL + "    <import plugin=\"org.eclipse.core.runtime\"/>" + NL + "    <import plugin=\"org.eclipse.core.resources\"/>" + NL + "    <import plugin=\"org.eclipse.jface\"/>" + NL + "    <import plugin=\"org.eclipse.ui.ide\"/>" + NL + "    <import plugin=\"org.eclipse.ui.views\"/>" + NL + "    <import plugin=\"org.eclipse.ui.workbench\"/>" + NL + "    <import plugin=\"org.eclipse.emf.ecore\"/>";
  protected final String TEXT_6 = NL + "    <import plugin=\"org.eclipse.emf.edit.ui\"/>" + NL + "    <import plugin=\"org.eclipse.gef\" export=\"true\"/>" + NL + "    <import plugin=\"org.eclipse.gmf.runtime.emf.commands.core\"/>" + NL + "    <import plugin=\"org.eclipse.gmf.runtime.diagram.ui\"/>";
  protected final String TEXT_7 = NL + "    <import plugin=\"org.eclipse.gmf.runtime.diagram.ui.printing\"/>";
  protected final String TEXT_8 = NL + "    <import plugin=\"org.eclipse.gmf.runtime.diagram.ui.providers\"/>" + NL + "    <import plugin=\"org.eclipse.gmf.runtime.diagram.ui.providers.ide\"/>" + NL + "    <import plugin=\"org.eclipse.gmf.runtime.diagram.ui.render\"/>" + NL + "    <import plugin=\"org.eclipse.gmf.runtime.diagram.ui.resources.editor\"/>" + NL + "    <import plugin=\"org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide\"/>" + NL + "    <import plugin=\"org.eclipse.gmf.runtime.notation.providers\"/>";
  protected final String TEXT_9 = NL + "    <import plugin=\"";
  protected final String TEXT_10 = "\" export=\"true\"/>";
  protected final String TEXT_11 = NL + "  </requires>" + NL + "" + NL + "  <runtime>" + NL + "    <library name=\"plugin.jar\">" + NL + "      <export name=\"*\"/>" + NL + "    </library>" + NL + "  </runtime>" + NL + "" + NL + "   <extension point=\"org.eclipse.core.runtime.preferences\">" + NL + "      <initializer class=\"";
  protected final String TEXT_12 = "\"/>" + NL + "   </extension>" + NL + "" + NL + "  <extension point=\"org.eclipse.team.core.fileTypes\">" + NL + "      <fileTypes" + NL + "         type=\"text\"" + NL + "         extension=\"";
  protected final String TEXT_13 = "\">" + NL + "      </fileTypes>" + NL + "  </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.emf.ecore.extension_parser\">" + NL + "      <parser" + NL + "         type=\"";
  protected final String TEXT_14 = "\"" + NL + "         class=\"org.eclipse.gmf.runtime.emf.core.resources.MResourceFactory\">" + NL + "      </parser>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.editors\">" + NL + "     <editor" + NL + "        id=\"";
  protected final String TEXT_15 = "ID\"" + NL + "        name=\"";
  protected final String TEXT_16 = " Diagram Editor\"" + NL + "        icon=\"icons/full/obj16/";
  protected final String TEXT_17 = "ModelFile.gif\"" + NL + "        extensions=\"";
  protected final String TEXT_18 = "\"" + NL + "        default=\"true\"" + NL + "        class=\"";
  protected final String TEXT_19 = "\"" + NL + "        matchingStrategy=\"";
  protected final String TEXT_20 = "\"" + NL + "        contributorClass=\"";
  protected final String TEXT_21 = "\">" + NL + "     </editor>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.newWizards\">" + NL + "  \t  <wizard" + NL + "  \t     name=\"";
  protected final String TEXT_22 = " Diagram\"" + NL + "  \t     icon=\"icons/full/obj16/";
  protected final String TEXT_23 = "ModelFile.gif\"" + NL + "  \t     category=\"org.eclipse.ui.Examples\"" + NL + "  \t     class=\"";
  protected final String TEXT_24 = "\"" + NL + "  \t     id=\"";
  protected final String TEXT_25 = "ID\">" + NL + "  \t  \t <description>" + NL + "  \t  \t\tCreates ";
  protected final String TEXT_26 = " diagram." + NL + "  \t  \t </description>  " + NL + "      </wizard>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.popupMenus\">" + NL + "      <objectContribution" + NL + "            id=\"";
  protected final String TEXT_27 = ".ui.objectContribution.IFile1\"" + NL + "            nameFilter=\"*.";
  protected final String TEXT_28 = "\"" + NL + "            objectClass=\"org.eclipse.core.resources.IFile\">" + NL + "         <action" + NL + "               label=\"Initialize ";
  protected final String TEXT_29 = " diagram file\"" + NL + "               class=\"";
  protected final String TEXT_30 = "\"" + NL + "               menubarPath=\"additions\"" + NL + "               enablesFor=\"1\"" + NL + "               id=\"";
  protected final String TEXT_31 = "ID\">" + NL + "         </action>" + NL + "      </objectContribution>            " + NL + "  </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.action.globalActionHandlerProviders\">" + NL + "      <GlobalActionHandlerProvider" + NL + "         class=\"org.eclipse.gmf.runtime.diagram.ui.providers.PresentationGlobalActionHandlerProvider\"" + NL + "         id=\"";
  protected final String TEXT_32 = "Presentation\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "         <ViewId id=\"";
  protected final String TEXT_33 = "ID\">" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart\">" + NL + "               <GlobalActionId actionId=\"delete\"/>" + NL + "            </ElementType>" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart\">" + NL + "               <GlobalActionId actionId=\"save\"/>" + NL + "            </ElementType>" + NL + "         </ViewId>" + NL + "      </GlobalActionHandlerProvider>";
  protected final String TEXT_34 = NL + "      <GlobalActionHandlerProvider" + NL + "         class=\"org.eclipse.gmf.runtime.diagram.ui.printing.internal.providers.PresentationWithPrintGlobalActionHandlerProvider\"" + NL + "         id=\"";
  protected final String TEXT_35 = "PresentationPrint\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "         <ViewId id=\"";
  protected final String TEXT_36 = "ID\">" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart\">" + NL + "               <GlobalActionId actionId=\"print\"/>" + NL + "            </ElementType>" + NL + "         </ViewId>" + NL + "      </GlobalActionHandlerProvider>";
  protected final String TEXT_37 = NL + "      <GlobalActionHandlerProvider" + NL + "         class=\"org.eclipse.gmf.runtime.diagram.ui.providers.ide.providers.DiagramIDEGlobalActionHandlerProvider\"" + NL + "         id=\"";
  protected final String TEXT_38 = "PresentationIDE\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "         <ViewId id=\"";
  protected final String TEXT_39 = "ID\">" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart\">" + NL + "               <GlobalActionId actionId=\"bookmark\"/>" + NL + "            </ElementType>" + NL + "         </ViewId>" + NL + "      </GlobalActionHandlerProvider>" + NL + "      <GlobalActionHandlerProvider" + NL + "            class=\"org.eclipse.gmf.runtime.diagram.ui.render.providers.DiagramUIRenderGlobalActionHandlerProvider\"" + NL + "            id=\"";
  protected final String TEXT_40 = "Render\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "         <ViewId id=\"";
  protected final String TEXT_41 = "ID\">" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart\">" + NL + "               <GlobalActionId actionId=\"cut\"/>" + NL + "               <GlobalActionId actionId=\"copy\"/>" + NL + "               <GlobalActionId actionId=\"paste\"/>" + NL + "            </ElementType>" + NL + "         </ViewId>" + NL + "      </GlobalActionHandlerProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.diagram.core.viewProviders\">" + NL + "      <viewProvider class=\"";
  protected final String TEXT_42 = "\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "         <context viewClass=\"org.eclipse.gmf.runtime.notation.Diagram\" semanticHints=\"";
  protected final String TEXT_43 = "\"/>" + NL + "         <context viewClass=\"org.eclipse.gmf.runtime.notation.Node\" semanticHints=\"\"/>" + NL + "         <context viewClass=\"org.eclipse.gmf.runtime.notation.Edge\" semanticHints=\"\"/>" + NL + "      </viewProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.diagram.ui.editpartProviders\">" + NL + "      <editpartProvider class=\"";
  protected final String TEXT_44 = "\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "      </editpartProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.emf.core.MetaModelProviders\">" + NL + "      <MetaModelProvider class=\"";
  protected final String TEXT_45 = "\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "      </MetaModelProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.emf.ui.modelingAssistantProviders\">" + NL + "      <modelingAssistantProvider class=\"";
  protected final String TEXT_46 = "\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "      </modelingAssistantProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.iconProviders\">" + NL + "      <IconProvider class=\"";
  protected final String TEXT_47 = "\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "      </IconProvider>" + NL + "   </extension>" + NL + "" + NL + "</plugin>";
  protected final String TEXT_48 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    GenModel genModel = genDiagram.getEMFGenModel();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getPluginName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genDiagram.getPluginID());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getPluginQualifiedClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getProviderName());
    stringBuffer.append(TEXT_5);
    
	// XXX org.eclipse.emf.edit.ui is for ExtendedImageRegistry. 
	// FIXME move image registry to plugin class code

    stringBuffer.append(TEXT_6);
    if (genDiagram.isPrintingEnabled()) {
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    
Set requiredPluginIDs = new LinkedHashSet();
requiredPluginIDs.add(genModel.getModelPluginID());
requiredPluginIDs.add(genModel.getEditPluginID());

for (Iterator it = genModel.getAllUsedGenPackagesWithClassifiers().iterator(); it.hasNext();) {
	GenModel nextGenModel = ((GenPackage) it.next()).getGenModel();
	if (nextGenModel.hasEditSupport()) {
		requiredPluginIDs.add(nextGenModel.getEditPluginID());
	}
}

String[] requiredPlugins = genDiagram.getRequiredPluginIDs();
if (requiredPlugins == null) {
	requiredPlugins = new String[0];
}
requiredPluginIDs.addAll(Arrays.asList(requiredPlugins));

for (Iterator it = requiredPluginIDs.iterator(); it.hasNext();) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(it.next());
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genDiagram.getPreferenceInitializerQualifiedClassName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genDiagram.getDiagramFileExtension());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genDiagram.getDiagramFileExtension());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genDiagram.getEditorQualifiedClassName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genDiagram.getDiagramFileExtension());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genDiagram.getEditorQualifiedClassName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genDiagram.getMatchingStrategyQualifiedClassName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genDiagram.getActionBarContributorQualifiedClassName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genDiagram.getCreationWizardQualifiedClassName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genDiagram.getCreationWizardQualifiedClassName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genDiagram.getPluginID());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getGenPackage().getPrefix().toLowerCase());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genDiagram.getDiagramFileExtension());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genDiagram.getEditorQualifiedClassName());
    stringBuffer.append(TEXT_33);
    if (genDiagram.isPrintingEnabled()) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genDiagram.getEditorQualifiedClassName());
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genDiagram.getEditorQualifiedClassName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genDiagram.getEditorQualifiedClassName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(genDiagram.getViewProviderQualifiedClassName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genDiagram.getEditPartProviderQualifiedClassName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genDiagram.getMetamodelSupportProviderQualifiedClassName());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(genDiagram.getModelingAssistantProviderQualifiedClassName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genDiagram.getIconProviderQualifiedClassName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(TEXT_48);
    return stringBuffer.toString();
  }
}
