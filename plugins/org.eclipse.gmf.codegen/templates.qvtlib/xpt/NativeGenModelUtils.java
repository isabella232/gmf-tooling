package xpt;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
public class NativeGenModelUtils {
@Operation(contextual = false, kind = Kind.HELPER)
public static org.eclipse.emf.codegen.ecore.genmodel.GenClass getDocumentRoot(org.eclipse.emf.codegen.ecore.genmodel.GenPackage gp) { return org.eclipse.gmf.internal.codegen.util.GenModelUtils.getDocumentRoot(gp); }
@Operation(contextual = false, kind = Kind.HELPER)
public static org.eclipse.emf.codegen.ecore.genmodel.GenClassifier findGenClassifier(org.eclipse.emf.codegen.ecore.genmodel.GenModel genModel, org.eclipse.emf.ecore.EClassifier eClassifier) { return org.eclipse.gmf.internal.codegen.util.GenModelUtils.findGenClassifier(genModel, eClassifier); }
@Operation(contextual = false, kind = Kind.HELPER)
public static Boolean isListType(org.eclipse.emf.codegen.ecore.genmodel.GenFeature feature) { return org.eclipse.gmf.internal.codegen.util.GenModelUtils.isListType(feature); }
@Operation(contextual = false, kind = Kind.HELPER)
public static Boolean isDerived(org.eclipse.emf.codegen.ecore.genmodel.GenFeature feature) { return org.eclipse.gmf.internal.codegen.util.GenModelUtils.isDerived(feature); }
@Operation(contextual = false, kind = Kind.HELPER)
public static org.eclipse.emf.codegen.ecore.genmodel.GenClass getTypeGenClassX(org.eclipse.emf.codegen.ecore.genmodel.GenFeature feature) { return org.eclipse.gmf.internal.codegen.util.GenModelUtils.getTypeGenClass(feature); }
}