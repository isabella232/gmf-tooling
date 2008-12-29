import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
public class NativeUtil {
@Operation(contextual = false, kind = Kind.HELPER)
public static String messageFormat(String pattern, java.util.List<Object> argument) { return java.text.MessageFormat.format(pattern, argument.toArray(new Object[argument.size()])); }
}