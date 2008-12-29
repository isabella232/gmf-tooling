package xpt;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
public class NativeEMFUtils {
@Operation(contextual = false, kind = Kind.HELPER)
public static java.util.List<org.eclipse.emf.ecore.EObject> getReferencingObjects(org.eclipse.emf.ecore.EObject target) { return org.eclipse.ocl.util.CollectionUtil.<org.eclipse.emf.ecore.EObject> createNewSequence(org.eclipse.gmf.internal.codegen.util.EmfUtils.getReferencingObjects(target)); }
@Operation(contextual = false, kind = Kind.HELPER)
public static String toStringLiteral(String strValue) { return org.eclipse.gmf.internal.codegen.util.EmfUtils.toStringLiteral(strValue); }
}