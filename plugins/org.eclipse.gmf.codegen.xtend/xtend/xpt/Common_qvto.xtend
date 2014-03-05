package xpt

import java.util.regex.Pattern

@com.google.inject.Singleton class Common_qvto {

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
		qualifiedName.split(Pattern::quote(separator)).last;
	}

	def String withoutLastSegment(String qualifiedName, String separator) {
		var parts = qualifiedName.split(Pattern::quote(separator))
		return parts.take(parts.size - 1).join(separator)
	}
	
	def String substringAfter(String name, String prefix){
		if (!name.startsWith(prefix)){
			throw new IllegalArgumentException("String " + name + " does not startWith: " + prefix)
		}
		return name.substring(prefix.length);
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
