package org.eclipse.gmf.codegen.util;

import java.util.Iterator;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.codegen.util.ImportManager;

/**
 * Copy of GenModelImpl functionality
 */
public class ImportUtil {
	private final ImportManager myImportManager;

	private StringBuffer importStringBuffer;

	private int importInsertionPoint;

	public ImportUtil(String compilationUnitPackage) {
		myImportManager = new ImportManager(compilationUnitPackage);
	}

	public void markImportLocation(StringBuffer stringBuffer, GenPackage genPackage) {
		markImportLocation(stringBuffer);
		myImportManager.addJavaLangImports(genPackage.getJavaLangConflicts());
	}

	public void markImportLocation(StringBuffer stringBuffer) {
		importStringBuffer = stringBuffer;
		importInsertionPoint = stringBuffer.length();
		myImportManager.addCompilationUnitImports(stringBuffer.toString());
	}

	public void emitSortedImports() {
		String NL = System.getProperties().getProperty("line.separator");
		StringBuffer importsBuf = new StringBuffer();

		String previousPackageName = null;
		for (Iterator iter = myImportManager.getImports().iterator(); iter.hasNext();) {
			String importName = (String) iter.next();
			int index = importName.lastIndexOf(".");
			if (index != -1) {
				String packageName = importName.substring(0, index);
				if (previousPackageName != null && !previousPackageName.equals(packageName)) {
					importsBuf.append(NL);
				}
				previousPackageName = packageName;
			}
			importsBuf.append(NL + "import " + importName + ";");
		}

		importStringBuffer.insert(importInsertionPoint, importsBuf);
	}

	// one from GenModelImpl
	public String getImportedName(String qualifiedName) {
		int index = qualifiedName.indexOf("$");
		myImportManager.addImport(index == -1 ? qualifiedName : qualifiedName.substring(0, index));
		return myImportManager.getImportedName(qualifiedName);
	}

	public void addImport(String qualifiedName) {
		myImportManager.addImport(qualifiedName);
	}

	public void addImport(String packageName, String shortName) {
		myImportManager.addImport(packageName, shortName);
	}
}
