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

package org.eclipse.gmf.doclet.proxies;


import java.util.ArrayList;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ConstructorDoc;
import com.sun.javadoc.Doc;
import com.sun.javadoc.ExecutableMemberDoc;
import com.sun.javadoc.FieldDoc;
import com.sun.javadoc.MemberDoc;
import com.sun.javadoc.MethodDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.ParamTag;
import com.sun.javadoc.Parameter;
import com.sun.javadoc.ProgramElementDoc;
import com.sun.javadoc.RootDoc;
import com.sun.javadoc.SeeTag;
import com.sun.javadoc.SerialFieldTag;
import com.sun.javadoc.Tag;
import com.sun.javadoc.ThrowsTag;
import com.sun.javadoc.Type;


/**
 * Factory for proxy objects. Generate proxies for Object, typed Object, or collection.
 * The factory is smart enough to always return the most derived proxy for a given element.
 * The factory will always return the same proxy for a given object to wrap.
 */

public class ProxyFactory
{

  private ProxyRegistry proxyRegistry = null;

  private static ProxyFactory instance = null;

  public static ProxyFactory getInstance()
  {
    if (instance == null)
    {
      instance = new ProxyFactory();
    }

    return instance;
  }

  /*
   * DocProxy Proxies
   */

  public DocProxy[] createDocProxies(Doc docs[])
  {

    ArrayList docProxies = new ArrayList();

    for (int i = 0; i < docs.length; i++)
    {
      Doc doc = docs[i];
      docProxies.add(createDocProxy(doc));
    }

    return (DocProxy[])docProxies.toArray(new DocProxy [0]);
  }

  public DocProxy createDocProxy(Object object)
  {
    DocProxy docProxy = null;

    if (object instanceof DocProxy)
    {
      docProxy = (DocProxy)object;
    }
    else
    {
      if (object instanceof Doc)
      {
        docProxy = createDocProxy((Doc)object);
      }
    }

    return docProxy;
  }

  public DocProxy createDocProxy(Doc doc)
  {

    DocProxy proxy = null;

    if (doc != null)
    {
      proxy = (DocProxy)getProxyRegistry().getProxyForObject(doc);
      if (proxy == null)
      {
        if (doc instanceof PackageDoc)
        {
          proxy = createPackageDocProxy((PackageDoc)doc);
        }
        else if (doc instanceof ProgramElementDoc)
        {
          proxy = createProgramElementDocProxy((ProgramElementDoc)doc);
        }
        else if (doc instanceof RootDoc)
        {
          proxy = createRootDocProxy((RootDoc)doc);
        }
        else
        {
          proxy = new DocProxy(doc);
          ProxyFactory.getInstance().getProxyRegistry().registerProxy(doc, proxy);
        }
      }
    }

    return proxy;
  }

  /*
   * PackageDoc Proxies
   */

  public PackageDocProxy[] createPackageDocProxies(PackageDoc packageDocs[])
  {

    ArrayList packageDocProxies = new ArrayList();

    for (int i = 0; i < packageDocs.length; i++)
    {
      PackageDoc packageDoc = packageDocs[i];
      packageDocProxies.add(createPackageDocProxy(packageDoc));
    }

    return (PackageDocProxy[])packageDocProxies.toArray(new PackageDocProxy [0]);
  }

  public PackageDocProxy createPackageDocProxy(Object object)
  {
    PackageDocProxy packageDocProxy = null;

    if (object instanceof PackageDocProxy)
    {
      packageDocProxy = (PackageDocProxy)object;
    }
    else
    {
      if (object instanceof PackageDoc)
      {
        packageDocProxy = createPackageDocProxy((PackageDoc)object);
      }
    }

    return packageDocProxy;
  }

