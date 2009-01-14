/*
 * Copyright (c) 2007, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     bblajer - initial API and implementation
 *     Artem Tikhomirov (Borland) - Migration to OCL expressions
 */
package org.eclipse.gmf.tests.xpand;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.BufferOutput;
import org.eclipse.gmf.internal.xpand.model.AmbiguousDefinitionException;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.ExecutionContextImpl;
import org.eclipse.gmf.internal.xpand.model.Scope;
import org.eclipse.gmf.internal.xpand.model.Variable;
import org.eclipse.gmf.internal.xpand.model.XpandDefinition;
import org.eclipse.gmf.internal.xpand.util.ParserException;
import org.eclipse.gmf.internal.xpand.util.ResourceManagerImpl;
import org.eclipse.gmf.internal.xpand.util.TypeNameUtil;

public class CompositeResourcesTest extends TestCase {
	private ExecutionContext myContext;
	private StringBuilder myBuffer;
	private TestResourceManager myResourceManager;
	private EClassifier oclStringType;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		myBuffer = new StringBuilder();
		myResourceManager = new TestResourceManager();
		myContext = new ExecutionContextImpl(new Scope(myResourceManager, null, new BufferOutput(myBuffer)));
		oclStringType = myContext.getOCLEnvironment().getOCLStandardLibrary().getString();
		myContext = myContext.cloneWithVariable(new Variable("this", oclStringType, ""));
	}

	/**
	 * Tests that DEFINE statements are effectively the same as AROUND without targetDef.proceed()
	 * @throws AmbiguousDefinitionException 
	 */
	public void testRedefineInAspect() throws AmbiguousDefinitionException {
		myResourceManager.setPrefixes((String) null);
		XpandDefinition definition = myContext.findDefinition(qualify("Overridable::testRedefineInAspect"), oclStringType, new EClassifier[0]);
		definition.evaluate(myContext);
		assertEquals("testRedefineOriginal", myBuffer.toString());
		myBuffer.delete(0, myBuffer.length());
		myResourceManager.setPrefixes("override2", null);
		definition = myContext.findDefinition(qualify("Overridable::testRedefineInAspect"), oclStringType, new EClassifier[0]);
		definition.evaluate(myContext);
		assertEquals("testRedefineRedefined", myBuffer.toString());
	}

	public void testOverrideXpand() throws AmbiguousDefinitionException {
		myResourceManager.setPrefixes((String) null);
		XpandDefinition definition = myContext.findDefinition(qualify("Overridable::test2"), oclStringType, new EClassifier[0]);
		definition.evaluate(myContext);
		assertEquals("<test4>", myBuffer.toString());
		myBuffer.delete(0, myBuffer.length());
		myResourceManager.setPrefixes("override3", null);
		definition = myContext.findDefinition(qualify("Overridable::test2"), oclStringType, new EClassifier[0]);
		definition.evaluate(myContext);
		assertEquals("<test3>", myBuffer.toString());
	}

	private static String qualify(String unqualified) {
        return "org::eclipse::gmf::tests::xpand::evaluate::" + unqualified;
    }

    private static class TestResourceManager extends ResourceManagerImpl {
		private String[] mySuffixes;
		public void setPrefixes(String... prefixes) {
			mySuffixes = prefixes;
			forgetAll();
		}
		@Override
		protected boolean shouldCache() {
			return true;
		}
		@Override
		protected String getAspectsTemplateName(String fullyQualifiedName) {
			return fullyQualifiedName + "_Aspects";
		}
		@Override
		protected Reader[] resolveMultiple(String fullyQualifiedName, String extension) throws IOException {
			ArrayList<Reader> result = new ArrayList<Reader>(mySuffixes.length);
			for (int i = 0; i < mySuffixes.length; i++) {
				String templateName = TypeNameUtil.getLastSegment(fullyQualifiedName) + "." + extension;
				String path = TypeNameUtil.withoutLastSegment(fullyQualifiedName).replaceAll(TypeNameUtil.NS_DELIM, "/");
				if (mySuffixes[i] != null && mySuffixes[i].length() > 0) {
					path += "/" + mySuffixes[i];
				}
				path += "/" + templateName;
				Reader reader = getReader(path);
				if (reader != null) {
					result.add(reader);
				}
			}
			if (result.isEmpty()) {
				throw new FileNotFoundException();
			}
			return result.toArray(new Reader[result.size()]);
		}
		protected Reader getReader(String path) {
			InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(path);
			if (resourceAsStream == null) {
				return null;
			}
			return new InputStreamReader(resourceAsStream, Charset.forName("ISO-8859-1"));
		}
		@Override
		protected void handleParserException(ParserException ex) {
			fail(ex.getClass().getName());
		}

		@Override
		protected String resolveCFileFullPath(String fullyQualifiedName, String fileExtension) {
			return fullyQualifiedName + "." + fileExtension;
		}
	}
}
