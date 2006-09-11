package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import java.util.*;
import org.eclipse.emf.codegen.util.*;

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
  protected final String TEXT_9 = ") {" + NL + "\t\t\t";
  protected final String TEXT_10 = " view = (";
  protected final String TEXT_11 = ") parentElement;" + NL + "\t\t\tif (!";
  protected final String TEXT_12 = ".MODEL_ID.equals(";
  protected final String TEXT_13 = ".getModelID(view))) {" + NL + "\t\t\t\treturn EMPTY_ARRAY;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tint visualID = ";
  protected final String TEXT_14 = ".getVisualID(view);" + NL + "\t\t\tswitch (visualID) {";
  protected final String TEXT_15 = NL + "\t\t\tcase ";
  protected final String TEXT_16 = ".VISUAL_ID: {" + NL + "\t\t\t\t";
  protected final String TEXT_17 = " result = new ";
  protected final String TEXT_18 = "();";
  protected final String TEXT_19 = NL + "\t\t\t\t";
  protected final String TEXT_20 = " ";
  protected final String TEXT_21 = " = new ";
  protected final String TEXT_22 = "(\"";
  protected final String TEXT_23 = "\", \"";
  protected final String TEXT_24 = "\");" + NL + "\t\t\t\tresult.add(";
  protected final String TEXT_25 = ");";
  protected final String TEXT_26 = NL + "\t\t\t\t";
  protected final String TEXT_27 = ".addChildren(";
  protected final String TEXT_28 = NL + "\t\t\t\tresult.addAll(";
  protected final String TEXT_29 = "getChildByType(view.getChildren(), ";
  protected final String TEXT_30 = ".getType(";
  protected final String TEXT_31 = ".VISUAL_ID))";
  protected final String TEXT_32 = "getViewByType(view.eResource().getContents(), ";
  protected final String TEXT_33 = ".MODEL_ID)";
  protected final String TEXT_34 = "getViewByType(view.getDiagram().getChildren(), ";
  protected final String TEXT_35 = ".getType(";
  protected final String TEXT_36 = ".VISUAL_ID))";
  protected final String TEXT_37 = "getViewByType(view.getDiagram().getEdges(), ";
  protected final String TEXT_38 = ".getType(";
  protected final String TEXT_39 = ".VISUAL_ID))";
  protected final String TEXT_40 = ".EMPTY_LIST";
  protected final String TEXT_41 = "getViewByType(view.getSourceEdges(), ";
  protected final String TEXT_42 = ".getType(";
  protected final String TEXT_43 = ".VISUAL_ID))";
  protected final String TEXT_44 = "getViewByType(";
  protected final String TEXT_45 = ".singletonList(((";
  protected final String TEXT_46 = ") view).getTarget()), ";
  protected final String TEXT_47 = ".getType(";
  protected final String TEXT_48 = ".VISUAL_ID))";
  protected final String TEXT_49 = ".EMPTY_LIST";
  protected final String TEXT_50 = "getViewByType(view.getTargetEdges(), ";
  protected final String TEXT_51 = ".getType(";
  protected final String TEXT_52 = ".VISUAL_ID))";
  protected final String TEXT_53 = "getViewByType(";
  protected final String TEXT_54 = ".singletonList(((";
  protected final String TEXT_55 = ") view).getSource()), ";
  protected final String TEXT_56 = ".getType(";
  protected final String TEXT_57 = ".VISUAL_ID))";
  protected final String TEXT_58 = ".EMPTY_LIST";
  protected final String TEXT_59 = ".EMPTY_LIST";
  protected final String TEXT_60 = ");";
  protected final String TEXT_61 = NL + "\t\t\treturn result.toArray();" + NL + "\t\t\t}";
  protected final String TEXT_62 = NL + "\t\t\t}" + NL + "    \t} else if (parentElement instanceof ";
  protected final String TEXT_63 = ") {" + NL + "\t    \t";
  protected final String TEXT_64 = " file = (";
  protected final String TEXT_65 = ") parentElement;" + NL + "\t\t\t";
  protected final String TEXT_66 = " editingDomain = ";
  protected final String TEXT_67 = ".INSTANCE.createEditingDomain();" + NL + "\t\t\t";
  protected final String TEXT_68 = " resourceSet = editingDomain.getResourceSet();" + NL + "\t\t\t";
  protected final String TEXT_69 = " fileURI = ";
  protected final String TEXT_70 = ".createPlatformResourceURI(file.getFullPath().toString());" + NL + "\t\t\t";
  protected final String TEXT_71 = " resource = resourceSet.getResource(fileURI, true);" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_72 = " result = new ";
  protected final String TEXT_73 = "();";
  protected final String TEXT_74 = NL + "\t\t\t";
  protected final String TEXT_75 = " ";
  protected final String TEXT_76 = " = new ";
  protected final String TEXT_77 = "(\"";
  protected final String TEXT_78 = "\", \"";
  protected final String TEXT_79 = "\");" + NL + "\t\t\tresult.add(";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = NL + "\t\t\t";
  protected final String TEXT_82 = ".addChildren(";
  protected final String TEXT_83 = NL + "\t\t\tresult.addAll(";
  protected final String TEXT_84 = "getViewByType(resource.getContents(), ";
  protected final String TEXT_85 = ".MODEL_ID)";
  protected final String TEXT_86 = ".EMPTY_LIST";
  protected final String TEXT_87 = "getChildByType(resource.getContents(), ";
  protected final String TEXT_88 = ".getType(";
  protected final String TEXT_89 = ".VISUAL_ID))";
  protected final String TEXT_90 = ".EMPTY_LIST";
  protected final String TEXT_91 = ");";
  protected final String TEXT_92 = NL + "\t\t\treturn result.toArray();" + NL + "\t\t} else if (parentElement instanceof ";
  protected final String TEXT_93 = ") {" + NL + "\t\t\treturn ((";
  protected final String TEXT_94 = ") parentElement).getChildren();" + NL + "\t\t}" + NL + "\t\treturn EMPTY_ARRAY;" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public Object getParent(Object element) {" + NL + "\t\tif (element instanceof ";
  protected final String TEXT_95 = ") {" + NL + "\t\t\t";
  protected final String TEXT_96 = " view = (";
  protected final String TEXT_97 = ") element;" + NL + "\t\t\treturn view.eContainer() != null ? view.eContainer() : ";
  protected final String TEXT_98 = ".getFile(view.eResource());" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    public boolean hasChildren(Object element) {" + NL + "    \treturn element instanceof ";
  protected final String TEXT_99 = " || getChildren(element).length > 0;" + NL + "    }" + NL + "    " + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void init(";
  protected final String TEXT_100 = " aConfig) {" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void restoreState(";
  protected final String TEXT_101 = " aMemento) {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void saveState(";
  protected final String TEXT_102 = " aMemento) {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_103 = " getViewByType(";
  protected final String TEXT_104 = " childViews, String type) {" + NL + "\t\t";
  protected final String TEXT_105 = " result = new ";
  protected final String TEXT_106 = "();" + NL + "\t\tfor (";
  protected final String TEXT_107 = " it = childViews.iterator(); it.hasNext();) {" + NL + "\t\t\tObject next = it.next();" + NL + "\t\t\tif (false == next instanceof ";
  protected final String TEXT_108 = ") {" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_109 = " nextView = (";
  protected final String TEXT_110 = ") next;" + NL + "\t\t\tif (type.equals(nextView.getType())) {" + NL + "\t\t\t\tresult.add(nextView);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_111 = " getChildByType(";
  protected final String TEXT_112 = " childViews, String type) {" + NL + "\t\t";
  protected final String TEXT_113 = " result = new ";
  protected final String TEXT_114 = "();" + NL + "\t\t";
  protected final String TEXT_115 = " children = new ";
  protected final String TEXT_116 = "(childViews);" + NL + "\t\tfor (int i = 0; i < children.size(); i++) {" + NL + "\t\t\tif (false == children.get(i) instanceof ";
  protected final String TEXT_117 = ") {" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_118 = " nextChild = (";
  protected final String TEXT_119 = ") children.get(i);" + NL + "\t\t\tif (type.equals(nextChild.getType())) {" + NL + "\t\t\t\tresult.add(nextChild);" + NL + "\t\t\t} else if (!stopGettingChildren(nextChild, type)) {" + NL + "\t\t\t\tchildren.addAll(nextChild.getChildren());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean stopGettingChildren(";
  protected final String TEXT_120 = " child, String type) {" + NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_121 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenNavigator genNavigator = (GenNavigator) ((Object[]) argument)[0];
GenDiagram genDiagram = genNavigator.getEditorGen().getDiagram();
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
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_14);
    Collection commonBaseElements = new ArrayList(genDiagram.getAllContainers());
commonBaseElements.addAll(genDiagram.getLinks());
for (Iterator containers = commonBaseElements.iterator(); containers.hasNext();) {
	GenCommonBase nextCommonBase = (GenCommonBase) containers.next();
	Collection childReferences = genNavigator.getChildReferencesFor(nextCommonBase);
	if (childReferences.size() == 0) {
		continue;
	}
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(nextCommonBase.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_18);
    	Set createdGroups = new HashSet();
	for (Iterator it = childReferences.iterator(); it.hasNext();) {
		GenNavigatorChildReference nextReference = (GenNavigatorChildReference) it.next();
		if (nextReference.isInsideGroup()) {
			String groupNameKey = CodeGenUtil.validJavaIdentifier(nextReference.getGroupName());
			if (!createdGroups.contains(groupNameKey)) {
				createdGroups.add(groupNameKey);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName(genNavigator.getGroupWrapperQualifiedClassName()));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(groupNameKey);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName(genNavigator.getGroupWrapperQualifiedClassName()));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(nextReference.getGroupName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(nextReference.getGroupIcon());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(groupNameKey);
    stringBuffer.append(TEXT_25);
    			}
    stringBuffer.append(TEXT_26);
    stringBuffer.append(groupNameKey);
    stringBuffer.append(TEXT_27);
    
		} else {
    stringBuffer.append(TEXT_28);
    
		}
		
		if (nextReference.getReferenceType() == GenNavigatorReferenceType.CHILDREN_LITERAL) {
			
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_31);
    
		} else if (nextReference.getReferenceType() == GenNavigatorReferenceType.DEFAULT_LITERAL) {
			if (nextReference.getChild() instanceof GenDiagram) {
			
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_33);
    
			} else if (nextReference.getChild() instanceof GenTopLevelNode) {
			
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_36);
    
			} else if (nextReference.getChild() instanceof GenLink) {
			
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_39);
    
			} else {
			/* Any other "Default" child refrences are not supported */
			
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_40);
    
			}
		} else if (nextReference.getReferenceType() == GenNavigatorReferenceType.OUT_TAGET_LITERAL) {
			if (nextCommonBase instanceof GenNode) {
			
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_43);
    
			} else if (nextCommonBase instanceof GenLink) {
			
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_48);
    
			} else {
			/* Any other "OUT_TAGET_LITERAL" child refrences are not supported */
			
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_49);
    
			}
		} else if (nextReference.getReferenceType() == GenNavigatorReferenceType.IN_SOURCE_LITERAL) {
			if (nextCommonBase instanceof GenNode) {
			
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_52);
    
			} else if (nextCommonBase instanceof GenLink) {
			
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_57);
    
			} else {
			/* Any other "IN_SOURCE_LITERAL" child refrences are not supported */
			
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_58);
    
			}
		} else {
			/* Put processing of other types of the references here. */
			
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_59);
    
		}
    stringBuffer.append(TEXT_60);
    	}
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.domain.EditingDomain"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.ResourceSet"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_73);
    Set createdDiagramGroups = new HashSet();
