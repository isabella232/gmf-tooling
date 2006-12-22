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
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.0\"?>";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "<!--";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + "-->";
  protected final String TEXT_6 = NL + "<plugin>" + NL + "" + NL + "   <extension point=\"org.eclipse.core.runtime.preferences\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <initializer class=\"";
  protected final String TEXT_7 = "\"/>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.team.core.fileTypes\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <fileTypes" + NL + "         type=\"text\"" + NL + "         extension=\"";
  protected final String TEXT_8 = "\">" + NL + "      </fileTypes>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.emf.ecore.extension_parser\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <parser" + NL + "         type=\"";
  protected final String TEXT_9 = "\"" + NL + "         class=\"org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory\">" + NL + "      </parser>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.editors\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "     <editor" + NL + "        id=\"";
  protected final String TEXT_10 = "\"" + NL + "        name=\"%editorName\"" + NL + "        icon=\"";
  protected final String TEXT_11 = "\"" + NL + "        extensions=\"";
  protected final String TEXT_12 = "\"" + NL + "        default=\"true\"" + NL + "        class=\"";
  protected final String TEXT_13 = "\"" + NL + "        matchingStrategy=\"";
  protected final String TEXT_14 = "\"" + NL + "        contributorClass=\"";
  protected final String TEXT_15 = "\">" + NL + "     </editor>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.newWizards\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "  \t  <wizard" + NL + "  \t     name=\"%newWizardName\"" + NL + "  \t     icon=\"";
  protected final String TEXT_16 = "\"" + NL + "  \t     category=\"";
  protected final String TEXT_17 = "\"" + NL + "  \t     class=\"";
  protected final String TEXT_18 = "\"" + NL + "  \t     id=\"";
  protected final String TEXT_19 = "ID\">" + NL + "  \t  \t <description>%newWizardDesc</description>  " + NL + "      </wizard>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.popupMenus\">" + NL + "      <?gmfgen generated=\"true\"?>";
  protected final String TEXT_20 = NL + "      <objectContribution" + NL + "            id=\"";
  protected final String TEXT_21 = ".ui.objectContribution.IFile1\"" + NL + "            nameFilter=\"*.";
  protected final String TEXT_22 = "\"" + NL + "            objectClass=\"org.eclipse.core.resources.IFile\">" + NL + "         <action" + NL + "               label=\"%initDiagramActionLabel\"" + NL + "               class=\"";
  protected final String TEXT_23 = "\"" + NL + "               menubarPath=\"additions\"" + NL + "               enablesFor=\"1\"" + NL + "               id=\"";
  protected final String TEXT_24 = "ID\">" + NL + "         </action>" + NL + "      </objectContribution>  ";
  protected final String TEXT_25 = NL + "      <objectContribution" + NL + "            adaptable=\"false\"" + NL + "            id=\"";
  protected final String TEXT_26 = ".ui.objectContribution.";
  protected final String TEXT_27 = "1\"" + NL + "            objectClass=\"";
  protected final String TEXT_28 = "\">" + NL + "         <action" + NL + "               class=\"";
  protected final String TEXT_29 = "\"" + NL + "               enablesFor=\"1\"" + NL + "               id=\"";
  protected final String TEXT_30 = "ID\"" + NL + "               label=\"%createShortcutActionLabel\"" + NL + "               menubarPath=\"additions\">" + NL + "         </action>" + NL + "      </objectContribution>                      ";
  protected final String TEXT_31 = NL + "      <objectContribution" + NL + "            adaptable=\"false\"" + NL + "            id=\"";
  protected final String TEXT_32 = ".ui.objectContribution.";
  protected final String TEXT_33 = "2\"" + NL + "            objectClass=\"";
  protected final String TEXT_34 = "\">" + NL + "         <action" + NL + "               class=\"";
  protected final String TEXT_35 = "\"" + NL + "               enablesFor=\"1\"" + NL + "               id=\"";
  protected final String TEXT_36 = "ID\"" + NL + "               label=\"%loadResourceActionLabel\"" + NL + "               menubarPath=\"additions\">" + NL + "         </action>" + NL + "      </objectContribution>                      " + NL + "  </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.action.contributionItemProviders\">" + NL + "      <?gmfgen generated=\"true\"?>";
  protected final String TEXT_37 = NL + "      <contributionItemProvider class=\"";
  protected final String TEXT_38 = "\">" + NL + "         <Priority name=\"Low\">" + NL + "         </Priority>" + NL + "         <partContribution id=\"";
  protected final String TEXT_39 = "\">" + NL + "            <partAction menubarPath=\"/file/print\" id=\"printPreviewAction\">" + NL + "            </partAction>" + NL + "         </partContribution>" + NL + "      </contributionItemProvider>";
  protected final String TEXT_40 = NL + "      <contributionItemProvider" + NL + "            class=\"org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContributionItemProvider\"" + NL + "            checkPluginLoaded=\"false\">" + NL + "         <Priority name=\"Low\"/>";
  protected final String TEXT_41 = NL + "         <popupContribution class=\"org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider\">" + NL + "            <popupStructuredContributionCriteria objectClass=\"";
  protected final String TEXT_42 = "\"/>" + NL + "            <popupPredefinedItem id=\"deleteFromDiagramAction\" remove=\"true\"/>" + NL + "            <popupPredefinedItem id=\"deleteFromModelAction\" remove=\"true\"/>" + NL + "         </popupContribution>";
  protected final String TEXT_43 = NL + "         <popupContribution class=\"org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider\">" + NL + "            <popupStructuredContributionCriteria objectClass=\"";
  protected final String TEXT_44 = "\"/>" + NL + "            <popupAction path=\"/editGroup\" id=\"deleteFromModelAction\"/>";
  protected final String TEXT_45 = NL + "            <popupPredefinedItem id=\"deleteFromDiagramAction\" remove=\"true\"/>";
  protected final String TEXT_46 = NL + "         </popupContribution>";
  protected final String TEXT_47 = NL + "         <popupContribution class=\"org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider\">" + NL + "            <popupStructuredContributionCriteria objectClass=\"";
  protected final String TEXT_48 = "\"/>" + NL + "            <popupPredefinedItem id=\"deleteFromDiagramAction\" remove=\"true\"/>" + NL + "         </popupContribution>";
  protected final String TEXT_49 = NL + "      </contributionItemProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.action.globalActionHandlerProviders\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <GlobalActionHandlerProvider" + NL + "         class=\"org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandlerProvider\"" + NL + "         id=\"";
  protected final String TEXT_50 = "Presentation\">" + NL + "         <Priority name=\"Lowest\"/>" + NL + "         <ViewId id=\"";
  protected final String TEXT_51 = "\">" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart\">" + NL + "               <GlobalActionId actionId=\"delete\"/>" + NL + "            </ElementType>" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart\">" + NL + "               <GlobalActionId actionId=\"save\"/>" + NL + "            </ElementType>" + NL + "         </ViewId>" + NL + "      </GlobalActionHandlerProvider>";
  protected final String TEXT_52 = NL + "      <GlobalActionHandlerProvider" + NL + "         class=\"org.eclipse.gmf.runtime.diagram.ui.printing.render.providers.DiagramWithPrintGlobalActionHandlerProvider\"" + NL + "         id=\"";
  protected final String TEXT_53 = "PresentationPrint\">" + NL + "         <Priority name=\"Lowest\"/>" + NL + "         <ViewId id=\"";
  protected final String TEXT_54 = "\">" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart\">" + NL + "               <GlobalActionId actionId=\"print\"/>" + NL + "            </ElementType>" + NL + "         </ViewId>" + NL + "      </GlobalActionHandlerProvider>";
  protected final String TEXT_55 = NL + "      <GlobalActionHandlerProvider" + NL + "         class=\"org.eclipse.gmf.runtime.diagram.ui.providers.ide.providers.DiagramIDEGlobalActionHandlerProvider\"" + NL + "         id=\"";
  protected final String TEXT_56 = "PresentationIDE\">" + NL + "         <Priority name=\"Lowest\"/>" + NL + "         <ViewId id=\"";
  protected final String TEXT_57 = "\">" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart\">" + NL + "               <GlobalActionId actionId=\"bookmark\"/>" + NL + "            </ElementType>" + NL + "         </ViewId>" + NL + "      </GlobalActionHandlerProvider>";
  protected final String TEXT_58 = NL + "      <GlobalActionHandlerProvider" + NL + "            class=\"org.eclipse.gmf.runtime.diagram.ui.render.providers.DiagramUIRenderGlobalActionHandlerProvider\"" + NL + "            id=\"";
  protected final String TEXT_59 = "Render\">" + NL + "         <Priority name=\"Lowest\"/>" + NL + "         <ViewId id=\"";
  protected final String TEXT_60 = "\">" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart\">" + NL + "               <GlobalActionId actionId=\"cut\"/>" + NL + "               <GlobalActionId actionId=\"copy\"/>" + NL + "               <GlobalActionId actionId=\"paste\"/>" + NL + "            </ElementType>" + NL + "         </ViewId>" + NL + "      </GlobalActionHandlerProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.diagram.core.viewProviders\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <viewProvider class=\"";
  protected final String TEXT_61 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_62 = "\"/>" + NL + "         <context viewClass=\"org.eclipse.gmf.runtime.notation.Diagram\" semanticHints=\"";
  protected final String TEXT_63 = "\"/>" + NL + "         <context viewClass=\"org.eclipse.gmf.runtime.notation.Node\" semanticHints=\"\"/>" + NL + "         <context viewClass=\"org.eclipse.gmf.runtime.notation.Edge\" semanticHints=\"\"/>" + NL + "      </viewProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.diagram.ui.editpartProviders\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <editpartProvider class=\"";
  protected final String TEXT_64 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_65 = "\"/>" + NL + "      </editpartProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.emf.ui.modelingAssistantProviders\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <modelingAssistantProvider class=\"";
  protected final String TEXT_66 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_67 = "\"/>" + NL + "      </modelingAssistantProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.iconProviders\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <IconProvider class=\"";
  protected final String TEXT_68 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_69 = "\"/>" + NL + "      </IconProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.parserProviders\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <ParserProvider class=\"";
  protected final String TEXT_70 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_71 = "\"/>" + NL + "      </ParserProvider>" + NL + "   </extension>";
  protected final String TEXT_72 = NL + NL + "   <extension point=\"org.eclipse.gmf.runtime.diagram.ui.decoratorProviders\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <decoratorProvider class=\"";
  protected final String TEXT_73 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_74 = "\"/>" + NL + "      </decoratorProvider>" + NL + "   </extension>";
  protected final String TEXT_75 = NL + NL + "   <extension point=\"org.eclipse.gmf.runtime.emf.type.core.elementTypes\">" + NL + "      <?gmfgen generated=\"true\"?>";
  protected final String TEXT_76 = NL;
  protected final String TEXT_77 = NL + "      <metamodel nsURI=\"";
  protected final String TEXT_78 = "\">" + NL + "         <metamodelType" + NL + "               id=\"";
  protected final String TEXT_79 = "\"";
  protected final String TEXT_80 = NL + "               name=\"";
  protected final String TEXT_81 = "\"";
  protected final String TEXT_82 = NL + "               kind=\"org.eclipse.gmf.runtime.emf.type.core.IHintedType\"" + NL + "               eclass=\"";
  protected final String TEXT_83 = "\"" + NL + "               edithelper=\"";
  protected final String TEXT_84 = "\">" + NL + "            <param name=\"semanticHint\" value=\"";
  protected final String TEXT_85 = "\"/>" + NL + "         </metamodelType>" + NL + "      </metamodel>";
  protected final String TEXT_86 = NL + "      <metamodel nsURI=\"";
  protected final String TEXT_87 = "\">";
  protected final String TEXT_88 = NL + "         <specializationType" + NL + "               id=\"";
  protected final String TEXT_89 = "\"";
  protected final String TEXT_90 = NL + "               name=\"";
  protected final String TEXT_91 = "\"";
  protected final String TEXT_92 = NL + "               kind=\"org.eclipse.gmf.runtime.emf.type.core.IHintedType\"" + NL + "               edithelperadvice=\"";
  protected final String TEXT_93 = "\">" + NL + "            <specializes id=\"";
  protected final String TEXT_94 = "\"/>" + NL + "            <param name=\"semanticHint\" value=\"";
  protected final String TEXT_95 = "\"/>" + NL + "         </specializationType>";
  protected final String TEXT_96 = NL + "      </metamodel>";
  protected final String TEXT_97 = NL + "      <specializationType" + NL + "            id=\"";
  protected final String TEXT_98 = "\"";
  protected final String TEXT_99 = NL + "               name=\"";
  protected final String TEXT_100 = "\"";
  protected final String TEXT_101 = NL + "            kind=\"org.eclipse.gmf.runtime.diagram.ui.util.INotationType\">" + NL + "         <specializes id=\"org.eclipse.gmf.runtime.emf.type.core.null\"/>" + NL + "         <param name=\"semanticHint\" value=\"";
  protected final String TEXT_102 = "\"/>" + NL + "      </specializationType>";
  protected final String TEXT_103 = NL;
  protected final String TEXT_104 = NL + "      <metamodel nsURI=\"";
  protected final String TEXT_105 = "\">" + NL + "         <metamodelType" + NL + "               id=\"";
  protected final String TEXT_106 = "\"";
  protected final String TEXT_107 = NL + "               name=\"";
  protected final String TEXT_108 = "\"";
  protected final String TEXT_109 = NL + "               kind=\"org.eclipse.gmf.runtime.emf.type.core.IHintedType\"" + NL + "               eclass=\"";
  protected final String TEXT_110 = "\"" + NL + "               edithelper=\"";
  protected final String TEXT_111 = "\">" + NL + "            <param name=\"semanticHint\" value=\"";
  protected final String TEXT_112 = "\"/>" + NL + "         </metamodelType>" + NL + "      </metamodel>";
  protected final String TEXT_113 = NL + "      <metamodel nsURI=\"";
  protected final String TEXT_114 = "\">";
  protected final String TEXT_115 = NL + "         <specializationType" + NL + "               id=\"";
  protected final String TEXT_116 = "\"";
  protected final String TEXT_117 = NL + "               name=\"";
  protected final String TEXT_118 = "\"";
  protected final String TEXT_119 = NL + "               kind=\"org.eclipse.gmf.runtime.emf.type.core.IHintedType\"" + NL + "               edithelperadvice=\"";
  protected final String TEXT_120 = "\">" + NL + "            <specializes id=\"";
  protected final String TEXT_121 = "\"/>" + NL + "            <param name=\"semanticHint\" value=\"";
  protected final String TEXT_122 = "\"/>" + NL + "         </specializationType>";
  protected final String TEXT_123 = NL + "      </metamodel>";
  protected final String TEXT_124 = NL + "      <specializationType" + NL + "            id=\"";
  protected final String TEXT_125 = "\"";
  protected final String TEXT_126 = NL + "               name=\"";
  protected final String TEXT_127 = "\"";
  protected final String TEXT_128 = NL + "            kind=\"org.eclipse.gmf.runtime.diagram.ui.util.INotationType\">" + NL + "         <specializes id=\"org.eclipse.gmf.runtime.emf.type.core.null\"/>" + NL + "         <param name=\"semanticHint\" value=\"";
  protected final String TEXT_129 = "\"/>" + NL + "      </specializationType>";
  protected final String TEXT_130 = NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.emf.type.core.elementTypeBindings\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <clientContext id=\"";
  protected final String TEXT_131 = "ClientContext\">" + NL + "         <enablement>" + NL + "            <test" + NL + "               property=\"org.eclipse.gmf.runtime.emf.core.editingDomain\"" + NL + "               value=\"";
  protected final String TEXT_132 = "\"/>" + NL + "         </enablement>" + NL + "      </clientContext> " + NL + "      <binding context=\"";
  protected final String TEXT_133 = "ClientContext\">" + NL + "         <elementType ref=\"";
  protected final String TEXT_134 = "\"/>";
  protected final String TEXT_135 = NL + "         <elementType ref=\"";
  protected final String TEXT_136 = "\"/>";
  protected final String TEXT_137 = NL + "         <advice ref=\"org.eclipse.gmf.runtime.diagram.core.advice.notationDepdendents\"/>" + NL + "      </binding>" + NL + "   </extension>";
  protected final String TEXT_138 = NL + "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.markerNavigationProviders\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <MarkerNavigationProvider class=\"";
  protected final String TEXT_139 = "\">" + NL + "         <MarkerType name=\"";
  protected final String TEXT_140 = "\"/>" + NL + "         <Priority name=\"";
  protected final String TEXT_141 = "\"/>" + NL + "      </MarkerNavigationProvider>" + NL + "   </extension>" + NL + "   <extension id=\"";
  protected final String TEXT_142 = "\" name=\"";
  protected final String TEXT_143 = " problems\" point=\"org.eclipse.core.resources.markers\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <super type=\"org.eclipse.core.resources.problemmarker\"/>" + NL + "      <super type=\"org.eclipse.gmf.runtime.common.ui.services.marker\"/>" + NL + "      <persistent value=\"true\"/>" + NL + "   </extension>   ";
  protected final String TEXT_144 = NL + "   <extension id=\"ValidationContributionItemProvider\" name=\"Validation\"" + NL + "      point=\"org.eclipse.gmf.runtime.common.ui.services.action.contributionItemProviders\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <contributionItemProvider checkPluginLoaded=\"true\"" + NL + "         class=\"";
  protected final String TEXT_145 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_146 = "\"/>" + NL + "         <partContribution id=\"";
  protected final String TEXT_147 = "\">" + NL + "            <partMenuGroup menubarPath=\"/diagramMenu/\" id=\"validationGroup\"/>" + NL + "            <partAction id=\"validateAction\" menubarPath=\"/diagramMenu/validationGroup\"/>" + NL + "         </partContribution>" + NL + "      </contributionItemProvider>" + NL + "   </extension>";
  protected final String TEXT_148 = NL + "   <extension id=\"validationDecoratorProvider\" name=\"ValidationDecorations\" point=\"org.eclipse.gmf.runtime.diagram.ui.decoratorProviders\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <decoratorProvider class=\"";
  protected final String TEXT_149 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_150 = "\"/>" + NL + "         <object class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart(org.eclipse.gmf.runtime.diagram.ui)\" id=\"PRIMARY_VIEW\"/>" + NL + "         <context decoratorTargets=\"PRIMARY_VIEW\"/>" + NL + "      </decoratorProvider>" + NL + "   </extension>";
  protected final String TEXT_151 = NL;
  protected final String TEXT_152 = NL + "<extension point=\"org.eclipse.emf.validation.constraintProviders\">" + NL + "\t<?gmfgen generated=\"true\"?>";
  protected final String TEXT_153 = NL + "\t<category" + NL + "\t\tid=\"";
  protected final String TEXT_154 = "\"" + NL + "\t\tmandatory=\"false\"" + NL + "\t\tname=\"";
  protected final String TEXT_155 = "\">" + NL + "\t<![CDATA[";
  protected final String TEXT_156 = "]]>" + NL + "\t</category>\t\t";
  protected final String TEXT_157 = NL + "\t<constraintProvider cache=\"true\">";
  protected final String TEXT_158 = NL + "\t\t<package namespaceUri=\"";
  protected final String TEXT_159 = "\"/>";
  protected final String TEXT_160 = NL + "\t\t<constraints categories=\"";
  protected final String TEXT_161 = "\">\t\t";
  protected final String TEXT_162 = NL + "\t\t\t<constraint id=\"";
  protected final String TEXT_163 = "\"";
  protected final String TEXT_164 = NL + "\t\t\t\tlang=\"Java\" class=\"";
  protected final String TEXT_165 = "\"";
  protected final String TEXT_166 = NL + "\t\t\t\tlang=\"OCL\"";
  protected final String TEXT_167 = NL + "\t\t\t\tname=\"";
  protected final String TEXT_168 = "\" mode=\"";
  protected final String TEXT_169 = "\"" + NL + "\t\t\t\tseverity=\"";
  protected final String TEXT_170 = "\" statusCode=\"";
  protected final String TEXT_171 = "\">";
  protected final String TEXT_172 = NL + "\t\t\t\t<![CDATA[";
  protected final String TEXT_173 = "]]>";
  protected final String TEXT_174 = "\t\t\t" + NL + "\t            <description><![CDATA[";
  protected final String TEXT_175 = "]]></description>" + NL + "\t            <message><![CDATA[";
  protected final String TEXT_176 = "]]></message>" + NL + "\t\t\t\t<target class=\"";
  protected final String TEXT_177 = "\"/>" + NL + "\t\t\t</constraint>";
  protected final String TEXT_178 = NL + "\t\t</constraints>";
  protected final String TEXT_179 = NL + "\t</constraintProvider>" + NL + "</extension>" + NL + "" + NL + "<extension point=\"org.eclipse.emf.validation.constraintBindings\">" + NL + "\t<?gmfgen generated=\"true\"?>";
  protected final String TEXT_180 = NL + "\t<clientContext default=\"false\" id=\"";
  protected final String TEXT_181 = ".";
  protected final String TEXT_182 = "\">" + NL + "\t\t<selector class=\"";
  protected final String TEXT_183 = "\"/>" + NL + "\t</clientContext>" + NL + "\t<binding context=\"";
  protected final String TEXT_184 = ".";
  protected final String TEXT_185 = "\">";
  protected final String TEXT_186 = "\t" + NL + "\t\t<constraint ref=\"";
  protected final String TEXT_187 = ".";
  protected final String TEXT_188 = "\"/>";
  protected final String TEXT_189 = NL + "\t</binding>";
  protected final String TEXT_190 = "\t\t" + NL + "</extension>" + NL;
  protected final String TEXT_191 = NL + "<extension point=\"org.eclipse.emf.validation.ui.UIRegisteredClientContext\">" + NL + "\t<?gmfgen generated=\"true\"?>";
  protected final String TEXT_192 = NL + "\t<clientContext id=\"";
  protected final String TEXT_193 = "\"/>";
  protected final String TEXT_194 = NL + "</extension>";
  protected final String TEXT_195 = "   " + NL + "\t<extension id=\"MetricContributionItemProvider\" name=\"Metrics\"" + NL + "\t\tpoint=\"org.eclipse.gmf.runtime.common.ui.services.action.contributionItemProviders\">" + NL + "\t\t<?gmfgen generated=\"true\"?>" + NL + "\t\t<contributionItemProvider checkPluginLoaded=\"true\" class=\"";
  protected final String TEXT_196 = "\">" + NL + "\t\t\t<Priority name=\"";
  protected final String TEXT_197 = "\"/>\t\t" + NL + "\t\t\t<partContribution id=\"";
  protected final String TEXT_198 = "\">" + NL + "\t\t\t\t<partMenuGroup menubarPath=\"/diagramMenu/\" id=\"validationGroup\"/>" + NL + "\t\t\t\t<partAction id=\"metricsAction\" menubarPath=\"/diagramMenu/validationGroup\"/>" + NL + "\t\t\t</partContribution>\t\t" + NL + "\t\t</contributionItemProvider>" + NL + "\t</extension>" + NL + "" + NL + "\t<extension point=\"org.eclipse.ui.views\">" + NL + "\t    <?gmfgen generated=\"true\"?>" + NL + "   \t\t<view class=\"";
  protected final String TEXT_199 = "$ResultView\"" + NL + "\t\t\tid=\"";
  protected final String TEXT_200 = "\"" + NL + "\t\t\tname=\"";
  protected final String TEXT_201 = " Diagram Metrics\"/>" + NL + "\t</extension>";
  protected final String TEXT_202 = NL;
  protected final String TEXT_203 = NL + "   <extension point=\"org.eclipse.core.expressions.propertyTesters\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "       <propertyTester" + NL + "           id=\"";
  protected final String TEXT_204 = ".ShortcutPropertyTester\"" + NL + "           type=\"org.eclipse.gmf.runtime.notation.View\"" + NL + "           namespace=\"";
  protected final String TEXT_205 = "\"" + NL + "           properties=\"isShortcut\"" + NL + "           class=\"";
  protected final String TEXT_206 = "\">" + NL + "       </propertyTester>" + NL + "   </extension>" + NL + "   ";
  protected final String TEXT_207 = NL + "   <extension point=\"org.eclipse.ui.navigator.viewer\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <viewerContentBinding viewerId=\"org.eclipse.ui.navigator.ProjectExplorer\">" + NL + "         <includes>" + NL + "            <contentExtension pattern=\"";
  protected final String TEXT_208 = "\"/>" + NL + "            <contentExtension pattern=\"";
  protected final String TEXT_209 = "\"/>" + NL + "         </includes>" + NL + "      </viewerContentBinding>" + NL + "      <viewerActionBinding viewerId=\"org.eclipse.ui.navigator.ProjectExplorer\">" + NL + "         <includes>" + NL + "            <actionExtension pattern=\"";
  protected final String TEXT_210 = "\"/>" + NL + "         </includes>" + NL + "      </viewerActionBinding>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.navigator.navigatorContent\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <navigatorContent " + NL + "            id=\"";
  protected final String TEXT_211 = "\" " + NL + "            name=\"";
  protected final String TEXT_212 = "\" " + NL + "            priority=\"";
  protected final String TEXT_213 = "\" " + NL + "            contentProvider=\"";
  protected final String TEXT_214 = "\" " + NL + "            labelProvider=\"";
  protected final String TEXT_215 = "\"" + NL + "            icon=\"";
  protected final String TEXT_216 = "\"" + NL + "            activeByDefault=\"true\">" + NL + "         <triggerPoints>" + NL + "            <or>" + NL + "\t           <and>" + NL + "    \t          <instanceof value=\"org.eclipse.core.resources.IFile\"/>" + NL + "        \t      <test property=\"org.eclipse.core.resources.extension\" value=\"";
  protected final String TEXT_217 = "\"/>" + NL + "               </and>" + NL + "               <instanceof value=\"";
  protected final String TEXT_218 = "\"/>";
  protected final String TEXT_219 = NL + "           \t   <adapt type=\"org.eclipse.gmf.runtime.notation.View\">" + NL + "           \t      <test property=\"";
  protected final String TEXT_220 = ".isShortcut\"/>" + NL + "           \t   </adapt>";
  protected final String TEXT_221 = NL + "            </or>" + NL + "         </triggerPoints>" + NL + "         <possibleChildren>" + NL + "            <or>" + NL + "         \t   <instanceof value=\"";
  protected final String TEXT_222 = "\"/>";
  protected final String TEXT_223 = NL + "           \t   <adapt type=\"org.eclipse.gmf.runtime.notation.View\">" + NL + "           \t      <test property=\"";
  protected final String TEXT_224 = ".isShortcut\"/>" + NL + "           \t   </adapt>";
  protected final String TEXT_225 = NL + "            </or>" + NL + "         </possibleChildren>" + NL + "         <commonSorter " + NL + "               id=\"";
  protected final String TEXT_226 = "\" " + NL + "               class=\"";
  protected final String TEXT_227 = "\">" + NL + "            <parentExpression>" + NL + "               <or>" + NL + "\t              <and>" + NL + "    \t             <instanceof value=\"org.eclipse.core.resources.IFile\"/>" + NL + "        \t         <test property=\"org.eclipse.core.resources.extension\" value=\"";
  protected final String TEXT_228 = "\"/>" + NL + "                  </and>" + NL + "                  <instanceof value=\"";
  protected final String TEXT_229 = "\"/>" + NL + "               </or>" + NL + "            </parentExpression>" + NL + "         </commonSorter>" + NL + "      </navigatorContent>" + NL + "      <actionProvider" + NL + "            id=\"";
  protected final String TEXT_230 = "\"" + NL + "            class=\"";
  protected final String TEXT_231 = "\">" + NL + "         <enablement>" + NL + "            <or>" + NL + "               <instanceof value=\"";
  protected final String TEXT_232 = "\"/>";
  protected final String TEXT_233 = NL + "           \t   <adapt type=\"org.eclipse.gmf.runtime.notation.View\">" + NL + "           \t      <test property=\"";
  protected final String TEXT_234 = ".isShortcut\"/>" + NL + "           \t   </adapt>";
  protected final String TEXT_235 = NL + "            </or>" + NL + "         </enablement>" + NL + "      </actionProvider>" + NL + "   </extension>" + NL + "   " + NL + "   <extension point=\"org.eclipse.ui.navigator.linkHelper\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <linkHelper" + NL + "            id=\"";
  protected final String TEXT_236 = "\"" + NL + "            class=\"";
  protected final String TEXT_237 = "\">" + NL + "         <editorInputEnablement>" + NL + "            <instanceof value=\"org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.FileEditorInputProxy\"/>" + NL + "         </editorInputEnablement>" + NL + "         <selectionEnablement>" + NL + "            <instanceof value=\"";
  protected final String TEXT_238 = "\"/>" + NL + "         </selectionEnablement>" + NL + "      </linkHelper>" + NL + "   </extension>";
  protected final String TEXT_239 = NL;
  protected final String TEXT_240 = NL + "   <extension point=\"org.eclipse.ui.views.properties.tabbed.propertyContributor\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <propertyContributor contributorId=\"";
  protected final String TEXT_241 = "\"";
  protected final String TEXT_242 = NL + "            labelProvider=\"";
  protected final String TEXT_243 = "\"";
  protected final String TEXT_244 = ">" + NL + "         <propertyCategory category=\"domain\"/>" + NL + "         <propertyCategory category=\"visual\"/>" + NL + "         <propertyCategory category=\"extra\"/>" + NL + "      </propertyContributor>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.views.properties.tabbed.propertyTabs\">" + NL + "      <?gmfgen generated=\"true\"?>   " + NL + "      <propertyTabs contributorId=\"";
  protected final String TEXT_245 = "\">";
  protected final String TEXT_246 = NL;
  protected final String TEXT_247 = "         <propertyTab" + NL + "             category=\"visual\"" + NL + "             id=\"property.tab.AppearancePropertySection\"" + NL + "             label=\"%tab.appearance\"/>";
  protected final String TEXT_248 = "          <propertyTab" + NL + "             category=\"visual\"" + NL + "             id=\"property.tab.DiagramPropertySection\"" + NL + "             label=\"%tab.diagram\"/>";
  protected final String TEXT_249 = "          <propertyTab" + NL + "             category=\"extra\"" + NL + "             id=\"property.tab.AdvancedPropertySection\"" + NL + "             label=\"%tab.advanced\"/>           ";
  protected final String TEXT_250 = NL;
  protected final String TEXT_251 = "          <propertyTab";
  protected final String TEXT_252 = NL + "             category=\"domain\"";
  protected final String TEXT_253 = NL + "             category=\"extra\"";
  protected final String TEXT_254 = NL + "             id=\"property.tab.";
  protected final String TEXT_255 = "\"" + NL + "             label=\"%tab.";
  protected final String TEXT_256 = "\"/>";
  protected final String TEXT_257 = NL + "      </propertyTabs>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.views.properties.tabbed.propertySections\">" + NL + "      <?gmfgen generated=\"true\"?>   " + NL + "      <propertySections contributorId=\"";
  protected final String TEXT_258 = "\">";
  protected final String TEXT_259 = NL;
  protected final String TEXT_260 = NL + "         <propertySection id=\"property.section.ConnectorAppearancePropertySection\" " + NL + "            filter=\"org.eclipse.gmf.runtime.diagram.ui.properties.filters.ConnectionEditPartPropertySectionFilter\" " + NL + "            class=\"org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ConnectionAppearancePropertySection\" " + NL + "            tab=\"property.tab.AppearancePropertySection\">" + NL + "         </propertySection>" + NL + "         <propertySection id=\"property.section.ShapeColorAndFontPropertySection\" " + NL + "            filter=\"org.eclipse.gmf.runtime.diagram.ui.properties.filters.ShapeEditPartPropertySectionFilter\" " + NL + "            class=\"org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.ShapeColorsAndFontsPropertySection\" " + NL + "            tab=\"property.tab.AppearancePropertySection\">" + NL + "         </propertySection> " + NL + "         <propertySection id=\"property.section.DiagramColorsAndFontsPropertySection\" " + NL + "            filter=\"org.eclipse.gmf.runtime.diagram.ui.properties.filters.DiagramEditPartPropertySectionFilter\" " + NL + "            class=\"org.eclipse.gmf.runtime.diagram.ui.properties.sections.appearance.DiagramColorsAndFontsPropertySection\" " + NL + "            tab=\"property.tab.AppearancePropertySection\">" + NL + "         </propertySection>     ";
  protected final String TEXT_261 = NL + "          <propertySection id=\"property.section.RulerGridPropertySection\" " + NL + "             filter=\"org.eclipse.gmf.runtime.diagram.ui.properties.filters.DiagramEditPartPropertySectionFilter\" " + NL + "             class=\"org.eclipse.gmf.runtime.diagram.ui.properties.sections.grid.RulerGridPropertySection\" " + NL + "             tab=\"property.tab.DiagramPropertySection\">" + NL + "          </propertySection>     ";
  protected final String TEXT_262 = NL + "          <propertySection id=\"property.section.AdvancedPropertySection\"" + NL + "             class=\"org.eclipse.gmf.runtime.diagram.ui.properties.sections.AdvancedPropertySection\"" + NL + "             filter=\"org.eclipse.gmf.runtime.diagram.ui.properties.filters.EditPartPropertySectionFilter\"" + NL + "             tab=\"property.tab.AdvancedPropertySection\">" + NL + "          </propertySection>            ";
  protected final String TEXT_263 = "         ";
  protected final String TEXT_264 = NL;
  protected final String TEXT_265 = "         <propertySection" + NL + "            id=\"property.section.";
  protected final String TEXT_266 = "\" " + NL + "            tab=\"property.tab.";
  protected final String TEXT_267 = "\"";
  protected final String TEXT_268 = "filter=\"";
  protected final String TEXT_269 = "\"";
  protected final String TEXT_270 = NL + "            class=\"";
  protected final String TEXT_271 = "\">";
  protected final String TEXT_272 = NL + "            <input type=\"";
  protected final String TEXT_273 = "\"/>";
  protected final String TEXT_274 = NL + "         </propertySection>";
  protected final String TEXT_275 = NL + "      </propertySections>" + NL + "   </extension>";
  protected final String TEXT_276 = NL + NL + "   <extension id=\"";
  protected final String TEXT_277 = "\" point=\"org.eclipse.core.runtime.applications\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <application>" + NL + "         <run class=\"";
  protected final String TEXT_278 = "\"/>" + NL + "      </application>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.perspectives\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <perspective" + NL + "            id=\"";
  protected final String TEXT_279 = "\"" + NL + "            name=\"";
  protected final String TEXT_280 = " Perspective\"" + NL + "            class=\"";
  protected final String TEXT_281 = "\">" + NL + "      </perspective>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.commands\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <command" + NL + "            name=\"%openURIActionLabel\"" + NL + "            description=\"%openURIActionDescription\"" + NL + "            categoryId=\"org.eclipse.ui.category.file\"" + NL + "            id=\"";
  protected final String TEXT_282 = ".OpenURICommand\"/>  " + NL + "      <command" + NL + "            name=\"%openActionLabel\"" + NL + "            description=\"%openActionDescription\"" + NL + "            categoryId=\"org.eclipse.ui.category.file\"" + NL + "            id=\"";
  protected final String TEXT_283 = ".OpenCommand\"/>  " + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.bindings\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <key" + NL + "            commandId=\"";
  protected final String TEXT_284 = ".OpenURICommand\"" + NL + "            sequence=\"M1+U\"" + NL + "            schemeId=\"org.eclipse.ui.defaultAcceleratorConfiguration\"/>" + NL + "      <key" + NL + "            commandId=\"";
  protected final String TEXT_285 = ".OpenCommand\"" + NL + "            sequence=\"M1+O\"" + NL + "            schemeId=\"org.eclipse.ui.defaultAcceleratorConfiguration\"/>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.actionSets\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <actionSet" + NL + "            label=\"%applicationActionSetLabel\"" + NL + "            visible=\"true\"" + NL + "            id=\"";
  protected final String TEXT_286 = ".ActionSet\">" + NL + "         <action" + NL + "               label=\"%newDiagramActionLabel\"" + NL + "               class=\"";
  protected final String TEXT_287 = "$NewDiagramAction\"" + NL + "               menubarPath=\"file/new/additions\"" + NL + "               id=\"";
  protected final String TEXT_288 = ".NewDiagramAction\">" + NL + "         </action>" + NL + "         <action" + NL + "               label=\"%aboutActionLabel\"" + NL + "               class=\"";
  protected final String TEXT_289 = "$AboutAction\"" + NL + "               menubarPath=\"help/additions\"" + NL + "               id=\"";
  protected final String TEXT_290 = ".AboutAction\">" + NL + "         </action>" + NL + "         <action" + NL + "               label=\"%openURIActionLabel\"" + NL + "               definitionId=\"";
  protected final String TEXT_291 = ".OpenURICommand\"" + NL + "               class=\"";
  protected final String TEXT_292 = "$OpenURIAction\"" + NL + "               menubarPath=\"file/additions\"" + NL + "               id=\"";
  protected final String TEXT_293 = ".OpenURIAction\">" + NL + "         </action>" + NL + "         <action" + NL + "               label=\"%openActionLabel\"" + NL + "               definitionId=\"";
  protected final String TEXT_294 = ".OpenCommand\"" + NL + "               class=\"";
  protected final String TEXT_295 = "$OpenAction\"" + NL + "               menubarPath=\"file/additions\"" + NL + "               id=\"";
  protected final String TEXT_296 = ".OpenAction\">" + NL + "         </action>" + NL + "      </actionSet>" + NL + "   </extension>";
  protected final String TEXT_297 = NL + "</plugin>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenPlugin genPlugin = (GenPlugin) argument;