  public PackageDocProxy createPackageDocProxy(PackageDoc packageDoc)
  {

    PackageDocProxy proxy = null;

    if (packageDoc != null)
    {
      proxy = (PackageDocProxy)getProxyRegistry().getProxyForObject(packageDoc);
      if (proxy == null)
      {
        proxy = new PackageDocProxy(packageDoc);
        ProxyFactory.getInstance().getProxyRegistry().registerProxy(packageDoc, proxy);
      }
    }

    return proxy;
  }

  /*
   * ProgramElementDocProxy Proxies
   */

  public ProgramElementDocProxy[] createProgramElementDocProxies(ProgramElementDoc programElementDocs[])
  {

    ArrayList programElementDocProxies = new ArrayList();

    for (int i = 0; i < programElementDocs.length; i++)
    {
      ProgramElementDoc programElementDoc = programElementDocs[i];
      programElementDocProxies.add(createProgramElementDocProxy(programElementDoc));
    }

    return (ProgramElementDocProxy[])programElementDocProxies.toArray(new ProgramElementDocProxy [0]);
  }

  public ProgramElementDocProxy createProgramElementDocProxy(Object object)
  {
    ProgramElementDocProxy programElementDocProxy = null;

    if (object instanceof ProgramElementDocProxy)
    {
      programElementDocProxy = (ProgramElementDocProxy)object;
    }
    else
    {
      if (object instanceof ProgramElementDoc)
      {
        programElementDocProxy = createProgramElementDocProxy((ProgramElementDoc)object);
      }
    }

    return programElementDocProxy;
  }

  public ProgramElementDocProxy createProgramElementDocProxy(ProgramElementDoc programElementDoc)
  {

    ProgramElementDocProxy proxy = null;

    if (programElementDoc != null)
    {
      proxy = (ProgramElementDocProxy)getProxyRegistry().getProxyForObject(programElementDoc);
      if (proxy == null)
      {
        if (programElementDoc instanceof ClassDoc)
        {
          proxy = createClassDocProxy((ClassDoc)programElementDoc);
        }
        else if (programElementDoc instanceof MemberDoc)
        {
          proxy = createMemberDocProxy((MemberDoc)programElementDoc);
        }
        else
        {
          proxy = new ProgramElementDocProxy(programElementDoc);
          ProxyFactory.getInstance().getProxyRegistry().registerProxy(programElementDoc, proxy);
        }
      }
    }

    return proxy;
  }

  /*
   * RootDoc Proxies
   */

  public RootDocProxy createRootDocProxy(Object object)
  {
    RootDocProxy rootDocProxy = null;

    if (object instanceof RootDocProxy)
    {
      rootDocProxy = (RootDocProxy)object;
    }
    else
    {
      if (object instanceof RootDoc)
      {
        rootDocProxy = createRootDocProxy((RootDoc)object);
      }
    }

    return rootDocProxy;
  }

  public RootDocProxy createRootDocProxy(RootDoc rootDoc)
  {

    RootDocProxy proxy = null;

    if (rootDoc != null)
    {
      proxy = (RootDocProxy)getProxyRegistry().getProxyForObject(rootDoc);
      if (proxy == null)
      {
        proxy = new RootDocProxy(rootDoc);
        ProxyFactory.getInstance().getProxyRegistry().registerProxy(rootDoc, proxy);
      }
    }

    return proxy;
  }

  /*
   * ClassDoc Proxies
   */

  public ClassDocProxy[] createClassDocProxies(ClassDoc classDocs[])
  {

    ArrayList classDocProxies = new ArrayList();

    for (int i = 0; i < classDocs.length; i++)
    {
      ClassDoc classDoc = classDocs[i];
      classDocProxies.add(createClassDocProxy(classDoc));
    }

    return (ClassDocProxy[])classDocProxies.toArray(new ClassDocProxy [0]);
  }

  public ClassDocProxy createClassDocProxy(Object object)
  {
    ClassDocProxy classDocProxy = null;

    if (object instanceof ClassDocProxy)
    {
      classDocProxy = (ClassDocProxy)object;
    }
    else
    {
      if (object instanceof ClassDoc)
      {
        classDocProxy = createClassDocProxy((ClassDoc)object);
      }
    }

    return classDocProxy;
  }

