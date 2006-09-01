package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import java.util.*;

public class ElementChooserGenerator
{
  protected static String nl;
  public static synchronized ElementChooserGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ElementChooserGenerator result = new ElementChooserGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import java.util.Collections;" + NL + "" + NL + "import org.eclipse.core.resources.IContainer;" + NL + "import org.eclipse.core.resources.IFile;" + NL + "import org.eclipse.core.resources.ResourcesPlugin;" + NL + "import org.eclipse.core.runtime.IPath;" + NL + "import org.eclipse.core.runtime.Path;" + NL + "import org.eclipse.emf.common.util.URI;" + NL + "import org.eclipse.emf.common.util.WrappedException;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.resource.Resource;" + NL + "import org.eclipse.emf.ecore.resource.ResourceSet;" + NL + "import org.eclipse.emf.edit.domain.EditingDomain;" + NL + "import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;" + NL + "import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;" + NL + "import org.eclipse.gmf.runtime.diagram.core.services.ViewService;" + NL + "import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;" + NL + "import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;" + NL + "import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;" + NL + "import org.eclipse.gmf.runtime.notation.Node;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.jface.dialogs.Dialog;" + NL + "import org.eclipse.jface.dialogs.IDialogConstants;" + NL + "import org.eclipse.jface.viewers.ILabelProvider;" + NL + "import org.eclipse.jface.viewers.ILabelProviderListener;" + NL + "import org.eclipse.jface.viewers.ISelectionChangedListener;" + NL + "import org.eclipse.jface.viewers.IStructuredSelection;" + NL + "import org.eclipse.jface.viewers.ITreeContentProvider;" + NL + "import org.eclipse.jface.viewers.SelectionChangedEvent;" + NL + "import org.eclipse.jface.viewers.TreeViewer;" + NL + "import org.eclipse.jface.viewers.Viewer;" + NL + "import org.eclipse.jface.viewers.ViewerFilter;" + NL + "import org.eclipse.swt.SWT;" + NL + "import org.eclipse.swt.graphics.Image;" + NL + "import org.eclipse.swt.layout.GridData;" + NL + "import org.eclipse.swt.widgets.Composite;" + NL + "import org.eclipse.swt.widgets.Control;" + NL + "import org.eclipse.swt.widgets.Shell;" + NL + "import org.eclipse.ui.model.WorkbenchContentProvider;" + NL + "import org.eclipse.ui.model.WorkbenchLabelProvider;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends Dialog {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate TreeViewer myTreeViewer;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EObject mySelectedModelElement;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate View myView;" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EditingDomain myEditingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_7 = "(Shell parentShell, View view) {" + NL + "\t\tsuper(parentShell);" + NL + "\t\tsetShellStyle(getShellStyle() | SWT.RESIZE);" + NL + "\t\tmyView = view;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Control createDialogArea(Composite parent) {" + NL + "\t\tComposite composite = (Composite) super.createDialogArea(parent);" + NL + "\t\tgetShell().setText(\"Select model element\");" + NL + "\t\tcreateModelBrowser(composite);" + NL + "\t\treturn composite;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Control createButtonBar(Composite parent) {" + NL + "\t\tControl buttonBar = super.createButtonBar(parent);" + NL + "\t\tsetOkButtonEnabled(false);" + NL + "\t\treturn buttonBar;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createModelBrowser(Composite composite) {" + NL + "\t\tmyTreeViewer = new TreeViewer(composite, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);" + NL + "\t\tGridData layoutData = new GridData(GridData.FILL_BOTH);" + NL + "\t\tlayoutData.heightHint = 300;" + NL + "\t\tlayoutData.widthHint = 300;" + NL + "\t\tmyTreeViewer.getTree().setLayoutData(layoutData);" + NL + "\t\tmyTreeViewer.setContentProvider(new ModelElementsTreeContentProvider());" + NL + "\t\tmyTreeViewer.setLabelProvider(new ModelElementsTreeLabelProvider());" + NL + "\t\tmyTreeViewer.setInput(ResourcesPlugin.getWorkspace().getRoot());" + NL + "\t\tmyTreeViewer.addFilter(new ModelFilesFilter());" + NL + "\t\tmyTreeViewer.addSelectionChangedListener(new OkButtonEnabler());" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void setOkButtonEnabled(boolean enabled) {" + NL + "\t\tgetButton(IDialogConstants.OK_ID).setEnabled(enabled);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isValidModelFile(IFile file) {" + NL + "\t\tString fileExtension = file.getFullPath().getFileExtension();" + NL + "\t\treturn ";
  protected final String TEXT_8 = NL + "\t\t\t\"";
  protected final String TEXT_9 = "\".equals(fileExtension) ";
  protected final String TEXT_10 = NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic URI getSelectedModelElementURI() {" + NL + "\t\tResource resource = mySelectedModelElement.eResource();" + NL + "\t\treturn resource.getURI().appendFragment(resource.getURIFragment(mySelectedModelElement));" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class ModelElementsTreeContentProvider implements ITreeContentProvider {" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ITreeContentProvider myWorkbenchContentProvider = new WorkbenchContentProvider();" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate AdapterFactoryContentProvider myAdapterFctoryContentProvier = new AdapterFactoryContentProvider(";
  protected final String TEXT_11 = ".getInstance().getItemProvidersAdapterFactory());" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Object[] getChildren(Object parentElement) {" + NL + "\t\t\tObject[] result = myWorkbenchContentProvider.getChildren(parentElement);" + NL + "\t\t\tif (result != null && result.length > 0) {" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t\tif (parentElement instanceof IFile) {" + NL + "\t\t\t\tIFile modelFile = (IFile) parentElement;" + NL + "\t\t\t\tIPath resourcePath = modelFile.getFullPath();" + NL + "\t\t\t\tResourceSet resourceSet = myEditingDomain.getResourceSet();" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tResource modelResource = resourceSet.getResource(URI.createPlatformResourceURI(resourcePath.toString()), true);" + NL + "\t\t\t\t\treturn myAdapterFctoryContentProvier.getChildren(modelResource);" + NL + "\t\t\t\t} catch (WrappedException e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_12 = ".getInstance().logError(\"Unable to load resource: \" + resourcePath.toString(), e); //$NON-NLS-1$" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn Collections.EMPTY_LIST.toArray();" + NL + "\t\t\t}" + NL + "\t\t\treturn myAdapterFctoryContentProvier.getChildren(parentElement);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Object getParent(Object element) {" + NL + "\t\t\tObject parent = myWorkbenchContentProvider.getParent(element);" + NL + "\t\t\tif (parent != null) {" + NL + "\t\t\t\treturn parent;" + NL + "\t\t\t}" + NL + "\t\t\tif (element instanceof EObject) {" + NL + "\t\t\t\tEObject eObject = (EObject) element;" + NL + "\t\t\t\tif (eObject.eContainer() == null && eObject.eResource().getURI().isFile()) {" + NL + "\t\t\t\t\tString path = eObject.eResource().getURI().path();" + NL + "\t\t\t\t\treturn ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(path));" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn myAdapterFctoryContentProvier.getParent(eObject);" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean hasChildren(Object element) {" + NL + "\t\t\tif (element instanceof IFile) {" + NL + "\t\t\t\treturn isValidModelFile((IFile) element);" + NL + "\t\t\t}" + NL + "\t\t\treturn myWorkbenchContentProvider.hasChildren(element) || myAdapterFctoryContentProvier.hasChildren(element);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Object[] getElements(Object inputElement) {" + NL + "\t\t\tObject[] elements = myWorkbenchContentProvider.getElements(inputElement);" + NL + "\t\t\treturn elements;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void dispose() {" + NL + "\t\t\tmyWorkbenchContentProvider.dispose();" + NL + "\t\t\tmyAdapterFctoryContentProvier.dispose();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void inputChanged(Viewer viewer, Object oldInput, Object newInput) {" + NL + "\t\t\tmyWorkbenchContentProvider.inputChanged(viewer, oldInput, newInput);" + NL + "\t\t\tmyAdapterFctoryContentProvier.inputChanged(viewer, oldInput, newInput);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class ModelElementsTreeLabelProvider implements ILabelProvider {" + NL + "\t\t" + NL + "\t\tprivate WorkbenchLabelProvider myWorkbenchLabelProvider = new WorkbenchLabelProvider();" + NL + "\t\tprivate AdapterFactoryLabelProvider myAdapterFactoryLabelProvider = new AdapterFactoryLabelProvider(";
  protected final String TEXT_13 = ".getInstance().getItemProvidersAdapterFactory());" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Image getImage(Object element) {" + NL + "\t\t\tImage result = myWorkbenchLabelProvider.getImage(element);" + NL + "\t\t\treturn result != null ? result : myAdapterFactoryLabelProvider.getImage(element);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic String getText(Object element) {" + NL + "\t\t\tString result = myWorkbenchLabelProvider.getText(element);" + NL + "\t\t\treturn result != null && result.length() > 0 ? result : myAdapterFactoryLabelProvider.getText(element);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void addListener(ILabelProviderListener listener) {" + NL + "\t\t\tmyWorkbenchLabelProvider.addListener(listener);" + NL + "\t\t\tmyAdapterFactoryLabelProvider.addListener(listener);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void dispose() {" + NL + "\t\t\tmyWorkbenchLabelProvider.dispose();" + NL + "\t\t\tmyAdapterFactoryLabelProvider.dispose();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean isLabelProperty(Object element, String property) {" + NL + "\t\t\treturn myWorkbenchLabelProvider.isLabelProperty(element, property) || myAdapterFactoryLabelProvider.isLabelProperty(element, property);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void removeListener(ILabelProviderListener listener) {" + NL + "\t\t\tmyWorkbenchLabelProvider.removeListener(listener);" + NL + "\t\t\tmyAdapterFactoryLabelProvider.removeListener(listener);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class ModelFilesFilter extends ViewerFilter {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean select(Viewer viewer, Object parentElement, Object element) {" + NL + "\t\t\tif (element instanceof IContainer) {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t\tif (element instanceof IFile) {" + NL + "\t\t\t\tIFile file = (IFile) element;" + NL + "\t\t\t\treturn isValidModelFile(file);" + NL + "\t\t\t}" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class OkButtonEnabler implements ISelectionChangedListener {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void selectionChanged(SelectionChangedEvent event) {" + NL + "\t\t\tif (event.getSelection() instanceof IStructuredSelection) {" + NL + "\t\t\t\tIStructuredSelection selection = (IStructuredSelection) event.getSelection();" + NL + "\t\t\t\tif (selection.size() == 1) {" + NL + "\t\t\t\t\tObject selectedElement = selection.getFirstElement();" + NL + "\t\t\t\t\tif (selectedElement instanceof ";
  protected final String TEXT_14 = ") {" + NL + "\t\t\t\t\t\tselectedElement = ((";
  protected final String TEXT_15 = ") selectedElement).getValue();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (selectedElement instanceof ";
  protected final String TEXT_16 = ".Entry) {" + NL + "\t\t\t\t\t\tselectedElement = ((";
  protected final String TEXT_17 = ".Entry) selectedElement).getValue();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tif (selectedElement instanceof EObject) {" + NL + "\t\t\t\t\t\tmySelectedModelElement = (EObject) selectedElement;" + NL + "\t\t\t\t\t\tsetOkButtonEnabled(ViewService.getInstance().provides(Node.class, new EObjectAdapter(mySelectedModelElement), myView, null, ViewUtil.APPEND, true, ";
  protected final String TEXT_18 = ".DIAGRAM_PREFERENCES_HINT));" + NL + "\t\t\t\t\t\treturn;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tmySelectedModelElement = null;" + NL + "\t\t\tsetOkButtonEnabled(false);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_19 = NL;

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
    stringBuffer.append(genDiagram.getElementChooserClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getElementChooserClassName());
    stringBuffer.append(TEXT_7);
    
for (Iterator it = genDiagram.getContainsShortcutsTo().iterator(); it.hasNext();) {
	String nextFileExtension = (String) it.next();

    stringBuffer.append(TEXT_8);
    stringBuffer.append(nextFileExtension);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(it.hasNext() ? "||" : ";");
    
}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.provider.IWrapperItemProvider"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.edit.provider.IWrapperItemProvider"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.util.FeatureMap"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_18);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
