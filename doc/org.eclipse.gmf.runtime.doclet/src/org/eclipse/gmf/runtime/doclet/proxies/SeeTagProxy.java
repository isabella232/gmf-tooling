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
import com.sun.javadoc.MemberDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.SeeTag;


/**
 * Proxy to a SeeTag
 */

public class SeeTagProxy
	extends TagProxy
	implements SeeTag {

	public SeeTagProxy(SeeTag innerSeeTag) {
		super (innerSeeTag);
	}
	
	private SeeTag getInnerSeeTag() {
		return (SeeTag)getInnerObject();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.SeeTag#referencedClass()
	 */
	public ClassDoc referencedClass() {
		return FACTORY.createClassDocProxy(getInnerSeeTag().referencedClass());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.SeeTag#referencedMember()
	 */
	public MemberDoc referencedMember() {
		return FACTORY.createMemberDocProxy(getInnerSeeTag().referencedMember());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.SeeTag#referencedPackage()
	 */
	public PackageDoc referencedPackage() {
		return FACTORY.createPackageDocProxy(getInnerSeeTag().referencedPackage());
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.SeeTag#label()
	 */
	public String label() {
		return getInnerSeeTag().label();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.SeeTag#referencedClassName()
	 */
	public String referencedClassName() {
		return getInnerSeeTag().referencedClassName();
	}

	/* (non-Javadoc)
	 * @see com.sun.javadoc.SeeTag#referencedMemberName()
	 */
	public String referencedMemberName() {
		return getInnerSeeTag().referencedMemberName();
	}

}
