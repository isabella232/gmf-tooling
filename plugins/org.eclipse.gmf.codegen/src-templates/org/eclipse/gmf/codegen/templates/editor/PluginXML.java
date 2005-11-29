package org.eclipse.gmf.codegen.templates.editor;

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
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.0\"?>" + NL + "<plugin>" + NL + "" + NL + "   <extension point=\"org.eclipse.core.runtime.preferences\">" + NL + "      <initializer class=\"";
  protected final String TEXT_2 = "\"/>" + NL + "   </extension>" + NL + "" + NL + "  <extension point=\"org.eclipse.team.core.fileTypes\">" + NL + "      <fileTypes" + NL + "         type=\"text\"" + NL + "         extension=\"";
  protected final String TEXT_3 = "\">" + NL + "      </fileTypes>" + NL + "  </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.emf.ecore.extension_parser\">" + NL + "      <parser" + NL + "         type=\"";
  protected final String TEXT_4 = "\"" + NL + "         class=\"org.eclipse.gmf.runtime.emf.core.resources.MResourceFactory\">" + NL + "      </parser>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.editors\">" + NL + "     <editor" + NL + "        id=\"";
  protected final String TEXT_5 = "ID\"" + NL + "        name=\"";
  protected final String TEXT_6 = " Diagram Editor\"" + NL + "        icon=\"icons/full/obj16/";
  protected final String TEXT_7 = "ModelFile.gif\"" + NL + "        extensions=\"";
  protected final String TEXT_8 = "\"" + NL + "        default=\"true\"" + NL + "        class=\"";
  protected final String TEXT_9 = "\"" + NL + "        matchingStrategy=\"";
  protected final String TEXT_10 = "\"" + NL + "        contributorClass=\"";
  protected final String TEXT_11 = "\">" + NL + "     </editor>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.newWizards\">" + NL + "  \t  <wizard" + NL + "  \t     name=\"";
  protected final String TEXT_12 = " Diagram\"" + NL + "  \t     icon=\"icons/full/obj16/";
  protected final String TEXT_13 = "ModelFile.gif\"" + NL + "  \t     category=\"org.eclipse.ui.Examples\"" + NL + "  \t     class=\"";
  protected final String TEXT_14 = "\"" + NL + "  \t     id=\"";
  protected final String TEXT_15 = "ID\">" + NL + "  \t  \t <description>" + NL + "  \t  \t\tCreates ";
  protected final String TEXT_16 = " diagram." + NL + "  \t  \t </description>  " + NL + "      </wizard>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.popupMenus\">" + NL + "      <objectContribution" + NL + "            id=\"";
  protected final String TEXT_17 = ".ui.objectContribution.IFile1\"" + NL + "            nameFilter=\"*.";
  protected final String TEXT_18 = "\"" + NL + "            objectClass=\"org.eclipse.core.resources.IFile\">" + NL + "         <action" + NL + "               label=\"Initialize ";
  protected final String TEXT_19 = " diagram file\"" + NL + "               class=\"";
  protected final String TEXT_20 = "\"" + NL + "               menubarPath=\"additions\"" + NL + "               enablesFor=\"1\"" + NL + "               id=\"";
  protected final String TEXT_21 = "ID\">" + NL + "         </action>" + NL + "      </objectContribution>            " + NL + "  </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.action.globalActionHandlerProviders\">" + NL + "      <GlobalActionHandlerProvider" + NL + "         class=\"org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandlerProvider\"" + NL + "         id=\"";
  protected final String TEXT_22 = "Presentation\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "         <ViewId id=\"";
  protected final String TEXT_23 = "ID\">" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart\">" + NL + "               <GlobalActionId actionId=\"delete\"/>" + NL + "            </ElementType>" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart\">" + NL + "               <GlobalActionId actionId=\"save\"/>" + NL + "            </ElementType>" + NL + "         </ViewId>" + NL + "      </GlobalActionHandlerProvider>";
  protected final String TEXT_24 = NL + "      <GlobalActionHandlerProvider" + NL + "         class=\"org.eclipse.gmf.runtime.diagram.ui.printing.render.providers.DiagramWithPrintGlobalActionHandlerProvider\"" + NL + "         id=\"";
  protected final String TEXT_25 = "PresentationPrint\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "         <ViewId id=\"";
  protected final String TEXT_26 = "ID\">" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart\">" + NL + "               <GlobalActionId actionId=\"print\"/>" + NL + "            </ElementType>" + NL + "         </ViewId>" + NL + "      </GlobalActionHandlerProvider>";
  protected final String TEXT_27 = NL + "      <GlobalActionHandlerProvider" + NL + "         class=\"org.eclipse.gmf.runtime.diagram.ui.providers.ide.providers.DiagramIDEGlobalActionHandlerProvider\"" + NL + "         id=\"";
  protected final String TEXT_28 = "PresentationIDE\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "         <ViewId id=\"";
  protected final String TEXT_29 = "ID\">" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart\">" + NL + "               <GlobalActionId actionId=\"bookmark\"/>" + NL + "            </ElementType>" + NL + "         </ViewId>" + NL + "      </GlobalActionHandlerProvider>" + NL + "      <GlobalActionHandlerProvider" + NL + "            class=\"org.eclipse.gmf.runtime.diagram.ui.render.providers.DiagramUIRenderGlobalActionHandlerProvider\"" + NL + "            id=\"";
  protected final String TEXT_30 = "Render\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "         <ViewId id=\"";
  protected final String TEXT_31 = "ID\">" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart\">" + NL + "               <GlobalActionId actionId=\"cut\"/>" + NL + "               <GlobalActionId actionId=\"copy\"/>" + NL + "               <GlobalActionId actionId=\"paste\"/>" + NL + "            </ElementType>" + NL + "         </ViewId>" + NL + "      </GlobalActionHandlerProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.diagram.core.viewProviders\">" + NL + "      <viewProvider class=\"";
  protected final String TEXT_32 = "\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "         <context viewClass=\"org.eclipse.gmf.runtime.notation.Diagram\" semanticHints=\"";
  protected final String TEXT_33 = "\"/>" + NL + "         <context viewClass=\"org.eclipse.gmf.runtime.notation.Node\" semanticHints=\"\"/>" + NL + "         <context viewClass=\"org.eclipse.gmf.runtime.notation.Edge\" semanticHints=\"\"/>" + NL + "      </viewProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.diagram.ui.editpartProviders\">" + NL + "      <editpartProvider class=\"";
  protected final String TEXT_34 = "\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "      </editpartProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.emf.core.MetaModelProviders\">" + NL + "      <MetaModelProvider class=\"";
  protected final String TEXT_35 = "\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "      </MetaModelProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.emf.ui.modelingAssistantProviders\">" + NL + "      <modelingAssistantProvider class=\"";
  protected final String TEXT_36 = "\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "      </modelingAssistantProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.properties.propertiesProviders\">" + NL + "      <PropertiesProvider" + NL + "            verifyPluginLoaded=\"false\"" + NL + "            class=\"";
  protected final String TEXT_37 = "\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "      </PropertiesProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.iconProviders\">" + NL + "      <IconProvider class=\"";
  protected final String TEXT_38 = "\">" + NL + "         <Priority name=\"Medium\"/>" + NL + "      </IconProvider>" + NL + "   </extension>" + NL + "" + NL + "</plugin>";
  protected final String TEXT_39 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) argument;
