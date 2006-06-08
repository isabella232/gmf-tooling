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
  protected final String TEXT_6 = NL + "<plugin>" + NL + "" + NL + "   <extension point=\"org.eclipse.core.runtime.preferences\">" + NL + "      <initializer class=\"";
  protected final String TEXT_7 = "\"/>" + NL + "   </extension>" + NL + "" + NL + "  <extension point=\"org.eclipse.team.core.fileTypes\">" + NL + "      <fileTypes" + NL + "         type=\"text\"" + NL + "         extension=\"";
  protected final String TEXT_8 = "\">" + NL + "      </fileTypes>" + NL + "  </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.emf.ecore.extension_parser\">" + NL + "      <parser" + NL + "         type=\"";
  protected final String TEXT_9 = "\"" + NL + "         class=\"org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory\">" + NL + "      </parser>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.editors\">" + NL + "     <editor" + NL + "        id=\"";
  protected final String TEXT_10 = "\"" + NL + "        name=\"";
  protected final String TEXT_11 = " Diagram Editor\"" + NL + "        icon=\"";
  protected final String TEXT_12 = "\"" + NL + "        extensions=\"";
  protected final String TEXT_13 = "\"" + NL + "        default=\"true\"" + NL + "        class=\"";
  protected final String TEXT_14 = "\"" + NL + "        matchingStrategy=\"";
  protected final String TEXT_15 = "\"" + NL + "        contributorClass=\"";
  protected final String TEXT_16 = "\">" + NL + "     </editor>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.newWizards\">" + NL + "  \t  <wizard" + NL + "  \t     name=\"";
  protected final String TEXT_17 = " Diagram\"" + NL + "  \t     icon=\"";
  protected final String TEXT_18 = "\"" + NL + "  \t     category=\"org.eclipse.ui.Examples\"" + NL + "  \t     class=\"";
  protected final String TEXT_19 = "\"" + NL + "  \t     id=\"";
  protected final String TEXT_20 = "ID\">" + NL + "  \t  \t <description>" + NL + "  \t  \t\tCreates ";
  protected final String TEXT_21 = " diagram." + NL + "  \t  \t </description>  " + NL + "      </wizard>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.popupMenus\">" + NL + "      <objectContribution" + NL + "            id=\"";
  protected final String TEXT_22 = ".ui.objectContribution.IFile1\"" + NL + "            nameFilter=\"*.";
  protected final String TEXT_23 = "\"" + NL + "            objectClass=\"org.eclipse.core.resources.IFile\">" + NL + "         <action" + NL + "               label=\"Initialize ";
  protected final String TEXT_24 = " diagram file\"" + NL + "               class=\"";
  protected final String TEXT_25 = "\"" + NL + "               menubarPath=\"additions\"" + NL + "               enablesFor=\"1\"" + NL + "               id=\"";
  protected final String TEXT_26 = "ID\">" + NL + "         </action>" + NL + "      </objectContribution>  ";
  protected final String TEXT_27 = NL + "      <objectContribution" + NL + "            adaptable=\"false\"" + NL + "            id=\"";
  protected final String TEXT_28 = ".ui.objectContribution.";
  protected final String TEXT_29 = "1\"" + NL + "            objectClass=\"";
  protected final String TEXT_30 = "\">" + NL + "         <action" + NL + "               class=\"";
  protected final String TEXT_31 = "\"" + NL + "               enablesFor=\"1\"" + NL + "               id=\"";
  protected final String TEXT_32 = "ID\"" + NL + "               label=\"Create Shortcut...\"" + NL + "               menubarPath=\"additions\">" + NL + "         </action>" + NL + "      </objectContribution>                      ";
  protected final String TEXT_33 = NL + "      <objectContribution" + NL + "            adaptable=\"false\"" + NL + "            id=\"";
  protected final String TEXT_34 = ".ui.objectContribution.";
  protected final String TEXT_35 = "2\"" + NL + "            objectClass=\"";
  protected final String TEXT_36 = "\">" + NL + "         <action" + NL + "               class=\"";
  protected final String TEXT_37 = "\"" + NL + "               enablesFor=\"1\"" + NL + "               id=\"";
  protected final String TEXT_38 = "ID\"" + NL + "               label=\"Load Resource...\"" + NL + "               menubarPath=\"additions\">" + NL + "         </action>" + NL + "      </objectContribution>                      " + NL + "  </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.action.contributionItemProviders\">";
  protected final String TEXT_39 = NL + "      <contributionItemProvider class=\"";
  protected final String TEXT_40 = "\">" + NL + "         <Priority name=\"Low\">" + NL + "         </Priority>" + NL + "         <partContribution id=\"";
  protected final String TEXT_41 = "\">" + NL + "            <partAction menubarPath=\"/file/print\" id=\"printPreviewAction\">" + NL + "            </partAction>" + NL + "         </partContribution>" + NL + "      </contributionItemProvider>";
  protected final String TEXT_42 = NL + "      <contributionItemProvider" + NL + "            class=\"org.eclipse.gmf.runtime.diagram.ui.providers.internal.DiagramContributionItemProvider\"" + NL + "            checkPluginLoaded=\"false\">" + NL + "         <Priority name=\"Low\"/>";
  protected final String TEXT_43 = NL + "         <popupContribution class=\"org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider\">" + NL + "            <popupStructuredContributionCriteria objectClass=\"";
  protected final String TEXT_44 = "\"/>" + NL + "            <popupPredefinedItem id=\"deleteFromDiagramAction\" remove=\"true\"/>" + NL + "            <popupPredefinedItem id=\"deleteFromModelAction\" remove=\"true\"/>" + NL + "         </popupContribution>";
  protected final String TEXT_45 = NL + "         <popupContribution class=\"org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider\">" + NL + "            <popupStructuredContributionCriteria objectClass=\"";
  protected final String TEXT_46 = "\"/>" + NL + "            <popupAction path=\"/editGroup\" id=\"deleteFromModelAction\"/>" + NL + "            <popupPredefinedItem id=\"deleteFromDiagramAction\" remove=\"true\"/>" + NL + "         </popupContribution>";
  protected final String TEXT_47 = NL + "         <popupContribution class=\"org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider\">" + NL + "            <popupStructuredContributionCriteria objectClass=\"";
  protected final String TEXT_48 = "\"/>" + NL + "            <popupPredefinedItem id=\"deleteFromDiagramAction\" remove=\"true\"/>" + NL + "         </popupContribution>";
  protected final String TEXT_49 = NL + "      </contributionItemProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.action.globalActionHandlerProviders\">" + NL + "      <GlobalActionHandlerProvider" + NL + "         class=\"org.eclipse.gmf.runtime.diagram.ui.providers.DiagramGlobalActionHandlerProvider\"" + NL + "         id=\"";
  protected final String TEXT_50 = "Presentation\">" + NL + "         <Priority name=\"Lowest\"/>" + NL + "         <ViewId id=\"";
  protected final String TEXT_51 = "\">" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart\">" + NL + "               <GlobalActionId actionId=\"delete\"/>" + NL + "            </ElementType>" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart\">" + NL + "               <GlobalActionId actionId=\"save\"/>" + NL + "            </ElementType>" + NL + "         </ViewId>" + NL + "      </GlobalActionHandlerProvider>";
  protected final String TEXT_52 = NL + "      <GlobalActionHandlerProvider" + NL + "         class=\"org.eclipse.gmf.runtime.diagram.ui.printing.render.providers.DiagramWithPrintGlobalActionHandlerProvider\"" + NL + "         id=\"";
  protected final String TEXT_53 = "PresentationPrint\">" + NL + "         <Priority name=\"Lowest\"/>" + NL + "         <ViewId id=\"";
  protected final String TEXT_54 = "\">" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart\">" + NL + "               <GlobalActionId actionId=\"print\"/>" + NL + "            </ElementType>" + NL + "         </ViewId>" + NL + "      </GlobalActionHandlerProvider>";
  protected final String TEXT_55 = NL + "      <GlobalActionHandlerProvider" + NL + "         class=\"org.eclipse.gmf.runtime.diagram.ui.providers.ide.providers.DiagramIDEGlobalActionHandlerProvider\"" + NL + "         id=\"";
  protected final String TEXT_56 = "PresentationIDE\">" + NL + "         <Priority name=\"Lowest\"/>" + NL + "         <ViewId id=\"";
  protected final String TEXT_57 = "\">" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart\">" + NL + "               <GlobalActionId actionId=\"bookmark\"/>" + NL + "            </ElementType>" + NL + "         </ViewId>" + NL + "      </GlobalActionHandlerProvider>" + NL + "      <GlobalActionHandlerProvider" + NL + "            class=\"org.eclipse.gmf.runtime.diagram.ui.render.providers.DiagramUIRenderGlobalActionHandlerProvider\"" + NL + "            id=\"";
  protected final String TEXT_58 = "Render\">" + NL + "         <Priority name=\"Lowest\"/>" + NL + "         <ViewId id=\"";
  protected final String TEXT_59 = "\">" + NL + "            <ElementType class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart\">" + NL + "               <GlobalActionId actionId=\"cut\"/>" + NL + "               <GlobalActionId actionId=\"copy\"/>" + NL + "               <GlobalActionId actionId=\"paste\"/>" + NL + "            </ElementType>" + NL + "         </ViewId>" + NL + "      </GlobalActionHandlerProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.diagram.core.viewProviders\">" + NL + "      <viewProvider class=\"";
  protected final String TEXT_60 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_61 = "\"/>" + NL + "         <context viewClass=\"org.eclipse.gmf.runtime.notation.Diagram\" semanticHints=\"";
  protected final String TEXT_62 = "\"/>" + NL + "         <context viewClass=\"org.eclipse.gmf.runtime.notation.Node\" semanticHints=\"\"/>" + NL + "         <context viewClass=\"org.eclipse.gmf.runtime.notation.Edge\" semanticHints=\"\"/>" + NL + "      </viewProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.diagram.ui.editpartProviders\">" + NL + "      <editpartProvider class=\"";
  protected final String TEXT_63 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_64 = "\"/>" + NL + "      </editpartProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.diagram.ui.paletteProviders\">" + NL + "      <paletteProvider class=\"";
  protected final String TEXT_65 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_66 = "\"/>" + NL + "         <editor id=\"";
  protected final String TEXT_67 = "\"/>" + NL + "      </paletteProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.emf.ui.modelingAssistantProviders\">" + NL + "      <modelingAssistantProvider class=\"";
  protected final String TEXT_68 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_69 = "\"/>" + NL + "      </modelingAssistantProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.properties.propertiesProviders\">" + NL + "      <PropertiesProvider" + NL + "            verifyPluginLoaded=\"false\"" + NL + "            class=\"";
  protected final String TEXT_70 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_71 = "\"/>" + NL + "      </PropertiesProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.iconProviders\">" + NL + "      <IconProvider class=\"";
  protected final String TEXT_72 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_73 = "\"/>" + NL + "      </IconProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.parserProviders\">" + NL + "      <ParserProvider class=\"";
  protected final String TEXT_74 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_75 = "\"/>" + NL + "      </ParserProvider>" + NL + "   </extension>";
  protected final String TEXT_76 = NL + NL + "   <extension point=\"org.eclipse.gmf.runtime.diagram.ui.decoratorProviders\">" + NL + "      <decoratorProvider class=\"";
  protected final String TEXT_77 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_78 = "\"/>" + NL + "      </decoratorProvider>" + NL + "   </extension>";
  protected final String TEXT_79 = NL + NL + "   <extension point=\"org.eclipse.gmf.runtime.emf.type.core.elementTypes\">";
  protected final String TEXT_80 = NL;
  protected final String TEXT_81 = NL + "      <metamodel nsURI=\"";
  protected final String TEXT_82 = "\">" + NL + "         <metamodelType" + NL + "               id=\"";
  protected final String TEXT_83 = "\"";
  protected final String TEXT_84 = NL + "               name=\"";
  protected final String TEXT_85 = "\"";
  protected final String TEXT_86 = NL + "               kind=\"org.eclipse.gmf.runtime.emf.type.core.IHintedType\"" + NL + "               eclass=\"";
  protected final String TEXT_87 = "\"" + NL + "               edithelper=\"";
  protected final String TEXT_88 = "\">" + NL + "            <param name=\"semanticHint\" value=\"";
  protected final String TEXT_89 = "\"/>" + NL + "         </metamodelType>" + NL + "      </metamodel>";
  protected final String TEXT_90 = NL + "      <metamodel nsURI=\"";
  protected final String TEXT_91 = "\">";
  protected final String TEXT_92 = NL + "         <specializationType" + NL + "               id=\"";
  protected final String TEXT_93 = "\"";
  protected final String TEXT_94 = NL + "               name=\"";
  protected final String TEXT_95 = "\"";
  protected final String TEXT_96 = NL + "               kind=\"org.eclipse.gmf.runtime.emf.type.core.IHintedType\"" + NL + "               edithelperadvice=\"";
  protected final String TEXT_97 = "\">" + NL + "            <specializes id=\"";
  protected final String TEXT_98 = "\"/>" + NL + "            <param name=\"semanticHint\" value=\"";
  protected final String TEXT_99 = "\"/>" + NL + "         </specializationType>";
  protected final String TEXT_100 = NL + "      </metamodel>";
  protected final String TEXT_101 = NL + "      <specializationType" + NL + "            id=\"";
  protected final String TEXT_102 = "\"";
  protected final String TEXT_103 = NL + "               name=\"";
  protected final String TEXT_104 = "\"";
  protected final String TEXT_105 = NL + "            kind=\"org.eclipse.gmf.runtime.diagram.ui.util.INotationType\">" + NL + "         <specializes id=\"org.eclipse.gmf.runtime.emf.type.core.null\"/>" + NL + "         <param name=\"semanticHint\" value=\"";
  protected final String TEXT_106 = "\"/>" + NL + "      </specializationType>";
  protected final String TEXT_107 = NL;
  protected final String TEXT_108 = NL + "      <metamodel nsURI=\"";
  protected final String TEXT_109 = "\">" + NL + "         <metamodelType" + NL + "               id=\"";
  protected final String TEXT_110 = "\"";
  protected final String TEXT_111 = NL + "               name=\"";
  protected final String TEXT_112 = "\"";
  protected final String TEXT_113 = NL + "               kind=\"org.eclipse.gmf.runtime.emf.type.core.IHintedType\"" + NL + "               eclass=\"";
  protected final String TEXT_114 = "\"" + NL + "               edithelper=\"";
  protected final String TEXT_115 = "\">" + NL + "            <param name=\"semanticHint\" value=\"";
  protected final String TEXT_116 = "\"/>" + NL + "         </metamodelType>" + NL + "      </metamodel>";
  protected final String TEXT_117 = NL + "      <metamodel nsURI=\"";
  protected final String TEXT_118 = "\">";
  protected final String TEXT_119 = NL + "         <specializationType" + NL + "               id=\"";
  protected final String TEXT_120 = "\"";
  protected final String TEXT_121 = NL + "               name=\"";
  protected final String TEXT_122 = "\"";
  protected final String TEXT_123 = NL + "               kind=\"org.eclipse.gmf.runtime.emf.type.core.IHintedType\"" + NL + "               edithelperadvice=\"";
  protected final String TEXT_124 = "\">" + NL + "            <specializes id=\"";
  protected final String TEXT_125 = "\"/>" + NL + "            <param name=\"semanticHint\" value=\"";
  protected final String TEXT_126 = "\"/>" + NL + "         </specializationType>";
  protected final String TEXT_127 = NL + "      </metamodel>";
  protected final String TEXT_128 = NL + "      <specializationType" + NL + "            id=\"";
  protected final String TEXT_129 = "\"";
  protected final String TEXT_130 = NL + "               name=\"";
  protected final String TEXT_131 = "\"";
  protected final String TEXT_132 = NL + "            kind=\"org.eclipse.gmf.runtime.diagram.ui.util.INotationType\">" + NL + "         <specializes id=\"org.eclipse.gmf.runtime.emf.type.core.null\"/>" + NL + "         <param name=\"semanticHint\" value=\"";
  protected final String TEXT_133 = "\"/>" + NL + "      </specializationType>";
  protected final String TEXT_134 = NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.gmf.runtime.emf.type.core.elementTypeBindings\">" + NL + "      <clientContext id=\"";
  protected final String TEXT_135 = "ClientContext\">" + NL + "         <enablement>" + NL + "            <test" + NL + "               property=\"org.eclipse.gmf.runtime.emf.core.editingDomain\"" + NL + "               value=\"";
  protected final String TEXT_136 = "EditingDomain\"/>" + NL + "         </enablement>" + NL + "      </clientContext> " + NL + "      <binding context=\"";
  protected final String TEXT_137 = "ClientContext\">" + NL + "         <elementType ref=\"";
  protected final String TEXT_138 = "\"/>";
  protected final String TEXT_139 = NL + "         <elementType ref=\"";
  protected final String TEXT_140 = "\"/>";
  protected final String TEXT_141 = NL + "         <advice ref=\"org.eclipse.gmf.runtime.diagram.core.advice.notationDepdendents\"/>" + NL + "      </binding>" + NL + "   </extension>";
  protected final String TEXT_142 = NL + NL + "   <extension point=\"org.eclipse.gmf.runtime.common.ui.services.markerNavigationProviders\">" + NL + "      <MarkerNavigationProvider class=\"";
  protected final String TEXT_143 = "\">" + NL + "         <MarkerType name=\"";
  protected final String TEXT_144 = "\"/>" + NL + "         <Priority name=\"";
  protected final String TEXT_145 = "\"/>" + NL + "      </MarkerNavigationProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension id=\"ValidationContributionItemProvider\" name=\"Validation\"" + NL + "      point=\"org.eclipse.gmf.runtime.common.ui.services.action.contributionItemProviders\">" + NL + "      <contributionItemProvider checkPluginLoaded=\"true\"" + NL + "         class=\"";
  protected final String TEXT_146 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_147 = "\"/>" + NL + "         <partContribution id=\"";
  protected final String TEXT_148 = "\">" + NL + "            <partMenuGroup menubarPath=\"/diagramMenu/\" id=\"validationGroup\"/>" + NL + "            <partAction id=\"validateAction\" menubarPath=\"/diagramMenu/validationGroup\"/>" + NL + "         </partContribution>" + NL + "      </contributionItemProvider>" + NL + "   </extension>" + NL + "" + NL + "   <extension id=\"";
  protected final String TEXT_149 = "\" name=\"";
  protected final String TEXT_150 = " problems\" point=\"org.eclipse.core.resources.markers\">" + NL + "      <super type=\"org.eclipse.core.resources.problemmarker\"/>" + NL + "      <super type=\"org.eclipse.gmf.runtime.common.ui.services.marker\"/>" + NL + "      <persistent value=\"true\"/>" + NL + "   </extension>";
  protected final String TEXT_151 = NL + "   <extension id=\"validationDecoratorProvider\" name=\"ValidationDecorations\" point=\"org.eclipse.gmf.runtime.diagram.ui.decoratorProviders\">" + NL + "      <decoratorProvider class=\"";
  protected final String TEXT_152 = "\">" + NL + "         <Priority name=\"";
  protected final String TEXT_153 = "\"/>" + NL + "         <object class=\"org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart(org.eclipse.gmf.runtime.diagram.ui)\" id=\"PRIMARY_VIEW\"/>" + NL + "         <context decoratorTargets=\"PRIMARY_VIEW\"/>" + NL + "      </decoratorProvider>" + NL + "   </extension>";
  protected final String TEXT_154 = NL;
  protected final String TEXT_155 = NL + "<extension point=\"org.eclipse.emf.validation.constraintProviders\">";
  protected final String TEXT_156 = NL + "\t<category" + NL + "\t\tid=\"";
  protected final String TEXT_157 = "\"" + NL + "\t\tmandatory=\"false\"" + NL + "\t\tname=\"";
  protected final String TEXT_158 = "\">" + NL + "\t<![CDATA[";
  protected final String TEXT_159 = "]]>" + NL + "\t</category>\t\t";
  protected final String TEXT_160 = NL + "\t<constraintProvider cache=\"true\">";
  protected final String TEXT_161 = NL + "\t\t<package namespaceUri=\"";
  protected final String TEXT_162 = "\"/>";
  protected final String TEXT_163 = NL + "\t\t<constraints categories=\"";
  protected final String TEXT_164 = "\">" + NL + "\t\t\t<constraint id=\"";
  protected final String TEXT_165 = "\"";
  protected final String TEXT_166 = NL + "\t\t\t\tlang=\"Java\" class=\"";
  protected final String TEXT_167 = "\"";
  protected final String TEXT_168 = NL + "\t\t\t\tlang=\"OCL\"";
  protected final String TEXT_169 = NL + "\t\t\t\tname=\"";
  protected final String TEXT_170 = "\" ";
  protected final String TEXT_171 = NL + "\t\t\t\tseverity=\"";
  protected final String TEXT_172 = "\" statusCode=\"";
  protected final String TEXT_173 = "\">";
  protected final String TEXT_174 = NL + "\t\t\t\t<![CDATA[";
  protected final String TEXT_175 = "]]>";
  protected final String TEXT_176 = "\t\t\t" + NL + "\t            <description><![CDATA[";
  protected final String TEXT_177 = "]]></description>" + NL + "\t            <message><![CDATA[";
  protected final String TEXT_178 = "]]></message>" + NL + "\t\t\t\t<target class=\"";
  protected final String TEXT_179 = "\"/>" + NL + "\t\t\t</constraint>" + NL + "\t\t</constraints>";
  protected final String TEXT_180 = NL + "\t</constraintProvider>" + NL + "</extension>" + NL + "" + NL + "<extension point=\"org.eclipse.emf.validation.constraintBindings\">";
  protected final String TEXT_181 = NL + "\t<clientContext default=\"false\" id=\"";
  protected final String TEXT_182 = ".";
  protected final String TEXT_183 = "\">" + NL + "\t\t<selector class=\"";
  protected final String TEXT_184 = "\"/>" + NL + "\t</clientContext>" + NL + "\t<binding context=\"";
  protected final String TEXT_185 = ".";
  protected final String TEXT_186 = "\">";
  protected final String TEXT_187 = "\t" + NL + "\t\t<constraint ref=\"";
  protected final String TEXT_188 = ".";
  protected final String TEXT_189 = "\"/>";
  protected final String TEXT_190 = NL + "\t</binding>";
  protected final String TEXT_191 = "\t\t" + NL + "</extension>";
  protected final String TEXT_192 = "   " + NL + "\t<extension id=\"MetricContributionItemProvider\" name=\"Metrics\"" + NL + "\t\tpoint=\"org.eclipse.gmf.runtime.common.ui.services.action.contributionItemProviders\">" + NL + "\t\t<contributionItemProvider checkPluginLoaded=\"true\" class=\"";
  protected final String TEXT_193 = "\">" + NL + "\t\t\t<Priority name=\"";
  protected final String TEXT_194 = "\"/>\t\t" + NL + "\t\t\t<partContribution id=\"";
  protected final String TEXT_195 = "\">" + NL + "\t\t\t\t<partMenuGroup menubarPath=\"/diagramMenu/\" id=\"validationGroup\"/>" + NL + "\t\t\t\t<partAction id=\"metricsAction\" menubarPath=\"/diagramMenu/validationGroup\"/>" + NL + "\t\t\t</partContribution>\t\t" + NL + "\t\t</contributionItemProvider>" + NL + "\t</extension>" + NL + "" + NL + "\t<extension point=\"org.eclipse.ui.views\">" + NL + "   \t\t<view class=\"";
  protected final String TEXT_196 = "$ResultView\"" + NL + "\t\t\tid=\"";
  protected final String TEXT_197 = "\"" + NL + "\t\t\tname=\"";
  protected final String TEXT_198 = " Diagram Metrics\"/>" + NL + "\t</extension>";
  protected final String TEXT_199 = NL + "</plugin>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenPlugin genPlugin = (GenPlugin) argument;