for (Iterator it = genNavigator.getChildReferencesFor(null).iterator(); it.hasNext();) {
	GenNavigatorChildReference nextReference = (GenNavigatorChildReference) it.next();
	if (nextReference.isInsideGroup()) {
		String groupNameKey = CodeGenUtil.validJavaIdentifier(nextReference.getGroupName());
		if (!createdDiagramGroups.contains(groupNameKey)) {
			createdDiagramGroups.add(groupNameKey);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName(genNavigator.getGroupWrapperQualifiedClassName()));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(groupNameKey);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName(genNavigator.getGroupWrapperQualifiedClassName()));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(nextReference.getGroupName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(nextReference.getGroupIcon());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(groupNameKey);
    stringBuffer.append(TEXT_80);
    		}
    stringBuffer.append(TEXT_81);
    stringBuffer.append(groupNameKey);
    stringBuffer.append(TEXT_82);
    
	} else {
    stringBuffer.append(TEXT_83);
    
	}
	
	if (nextReference.getReferenceType() == GenNavigatorReferenceType.DEFAULT_LITERAL) {
		if (nextReference.getChild() instanceof GenDiagram) {
			
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_85);
    
		} else {
			/* Any other "Default" child refrences are not supported for resource */
			
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_86);
    
		}
	} else if (nextReference.getReferenceType() == GenNavigatorReferenceType.CHILDREN_LITERAL) {
		
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName(nextReference.getChild().getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_89);
    
	} else {
		/* Any other ReferenceTypes are not supported for the resource */
		
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_90);
    
	}
    stringBuffer.append(TEXT_91);
    }
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName(genNavigator.getGroupWrapperQualifiedClassName()));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName(genNavigator.getGroupWrapperQualifiedClassName()));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.workspace.util.WorkspaceSynchronizer"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonContentExtensionSite"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IMemento"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IMemento"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_120);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_121);
    return stringBuffer.toString();
  }
}