  public ClassDocProxy createClassDocProxy(ClassDoc classDoc)
  {

    ClassDocProxy proxy = null;

    if (classDoc != null)
    {
      proxy = (ClassDocProxy)getProxyRegistry().getProxyForObject(classDoc);
      if (proxy == null)
      {
        proxy = new ClassDocProxy(classDoc);
        ProxyFactory.getInstance().getProxyRegistry().registerProxy(classDoc, proxy);
      }
    }

    return proxy;
  }

  /*
   * MemberDoc Proxies
   */

  public MemberDocProxy[] createMemberDocProxies(MemberDoc memberDocs[])
  {

    ArrayList memberDocProxies = new ArrayList();

    for (int i = 0; i < memberDocs.length; i++)
    {
      MemberDoc memberDoc = memberDocs[i];
      memberDocProxies.add(createMemberDocProxy(memberDoc));
    }

    return (MemberDocProxy[])memberDocProxies.toArray(new MemberDocProxy [0]);
  }

  public MemberDocProxy createMemberDocProxy(Object object)
  {
    MemberDocProxy memberDocProxy = null;

    if (object instanceof MemberDocProxy)
    {
      memberDocProxy = (MemberDocProxy)object;
    }
    else
    {
      if (object instanceof MemberDoc)
      {
        memberDocProxy = createMemberDocProxy((MemberDoc)object);
      }
    }

    return memberDocProxy;
  }

  public MemberDocProxy createMemberDocProxy(MemberDoc memberDoc)
  {

    MemberDocProxy proxy = null;

    if (memberDoc != null)
    {
      proxy = (MemberDocProxy)getProxyRegistry().getProxyForObject(memberDoc);
      if (proxy == null)
      {
        if (memberDoc instanceof ExecutableMemberDoc)
        {
          proxy = createExecutableMemberDocProxy((ExecutableMemberDoc)memberDoc);
        }
        else if (memberDoc instanceof FieldDoc)
        {
          proxy = createFieldDocProxy((FieldDoc)memberDoc);
        }
        else
        {
          proxy = new MemberDocProxy(memberDoc);
          ProxyFactory.getInstance().getProxyRegistry().registerProxy(memberDoc, proxy);
        }
      }
    }

    return proxy;
  }

  /*
   * ExecutableMemberDoc Proxies
   */

  public ExecutableMemberDocProxy[] createExecutableMemberDocProxies(ExecutableMemberDoc executableMemberDocs[])
  {

    ArrayList executableMemberDocProxies = new ArrayList();

    for (int i = 0; i < executableMemberDocs.length; i++)
    {
      ExecutableMemberDoc executableMemberDoc = executableMemberDocs[i];
      executableMemberDocProxies.add(createExecutableMemberDocProxy(executableMemberDoc));
    }

    return (ExecutableMemberDocProxy[])executableMemberDocProxies.toArray(new ExecutableMemberDocProxy [0]);
  }

  public ExecutableMemberDocProxy createExecutableMemberDocProxy(Object object)
  {
    ExecutableMemberDocProxy executableMemberDocProxy = null;

    if (object instanceof ExecutableMemberDocProxy)
    {
      executableMemberDocProxy = (ExecutableMemberDocProxy)object;
    }
    else
    {
      if (object instanceof ExecutableMemberDoc)
      {
        executableMemberDocProxy = createExecutableMemberDocProxy((ExecutableMemberDoc)object);
      }
    }

    return executableMemberDocProxy;
  }

