package edithelpers;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.gmf.codegen.gmfgen.ElementType;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.gmf.codegen.gmfgen.SpecializationType;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class edithelper {
  public CharSequence main(final ElementType it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class ");
    Object _className = this.className(it);
    _builder.append(_className, "");
    _builder.append(" extends org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice {");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public org.eclipse.gmf.runtime.common.core.command.ICommand getBeforeEditCommand(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest request) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new MarkerCommand(\"before\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public org.eclipse.gmf.runtime.common.core.command.ICommand getAfterEditCommand(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest request) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return new MarkerCommand(\"after\");");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("private class MarkerCommand extends org.eclipse.gmf.runtime.common.core.command.AbstractCommand {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("public MarkerCommand(String name) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("super(name + \"MarkerCommand");
    GenCommonBase _diagramElement = it.getDiagramElement();
    int _visualID = _diagramElement.getVisualID();
    _builder.append(_visualID, "			");
    _builder.append("\");");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected org.eclipse.gmf.runtime.common.core.command.CommandResult doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor progressMonitor, org.eclipse.core.runtime.IAdaptable info) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected org.eclipse.gmf.runtime.common.core.command.CommandResult doRedoWithResult(org.eclipse.core.runtime.IProgressMonitor progressMonitor, org.eclipse.core.runtime.IAdaptable info) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("protected org.eclipse.gmf.runtime.common.core.command.CommandResult doUndoWithResult(org.eclipse.core.runtime.IProgressMonitor progressMonitor, org.eclipse.core.runtime.IAdaptable info) {");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("return null;");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  protected Object _className(final ElementType it) {
    IllegalStateException _illegalStateException = new IllegalStateException("Should never be called");
    throw _illegalStateException;
  }
  
  protected CharSequence _className(final MetamodelType it) {
    StringConcatenation _builder = new StringConcatenation();
    String _editHelperClassName = it.getEditHelperClassName();
    _builder.append(_editHelperClassName, "");
    _builder.append("ExternalAdvice");
    return _builder;
  }
  
  protected Object _className(final SpecializationType it) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _or = false;
      String _editHelperAdviceClassName = it.getEditHelperAdviceClassName();
      boolean _equals = Objects.equal(_editHelperAdviceClassName, null);
      if (_equals) {
        _or = true;
      } else {
        String _editHelperAdviceClassName_1 = it.getEditHelperAdviceClassName();
        int _length = _editHelperAdviceClassName_1.length();
        boolean _equals_1 = (_length == 0);
        _or = (_equals || _equals_1);
      }
      if (_or) {
        GenCommonBase _diagramElement = it.getDiagramElement();
        String _uniqueIdentifier = _diagramElement.getUniqueIdentifier();
        _builder.append(_uniqueIdentifier, "");
      } else {
        String _editHelperAdviceClassName_2 = it.getEditHelperAdviceClassName();
        _builder.append(_editHelperAdviceClassName_2, "");
      }
    }
    _builder.append("ExternalAdvice");
    return _builder;
  }
  
  public Object className(final ElementType it) {
    if (it instanceof MetamodelType) {
      return _className((MetamodelType)it);
    } else if (it instanceof SpecializationType) {
      return _className((SpecializationType)it);
    } else if (it != null) {
      return _className(it);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it).toString());
    }
  }
}
