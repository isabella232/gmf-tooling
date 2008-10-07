package org.eclipse.gmf.tests.xpand.migration;
public class JavaExtensionsContainer {
public static class Metainfo {
public static String[] simpleNativeExtension(String parameter) { return new String[] {"String", "String"}; }
public static String[] modelElementAsNativeExtensionParameter(org.eclipse.emf.ecore.EObject param1, org.eclipse.emf.ecore.EPackage param2) { return new String[] {"ecore::EClass", "ecore::EObject", "ecore::EPackage"}; }
public static String[] collectionsInNativeExtensions(java.util.Collection param1, java.util.Set param2, java.util.List param3, java.util.List param4) { return new String[] {"Sequence(ecore::EClass)", "Collection(ecore::EObject)", "Set(ecore::EPackage)", "Sequence(OclAny)", "Sequence(ecore::EClassifier)"}; }
}
public String simpleNativeExtension(String parameter) { return org.eclipse.gmf.tests.xpand.migration.NativeExtensionsContainer.simpleNativeExtension(parameter); }
public org.eclipse.emf.ecore.EClass modelElementAsNativeExtensionParameter(org.eclipse.emf.ecore.EObject param1, org.eclipse.emf.ecore.EPackage param2) { return org.eclipse.gmf.tests.xpand.migration.NativeExtensionsContainer.modelElementAsNativeExtensionParameter(param1, param2); }
public java.util.List collectionsInNativeExtensions(java.util.Collection param1, java.util.Set param2, java.util.List param3, java.util.List param4) { return org.eclipse.gmf.tests.xpand.migration.NativeExtensionsContainer.collectionsInNativeExtensions(param1, param2, param3.toArray(new Object[param3.size()]), param4.toArray(new org.eclipse.emf.ecore.EClassifier[param4.size()])); }
}