package xpt.diagram.parts;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
public class NativeLinkNotationModelRefresher {
@Operation(contextual = false, kind = Kind.HELPER)
public static java.util.Collection<org.eclipse.gmf.codegen.gmfgen.GenLink> getTypeGenLinksForFeature(org.eclipse.gmf.codegen.gmfgen.GenCommonBase gcb, org.eclipse.emf.codegen.ecore.genmodel.GenFeature genFeature, java.util.Collection<org.eclipse.gmf.codegen.gmfgen.GenLink> containedLinks) { return org.eclipse.ocl.util.CollectionUtil.<org.eclipse.gmf.codegen.gmfgen.GenLink> createNewBag(org.eclipse.gmf.internal.codegen.lite.utils.SemanticSyncUtils.getTypeGenLinks(gcb, genFeature, containedLinks)); }
@Operation(contextual = false, kind = Kind.HELPER)
public static java.util.Collection<org.eclipse.gmf.codegen.gmfgen.GenLink> getFeatureGenLinksForFeature(org.eclipse.gmf.codegen.gmfgen.GenCommonBase gcb, org.eclipse.emf.codegen.ecore.genmodel.GenFeature genFeature, java.util.Collection<org.eclipse.gmf.codegen.gmfgen.GenLink> containedLinks) { return org.eclipse.ocl.util.CollectionUtil.<org.eclipse.gmf.codegen.gmfgen.GenLink> createNewBag(org.eclipse.gmf.internal.codegen.lite.utils.SemanticSyncUtils.getFeatureGenLinks(gcb, genFeature, containedLinks)); }
@Operation(contextual = false, kind = Kind.HELPER)
public static java.util.Collection<org.eclipse.gmf.codegen.gmfgen.GenCommonBase> buildAncestorClosure(java.util.Collection<org.eclipse.gmf.codegen.gmfgen.GenCommonBase> elements) { return org.eclipse.ocl.util.CollectionUtil.<org.eclipse.gmf.codegen.gmfgen.GenCommonBase> createNewBag(org.eclipse.gmf.internal.codegen.lite.utils.SemanticSyncUtils.buildAncestorClosure(elements)); }
}