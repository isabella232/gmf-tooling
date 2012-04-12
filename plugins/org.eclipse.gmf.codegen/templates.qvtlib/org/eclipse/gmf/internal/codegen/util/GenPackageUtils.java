package org.eclipse.gmf.internal.codegen.util;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;

public class GenPackageUtils {
	
	@Operation(contextual = false, kind = Kind.HELPER)
	public static  String getGenPackageQualifiedPackageInterfaceName(GenPackage genPackage)
	{
	  return genPackage.getQualifiedPackageInterfaceName();
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public String getGenPackageQualifiedFactoryInterfaceName(GenPackage genPackage)
	{
	  return genPackage.getQualifiedFactoryInterfaceName();
	}
	
	@Operation(contextual = false, kind = Kind.HELPER)
	public static  String getGenPackageQualifiedInterfaceName(GenClass genClass)
	{
	  return genClass.getQualifiedInterfaceName();
	}
	
	
}
