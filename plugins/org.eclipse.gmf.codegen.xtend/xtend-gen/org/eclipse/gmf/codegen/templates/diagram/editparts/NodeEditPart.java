package org.eclipse.gmf.codegen.templates.diagram.editparts;

import com.google.inject.Inject;
import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Extension;
import xpt.Common;

@SuppressWarnings("all")
public class NodeEditPart {
  @Inject
  @Extension
  private Common _common;
  
  public String getFilePath(final GenNode genNode) {
    String _editPartQualifiedClassName = genNode.getEditPartQualifiedClassName();
    String _plus = (_editPartQualifiedClassName + "_New");
    return _plus;
  }
  
  public CharSequence generate(final GenNode genNode) {
    StringConcatenation _builder = new StringConcatenation();
    CharSequence _genPackageDeclaration = this.genPackageDeclaration(genNode);
    _builder.append(_genPackageDeclaration, "");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("public class ");
    String _editPartClassName = genNode.getEditPartClassName();
    String _plus = (_editPartClassName + "_New");
    _builder.append(_plus, "");
    _builder.append(" {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedClassComment = this._common.generatedClassComment(genNode);
    _builder.append(_generatedClassComment, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("public void doIt() {}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.newLine();
    _builder.append("\t");
    CharSequence _generatedClassComment_1 = this._common.generatedClassComment(genNode, " Some additional comment");
    _builder.append(_generatedClassComment_1, "	");
    _builder.newLineIfNotEmpty();
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
