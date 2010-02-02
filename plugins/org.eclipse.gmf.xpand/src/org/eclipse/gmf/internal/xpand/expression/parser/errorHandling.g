-- this grammar include file overrides TokenStream#reportError()... methods to introduce 
-- better error handling than plain system.err dump
--
-- Depending on whether this file is being included into LexStream or PrsStream, following definition 
-- should be specified:
--		$tokenStartOffset
--		$tokenEndOffset
-- Definitions may access 'leftToken' and 'rightToken' variables (token indexes)

%Globals
	/.import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.gmf.internal.xpand.Activator;
import org.eclipse.gmf.internal.xpand.util.ParserException.ErrorLocationInfo;
./
%End

%Headers
	/.
		public ErrorLocationInfo[] getErrors() {
			return errors.toArray(new ErrorLocationInfo[errors.size()]);
		}

		private void resetErrors() {
			errors.clear();
		}

		private final List<ErrorLocationInfo> errors = new LinkedList<ErrorLocationInfo>();
		
		@Override
		public void reportError(int errorCode, int leftToken, int errorToken, int rightToken, String errorInfo[]) {
			StringBuilder sb = new StringBuilder("(");
			sb.append(errorCode);
			sb.append(") ");
			if (errorInfo != null) {
				for (int i = 0; i < errorInfo.length; i++) {
					if (sb.length() > 0) {
						sb.append("; ");
					}
					sb.append(errorInfo[i]);
				}
			}
			errors.add(new ErrorLocationInfo(sb.toString(), getLine(leftToken), getColumn(leftToken), getEndLine(rightToken), getEndColumn(rightToken)));
		}
	./
%End