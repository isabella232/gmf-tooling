package xpt;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
public class NativeGenAuditRoot {
@Operation(contextual = false, kind = Kind.HELPER)
public static String escapeXML(String s) { return org.eclipse.gmf.internal.common.codegen.Conversions.escapeXML(s); }
}