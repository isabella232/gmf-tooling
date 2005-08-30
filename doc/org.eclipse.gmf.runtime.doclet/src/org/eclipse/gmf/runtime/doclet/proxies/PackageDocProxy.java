/*
 *+------------------------------------------------------------------------+
 *| Licensed Materials - Property of IBM                                   |
 *| (C) Copyright IBM Corp. 2005.  All Rights Reserved.                    |
 *|                                                                        |
 *| US Government Users Restricted Rights - Use, duplication or disclosure |
 *| restricted by GSA ADP Schedule Contract with IBM Corp.                 |
 *+------------------------------------------------------------------------+
 */
package org.eclipse.gmf.runtime.doclet.proxies;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.PackageDoc;


/**
 * Proxy to a PackageDoc
 */

public class PackageDocProxy
	extends DocProxy
	implements PackageDoc {

	public PackageDocProxy(PackageDoc innerPackageDoc) {
		super (innerPackageDoc);
	}
	
	private PackageDoc getInnerPackageDoc() {
		return (PackageDoc)getInnerObject();
	}


	/* (non-Javadoc)
	 * @see com.sun.javadoc.PackageDoc#allClasses()
	 */
	public ClassDoc[] allClasses() {
		return ProxyFactory.getInstance().createClassDocProxies(getInnerPackageDoc().allClasses());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.PackageDoc#errors()
	 */
	public ClassDoc[] errors() {
		return ProxyFactory.getInstance().createClassDocProxies(getInnerPackageDoc().errors());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.PackageDoc#exceptions()
	 */
	public ClassDoc[] exceptions() {
		return ProxyFactory.getInstance().createClassDocProxies(getInnerPackageDoc().exceptions());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.PackageDoc#interfaces()
	 */
	public ClassDoc[] interfaces() {
		return ProxyFactory.getInstance().createClassDocProxies(getInnerPackageDoc().interfaces());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.PackageDoc#ordinaryClasses()
	 */
	public ClassDoc[] ordinaryClasses() {
		return ProxyFactory.getInstance().createClassDocProxies(getInnerPackageDoc().ordinaryClasses());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.PackageDoc#allClasses(boolean)
	 */
	public ClassDoc[] allClasses(boolean arg0) {
		return ProxyFactory.getInstance().createClassDocProxies(getInnerPackageDoc().allClasses(arg0));
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.PackageDoc#findClass(java.lang.String)
	 */
	public ClassDoc findClass(String arg0) {
		return ProxyFactory.getInstance().createClassDocProxy(getInnerPackageDoc().findClass(arg0));
	}

}