final GenEditorGenerator editorGen = genPlugin.getEditorGen();
final GenDiagram genDiagram = editorGen.getDiagram();

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
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(editorGen.getEditor().getIconPathX());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(editorGen.getEditor().getQualifiedClassName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genDiagram.getMatchingStrategyQualifiedClassName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(editorGen.getEditor().getActionBarContributorQualifiedClassName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genDiagram.getCreationWizardIconPathX());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genDiagram.getCreationWizardQualifiedClassName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genDiagram.getCreationWizardQualifiedClassName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_26);
    if (genDiagram.generateCreateShortcutAction()) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genDiagram.getEditPartQualifiedClassName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genDiagram.getCreateShortcutActionQualifiedClassName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genDiagram.getCreateShortcutActionQualifiedClassName());
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genDiagram.getEditPartQualifiedClassName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genDiagram.getLoadResourceActionQualifiedClassName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genDiagram.getLoadResourceActionQualifiedClassName());
    stringBuffer.append(TEXT_38);
    if (genPlugin.isPrintingEnabled()) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genDiagram.getContributionItemProviderQualifiedClassName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_41);
    }
    stringBuffer.append(TEXT_42);
    
for (Iterator contents = genDiagram.eAllContents(); contents.hasNext(); ) {
	Object next = contents.next();
	if (next instanceof GenLinkLabel || next instanceof GenExternalNodeLabel) {
		// disable delete actions for external labels

    stringBuffer.append(TEXT_43);
    stringBuffer.append(((GenCommonBase) next).getEditPartQualifiedClassName());
    stringBuffer.append(TEXT_44);
    
		continue;
	}
	if (next instanceof GenLink && ((GenLink) next).getModelFacet() instanceof FeatureLinkModelFacet) {
		// ref-based links should be removed from model, not from diagram

    stringBuffer.append(TEXT_45);
    stringBuffer.append(((GenCommonBase) next).getEditPartQualifiedClassName());
    stringBuffer.append(TEXT_46);
    
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
    stringBuffer.append(TEXT_55);
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genDiagram.getNotationViewProviderQualifiedClassName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genDiagram.getNotationViewProviderPriority());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(genPlugin.getEditorGen().getModelID());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(genDiagram.getEditPartProviderQualifiedClassName());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(genDiagram.getEditPartProviderPriority());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(genDiagram.getPaletteProviderQualifiedClassName());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(genDiagram.getPaletteProviderPriority());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(genDiagram.getModelingAssistantProviderQualifiedClassName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(genDiagram.getModelingAssistantProviderPriority());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(genDiagram.getPropertyProviderQualifiedClassName());
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genDiagram.getPropertyProviderPriority());
    stringBuffer.append(TEXT_71);
    stringBuffer.append(genDiagram.getIconProviderQualifiedClassName());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(genDiagram.getIconProviderPriority());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(genDiagram.getParserProviderQualifiedClassName());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(genDiagram.getParserProviderPriority());
    stringBuffer.append(TEXT_75);
    if (genDiagram.generateShortcutIcon()) {
    stringBuffer.append(TEXT_76);
    stringBuffer.append(genDiagram.getShortcutsDecoratorProviderQualifiedClassName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(genDiagram.getShortcutsDecoratorProviderPriority());
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    GenCommonBase genElement = genDiagram;
    stringBuffer.append(TEXT_80);
    
if (!genElement.getElementType().isDefinedExternally()) {
	final String displayName = genElement.getElementType().getDisplayName();

	if (genElement.getElementType() instanceof MetamodelType) {
		MetamodelType metamodelType = (MetamodelType) genElement.getElementType();
		GenClass metaClass = metamodelType.getMetaClass();

    stringBuffer.append(TEXT_81);
    stringBuffer.append(metaClass.getGenPackage().getNSURI());
    stringBuffer.append(TEXT_82);
    stringBuffer.append(metamodelType.getUniqueIdentifier());
    stringBuffer.append(TEXT_83);
    		if (displayName != null) {
    stringBuffer.append(TEXT_84);
    stringBuffer.append(displayName);
    stringBuffer.append(TEXT_85);
    		}
    stringBuffer.append(TEXT_86);
    stringBuffer.append(metaClass.getName());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(metamodelType.getEditHelperQualifiedClassName());
    stringBuffer.append(TEXT_88);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_89);
    
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

    stringBuffer.append(TEXT_90);
    stringBuffer.append(metaClass.getGenPackage().getNSURI());
    stringBuffer.append(TEXT_91);
    		}
    stringBuffer.append(TEXT_92);
    stringBuffer.append(specializationType.getUniqueIdentifier());
    stringBuffer.append(TEXT_93);
    		if (displayName != null) {
    stringBuffer.append(TEXT_94);
    stringBuffer.append(displayName);
    stringBuffer.append(TEXT_95);
    		}
    stringBuffer.append(TEXT_96);
    stringBuffer.append(specializationType.getEditHelperAdviceQualifiedClassName());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(metamodelTypeId);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_99);
    		if (metaClass != null) {
    stringBuffer.append(TEXT_100);
    
		}
	} else if (genElement.getElementType() instanceof NotationType) {
		NotationType notationType = (NotationType) genElement.getElementType();

    stringBuffer.append(TEXT_101);
    stringBuffer.append(notationType.getUniqueIdentifier());
    stringBuffer.append(TEXT_102);
    		if (displayName != null) {
    stringBuffer.append(TEXT_103);
    stringBuffer.append(displayName);
    stringBuffer.append(TEXT_104);
    		}
    stringBuffer.append(TEXT_105);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_106);
    
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

    stringBuffer.append(TEXT_107);
    
if (!genElement.getElementType().isDefinedExternally()) {
	final String displayName = genElement.getElementType().getDisplayName();

	if (genElement.getElementType() instanceof MetamodelType) {
		MetamodelType metamodelType = (MetamodelType) genElement.getElementType();
		GenClass metaClass = metamodelType.getMetaClass();

    stringBuffer.append(TEXT_108);
    stringBuffer.append(metaClass.getGenPackage().getNSURI());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(metamodelType.getUniqueIdentifier());
    stringBuffer.append(TEXT_110);
    		if (displayName != null) {
    stringBuffer.append(TEXT_111);
    stringBuffer.append(displayName);
    stringBuffer.append(TEXT_112);
    		}
    stringBuffer.append(TEXT_113);
    stringBuffer.append(metaClass.getName());
    stringBuffer.append(TEXT_114);
    stringBuffer.append(metamodelType.getEditHelperQualifiedClassName());
    stringBuffer.append(TEXT_115);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_116);
    
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

    stringBuffer.append(TEXT_117);
    stringBuffer.append(metaClass.getGenPackage().getNSURI());
    stringBuffer.append(TEXT_118);
    		}
    stringBuffer.append(TEXT_119);
    stringBuffer.append(specializationType.getUniqueIdentifier());
    stringBuffer.append(TEXT_120);
    		if (displayName != null) {
    stringBuffer.append(TEXT_121);
    stringBuffer.append(displayName);
    stringBuffer.append(TEXT_122);
    		}
    stringBuffer.append(TEXT_123);
    stringBuffer.append(specializationType.getEditHelperAdviceQualifiedClassName());
    stringBuffer.append(TEXT_124);
    stringBuffer.append(metamodelTypeId);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_126);
    		if (metaClass != null) {
    stringBuffer.append(TEXT_127);
    
		}
	} else if (genElement.getElementType() instanceof NotationType) {
		NotationType notationType = (NotationType) genElement.getElementType();

    stringBuffer.append(TEXT_128);
    stringBuffer.append(notationType.getUniqueIdentifier());
    stringBuffer.append(TEXT_129);
    		if (displayName != null) {
    stringBuffer.append(TEXT_130);
    stringBuffer.append(displayName);
    stringBuffer.append(TEXT_131);
    		}
    stringBuffer.append(TEXT_132);
    stringBuffer.append(genElement.getVisualID());
    stringBuffer.append(TEXT_133);
    
	}
}

    }
    stringBuffer.append(TEXT_134);
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_135);
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_136);
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(genDiagram.getElementType().getUniqueIdentifier());
    stringBuffer.append(TEXT_138);
    