  public ExecutableMemberDocProxy createExecutableMemberDocProxy(ExecutableMemberDoc executableMemberDoc)
  {

    ExecutableMemberDocProxy proxy = null;

    if (executableMemberDoc != null)
    {
      proxy = (ExecutableMemberDocProxy)getProxyRegistry().getProxyForObject(executableMemberDoc);
      if (proxy == null)
      {
        if (executableMemberDoc instanceof ConstructorDoc)
        {
          proxy = createConstructorDocProxy((ConstructorDoc)executableMemberDoc);
        }
        else if (executableMemberDoc instanceof MethodDoc)
        {
          proxy = createMethodDocProxy((MethodDoc)executableMemberDoc);
        }
        else
        {
          proxy = new ExecutableMemberDocProxy(executableMemberDoc);
          ProxyFactory.getInstance().getProxyRegistry().registerProxy(executableMemberDoc, proxy);
        }
      }
    }

    return proxy;
  }

  /*
   * FieldDoc Proxies
   */

  public FieldDocProxy[] createFieldDocProxies(FieldDoc fieldDocs[])
  {

    ArrayList fieldDocProxies = new ArrayList();

    for (int i = 0; i < fieldDocs.length; i++)
    {
      FieldDoc fieldDoc = fieldDocs[i];
      fieldDocProxies.add(createFieldDocProxy(fieldDoc));
    }

    return (FieldDocProxy[])fieldDocProxies.toArray(new FieldDocProxy [0]);
  }

  public FieldDocProxy createFieldDocProxy(Object object)
  {
    FieldDocProxy fieldDocProxy = null;

    if (object instanceof FieldDocProxy)
    {
      fieldDocProxy = (FieldDocProxy)object;
    }
    else
    {
      if (object instanceof FieldDoc)
      {
        fieldDocProxy = createFieldDocProxy((FieldDoc)object);
      }
    }

    return fieldDocProxy;
  }

  public FieldDocProxy createFieldDocProxy(FieldDoc fieldDoc)
  {

    FieldDocProxy proxy = null;

    if (fieldDoc != null)
    {
      proxy = (FieldDocProxy)getProxyRegistry().getProxyForObject(fieldDoc);
      if (proxy == null)
      {
        proxy = new FieldDocProxy(fieldDoc);
        ProxyFactory.getInstance().getProxyRegistry().registerProxy(fieldDoc, proxy);
      }
    }

    return proxy;
  }

  /*
   * ContructorDoc Proxies
   */

  public ConstructorDocProxy[] createConstructorDocProxies(ConstructorDoc constructorDocs[])
  {

    ArrayList constructorDocProxies = new ArrayList();

    for (int i = 0; i < constructorDocs.length; i++)
    {
      ConstructorDoc constructorDoc = constructorDocs[i];
      constructorDocProxies.add(createConstructorDocProxy(constructorDoc));
    }

    return (ConstructorDocProxy[])constructorDocProxies.toArray(new ConstructorDocProxy [0]);
  }

  public ConstructorDocProxy createConstructorDocProxy(Object object)
  {
    ConstructorDocProxy constructorDocProxy = null;

    if (object instanceof ConstructorDocProxy)
    {
      constructorDocProxy = (ConstructorDocProxy)object;
    }
    else
    {
      if (object instanceof ConstructorDoc)
      {
        constructorDocProxy = createConstructorDocProxy((ConstructorDoc)object);
      }
    }

    return constructorDocProxy;
  }

  public ConstructorDocProxy createConstructorDocProxy(ConstructorDoc constructorDoc)
  {

    ConstructorDocProxy proxy = null;

    if (constructorDoc != null)
    {
      proxy = (ConstructorDocProxy)getProxyRegistry().getProxyForObject(constructorDoc);
      if (proxy == null)
      {
        proxy = new ConstructorDocProxy(constructorDoc);
        ProxyFactory.getInstance().getProxyRegistry().registerProxy(constructorDoc, proxy);
      }
    }

    return proxy;
  }

  /*
   * MethodDoc Proxies
   */

