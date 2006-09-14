package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

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
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " implements ";
  protected final String TEXT_8 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic {" + NL + "\t\t";
  protected final String TEXT_9 = ".getInstance().getImageRegistry().put(\"";
  protected final String TEXT_10 = "\", ";
  protected final String TEXT_11 = ".getMissingImageDescriptor());" + NL + "\t\t";
  protected final String TEXT_12 = ".getInstance().getImageRegistry().put(\"";
  protected final String TEXT_13 = "\", ";
  protected final String TEXT_14 = ".getMissingImageDescriptor());" + NL + "\t\t";
  protected final String TEXT_15 = ".getInstance().getImageRegistry().put(\"";
  protected final String TEXT_16 = "\", ";
  protected final String TEXT_17 = ".getMissingImageDescriptor());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_18 = " myAdapterFactoryLabelProvider = new ";
  protected final String TEXT_19 = "(";
  protected final String TEXT_20 = ".getInstance().getItemProvidersAdapterFactory());" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_21 = " getImage(Object element) {" + NL + "\t\tif (element instanceof ";
  protected final String TEXT_22 = ") {" + NL + "\t\t\t";
  protected final String TEXT_23 = " view = (";
  protected final String TEXT_24 = ") element;" + NL + "\t\t\tif (!";
  protected final String TEXT_25 = ".MODEL_ID.equals(";
  protected final String TEXT_26 = ".getModelID(view))) {" + NL + "\t\t\t\treturn super.getImage(element);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\t" + NL + "\t\t\tint visualID = ";
  protected final String TEXT_27 = ".getVisualID(view);" + NL + "\t\t\tString key;" + NL + "\t\t\t";
  protected final String TEXT_28 = " elementType = null;" + NL + "\t\t\tswitch (visualID) {";
  protected final String TEXT_29 = NL + "\t\t\tcase ";
  protected final String TEXT_30 = ".VISUAL_ID:" + NL + "\t\t\t\tkey = \"";
  protected final String TEXT_31 = "\";";
  protected final String TEXT_32 = NL + "\t\t\t\telementType = ";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = ";";
  protected final String TEXT_35 = NL + "\t\t\t\tbreak;";
  protected final String TEXT_36 = NL + "\t\t\t\tdefault:" + NL + "\t\t\t\t\tkey = \"";
  protected final String TEXT_37 = "\";" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_38 = " imageRegistry = ";
  protected final String TEXT_39 = ".getInstance().getImageRegistry();" + NL + "\t\t\t";
  protected final String TEXT_40 = " image = imageRegistry.get(key);" + NL + "\t\t\tif (image == null && elementType != null && ";
  protected final String TEXT_41 = ".isKnownElementType(elementType)) {" + NL + "\t\t\t\timage = ";
  protected final String TEXT_42 = ".getImage(elementType);" + NL + "\t\t\t\timageRegistry.put(key, image);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tif (image == null) {" + NL + "\t\t\t\timage = imageRegistry.get(\"";
  protected final String TEXT_43 = "\");" + NL + "\t\t\t\timageRegistry.put(key, image);" + NL + "\t\t\t}" + NL + "\t\t\treturn image;" + NL + "\t\t} else if (element instanceof ";
  protected final String TEXT_44 = ") {" + NL + "\t\t\t";
  protected final String TEXT_45 = " group = (";
  protected final String TEXT_46 = ") element;" + NL + "\t\t\tif (";
  protected final String TEXT_47 = ".MODEL_ID.equals(group.getModelID())) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_48 = ".getInstance().getBundledImage(group.getIcon());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn super.getImage(element);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getText(Object element) {" + NL + "\t\tif (element instanceof ";
  protected final String TEXT_49 = ") {" + NL + "\t\t\t";
  protected final String TEXT_50 = " view = (";
  protected final String TEXT_51 = ") element;" + NL + "\t\t\tif (!";
  protected final String TEXT_52 = ".MODEL_ID.equals(";
  protected final String TEXT_53 = ".getModelID(view))) {" + NL + "\t\t\t\treturn super.getText(element);" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_54 = " eObject = view.getElement();" + NL + "\t\t\treturn myAdapterFactoryLabelProvider.getText(eObject);" + NL + "\t\t} else if (element instanceof ";
  protected final String TEXT_55 = ") {" + NL + "\t\t\t";
  protected final String TEXT_56 = " group = (";
  protected final String TEXT_57 = ") element;" + NL + "\t\t\tif (";
  protected final String TEXT_58 = ".MODEL_ID.equals(group.getModelID())) {" + NL + "\t\t\t\treturn ((";
  protected final String TEXT_59 = ") element).getGroupName();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn super.getText(element);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void init(";
  protected final String TEXT_60 = " aConfig) {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void restoreState(";
  protected final String TEXT_61 = " aMemento) {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void saveState(";
  protected final String TEXT_62 = " aMemento) {" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getDescription(Object anElement) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_63 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenNavigator genNavigator = (GenNavigator) ((Object[]) argument)[0];
GenDiagram genDiagram = genNavigator.getEditorGen().getDiagram();
Collection commonBaseElements = new ArrayList(genDiagram.getAllContainers());
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
		return getCommonPrefix() + (node instanceof GenTopLevelNode ? "TopLevelNode?" : "Node?") + getKeyFragment(node.getModelFacet().getMetaClass());
	}
	
	private String getKey(GenLink link) {
		LinkModelFacet modelFacet = link.getModelFacet();
		if (modelFacet instanceof TypeLinkModelFacet) {
			return getCommonPrefix() + "Link?" + getKeyFragment(((TypeLinkModelFacet) modelFacet).getMetaClass());
		} else if (modelFacet instanceof FeatureLinkModelFacet) {
			return getCommonPrefix() + "Link?" + getKeyFragment(((FeatureLinkModelFacet) modelFacet).getMetaFeature());
		}
		return getInvalidElementKey();
	}
	
	private String getKey(GenCompartment compartment) {
		return getCommonPrefix() + "Compartment?" + getKeyFragment(compartment.getNode().getModelFacet().getMetaClass()) + "?" + compartment.getTitle();
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
		return genClass.getGenPackage().getNSURI() + "?" + genClass.getName();
	}
	
	private String getKeyFragment(GenFeature genFeature) {
		GenClass genClass = genFeature.getGenClass();
		return getKeyFragment(genClass) + "?" + genFeature.getName();
	}
	
	private String getKeyFragment(GenLabel genLabel) {
		LabelModelFacet modelFacet = genLabel.getModelFacet();
		if (modelFacet instanceof CompositeFeatureLabelModelFacet) {
			String result = "";
			for (Iterator it = ((CompositeFeatureLabelModelFacet) genLabel).getMetaFeatures().iterator(); it.hasNext();) {
				result += getKeyFragment((GenFeature) it.next());
			}
			return result;
		} else if (modelFacet instanceof FeatureLabelModelFacet) {
			return getKeyFragment(((FeatureLabelModelFacet) modelFacet).getMetaFeature());
		} else if (modelFacet instanceof DesignLabelModelFacet) {
			return "DesignLabel";
		}
		return getInvalidElementKey();
	}

}


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
    stringBuffer.append(genNavigator.getLabelProviderClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.LabelProvider"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonLabelProvider"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genNavigator.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(invalidElementKey);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genNavigator.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(unknownElementKey);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(genNavigator.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(notFoundElementKey);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName(genNavigator.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_28);
    for (Iterator it = commonBaseElements.iterator(); it.hasNext();) {
	GenCommonBase nextCommonBase = (GenCommonBase) it.next();
	if (genNavigator.getChildReferencesTo(nextCommonBase).size() > 0) {
		RegistryKey registryKey = new RegistryKey(nextCommonBase);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName(nextCommonBase.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(registryKey.getKey());
    stringBuffer.append(TEXT_31);
    		if (nextCommonBase.getElementType() != null) {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(nextCommonBase.getUniqueIdentifier());
    stringBuffer.append(TEXT_34);
    		}
    stringBuffer.append(TEXT_35);
    	}
}
    stringBuffer.append(TEXT_36);
    stringBuffer.append(unknownElementKey);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageRegistry"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(genNavigator.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(notFoundElementKey);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(genNavigator.getGroupWrapperQualifiedClassName()));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(genNavigator.getGroupWrapperQualifiedClassName()));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName(genNavigator.getGroupWrapperQualifiedClassName()));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(genNavigator.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName(genNavigator.getGroupWrapperQualifiedClassName()));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName(genNavigator.getGroupWrapperQualifiedClassName()));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName(genNavigator.getGroupWrapperQualifiedClassName()));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName(genNavigator.getGroupWrapperQualifiedClassName()));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.navigator.ICommonContentExtensionSite"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IMemento"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IMemento"));
    stringBuffer.append(TEXT_62);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_63);
    return stringBuffer.toString();
  }
}
