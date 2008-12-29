package xpt.providers;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
public class NativeMetrics {
@Operation(contextual = false, kind = Kind.HELPER)
public static String validJavaIdentifier(String identifier) { return org.eclipse.emf.codegen.util.CodeGenUtil.validJavaIdentifier(identifier); }
}