  public MethodDocProxy[] createMethodDocProxies(MethodDoc methodDocs[])
  {

    ArrayList methodDocProxies = new ArrayList();

    for (int i = 0; i < methodDocs.length; i++)
    {
      MethodDoc methodDoc = methodDocs[i];
      methodDocProxies.add(createMethodDocProxy(methodDoc));
    }

    return (MethodDocProxy[])methodDocProxies.toArray(new MethodDocProxy [0]);
  }

  public MethodDocProxy createMethodDocProxy(Object object)
  {
    MethodDocProxy methodDocProxy = null;

    if (object instanceof MethodDocProxy)
    {
      methodDocProxy = (MethodDocProxy)object;
    }
    else
    {
      if (object instanceof MethodDoc)
      {
        methodDocProxy = createMethodDocProxy((MethodDoc)object);
      }
    }

    return methodDocProxy;
  }

  public MethodDocProxy createMethodDocProxy(MethodDoc methodDoc)
  {

    MethodDocProxy proxy = null;

    if (methodDoc != null)
    {
      proxy = (MethodDocProxy)getProxyRegistry().getProxyForObject(methodDoc);
      if (proxy == null)
      {
        proxy = new MethodDocProxy(methodDoc);
        ProxyFactory.getInstance().getProxyRegistry().registerProxy(methodDoc, proxy);
      }
    }

    return proxy;
  }

  /*
   * Parameter Proxies
   */

  public ParameterProxy[] createParameterProxies(Parameter parameters[])
  {

    ArrayList parameterProxies = new ArrayList();

    for (int i = 0; i < parameters.length; i++)
    {
      Parameter parameter = parameters[i];
      parameterProxies.add(createParameterProxy(parameter));
    }

    return (ParameterProxy[])parameterProxies.toArray(new ParameterProxy [0]);
  }

  public ParameterProxy createParameterProxy(Object object)
  {
    ParameterProxy parameterProxy = null;

    if (object instanceof ParameterProxy)
    {
      parameterProxy = (ParameterProxy)object;
    }
    else
    {
      if (object instanceof Parameter)
      {
        parameterProxy = createParameterProxy((Parameter)object);
      }
    }

    return parameterProxy;
  }

  public ParameterProxy createParameterProxy(Parameter parameter)
  {

    ParameterProxy proxy = null;

    if (parameter != null)
    {
      proxy = (ParameterProxy)getProxyRegistry().getProxyForObject(parameter);
      if (proxy == null)
      {
        proxy = new ParameterProxy(parameter);
        ProxyFactory.getInstance().getProxyRegistry().registerProxy(parameter, proxy);
      }
    }

    return proxy;
  }

  /*
   * Type Proxies
   */

  public Proxy[] createTypeProxies(Type types[])
  {

    ArrayList typeProxies = new ArrayList();

    for (int i = 0; i < types.length; i++)
    {
      Type type = types[i];
      typeProxies.add(createTypeProxy(type));
    }

    return (Proxy[])typeProxies.toArray(new Proxy [0]);
  }

  public Proxy createTypeProxy(Object object)
  {
    Proxy typeProxy = null;

    if (object instanceof TypeProxy)
    {
      typeProxy = (TypeProxy)object;
    }
    else
    {
      if (object instanceof Type)
      {
        typeProxy = createTypeProxy((Type)object);
      }
    }

    return typeProxy;
  }

  public Proxy createTypeProxy(Type type)
  {

    Proxy proxy = null;

    if (type != null)
    {
      proxy = getProxyRegistry().getProxyForObject(type);
      if (proxy == null)
      {
        if (type instanceof ClassDoc)
        {
          proxy = new ClassDocProxy((ClassDoc)type);
        }
        else
        {
          proxy = new TypeProxy(type);
        }
        ProxyFactory.getInstance().getProxyRegistry().registerProxy(type, proxy);
      }
    }

    return proxy;
  }

  /*
   * Tag Proxies
   */

