/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Anna Karjakina (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.gen;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.internal.common.codegen.OrganizeImportsPostprocessor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Name;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

public class OrganizeImportsPostprocessorTest extends TestCase {

    private static final String nl = System.getProperty("line.separator");

    public void testFullQualifiedFields() throws Exception {
        String className = "TestFullQualifiedFields";
        String[] fieldTypes = new String[] { List.class.getName(), RectangleFigure.class.getName(), getInnerClassAwareName(Map.Entry.class), Map.class.getName(), getInnerClassAwareName(Iterator.class)+"_eINSTANCE" };
        String code = generateClassCode(className, null, null, null, fieldTypes, null, null, null, null);
        ICompilationUnit icu = JavaProjectHelper.createJavaFile(className+".java", code);
        
        OrganizeImportsPostprocessor processor = new OrganizeImportsPostprocessor();
        processor.organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        final List<String> fieldList = new ArrayList<String>(fieldTypes.length);
        
        assertEquals("Failed to generate enough import statements", fieldTypes.length, imports.size());
        fieldList.clear();
        fieldList.addAll(Arrays.asList(fieldTypes));
        for (Iterator it=imports.iterator(); it.hasNext();) {
            String nextImport = ((ImportDeclaration) it.next()).getName().getFullyQualifiedName();
            assertTrue("Unexpected import found: "+nextImport, fieldList.remove(nextImport));
        }
        assertTrue("Failed to generate import for "+fieldList.size()+" more types", fieldList.isEmpty());
        
        fieldList.clear();
        fieldList.addAll(Arrays.asList(fieldTypes));
        cu.accept(new ASTVisitor(){
            public boolean visit(FieldDeclaration node) {
                node.getType().accept(new ExpectedSimpleNamesVisitor(fieldList));
                return super.visit(node);
            }
        });
        assertTrue("Failed to find references for "+fieldList.size()+" more types", fieldList.isEmpty());
    }
    
    public void testFullQualifiedMethodParams() throws Exception {
        String className = "TestFullQualifiedMethodParams";
        String[] methodParams = new String[] { List.class.getName(), RectangleFigure.class.getName(), getInnerClassAwareName(Map.Entry.class), Map.class.getName() };
        String code = generateClassCode(className, null, null, null, null, methodParams, null, null, null);
        ICompilationUnit icu = JavaProjectHelper.createJavaFile(className+".java", code);
        
        OrganizeImportsPostprocessor processor = new OrganizeImportsPostprocessor();
        processor.organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        final List<String> methodsList = new ArrayList<String>();
        
        assertEquals("Failed to generate enough import statements", methodParams.length, imports.size());
        methodsList.addAll(Arrays.asList(methodParams));
        for (Iterator it=imports.iterator(); it.hasNext();) {
            String nextImport = ((ImportDeclaration) it.next()).getName().getFullyQualifiedName();
            assertTrue("Unexpected import found: "+nextImport, methodsList.remove(nextImport));
        }
        assertTrue("Failed to generate import for "+methodsList.size()+" more types", methodsList.isEmpty());

        methodsList.clear();
        methodsList.addAll(Arrays.asList(methodParams));
        cu.accept(new ASTVisitor(){
            public boolean visit(MethodDeclaration node) {
                for (Iterator it = node.parameters().iterator(); it.hasNext();) {
                    SingleVariableDeclaration next = (SingleVariableDeclaration) it.next();
                    next.getType().accept(new ExpectedSimpleNamesVisitor(methodsList));
                }
                return super.visit(node);
            }
        });
        assertTrue("Failed to find references for "+methodsList.size()+" more types", methodsList.isEmpty());
    }
    
    public void testFullQualifiedMethodExceptions() throws Exception {
        String className = "TestFullQualifiedMethodExceptions";
        String[] methodExceptions = new String[] { List.class.getName(), RectangleFigure.class.getName(), getInnerClassAwareName(Map.Entry.class), Map.class.getName(), "org.eclipse.core.commands.ExecutionException" };
        String code = generateClassCode(className, null, null, null, null, null, null, null, methodExceptions);
        ICompilationUnit icu = JavaProjectHelper.createJavaFile(className+".java", code);
        
        OrganizeImportsPostprocessor processor = new OrganizeImportsPostprocessor();
        processor.organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        final List<String> exceptionsList = new ArrayList<String>();
        
        assertEquals("Failed to generate enough import statements", methodExceptions.length, imports.size());
        exceptionsList.addAll(Arrays.asList(methodExceptions));
        for (Iterator it=imports.iterator(); it.hasNext();) {
            String nextImport = ((ImportDeclaration) it.next()).getName().getFullyQualifiedName();
            assertTrue("Unexpected import found: "+nextImport, exceptionsList.remove(nextImport));
        }
        assertTrue("Failed to generate import for "+exceptionsList.size()+" more types", exceptionsList.isEmpty());

        exceptionsList.clear();
        exceptionsList.addAll(Arrays.asList(methodExceptions));
        cu.accept(new ASTVisitor(){
            public boolean visit(MethodDeclaration node) {
                for (Iterator it = node.thrownExceptions().iterator(); it.hasNext();) {
                    Name next = (Name) it.next();
                    next.accept(new ExpectedSimpleNamesVisitor(exceptionsList));
                }
                return super.visit(node);
            }
        });
        assertTrue("Failed to find references for "+exceptionsList.size()+" more types", exceptionsList.isEmpty());
        
        exceptionsList.clear();
        exceptionsList.addAll(Arrays.asList(methodExceptions));
        cu.accept(new ASTVisitor(){
            public boolean visit(MethodDeclaration node) {
                node.getBody().accept(new ASTVisitor() {
                    public boolean visit(ThrowStatement node) {
                        node.getExpression().accept(new ExpectedSimpleNamesVisitor(exceptionsList));
                        return super.visit(node);
                    }
                });
                return super.visit(node);
            }
        });
        
        assertTrue("Failed to find references for "+exceptionsList.size()+" more types", exceptionsList.isEmpty());
    }
    
    public void testFullQualifiedLocalVariables() throws Exception {
        String className = "TestFullQualifiedLocalVariables";
        String[] localVars = new String[] { List.class.getName(), RectangleFigure.class.getName(), getInnerClassAwareName(Map.Entry.class), Map.class.getName() };
        String code = generateClassCode(className, null, null, null, null, null, null, localVars, null);
        ICompilationUnit icu = JavaProjectHelper.createJavaFile(className+".java", code);
        
        OrganizeImportsPostprocessor processor = new OrganizeImportsPostprocessor();
        processor.organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        final List<String> varsList = new ArrayList<String>(localVars.length);
        
        assertEquals("Failed to generate enough import statements", localVars.length, imports.size());
        varsList.addAll(Arrays.asList(localVars));
        for (Iterator it=imports.iterator(); it.hasNext();) {
            String nextImport = ((ImportDeclaration) it.next()).getName().getFullyQualifiedName();
            assertTrue("Unexpected import found: "+nextImport, varsList.remove(nextImport));
        }
        assertTrue("Failed to generate import for "+varsList.size()+" more types", varsList.isEmpty());
        
        varsList.clear();
        varsList.addAll(Arrays.asList(localVars));
        cu.accept(new ASTVisitor(){
            public boolean visit(MethodDeclaration node) {
                node.getBody().accept(new ASTVisitor() {
                    public boolean visit(VariableDeclarationStatement node) {
                        node.getType().accept(new ExpectedSimpleNamesVisitor(varsList));
                        return super.visit(node);
                    }
                });
                return super.visit(node);
            }
        });
        assertTrue("Failed to find references for "+varsList.size()+" more types", varsList.isEmpty());
    }
    
    public void testFullQualifiedSupers() throws Exception {
        String className = "TestFullQualifiedSupers";
        String superClass = RectangleFigure.class.getName();
        String[] superInterfaces = new String[] { Collection.class.getName(), Iterator.class.getName() };
        String code = generateClassCode(className, null, superClass, superInterfaces, null, null, null, null, null);
        ICompilationUnit icu = JavaProjectHelper.createJavaFile(className+".java", code);
        
        OrganizeImportsPostprocessor processor = new OrganizeImportsPostprocessor();
        processor.organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        final List<String> supersList = new ArrayList<String>(superInterfaces.length+1);
        
        assertEquals("Failed to generate enough import statements", superInterfaces.length+1, imports.size());
        supersList.clear();
        supersList.add(superClass);
        supersList.addAll(Arrays.asList(superInterfaces));
        for (Iterator it=imports.iterator(); it.hasNext();) {
            String nextImport = ((ImportDeclaration) it.next()).getName().getFullyQualifiedName();
            assertTrue("Unexpected import found: "+nextImport, supersList.remove(nextImport));
        }
        assertTrue("Failed to generate import for "+supersList.size()+" more types", supersList.isEmpty());
        
        supersList.clear();
        supersList.add(superClass);
        supersList.addAll(Arrays.asList(superInterfaces));
        final ASTVisitor typeVisitor = new ExpectedSimpleNamesVisitor(supersList);
        cu.accept(new ASTVisitor(){
            public boolean visit(TypeDeclaration node) {
                node.getSuperclassType().accept(typeVisitor);
                for (Iterator it=node.superInterfaceTypes().iterator(); it.hasNext();) {
                    ((Type) it.next()).accept(typeVisitor);
                }
                return super.visit(node);
            }
        });
        assertTrue("Failed to find references for "+supersList.size()+" more types", supersList.isEmpty());
    }
    
    public void testFieldConflictWithDeclaredType() throws Exception {
        String className = "FieldConflictWithDeclaredType";
        String[] fieldTypes = new String[] { Collection.class.getName() };
        StringBuffer code = new StringBuffer();
        String mainClass = generateClassCode(className, null, null, null, fieldTypes, null, null, null, null);
        String innerClass = generateClassCode(Collection.class.getSimpleName(), null, null, null, null, null, null, null, null);
        code.append(mainClass).insert(mainClass.length()-1, innerClass);
        ICompilationUnit icu = JavaProjectHelper.createJavaFile(className+".java", code.toString());
        
        OrganizeImportsPostprocessor processor = new OrganizeImportsPostprocessor();
        processor.organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        assertTrue("Failed not to generate conflicted import statements", imports.isEmpty());
        assertEquals("Failed to preserve conflicted types qualified", code.toString(), icu.getBuffer().getContents());
        
        final List<String> fieldsList = new ArrayList<String>(fieldTypes.length);
        fieldsList.clear();
        fieldsList.addAll(Arrays.asList(fieldTypes));
        cu.accept(new ASTVisitor(){
            public boolean visit(FieldDeclaration node) {
                node.getType().accept(new ASTVisitor() {
                    public boolean visit(QualifiedName node) {
                        boolean found = false;
                        for (Iterator<String> it = fieldsList.iterator(); it.hasNext();) {
                            String nextFullTypeName = it.next();
                            if (nextFullTypeName.equals(node.getFullyQualifiedName())) {
                                it.remove();
                                found = true;
                                break;
                            }
                        }
                        assertTrue("Unexpected simple type found "+node.getFullyQualifiedName(), found);
                        return false;
                    }
                });
                return super.visit(node);
            }
        });
        assertTrue("Failed to find references for "+fieldsList.size()+" more types", fieldsList.isEmpty());
    }
    
    public void testImportConflictWithDeclaredType() throws Exception {
        String className = "ImportConflictWithDeclaredType";
        String[] importedTypes = new String[] { Collection.class.getName() };
        StringBuffer code = new StringBuffer();
        String mainClass = generateClassCode(className, importedTypes, null, null, null, null, null, null, null);
        String innerClass = generateClassCode(Collection.class.getSimpleName(), null, null, null, null, null, null, null, null);
        code.append(mainClass).insert(mainClass.length()-1, innerClass);
        ICompilationUnit icu = JavaProjectHelper.createJavaFile(className+".java", code.toString());
        
        OrganizeImportsPostprocessor processor = new OrganizeImportsPostprocessor();
        processor.organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        final List<String> importsList = new ArrayList<String>(importedTypes.length);
        
        assertEquals("Failed to generate enough import statements", importedTypes.length, imports.size());
        importsList.clear();
        importsList.addAll(Arrays.asList(importedTypes));
        for (Iterator it=imports.iterator(); it.hasNext();) {
            String nextImport = ((ImportDeclaration) it.next()).getName().getFullyQualifiedName();
            assertTrue("Unexpected import found: "+nextImport, importsList.remove(nextImport));
        }
        
        assertTrue("Failed to generate import for "+importsList.size()+" more types", importsList.isEmpty());
        assertEquals("Failed to preserve conflicted types qualified", code.toString(), icu.getBuffer().getContents());
        assertTrue("Failed to find references for "+importsList.size()+" more types", importsList.isEmpty());
    }
    
    public void testImportConflictWithQualifiedTypeRef() throws Exception {
        String className = "ImportConflictWithQualifiedTypeRef";
        String[] importedTypes = new String[] { Collection.class.getName() };
        StringBuffer code = new StringBuffer();
        String mainClass = generateClassCode(className, importedTypes, null, null, null, null, null, null, null);
        String innerClass = generateClassCode(Collection.class.getSimpleName(), null, Collection.class.getName(), null, null, null, null, null, null);
        code.append(mainClass).insert(mainClass.length()-1, innerClass);
        ICompilationUnit icu = JavaProjectHelper.createJavaFile(className+".java", code.toString());
        
        OrganizeImportsPostprocessor processor = new OrganizeImportsPostprocessor();
        processor.organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        final List<String> importsList = new ArrayList<String>(importedTypes.length);
        
        assertEquals("Failed to generate enough import statements", importedTypes.length, imports.size());
        importsList.clear();
        importsList.addAll(Arrays.asList(importedTypes));
        for (Iterator it=imports.iterator(); it.hasNext();) {
            String nextImport = ((ImportDeclaration) it.next()).getName().getFullyQualifiedName();
            assertTrue("Unexpected import found: "+nextImport, importsList.remove(nextImport));
        }
        
        assertTrue("Failed to generate import for "+importsList.size()+" more types", importsList.isEmpty());
        //assertEquals("Failed to preserve conflicted types qualified", code.toString(), icu.getBuffer().getContents());
        assertTrue("Failed to find references for "+importsList.size()+" more types", importsList.isEmpty());
    }
    
    public void testImportConflictWithSuperTypeRef() throws Exception {
        String className = "ImportConflictWithSuperTypeRef";
        String[] importedTypes = new String[] { Collection.class.getName() };
        String conflicted = "my.own.Collection";
        String code = generateClassCode(className, importedTypes, conflicted, null, null, null, null, null, null);
        ICompilationUnit icu = JavaProjectHelper.createJavaFile(className+".java", code);
        
        OrganizeImportsPostprocessor processor = new OrganizeImportsPostprocessor();
        processor.organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        final List<String> importsList = new ArrayList<String>(importedTypes.length);
        
        assertEquals("Failed to generate enough import statements", importedTypes.length, imports.size());
        importsList.clear();
        importsList.addAll(Arrays.asList(importedTypes));
        for (Iterator it=imports.iterator(); it.hasNext();) {
            String nextImport = ((ImportDeclaration) it.next()).getName().getFullyQualifiedName();
            assertTrue("Unexpected import found: "+nextImport, importsList.remove(nextImport));
        }
        
        assertTrue("Failed to generate import for "+importsList.size()+" more types", importsList.isEmpty());
        assertEquals("Failed to preserve conflicted types qualified", code.toString(), icu.getBuffer().getContents());
        assertTrue("Failed to find references for "+importsList.size()+" more types", importsList.isEmpty());
    }
    
    public void testLocalVarConflictWithDeclaredType() throws Exception {
        String className = "TestFullQualifiedLocalVariables";
        String[] localVars = new String[] { Collection.class.getName() };
        StringBuffer code = new StringBuffer();
        String mainClass = generateClassCode(className, null, null, null, null, null, null, null, null);
        String innerClass = generateClassCode(Collection.class.getSimpleName(), null, null, null, null, null, null, localVars, null);
        code.append(mainClass).insert(mainClass.length()-1, innerClass);
        ICompilationUnit icu = JavaProjectHelper.createJavaFile(className+".java", code.toString());
        
        OrganizeImportsPostprocessor processor = new OrganizeImportsPostprocessor();
        processor.organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        assertTrue("Failed not to generate conflicting imports", imports.isEmpty());
        
        final List<String> varsList = new ArrayList<String>(Arrays.asList(localVars));
        cu.accept(new ASTVisitor(){
            public boolean visit(MethodDeclaration node) {
                node.getBody().accept(new ASTVisitor() {
                    public boolean visit(VariableDeclarationStatement node) {
                        node.getType().accept(new ASTVisitor() {
                            public boolean visit(QualifiedName node) {
                                boolean found = false;
                                for (Iterator<String> it = varsList.iterator(); it.hasNext();) {
                                    String nextFullTypeName = it.next();
                                    if (nextFullTypeName.equals(node.getFullyQualifiedName())) {
                                        it.remove();
                                        found = true;
                                        break;
                                    }
                                }
                                assertTrue("Unexpected simple type found "+node.getFullyQualifiedName(), found);
                                return false;
                            }
                        });
                        return super.visit(node);
                    }
                });
                return super.visit(node);
            }
        });
        assertTrue("Failed to find references for "+varsList.size()+" more types", varsList.isEmpty());
    }
    
    public void testNotSpoilingExistingImports() throws Exception {
        String className = "NotSpoilingExistingImports";
        String[] existingImports = new String[] { ArrayList.class.getName(), Map.class.getName() };
        String[] fieldTypes = new String[] { List.class.getName(), RectangleFigure.class.getName(), getInnerClassAwareName(Map.Entry.class), Map.class.getName(), Map.class.getSimpleName(), ArrayList.class.getSimpleName() };
        String code = generateClassCode(className, existingImports, null, null, fieldTypes, null, null, null, null);
        ICompilationUnit icu = JavaProjectHelper.createJavaFile(className+".java", code);
        
        OrganizeImportsPostprocessor processor = new OrganizeImportsPostprocessor();
        processor.organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        final List<String> hadImportsList = new ArrayList<String>(Arrays.asList(existingImports));
        final List<String> uniqueImports = new ArrayList<String>(hadImportsList);
        for (int i=0; i<fieldTypes.length; i++) {
            if (!uniqueImports.contains(fieldTypes[i]) && fieldTypes[i].indexOf('.') != -1) {
                uniqueImports.add(fieldTypes[i]);
            }
        }
        
        final List<String> allImports = new ArrayList<String>();
        allImports.addAll(uniqueImports);
        assertEquals("Failed to generate enough import statements", allImports.size(), imports.size());
        for (Iterator it=imports.iterator(); it.hasNext();) {
            String nextImport = ((ImportDeclaration) it.next()).getName().getFullyQualifiedName();
            assertTrue("Unexpected import found: "+nextImport, allImports.remove(nextImport));
        }
        assertTrue("Failed to generate import for "+allImports.size()+" more types", allImports.isEmpty());
        
        allImports.clear();
        allImports.addAll(uniqueImports);
        cu.accept(new ASTVisitor(){
            public boolean visit(FieldDeclaration node) {
                node.getType().accept(new ASTVisitor(){
                    public boolean visit(QualifiedName node) {
                        fail("Unexpected fully qualified field found: "+node.getFullyQualifiedName());
                        return false;
                    }

                    public boolean visit(SimpleName node) {
                        String name = "."+node.getFullyQualifiedName();
                        boolean found = false;
                        for (Iterator<String> it=uniqueImports.iterator(); it.hasNext();) {
                            String nextFullTypeName = it.next();
                            if (nextFullTypeName.endsWith(name)) {
                                found = true;
                                break;
                            }
                        }
                        assertTrue("Unexpected simple type found "+name, found);
                        for (Iterator<String> it=allImports.iterator(); it.hasNext();) {
                            String nextFullTypeName = it.next();
                            if (nextFullTypeName.endsWith(name)) {
                                it.remove();
                                break;
                            }
                        }
                        return false;
                    }
                });
                return super.visit(node);
            }
        });
        assertTrue("Failed to find references for "+allImports.size()+" more types", allImports.isEmpty());
    }
    
    public void testNotToRemoveEvenUnusedImports() throws Exception {
        String className = "TestNotToRemoveEvenUnusedImports";
        String[] existingImports = new String[] { ArrayList.class.getName() };
        String code = generateClassCode(className, existingImports, null, null, null, null, null, null, null);
        ICompilationUnit icu = JavaProjectHelper.createJavaFile(className+".java", code);
        
        OrganizeImportsPostprocessor processor = new OrganizeImportsPostprocessor();
        processor.organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        assertFalse("Failed not to remove unused imports", imports.isEmpty());
        assertEquals("Failed to preserve everything if there is unused imports", code, icu.getBuffer().getContents());
    }
    
    public void testNotToImportIfInOnDemandImports() throws Exception {
        String className = "TestNotToImportIfInOnDemandImports";
        String[] existingImports = new String[] { "java.util.*" };
        String[] fieldTypes = new String[] { ArrayList.class.getName() };
        String code = generateClassCode(className, existingImports, null, null, fieldTypes, null, null, null, null);
        ICompilationUnit icu = JavaProjectHelper.createJavaFile(className+".java", code);
        
        OrganizeImportsPostprocessor processor = new OrganizeImportsPostprocessor();
        processor.organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        assertEquals("Failed not to add extra import if on-demand presents", 1, imports.size());
        assertTrue("Failed to preserve on-demand imports", ((ImportDeclaration)imports.get(0)).isOnDemand());
        assertEquals("Failed to preserve right on-demand imports", existingImports[0], ((ImportDeclaration)imports.get(0)).getName().getFullyQualifiedName()+".*");

        final List<String> fieldList = new ArrayList<String>();
        fieldList.addAll(Arrays.asList(fieldTypes));
        cu.accept(new ASTVisitor(){
            public boolean visit(FieldDeclaration node) {
                node.getType().accept(new ExpectedSimpleNamesVisitor(fieldList));
                return super.visit(node);
            }
        });
        assertTrue("Failed to find references for "+fieldList.size()+" more types", fieldList.isEmpty());
    }
    
    private static class ExpectedSimpleNamesVisitor extends ASTVisitor {
        private Collection<String> myExpectedFullNames;

        public ExpectedSimpleNamesVisitor(Collection<String> expectedFullNames) {
            myExpectedFullNames = expectedFullNames;
        }
        
        public boolean visit(QualifiedName node) {
            fail("Unexpected fully qualified field found: "+node.getFullyQualifiedName());
            return false;
        }

        public boolean visit(SimpleName node) {
            String dottedName = "."+node.getFullyQualifiedName();
            boolean found = false;
            for (Iterator<String> it = myExpectedFullNames.iterator(); it.hasNext();) {
                String nextFullTypeName = it.next();
                if (nextFullTypeName.endsWith(dottedName)) {
                    it.remove();
                    found = true;
                    break;
                }
            }
            assertTrue("Unexpected simple type found "+node.getFullyQualifiedName(), found);
            return false;
        }
    }
    
    private String generateClassCode(String className, String[] imports, String extendsType, String[] implementsTypes, String[] fieldTypes, String[] methodParameters, String[] methodReturns, String[] localVariables, String[] methodExceptions) {
        StringBuffer buf = new StringBuffer();
        if (imports != null && imports.length > 0) {
            for (int i=0; i<imports.length; i++) {
                buf.append("import ").append(imports[i]).append(';').append(nl);
            }
        }
        buf.append(nl);
        buf.append("public class ").append(className);
        if (extendsType != null) {
            buf.append(" extends ").append(extendsType);
        }
        if (implementsTypes != null && implementsTypes.length > 0) {
            buf.append(" implements ");
            for (int i=0; i<implementsTypes.length; i++) {
                buf.append(implementsTypes[i]);
                if (i != implementsTypes.length-1) {
                    buf.append(", ");
                }
            }
        }
        buf.append(" {").append(nl);
        buf.append(nl);
        if (fieldTypes != null && fieldTypes.length > 0) {
            for (int i=0; i<fieldTypes.length; i++) {
                buf.append("    public ").append(fieldTypes[i]).append(" field").append(i).append(";").append(nl);
            }
        }
        buf.append(nl);
        if (methodParameters != null && methodParameters.length > 0) {
            buf.append("    public void methodWithParams(");
            for (int i=0; i<methodParameters.length; i++) {
                buf.append(methodParameters[i]).append(" param").append(i);
                if (i != methodParameters.length-1) {
                    buf.append(", ");
                }
            }
            buf.append(") {}").append(nl);
        }
        buf.append(nl);
        if (methodReturns != null && methodReturns.length > 0) {
            for (int i=0; i<methodReturns.length; i++) {
                buf.append("    public ").append(methodReturns[i]).append(" methodWithReturn").append(i).append("() {").append(nl);
                buf.append("        return null;").append(nl);
                buf.append("    }").append(nl);
                buf.append(nl);
            }
        }
        if (localVariables != null && localVariables.length > 0) {
            buf.append("    public void methodWithLocalVariables() {").append(nl);
            for (int i=0; i<localVariables.length; i++) {
                buf.append("        ").append(localVariables[i]).append(" localVar").append(i).append(';').append(nl);
            }
            buf.append("    }").append(nl);
        }
        buf.append(nl);
        if (methodExceptions != null && methodExceptions.length > 0) {
            buf.append("    public Object methodWithExceptions").append("() throws ");
            for (int i=0; i<methodExceptions.length; i++) {
                buf.append(methodExceptions[i]);
                if (i != methodExceptions.length - 1) {
                    buf.append(", ");
                }
            }
            buf.append(" {").append(nl);
            buf.append("        return null;").append(nl);
            buf.append("    }").append(nl);
            buf.append(nl);
        }
        buf.append(nl);
        if (methodExceptions != null && methodExceptions.length > 0) {
            buf.append("    public Object methodWithRuntimeExceptions() ");
            buf.append(" {").append(nl);
            for (int i=0; i<methodExceptions.length; i++) {
                buf.append("        throw new ").append(methodExceptions[i]).append("();").append(nl);
            }
            buf.append("        return null;").append(nl);
            buf.append("    }").append(nl);
            buf.append(nl);
        }
        buf.append('}');
        return buf.toString();
    }

    public void testFailOnWrongSyntaxInCode() throws Exception {
        StringBuffer buf = new StringBuffer();
        buf.append("public class FailOnWrongSyntaxInCode {").append(nl);
        buf.append(nl);
        buf.append("    private method1() { WRONG-CODE! }").append(nl);
        buf.append(nl);
        buf.append("}").append(nl);
        
        ICompilationUnit icu = JavaProjectHelper.createJavaFile("FailOnWrongSyntaxInCode.java", buf.toString());
        
        try {
            new OrganizeImportsPostprocessor().organizeImports(icu, true, null);
            fail("Failed to produce CoreException with code, containing syntax errors");
        } catch (CoreException e) {
            assertTrue(true);
        }
        icu.save(null, true);
        
        assertEquals("Failed not to change anything in wrong syntax code", buf.toString(), icu.getBuffer().getContents());
    }
    
    public void testSimpleAndQualifiedTypesMatch() throws Exception {
        String className = "SimpleAndQualifiedTypesMatch";
        Class[] typeRefs = new Class[] {
                ArrayList.class,
        };
        
        String[] fieldTypes = new String[] { typeRefs[0].getName(), typeRefs[0].getSimpleName() };
        String[] existedImports = new String[] { fieldTypes[0] };
        String code = generateClassCode(className, existedImports, null, null, fieldTypes, null, null, null, null);
        ICompilationUnit icu = JavaProjectHelper.createJavaFile(className+".java", code);
        
        OrganizeImportsPostprocessor processor = new OrganizeImportsPostprocessor();
        processor.organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        final List<String> fieldList = new ArrayList<String>(typeRefs.length);
        
        fieldList.clear();
        fieldList.addAll(Arrays.asList(existedImports));
        assertEquals("Failed to generate enough import statements", typeRefs.length, imports.size());
        for (Iterator it=imports.iterator(); it.hasNext();) {
            String nextImport = ((ImportDeclaration) it.next()).getName().getFullyQualifiedName();
            assertTrue("Unexpected import found: "+nextImport, fieldList.remove(nextImport));
        }
        assertTrue("Failed to generate import for "+fieldList.size()+" more types", fieldList.isEmpty());

        fieldList.clear();
        fieldList.addAll(Arrays.asList(existedImports));
        cu.accept(new ASTVisitor(){
            public boolean visit(FieldDeclaration node) {
                node.getType().accept(new ExpectedSimpleNamesVisitor(fieldList) {
                    public boolean visit(SimpleName node) {
                        String dottedName = "."+node.getFullyQualifiedName();
                        boolean found = false;
                        for (Iterator<String> it = fieldList.iterator(); it.hasNext();) {
                            String nextFullTypeName = it.next();
                            if (nextFullTypeName.endsWith(dottedName)) {
                                found = true;
                                break;
                            }
                        }
                        assertTrue("Unexpected simple type found "+node.getFullyQualifiedName(), found);
                        return false;
                    }
                });
                return super.visit(node);
            }
        });
    }
    
    public void testQualifiedConstantsInMethodCalls() throws Exception {
        String testClassName = "QualifiedConstantsInMethodCalls";
        final List<String> typeNameRefs = new ArrayList<String>(Arrays.asList(new String[] {
                "javax.dummy.Castings",
                "javax.dummy.Classes",
                "javax.dummy.Constants",
                "javax.dummy.Methods",
        }));
        
        StringBuffer buf = new StringBuffer();
        buf.append("public class ").append(testClassName).append(" {").append(nl);
        buf.append(nl);
        buf.append("    private static int method1(Object[] values) {").append(nl);
        buf.append("        return method2(").append(typeNameRefs.get(2)).append(".CONSTANT,").append(nl);
        buf.append("               ").append("(").append(typeNameRefs.get(0)).append(") casting,").append(nl);
        buf.append("               ").append(typeNameRefs.get(1)).append(".class,").append(nl);
        buf.append("               values.length,").append(nl);
        buf.append("               local.fVar1.fVar2.length,").append(nl);
        buf.append("               localV.fVar1.fVar2.length,").append(nl);
        buf.append("               not.to.replace.pack1.A,").append(nl);
        buf.append("               (not.to.replace.pack2.B) b,").append(nl);
        buf.append("               ").append(typeNameRefs.get(3)).append(".method());").append(nl);
        buf.append("    }").append(nl);
        buf.append(nl);
        buf.append("}").append(nl);

        ICompilationUnit icu = JavaProjectHelper.createJavaFile(testClassName+".java", buf.toString());
        new OrganizeImportsPostprocessor().organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        assertEquals("Failed to generate enough import statements: "+imports, typeNameRefs.size(), imports.size());
        for (int i=0; i<imports.size(); i++) {
            String nextImport = ((ImportDeclaration) imports.get(i)).getName().getFullyQualifiedName();
            assertEquals("Unexpected import found", typeNameRefs.get(i), nextImport);
        }
        
        cu.accept(new ASTVisitor(){
            public boolean visit(FieldDeclaration node) {
                node.getType().accept(new ExpectedSimpleNamesVisitor(typeNameRefs) {
                    public boolean visit(QualifiedName node) {
                        assertFalse("Unexpected full-qualified name found!", node.getFullyQualifiedName().startsWith("javax.dummy"));
                        return false;
                    }
                });
                return super.visit(node);
            }
        });
    }
    
    public void _testQualifiedGenerics() throws Exception {
        String testClassName = "QualifiedGenerics";
        final List<String> collectionTypeNameRefs = new ArrayList<String>(Arrays.asList(new String[] {
                "java.util.ArrayList",
                "java.util.Collection"
        }));
        final List<String> genericTypeNameRefs = new ArrayList<String>(Arrays.asList(new String[] {
                "javax.dummy.Castings",
                "javax.dummy.Classes",
                "javax.dummy.Constants",
                "javax.dummy.Methods",
        }));
        
        StringBuffer buf = new StringBuffer();
        buf.append("public class ").append(testClassName).append(" {").append(nl);
        buf.append(nl);
        for (int i=0; i<genericTypeNameRefs.size(); i++) {
            buf.append("    private static ").append(collectionTypeNameRefs.get(0)).append("<").append(genericTypeNameRefs.get(i)).append("> myField").append(i).append(";").append(nl);
            buf.append("    private static ").append(collectionTypeNameRefs.get(1)).append(" < ").append(genericTypeNameRefs.get(i)).append(" > otherField").append(i).append(";").append(nl);
        }
        buf.append("    private static Map<Class1, Class2> unqualified;").append(nl);
        buf.append(nl);
        for (int i=0; i<genericTypeNameRefs.size(); i++) {
            buf.append("    private static int method").append(i).append("(").append(collectionTypeNameRefs.get(1)).append("<? extends ").append(genericTypeNameRefs.get(0)).append("> values) {").append(nl);
            buf.append("        return method(new ").append(collectionTypeNameRefs.get(0)).append("<").append(genericTypeNameRefs.get(i)).append(">());").append(nl);
            buf.append("    }").append(nl);
            buf.append(nl);
            buf.append("    private static int method").append(i).append("(").append(collectionTypeNameRefs.get(1)).append(" < ? extends ").append(genericTypeNameRefs.get(0)).append(" > values ) {").append(nl);
            buf.append("        return method( new  ").append(collectionTypeNameRefs.get(0)).append(" < ").append(genericTypeNameRefs.get(i)).append(" > () );").append(nl);
            buf.append("    }").append(nl);
            buf.append(nl);
        }
        buf.append("}").append(nl);

        ICompilationUnit icu = JavaProjectHelper.createJavaFile(testClassName+".java", buf.toString());
        new OrganizeImportsPostprocessor().organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        assertEquals("Failed to generate enough import statements: "+imports, genericTypeNameRefs.size()+collectionTypeNameRefs.size(), imports.size());
        for (int i=0; i<imports.size(); i++) {
            String nextImport = ((ImportDeclaration) imports.get(i)).getName().getFullyQualifiedName();
            assertTrue("Unexpected import found", genericTypeNameRefs.contains(nextImport) || collectionTypeNameRefs.contains(nextImport));
        }

        final List<String> allReferencedTypes = new ArrayList<String>(genericTypeNameRefs.size()+collectionTypeNameRefs.size());
        allReferencedTypes.addAll(genericTypeNameRefs);
        allReferencedTypes.addAll(collectionTypeNameRefs);
        cu.accept(new ExpectedSimpleNamesVisitor(allReferencedTypes) {
            public boolean visit(ImportDeclaration node) {
                return false;
            }
        });
    }
    
    public void testFullQualifiedArrays() throws Exception {
        String testClassName = "FullQualifiedArrays";
        List<Class> typeRefs = Arrays.asList(new Class[] {
                ArrayList.class,
                List.class,
                Map.class,
                Map.Entry.class,
        });
        final String[] conflictedTypeNames = new String[] {
                "javax.some.Map",
        };
        final List<String> typeNameRefs = new ArrayList<String>(typeRefs.size()+conflictedTypeNames.length);
        for (Iterator<Class> it = typeRefs.iterator(); it.hasNext();) {
            typeNameRefs.add(getInnerClassAwareName(it.next()));
        }
        String localVariable = typeNameRefs.get(2)+".SMTH.ourEntries";
        //String localVariable2 = "org.eclipse.draw2d.Graphics";
        typeNameRefs.add(localVariable);
        //typeNameRefs.add(localVariable2);
        typeNameRefs.addAll(Arrays.asList(conflictedTypeNames));
        
        StringBuffer buf = new StringBuffer();
        buf.append("import ").append(typeNameRefs.get(0)).append(";").append(nl);
        buf.append(nl);
        buf.append("public class ").append(testClassName).append(" {").append(nl);
        buf.append(nl);
        buf.append("    private ").append(typeNameRefs.get(1)).append("[] list;").append(nl);
        buf.append("    private ").append(typeNameRefs.get(2)).append("[] entry = new ").append(typeNameRefs.get(4)).append("[0];").append(nl);
        buf.append("    private ").append(typeNameRefs.get(3)).append("[] maps;").append(nl);
        buf.append("    private ").append(typeRefs.get(0).getSimpleName()).append("[] arrayLists;").append(nl);
        buf.append("    private ").append(typeNameRefs.get(5)).append(" conflictEntry;").append(nl);
        buf.append("    private int style = setLineStyle(").append(localVariable).append(".LINE_DASH);");
        buf.append(nl);
        buf.append("    private static int setLineStyle(int style) {");
        buf.append("        return 0;");
        buf.append("    }");
        buf.append(nl);
        buf.append("}").append(nl);

        ICompilationUnit icu = JavaProjectHelper.createJavaFile(testClassName+".java", buf.toString());
        new OrganizeImportsPostprocessor().organizeImports(icu, true, null);
        icu.save(null, true);
        
        ASTParser parser = ASTParser.newParser(AST.JLS3);
        parser.setSource(icu);
        CompilationUnit cu = (CompilationUnit) parser.createAST(null);
        List imports = cu.imports();
        
        assertEquals("Failed to generate enough import statements: "+imports, typeRefs.size(), imports.size());
        for (int i=0; i<imports.size(); i++) {
            String nextImport = ((ImportDeclaration) imports.get(i)).getName().getFullyQualifiedName();
            assertEquals("Unexpected import found", typeNameRefs.get(i), nextImport);
        }
        
        cu.accept(new ASTVisitor(){
            public boolean visit(FieldDeclaration node) {
                node.getType().accept(new ExpectedSimpleNamesVisitor(typeNameRefs) {
                    public boolean visit(QualifiedName node) {
                        assertEquals("Unexpected full-qualified name found!", conflictedTypeNames[0], node.getFullyQualifiedName());
                        return false;
                    }
                });
                return super.visit(node);
            }
        });
        assertEquals("Failed to leave unqualified only 1 reference", conflictedTypeNames.length, typeNameRefs.size()-1);
    }

    private String getInnerClassAwareName(Class clazz) {
        return clazz.getName();//.replace('$', '.');
    }

    public void testCodeFormattingInSomeRealPieceOfCode() throws Exception {
        StringBuffer buf = new StringBuffer();
        buf.append(nl);
        buf.append("import java.util.ArrayList;").append(nl);
        buf.append(nl);
        buf.append(nl);
        buf.append(nl);
        buf.append(nl);
        buf.append(nl);
        buf.append("import org.eclipse.gmf.runtime.common.ui.resources.IMarker;").append(nl);
        buf.append(nl);
        buf.append(nl);
        buf.append("public class SomeRealPieceOfCode {").append(nl);
        buf.append(nl);
        buf.append("    private      java.util.List     list;").append(nl);
        buf.append(nl);
        buf.append("    private java.util.Map.Entry[] entries;").append(nl);
        buf.append("    private java.util.Map map;").append(nl);
        buf.append("    private ArrayList arrayList;").append(nl);
        buf.append(nl);
        buf.append("    private void createContents() {").append(nl);
        buf.append("        org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel fig_0 = ").append(nl);
        buf.append("                new org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel();").append(nl);
        buf.append("        //some new empty line with comment").append(nl);
        buf.append("        org.eclipse.gmf.runtime.draw2d.ui.figures.NamedNodeRectangle fig_0 = new org.eclipse.gmf.runtime.draw2d.ui.figures.NamedNodeRectangle();").append(nl);
        buf.append("        Object layData0 = null;").append(nl);
        buf.append("    }").append(nl);
        buf.append(nl);
        buf.append("    public class NamedNodeRectangle extends org.eclipse.draw2d.RectangleFigure").append(nl);
        buf.append("                                    implements org.eclipse.gmf.runtime.common.ui.resources.IMarker {").append(nl);
        buf.append("    }").append(nl);
        buf.append(nl);
        buf.append("}").append(nl);

        ICompilationUnit icu = JavaProjectHelper.createJavaFile("SomeRealPieceOfCode.java", buf.toString());
        new OrganizeImportsPostprocessor().organizeImports(icu, true, null);
        icu.save(null, true);
        
        buf = new StringBuffer();
        buf.append(nl);
        buf.append("import java.util.ArrayList;").append(nl);
        buf.append("import java.util.List;").append(nl);
        buf.append("import java.util.Map;").append(nl);
        buf.append(nl);
        buf.append(nl);
        buf.append(nl);
        buf.append(nl);
        buf.append(nl);
        buf.append("import org.eclipse.draw2d.RectangleFigure;").append(nl);
        buf.append("import org.eclipse.gmf.runtime.common.ui.resources.IMarker;").append(nl);
        buf.append("import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;").append(nl);
        buf.append(nl);
        buf.append(nl);
        buf.append("public class SomeRealPieceOfCode {").append(nl);
        buf.append(nl);
        buf.append("    private      List     list;").append(nl);
        buf.append(nl);
        buf.append("    private Map.Entry[] entries;").append(nl);
        buf.append("    private Map map;").append(nl);
        buf.append("    private ArrayList arrayList;").append(nl);
        buf.append(nl);
        buf.append("    private void createContents() {").append(nl);
        buf.append("        WrapLabel fig_0 = ").append(nl);
        buf.append("                new WrapLabel();").append(nl);
        buf.append("        //some new empty line with comment").append(nl);
        buf.append("        org.eclipse.gmf.runtime.draw2d.ui.figures.NamedNodeRectangle fig_0 = new org.eclipse.gmf.runtime.draw2d.ui.figures.NamedNodeRectangle();").append(nl);
        buf.append("        Object layData0 = null;").append(nl);
        buf.append("    }").append(nl);
        buf.append(nl);
        buf.append("    public class NamedNodeRectangle extends RectangleFigure").append(nl);
        buf.append("                                    implements IMarker {").append(nl);
        buf.append("    }").append(nl);
        buf.append(nl);
        buf.append("}").append(nl);
        
        assertEquals("Failed to organize imports", buf.toString(), icu.getBuffer().getContents());
    }

    public static class JavaProjectHelper {
        private static String myTmpProjectNamePrefix = "imports.tmp";
        
        public static IProject createTmpProject() throws CoreException {
            IWorkspace workspace = ResourcesPlugin.getWorkspace();
            if (workspace != null) {
                IWorkspaceRoot root = workspace.getRoot();
                IProject tmp = root.getProject(myTmpProjectNamePrefix);
                if (!tmp.exists()) {
                    tmp.create(null);
                }
                if (!tmp.isOpen()) {
                    tmp.open(null);
                }
                return tmp;
            }
            return null;
        }

        public static IFile createFile(String tmpFileNamePrefix, String initialContent) throws CoreException {
            IProject project = createTmpProject();
            if (project != null) {
                IFile tmp = project.getFile(tmpFileNamePrefix);
                if (tmp.exists()) {
                    tmp.delete(true, null);
                }
                ByteArrayInputStream is = new ByteArrayInputStream(initialContent.getBytes());
                tmp.create(is, true, null);
                return tmp;
            }
            return null;
        }
        
        public static ICompilationUnit createJavaFile(String tmpFileNamePrefix, String initialContent) throws CoreException {
            IFile file = createFile(tmpFileNamePrefix, initialContent);
            
            IProjectDescription descr = file.getProject().getDescription();
            descr.setNatureIds(new String[] {JavaCore.NATURE_ID});
            file.getProject().setDescription(descr, null);
            
            IJavaProject javaProject = JavaCore.create(file.getProject());
            javaProject.setRawClasspath(new IClasspathEntry[]{ 
                    JavaCore.newSourceEntry(file.getProject().getFullPath()),
                    JavaCore.newLibraryEntry(JavaCore.getClasspathVariable("JRE_LIB"), null, null)
            }, null);

            return JavaCore.createCompilationUnitFrom(file);
        }
    }
}
