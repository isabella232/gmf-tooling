package org.eclipse.gmf.codegen.util;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.List;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.templates.diagram.editparts.NodeEditPart;
import org.eclipse.gmf.codegen.util.MergeFileSystemAccess;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.internal.common.codegen.GeneratorBase;
import org.eclipse.gmf.internal.common.codegen.GeneratorBase.Counter;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class GMFGenGenerator extends GeneratorBase implements IGenerator {
  private IFileSystemAccess fileSystemAccess;
  
  private GenEditorGenerator genEditor;
  
  private NodeEditPart nodeEditPartGen = new Function0<NodeEditPart>() {
    public NodeEditPart apply() {
      NodeEditPart _nodeEditPart = new NodeEditPart();
      return _nodeEditPart;
    }
  }.apply();
  
  public void doGenerate(final Resource resource, final IFileSystemAccess fsa) {
    try {
      this.fileSystemAccess = fsa;
      boolean _and = false;
      EList<EObject> _contents = resource.getContents();
      boolean _isEmpty = _contents.isEmpty();
      boolean _not = (!_isEmpty);
      if (!_not) {
        _and = false;
      } else {
        EList<EObject> _contents_1 = resource.getContents();
        EObject _get = _contents_1.get(0);
        _and = (_not && (_get instanceof GenEditorGenerator));
      }
      if (_and) {
        EList<EObject> _contents_2 = resource.getContents();
        EObject _get_1 = _contents_2.get(0);
        this.genEditor = ((GenEditorGenerator) _get_1);
        this.customRun();
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void customRun() throws InterruptedException, UnexpectedBehaviourException {
    boolean _equals = Objects.equal(this.genEditor, null);
    if (_equals) {
      return;
    }
    String _pluginDirectory = this.genEditor.getPluginDirectory();
    Path _path = new Path(_pluginDirectory);
    final Path pluginDirectory = _path;
    IPath _guessProjectLocation = this.guessProjectLocation(this.genEditor);
    List<IProject> _emptyList = Collections.<IProject>emptyList();
    this.initializeEditorProject(pluginDirectory, _guessProjectLocation, _emptyList);
    String _string = pluginDirectory.toString();
    ((MergeFileSystemAccess) this.fileSystemAccess).setOutputPath(_string);
    GenDiagram _diagram = this.genEditor.getDiagram();
    EList<GenTopLevelNode> _topLevelNodes = _diagram.getTopLevelNodes();
    final Procedure1<GenTopLevelNode> _function = new Procedure1<GenTopLevelNode>() {
        public void apply(final GenTopLevelNode it) {
          GMFGenGenerator.this.generateEditPart(it);
        }
      };
    IterableExtensions.<GenTopLevelNode>forEach(_topLevelNodes, _function);
  }
  
  private void generateEditPart(final GenNode genNode) {
    final String qualifiedName = genNode.getEditPartQualifiedClassName();
    String _replaceAll = qualifiedName.replaceAll("\\.", "/");
    final String fileName = _replaceAll.concat(".java");
    CharSequence _generate = this.nodeEditPartGen.generate(genNode);
    this.fileSystemAccess.generateFile(fileName, _generate);
  }
  
  private IPath guessProjectLocation(final GenEditorGenerator genEditor) {
    IPath _xblockexpression = null;
    {
      String _pluginDirectory = genEditor.getPluginDirectory();
      Path _path = new Path(_pluginDirectory);
      final Path path = _path;
      final String projectName = path.segment(0);
      GenModel _domainGenModel = genEditor.getDomainGenModel();
      String _modelDirectory = _domainGenModel==null?(String)null:_domainGenModel.getModelDirectory();
      Path _path_1 = new Path(_modelDirectory);
      final Path modelProjectPath = _path_1;
      IPath _guessNewProjectLocation = this.guessNewProjectLocation(modelProjectPath, projectName);
      _xblockexpression = (_guessNewProjectLocation);
    }
    return _xblockexpression;
  }
  
  protected void setupProgressMonitor() {
    Counter _counter = new Counter();
    final Counter c = _counter;
    EClass _genNode = GMFGenPackage.eINSTANCE.getGenNode();
    c.registerFactor(_genNode, 7);
    EClass _genChildLabelNode = GMFGenPackage.eINSTANCE.getGenChildLabelNode();
    c.registerFactor(_genChildLabelNode, 5);
    EClass _genLink = GMFGenPackage.eINSTANCE.getGenLink();
    c.registerFactor(_genLink, 6);
    EClass _genLinkLabel = GMFGenPackage.eINSTANCE.getGenLinkLabel();
    c.registerFactor(_genLinkLabel, 2);
    EClass _genCompartment = GMFGenPackage.eINSTANCE.getGenCompartment();
    c.registerFactor(_genCompartment, 3);
    EClass _genDiagram = GMFGenPackage.eINSTANCE.getGenDiagram();
    c.registerFactor(_genDiagram, 30);
    EClass _genEditorGenerator = GMFGenPackage.eINSTANCE.getGenEditorGenerator();
    c.registerFactor(_genEditorGenerator, 2);
    EClass _genPlugin = GMFGenPackage.eINSTANCE.getGenPlugin();
    c.registerFactor(_genPlugin, 6);
    EClass _genNavigator = GMFGenPackage.eINSTANCE.getGenNavigator();
    c.registerFactor(_genNavigator, 3);
    EClass _genNavigatorChildReference = GMFGenPackage.eINSTANCE.getGenNavigatorChildReference();
    c.registerFactor(_genNavigatorChildReference, 1);
    EClass _genCustomPropertyTab = GMFGenPackage.eINSTANCE.getGenCustomPropertyTab();
    c.registerFactor(_genCustomPropertyTab, 1);
    EClass _behaviour = GMFGenPackage.eINSTANCE.getBehaviour();
    c.registerFactor(_behaviour, 1);
    EClass _genMetricContainer = GMFGenPackage.eINSTANCE.getGenMetricContainer();
    c.registerFactor(_genMetricContainer, 1);
    EClass _genExpressionProviderContainer = GMFGenPackage.eINSTANCE.getGenExpressionProviderContainer();
    c.registerFactor(_genExpressionProviderContainer, 1);
    EClass _palette = GMFGenPackage.eINSTANCE.getPalette();
    c.registerFactor(_palette, 1);
    int _total = c.getTotal(this.genEditor);
    this.setupProgressMonitor(null, _total);
  }
}
