package org.eclipse.gmf.codegen.templates.navigator;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import java.util.*;
import org.eclipse.emf.codegen.util.*;
import org.eclipse.gmf.codegen.util.*;

public class NavigatorContentProviderGenerator
{
  protected static String nl;
  public static synchronized NavigatorContentProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NavigatorContentProviderGenerator result = new NavigatorContentProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " implements ";
  protected final String TEXT_7 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final Object[] EMPTY_ARRAY = new Object[0];" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public void dispose() {" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public void inputChanged(";
  protected final String TEXT_8 = " viewer, Object oldInput, Object newInput) {" + NL + "    }" + NL + "    " + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object[] getElements(Object inputElement) {" + NL + "\t\treturn getChildren(inputElement);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public Object[] getChildren(Object parentElement) {" + NL + "\t\tif (parentElement instanceof ";
  protected final String TEXT_9 = ") {" + NL + "\t    \t";
  protected final String TEXT_10 = " file = (";
  protected final String TEXT_11 = ") parentElement;" + NL + "\t\t\t";
  protected final String TEXT_12 = " editingDomain = (";
  protected final String TEXT_13 = ") ";
  protected final String TEXT_14 = ".INSTANCE.createEditingDomain();" + NL + "\t\t\teditingDomain.setResourceToReadOnlyMap(new ";
  protected final String TEXT_15 = "() {" + NL + "\t\t\t\tpublic Object get(Object key) {" + NL + "\t\t\t\t\tif (!containsKey(key)) {" + NL + "\t\t\t\t\t\tput(key, Boolean.TRUE);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn super.get(key);" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t\t";
  protected final String TEXT_16 = " resourceSet = editingDomain.getResourceSet();" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_17 = " fileURI = ";
  protected final String TEXT_18 = ".createPlatformResourceURI(file.getFullPath().toString(), true);" + NL + "\t\t\t";
  protected final String TEXT_19 = " resource = resourceSet.getResource(fileURI, true);" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_20 = " result = new ";
  protected final String TEXT_21 = "();";
  protected final String TEXT_22 = NL + "\t\t\t";
  protected final String TEXT_23 = " ";
  protected final String TEXT_24 = " = new ";
  protected final String TEXT_25 = "(\"";
  protected final String TEXT_26 = "\", \"";
  protected final String TEXT_27 = "\", file);";
  protected final String TEXT_28 = NL + "\t\t\t";
  protected final String TEXT_29 = ".addChildren(";
  protected final String TEXT_30 = NL + "\t\t\tresult.addAll(";
  protected final String TEXT_31 = "createNavigatorItems(selectViewsByType(resource.getContents(), ";
  protected final String TEXT_32 = ".MODEL_ID";
  protected final String TEXT_33 = ".getType(";
  protected final String TEXT_34 = ".VISUAL_ID)";
  protected final String TEXT_35 = "), ";
  protected final String TEXT_36 = "));";
  protected final String TEXT_37 = NL + "\t\t\tif (!";
  protected final String TEXT_38 = ".isEmpty()) {";
  protected final String TEXT_39 = NL + "\t\t\tresult.add(";
  protected final String TEXT_40 = ");";
  protected final String TEXT_41 = NL + "\t\t\t}";
  protected final String TEXT_42 = NL + "\t\t\treturn result.toArray();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif (parentElement instanceof ";
  protected final String TEXT_43 = ") {" + NL + "\t\t\t";
  protected final String TEXT_44 = " group = (";
  protected final String TEXT_45 = ") parentElement;" + NL + "\t\t\treturn group.getChildren();" + NL + "\t\t} " + NL + "" + NL + "\t\tif (parentElement instanceof ";
  protected final String TEXT_46 = ") {" + NL + "\t\t\t";
  protected final String TEXT_47 = " navigatorItem = (";
  protected final String TEXT_48 = ") parentElement;" + NL + "    \t\tif (navigatorItem.isLeaf() || !isOwnView(navigatorItem.getView())) {" + NL + "    \t\t\treturn EMPTY_ARRAY;" + NL + "    \t\t}" + NL + "    \t\treturn getViewChildren(navigatorItem.getView(), parentElement);" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_49 = NL + "\t\t// Due to plugin.xml content will be called only for \"own\" views" + NL + "\t\tif (parentElement instanceof ";
  protected final String TEXT_50 = ") {" + NL + "\t\t\t";
  protected final String TEXT_51 = " view = (";
  protected final String TEXT_52 = ") ((";
  protected final String TEXT_53 = ") parentElement).getAdapter(";
  protected final String TEXT_54 = ".class);" + NL + "\t\t\tif (view != null) {" + NL + "\t\t\t\treturn getViewChildren(view, parentElement);" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_55 = NL + NL + "\t\treturn EMPTY_ARRAY;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    private Object[] getViewChildren(";
  protected final String TEXT_56 = " view, Object parentElement) {" + NL + "\t\tswitch (";
  protected final String TEXT_57 = ".getVisualID(view)) {";
  protected final String TEXT_58 = NL + "\t\tcase ";
  protected final String TEXT_59 = ".VISUAL_ID: {" + NL + "\t\t\t";
  protected final String TEXT_60 = " result = new ";
  protected final String TEXT_61 = "();";
  protected final String TEXT_62 = NL + "\t\t\tresult.addAll(getForeignShortcuts((";
  protected final String TEXT_63 = ") view, parentElement));";
  protected final String TEXT_64 = NL + "\t\t\t";
  protected final String TEXT_65 = " ";
  protected final String TEXT_66 = " = new ";
  protected final String TEXT_67 = "(\"";
  protected final String TEXT_68 = "\", \"";
  protected final String TEXT_69 = "\", parentElement);";
  protected final String TEXT_70 = NL + "\t\t\t";
  protected final String TEXT_71 = ".addChildren(";
  protected final String TEXT_72 = NL + "\t\t\tresult.addAll(";
  protected final String TEXT_73 = "(";
  protected final String TEXT_74 = "(";
  protected final String TEXT_75 = ") ";
  protected final String TEXT_76 = "view, ";
  protected final String TEXT_77 = "));";
  protected final String TEXT_78 = NL + "\t\t\tif (!";
  protected final String TEXT_79 = ".isEmpty()) {";
  protected final String TEXT_80 = NL + "\t\t\tresult.add(";
  protected final String TEXT_81 = ");";
  protected final String TEXT_82 = NL + "\t\t\t}";
  protected final String TEXT_83 = NL + "\t\t\treturn result.toArray();" + NL + "\t\t}";
  protected final String TEXT_84 = NL + "\t\t}" + NL + "\t\treturn EMPTY_ARRAY;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public Object getParent(Object element) {" + NL + "    \tif (element instanceof ";
  protected final String TEXT_85 = ") {" + NL + "    \t\t";
  protected final String TEXT_86 = " abstractNavigatorItem = (";
  protected final String TEXT_87 = ") element;" + NL + "\t\t\treturn abstractNavigatorItem.getParent();" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public boolean hasChildren(Object element) {" + NL + "    \treturn element instanceof ";
  protected final String TEXT_88 = " || getChildren(element).length > 0;" + NL + "    }" + NL + "    " + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void init(";
  protected final String TEXT_89 = " aConfig) {" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void restoreState(";
  protected final String TEXT_90 = " aMemento) {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void saveState(";
  protected final String TEXT_91 = " aMemento) {" + NL + "\t}" + NL;
  protected final String TEXT_92 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_93 = " ";
  protected final String TEXT_94 = "(";
  protected final String TEXT_95 = " ";
  protected final String TEXT_96 = ", Object parent) {" + NL + "\t\t";
  protected final String TEXT_97 = " result = new ";
  protected final String TEXT_98 = "();";
  protected final String TEXT_99 = NL + "\t\t";
  protected final String TEXT_100 = " connectedViews = ";
  protected final String TEXT_101 = NL + "\t\tconnectedViews = ";
  protected final String TEXT_102 = "getLinksTargetByType";
  protected final String TEXT_103 = "getLinksSourceByType";
  protected final String TEXT_104 = "getOutgoingLinksByType";
  protected final String TEXT_105 = "getIncomingLinksByType";
  protected final String TEXT_106 = "getDiagramLinksByType";
  protected final String TEXT_107 = "getChildrenByType";
  protected final String TEXT_108 = "(";
  protected final String TEXT_109 = ".singleton(";
  protected final String TEXT_110 = ")";
  protected final String TEXT_111 = "connectedViews";
  protected final String TEXT_112 = ", ";
  protected final String TEXT_113 = ".getType(";
  protected final String TEXT_114 = ".VISUAL_ID));";
  protected final String TEXT_115 = NL + "\t\tcreateNavigatorItems(connectedViews, parent, result, ";
  protected final String TEXT_116 = "(";
  protected final String TEXT_117 = "));";
  protected final String TEXT_118 = NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean ";
  protected final String TEXT_119 = "(";
  protected final String TEXT_120 = " ";
  protected final String TEXT_121 = ") {" + NL + "\t\treturn ";
  protected final String TEXT_122 = ";" + NL + "\t}";
  protected final String TEXT_123 = NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_124 = " getLinksSourceByType(";
  protected final String TEXT_125 = " edges, String type) {" + NL + "\t\t";
  protected final String TEXT_126 = " result = new ";
  protected final String TEXT_127 = "();" + NL + "\t \tfor (";
  protected final String TEXT_128 = " it = edges.iterator(); it.hasNext();) {" + NL + "\t \t\t";
  protected final String TEXT_129 = " nextEdge = (";
  protected final String TEXT_130 = ") it.next();" + NL + "\t \t\t";
  protected final String TEXT_131 = " nextEdgeSource = nextEdge.getSource();" + NL + "\t \t\tif (type.equals(nextEdgeSource.getType()) && !isOwnView(nextEdgeSource)) {" + NL + "\t \t\t\tresult.add(nextEdgeSource);" + NL + "\t \t\t}" + NL + "\t \t}" + NL + "\t \treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_132 = " getLinksTargetByType(";
  protected final String TEXT_133 = " edges, String type) {" + NL + "\t\t";
  protected final String TEXT_134 = " result = new ";
  protected final String TEXT_135 = "();" + NL + "\t \tfor (";
  protected final String TEXT_136 = " it = edges.iterator(); it.hasNext();) {" + NL + "\t \t\t";
  protected final String TEXT_137 = " nextEdge = (";
  protected final String TEXT_138 = ") it.next();" + NL + "\t \t\t";
  protected final String TEXT_139 = " nextEdgeSource = nextEdge.getTarget();" + NL + "\t \t\tif (type.equals(nextEdgeSource.getType()) && !isOwnView(nextEdgeSource)) {" + NL + "\t \t\t\tresult.add(nextEdgeSource);" + NL + "\t \t\t}" + NL + "\t \t}" + NL + "\t \treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_140 = " getOutgoingLinksByType(";
  protected final String TEXT_141 = " nodes, String type) {" + NL + "\t\t";
  protected final String TEXT_142 = " result = new ";
  protected final String TEXT_143 = "();" + NL + "\t \tfor (";
  protected final String TEXT_144 = " it = nodes.iterator(); it.hasNext();) {" + NL + "\t \t\t";
  protected final String TEXT_145 = " nextNode = (";
  protected final String TEXT_146 = ") it.next();" + NL + "\t\t\tresult.addAll(selectViewsByType(nextNode.getSourceEdges(), type));" + NL + "\t \t}" + NL + "\t \treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_147 = " getIncomingLinksByType(";
  protected final String TEXT_148 = " nodes, String type) {" + NL + "\t\t";
  protected final String TEXT_149 = " result = new ";
  protected final String TEXT_150 = "();" + NL + "\t \tfor (";
  protected final String TEXT_151 = " it = nodes.iterator(); it.hasNext();) {" + NL + "\t \t\t";
  protected final String TEXT_152 = " nextNode = (";
  protected final String TEXT_153 = ") it.next();" + NL + "\t\t\tresult.addAll(selectViewsByType(nextNode.getTargetEdges(), type));" + NL + "\t \t}" + NL + "\t \treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_154 = " getChildrenByType(";
  protected final String TEXT_155 = " nodes, String type) {" + NL + "\t\t";
  protected final String TEXT_156 = " result = new ";
  protected final String TEXT_157 = "();" + NL + "\t \tfor (";
  protected final String TEXT_158 = " it = nodes.iterator(); it.hasNext();) {" + NL + "\t \t\t";
  protected final String TEXT_159 = " nextNode = (";
  protected final String TEXT_160 = ") it.next();" + NL + "\t\t\tresult.addAll(selectViewsByType(nextNode.getChildren(), type));" + NL + "\t \t}" + NL + "\t \treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_161 = " getDiagramLinksByType(";
  protected final String TEXT_162 = " diagrams, String type) {" + NL + "\t\t";
  protected final String TEXT_163 = " result = new ";
  protected final String TEXT_164 = "();" + NL + "\t \tfor (";
  protected final String TEXT_165 = " it = diagrams.iterator(); it.hasNext();) {" + NL + "\t \t\t";
  protected final String TEXT_166 = " nextDiagram = (";
  protected final String TEXT_167 = ") it.next();" + NL + "\t\t\tresult.addAll(selectViewsByType(nextDiagram.getEdges(), type));" + NL + "\t \t}" + NL + "\t \treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_168 = " selectViewsByType(";
  protected final String TEXT_169 = " views, String type) {" + NL + "\t\t";
  protected final String TEXT_170 = " result = new ";
  protected final String TEXT_171 = "();" + NL + "\t\tfor (";
  protected final String TEXT_172 = " it = views.iterator(); it.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_173 = " nextView = (";
  protected final String TEXT_174 = ") it.next();" + NL + "\t\t\tif (type.equals(nextView.getType()) && isOwnView(nextView)) {" + NL + "\t\t\t\tresult.add(nextView);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_175 = " createNavigatorItems(";
  protected final String TEXT_176 = " views, Object parent) {" + NL + "\t\t";
  protected final String TEXT_177 = " result = new ";
  protected final String TEXT_178 = "();" + NL + "\t\tcreateNavigatorItems(views, parent, result, false);" + NL + "\t\treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createNavigatorItems(";
  protected final String TEXT_179 = " views, Object parent, ";
  protected final String TEXT_180 = " result, boolean isLeafs) {" + NL + "\t\tfor (";
  protected final String TEXT_181 = " it = views.iterator(); it.hasNext();) {" + NL + "\t\t\tresult.add(new ";
  protected final String TEXT_182 = "((";
  protected final String TEXT_183 = ") it.next(), parent, isLeafs));" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isOwnView(";
  protected final String TEXT_184 = " view) {" + NL + "\t\treturn ";
  protected final String TEXT_185 = ".MODEL_ID.equals(";
  protected final String TEXT_186 = ".getModelID(view));" + NL + "\t}" + NL + "\t";
  protected final String TEXT_187 = "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_188 = " getForeignShortcuts(";
  protected final String TEXT_189 = " diagram, Object parent) {" + NL + "\t\t";
  protected final String TEXT_190 = " result = new ";
  protected final String TEXT_191 = "();" + NL + "\t\tfor (";
  protected final String TEXT_192 = " it = diagram.getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_193 = " nextView = (";
  protected final String TEXT_194 = ") it.next();" + NL + "\t\t\tif (!isOwnView(nextView) && nextView.getEAnnotation(\"Shortcut\") != null) { //$NON-NLS-1$" + NL + "\t\t\t\tresult.add(nextView);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn createNavigatorItems(result, parent);" + NL + "\t}" + NL + "\t";
  protected final String TEXT_195 = NL + "}";
  protected final String TEXT_196 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenNavigator genNavigator = (GenNavigator) ((Object[]) argument)[0];
GenDiagram genDiagram = genNavigator.getEditorGen().getDiagram();
Collection commonBaseElements = new ArrayList(genDiagram.getAllContainers());
commonBaseElements.addAll(genDiagram.getLinks());
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genNavigator.getContentProviderClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonContentProvider"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.Viewer"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.ResourceSet"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_21);
    Map createdDiagramGroups = new TreeMap();
for (Iterator it = genNavigator.getChildReferencesFrom(null).iterator(); it.hasNext();) {
	GenNavigatorChildReference nextReference = (GenNavigatorChildReference) it.next();
	if (nextReference.getReferenceType() != GenNavigatorReferenceType.CHILDREN_LITERAL) {
		continue;
	}
	String parentVariable;
	if (nextReference.isInsideGroup()) {
		parentVariable = CodeGenUtil.validJavaIdentifier(nextReference.getGroupName());
		if (!createdDiagramGroups.containsKey(parentVariable)) {
			createdDiagramGroups.put(parentVariable, nextReference);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(nextReference.getGroupName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(nextReference.getGroupIcon());
    stringBuffer.append(TEXT_27);
    		}
    stringBuffer.append(TEXT_28);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_29);
    
	} else {
		parentVariable = "file";
    stringBuffer.append(TEXT_30);
    
	}
    stringBuffer.append(TEXT_31);
    
	if (nextReference.getChild() instanceof GenDiagram) {
		
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_32);
    
	} else {
		
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_34);
    
	}
    stringBuffer.append(TEXT_35);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_36);
    }

for (Iterator it = createdDiagramGroups.keySet().iterator(); it.hasNext();) {
	String groupNameKey = (String) it.next();
	GenNavigatorChildReference nextReference = (GenNavigatorChildReference) createdDiagramGroups.get(groupNameKey);
	if (nextReference.isHideIfEmpty()) {
    stringBuffer.append(TEXT_37);
    stringBuffer.append(groupNameKey);
    stringBuffer.append(TEXT_38);
    	}
    stringBuffer.append(TEXT_39);
    stringBuffer.append(groupNameKey);
    stringBuffer.append(TEXT_40);
    	if (nextReference.isHideIfEmpty()) {
    stringBuffer.append(TEXT_41);
    	}
}

    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_48);
    if (genDiagram.generateShortcutIcon()) {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_54);
    
}
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_57);
    boolean generateGetForeignShortcuts = false;
Map getter2ReferenceMap = new TreeMap();
for (Iterator containers = commonBaseElements.iterator(); containers.hasNext();) {
	GenCommonBase nextCommonBase = (GenCommonBase) containers.next();
	Collection childReferences = genNavigator.getChildReferencesFrom(nextCommonBase);
	if (childReferences.size() == 0) {
		continue;
	}
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName(nextCommonBase.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_61);
    	if (nextCommonBase instanceof GenDiagram && ((GenDiagram) nextCommonBase).generateCreateShortcutAction()) {
		generateGetForeignShortcuts = true;
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_63);
    	}
	Map createdGroups = new TreeMap();
	for (Iterator it = childReferences.iterator(); it.hasNext();) {
		GenNavigatorChildReference nextReference = (GenNavigatorChildReference) it.next();
		String parentVariable;
		if (nextReference.isInsideGroup()) {
			parentVariable = CodeGenUtil.validJavaIdentifier(nextReference.getGroupName());
			if (!createdGroups.containsKey(parentVariable)) {
				createdGroups.put(parentVariable, nextReference);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(nextReference.getGroupName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(nextReference.getGroupIcon());
    stringBuffer.append(TEXT_69);
    			}
    stringBuffer.append(TEXT_70);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_71);
    
		} else {
			parentVariable = "parentElement";
    stringBuffer.append(TEXT_72);
    
		}
		
		String getterNameBase = nextCommonBase.getUniqueIdentifier() + "To" + nextReference.getChild().getUniqueIdentifier();
		if (nextReference.getReferenceType() == GenNavigatorReferenceType.OUT_TAGET_LITERAL) {
			getterNameBase = getterNameBase + "OutTarget";
		} else if (nextReference.getReferenceType() == GenNavigatorReferenceType.IN_SOURCE_LITERAL) {
			getterNameBase = getterNameBase + "InSource";
		} else { /*nextReference.getReferenceType() == GenNavigatorReferenceType.CHILDREN_LITERAL*/
			getterNameBase = getterNameBase + "Children";
		}
		String getterName = getterNameBase;
		for (int i = 1; getter2ReferenceMap.containsKey(getterName); i++) {
			getterName = getterNameBase + "_" + i;
		}
		getter2ReferenceMap.put(getterName, nextReference);
		getterName = "get" + getterName;
		
    stringBuffer.append(getterName);
    stringBuffer.append(TEXT_73);
    if (nextCommonBase instanceof GenLink) {
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_75);
    }
    stringBuffer.append(TEXT_76);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_77);
    	}
	
	for (Iterator it = createdGroups.keySet().iterator(); it.hasNext();) {
		String nextGroupKey = (String) it.next();
		GenNavigatorChildReference nextReference = (GenNavigatorChildReference) createdGroups.get(nextGroupKey);
		if (nextReference.isHideIfEmpty()) {
    stringBuffer.append(TEXT_78);
    stringBuffer.append(nextGroupKey);
    stringBuffer.append(TEXT_79);
    		}
    stringBuffer.append(TEXT_80);
    stringBuffer.append(nextGroupKey);
    stringBuffer.append(TEXT_81);
    		if (nextReference.isHideIfEmpty()) {
    stringBuffer.append(TEXT_82);
    		}
	}
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonContentExtensionSite"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IMemento"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IMemento"));
    stringBuffer.append(TEXT_91);
    GenModelGraphAnalyzer graphAnalyzer = new GenModelGraphAnalyzer(genDiagram);
for (Iterator it = getter2ReferenceMap.entrySet().iterator(); it.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) it.next();
	GenNavigatorChildReference childReference = (GenNavigatorChildReference) nextEntry.getValue();
	String methodName = (String) nextEntry.getKey();
	String parameterClassFQName;
	String parameterName;
	if (childReference.getParent() instanceof GenLink) {
		parameterClassFQName = "org.eclipse.gmf.runtime.notation.Edge";
		parameterName = "edge";
	} else {
		parameterClassFQName = "org.eclipse.gmf.runtime.notation.View";
		parameterName = "view";
	}
	List<List<GenCommonBase>> paths = graphAnalyzer.getConnectionPaths(childReference);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append("get" + methodName);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName(parameterClassFQName));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_98);
    	boolean connectedViewsDeclared = false;
	for (List<GenCommonBase> nextPath : paths) {
		for (int i = 0; i < nextPath.size() - 1; i++) {
			GenCommonBase currentPathSegment = nextPath.get(i);
			GenCommonBase nextPathSegment = nextPath.get(i + 1);
			if (!connectedViewsDeclared) {
				connectedViewsDeclared = true;
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_100);
    
			}else {
    stringBuffer.append(TEXT_101);
    
			}
			if (currentPathSegment instanceof GenLink) {
				if (childReference.getReferenceType() == GenNavigatorReferenceType.OUT_TAGET_LITERAL) {
					
    stringBuffer.append(TEXT_102);
    
				} else { /*childReference.getReferenceType() == GenNavigatorReferenceType.IN_SOURCE_LITERAL*/
					
    stringBuffer.append(TEXT_103);
    
				}
			} else {
				if (childReference.getReferenceType() == GenNavigatorReferenceType.OUT_TAGET_LITERAL) {
					
    stringBuffer.append(TEXT_104);
    
				} else if (childReference.getReferenceType() == GenNavigatorReferenceType.IN_SOURCE_LITERAL) {
					
    stringBuffer.append(TEXT_105);
    
				} else { /*childReference.getReferenceType() == GenNavigatorReferenceType.CHILDREN_LITERAL*/
					if (currentPathSegment instanceof GenDiagram && nextPathSegment instanceof GenLink) {
						/* References from diagram to links are represented by CHILDREN_LITERAL too */
						
    stringBuffer.append(TEXT_106);
    
					} else {
						
    stringBuffer.append(TEXT_107);
    
					}
				}
			}
    stringBuffer.append(TEXT_108);
    
			if (i == 0) {
				
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_110);
    
			} else {
				
    stringBuffer.append(TEXT_111);
    
			}
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName(nextPathSegment.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_114);
    		}
    stringBuffer.append(TEXT_115);
    stringBuffer.append("is" + methodName + "Leaf");
    stringBuffer.append(TEXT_116);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_117);
    	}
    stringBuffer.append(TEXT_118);
    stringBuffer.append("is" + methodName + "Leaf");
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName(parameterClassFQName));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(childReference.getReferenceType() == GenNavigatorReferenceType.CHILDREN_LITERAL ? "false" : "true");
    stringBuffer.append(TEXT_122);
    }
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_186);
    if (generateGetForeignShortcuts) {
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_189);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_191);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_192);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_193);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_194);
    }
    stringBuffer.append(TEXT_195);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_196);
    return stringBuffer.toString();
  }
}