  public TagProxy[] createTagProxies(Tag tags[])
  {

    ArrayList tagProxies = new ArrayList();

    for (int i = 0; i < tags.length; i++)
    {
      Tag tag = tags[i];
      tagProxies.add(createTagProxy(tag));
    }

    return (TagProxy[])tagProxies.toArray(new TagProxy [0]);
  }

  public TagProxy createTagProxy(Object object)
  {
    TagProxy tagProxy = null;

    if (object instanceof TagProxy)
    {
      tagProxy = (TagProxy)object;
    }
    else
    {
      if (object instanceof Tag)
      {
        tagProxy = createTagProxy((Tag)object);
      }
    }

    return tagProxy;
  }

  public TagProxy createTagProxy(Tag tag)
  {

    TagProxy proxy = null;

    if (tag != null)
    {
      proxy = (TagProxy)getProxyRegistry().getProxyForObject(tag);
      if (proxy == null)
      {
        if (tag instanceof ParamTag)
        {
          proxy = createParamTagProxy((ParamTag)tag);
        }
        else if (tag instanceof SeeTag)
        {
          proxy = createSeeTagProxy((SeeTag)tag);
        }
        else if (tag instanceof SerialFieldTag)
        {
          proxy = createSerialFieldTagProxy((SerialFieldTag)tag);
        }
        else if (tag instanceof ThrowsTag)
        {
          proxy = createThrowsTagProxy((ThrowsTag)tag);
        }
        else
        {
          proxy = new TagProxy(tag);
        }

        ProxyFactory.getInstance().getProxyRegistry().registerProxy(tag, proxy);
      }
    }

    return proxy;
  }

  /*
   * ParamTag Proxies
   */

  public ParamTagProxy[] createParamTagProxies(ParamTag paramTags[])
  {

    ArrayList paramTagProxies = new ArrayList();

    for (int i = 0; i < paramTags.length; i++)
    {
      ParamTag paramTag = paramTags[i];
      paramTagProxies.add(createParamTagProxy(paramTag));
    }

    return (ParamTagProxy[])paramTagProxies.toArray(new ParamTagProxy [0]);
  }

  public ParamTagProxy createParamTagProxy(Object object)
  {
    ParamTagProxy paramTagProxy = null;

    if (object instanceof ParamTagProxy)
    {
      paramTagProxy = (ParamTagProxy)object;
    }
    else
    {
      if (object instanceof ParamTag)
      {
        paramTagProxy = createParamTagProxy((ParamTag)object);
      }
    }

    return paramTagProxy;
  }

  public ParamTagProxy createParamTagProxy(ParamTag paramTag)
  {

    ParamTagProxy proxy = null;

    if (paramTag != null)
    {
      proxy = (ParamTagProxy)getProxyRegistry().getProxyForObject(paramTag);
      if (proxy == null)
      {
        proxy = new ParamTagProxy(paramTag);
        ProxyFactory.getInstance().getProxyRegistry().registerProxy(paramTag, proxy);
      }
    }

    return proxy;
  }

  /*
   * SeeTag Proxies
   */

  public SeeTagProxy[] createSeeTagProxies(SeeTag seeTags[])
  {

    ArrayList seeTagProxies = new ArrayList();

    for (int i = 0; i < seeTags.length; i++)
    {
      SeeTag seeTag = seeTags[i];
      seeTagProxies.add(createSeeTagProxy(seeTag));
    }

    return (SeeTagProxy[])seeTagProxies.toArray(new SeeTagProxy [0]);
  }

  public SeeTagProxy createSeeTagProxy(Object object)
  {
    SeeTagProxy seeTagProxy = null;

    if (object instanceof SeeTagProxy)
    {
      seeTagProxy = (SeeTagProxy)object;
    }
    else
    {
      if (object instanceof SeeTag)
      {
        seeTagProxy = createSeeTagProxy((SeeTag)object);
      }
    }

    return seeTagProxy;
  }