final GenEditorGenerator editorGen = genPlugin.getEditorGen();
final GenDiagram genDiagram = editorGen.getDiagram();
final GenApplication application = editorGen.getApplication();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(copyrightText);
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getPreferenceInitializerQualifiedClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(editorGen.getEditor().getIconPathX());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(editorGen.getEditor().getQualifiedClassName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genDiagram.getMatchingStrategyQualifiedClassName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(editorGen.getEditor().getActionBarContributorQualifiedClassName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genDiagram.getCreationWizardIconPathX());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genDiagram.getCreationWizardCategoryID());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genDiagram.getCreationWizardQualifiedClassName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genDiagram.getCreationWizardQualifiedClassName());
    stringBuffer.append(TEXT_19);
    if (editorGen.getApplication() == null && genDiagram.generateInitDiagramAction()) {
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_24);
    }

if (editorGen.getApplication() == null && genDiagram.generateCreateShortcutAction()) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genDiagram.getEditPartQualifiedClassName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genDiagram.getCreateShortcutActionQualifiedClassName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genDiagram.getCreateShortcutActionQualifiedClassName());
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genDiagram.getEditPartQualifiedClassName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genDiagram.getLoadResourceActionQualifiedClassName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genDiagram.getLoadResourceActionQualifiedClassName());
    stringBuffer.append(TEXT_36);
    if (genPlugin.isPrintingEnabled()) {
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genDiagram.getContributionItemProviderQualifiedClassName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    
for (Iterator contents = genDiagram.eAllContents(); contents.hasNext(); ) {
	Object next = contents.next();
	if (next instanceof GenLinkLabel || next instanceof GenExternalNodeLabel) {
		// disable delete actions for external labels

    stringBuffer.append(TEXT_41);
    stringBuffer.append(((GenCommonBase) next).getEditPartQualifiedClassName());
    stringBuffer.append(TEXT_42);
    
		continue;
	}
	if (next instanceof GenLink && ((GenLink) next).getModelFacet() instanceof FeatureLinkModelFacet) {
		// ref-based links should be removed from model, not from diagram

    stringBuffer.append(TEXT_43);
    stringBuffer.append(((GenCommonBase) next).getEditPartQualifiedClassName());
    stringBuffer.append(TEXT_44);
    		if (genDiagram.isSynchronized()) {
    stringBuffer.append(TEXT_45);
    		}
    stringBuffer.append(TEXT_46);
    
		continue;
	}
	if (!genDiagram.isSynchronized()) {
		continue;
	}
	ModelFacet modelFacet;
	if (next instanceof GenNodeLabel) {
		modelFacet = ((GenNodeLabel) next).getNode().getModelFacet();
	} else if (next instanceof GenNode) {
		modelFacet = ((GenNode) next).getModelFacet();
	} else if (next instanceof GenLink) {
		modelFacet = ((GenLink) next).getModelFacet();
	} else {
		continue;
	}
	if (modelFacet instanceof TypeModelFacet) {
		// elements based on ecore classes should not be removed from diagram

    stringBuffer.append(TEXT_47);
    stringBuffer.append(((GenCommonBase) next).getEditPartQualifiedClassName());
    stringBuffer.append(TEXT_48);
    
	}
}

    stringBuffer.append(TEXT_49);
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_51);
    if (genPlugin.isPrintingEnabled()) {
    stringBuffer.append(TEXT_52);
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_54);
    }
    if (editorGen.getApplication() == null) {
    stringBuffer.append(TEXT_55);
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(TEXT_58);
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genDiagram.getNotationViewProviderQualifiedClassName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(genDiagram.getNotationViewProviderPriority());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(genPlugin.getEditorGen().getModelID());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(genDiagram.getEditPartProviderQualifiedClassName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(genDiagram.getEditPartProviderPriority());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genDiagram.getModelingAssistantProviderQualifiedClassName());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(genDiagram.getModelingAssistantProviderPriority());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(genDiagram.getIconProviderQualifiedClassName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(genDiagram.getIconProviderPriority());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(genDiagram.getParserProviderQualifiedClassName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genDiagram.getParserProviderPriority());
    stringBuffer.append(TEXT_71);
    if (genDiagram.generateShortcutIcon()) {
    stringBuffer.append(TEXT_72);
    stringBuffer.append(genDiagram.getShortcutsDecoratorProviderQualifiedClassName());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(genDiagram.getShortcutsDecoratorProviderPriority());
    stringBuffer.append(TEXT_74);
    }
    stringBuffer.append(TEXT_75);
    GenCommonBase genElement = genDiagram;
    stringBuffer.append(TEXT_76);
    
if (!genElement.getElementType().isDefinedExternally()) {
	final String displayName = genElement.getElementType().getDisplayName();

	if (genElement.getElementType() instanceof MetamodelType) {
		MetamodelType metamodelType = (MetamodelType) genElement.getElementType();
		GenClass metaClass = metamodelType.getMetaClass();

    stringBuffer.append(TEXT_77);
    stringBuffer.append(metaClass.getGenPackage().getNSURI());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(metamodelType.getUniqueIdentifier());
    stringBuffer.append(TEXT_79);
    		if (displayName != null) {
    stringBuffer.append(TEXT_80);
    stringBuffer.append(displayName);
    stringBuffer.append(TEXT_81);
    		}
    stringBuffer.append(TEXT_82);
    stringBuffer.append(metaClass.getName());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(metamodelType.getEditHelperQualifiedClassName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_85);
    
	} else if (genElement.getElementType() instanceof SpecializationType) {
		SpecializationType specializationType = (SpecializationType) genElement.getElementType();
		MetamodelType metamodelType = specializationType.getMetamodelType();
		GenClass metaClass = null;
		String metamodelTypeId = "org.eclipse.gmf.runtime.emf.type.core.null";
		if (metamodelType != null) {
			metaClass = metamodelType.getMetaClass();
			metamodelTypeId = metamodelType.getUniqueIdentifier();
		}
		if (genElement instanceof GenLink) {
			LinkModelFacet modelFacet = ((GenLink) genElement).getModelFacet();
			if (modelFacet instanceof FeatureLinkModelFacet) {
				GenFeature metaFeature = ((FeatureLinkModelFacet) modelFacet).getMetaFeature();
				metaClass = metaFeature.getGenClass();
			}
		}
		if (metaClass != null) {

    stringBuffer.append(TEXT_86);
    stringBuffer.append(metaClass.getGenPackage().getNSURI());
    stringBuffer.append(TEXT_87);
    		}
    stringBuffer.append(TEXT_88);
    stringBuffer.append(specializationType.getUniqueIdentifier());
    stringBuffer.append(TEXT_89);
    		if (displayName != null) {
    stringBuffer.append(TEXT_90);
    stringBuffer.append(displayName);
    stringBuffer.append(TEXT_91);
    		}
    stringBuffer.append(TEXT_92);
    stringBuffer.append(specializationType.getEditHelperAdviceQualifiedClassName());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(metamodelTypeId);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_95);
    		if (metaClass != null) {
    stringBuffer.append(TEXT_96);
    
		}
	} else if (genElement.getElementType() instanceof NotationType) {
		NotationType notationType = (NotationType) genElement.getElementType();

    stringBuffer.append(TEXT_97);
    stringBuffer.append(notationType.getUniqueIdentifier());
    stringBuffer.append(TEXT_98);
    		if (displayName != null) {
    stringBuffer.append(TEXT_99);
    stringBuffer.append(displayName);
    stringBuffer.append(TEXT_100);
    		}
    stringBuffer.append(TEXT_101);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_102);
    
	}
}

    
for (Iterator contents = genDiagram.eAllContents(); contents.hasNext(); ) {
	Object next = contents.next();
	if (next instanceof GenNode) {
		genElement = (GenCommonBase) next;
	} else if (next instanceof GenLink) {
		genElement = (GenCommonBase) next;
	} else {
		continue;
	}

    stringBuffer.append(TEXT_103);
    
if (!genElement.getElementType().isDefinedExternally()) {
	final String displayName = genElement.getElementType().getDisplayName();

	if (genElement.getElementType() instanceof MetamodelType) {
		MetamodelType metamodelType = (MetamodelType) genElement.getElementType();
		GenClass metaClass = metamodelType.getMetaClass();

    stringBuffer.append(TEXT_104);
    stringBuffer.append(metaClass.getGenPackage().getNSURI());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(metamodelType.getUniqueIdentifier());
    stringBuffer.append(TEXT_106);
    		if (displayName != null) {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(displayName);
    stringBuffer.append(TEXT_108);
    		}
    stringBuffer.append(TEXT_109);
    stringBuffer.append(metaClass.getName());
    stringBuffer.append(TEXT_110);
    stringBuffer.append(metamodelType.getEditHelperQualifiedClassName());
    stringBuffer.append(TEXT_111);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_112);
    
	} else if (genElement.getElementType() instanceof SpecializationType) {
		SpecializationType specializationType = (SpecializationType) genElement.getElementType();
		MetamodelType metamodelType = specializationType.getMetamodelType();
		GenClass metaClass = null;
		String metamodelTypeId = "org.eclipse.gmf.runtime.emf.type.core.null";
		if (metamodelType != null) {
			metaClass = metamodelType.getMetaClass();
			metamodelTypeId = metamodelType.getUniqueIdentifier();
		}
		if (genElement instanceof GenLink) {
			LinkModelFacet modelFacet = ((GenLink) genElement).getModelFacet();
			if (modelFacet instanceof FeatureLinkModelFacet) {
				GenFeature metaFeature = ((FeatureLinkModelFacet) modelFacet).getMetaFeature();
				metaClass = metaFeature.getGenClass();
			}
		}
		if (metaClass != null) {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(metaClass.getGenPackage().getNSURI());
    stringBuffer.append(TEXT_114);
    		}
    stringBuffer.append(TEXT_115);
    stringBuffer.append(specializationType.getUniqueIdentifier());
    stringBuffer.append(TEXT_116);
    		if (displayName != null) {
    stringBuffer.append(TEXT_117);
    stringBuffer.append(displayName);
    stringBuffer.append(TEXT_118);
    		}
    stringBuffer.append(TEXT_119);
    stringBuffer.append(specializationType.getEditHelperAdviceQualifiedClassName());
    stringBuffer.append(TEXT_120);
    stringBuffer.append(metamodelTypeId);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_122);
    		if (metaClass != null) {
    stringBuffer.append(TEXT_123);
    
		}
	} else if (genElement.getElementType() instanceof NotationType) {
		NotationType notationType = (NotationType) genElement.getElementType();

    stringBuffer.append(TEXT_124);
    stringBuffer.append(notationType.getUniqueIdentifier());
    stringBuffer.append(TEXT_125);
    		if (displayName != null) {
    stringBuffer.append(TEXT_126);
    stringBuffer.append(displayName);
    stringBuffer.append(TEXT_127);
    		}
    stringBuffer.append(TEXT_128);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_129);
    
	}
}

    }
    stringBuffer.append(TEXT_130);
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(genDiagram.getEditingDomainID());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_133);
    stringBuffer.append(genDiagram.getElementType().getUniqueIdentifier());
    stringBuffer.append(TEXT_134);
    
