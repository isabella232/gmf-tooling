package xpt

class Common_qvto {

	def oclIsKindOf(Object obj, Class<?> clazz) {
		return obj != null && clazz.isInstance(obj);
	}

	def String lastSegment(String qualifiedName) {
		lastSegment(qualifiedName, ".")
	}

	def String withoutLastSegment(String qualifiedName) {
		withoutLastSegment(qualifiedName, ".")
	}

	def String lastSegment(String qualifiedName, String separator) {
		qualifiedName.split(separator).last;
	}

	def String withoutLastSegment(String qualifiedName, String separator) {
		var parts = qualifiedName.split(separator);
		parts.remove(parts.size - 1)
		return parts.join(separator)
	}

	def ERROR(String msg) {
		throw new IllegalStateException(msg)
	}
	
	def <T> T notNullOf(T a, T b) {
		if (a != null) a else b 
	}
	
	def boolean nullOrSpaces(String text) {
		return text == null || text.trim().length == 0
	}
	
	def <T> boolean notEmpty(Iterable<T> collection) {
		return !collection.empty;
	}

}