  public SeeTagProxy createSeeTagProxy(SeeTag seeTag)
  {

    SeeTagProxy proxy = null;

    if (seeTag != null)
    {
      proxy = (SeeTagProxy)getProxyRegistry().getProxyForObject(seeTag);
      if (proxy == null)
      {
        proxy = new SeeTagProxy(seeTag);
        ProxyFactory.getInstance().getProxyRegistry().registerProxy(seeTag, proxy);
      }
    }

    return proxy;
  }

  /*
   * ThrowsTag Proxies
   */

  public ThrowsTagProxy[] createThrowsTagProxies(ThrowsTag throwsTags[])
  {

    ArrayList throwsTagProxies = new ArrayList();

    for (int i = 0; i < throwsTags.length; i++)
    {
      ThrowsTag throwsTag = throwsTags[i];
      throwsTagProxies.add(createThrowsTagProxy(throwsTag));
    }

    return (ThrowsTagProxy[])throwsTagProxies.toArray(new ThrowsTagProxy [0]);
  }

  public ThrowsTagProxy createThrowsTagProxy(Object object)
  {
    ThrowsTagProxy throwsTagProxy = null;

    if (object instanceof ThrowsTagProxy)
    {
      throwsTagProxy = (ThrowsTagProxy)object;
    }
    else
    {
      if (object instanceof ThrowsTag)
      {
        throwsTagProxy = createThrowsTagProxy((ThrowsTag)object);
      }
    }

    return throwsTagProxy;
  }

  public ThrowsTagProxy createThrowsTagProxy(ThrowsTag throwsTag)
  {

    ThrowsTagProxy proxy = null;

    if (throwsTag != null)
    {
      proxy = (ThrowsTagProxy)getProxyRegistry().getProxyForObject(throwsTag);
      if (proxy == null)
      {
        proxy = new ThrowsTagProxy(throwsTag);
        ProxyFactory.getInstance().getProxyRegistry().registerProxy(throwsTag, proxy);
      }
    }

    return proxy;
  }

  /*
   * SerialFieldTag Proxies
   */

  public SerialFieldTagProxy[] createSerialFieldTagProxies(SerialFieldTag serialFieldTags[])
  {

    ArrayList serialFieldTagProxies = new ArrayList();

    for (int i = 0; i < serialFieldTags.length; i++)
    {
      SerialFieldTag serialFieldTag = serialFieldTags[i];
      serialFieldTagProxies.add(createSerialFieldTagProxy(serialFieldTag));
    }

    return (SerialFieldTagProxy[])serialFieldTagProxies.toArray(new SerialFieldTagProxy [0]);
  }

  public SerialFieldTagProxy createSerialFieldTagProxy(Object object)
  {
    SerialFieldTagProxy serialFieldTagProxy = null;

    if (object instanceof SerialFieldTagProxy)
    {
      serialFieldTagProxy = (SerialFieldTagProxy)object;
    }
    else
    {
      if (object instanceof SerialFieldTag)
      {
        serialFieldTagProxy = createSerialFieldTagProxy((SerialFieldTag)object);
      }
    }

    return serialFieldTagProxy;
  }

  public SerialFieldTagProxy createSerialFieldTagProxy(SerialFieldTag serialFieldTag)
  {

    SerialFieldTagProxy proxy = null;

    if (serialFieldTag != null)
    {
      proxy = (SerialFieldTagProxy)getProxyRegistry().getProxyForObject(serialFieldTag);
      if (proxy == null)
      {
        proxy = new SerialFieldTagProxy(serialFieldTag);
        ProxyFactory.getInstance().getProxyRegistry().registerProxy(serialFieldTag, proxy);
      }
    }

    return proxy;
  }

  private ProxyFactory()
  {
    proxyRegistry = new ProxyRegistry();
  }

  /* package */ProxyRegistry getProxyRegistry()
  {
    return proxyRegistry;
  }
}