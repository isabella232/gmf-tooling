package xpt.navigator;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
public class NativeUtils {
@Operation(contextual = false, kind = Kind.HELPER)
public static String asValidJavaIdentifier(String identifier) { return org.eclipse.emf.codegen.util.CodeGenUtil.validJavaIdentifier(identifier); }
}