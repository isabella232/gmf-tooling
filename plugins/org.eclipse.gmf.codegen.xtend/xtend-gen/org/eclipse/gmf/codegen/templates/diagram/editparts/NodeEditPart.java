package org.eclipse.gmf.codegen.templates.diagram.editparts;

import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class NodeEditPart {
  public String getFilePath(final GenNode genNode) {
    String _editPartQualifiedClassName = genNode.getEditPartQualifiedClassName();
    return _editPartQualifiedClassName;
  }
  
  public CharSequence generate(final GenNode genNode) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _genPackageDeclaration = this.genPackageDeclaration(genNode);
    _builder.append(_genPackageDeclaration, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _editPartClassName = genNode.getEditPartClassName();
    _builder.append(_editPartClassName, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("*");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @generated");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("**/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public ");
    String _editPartClassName_1 = genNode.getEditPartClassName();
    _builder.append(_editPartClassName_1, "	");
    _builder.append("() {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence genPackageDeclaration(final GenNode genNode) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package ");
    String _editPartQualifiedClassName = genNode.getEditPartQualifiedClassName();
    String _packageName = CodeGenUtil.getPackageName(_editPartQualifiedClassName);
    _builder.append(_packageName, "");
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }
}