for (Iterator contents = genDiagram.eAllContents(); contents.hasNext(); ) {
	Object next = contents.next();
	if (next instanceof GenNode) {
		genElement = (GenCommonBase) next;
	} else if (next instanceof GenLink) {
		genElement = (GenCommonBase) next;
	} else {
		continue;
	}

    stringBuffer.append(TEXT_139);
    stringBuffer.append(genElement.getElementType().getUniqueIdentifier());
    stringBuffer.append(TEXT_140);
    }
    stringBuffer.append(TEXT_141);
    if(genDiagram.isValidationEnabled()) {
    stringBuffer.append(TEXT_142);
    stringBuffer.append(genDiagram.getMarkerNavigationProviderQualifiedClassName());
    stringBuffer.append(TEXT_143);
    stringBuffer.append(genPlugin.getID() + "." + genDiagram.getValidationDiagnosticMarkerType());
    stringBuffer.append(TEXT_144);
    stringBuffer.append(genDiagram.getMarkerNavigationProviderPriority());
    stringBuffer.append(TEXT_145);
    stringBuffer.append(genDiagram.getValidationProviderQualifiedClassName());
    stringBuffer.append(TEXT_146);
    stringBuffer.append(genDiagram.getValidationProviderPriority());
    stringBuffer.append(TEXT_147);
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_148);
    stringBuffer.append(genDiagram.getValidationDiagnosticMarkerType());
    stringBuffer.append(TEXT_149);
    stringBuffer.append(genPlugin.getName());
    stringBuffer.append(TEXT_150);
    	if(genDiagram.isValidationDecorators()) { 
    stringBuffer.append(TEXT_151);
    stringBuffer.append(genDiagram.getValidationDecoratorProviderQualifedClassName());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(genDiagram.getValidationDecoratorProviderPriority());
    stringBuffer.append(TEXT_153);
    	} /* decorators */
} /* validation */

    stringBuffer.append(TEXT_154);
    
