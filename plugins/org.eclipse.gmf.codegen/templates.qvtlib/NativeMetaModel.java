import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
public class NativeMetaModel {
@Operation(contextual = false, kind = Kind.HELPER)
public static String getGetAccessor(org.eclipse.emf.codegen.ecore.genmodel.GenFeature gf) { return org.eclipse.gmf.internal.codegen.util.GenModelUtils.getGetAccessor(gf); }
@Operation(contextual = false, kind = Kind.HELPER)
public static String safeName(String name) { return org.eclipse.emf.codegen.util.CodeGenUtil.safeName(name); }
}