/*
 *+------------------------------------------------------------------------+
 *| Licensed Materials - Property of IBM                                   |
 *| (C) Copyright IBM Corp. 2005.  All Rights Reserved.                    |
 *|                                                                        |
 *| US Government Users Restricted Rights - Use, duplication or disclosure |
 *| restricted by GSA ADP Schedule Contract with IBM Corp.                 |
 *+------------------------------------------------------------------------+
 */
package org.eclipse.gmf.runtime.doclet.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.gmf.runtime.doclet.ITagDefinitions;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.ProgramElementDoc;
import com.sun.javadoc.RootDoc;
import com.sun.javadoc.Tag;

/**
 * Generator for all canBeSeenBy maps. Traverse all packages, classes, and members to find
 * @canbeSeenBy tags and records them in a map.
 */

public class MapsGenerator {

	private static final String NAMESPACE_SEPARATOR = ","; //$NON-NLS-1$

	private HashMap canBeSeenByMap = null;

	private RootDoc root;

	private AliasRegistry aliasRegistry;

	public MapsGenerator(RootDoc root, AliasRegistry aliasRegistry) {
		this.root = root;
		this.aliasRegistry = aliasRegistry;

		generateMaps();

		printMaps();
	}

	public HashMap getCanBeSeeByMap() {
		return this.canBeSeenByMap;
	}

	public AliasRegistry getAliasRegistry() {
		return this.aliasRegistry;
	}

	private void generateMaps() {

		this.canBeSeenByMap = new HashMap();

		if (root.classes() != null) {
			visitClassDocs(root.classes());
		}

		if (root.specifiedPackages() != null) {
			visitPackageDocs(root.specifiedPackages());
		}
	}

	private void visitClassDocs(ClassDoc classDocs[]) {
		for (int i = 0; i < classDocs.length; i++) {
			ClassDoc classDoc = classDocs[i];
			visitClassDoc(classDoc);
		}
	}

	private void visitClassDoc(ClassDoc classDoc) {

		addVisibilityRules(classDoc);

		addVisibilityRules(classDoc.constructors());

		addVisibilityRules(classDoc.methods());

		addVisibilityRules(classDoc.fields());

		visitClassDocs(classDoc.innerClasses());

		visitPackageDoc(classDoc.containingPackage());
	}

	private void visitPackageDocs(PackageDoc packageDocs[]) {
		for (int i = 0; i < packageDocs.length; i++) {
			PackageDoc packageDoc = packageDocs[i];
			visitPackageDoc(packageDoc);
		}
	}

	private void visitPackageDoc(PackageDoc packageDoc) {
		addVisibilityRules(packageDoc.tags(ITagDefinitions.TAG_CAN_BE_SEEN_BY),
			packageDoc.name());
	}

	private void addVisibilityRules(ProgramElementDoc programElementDocs[]) {
		for (int i = 0; i < programElementDocs.length; i++) {
			ProgramElementDoc programElementDoc = programElementDocs[i];
			addVisibilityRules(programElementDoc);
		}
	}

	private void addVisibilityRules(ProgramElementDoc programElementDoc) {
		addVisibilityRules(programElementDoc
			.tags(ITagDefinitions.TAG_CAN_BE_SEEN_BY), programElementDoc
			.qualifiedName());
	}

	private void addVisibilityRules(Tag canBeSeenByTags[], String qualifiedName) {

		for (int i = 0; i < canBeSeenByTags.length; i++) {
			Tag tag = canBeSeenByTags[i];
			addVisibilityRule(getCanBeSeeByMap(), qualifiedName, tag.text());
		}
	}

	private void addVisibilityRule(HashMap map, String qualifiedName,
			String allowedNamespace) {

		String aliasValue = getAliasRegistry().getAliasValue(allowedNamespace);
		if (aliasValue != null) {
			allowedNamespace = aliasValue;
		}

		String allowedNamespaces[] = allowedNamespace
			.split(NAMESPACE_SEPARATOR);
		
		for (int i = 0; i < allowedNamespaces.length; i++) {
			String singleNamespace = allowedNamespaces[i];

			Set existingAllowedNamespaces = (Set) map.get(qualifiedName);

			if (existingAllowedNamespaces == null) {
				existingAllowedNamespaces = new HashSet();
				map.put(qualifiedName, existingAllowedNamespaces);
			}

			existingAllowedNamespaces.add(singleNamespace);

		}

	}

	private void printMaps() {

		System.out.println();
		System.out
			.println("************************* START @canBeSeenBy Map ***************************"); //$NON-NLS-1$
		System.out.println();

		Set entries = getCanBeSeeByMap().entrySet();
		for (Iterator iterEntry = entries.iterator(); iterEntry.hasNext();) {
			Map.Entry entry = (Map.Entry) iterEntry.next();

			Set namespaces = (Set) entry.getValue();
			for (Iterator iterNamespace = namespaces.iterator(); iterNamespace
				.hasNext();) {
				String namespace = (String) iterNamespace.next();
				System.out.println((String) entry.getKey() + "\t->\t" + namespace); //$NON-NLS-1$
			}
		}

		System.out.println();
		System.out
			.println("************************* END @canBeSeenBy Map ***************************"); //$NON-NLS-1$
		System.out.println();
	}

}