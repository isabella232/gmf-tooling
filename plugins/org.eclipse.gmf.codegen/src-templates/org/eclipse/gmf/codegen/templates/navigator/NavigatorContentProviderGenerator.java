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
  protected final String TEXT_8 = " viewer, Object oldInput, Object newInput) {" + NL + "    }" + NL + "    " + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Object[] getElements(Object inputElement) {" + NL + "\t\treturn getChildren(inputElement);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public Object[] getChildren(Object parentElement) {" + NL + "    \tif (parentElement instanceof ";
  protected final String TEXT_9 = ") {" + NL + "    \t\t";
  protected final String TEXT_10 = " abstractNavigatorItem = (";
  protected final String TEXT_11 = ") parentElement;" + NL + "\t\t\tif (!";
  protected final String TEXT_12 = ".MODEL_ID.equals(abstractNavigatorItem.getModelID())) {" + NL + "\t\t\t\treturn EMPTY_ARRAY;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif (abstractNavigatorItem instanceof ";
  protected final String TEXT_13 = ") {" + NL + "    \t\t\t";
  protected final String TEXT_14 = " navigatorItem = (";
  protected final String TEXT_15 = ") abstractNavigatorItem;" + NL + "\t\t\t\tswitch (navigatorItem.getVisualID()) {";
  protected final String TEXT_16 = NL + "\t\t\t\tcase ";
  protected final String TEXT_17 = ".VISUAL_ID: {" + NL + "\t\t\t\t\t";
  protected final String TEXT_18 = " result = new ";
  protected final String TEXT_19 = "();";
  protected final String TEXT_20 = NL + "\t\t\t\t\t";
  protected final String TEXT_21 = " ";
  protected final String TEXT_22 = " = new ";
  protected final String TEXT_23 = "(\"";
  protected final String TEXT_24 = "\", \"";
  protected final String TEXT_25 = "\", ";
  protected final String TEXT_26 = ".MODEL_ID, navigatorItem);";
  protected final String TEXT_27 = NL + "\t\t\t\t\t";
  protected final String TEXT_28 = ".addChildren(";
  protected final String TEXT_29 = NL + "\t\t\t\t\tresult.addAll(";
  protected final String TEXT_30 = "getViewByType(navigatorItem.getView().eResource().getContents(), ";
  protected final String TEXT_31 = ".MODEL_ID, ";
  protected final String TEXT_32 = ")";
  protected final String TEXT_33 = "getViewByType(navigatorItem.getView().getDiagram().getChildren(), ";
  protected final String TEXT_34 = ".getType(";
  protected final String TEXT_35 = ".VISUAL_ID), ";
  protected final String TEXT_36 = ")";
  protected final String TEXT_37 = "getViewByType(navigatorItem.getView().getDiagram().getEdges(), ";
  protected final String TEXT_38 = ".getType(";
  protected final String TEXT_39 = ".VISUAL_ID), ";
  protected final String TEXT_40 = ")";
  protected final String TEXT_41 = ".EMPTY_LIST";
  protected final String TEXT_42 = "(";
  protected final String TEXT_43 = "(";
  protected final String TEXT_44 = ") ";
  protected final String TEXT_45 = "navigatorItem.getView(), ";
  protected final String TEXT_46 = ")";
  protected final String TEXT_47 = ".EMPTY_LIST";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = NL + "\t\t\t\tif (!";
  protected final String TEXT_50 = ".isEmpty()) {";
  protected final String TEXT_51 = NL + "\t\t\t\tresult.add(";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\t\t\t\t}";
  protected final String TEXT_54 = NL + "\t\t\t\treturn result.toArray();" + NL + "\t\t\t\t}";
  protected final String TEXT_55 = NL + "\t\t\t\t}" + NL + "\t\t\t} else if (abstractNavigatorItem instanceof ";
  protected final String TEXT_56 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_57 = " group = (";
  protected final String TEXT_58 = ") parentElement;" + NL + "\t\t\t\treturn group.getChildren();" + NL + "\t\t\t}" + NL + "    \t} else if (parentElement instanceof ";
  protected final String TEXT_59 = ") {" + NL + "\t    \t";
  protected final String TEXT_60 = " file = (";
  protected final String TEXT_61 = ") parentElement;" + NL + "\t\t\t";
  protected final String TEXT_62 = " editingDomain = (";
  protected final String TEXT_63 = ") ";
  protected final String TEXT_64 = ".INSTANCE.createEditingDomain();" + NL + "\t\t\teditingDomain.setResourceToReadOnlyMap(new ";
  protected final String TEXT_65 = "() {" + NL + "\t\t\t\tpublic Object get(Object key) {" + NL + "\t\t\t\t\tif (!containsKey(key)) {" + NL + "\t\t\t\t\t\tput(key, Boolean.TRUE);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn super.get(key);" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t\t";
  protected final String TEXT_66 = " resourceSet = editingDomain.getResourceSet();" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_67 = " fileURI = ";
  protected final String TEXT_68 = ".createPlatformResourceURI(file.getFullPath().toString(), true);" + NL + "\t\t\t";
  protected final String TEXT_69 = " resource = resourceSet.getResource(fileURI, true);" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_70 = " result = new ";
  protected final String TEXT_71 = "();";
  protected final String TEXT_72 = NL + "\t\t\t";
  protected final String TEXT_73 = " ";
  protected final String TEXT_74 = " = new ";
  protected final String TEXT_75 = "(\"";
  protected final String TEXT_76 = "\", \"";
  protected final String TEXT_77 = "\", ";
  protected final String TEXT_78 = ".MODEL_ID, file);";
  protected final String TEXT_79 = NL + "\t\t\t";
  protected final String TEXT_80 = ".addChildren(";
  protected final String TEXT_81 = NL + "\t\t\tresult.addAll(";
  protected final String TEXT_82 = "getViewByType(resource.getContents(), ";
  protected final String TEXT_83 = ".MODEL_ID, ";
  protected final String TEXT_84 = ")";
  protected final String TEXT_85 = ".EMPTY_LIST";
  protected final String TEXT_86 = ".EMPTY_LIST";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "\t\t\tif (!";
  protected final String TEXT_89 = ".isEmpty()) {";
  protected final String TEXT_90 = NL + "\t\t\tresult.add(";
  protected final String TEXT_91 = ");";
  protected final String TEXT_92 = NL + "\t\t\t}";
  protected final String TEXT_93 = NL + "\t\t\treturn result.toArray();" + NL + "\t\t}" + NL + "\t\treturn EMPTY_ARRAY;" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public Object getParent(Object element) {" + NL + "    \tif (element instanceof ";
  protected final String TEXT_94 = ") {" + NL + "    \t\t";
  protected final String TEXT_95 = " abstractNavigatorItem = (";
  protected final String TEXT_96 = ") element;" + NL + "\t\t\tif (!";
  protected final String TEXT_97 = ".MODEL_ID.equals(abstractNavigatorItem.getModelID())) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\treturn abstractNavigatorItem.getParent();" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public boolean hasChildren(Object element) {" + NL + "    \treturn element instanceof ";
  protected final String TEXT_98 = " || getChildren(element).length > 0;" + NL + "    }" + NL + "    " + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void init(";
  protected final String TEXT_99 = " aConfig) {" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void restoreState(";
  protected final String TEXT_100 = " aMemento) {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void saveState(";
  protected final String TEXT_101 = " aMemento) {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_102 = " getViewByType(";
  protected final String TEXT_103 = " childViews, String type, Object parent) {" + NL + "\t\t";
  protected final String TEXT_104 = " result = new ";
  protected final String TEXT_105 = "();" + NL + "\t\tfor (";
  protected final String TEXT_106 = " it = childViews.iterator(); it.hasNext();) {" + NL + "\t\t\tObject next = it.next();" + NL + "\t\t\tif (false == next instanceof ";
  protected final String TEXT_107 = ") {" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_108 = " nextView = (";
  protected final String TEXT_109 = ") next;" + NL + "\t\t\tif (type.equals(nextView.getType())) {" + NL + "\t\t\t\tresult.add(new ";
  protected final String TEXT_110 = "(nextView, parent));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_111 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_112 = " ";
  protected final String TEXT_113 = "(";
  protected final String TEXT_114 = " ";
  protected final String TEXT_115 = ", ";
  protected final String TEXT_116 = " parent) {" + NL + "\t\t";
  protected final String TEXT_117 = " result = new ";
  protected final String TEXT_118 = "();";
  protected final String TEXT_119 = NL + "\t\t";
  protected final String TEXT_120 = " connectedViews = ";
  protected final String TEXT_121 = NL + "\t\tconnectedViews = ";
  protected final String TEXT_122 = "getLinksTargetByType";
  protected final String TEXT_123 = "getLinksSourceByType";
  protected final String TEXT_124 = "getOutgoingLinksByType";
  protected final String TEXT_125 = "getIncomingLinksByType";
  protected final String TEXT_126 = "getChildrenByType";
  protected final String TEXT_127 = "(";
  protected final String TEXT_128 = ".singleton(";
  protected final String TEXT_129 = ")";
  protected final String TEXT_130 = "connectedViews";
  protected final String TEXT_131 = ", ";
  protected final String TEXT_132 = ".getType(";
  protected final String TEXT_133 = ".VISUAL_ID));";
  protected final String TEXT_134 = NL + "\t\tcreateNavigatorItems(connectedViews, parent, result);";
  protected final String TEXT_135 = NL + "\t\treturn result;" + NL + "\t}";
  protected final String TEXT_136 = NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_137 = " getLinksSourceByType(";
  protected final String TEXT_138 = " edges, String type) {" + NL + "\t\t";
  protected final String TEXT_139 = " result = new ";
  protected final String TEXT_140 = "();" + NL + "\t \tfor (";
  protected final String TEXT_141 = " it = edges.iterator(); it.hasNext();) {" + NL + "\t \t\t";
  protected final String TEXT_142 = " nextEdge = (";
  protected final String TEXT_143 = ") it.next();" + NL + "\t \t\t";
  protected final String TEXT_144 = " nextEdgeSource = nextEdge.getSource();" + NL + "\t \t\tif (type.equals(nextEdgeSource.getType())) {" + NL + "\t \t\t\tresult.add(nextEdgeSource);" + NL + "\t \t\t}" + NL + "\t \t}" + NL + "\t \treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_145 = " getLinksTargetByType(";
  protected final String TEXT_146 = " edges, String type) {" + NL + "\t\t";
  protected final String TEXT_147 = " result = new ";
  protected final String TEXT_148 = "();" + NL + "\t \tfor (";
  protected final String TEXT_149 = " it = edges.iterator(); it.hasNext();) {" + NL + "\t \t\t";
  protected final String TEXT_150 = " nextEdge = (";
  protected final String TEXT_151 = ") it.next();" + NL + "\t \t\t";
  protected final String TEXT_152 = " nextEdgeSource = nextEdge.getTarget();" + NL + "\t \t\tif (type.equals(nextEdgeSource.getType())) {" + NL + "\t \t\t\tresult.add(nextEdgeSource);" + NL + "\t \t\t}" + NL + "\t \t}" + NL + "\t \treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_153 = " getOutgoingLinksByType(";
  protected final String TEXT_154 = " nodes, String type) {" + NL + "\t\t";
  protected final String TEXT_155 = " result = new ";
  protected final String TEXT_156 = "();" + NL + "\t \tfor (";
  protected final String TEXT_157 = " it = nodes.iterator(); it.hasNext();) {" + NL + "\t \t\t";
  protected final String TEXT_158 = " nextNode = (";
  protected final String TEXT_159 = ") it.next();" + NL + "\t\t\tresult.addAll(selectViewsByType(nextNode.getSourceEdges(), type));" + NL + "\t \t}" + NL + "\t \treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_160 = " getIncomingLinksByType(";
  protected final String TEXT_161 = " nodes, String type) {" + NL + "\t\t";
  protected final String TEXT_162 = " result = new ";
  protected final String TEXT_163 = "();" + NL + "\t \tfor (";
  protected final String TEXT_164 = " it = nodes.iterator(); it.hasNext();) {" + NL + "\t \t\t";
  protected final String TEXT_165 = " nextNode = (";
  protected final String TEXT_166 = ") it.next();" + NL + "\t\t\tresult.addAll(selectViewsByType(nextNode.getTargetEdges(), type));" + NL + "\t \t}" + NL + "\t \treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_167 = " getChildrenByType(";
  protected final String TEXT_168 = " nodes, String type) {" + NL + "\t\t";
  protected final String TEXT_169 = " result = new ";
  protected final String TEXT_170 = "();" + NL + "\t \tfor (";
  protected final String TEXT_171 = " it = nodes.iterator(); it.hasNext();) {" + NL + "\t \t\t";
  protected final String TEXT_172 = " nextNode = (";
  protected final String TEXT_173 = ") it.next();" + NL + "\t\t\tresult.addAll(selectViewsByType(nextNode.getChildren(), type));" + NL + "\t \t}" + NL + "\t \treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_174 = " selectViewsByType(";
  protected final String TEXT_175 = " views, String type) {" + NL + "\t\t";
  protected final String TEXT_176 = " result = new ";
  protected final String TEXT_177 = "();" + NL + "\t\tfor (";
  protected final String TEXT_178 = " it = views.iterator(); it.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_179 = " nextView = (";
  protected final String TEXT_180 = ") it.next();" + NL + "\t\t\tif (type.equals(nextView.getType())) {" + NL + "\t\t\t\tresult.add(nextView);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createNavigatorItems(";
  protected final String TEXT_181 = " views, ";
  protected final String TEXT_182 = " parent, ";
  protected final String TEXT_183 = " result) {" + NL + "\t\tfor (";
  protected final String TEXT_184 = " it = views.iterator(); it.hasNext();) {" + NL + "\t\t\tresult.add(new ";
  protected final String TEXT_185 = "((";
  protected final String TEXT_186 = ") it.next(), parent));" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_187 = NL;

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
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_15);
    Map getter2ReferenceMap = new HashMap();
for (Iterator containers = commonBaseElements.iterator(); containers.hasNext();) {
	GenCommonBase nextCommonBase = (GenCommonBase) containers.next();
	Collection childReferences = genNavigator.getChildReferencesFrom(nextCommonBase);
	if (childReferences.size() == 0) {
		continue;
	}
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName(nextCommonBase.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_19);
    	Map createdGroups = new HashMap();
	for (Iterator it = childReferences.iterator(); it.hasNext();) {
		GenNavigatorChildReference nextReference = (GenNavigatorChildReference) it.next();
		String parentVariable;
		if (nextReference.isInsideGroup()) {
			parentVariable = CodeGenUtil.validJavaIdentifier(nextReference.getGroupName());
			if (!createdGroups.containsKey(parentVariable)) {
				createdGroups.put(parentVariable, nextReference);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(nextReference.getGroupName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(nextReference.getGroupIcon());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_26);
    			}
    stringBuffer.append(TEXT_27);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_28);
    
		} else {
			parentVariable = "navigatorItem";
    stringBuffer.append(TEXT_29);
    
		}
		
		if (nextReference.getReferenceType() == GenNavigatorReferenceType.DEFAULT_LITERAL) {
			if (nextReference.getChild() instanceof GenDiagram) {
			
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_32);
    
			} else if (nextReference.getChild() instanceof GenTopLevelNode) {
			
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_36);
    
			} else if (nextReference.getChild() instanceof GenLink) {
			
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_40);
    
			} else {
			/* Any other "Default" child refrences are not supported */
			
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_41);
    
			}
		} else if (nextReference.getReferenceType() == GenNavigatorReferenceType.CHILDREN_LITERAL || nextReference.getReferenceType() == GenNavigatorReferenceType.OUT_TAGET_LITERAL || nextReference.getReferenceType() == GenNavigatorReferenceType.IN_SOURCE_LITERAL) {
			String getterNameBase = "get" + nextCommonBase.getUniqueIdentifier() + "To" + nextReference.getChild().getUniqueIdentifier();
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
			
    stringBuffer.append(getterName);
    stringBuffer.append(TEXT_42);
    if (nextCommonBase instanceof GenLink) {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_46);
    
		} else {
			/* Put processing of other types of the references here. */
			
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_47);
    
		}
    stringBuffer.append(TEXT_48);
    	}
	
	for (Iterator it = createdGroups.keySet().iterator(); it.hasNext();) {
		String nextGroupKey = (String) it.next();
		GenNavigatorChildReference nextReference = (GenNavigatorChildReference) createdGroups.get(nextGroupKey);
		if (nextReference.isHideIfEmpty()) {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(nextGroupKey);
    stringBuffer.append(TEXT_50);
    		}
    stringBuffer.append(TEXT_51);
    stringBuffer.append(nextGroupKey);
    stringBuffer.append(TEXT_52);
    		if (nextReference.isHideIfEmpty()) {
    stringBuffer.append(TEXT_53);
    		}
	}
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.ResourceSet"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_71);
    Map createdDiagramGroups = new HashMap();
for (Iterator it = genNavigator.getChildReferencesFrom(null).iterator(); it.hasNext();) {
	GenNavigatorChildReference nextReference = (GenNavigatorChildReference) it.next();
	String parentVariable;
	if (nextReference.isInsideGroup()) {
		parentVariable = CodeGenUtil.validJavaIdentifier(nextReference.getGroupName());
		if (!createdDiagramGroups.containsKey(parentVariable)) {
			createdDiagramGroups.put(parentVariable, nextReference);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(nextReference.getGroupName());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(nextReference.getGroupIcon());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_78);
    		}
    stringBuffer.append(TEXT_79);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_80);
    
	} else {
		parentVariable = "file";
    stringBuffer.append(TEXT_81);
    
	}
	if (nextReference.getReferenceType() == GenNavigatorReferenceType.DEFAULT_LITERAL) {
		if (nextReference.getChild() instanceof GenDiagram) {
			
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_84);
    
		} else {
			/* Any other "Default" child refrences are not supported for resource */
			
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_85);
    
		}
	} else {
		/* Any other ReferenceTypes are not supported for the resource */
		
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_86);
    
	}
    stringBuffer.append(TEXT_87);
    }

for (Iterator it = createdDiagramGroups.keySet().iterator(); it.hasNext();) {
	String groupNameKey = (String) it.next();
	GenNavigatorChildReference nextReference = (GenNavigatorChildReference) createdDiagramGroups.get(groupNameKey);
	if (nextReference.isHideIfEmpty()) {
    stringBuffer.append(TEXT_88);
    stringBuffer.append(groupNameKey);
    stringBuffer.append(TEXT_89);
    	}
    stringBuffer.append(TEXT_90);
    stringBuffer.append(groupNameKey);
    stringBuffer.append(TEXT_91);
    	if (nextReference.isHideIfEmpty()) {
    stringBuffer.append(TEXT_92);
    	}
}

    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonContentExtensionSite"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IMemento"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IMemento"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_110);
    GenModelGraphAnalyzer graphAnalyzer = new GenModelGraphAnalyzer(genDiagram);
for (Iterator it = getter2ReferenceMap.entrySet().iterator(); it.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) it.next();
	GenNavigatorChildReference childReference = (GenNavigatorChildReference) nextEntry.getValue();
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
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append((String) nextEntry.getKey());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName(parameterClassFQName));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_118);
    	boolean connectedViewsDeclared = false;
	for (List<GenCommonBase> nextPath : paths) {
		for (int i = 0; i < nextPath.size() - 1; i++) {
			GenCommonBase currentPathSegment = nextPath.get(i);
			GenCommonBase nextPathSegment = nextPath.get(i + 1);
			if (!connectedViewsDeclared) {
				connectedViewsDeclared = true;
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_120);
    
			}else {
    stringBuffer.append(TEXT_121);
    
			}
			if (currentPathSegment instanceof GenLink) {
				if (childReference.getReferenceType() == GenNavigatorReferenceType.OUT_TAGET_LITERAL) {
					
    stringBuffer.append(TEXT_122);
    
				} else { /*childReference.getReferenceType() == GenNavigatorReferenceType.IN_SOURCE_LITERAL*/
					
    stringBuffer.append(TEXT_123);
    
				}
			} else {
				if (childReference.getReferenceType() == GenNavigatorReferenceType.OUT_TAGET_LITERAL) {
					
    stringBuffer.append(TEXT_124);
    
				} else if (childReference.getReferenceType() == GenNavigatorReferenceType.IN_SOURCE_LITERAL) {
					
    stringBuffer.append(TEXT_125);
    
				} else { /*childReference.getReferenceType() == GenNavigatorReferenceType.CHILDREN_LITERAL*/
					
    stringBuffer.append(TEXT_126);
    
				}
			}
    stringBuffer.append(TEXT_127);
    
			if (i == 0) {
				
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_129);
    
			} else {
				
    stringBuffer.append(TEXT_130);
    
			}
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName(nextPathSegment.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_133);
    		}
    stringBuffer.append(TEXT_134);
    	}
    stringBuffer.append(TEXT_135);
    }
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_177);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_184);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_185);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_186);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_187);
    return stringBuffer.toString();
  }
}
