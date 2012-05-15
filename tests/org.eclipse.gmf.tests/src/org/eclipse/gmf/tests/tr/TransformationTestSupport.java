package org.eclipse.gmf.tests.tr;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.graphdef.codegen.MapModeCodeGenStrategy;
import org.eclipse.gmf.internal.bridge.StatefulVisualIdentifierDispencer;
import org.eclipse.gmf.internal.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.internal.bridge.genmodel.DiagramRunTimeModelHelper;
import org.eclipse.gmf.internal.bridge.genmodel.GenModelProducer;
import org.eclipse.gmf.internal.bridge.genmodel.InnerClassViewmapProducer;
import org.eclipse.gmf.internal.bridge.genmodel.ModeledViewmapProducer;
import org.eclipse.gmf.internal.bridge.genmodel.QVTDiagramGenModelTransformer;
import org.eclipse.gmf.internal.bridge.genmodel.ViewmapProducer;
import org.eclipse.gmf.internal.bridge.transform.VisualIdentifierDispenserProvider;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.m2m.qvt.oml.BasicModelExtent;
import org.eclipse.m2m.qvt.oml.ExecutionContextImpl;
import org.eclipse.m2m.qvt.oml.ExecutionDiagnostic;

/**
 * Utility class for tests around qvto-bridge.
 * 
 * @author ghillairet
 *
 */
public class TransformationTestSupport {
	
	abstract static class Transformation {
		protected GenEditorGenerator editor;
		protected StatefulVisualIdentifierDispencer dispenser;
				
		public GenEditorGenerator getEditor() {
			return editor;
		}
		public abstract GenEditorGenerator execute(URI outputURI);
		public StatefulVisualIdentifierDispencer getDispencer() {return dispenser;}
	}
	
	public static Transformation getJavaTransformation(final GenModel genModel, final Mapping mapping, final boolean useModeledViewmap) {
		return new Transformation() {
			@Override
			public GenEditorGenerator execute(URI outputURI) {
				VisualIdentifierDispenserProvider provider = new VisualIdentifierDispenserProvider(outputURI); //traceURI.trimFileExtension().appendFileExtension("java.gmfgen")
				provider.acquire();
				
				dispenser = (StatefulVisualIdentifierDispencer) provider.get();
				
				GenModelProducer producer = getJavaGenModelProducer(useModeledViewmap, genModel, provider);
				try {
					editor = producer.process(mapping, null);
				} catch (CoreException e) {
					e.printStackTrace();
				}
				
				Resource resource = genModel.eResource().getResourceSet().createResource(outputURI);
				resource.getContents().add(editor);
				
				return editor;
			}
		};
	}
	
	public static Transformation getQvtTransformation(final GenModel genModel, final Mapping mapping, final boolean useModeledViewmap) {
		return new Transformation() {
			@Override
			public GenEditorGenerator execute(URI outputURI) {
				VisualIdentifierDispenserProvider provider = new VisualIdentifierDispenserProvider(outputURI);
				provider.acquire();
				
				dispenser = (StatefulVisualIdentifierDispencer) provider.get();
				GenModelProducer producer = getQvtGenModelProducer(useModeledViewmap, genModel, provider, genModel.eResource().getResourceSet());
				try {
					editor = producer.process(mapping, null);
				} catch (CoreException e) {
					e.printStackTrace();
				}
				
				Resource resource = genModel.eResource().getResourceSet().createResource(outputURI);
				resource.getContents().add(editor);
				
				return editor;
			}
		};
	}
	
	public static GenModelProducer getJavaGenModelProducer(boolean useModeledViewmap, final GenModel genModel, VisualIdentifierDispenserProvider idDespenser) {
		MapModeCodeGenStrategy mmStrategy = MapModeCodeGenStrategy.DYNAMIC;
		ViewmapProducer viewmapProducer = useModeledViewmap ? new ModeledViewmapProducer() :  new InnerClassViewmapProducer("full", mmStrategy, null);

		final DiagramRunTimeModelHelper drtModelHelper = new BasicDiagramRunTimeModelHelper();
		DiagramGenModelTransformer.Parameters opts = new DiagramGenModelTransformer.Parameters(drtModelHelper, viewmapProducer, idDespenser.get(), false);
		final DiagramGenModelTransformer t = new DiagramGenModelTransformer(opts);
		
		t.setEMFGenModel(genModel);

		return new GenModelProducer() {
			public GenEditorGenerator process(Mapping mapping, IProgressMonitor progress) {
				t.transform(mapping);
				return t.getResult();
			}
		};
	}

	public static GenModelProducer getQvtGenModelProducer(boolean useModeledViewmap, final GenModel genModel, VisualIdentifierDispenserProvider idDespenser, ResourceSet resourceSet) {
		final ExecutionContextImpl context = new ExecutionContextImpl();
		context.setConfigProperty("rcp", false);
		context.setConfigProperty("useMapMode", false);
		context.setConfigProperty("useFullRunTime", false);
		context.setConfigProperty("useInTransformationCodeGen", !useModeledViewmap);

		final QVTDiagramGenModelTransformer transformer = new QVTDiagramGenModelTransformer(resourceSet, idDespenser.get());
		
		return new GenModelProducer() {
			public GenEditorGenerator process(Mapping mapping, IProgressMonitor progress) throws CoreException {
				final BasicModelExtent output = new BasicModelExtent();
				final ExecutionDiagnostic result = transformer.transform(mapping, genModel, output, context);

				if(result.getSeverity() == Diagnostic.OK) {
					List<EObject> outObjects = output.getContents();
					return outObjects.get(0) instanceof GenEditorGenerator ? (GenEditorGenerator) outObjects.get(0) : null;
				}
				return null;
			}
		};
	}
}
