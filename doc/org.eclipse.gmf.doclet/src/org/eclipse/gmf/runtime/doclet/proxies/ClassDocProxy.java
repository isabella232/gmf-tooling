/******************************************************************************
 * Copyright (c) 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.runtime.doclet.proxies;

import com.sun.javadoc.AnnotationDesc;
import com.sun.javadoc.AnnotationTypeDoc;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ConstructorDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.ParamTag;
import com.sun.javadoc.ParameterizedType;
import com.sun.javadoc.Type;
import com.sun.javadoc.TypeVariable;
import com.sun.javadoc.WildcardType;


/**
 * Proxy to a ClassDoc
 */
public class ClassDocProxy
	extends ProgramElementDocProxy
	implements ClassDoc {

	private Type type;
	
	public ClassDocProxy(ClassDoc innerClassDoc) {
		super (innerClassDoc);
		type = new TypeProxy(innerClassDoc);
	}
	
	private ClassDoc getInnerClassDoc() {
		return (ClassDoc)getInnerObject();
	}
	
	private Type getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#definesSerializableFields()
	 */
	public boolean definesSerializableFields() {
		return getInnerClassDoc().definesSerializableFields();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#isAbstract()
	 */
	public boolean isAbstract() {
		return getInnerClassDoc().isAbstract();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#isExternalizable()
	 */
	public boolean isExternalizable() {
		return getInnerClassDoc().isExternalizable();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#isSerializable()
	 */
	public boolean isSerializable() {
		return getInnerClassDoc().isSerializable();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#superclass()
	 */
	public ClassDoc superclass() {
		return FACTORY.createClassDocProxy(getInnerClassDoc().superclass());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#importedClasses()
	 */
	public ClassDoc[] importedClasses() {
		return FACTORY.createClassDocProxies(getInnerClassDoc().importedClasses());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#innerClasses()
	 */
	public ClassDoc[] innerClasses() {
		return FACTORY.createClassDocProxies(getInnerClassDoc().innerClasses());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#interfaces()
	 */
	public ClassDoc[] interfaces() {
		return FACTORY.createClassDocProxies(getInnerClassDoc().interfaces());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#subclassOf(com.sun.javadoc.ClassDoc)
	 */
	public boolean subclassOf(ClassDoc arg0) {
		return getInnerClassDoc().subclassOf((ClassDoc)ProxyUtil.getInnerObject(arg0));
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#innerClasses(boolean)
	 */
	public ClassDoc[] innerClasses(boolean arg0) {
		return getInnerClassDoc().innerClasses(arg0);
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#constructors()
	 */
	public ConstructorDoc[] constructors() {
		return FACTORY.createConstructorDocProxies(getInnerClassDoc().constructors());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#constructors(boolean)
	 */
	public ConstructorDoc[] constructors(boolean arg0) {
		return FACTORY.createConstructorDocProxies(getInnerClassDoc().constructors(arg0));
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#fields()
	 */
	public FieldDoc[] fields() {
		return FACTORY.createFieldDocProxies(getInnerClassDoc().fields());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#serializableFields()
	 */
	public FieldDoc[] serializableFields() {
		return FACTORY.createFieldDocProxies(getInnerClassDoc().serializableFields());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#fields(boolean)
	 */
	public FieldDoc[] fields(boolean arg0) {
		return FACTORY.createFieldDocProxies(getInnerClassDoc().fields(arg0));
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#methods()
	 */
	public MethodDoc[] methods() {
		return FACTORY.createMethodDocProxies(getInnerClassDoc().methods());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#serializationMethods()
	 */
	public MethodDoc[] serializationMethods() {
		return FACTORY.createMethodDocProxies(getInnerClassDoc().serializationMethods());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#methods(boolean)
	 */
	public MethodDoc[] methods(boolean arg0) {
		return FACTORY.createMethodDocProxies(getInnerClassDoc().methods(arg0));
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#importedPackages()
	 */
	public PackageDoc[] importedPackages() {
		return FACTORY.createPackageDocProxies(getInnerClassDoc().importedPackages());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.ClassDoc#findClass(java.lang.String)
	 */
	public ClassDoc findClass(String arg0) {
		return FACTORY.createClassDocProxy(getInnerClassDoc().findClass(arg0));
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.Type#asClassDoc()
	 */
	public ClassDoc asClassDoc() {
		return getType().asClassDoc();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.Type#dimension()
	 */
	public String dimension() {
		return getType().dimension();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.Type#qualifiedTypeName()
	 */
	public String qualifiedTypeName() {
		return getType().qualifiedTypeName();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.Type#typeName()
	 */
	public String typeName() {
		return getType().typeName();
	}

  public FieldDoc[] enumConstants()
  {
    return null;
  }

  public Type[] interfaceTypes()
  {
    return null;
  }

  public Type superclassType()
  {
    return null;
  }

  public ParamTag[] typeParamTags()
  {
    return null;
  }

  public TypeVariable[] typeParameters()
  {
    return null;
  }

  public AnnotationDesc[] annotations()
  {
    return null;
  }

  public boolean isAnnotationType()
  {
    return false;
  }

  public boolean isAnnotationTypeElement()
  {
    return false;
  }

  public boolean isEnum()
  {
    return false;
  }

  public boolean isEnumConstant()
  {
    return false;
  }

  public AnnotationTypeDoc asAnnotationTypeDoc()
  {
    return null;
  }

  public ParameterizedType asParameterizedType()
  {
    return null;
  }

  public TypeVariable asTypeVariable()
  {
    return null;
  }

  public WildcardType asWildcardType()
  {
    return null;
  }

  public boolean isPrimitive()
  {
    return false;
  }

  public String simpleTypeName()
  {
    return null;
  }

}