GenAuditContainer rootContainer = genDiagram.getEditorGen().getAudits();
if (rootContainer != null && genDiagram.getDomainDiagramElement() != null) {
	java.util.List containers = rootContainer != null ? rootContainer.getAllAuditContainers() : java.util.Collections.EMPTY_LIST;

    stringBuffer.append(TEXT_155);
    
	java.util.HashMap idMap = new java.util.HashMap();
	for(int i = 0; i < containers.size(); i++) {
		GenAuditContainer container = (GenAuditContainer)containers.get(i);
		idMap.put(container, container.getId() != null ? container.getId() : "category" + Integer.toString(i + 1));
	}
	java.util.HashMap pathMap = new java.util.HashMap();
	for(int i = 0; i < containers.size(); i++) {
		GenAuditContainer category = (GenAuditContainer)containers.get(i);
		java.util.List path = category.getPath();
		StringBuffer id = new StringBuffer();
		for(int pathPos = 0; pathPos < path.size(); pathPos++) {
			if(pathPos > 0) id.append('/');
			id.append(idMap.get(path.get(pathPos)));
		}
		pathMap.put(category, id.toString());

    stringBuffer.append(TEXT_156);
    stringBuffer.append(id.toString());
    stringBuffer.append(TEXT_157);
    stringBuffer.append(category.getName() != null ? category.getName() : id.toString());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(category.getDescription() != null ? category.getDescription():"");
    stringBuffer.append(TEXT_159);
    
	} // end of categories loop

    stringBuffer.append(TEXT_160);
    
	for(java.util.Iterator packageIt = rootContainer.getAllTargetedModelPackages().iterator(); packageIt.hasNext();) {
		GenPackage genPackage = (GenPackage)packageIt.next();

    stringBuffer.append(TEXT_161);
    stringBuffer.append(genPackage.getNSURI());
    stringBuffer.append(TEXT_162);
    
	} // end of used model packages iteration
	int rulePos = 0;
	for(java.util.Iterator catIt = containers.iterator(); catIt.hasNext();) {
		GenAuditContainer category = (GenAuditContainer)catIt.next();
		for(java.util.Iterator it = category.getAudits().iterator(); it.hasNext(); rulePos++) {
			GenAuditRule audit = (GenAuditRule)it.next();
			if(audit.getTarget() == null || (audit.getTarget().getTargetClass() == null)) continue;
			GenClass targetClass = audit.getTarget().getTargetClass();
			String targetClassName = (targetClass != null) ? targetClass.getGenPackage().getNSName() + "." + targetClass.getInterfaceName() : "null";
			String modeAttr = audit.isUseInLiveMode() ? "" : "mode=\"Batch\"";
			String name = audit.getName() != null ? audit.getName() : audit.getId();
			String message = audit.getMessage() != null ? audit.getMessage() : name + " audit violated";

    stringBuffer.append(TEXT_163);
    stringBuffer.append(pathMap.get(category));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(audit.getId());
    stringBuffer.append(TEXT_165);
    			if(audit.requiresConstraintAdapter()) {
    stringBuffer.append(TEXT_166);
    stringBuffer.append(audit.getConstraintAdapterQualifiedClassName());
    stringBuffer.append(TEXT_167);
    			} else { 
    stringBuffer.append(TEXT_168);
    			} 
    stringBuffer.append(TEXT_169);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(modeAttr);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(audit.getSeverity().getName());
    stringBuffer.append(TEXT_172);
    stringBuffer.append(Integer.toString(200 + rulePos));
    stringBuffer.append(TEXT_173);
    			if(!audit.requiresConstraintAdapter()) {
    stringBuffer.append(TEXT_174);
    stringBuffer.append(audit.getRule() != null ? audit.getRule().getBody() : "");
    stringBuffer.append(TEXT_175);
    			} 
    stringBuffer.append(TEXT_176);
    stringBuffer.append(audit.getDescription() != null ? audit.getDescription():"");
    stringBuffer.append(TEXT_177);
    stringBuffer.append(message);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(targetClassName);
    stringBuffer.append(TEXT_179);
    
		} // end of audits in category
	} // end of category loop

    stringBuffer.append(TEXT_180);
    
	String pluginID = genDiagram.getEditorGen().getPlugin().getID();
	for(java.util.Iterator it = rootContainer.getAllRulesToTargetContextMap().entrySet().iterator(); it.hasNext();) {
		java.util.Map.Entry ctx2Rules = (java.util.Map.Entry)it.next();
		java.util.List rules = (java.util.List)ctx2Rules.getValue();
		if(rules.isEmpty()) continue;
		String ctxID = (String)ctx2Rules.getKey();
		GenAuditRule ruleTarget = (GenAuditRule)rules.get(0);

    stringBuffer.append(TEXT_181);
    stringBuffer.append(pluginID);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(ctxID);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(ruleTarget.getContextSelectorQualifiedClassName());
    stringBuffer.append(TEXT_184);
    stringBuffer.append(pluginID);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(ctxID);
    stringBuffer.append(TEXT_186);
    
		for(java.util.Iterator ruleIt = rules.iterator(); ruleIt.hasNext();) {
			GenAuditRule nextRule = (GenAuditRule)ruleIt.next();

    stringBuffer.append(TEXT_187);
    stringBuffer.append(pluginID);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(nextRule.getId());
    stringBuffer.append(TEXT_189);
    
		} // end of rules in context

    stringBuffer.append(TEXT_190);
    
	} // end of contexts iteration

    stringBuffer.append(TEXT_191);
    
}

    if (editorGen.getMetrics() != null && !editorGen.getMetrics().getMetrics().isEmpty()) {
    stringBuffer.append(TEXT_192);
    stringBuffer.append(genDiagram.getMetricProviderQualifiedClassName());
    stringBuffer.append(TEXT_193);
    stringBuffer.append(genDiagram.getMetricProviderPriority());
    stringBuffer.append(TEXT_194);
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_195);
    stringBuffer.append(genDiagram.getMetricProviderQualifiedClassName());
    stringBuffer.append(TEXT_196);
    stringBuffer.append(genDiagram.getMetricViewID());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(editorGen.getModelID());
    stringBuffer.append(TEXT_198);
    } // end of metrics
    stringBuffer.append(TEXT_199);
    return stringBuffer.toString();
  }
}