for (Iterator contents = genDiagram.eAllContents(); contents.hasNext(); ) {
	Object next = contents.next();
	if (next instanceof GenNode) {
		genElement = (GenCommonBase) next;
	} else if (next instanceof GenLink) {
		genElement = (GenCommonBase) next;
	} else {
		continue;
	}

    stringBuffer.append(TEXT_135);
    stringBuffer.append(genElement.getElementType().getUniqueIdentifier());
    stringBuffer.append(TEXT_136);
    }
    stringBuffer.append(TEXT_137);
    if(genDiagram.isValidationEnabled() || editorGen.hasAudits()) {
    stringBuffer.append(TEXT_138);
    stringBuffer.append(genDiagram.getMarkerNavigationProviderQualifiedClassName());
    stringBuffer.append(TEXT_139);
    stringBuffer.append(genPlugin.getID() + "." + genDiagram.getValidationDiagnosticMarkerType());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(genDiagram.getMarkerNavigationProviderPriority());
    stringBuffer.append(TEXT_141);
    stringBuffer.append(genDiagram.getValidationDiagnosticMarkerType());
    stringBuffer.append(TEXT_142);
    stringBuffer.append(genPlugin.getName());
    stringBuffer.append(TEXT_143);
    	if(genDiagram.isValidationEnabled()) { 
    stringBuffer.append(TEXT_144);
    stringBuffer.append(genDiagram.getValidationProviderQualifiedClassName());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(genDiagram.getValidationProviderPriority());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_147);
    	} /* validationEnabled == true */ 
    	if(genDiagram.isValidationDecorators()) { 
    stringBuffer.append(TEXT_148);
    stringBuffer.append(genDiagram.getValidationDecoratorProviderQualifedClassName());
    stringBuffer.append(TEXT_149);
    stringBuffer.append(genDiagram.getValidationDecoratorProviderPriority());
    stringBuffer.append(TEXT_150);
    	} /* decorators */
} /* validation */

    stringBuffer.append(TEXT_151);
    
