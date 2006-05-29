package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ModelingAssistantProviderGenerator
{
  protected static String nl;
  public static synchronized ModelingAssistantProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ModelingAssistantProviderGenerator result = new ModelingAssistantProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/**" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import java.util.ArrayList;" + NL + "import java.util.Collection;" + NL + "import java.util.Collections;" + NL + "import java.util.HashSet;" + NL + "import java.util.Iterator;" + NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IElementType;" + NL + "import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.jface.viewers.ILabelProvider;" + NL + "import org.eclipse.jface.window.Window;" + NL + "import org.eclipse.swt.widgets.Display;" + NL + "import org.eclipse.swt.widgets.Shell;" + NL + "import org.eclipse.ui.dialogs.ElementListSelectionDialog;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ModelingAssistantProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List getTypesForPopupBar(IAdaptable host) {" + NL + "\t\tIGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);";
  protected final String TEXT_7 = NL + "\t\tif (editPart instanceof ";
  protected final String TEXT_8 = ") {" + NL + "\t\t\tList types = new ArrayList();";
  protected final String TEXT_9 = NL + "\t\t\ttypes.add(";
  protected final String TEXT_10 = ".";
  protected final String TEXT_11 = ");";
  protected final String TEXT_12 = NL + "\t\t\treturn types;" + NL + "\t\t}";
  protected final String TEXT_13 = NL + "\t\treturn Collections.EMPTY_LIST;" + NL + "\t}";
  protected final String TEXT_14 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List getRelTypesOnSource(IAdaptable source) {";
  protected final String TEXT_15 = NL + "\t\tIGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);";
  protected final String TEXT_16 = NL + "\t\tif (sourceEditPart instanceof ";
  protected final String TEXT_17 = ") {" + NL + "\t\t\tList types = new ArrayList();";
  protected final String TEXT_18 = NL + "\t\t\ttypes.add(";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ");";
  protected final String TEXT_21 = NL + "\t\t\treturn types;" + NL + "\t\t}";
  protected final String TEXT_22 = NL + "\t\treturn Collections.EMPTY_LIST;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List getRelTypesOnTarget(IAdaptable target) {";
  protected final String TEXT_23 = NL + "\t\tIGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);";
  protected final String TEXT_24 = NL + "\t\tif (targetEditPart instanceof ";
  protected final String TEXT_25 = ") {" + NL + "\t\t\tList types = new ArrayList();";
  protected final String TEXT_26 = NL + "\t\t\ttypes.add(";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = ");";
  protected final String TEXT_29 = NL + "\t\t\treturn types;" + NL + "\t\t}";
  protected final String TEXT_30 = NL + "\t\treturn Collections.EMPTY_LIST;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {";
  protected final String TEXT_31 = NL + "\t\tIGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);" + NL + "\t\tIGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);";
  protected final String TEXT_32 = NL + "\t\tif (sourceEditPart instanceof ";
  protected final String TEXT_33 = ") {" + NL + "\t\t\tList types = new ArrayList();";
  protected final String TEXT_34 = NL + "\t\t\tif (targetEditPart instanceof ";
  protected final String TEXT_35 = ") {" + NL + "\t\t\t\ttypes.add(";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = ");" + NL + "\t\t\t}";
  protected final String TEXT_38 = NL + "\t\t\treturn types;" + NL + "\t\t}";
  protected final String TEXT_39 = NL + "\t\treturn Collections.EMPTY_LIST;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List getTypesForSource(IAdaptable target, IElementType relationshipType) {";
  protected final String TEXT_40 = NL + "\t\tIGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);";
  protected final String TEXT_41 = NL + "\t\tif (targetEditPart instanceof ";
  protected final String TEXT_42 = ") {" + NL + "\t\t\tList types = new ArrayList();";
  protected final String TEXT_43 = NL + "\t\t\tif (relationshipType == ";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = ") {" + NL + "\t\t\t\ttypes.add(";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = ");" + NL + "\t\t\t}";
  protected final String TEXT_48 = NL + "\t\t\treturn types;" + NL + "\t\t}";
  protected final String TEXT_49 = NL + "\t\treturn Collections.EMPTY_LIST;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List getTypesForTarget(IAdaptable source, IElementType relationshipType) {";
  protected final String TEXT_50 = NL + "\t\tIGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);";
  protected final String TEXT_51 = NL + "\t\tif (sourceEditPart instanceof ";
  protected final String TEXT_52 = ") {" + NL + "\t\t\tList types = new ArrayList();";
  protected final String TEXT_53 = NL + "\t\t\tif (relationshipType == ";
  protected final String TEXT_54 = ".";
  protected final String TEXT_55 = ") {" + NL + "\t\t\t\ttypes.add(";
  protected final String TEXT_56 = ".";
  protected final String TEXT_57 = ");" + NL + "\t\t\t}";
  protected final String TEXT_58 = NL + "\t\t\treturn types;" + NL + "\t\t}";
  protected final String TEXT_59 = NL + "\t\treturn Collections.EMPTY_LIST;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EObject selectExistingElementForSource(IAdaptable target, IElementType relationshipType) {" + NL + "\t\treturn selectExistingElement(target, getTypesForSource(target, relationshipType));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EObject selectExistingElementForTarget(IAdaptable source, IElementType relationshipType) {" + NL + "\t\treturn selectExistingElement(source, getTypesForTarget(source, relationshipType));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject selectExistingElement(IAdaptable host, Collection types) {" + NL + "\t\tif (types.isEmpty()) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\tIGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);" + NL + "\t\tif (editPart == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\tDiagram diagram = (Diagram) editPart.getRoot().getContents().getModel();" + NL + "\t\tCollection elements = new HashSet();" + NL + "\t\tfor (Iterator it = diagram.getElement().eAllContents(); it.hasNext();) {" + NL + "\t\t\tEObject element = (EObject) it.next();" + NL + "\t\t\tif (isApplicableElement(element, types)) {" + NL + "\t\t\t\telements.add(element);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif (elements.isEmpty()) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn selectElement((EObject[]) elements.toArray(new EObject[elements.size()]));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isApplicableElement(EObject element, Collection types) {" + NL + "\t\tIElementType type = ElementTypeRegistry.getInstance().getElementType(element);" + NL + "\t\treturn types.contains(type);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject selectElement(EObject[] elements) {" + NL + "\t\tShell shell = Display.getCurrent().getActiveShell();" + NL + "\t\tILabelProvider labelProvider = new AdapterFactoryLabelProvider(";
  protected final String TEXT_60 = ".getInstance().getItemProvidersAdapterFactory());" + NL + "\t\tElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);" + NL + "\t\tdialog.setMessage(\"Available domain model elements:\");" + NL + "\t\tdialog.setTitle(\"Select domain model element\");" + NL + "\t\tdialog.setMultipleSelection(false);" + NL + "\t\tdialog.setElements(elements);" + NL + "\t\tEObject selected = null;" + NL + "\t\tif (dialog.open() == Window.OK) {" + NL + "\t\t\tselected = (EObject) dialog.getFirstResult();" + NL + "\t\t}" + NL + "\t\treturn selected;" + NL + "\t}" + NL + "}";
  protected final String TEXT_61 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
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
    stringBuffer.append(genDiagram.getModelingAssistantProviderClassName());
    stringBuffer.append(TEXT_6);
    
for (Iterator contents = genDiagram.getAllContainers().iterator(); contents.hasNext(); ) {
	GenContainerBase genContainer = (GenContainerBase) contents.next();
	if (genContainer instanceof GenCompartment && ((GenCompartment) genContainer).isListLayout()) {
		continue;
	}
	List children = new ArrayList(genContainer.getContainedNodes());
	if (genContainer instanceof GenNode) {
		for (Iterator compartments = ((GenNode) genContainer).getCompartments().iterator(); compartments.hasNext(); ) {
			GenCompartment compartment = (GenCompartment) compartments.next();
			if (compartment.isListLayout()) {
				children.addAll(compartment.getContainedNodes());
			}
		}
	}
	if (!children.isEmpty()) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genContainer.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    
			for (int i = 0; i < children.size(); i++) {
				String id = ((GenNode) children.get(i)).getUniqueIdentifier();

    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_11);
    			}
    stringBuffer.append(TEXT_12);
    
	}
}

    stringBuffer.append(TEXT_13);
    
Map outgoingLinks = new LinkedHashMap(); // source -> links going from the source
Map incomingLinks = new LinkedHashMap(); // target -> links coming to the target
for (Iterator links = genDiagram.getLinks().iterator(); links.hasNext(); ) {
	GenLink genLink = (GenLink) links.next();
	for (Iterator sources = genLink.getSources().iterator(); sources.hasNext(); ) {
		GenCommonBase source = (GenCommonBase) sources.next();
		Collection value = (Collection) outgoingLinks.get(source);
		if (value == null) {
			value = new LinkedHashSet();
			outgoingLinks.put(source, value);
		}
		value.add(genLink);
	}
	for (Iterator targets = genLink.getTargets().iterator(); targets.hasNext(); ) {
		GenCommonBase target = (GenCommonBase) targets.next();
		Collection value = (Collection) incomingLinks.get(target);
		if (value == null) {
			value = new LinkedHashSet();
			incomingLinks.put(target, value);
		}
		value.add(genLink);
	}
}

    stringBuffer.append(TEXT_14);
    if (!outgoingLinks.isEmpty()) {
    stringBuffer.append(TEXT_15);
    
	for (Iterator sources = outgoingLinks.keySet().iterator(); sources.hasNext(); ) {
		GenCommonBase source = (GenCommonBase) sources.next();

    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName(source.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_17);
    
		for (Iterator links = ((Collection) outgoingLinks.get(source)).iterator(); links.hasNext(); ) {
			GenLink genLink = (GenLink) links.next();

    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_20);
    		}
    stringBuffer.append(TEXT_21);
    
	}
}

    stringBuffer.append(TEXT_22);
    if (!incomingLinks.isEmpty()) {
    stringBuffer.append(TEXT_23);
    
	for (Iterator targets = incomingLinks.keySet().iterator(); targets.hasNext(); ) {
		GenCommonBase target = (GenCommonBase) targets.next();

    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(target.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_25);
    
		for (Iterator links = ((Collection) incomingLinks.get(target)).iterator(); links.hasNext(); ) {
			GenLink genLink = (GenLink) links.next();

    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_28);
    		}
    stringBuffer.append(TEXT_29);
    
	}
}

    stringBuffer.append(TEXT_30);
    if (!outgoingLinks.isEmpty()) {
    stringBuffer.append(TEXT_31);
    
	for (Iterator sources = outgoingLinks.keySet().iterator(); sources.hasNext(); ) {
		GenCommonBase source = (GenCommonBase) sources.next();

    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(source.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_33);
    
		for (Iterator links = ((Collection) outgoingLinks.get(source)).iterator(); links.hasNext(); ) {
			GenLink genLink = (GenLink) links.next();
			for (Iterator targets = genLink.getTargets().iterator(); targets.hasNext(); ) {
				GenCommonBase target = (GenCommonBase) targets.next();

    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName(target.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_37);
    
			}
		}

    stringBuffer.append(TEXT_38);
    
	}
}

    stringBuffer.append(TEXT_39);
    if (!incomingLinks.isEmpty()) {
    stringBuffer.append(TEXT_40);
    
	for (Iterator targets = incomingLinks.keySet().iterator(); targets.hasNext(); ) {
		GenCommonBase target = (GenCommonBase) targets.next();

    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(target.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_42);
    
		for (Iterator links = ((Collection) incomingLinks.get(target)).iterator(); links.hasNext(); ) {
			GenLink genLink = (GenLink) links.next();
			for (Iterator sources = genLink.getSources().iterator(); sources.hasNext(); ) {
				GenCommonBase source = (GenCommonBase) sources.next();

    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(source.getUniqueIdentifier());
    stringBuffer.append(TEXT_47);
    
			}
		}

    stringBuffer.append(TEXT_48);
    
	}
}

    stringBuffer.append(TEXT_49);
    if (!outgoingLinks.isEmpty()) {
    stringBuffer.append(TEXT_50);
    
	for (Iterator sources = outgoingLinks.keySet().iterator(); sources.hasNext(); ) {
		GenCommonBase source = (GenCommonBase) sources.next();

    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName(source.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_52);
    
		for (Iterator links = ((Collection) outgoingLinks.get(source)).iterator(); links.hasNext(); ) {
			GenLink genLink = (GenLink) links.next();
			for (Iterator targets = genLink.getTargets().iterator(); targets.hasNext(); ) {
				GenCommonBase target = (GenCommonBase) targets.next();

    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(target.getUniqueIdentifier());
    stringBuffer.append(TEXT_57);
    
			}
		}

    stringBuffer.append(TEXT_58);
    
	}
}

    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_60);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_61);
    return stringBuffer.toString();
  }
}
