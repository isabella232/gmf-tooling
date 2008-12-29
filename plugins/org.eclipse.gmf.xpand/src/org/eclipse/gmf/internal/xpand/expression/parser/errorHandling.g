-- this grammar include file overrides TokenStream#reportError()... methods to introduce 
-- better error handling than plain system.err dump
--
-- Depending on whether this file is being included into LexStream or PrsStream, following definition 
-- should be specified:
--		$tokenStartOffset
--		$tokenEndOffset
-- Definitions may access 'leftToken' and 'rightToken' variables (token indexes)

$Globals
	/.import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.gmf.internal.xpand.Activator;
import org.eclipse.gmf.internal.xpand.util.ParserException.ErrorLocationInfo;
./
$End

$Headers
	/.
		public ErrorLocationInfo[] getErrors() {
			return errors.toArray(new ErrorLocationInfo[errors.size()]);
		}

		private void resetErrors() {
			errors.clear();
		}

		private final List<ErrorLocationInfo> errors = new LinkedList<ErrorLocationInfo>();

		@Override
		public void reportError(int i, String code) {
			Activator.logWarn("Unexpected #reportError(int,String)");
			reportError(i, i);
		}

		@Override
		public void reportError(int leftToken, int rightToken) {
			final int errorCode = (rightToken >= getStreamLength() ? EOF_CODE : leftToken == rightToken ? LEX_ERROR_CODE : INVALID_TOKEN_CODE);
			final int endToken = (leftToken == rightToken ? rightToken : rightToken - 1);
			reportError(errorCode, null, leftToken, endToken, getName(leftToken));
		}

		@Override
		public void reportError(int errorCode, String locationInfo, String tokenText) {
			try {
				Matcher m = Pattern.compile("(?:[^:]+::)*[^:]+:(\\d+):(\\d+):(\\d+):(\\d+):.*").matcher(locationInfo);
				boolean t = m.matches(); // ignore return value, rely on exception if anything wrong
				assert t;
				final int leftTokenLine = Integer.parseInt(m.group(1));
				final int leftTokenColumn = Integer.parseInt(m.group(2));
				final int rightTokenLine = Integer.parseInt(m.group(3));
				final int rightTokenColumn = Integer.parseInt(m.group(4));
				final String msg = tokenText + errorMsgText[errorCode];
				errors.add(new ErrorLocationInfo(msg, leftTokenLine, leftTokenColumn, rightTokenLine, rightTokenColumn));
			} catch (Throwable ex) {
				// ignore
				errors.add(new ErrorLocationInfo(tokenText + errorMsgText[errorCode]));
			}
		}

		@Override
		public void reportError(int errorCode, String locationInfo, int leftToken, int rightToken, String tokenText) {
			final int leftTokenLine = getLine(leftToken);
			final int leftTokenColumn = getColumn(leftToken);
			final int rightTokenLine = getEndLine(rightToken);
			final int rightTokenColumn = getEndColumn(rightToken);
			final String msg = tokenText + errorMsgText[errorCode] + (locationInfo != null && locationInfo.length() > 0 ?  '(' + locationInfo + ')' : "");
			final int startOffset = $tokenStartOffset;
			final int endOffset = $tokenEndOffset;
			errors.add(new ErrorLocationInfo(msg, leftTokenLine, leftTokenColumn, rightTokenLine, rightTokenColumn, startOffset, endOffset));
		}
	./
$End