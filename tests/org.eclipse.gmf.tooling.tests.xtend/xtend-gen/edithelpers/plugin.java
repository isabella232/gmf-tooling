package edithelpers;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import edithelpers.edithelper;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.codegen.gmfgen.ElementType;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenPlugin;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class plugin {
  @Inject
  private edithelper helper;
  
  public CharSequence main(final GenDiagram it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    _builder.newLine();
    _builder.append("<?eclipse version=\"3.0\"?>");
    _builder.newLine();
    _builder.append("<plugin>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<extension point=\"org.eclipse.gmf.runtime.emf.type.core.elementTypes\">");
    _builder.newLine();
    {
      EList<GenTopLevelNode> _topLevelNodes = it.getTopLevelNodes();
      final Function1<GenTopLevelNode,Boolean> _function = new Function1<GenTopLevelNode,Boolean>() {
        public Boolean apply(final GenTopLevelNode n) {
          ElementType _elementType = n.getElementType();
          boolean _notEquals = (!Objects.equal(_elementType, null));
          return Boolean.valueOf(_notEquals);
        }
      };
      Iterable<GenTopLevelNode> _filter = IterableExtensions.<GenTopLevelNode>filter(_topLevelNodes, _function);
      for(final GenTopLevelNode f : _filter) {
        CharSequence _registerHelperAdvice = this.registerHelperAdvice(f);
        _builder.append(_registerHelperAdvice, "");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("</extension>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<extension point=\"org.eclipse.gmf.runtime.emf.type.core.elementTypeBindings\">");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<binding context=\"");
    GenEditorGenerator _editorGen = it.getEditorGen();
    GenPlugin _plugin = _editorGen.getPlugin();
    String _iD = _plugin.getID();
    _builder.append(_iD, "		");
    _builder.append(".TypeContext\">");
    _builder.newLineIfNotEmpty();
    {
      EList<GenTopLevelNode> _topLevelNodes_1 = it.getTopLevelNodes();
      final Function1<GenTopLevelNode,Boolean> _function_1 = new Function1<GenTopLevelNode,Boolean>() {
        public Boolean apply(final GenTopLevelNode n) {
          ElementType _elementType = n.getElementType();
          boolean _notEquals = (!Objects.equal(_elementType, null));
          return Boolean.valueOf(_notEquals);
        }
      };
      Iterable<GenTopLevelNode> _filter_1 = IterableExtensions.<GenTopLevelNode>filter(_topLevelNodes_1, _function_1);
      for(final GenTopLevelNode f_1 : _filter_1) {
        CharSequence _registerHelperAdvice_1 = this.registerHelperAdvice(f_1);
        _builder.append(_registerHelperAdvice_1, "");
        CharSequence _registerHelperAdviceBinding = this.registerHelperAdviceBinding(f_1);
        _builder.append(_registerHelperAdviceBinding, "");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("</binding>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</extension>");
    _builder.newLine();
    _builder.append("</plugin>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence registerHelperAdvice(final GenTopLevelNode it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<metamodel nsURI=\"");
    TypeModelFacet _modelFacet = it.getModelFacet();
    GenClass _metaClass = _modelFacet.getMetaClass();
    GenPackage _genPackage = _metaClass.getGenPackage();
    EPackage _ecorePackage = _genPackage.getEcorePackage();
    String _nsURI = _ecorePackage.getNsURI();
    _builder.append(_nsURI, "");
    _builder.append("\">");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("<adviceBinding");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("class=\"");
    ElementType _elementType = it.getElementType();
    Object _className = this.helper.className(_elementType);
    _builder.append(_className, "		");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("id=\"");
    ElementType _elementType_1 = it.getElementType();
    CharSequence _id = this.id(_elementType_1);
    _builder.append(_id, "		");
    _builder.append("\"");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t");
    _builder.append("inheritance=\"none\"");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("typeId=\"");
    ElementType _elementType_2 = it.getElementType();
    String _uniqueIdentifier = _elementType_2.getUniqueIdentifier();
    _builder.append(_uniqueIdentifier, "		");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    _builder.append("</metamodel>");
    _builder.newLine();
    return _builder;
  }
  
  public CharSequence id(final ElementType it) {
    StringConcatenation _builder = new StringConcatenation();
    String _uniqueIdentifier = it.getUniqueIdentifier();
    _builder.append(_uniqueIdentifier, "");
    _builder.append("_ExternalAdvice");
    return _builder;
  }
  
  public CharSequence registerHelperAdviceBinding(final GenTopLevelNode it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<advice ref=\"");
    ElementType _elementType = it.getElementType();
    CharSequence _id = this.id(_elementType);
    _builder.append(_id, "");
    _builder.append("\"/>");
    _builder.newLineIfNotEmpty();
    return _builder;
  }
}