final GenModel genModel = genDiagram.getEMFGenModel();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getPreferenceInitializerQualifiedClassName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genDiagram.getDiagramFileExtension());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getDiagramFileExtension());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditorQualifiedClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getDiagramFileExtension());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getEditorQualifiedClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genDiagram.getMatchingStrategyQualifiedClassName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getActionBarContributorQualifiedClassName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genDiagram.getCreationWizardQualifiedClassName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genDiagram.getCreationWizardQualifiedClassName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genDiagram.getPluginID());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getGenPackage().getPrefix().toLowerCase());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genDiagram.getDiagramFileExtension());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genDiagram.getEditorQualifiedClassName());
    stringBuffer.append(TEXT_23);
    if (genDiagram.isPrintingEnabled()) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genDiagram.getEditorQualifiedClassName());
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genDiagram.getEditorQualifiedClassName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genDiagram.getEditorQualifiedClassName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genDiagram.getNotationViewProviderQualifiedClassName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genDiagram.getEditPartProviderQualifiedClassName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genDiagram.getMetamodelSupportProviderQualifiedClassName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genDiagram.getModelingAssistantProviderQualifiedClassName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genDiagram.getPropertyProviderQualifiedClassName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genDiagram.getIconProviderQualifiedClassName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(TEXT_39);
    return stringBuffer.toString();
  }
}
