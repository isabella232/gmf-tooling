package org.eclipse.gmf.codegen.templates.lite.navigator;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.ecore.*;

public class NavigatorLabelProviderGenerator
{
  protected static String nl;
  public static synchronized NavigatorLabelProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NavigatorLabelProviderGenerator result = new NavigatorLabelProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = "((";
  protected final String TEXT_6 = ")";
  protected final String TEXT_7 = "((";
  protected final String TEXT_8 = ")";
  protected final String TEXT_9 = ")";
  protected final String TEXT_10 = ".eGet(";
  protected final String TEXT_11 = ".eINSTANCE.get";
  protected final String TEXT_12 = "())";
  protected final String TEXT_13 = ")";
  protected final String TEXT_14 = "((";
  protected final String TEXT_15 = ")";
  protected final String TEXT_16 = ")";
  protected final String TEXT_17 = ".";
  protected final String TEXT_18 = "()";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_21 = " extends ";
  protected final String TEXT_22 = " implements ";
  protected final String TEXT_23 = ", ";
  protected final String TEXT_24 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic {" + NL + "\t\t";
  protected final String TEXT_25 = ".getInstance().getImageRegistry().put(\"";
  protected final String TEXT_26 = "\", ";
  protected final String TEXT_27 = ".getMissingImageDescriptor());" + NL + "\t\t";
  protected final String TEXT_28 = ".getInstance().getImageRegistry().put(\"";
  protected final String TEXT_29 = "\", ";
  protected final String TEXT_30 = ".getMissingImageDescriptor());" + NL + "\t\t";
  protected final String TEXT_31 = ".getInstance().getImageRegistry().put(\"";
  protected final String TEXT_32 = "\", ";
  protected final String TEXT_33 = ".getMissingImageDescriptor());" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void updateLabel(";
  protected final String TEXT_34 = " label, ";
  protected final String TEXT_35 = " elementPath) {" + NL + "\t\tObject element = elementPath.getLastSegment();" + NL + "\t\tif (element instanceof ";
  protected final String TEXT_36 = " && !isOwnView(((";
  protected final String TEXT_37 = ") element).getView())) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tlabel.setText(getText(element));" + NL + "\t\tlabel.setImage(getImage(element));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_38 = " getImage(Object element) {" + NL + "\t\tif (element instanceof ";
  protected final String TEXT_39 = ") {" + NL + "\t\t\t";
  protected final String TEXT_40 = " group = (";
  protected final String TEXT_41 = ") element;" + NL + "\t\t\treturn ";
  protected final String TEXT_42 = ".getInstance().getBundledImage(group.getIcon());" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif (element instanceof ";
  protected final String TEXT_43 = ") {" + NL + "\t\t\t";
  protected final String TEXT_44 = " navigatorItem = (";
  protected final String TEXT_45 = ") element;" + NL + "    \t\tif (!isOwnView(navigatorItem.getView())) {" + NL + "    \t\t\treturn super.getImage(element);" + NL + "    \t\t}" + NL + "    \t\treturn getImage(navigatorItem.getView());" + NL + "\t\t}" + NL;
  protected final String TEXT_46 = NL + "\t\t// Due to plugin.xml content will be called only for \"own\" views" + NL + "\t\tif (element instanceof ";
  protected final String TEXT_47 = ") {" + NL + "\t\t\t";
  protected final String TEXT_48 = " view = (";
  protected final String TEXT_49 = ") ((";
  protected final String TEXT_50 = ") element).getAdapter(";
  protected final String TEXT_51 = ".class);" + NL + "\t\t\tif (view != null && isOwnView(view)) {" + NL + "\t\t\t\treturn getImage(view);" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_52 = NL + "\t\treturn super.getImage(element);" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_53 = " getImage(";
  protected final String TEXT_54 = " view) {" + NL + "\t\tswitch (";
  protected final String TEXT_55 = ".getVisualID(view)) {";
  protected final String TEXT_56 = NL + "\t\tcase ";
  protected final String TEXT_57 = ".VISUAL_ID: {";
  protected final String TEXT_58 = NL + "\t\t\t";
  protected final String TEXT_59 = " target = ((";
  protected final String TEXT_60 = ") view).getTarget();" + NL + "\t\t\t";
  protected final String TEXT_61 = " underlyingElement = target == null ? null : target.getElement();";
  protected final String TEXT_62 = NL + "\t\t\treturn getImage(\"";
  protected final String TEXT_63 = "\", ";
  protected final String TEXT_64 = ");" + NL + "\t\t}";
  protected final String TEXT_65 = NL + "\t\tdefault:" + NL + "\t\t\treturn getImage(\"";
  protected final String TEXT_66 = "\", null);" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_67 = " getImage(String key, ";
  protected final String TEXT_68 = " object) {" + NL + "\t\t";
  protected final String TEXT_69 = " imageRegistry = ";
  protected final String TEXT_70 = ".getInstance().getImageRegistry();" + NL + "\t\t";
  protected final String TEXT_71 = " image = imageRegistry.get(key);" + NL + "\t\tif (image == null && object != null) {" + NL + "\t\t\timage = ";
  protected final String TEXT_72 = ".getInstance().getItemImage(object);" + NL + "\t\t\timageRegistry.put(key, image);" + NL + "\t\t}" + NL + "\t\tif (image == null) {" + NL + "\t\t\timage = imageRegistry.get(\"";
  protected final String TEXT_73 = "\");" + NL + "\t\t\timageRegistry.put(key, image);" + NL + "\t\t}" + NL + "\t\treturn image;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getText(Object element) {" + NL + "\t\tif (element instanceof ";
  protected final String TEXT_74 = ") {" + NL + "\t\t\t";
  protected final String TEXT_75 = " group = (";
  protected final String TEXT_76 = ") element;" + NL + "\t\t\treturn group.getGroupName();" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tif (element instanceof ";
  protected final String TEXT_77 = ") {" + NL + "\t\t\t";
  protected final String TEXT_78 = " navigatorItem = (";
  protected final String TEXT_79 = ") element;" + NL + "    \t\tif (!isOwnView(navigatorItem.getView())) {" + NL + "    \t\t\treturn null;" + NL + "    \t\t}" + NL + "    \t\treturn getText(navigatorItem.getView());" + NL + "\t\t}" + NL + "\t";
  protected final String TEXT_80 = NL + "\t\t// Due to plugin.xml content will be called only for \"own\" views" + NL + "\t\tif (element instanceof ";
  protected final String TEXT_81 = ") {" + NL + "\t\t\t";
  protected final String TEXT_82 = " view = (";
  protected final String TEXT_83 = ") ((";
  protected final String TEXT_84 = ") element).getAdapter(";
  protected final String TEXT_85 = ".class);" + NL + "\t\t\tif (view != null && isOwnView(view)) {" + NL + "\t\t\t\treturn getText(view);" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_86 = NL + "\t\treturn super.getText(element);" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getText(";
  protected final String TEXT_87 = " view) {" + NL + "\t\tif (view.getElement().eIsProxy()) {" + NL + "\t\t\treturn getUnresolvedDomainElementProxyText(view);" + NL + "\t\t}" + NL + "\t\tswitch (";
  protected final String TEXT_88 = ".getVisualID(view)) {";
  protected final String TEXT_89 = NL + "\t\tcase ";
  protected final String TEXT_90 = ".VISUAL_ID:" + NL + "\t\t\treturn get";
  protected final String TEXT_91 = "Text(view);";
  protected final String TEXT_92 = NL + "\t\tdefault:" + NL + "\t\t\treturn getUnknownElementText(view);" + NL + "\t\t}" + NL + "\t}" + NL;
  protected final String TEXT_93 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String get";
  protected final String TEXT_94 = "Text(";
  protected final String TEXT_95 = " view) {";
  protected final String TEXT_96 = NL + "\t\t";
  protected final String TEXT_97 = " domainModelElement = view.getElement();" + NL + "\t\tif (domainModelElement == null) {" + NL + "\t\t\treturn \"\";" + NL + "\t\t}" + NL + "\t\tString result = ";
  protected final String TEXT_98 = ".LABEL_DISPLAYER.getDisplayText(domainModelElement);" + NL + "\t\tif (result == null) {" + NL + "\t\t\treturn \"\";" + NL + "\t\t}" + NL + "\t\treturn result;";
  protected final String TEXT_99 = NL + "\t\treturn \"\";";
  protected final String TEXT_100 = NL + "\t\treturn \"";
  protected final String TEXT_101 = "\";";
  protected final String TEXT_102 = NL + "\t\t";
  protected final String TEXT_103 = " domainModelElement = view.getElement();" + NL + "\t\tif (domainModelElement != null) {" + NL + "\t\t\treturn ";
  protected final String TEXT_104 = "String.valueOf(";
  protected final String TEXT_105 = "(String) ";
  protected final String TEXT_106 = ")";
  protected final String TEXT_107 = ";" + NL + "\t\t} else {" + NL + "\t\t\t";
  protected final String TEXT_108 = ".getInstance().logError(\"No domain element for view with visualID = \" + ";
  protected final String TEXT_109 = ");" + NL + "\t\t\treturn \"\";" + NL + "\t\t}";
  protected final String TEXT_110 = NL + "\t\treturn \"\";";
  protected final String TEXT_111 = NL + "\t}";
  protected final String TEXT_112 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String getUnknownElementText(";
  protected final String TEXT_113 = " view) {" + NL + "\t\treturn \"<UnknownElement Visual_ID = \" + view.getType() + \">\";" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String getUnresolvedDomainElementProxyText(";
  protected final String TEXT_114 = " view) {" + NL + "\t\treturn \"<Unresolved domain element Visual_ID = \" + view.getType() + \">\";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void init(";
  protected final String TEXT_115 = " aConfig) {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void restoreState(";
  protected final String TEXT_116 = " aMemento) {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void saveState(";
  protected final String TEXT_117 = " aMemento) {" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getDescription(Object anElement) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isOwnView(";
  protected final String TEXT_118 = " view) {" + NL + "\t\treturn ";
  protected final String TEXT_119 = ".MODEL_ID.equals(";
  protected final String TEXT_120 = ".getModelID(view));" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_121 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenNavigator genNavigator = (GenNavigator) ((Object[]) argument)[0];
GenDiagram genDiagram = genNavigator.getEditorGen().getDiagram();
Collection<GenCommonBase> commonBaseElements = new ArrayList<GenCommonBase>(genDiagram.getAllContainers());
commonBaseElements.addAll(genDiagram.getLinks());
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

final String commonKeyPrefix = "Navigator?";
final String invalidElementKey = commonKeyPrefix + "InvalidElement";
final String unknownElementKey = commonKeyPrefix + "UnknownElement";
final String notFoundElementKey = commonKeyPrefix + "ImageNotFound";
/* TODO: move this logic into genmodel */
final class RegistryKey {
	
	private GenCommonBase myCommonBase;
	private String myKey;
	
	public RegistryKey(GenCommonBase commonBase) {
		myCommonBase = commonBase;
	}
	
	public String getKey() {
		if (myKey == null) {
			if (myCommonBase instanceof GenDiagram) {
				myKey = getKey((GenDiagram) myCommonBase);
			} else if (myCommonBase instanceof GenNode) {
				myKey = getKey((GenNode) myCommonBase);
			} else if (myCommonBase instanceof GenLink) {
				myKey = getKey((GenLink) myCommonBase);
			} else if (myCommonBase instanceof GenCompartment) {
				myKey = getKey((GenCompartment) myCommonBase);
			} else if (myCommonBase instanceof GenLabel) {
				myKey = getKey((GenLabel) myCommonBase);
			} else {
				myKey = getInvalidElementKey();
			}
		}
		return myKey;
	}
	
	private String getKey(GenDiagram diagram) {
		return getCommonPrefix() + "Diagram?" + getKeyFragment(diagram.getDomainDiagramElement());
	}
	
	private String getKey(GenNode node) {
		return getCommonPrefix() + (node instanceof GenTopLevelNode ? "TopLevelNode?" : "Node?") + (node.getModelFacet() != null ? getKeyFragment(node.getModelFacet().getMetaClass()) : getKeyFragment(node.getViewmap()));
	}
	
	private String getKey(GenLink link) {
		LinkModelFacet modelFacet = link.getModelFacet();
		if (modelFacet instanceof TypeLinkModelFacet) {
			return getCommonPrefix() + "Link?" + getKeyFragment(((TypeLinkModelFacet) modelFacet).getMetaClass());
		} else if (modelFacet instanceof FeatureLinkModelFacet) {
			return getCommonPrefix() + "Link?" + getKeyFragment(((FeatureLinkModelFacet) modelFacet).getMetaFeature());
		}
		return getCommonPrefix() + "Link?" + getKeyFragment(link.getViewmap());
	}
	
	private String getKey(GenCompartment compartment) {
		return getKey(compartment.getNode()) + "?Compartment?" + compartment.getTitle();
	}
	
	private String getKey(GenLabel label) {
		if (label instanceof GenNodeLabel) {
			GenNodeLabel nodeLabel = (GenNodeLabel) label;
			return getKey(nodeLabel.getNode()) + "?Label?" + getKeyFragment(nodeLabel);
		} else if (label instanceof GenLinkLabel) {
			GenLinkLabel linkLabel = (GenLinkLabel) label;
			return getKey(linkLabel.getLink()) + "?Label?" + getKeyFragment(linkLabel);
		}
		return getInvalidElementKey();
	}
	
	private String getInvalidElementKey() {
		return invalidElementKey;
	}
	
	private String getCommonPrefix() {
		return commonKeyPrefix;
	}
	
	private String getKeyFragment(GenClass genClass) {
		if (genClass == null) {
			return "";
		}
		return genClass.getGenPackage().getNSURI() + "?" + genClass.getName();
	}
	
	private String getKeyFragment(GenFeature genFeature) {
		GenClass genClass = genFeature.getGenClass();
		return getKeyFragment(genClass) + "?" + genFeature.getName();
	}
	
	private String getKeyFragment(GenLabel genLabel) {
		LabelModelFacet modelFacet = genLabel.getModelFacet();
		if (modelFacet instanceof FeatureLabelModelFacet) {
			String result = "";
			for (GenFeature next : ((FeatureLabelModelFacet) genLabel).getMetaFeatures()) {
				result += getKeyFragment(next);
			}
			return result;
		} else if (modelFacet instanceof DesignLabelModelFacet) {
			return getKeyFragment(genLabel.getViewmap());
		}
		return getInvalidElementKey();
	}
	
	private String getKeyFragment(Viewmap viewmap) {
		if (viewmap instanceof FigureViewmap) {
			return ((FigureViewmap) viewmap).getFigureQualifiedClassName();
		} else if (viewmap instanceof InnerClassViewmap) {
			return ((InnerClassViewmap) viewmap).getClassName();
		} else if (viewmap instanceof ParentAssignedViewmap) {
			return ((ParentAssignedViewmap) viewmap).getFigureQualifiedClassName();
		}
		return "";
	}

}


    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    
class FeatureGetAccessorHelper {
	/**
	 * @param containerName the name of the container
	 * @param feature the feature whose value is in interest
	 * @param containerMetaClass the <code>GenClass</code> of the container, or <code>null</code>, if the container is declared as an <code>EObject</code>.
	 * @param needsCastToResultType whether the cast to the result type is required (this parameter is only used if the <code>EClass</code> this feature belongs to is an external interface). 
	 */
	public void appendFeatureValueGetter(String containerName, GenFeature feature, GenClass containerMetaClass, boolean needsCastToResultType) {
		if (feature.getGenClass().isExternalInterface()) {
			boolean needsCastToEObject = containerMetaClass != null && containerMetaClass.isExternalInterface();
			if (needsCastToResultType) {

    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName(feature.isListType() ? "java.util.Collection" : feature.getTypeGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_6);
    
			}
			if (needsCastToEObject) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_8);
    
			}

    stringBuffer.append(containerName);
    
			if (needsCastToEObject) {

    stringBuffer.append(TEXT_9);
    
			}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(feature.getFeatureAccessorName());
    stringBuffer.append(TEXT_12);
    
			if (needsCastToResultType) {

    stringBuffer.append(TEXT_13);
    
			}
		} else {
			boolean needsCastToFeatureGenType = containerMetaClass == null || containerMetaClass.isExternalInterface();
			if (needsCastToFeatureGenType) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_15);
    
			}

    stringBuffer.append(containerName);
    
			if (needsCastToFeatureGenType) {

    stringBuffer.append(TEXT_16);
    
			}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(feature.getGetAccessor());
    stringBuffer.append(TEXT_18);
    
		}
	}
}
final FeatureGetAccessorHelper myFeatureGetAccessorHelper = new FeatureGetAccessorHelper();

    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_19);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genNavigator.getLabelProviderClassName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.LabelProvider"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonLabelProvider"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.ITreePathLabelProvider"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(genNavigator.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(invalidElementKey);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(genNavigator.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(unknownElementKey);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName(genNavigator.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(notFoundElementKey);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.ViewerLabel"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.TreePath"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(genNavigator.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_45);
    
if (false && genDiagram.generateShortcutIcon()) {	//no shortcuts so far in lite

    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_51);
    
}
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_55);
    for (GenCommonBase nextCommonBase : commonBaseElements) {
	if (genNavigator.getChildReferencesTo(nextCommonBase).size() > 0) {
		RegistryKey registryKey = new RegistryKey(nextCommonBase);

    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName(nextCommonBase.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_57);
    
		String elementCode = "null";
		if (nextCommonBase instanceof GenLabel) {
			if (((GenLabel) nextCommonBase).isElementIcon()) {
				if (nextCommonBase instanceof GenLinkLabel) {
					GenLink parent = ((GenLinkLabel) nextCommonBase).getLink();
					if (parent.getModelFacet() instanceof TypeLinkModelFacet) {
						elementCode = "view.getElement()";
					} else if (parent.getModelFacet() instanceof FeatureLinkModelFacet) {

    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_61);
    
						elementCode = "underlyingElement";
					}
				}
			} else {
				elementCode = "null";
			}
		} else if (nextCommonBase instanceof GenChildLabelNode) {
			if (((GenChildLabelNode) nextCommonBase).isLabelElementIcon()) {
				elementCode = "view.getElement()";
			} else {
				elementCode = "null";
			}
		} else if (nextCommonBase instanceof GenCompartment || nextCommonBase instanceof GenLink || nextCommonBase instanceof GenNode || nextCommonBase instanceof GenDiagram) {
			elementCode = "view.getElement()";
		}

    stringBuffer.append(TEXT_62);
    stringBuffer.append(registryKey.getKey());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(elementCode);
    stringBuffer.append(TEXT_64);
    	}
}
    stringBuffer.append(TEXT_65);
    stringBuffer.append(unknownElementKey);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageRegistry"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName(genNavigator.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName(genNavigator.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(notFoundElementKey);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_79);
    
if (false && genDiagram.generateShortcutIcon()) {	//no shortcuts so far in lite

    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_85);
    
}
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_88);
    for (GenCommonBase nextCommonBase : commonBaseElements) {
	if (genNavigator.getChildReferencesTo(nextCommonBase).size() > 0) {
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName(nextCommonBase.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(nextCommonBase.getUniqueIdentifier());
    stringBuffer.append(TEXT_91);
    	}
}
    stringBuffer.append(TEXT_92);
    for (GenCommonBase nextCommonBase : commonBaseElements) {
	if (genNavigator.getChildReferencesTo(nextCommonBase).size() > 0) {
    stringBuffer.append(TEXT_93);
    stringBuffer.append(nextCommonBase.getUniqueIdentifier());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_95);
    		LabelModelFacet labelModelFacet = null;
		GenCommonBase labelHolder = null;
		if (nextCommonBase instanceof GenChildLabelNode) {
			labelModelFacet = ((GenChildLabelNode) nextCommonBase).getLabelModelFacet();
			labelHolder = nextCommonBase;
		} else if (nextCommonBase instanceof GenNode) {
			Collection<GenNodeLabel> labels = ((GenNode) nextCommonBase).getLabels();
			for(GenLabel nextLabel : labels) {
				if (false == nextLabel.getModelFacet() instanceof FeatureLabelModelFacet) {
					continue;
				}
				labelModelFacet = nextLabel.getModelFacet();
				labelHolder = nextLabel;
				break;
			}
		} else if (nextCommonBase instanceof GenLink) {
			GenLink genLink = (GenLink) nextCommonBase;
			Collection<GenLinkLabel> labels = genLink.getLabels();
			for(GenLabel nextLabel : labels) {
				if (false == nextLabel.getModelFacet() instanceof FeatureLabelModelFacet) {
					continue;
				}
				labelModelFacet = nextLabel.getModelFacet();
				labelHolder = nextLabel;
				break;
			}
		} else if (nextCommonBase instanceof GenLabel) {
			labelModelFacet = ((GenLabel) nextCommonBase).getModelFacet();
			labelHolder = nextCommonBase;
		}
		
		if (labelHolder != null) {
/* 1. Label was detected. */
			if (labelModelFacet instanceof FeatureLabelModelFacet) {

    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName(labelHolder.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_98);
    
			} else {

    stringBuffer.append(TEXT_99);
    
			}

    		} else if (nextCommonBase instanceof GenCompartment) {
/* 2. Compartment was detected. */
    stringBuffer.append(TEXT_100);
    stringBuffer.append(((GenCompartment) nextCommonBase).getTitle());
    stringBuffer.append(TEXT_101);
    		} else {
			GenClass domainElement = null;
			if (nextCommonBase instanceof GenDiagram) {
				domainElement = ((GenDiagram) nextCommonBase).getDomainDiagramElement();
			} else if (nextCommonBase instanceof GenNode) {
				GenNode genNode = (GenNode) nextCommonBase;
				if (genNode.getModelFacet() != null) {
					domainElement = genNode.getModelFacet().getMetaClass();
				}
			} else if (nextCommonBase instanceof GenLink) {
				LinkModelFacet modelFacet = ((GenLink) nextCommonBase).getModelFacet();
				if (modelFacet instanceof TypeModelFacet) {
					domainElement = ((TypeModelFacet) modelFacet).getMetaClass();
				}
			}
			if (domainElement != null && domainElement.getLabelFeature() != null) {
/* 3. Underlying domain model element recognized. */
				GenFeature labelFeature = domainElement.getLabelFeature();
				boolean notString = EcorePackage.eINSTANCE.getEString() != labelFeature.getEcoreFeature().getEType();
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_103);
    if (notString) {
    stringBuffer.append(TEXT_104);
    } else {
    stringBuffer.append(TEXT_105);
    }
    myFeatureGetAccessorHelper.appendFeatureValueGetter("domainModelElement", domainElement.getLabelFeature(), null, false);
    if (notString) {
    stringBuffer.append(TEXT_106);
    }
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(String.valueOf(nextCommonBase.getVisualID()));
    stringBuffer.append(TEXT_109);
    			} else {
/* 4. None of above. */
    stringBuffer.append(TEXT_110);
    			}
		}
    stringBuffer.append(TEXT_111);
    	}
}
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonContentExtensionSite"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IMemento"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IMemento"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_120);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_121);
    return stringBuffer.toString();
  }
}
