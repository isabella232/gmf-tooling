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
  protected final String TEXT_15 = ") abstractNavigatorItem;" + NL + "    \t\t\tif (navigatorItem.isLeaf()) {" + NL + "    \t\t\t\treturn EMPTY_ARRAY;" + NL + "    \t\t\t}" + NL + "\t\t\t\tswitch (navigatorItem.getVisualID()) {";
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
  protected final String TEXT_30 = "(";
  protected final String TEXT_31 = "(";
  protected final String TEXT_32 = ") ";
  protected final String TEXT_33 = "navigatorItem.getView(), ";
  protected final String TEXT_34 = "));";
  protected final String TEXT_35 = NL + "\t\t\t\tif (!";
  protected final String TEXT_36 = ".isEmpty()) {";
  protected final String TEXT_37 = NL + "\t\t\t\tresult.add(";
  protected final String TEXT_38 = ");";
  protected final String TEXT_39 = NL + "\t\t\t\t}";
  protected final String TEXT_40 = NL + "\t\t\t\treturn result.toArray();" + NL + "\t\t\t\t}";
  protected final String TEXT_41 = NL + "\t\t\t\t}" + NL + "\t\t\t} else if (abstractNavigatorItem instanceof ";
  protected final String TEXT_42 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_43 = " group = (";
  protected final String TEXT_44 = ") parentElement;" + NL + "\t\t\t\treturn group.getChildren();" + NL + "\t\t\t}" + NL + "    \t} else if (parentElement instanceof ";
  protected final String TEXT_45 = ") {" + NL + "\t    \t";
  protected final String TEXT_46 = " file = (";
  protected final String TEXT_47 = ") parentElement;" + NL + "\t\t\t";
  protected final String TEXT_48 = " editingDomain = (";
  protected final String TEXT_49 = ") ";
  protected final String TEXT_50 = ".INSTANCE.createEditingDomain();" + NL + "\t\t\teditingDomain.setResourceToReadOnlyMap(new ";
  protected final String TEXT_51 = "() {" + NL + "\t\t\t\tpublic Object get(Object key) {" + NL + "\t\t\t\t\tif (!containsKey(key)) {" + NL + "\t\t\t\t\t\tput(key, Boolean.TRUE);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn super.get(key);" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t\t";
  protected final String TEXT_52 = " resourceSet = editingDomain.getResourceSet();" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_53 = " fileURI = ";
  protected final String TEXT_54 = ".createPlatformResourceURI(file.getFullPath().toString(), true);" + NL + "\t\t\t";
  protected final String TEXT_55 = " resource = resourceSet.getResource(fileURI, true);" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_56 = " result = new ";
  protected final String TEXT_57 = "();";
  protected final String TEXT_58 = NL + "\t\t\t";
  protected final String TEXT_59 = " ";
  protected final String TEXT_60 = " = new ";
  protected final String TEXT_61 = "(\"";
  protected final String TEXT_62 = "\", \"";
  protected final String TEXT_63 = "\", ";
  protected final String TEXT_64 = ".MODEL_ID, file);";
  protected final String TEXT_65 = NL + "\t\t\t";
  protected final String TEXT_66 = ".addChildren(";
  protected final String TEXT_67 = NL + "\t\t\tresult.addAll(";
  protected final String TEXT_68 = "createNavigatorItems(selectViewsByType(resource.getContents(), ";
  protected final String TEXT_69 = ".MODEL_ID";
  protected final String TEXT_70 = ".getType(";
  protected final String TEXT_71 = ".VISUAL_ID)";
  protected final String TEXT_72 = "), ";
  protected final String TEXT_73 = "));";
  protected final String TEXT_74 = NL + "\t\t\tif (!";
  protected final String TEXT_75 = ".isEmpty()) {";
  protected final String TEXT_76 = NL + "\t\t\tresult.add(";
  protected final String TEXT_77 = ");";
  protected final String TEXT_78 = NL + "\t\t\t}";
  protected final String TEXT_79 = NL + "\t\t\treturn result.toArray();" + NL + "\t\t}" + NL + "\t\treturn EMPTY_ARRAY;" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public Object getParent(Object element) {" + NL + "    \tif (element instanceof ";
  protected final String TEXT_80 = ") {" + NL + "    \t\t";
  protected final String TEXT_81 = " abstractNavigatorItem = (";
  protected final String TEXT_82 = ") element;" + NL + "\t\t\tif (!";
  protected final String TEXT_83 = ".MODEL_ID.equals(abstractNavigatorItem.getModelID())) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t\treturn abstractNavigatorItem.getParent();" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public boolean hasChildren(Object element) {" + NL + "    \treturn element instanceof ";
  protected final String TEXT_84 = " || getChildren(element).length > 0;" + NL + "    }" + NL + "    " + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void init(";
  protected final String TEXT_85 = " aConfig) {" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void restoreState(";
  protected final String TEXT_86 = " aMemento) {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void saveState(";
  protected final String TEXT_87 = " aMemento) {" + NL + "\t}" + NL;
  protected final String TEXT_88 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_89 = " ";
  protected final String TEXT_90 = "(";
  protected final String TEXT_91 = " ";
  protected final String TEXT_92 = ", ";
  protected final String TEXT_93 = " parent) {" + NL + "\t\t";
  protected final String TEXT_94 = " result = new ";
  protected final String TEXT_95 = "();";
  protected final String TEXT_96 = NL + "\t\t";
  protected final String TEXT_97 = " connectedViews = ";
  protected final String TEXT_98 = NL + "\t\tconnectedViews = ";
  protected final String TEXT_99 = "getLinksTargetByType";
  protected final String TEXT_100 = "getLinksSourceByType";
  protected final String TEXT_101 = "getOutgoingLinksByType";
  protected final String TEXT_102 = "getIncomingLinksByType";
  protected final String TEXT_103 = "getChildrenByType";
  protected final String TEXT_104 = "(";
  protected final String TEXT_105 = ".singleton(";
  protected final String TEXT_106 = ")";
  protected final String TEXT_107 = "connectedViews";
  protected final String TEXT_108 = ", ";
  protected final String TEXT_109 = ".getType(";
  protected final String TEXT_110 = ".VISUAL_ID));";
  protected final String TEXT_111 = NL + "\t\tcreateNavigatorItems(connectedViews, parent, result, ";
  protected final String TEXT_112 = "(";
  protected final String TEXT_113 = "));";
  protected final String TEXT_114 = NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean ";
  protected final String TEXT_115 = "(";
  protected final String TEXT_116 = " ";
  protected final String TEXT_117 = ") {" + NL + "\t\treturn ";
  protected final String TEXT_118 = ";" + NL + "\t}";
  protected final String TEXT_119 = NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_120 = " getLinksSourceByType(";
  protected final String TEXT_121 = " edges, String type) {" + NL + "\t\t";
  protected final String TEXT_122 = " result = new ";
  protected final String TEXT_123 = "();" + NL + "\t \tfor (";
  protected final String TEXT_124 = " it = edges.iterator(); it.hasNext();) {" + NL + "\t \t\t";
  protected final String TEXT_125 = " nextEdge = (";
  protected final String TEXT_126 = ") it.next();" + NL + "\t \t\t";
  protected final String TEXT_127 = " nextEdgeSource = nextEdge.getSource();" + NL + "\t \t\tif (type.equals(nextEdgeSource.getType())) {" + NL + "\t \t\t\tresult.add(nextEdgeSource);" + NL + "\t \t\t}" + NL + "\t \t}" + NL + "\t \treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_128 = " getLinksTargetByType(";
  protected final String TEXT_129 = " edges, String type) {" + NL + "\t\t";
  protected final String TEXT_130 = " result = new ";
  protected final String TEXT_131 = "();" + NL + "\t \tfor (";
  protected final String TEXT_132 = " it = edges.iterator(); it.hasNext();) {" + NL + "\t \t\t";
  protected final String TEXT_133 = " nextEdge = (";
  protected final String TEXT_134 = ") it.next();" + NL + "\t \t\t";
  protected final String TEXT_135 = " nextEdgeSource = nextEdge.getTarget();" + NL + "\t \t\tif (type.equals(nextEdgeSource.getType())) {" + NL + "\t \t\t\tresult.add(nextEdgeSource);" + NL + "\t \t\t}" + NL + "\t \t}" + NL + "\t \treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_136 = " getOutgoingLinksByType(";
  protected final String TEXT_137 = " nodes, String type) {" + NL + "\t\t";
  protected final String TEXT_138 = " result = new ";
  protected final String TEXT_139 = "();" + NL + "\t \tfor (";
  protected final String TEXT_140 = " it = nodes.iterator(); it.hasNext();) {" + NL + "\t \t\t";
  protected final String TEXT_141 = " nextNode = (";
  protected final String TEXT_142 = ") it.next();" + NL + "\t\t\tresult.addAll(selectViewsByType(nextNode.getSourceEdges(), type));" + NL + "\t \t}" + NL + "\t \treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_143 = " getIncomingLinksByType(";
  protected final String TEXT_144 = " nodes, String type) {" + NL + "\t\t";
  protected final String TEXT_145 = " result = new ";
  protected final String TEXT_146 = "();" + NL + "\t \tfor (";
  protected final String TEXT_147 = " it = nodes.iterator(); it.hasNext();) {" + NL + "\t \t\t";
  protected final String TEXT_148 = " nextNode = (";
  protected final String TEXT_149 = ") it.next();" + NL + "\t\t\tresult.addAll(selectViewsByType(nextNode.getTargetEdges(), type));" + NL + "\t \t}" + NL + "\t \treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private ";
  protected final String TEXT_150 = " getChildrenByType(";
  protected final String TEXT_151 = " nodes, String type) {" + NL + "\t\t";
  protected final String TEXT_152 = " result = new ";
  protected final String TEXT_153 = "();" + NL + "\t \tfor (";
  protected final String TEXT_154 = " it = nodes.iterator(); it.hasNext();) {" + NL + "\t \t\t";
  protected final String TEXT_155 = " nextNode = (";
  protected final String TEXT_156 = ") it.next();" + NL + "\t\t\tresult.addAll(selectViewsByType(nextNode.getChildren(), type));" + NL + "\t \t}" + NL + "\t \treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_157 = " selectViewsByType(";
  protected final String TEXT_158 = " views, String type) {" + NL + "\t\t";
  protected final String TEXT_159 = " result = new ";
  protected final String TEXT_160 = "();" + NL + "\t\tfor (";
  protected final String TEXT_161 = " it = views.iterator(); it.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_162 = " nextView = (";
  protected final String TEXT_163 = ") it.next();" + NL + "\t\t\tif (type.equals(nextView.getType())) {" + NL + "\t\t\t\tresult.add(nextView);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_164 = " createNavigatorItems(";
  protected final String TEXT_165 = " views, Object parent) {" + NL + "\t\t";
  protected final String TEXT_166 = " result = new ";
  protected final String TEXT_167 = "();" + NL + "\t\tfor (";
  protected final String TEXT_168 = " it = views.iterator(); it.hasNext();) {" + NL + "\t\t\tresult.add(new ";
  protected final String TEXT_169 = "((";
  protected final String TEXT_170 = ") it.next(), parent, false));" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createNavigatorItems(";
  protected final String TEXT_171 = " views, ";
  protected final String TEXT_172 = " parent, ";
  protected final String TEXT_173 = " result, boolean isLeafs) {" + NL + "\t\tfor (";
  protected final String TEXT_174 = " it = views.iterator(); it.hasNext();) {" + NL + "\t\t\tresult.add(new ";
  protected final String TEXT_175 = "((";
  protected final String TEXT_176 = ") it.next(), parent, isLeafs));" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_177 = NL;

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
    stringBuffer.append(TEXT_30);
    if (nextCommonBase instanceof GenLink) {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_34);
    	}
	
	for (Iterator it = createdGroups.keySet().iterator(); it.hasNext();) {
		String nextGroupKey = (String) it.next();
		GenNavigatorChildReference nextReference = (GenNavigatorChildReference) createdGroups.get(nextGroupKey);
		if (nextReference.isHideIfEmpty()) {
    stringBuffer.append(TEXT_35);
    stringBuffer.append(nextGroupKey);
    stringBuffer.append(TEXT_36);
    		}
    stringBuffer.append(TEXT_37);
    stringBuffer.append(nextGroupKey);
    stringBuffer.append(TEXT_38);
    		if (nextReference.isHideIfEmpty()) {
    stringBuffer.append(TEXT_39);
    		}
	}
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.ResourceSet"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_57);
    Map createdDiagramGroups = new HashMap();
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
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(nextReference.getGroupName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(nextReference.getGroupIcon());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_64);
    		}
    stringBuffer.append(TEXT_65);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_66);
    
	} else {
		parentVariable = "file";
    stringBuffer.append(TEXT_67);
    
	}
    stringBuffer.append(TEXT_68);
    
	if (nextReference.getChild() instanceof GenDiagram) {
		
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_69);
    
	} else {
		
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_71);
    
	}
    stringBuffer.append(TEXT_72);
    stringBuffer.append(parentVariable);
    stringBuffer.append(TEXT_73);
    }

for (Iterator it = createdDiagramGroups.keySet().iterator(); it.hasNext();) {
	String groupNameKey = (String) it.next();
	GenNavigatorChildReference nextReference = (GenNavigatorChildReference) createdDiagramGroups.get(groupNameKey);
	if (nextReference.isHideIfEmpty()) {
    stringBuffer.append(TEXT_74);
    stringBuffer.append(groupNameKey);
    stringBuffer.append(TEXT_75);
    	}
    stringBuffer.append(TEXT_76);
    stringBuffer.append(groupNameKey);
    stringBuffer.append(TEXT_77);
    	if (nextReference.isHideIfEmpty()) {
    stringBuffer.append(TEXT_78);
    	}
}

    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonContentExtensionSite"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IMemento"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IMemento"));
    stringBuffer.append(TEXT_87);
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
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append("get" + methodName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName(parameterClassFQName));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_95);
    	boolean connectedViewsDeclared = false;
	for (List<GenCommonBase> nextPath : paths) {
		for (int i = 0; i < nextPath.size() - 1; i++) {
			GenCommonBase currentPathSegment = nextPath.get(i);
			GenCommonBase nextPathSegment = nextPath.get(i + 1);
			if (!connectedViewsDeclared) {
				connectedViewsDeclared = true;
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_97);
    
			}else {
    stringBuffer.append(TEXT_98);
    
			}
			if (currentPathSegment instanceof GenLink) {
				if (childReference.getReferenceType() == GenNavigatorReferenceType.OUT_TAGET_LITERAL) {
					
    stringBuffer.append(TEXT_99);
    
				} else { /*childReference.getReferenceType() == GenNavigatorReferenceType.IN_SOURCE_LITERAL*/
					
    stringBuffer.append(TEXT_100);
    
				}
			} else {
				if (childReference.getReferenceType() == GenNavigatorReferenceType.OUT_TAGET_LITERAL) {
					
    stringBuffer.append(TEXT_101);
    
				} else if (childReference.getReferenceType() == GenNavigatorReferenceType.IN_SOURCE_LITERAL) {
					
    stringBuffer.append(TEXT_102);
    
				} else { /*childReference.getReferenceType() == GenNavigatorReferenceType.CHILDREN_LITERAL*/
					
    stringBuffer.append(TEXT_103);
    
				}
			}
    stringBuffer.append(TEXT_104);
    
			if (i == 0) {
				
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_106);
    
			} else {
				
    stringBuffer.append(TEXT_107);
    
			}
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName(nextPathSegment.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_110);
    		}
    stringBuffer.append(TEXT_111);
    stringBuffer.append("is" + methodName + "Leaf");
    stringBuffer.append(TEXT_112);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_113);
    	}
    stringBuffer.append(TEXT_114);
    stringBuffer.append("is" + methodName + "Leaf");
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName(parameterClassFQName));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(parameterName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(childReference.getReferenceType() == GenNavigatorReferenceType.CHILDREN_LITERAL ? "false" : "true");
    stringBuffer.append(TEXT_118);
    }
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_158);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_159);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_165);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_168);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName(genNavigator.getAbstractNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_173);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_176);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_177);
    return stringBuffer.toString();
  }
}
