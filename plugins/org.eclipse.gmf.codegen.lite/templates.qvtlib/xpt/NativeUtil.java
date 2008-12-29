package xpt;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
public class NativeUtil {
@Operation(contextual = false, kind = Kind.HELPER)
public static String validJavaIdentifier(String s) { return org.eclipse.emf.codegen.util.CodeGenUtil.validJavaIdentifier(s); }
}