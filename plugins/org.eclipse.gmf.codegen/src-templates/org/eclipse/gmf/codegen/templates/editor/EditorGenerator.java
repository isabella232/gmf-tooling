package org.eclipse.gmf.codegen.templates.editor;

import java.util.List;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.util.ImportUtil;

public class EditorGenerator
{
  protected static String nl;
  public static synchronized EditorGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    EditorGenerator result = new EditorGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import java.util.ArrayList;" + NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.emf.common.notify.AdapterFactory;" + NL + "import org.eclipse.emf.edit.provider.ComposedAdapterFactory;" + NL + "import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;" + NL + "import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;" + NL + "import org.eclipse.gef.palette.PaletteRoot;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.editor.FileDiagramEditorWithFlyoutPalette;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends FileDiagramEditorWithFlyoutPalette {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected PaletteRoot createPaletteRoot() {" + NL + "\t\treturn ";
  protected final String TEXT_6 = ".createPalette(getSemanticAdapterFactory(), getDiagram());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void updatePaletteRoot() {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected AdapterFactory getSemanticAdapterFactory() {" + NL + "\t\tList factories = new ArrayList();" + NL + "\t\tfillItemProviderFactories(factories);" + NL + "\t\treturn new ComposedAdapterFactory(factories);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void fillItemProviderFactories(List factories) {";
  protected final String TEXT_7 = NL + "\t\tfactories.add(new ";
  protected final String TEXT_8 = "());";
  protected final String TEXT_9 = NL + "\t\tfactories.add(new ";
  protected final String TEXT_10 = "());";
  protected final String TEXT_11 = NL + "\t\tfactories.add(new ResourceItemProviderAdapterFactory());" + NL + "\t\tfactories.add(new ReflectiveItemProviderAdapterFactory());" + NL + "\t}" + NL + "}";
  protected final String TEXT_12 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    GenModel genModel = genDiagram.getEMFGenModel();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditorClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPalette().getFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_6);
    
List genPackages = genModel.getAllGenPackagesWithClassifiers();
for (int i = 0; i < genPackages.size(); i++) {
	GenPackage genPackage = (GenPackage) genPackages.get(i);
	if (genPackage.getGenModel().hasEditSupport()) {

    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedItemProviderAdapterFactoryClassName()));
    stringBuffer.append(TEXT_8);
    
	}
}
genPackages = genModel.getAllUsedGenPackagesWithClassifiers();
for (int i = 0; i < genPackages.size(); i++) {
	GenPackage genPackage = (GenPackage) genPackages.get(i);
	if (genPackage.getGenModel().hasEditSupport()) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedItemProviderAdapterFactoryClassName()));
    stringBuffer.append(TEXT_10);
    
	}
}

    stringBuffer.append(TEXT_11);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
