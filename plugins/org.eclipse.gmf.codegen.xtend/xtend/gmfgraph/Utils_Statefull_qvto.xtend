package gmfgraph

import java.util.List
import org.eclipse.gmf.gmfgraph.CustomBorder

/**
 * FIXME: @Singleton is ugly way to workaround the absence of FILE directive and QVTO properties.
 * Fortunately, it is the only place across all GMFT templates where those 2 features had been used
 */
@com.google.inject.Singleton class Utils_Statefull_qvto {
	
	private List<CustomBorder> myBordersInUse;

	private List<CharSequence> myStaticFieldsStream;

	def void addBorder(CustomBorder border) {
		myBordersInUse.add(border);
	}

	def void clearState() {
		myBordersInUse = <CustomBorder>newLinkedList();
		myStaticFieldsStream = <CharSequence>newLinkedList();
	}

	def Iterable<CustomBorder> getBordersInUse() {
		return myBordersInUse;
	}

	/**
	 * XXX [MG]: workaround for «FILE» directive is not supported in Xtend2
	 */
	def void addToStaticStream(CharSequence code) {
		if (code != null && code.length > 0) {
			myStaticFieldsStream.add(code);
		}
	}

	def Iterable<CharSequence> staticStream() {
		return myStaticFieldsStream;
	}

}
