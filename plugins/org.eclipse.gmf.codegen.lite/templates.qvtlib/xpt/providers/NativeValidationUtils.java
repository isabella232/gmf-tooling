package xpt.providers;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
public class NativeValidationUtils {
@Operation(contextual = false, kind = Kind.HELPER)
public static String toStringLiteral(String strValue) { return org.eclipse.gmf.internal.common.codegen.Conversions.toStringLiteral(strValue); }
}