GenAuditContainer rootContainer = genDiagram.getEditorGen().getAudits();
if (genDiagram.getEditorGen().hasAudits()) {
	java.util.List containers = rootContainer.getAllAuditContainers();

    stringBuffer.append(TEXT_152);
    
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

    stringBuffer.append(TEXT_153);
    stringBuffer.append(org.eclipse.gmf.internal.common.codegen.Conversions.escapeXML(id.toString()));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(org.eclipse.gmf.internal.common.codegen.Conversions.escapeXML(category.getName() != null ? category.getName() : id.toString()));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(category.getDescription() != null ? category.getDescription():"");
    stringBuffer.append(TEXT_156);
    
	} // end of categories loop

    stringBuffer.append(TEXT_157);
    
	for(java.util.Iterator packageIt = rootContainer.getAllTargetedModelPackages().iterator(); packageIt.hasNext();) {
		GenPackage genPackage = (GenPackage)packageIt.next();

    stringBuffer.append(TEXT_158);
    stringBuffer.append(genPackage.getNSURI());
    stringBuffer.append(TEXT_159);
    
	} // end of used model packages iteration
	int rulePos = 0;
	for(java.util.Iterator catIt = containers.iterator(); catIt.hasNext();) {
		GenAuditContainer category = (GenAuditContainer)catIt.next();

    stringBuffer.append(TEXT_160);
    stringBuffer.append(org.eclipse.gmf.internal.common.codegen.Conversions.escapeXML(pathMap.get(category).toString()));
    stringBuffer.append(TEXT_161);
    
		for(java.util.Iterator it = category.getAudits().iterator(); it.hasNext(); rulePos++) {
			GenAuditRule audit = (GenAuditRule)it.next();
			if(audit.getTarget() == null || (audit.getTarget().getTargetClass() == null)) continue;
			String targetClassName = audit.getTarget().getTargetClassModelQualifiedName();
			String modeAttr = audit.isUseInLiveMode() ? "Live" : "Batch";
			String name = audit.getName() != null ? audit.getName() : audit.getId();
			String message = audit.getMessage() != null ? audit.getMessage() : name + " audit violated";

    stringBuffer.append(TEXT_162);
    stringBuffer.append(org.eclipse.gmf.internal.common.codegen.Conversions.escapeXML(audit.getId()));
    stringBuffer.append(TEXT_163);
    			if(audit.requiresConstraintAdapter()) {
    stringBuffer.append(TEXT_164);
    stringBuffer.append(audit.getConstraintAdapterQualifiedClassName());
    stringBuffer.append(TEXT_165);
    			} else { 
    stringBuffer.append(TEXT_166);
    			} 
    stringBuffer.append(TEXT_167);
    stringBuffer.append(org.eclipse.gmf.internal.common.codegen.Conversions.escapeXML(name));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(modeAttr);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(audit.getSeverity().getName());
    stringBuffer.append(TEXT_170);
    stringBuffer.append(Integer.toString(200 + rulePos));
    stringBuffer.append(TEXT_171);
    			if(!audit.requiresConstraintAdapter()) {
    stringBuffer.append(TEXT_172);
    stringBuffer.append(audit.getRule() != null ? audit.getRule().getBody() : "");
    stringBuffer.append(TEXT_173);
    			} 
    stringBuffer.append(TEXT_174);
    stringBuffer.append(audit.getDescription() != null ? audit.getDescription():"");
    stringBuffer.append(TEXT_175);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(targetClassName);
    stringBuffer.append(TEXT_177);
    
		} // end of audits in category

    stringBuffer.append(TEXT_178);
    		
	} // end of category loop

    stringBuffer.append(TEXT_179);
    
	String pluginID = genDiagram.getEditorGen().getPlugin().getID();
	for(java.util.Iterator it = rootContainer.getAllRulesToTargetContextMap().entrySet().iterator(); it.hasNext();) {
		java.util.Map.Entry ctx2Rules = (java.util.Map.Entry)it.next();
		java.util.List rules = (java.util.List)ctx2Rules.getValue();
		if(rules.isEmpty()) continue;
		String ctxID = (String)ctx2Rules.getKey();
		GenAuditRule ruleTarget = (GenAuditRule)rules.get(0);

    stringBuffer.append(TEXT_180);
    stringBuffer.append(pluginID);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(ctxID);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(ruleTarget.getContextSelectorQualifiedClassName());
    stringBuffer.append(TEXT_183);
    stringBuffer.append(pluginID);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(ctxID);
    stringBuffer.append(TEXT_185);
    
		for(java.util.Iterator ruleIt = rules.iterator(); ruleIt.hasNext();) {
			GenAuditRule nextRule = (GenAuditRule)ruleIt.next();

    stringBuffer.append(TEXT_186);
    stringBuffer.append(pluginID);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(org.eclipse.gmf.internal.common.codegen.Conversions.escapeXML(nextRule.getId()));
    stringBuffer.append(TEXT_188);
    
		} // end of rules in context

    stringBuffer.append(TEXT_189);
    
	} // end of contexts iteration

    stringBuffer.append(TEXT_190);
    
	if(genDiagram.isLiveValidationUIFeedback()) { // UIRegisteredClientContext

    stringBuffer.append(TEXT_191);
    
		for(java.util.Iterator it = rootContainer.getAllRulesToTargetContextMap().keySet().iterator(); it.hasNext();) {
			String qualifiedCtxID = pluginID + "." + (String)it.next();

    stringBuffer.append(TEXT_192);
    stringBuffer.append(qualifiedCtxID);
    stringBuffer.append(TEXT_193);
    
		} // URI registered ctx iteration

    stringBuffer.append(TEXT_194);
    
	} // UIRegisteredClientContext

    
}

    if (editorGen.getMetrics() != null && !editorGen.getMetrics().getMetrics().isEmpty()) {
    stringBuffer.append(TEXT_195);
    stringBuffer.append(genDiagram.getMetricProviderQualifiedClassName());
    stringBuffer.append(TEXT_196);
    stringBuffer.append(genDiagram.getMetricProviderPriority());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_198);
    stringBuffer.append(genDiagram.getMetricProviderQualifiedClassName());
    stringBuffer.append(TEXT_199);
    stringBuffer.append(genDiagram.getMetricViewID());
    stringBuffer.append(TEXT_200);
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_201);
    } // end of metrics
    if (editorGen.getNavigator() != null) {
    stringBuffer.append(TEXT_202);
    if (genDiagram.generateShortcutIcon()) {
    stringBuffer.append(TEXT_203);
    stringBuffer.append(editorGen.getPlugin().getID());
    stringBuffer.append(TEXT_204);
    stringBuffer.append(editorGen.getPlugin().getID());
    stringBuffer.append(TEXT_205);
    stringBuffer.append(genDiagram.getShortcutPropertyTesterQualifiedClassName());
    stringBuffer.append(TEXT_206);
    }
    stringBuffer.append(TEXT_207);
    stringBuffer.append(editorGen.getNavigator().getContentExtensionID());
    stringBuffer.append(TEXT_208);
    stringBuffer.append(editorGen.getNavigator().getLinkHelperExtensionID());
    stringBuffer.append(TEXT_209);
    stringBuffer.append(editorGen.getNavigator().getActionProviderID());
    stringBuffer.append(TEXT_210);
    stringBuffer.append(editorGen.getNavigator().getContentExtensionID());
    stringBuffer.append(TEXT_211);
    stringBuffer.append(editorGen.getNavigator().getContentExtensionName());
    stringBuffer.append(TEXT_212);
    stringBuffer.append(editorGen.getNavigator().getContentExtensionPriority());
    stringBuffer.append(TEXT_213);
    stringBuffer.append(editorGen.getNavigator().getContentProviderQualifiedClassName());
    stringBuffer.append(TEXT_214);
    stringBuffer.append(editorGen.getNavigator().getLabelProviderQualifiedClassName());
    stringBuffer.append(TEXT_215);
    stringBuffer.append(editorGen.getEditor().getIconPathX());
    stringBuffer.append(TEXT_216);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_217);
    stringBuffer.append(editorGen.getNavigator().getAbstractNavigatorItemQualifiedClassName());
    stringBuffer.append(TEXT_218);
    if (genDiagram.generateShortcutIcon()) {
    stringBuffer.append(TEXT_219);
    stringBuffer.append(editorGen.getPlugin().getID());
    stringBuffer.append(TEXT_220);
    }
    stringBuffer.append(TEXT_221);
    stringBuffer.append(editorGen.getNavigator().getAbstractNavigatorItemQualifiedClassName());
    stringBuffer.append(TEXT_222);
    if (genDiagram.generateShortcutIcon()) {
    stringBuffer.append(TEXT_223);
    stringBuffer.append(editorGen.getPlugin().getID());
    stringBuffer.append(TEXT_224);
    }
    stringBuffer.append(TEXT_225);
    stringBuffer.append(editorGen.getNavigator().getSorterExtensionID());
    stringBuffer.append(TEXT_226);
    stringBuffer.append(editorGen.getNavigator().getSorterQualifiedClassName());
    stringBuffer.append(TEXT_227);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_228);
    stringBuffer.append(editorGen.getNavigator().getAbstractNavigatorItemQualifiedClassName());
    stringBuffer.append(TEXT_229);
    stringBuffer.append(editorGen.getNavigator().getActionProviderID());
    stringBuffer.append(TEXT_230);
    stringBuffer.append(editorGen.getNavigator().getActionProviderQualifiedClassName());
    stringBuffer.append(TEXT_231);
    stringBuffer.append(editorGen.getNavigator().getAbstractNavigatorItemQualifiedClassName());
    stringBuffer.append(TEXT_232);
    if (genDiagram.generateShortcutIcon()) {
    stringBuffer.append(TEXT_233);
    stringBuffer.append(editorGen.getPlugin().getID());
    stringBuffer.append(TEXT_234);
    }
    stringBuffer.append(TEXT_235);
    stringBuffer.append(editorGen.getNavigator().getLinkHelperExtensionID());
    stringBuffer.append(TEXT_236);
    stringBuffer.append(editorGen.getNavigator().getLinkHelperQualifiedClassName());
    stringBuffer.append(TEXT_237);
    stringBuffer.append(editorGen.getNavigator().getAbstractNavigatorItemQualifiedClassName());
    stringBuffer.append(TEXT_238);
    }
    if (editorGen.getPropertySheet() != null) {
    stringBuffer.append(TEXT_239);
    final GenPropertySheet propSheet = editorGen.getPropertySheet();
final String contributorID = genPlugin.getID();
    stringBuffer.append(TEXT_240);
    stringBuffer.append(contributorID);
    stringBuffer.append(TEXT_241);
    if (propSheet.isNeedsCaption()) {
    stringBuffer.append(TEXT_242);
    stringBuffer.append(propSheet.getLabelProviderQualifiedClassName());
    stringBuffer.append(TEXT_243);
    }
    stringBuffer.append(TEXT_244);
    stringBuffer.append(contributorID);
    stringBuffer.append(TEXT_245);
    for (Iterator it = propSheet.getTabs().iterator(); it.hasNext(); ) {
	final GenPropertyTab tab = (GenPropertyTab) it.next();
	if (tab instanceof GenStandardPropertyTab) {
    stringBuffer.append(TEXT_246);
    if ("appearance".equals(tab.getID())) {
    stringBuffer.append(TEXT_247);
    } else if ("diagram".equals(tab.getID())) {
    stringBuffer.append(TEXT_248);
    } else if ("advanced".equals(tab.getID())) {
    stringBuffer.append(TEXT_249);
    }
    } else if (tab instanceof GenCustomPropertyTab) {
    stringBuffer.append(TEXT_250);
    stringBuffer.append(TEXT_251);
    if ("domain".equals(tab.getID())) /*just to make use of domain category ;)*/ {
    stringBuffer.append(TEXT_252);
    } else {
    stringBuffer.append(TEXT_253);
    }
    stringBuffer.append(TEXT_254);
    stringBuffer.append(tab.getID());
    stringBuffer.append(TEXT_255);
    stringBuffer.append(tab.getID());
    stringBuffer.append(TEXT_256);
    }}
    stringBuffer.append(TEXT_257);
    stringBuffer.append(contributorID);
    stringBuffer.append(TEXT_258);
    for (Iterator it = propSheet.getTabs().iterator(); it.hasNext(); ) {
	final GenPropertyTab tab = (GenPropertyTab) it.next();
	if (tab instanceof GenStandardPropertyTab) {
    stringBuffer.append(TEXT_259);
    if ("appearance".equals(tab.getID())) {
    stringBuffer.append(TEXT_260);
    } else if ("diagram".equals(tab.getID())) {
    stringBuffer.append(TEXT_261);
    } else if ("advanced".equals(tab.getID())) {
    stringBuffer.append(TEXT_262);
    }
    stringBuffer.append(TEXT_263);
    } else if (tab instanceof GenCustomPropertyTab) {
    stringBuffer.append(TEXT_264);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(tab.getID());
    stringBuffer.append(TEXT_266);
    stringBuffer.append(tab.getID());
    stringBuffer.append(TEXT_267);
    if (((GenCustomPropertyTab) tab).getFilter() instanceof CustomTabFilter) {
    stringBuffer.append(TEXT_268);
    stringBuffer.append(((CustomTabFilter) ((GenCustomPropertyTab) tab).getFilter()).getQualifiedClassName());
    stringBuffer.append(TEXT_269);
    }
    stringBuffer.append(TEXT_270);
    stringBuffer.append(((GenCustomPropertyTab) tab).getQualifiedClassName());
    stringBuffer.append(TEXT_271);
    if (((GenCustomPropertyTab) tab).getFilter() instanceof TypeTabFilter) {
    
final TypeTabFilter typeTabFilter = (TypeTabFilter) ((GenCustomPropertyTab) tab).getFilter();
for (Iterator ttfIt = typeTabFilter.getAllTypes().iterator(); ttfIt.hasNext();) {
	String ttfType = (String) ttfIt.next();
    stringBuffer.append(TEXT_272);
    stringBuffer.append(ttfType);
    stringBuffer.append(TEXT_273);
    }
    }
    stringBuffer.append(TEXT_274);
    }}
    stringBuffer.append(TEXT_275);
    }
    if (application != null) {
    stringBuffer.append(TEXT_276);
    stringBuffer.append(application.getID());
    stringBuffer.append(TEXT_277);
    stringBuffer.append(application.getQualifiedClassName());
    stringBuffer.append(TEXT_278);
    stringBuffer.append(application.getPerspectiveId());
    stringBuffer.append(TEXT_279);
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_280);
    stringBuffer.append(application.getPerspectiveQualifiedClassName());
    stringBuffer.append(TEXT_281);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_282);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_283);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_284);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_285);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_286);
    stringBuffer.append(application.getActionBarAdvisorQualifiedClassName());
    stringBuffer.append(TEXT_287);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_288);
    stringBuffer.append(application.getActionBarAdvisorQualifiedClassName());
    stringBuffer.append(TEXT_289);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_290);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_291);
    stringBuffer.append(application.getActionBarAdvisorQualifiedClassName());
    stringBuffer.append(TEXT_292);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_293);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_294);
    stringBuffer.append(application.getActionBarAdvisorQualifiedClassName());
    stringBuffer.append(TEXT_295);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_296);
    }
    stringBuffer.append(TEXT_297);
    return stringBuffer.toString();
  }
}
