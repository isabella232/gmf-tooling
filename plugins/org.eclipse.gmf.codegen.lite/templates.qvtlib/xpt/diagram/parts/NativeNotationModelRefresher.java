package xpt.diagram.parts;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
public class NativeNotationModelRefresher {
@Operation(contextual = false, kind = Kind.HELPER)
public static java.util.Collection<org.eclipse.gmf.codegen.gmfgen.GenNode> getGenNodes(org.eclipse.gmf.codegen.gmfgen.GenContainerBase genContainerBase, org.eclipse.emf.codegen.ecore.genmodel.GenFeature genFeature) { return org.eclipse.ocl.util.CollectionUtil.<org.eclipse.gmf.codegen.gmfgen.GenNode> createNewBag(org.eclipse.gmf.internal.codegen.lite.utils.SemanticSyncUtils.getGenNodes(genContainerBase, genFeature)); }
}