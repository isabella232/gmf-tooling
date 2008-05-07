/*
 * Copyright (c) 2005, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Radek Dvorak (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.codegen.ecore.genmodel.GenBase;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider;
import org.eclipse.gmf.mappings.AuditContainer;
import org.eclipse.gmf.mappings.AuditRule;
import org.eclipse.gmf.mappings.AuditedMetricTarget;
import org.eclipse.gmf.mappings.ChildReference;
import org.eclipse.gmf.mappings.Constraint;
import org.eclipse.gmf.mappings.DiagramElementTarget;
import org.eclipse.gmf.mappings.DomainAttributeTarget;
import org.eclipse.gmf.mappings.DomainElementTarget;
import org.eclipse.gmf.mappings.FeatureInitializer;
import org.eclipse.gmf.mappings.FeatureSeqInitializer;
import org.eclipse.gmf.mappings.FeatureValueSpec;
import org.eclipse.gmf.mappings.GMFMapFactory;
import org.eclipse.gmf.mappings.Language;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.MetricContainer;
import org.eclipse.gmf.mappings.MetricRule;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.ReferenceNewElementSpec;
import org.eclipse.gmf.mappings.Severity;
import org.eclipse.gmf.mappings.ValueExpression;
import org.eclipse.gmf.tests.EPath;
import org.eclipse.gmf.tests.Plugin;
import org.osgi.framework.BundleException;

public class LinksSessionSetup extends SessionSetup {

	public static String modelURI = "/models/links/links.ecore"; //$NON-NLS-1$
	
	protected LinksSessionSetup() {
	}

	public static SessionSetup newInstance() {
		if (factoryClosed) {
			return null;
		}
		return new LinksSessionSetup();
	}

	@Override
	protected GenProjectSetup createGenProject() throws BundleException, Exception {
		GenProjectSetup genProjectSetup = super.createGenProject();

		assertValid("Test gmfmap model must be valid", EcoreUtil.getRootContainer(getMapModel().getMapping())); //$NON-NLS-1$
//		assertValid("Test gmfgen model must be valid", EcoreUtil.getRootContainer(getGenModel().getGenDiagram())); //$NON-NLS-1$
		return genProjectSetup;
	}
	
	static void assertValid(String message, EObject target) {
		Diagnostic validationDiagnostic = Diagnostician.INSTANCE.validate(target);
		IStatus validationStatus = BasicDiagnostic.toIStatus(validationDiagnostic);
		if(!validationStatus.isOK()) {
			Plugin.getInstance().getLog().log(validationStatus);
		}
		Assert.assertTrue(MessageFormat.format("{0}. {1}. See error log for details.", message, validationStatus.getMessage()), validationStatus.isOK()); //$NON-NLS-1$		
	}
	
	protected DomainModelSource createDomainModel() {
		DomainModelFileSetup modelSetup = new DomainModelFileSetup() {
			private EPath modelAccess;
			@Override
			public DomainModelSource init(URI sourceURI) {
				DomainModelSource r = super.init(sourceURI);
				modelAccess = new EPath(getModel().eResource());
				return r;
			}
			public EClass getDiagramElement() {
				return modelAccess.findClass("//Root"); //$NON-NLS-1$
			}
			public NodeData getNodeA() {
				EClass n = modelAccess.findClass("//Container"); //$NON-NLS-1$
				EReference c = modelAccess.findReference("//Root/elements"); //$NON-NLS-1$
				return new NodeData(n, null, c);
			}
			public NodeData getNodeB() {
				EClass n = modelAccess.findClass("//Node"); //$NON-NLS-1$
				EReference c = modelAccess.findReference("//Root/elements"); //$NON-NLS-1$
				return new NodeData(n, null, c);
			}
			public LinkData getLinkAsClass() {
				EClass l = modelAccess.findClass("//Link"); //$NON-NLS-1$
				EReference t = modelAccess.findReference("//Link/target"); //$NON-NLS-1$
				EReference c = modelAccess.findReference("//Container/childNodes"); //$NON-NLS-1$
				return new LinkData(l, t, c);
			}
			public EReference getLinkAsRef() {
				return modelAccess.findReference("//Container/referenceOnlyLink"); //$NON-NLS-1$
			}
		};
		try {
			modelSetup.init(Plugin.createURI(modelURI));
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail("Failed to setup the domain model. " + e.getLocalizedMessage()); //$NON-NLS-1$
		}
		return modelSetup;
	}
	
	protected DiaGenSource createGenModel() {
		DiaGenSetup diaGenSetup = new DiaGenSetup().init(getMapModel());
		// force generation of validation support 
		diaGenSetup.getGenDiagram().setValidationEnabled(true);
		diaGenSetup.getGenDiagram().setLiveValidationUIFeedback(true);		
		diaGenSetup.getGenDiagram().setValidationDecorators(true);
		// fix Prefixes for nested packages
		GenModel genModel = diaGenSetup.getGenDiagram().getDiagram().getDomainDiagramElement().getGenModel();
		for (GenPackage nextGenPackage : genModel.getAllGenPackagesWithClassifiers()) {
			if(nextGenPackage.getPrefix() == null || nextGenPackage.getPrefix().length() == 0) {
				StringBuffer buf = new StringBuffer(nextGenPackage.getPackageName());
				buf.setCharAt(0, Character.toUpperCase(buf.charAt(0)));
				nextGenPackage.setPrefix(buf.toString());
			}
		}
		for (Object o : diaGenSetup.getGenDiagram().getEditorGen().getExpressionProviders().getProviders()) {
			if (o instanceof GenJavaExpressionProvider) {
				((GenJavaExpressionProvider) o).setThrowException(false);
				// otherwise, validation listener won't report audit which failed with exception
				// as completed, and AuditRulesTest would fail.
				break; // expect no more than a single java provider - there should be at most 1
			}
		}
	
		ResourceSet rset = getMapModel().getMapping().eResource().getResourceSet();
		bindGMFGenModelToResourceSet(diaGenSetup, rset);
		
		return diaGenSetup;
	}

	@SuppressWarnings("synthetic-access")
	protected MapDefSource createMapModel() {
		MapSetup mapDefSource = new LinksMapSetup();
		return mapDefSource.init(getGraphDefModel(), getDomainModel(), new ToolDefSetup());
	}
	
	private void bindGMFGenModelToResourceSet(DiaGenSetup diaGenSetup, ResourceSet rset) {
		rset.createResource(URI.createURI("uri:/myTestModel/gmfgen")).getContents().add(EcoreUtil.getRootContainer(diaGenSetup.getGenDiagram())); //$NON-NLS-1$
		
		Set<GenModel> genModels = new HashSet<GenModel>();		
		GenModel domainGenModel = diaGenSetup.getGenDiagram().getDomainDiagramElement().getGenModel();
		genModels.add(domainGenModel);
		
		Map<EObject, ?> crossRefs = EcoreUtil.ExternalCrossReferencer.find(EcoreUtil.getRootContainer(diaGenSetup.getGenDiagram()));
		for (EObject crossReferenced : crossRefs.keySet()) {
			if(crossReferenced.eResource() == null && crossReferenced instanceof GenBase) {
				genModels.add(((GenBase)crossReferenced).getGenModel());
			}
		}
		
		int modelID = 0;
		for (GenModel nextGenModel : genModels) {
			rset.createResource(URI.createURI("uri:/myTestModel/genmodel/" + modelID++)).getContents().add(nextGenModel); //$NON-NLS-1$
		}			
	}	
	
	/*
	 * Custom map-setup
	 */
	private static final class LinksMapSetup extends MapSetup {
		private EPath modelAccess;
		
		public MapSetup init(DiaDefSource ddSource, DomainModelSource domainSource, ToolDefSource toolDef) {
			this.modelAccess = new EPath(domainSource.getModel().eResource());
						
			super.init(ddSource, domainSource, toolDef);
						
			// add mapping for InvalidNode, this node will be never created in tests
			// but used for generation purposes of java expression support
			EClass invalidNodeMetaClass = modelAccess.findClass("//InvalidNode"); //$NON-NLS-1$
			createNodeMapping(ddSource.getNodeDef(), 
					invalidNodeMetaClass, null, null,
					modelAccess.findReference("//Root/elements"), //$NON-NLS-1$
					true);
					
			// Note: needs metrics to be initialized before audits as audits may reference metric
			initMetricContainer(domainSource);
			initAudits();
			
			// eliminate dangling HREFs diagnostics
			bindToResourceSet(ddSource, toolDef, domainSource.getModel().eResource().getResourceSet());
			return this;
		}
		
		private void bindToResourceSet(DiaDefSource ddSource, ToolDefSource toolDef, ResourceSet rs) {			
			Resource mapRsrc = rs.createResource(URI.createURI("uri:/myTestModel/gmfmap")); //$NON-NLS-1$
			mapRsrc.getContents().add(getMapping());

			Resource graphRsrc = rs.createResource(URI.createURI("uri:/myTestModel/gmfgraph")); //$NON-NLS-1$
			graphRsrc.getContents().add(ddSource.getCanvasDef());

			Resource toolRsrc = rs.createResource(URI.createURI("uri:/myTestModel/gmftool")); //$NON-NLS-1$
			toolRsrc.getContents().add(toolDef.getRegistry());
		}

		/* Setup element initializers */
		protected void setupNodeMapping(NodeMapping nme) {
			if("Container".equals(nme.getDomainContext().getName())) { //$NON-NLS-1$
				EPath ecoreModelAccess = new EPath(EcorePackage.eINSTANCE.eResource());
				nme.setDomainInitializer(createFSeqInit(new FeatureInitDataHelper[] {
					featureValOCL("//Container/enumAttr_Init", "TestEnum::LIT1"), //$NON-NLS-1$ //$NON-NLS-2$
					featureValOCL("//Container/manyEnumAttr_Init", "Sequence { TestEnum::LIT0, TestEnum::LIT1 }"), //$NON-NLS-1$ //$NON-NLS-2$						
					featureValOCL("//Container/reference_Init", "Bag { self }" ), //$NON-NLS-1$ //$NON-NLS-2$
					featureValOCL("//Container/manyRealAttr_Init", "Sequence { 1, 1.5 }" ), //$NON-NLS-1$ //$NON-NLS-2$
					// test complex structure creation
					refNewElement(modelAccess.findFeature("//Container/refNewElement"), new FeatureSeqInitializer[] { //$NON-NLS-1$
						newElementFSeqInit(new FeatureInitDataHelper[] {
							featureValOCL(ecoreModelAccess.findFeature("//ENamedElement/name"), "'EClass'"), //$NON-NLS-1$ //$NON-NLS-2$
							refNewElement(ecoreModelAccess.findFeature("//EClass/eStructuralFeatures"), new FeatureSeqInitializer[] { //$NON-NLS-1$
								newElementFSeqInit(new FeatureInitDataHelper[] {
									featureValOCL(ecoreModelAccess.findFeature("//ENamedElement/name"), "'EAttribute'"), //$NON-NLS-1$ //$NON-NLS-2$
									featureValOCL(ecoreModelAccess.findFeature("//ETypedElement/eType"), "ecore::EString") //$NON-NLS-1$ //$NON-NLS-2$									
								}, ecoreModelAccess.findClass("//EAttribute")) //$NON-NLS-1$
							}),
							refNewElement(ecoreModelAccess.findFeature("//EClass/eOperations"), new FeatureSeqInitializer[] { //$NON-NLS-1$
									newElementFSeqInit(new FeatureInitDataHelper[] {
										featureValOCL(ecoreModelAccess.findFeature("//ENamedElement/name"), "'EOperation'"), //$NON-NLS-1$ //$NON-NLS-2$
										featureValOCL(ecoreModelAccess.findFeature("//ETypedElement/eType"), "links::Container") //$NON-NLS-1$ //$NON-NLS-2$									
									}, null) 
							})							
						}, null),
					})
				}));
	
				// test domain element seletor
				Constraint selector = GMFMapFactory.eINSTANCE.createConstraint();
				selector.setBody("true"); //$NON-NLS-1$
				nme.setDomainSpecialization(selector);
				
			} else if("Node".equals(nme.getDomainContext().getName())) { //$NON-NLS-1$
				nme.setDomainInitializer(createFSeqInit(new FeatureInitDataHelper[] {  
					featureValOCL("//Node/integers_Init", "Sequence { 10, 20 }" ), //$NON-NLS-1$ //$NON-NLS-2$
					featureValJava("//Node/name", "setNodeName"), //$NON-NLS-1$ //$NON-NLS-2$				
				}));				
			
				createReusedChildNodes(nme, new String[] { "//Node/nestedNodes1", "//Node/nestedNodes2" }); //$NON-NLS-1$ //$NON-NLS-2$				
			} else if("InvalidNode".equals(nme.getDomainContext().getName())) { //$NON-NLS-1$				
				// test specializer with multiple java expressions coming from reused node mapping				
				// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=144305
				nme.setDomainInitializer(createFSeqInit(new FeatureInitDataHelper[] {
					featureValOCL("//Node/name", "'\"Quated-name tests literal escaping\"'"), //$NON-NLS-1$ //$NON-NLS-2$						
					featureValJava("//Node/multiValPrimitive", "multiValPrimitive"), //$NON-NLS-1$ //$NON-NLS-2$ 					
					featureValJava("//Node/multiValObj", "multiValObj"), //$NON-NLS-1$ //$NON-NLS-2$ 					
					featureValJava("//Node/multiRef", "multiRef"), //$NON-NLS-1$ //$NON-NLS-2$
					featureValJava("//Node/singleValPrimitive", "singleValPrimitive"), //$NON-NLS-1$ //$NON-NLS-2$ 					
					featureValJava("//Node/singleValObj", "singleValObj"), //$NON-NLS-1$ //$NON-NLS-2$ 					
					featureValJava("//Node/singleRef", "singleRef"), //$NON-NLS-1$ //$NON-NLS-2$ 										
				}));		
		
				Constraint selector = GMFMapFactory.eINSTANCE.createConstraint();
				selector.setLanguage(Language.JAVA_LITERAL);				
				selector.setBody("myNodeSelector"); //$NON-NLS-1$
				nme.setDomainSpecialization(selector);
				createReusedChildNodes(nme, new String[] { "//Node/nestedNodes1" }); //$NON-NLS-1$				
			}
		}
		
		static FeatureSeqInitializer createFSeqInit(FeatureInitDataHelper[] featureInits) {
			FeatureSeqInitializer elementInitializer = GMFMapFactory.eINSTANCE.createFeatureSeqInitializer();
			for (int i = 0; i < featureInits.length; i++) {
				elementInitializer.getInitializers().add(featureInits[i].createInitializer());
			}
			return elementInitializer;
		}
		
		static FeatureSeqInitializer newElementFSeqInit(FeatureInitDataHelper[] featureInits, EClass elementClass) {
			FeatureSeqInitializer elementInitializer = createFSeqInit(featureInits);
			if(elementClass != null) {
				elementInitializer.setElementClass(elementClass);
			}
			return elementInitializer;
		}
				
		private static abstract class FeatureInitDataHelper {
			protected final EStructuralFeature feature;
			
			protected FeatureInitDataHelper(EStructuralFeature feature) {
				this.feature = feature;
			}
			
			abstract FeatureInitializer createInitializer();
		}
		
		FeatureInitDataHelper featureValOCL(String featureQName, final String expressionBody) {
			return featureValOCL(modelAccess.findFeature(featureQName), expressionBody);
		}

		static FeatureInitDataHelper featureValOCL(EStructuralFeature sf, final String expressionBody) {
			return featureVal(sf, expressionBody, Language.OCL_LITERAL);
		}

		FeatureInitDataHelper featureValJava(String featureQName, final String expressionBody) {
			return featureVal(modelAccess.findFeature(featureQName), expressionBody, Language.JAVA_LITERAL);
		}

		private static FeatureInitDataHelper featureVal(EStructuralFeature sf, final String expressionBody, final Language expressionLang) {
			return new FeatureInitDataHelper(sf) {
				FeatureInitializer createInitializer() {
					FeatureValueSpec featureValueSpec = GMFMapFactory.eINSTANCE.createFeatureValueSpec();				
					featureValueSpec.setFeature(feature);
					ValueExpression value = GMFMapFactory.eINSTANCE.createValueExpression();
					value.setBody(expressionBody);
					value.setLanguage(expressionLang);
					featureValueSpec.setValue(value);
					return featureValueSpec;
				}					
			};
		}		
		
		FeatureInitDataHelper refNewElement(EStructuralFeature sf, final FeatureSeqInitializer[] elementInitializers) {
			return new FeatureInitDataHelper(sf) {
				FeatureInitializer createInitializer() {
					ReferenceNewElementSpec newElementSpec = GMFMapFactory.eINSTANCE.createReferenceNewElementSpec();
					newElementSpec.setFeature(feature);
					for (int i = 0; i < elementInitializers.length; i++) {
						newElementSpec.getNewElementInitializers().add(elementInitializers[i]);
					}
					return newElementSpec;
				}					
			};
		}		
		 

		private void createReusedChildNodes(NodeMapping topNode, String[] containmentFeatures) {
			for (int i = 0; i < containmentFeatures.length; i++) {
				ChildReference childRef = GMFMapFactory.eINSTANCE.createChildReference();
				childRef.setContainmentFeature(modelAccess.findReference(containmentFeatures[i])); 
				childRef.setReferencedChild(topNode);
				topNode.getChildren().add(childRef);
			}
		}		

		protected void initAudits() {
			AuditContainer auditContainer = createAuditContainer(Plugin.getPluginID() + ".<category1>" + System.currentTimeMillis()); //$NON-NLS-1$
			getMapping().setAudits(auditContainer);
						
			DomainElementTarget classA = GMFMapFactory.eINSTANCE.createDomainElementTarget();
			classA.setElement(getNodeA().getDomainMetaElement());
			DomainElementTarget classB = GMFMapFactory.eINSTANCE.createDomainElementTarget();
			classB.setElement(modelAccess.findClass("//nestedPckg/ClassA")); //$NON-NLS-1$ 			
			
			// Note; constraints must always be false in order to be collected in the asserted validation result
			// create ID with xml markup chars to test xml escaping in plugin.xml
			String constraintId1 = "<constraint.id1>"; //$NON-NLS-1$ 
			auditContainer.getAudits().add(createAudit(constraintId1, "false", classA, Severity.WARNING_LITERAL, false)); //$NON-NLS-1$
			auditContainer.getAudits().add(createAudit("constraint.id2", "false and nestedPckg::ClassA.allInstances()->size() > 0", classB, Severity.ERROR_LITERAL, true));	//$NON-NLS-1$ //$NON-NLS-2$
			
			AuditContainer subCat = createAuditContainer("category2"); //$NON-NLS-1$
			DiagramElementTarget nodeTarget = GMFMapFactory.eINSTANCE.createDiagramElementTarget();
			nodeTarget.setElement(getNodeB());
			auditContainer.getChildContainers().add(subCat);
			subCat.getAudits().add(createAudit("constraint.id3", "''='Foo'", nodeTarget, Severity.INFO_LITERAL, false)); //$NON-NLS-1$ //$NON-NLS-2$
			
			AuditContainer attrAuditContainer = createAuditContainer("audit_container.attributeTarget");  //$NON-NLS-1$
			auditContainer.getChildContainers().add(attrAuditContainer);

			DomainAttributeTarget attrTarget1 = GMFMapFactory.eINSTANCE.createDomainAttributeTarget();
			attrTarget1.setAttribute(modelAccess.findAttribute("//Node/name")); //$NON-NLS-1$
			attrTarget1.setNullAsError(true);
			attrAuditContainer.getAudits().add(createAudit("audit.attributeTarget.id1", "self = ''", attrTarget1, Severity.ERROR_LITERAL, false)); //$NON-NLS-1$ //$NON-NLS-2$
			
			DomainAttributeTarget attrTarget2 = GMFMapFactory.eINSTANCE.createDomainAttributeTarget();
			attrTarget2.setAttribute(modelAccess.findAttribute("//Node/acceptLinkKind")); //$NON-NLS-1$
			attrTarget2.setNullAsError(false);
			AuditRule regexpRule = createAudit("audit.attributeTarget.id2", "a*b", attrTarget2, Severity.ERROR_LITERAL, false); //$NON-NLS-1$ //$NON-NLS-2$
			regexpRule.getRule().setLanguage(Language.REGEXP_LITERAL);				
			attrAuditContainer.getAudits().add(regexpRule);
									
			DomainAttributeTarget attrTarget3 = GMFMapFactory.eINSTANCE.createDomainAttributeTarget();
			attrTarget3.setAttribute(modelAccess.findAttribute("//Node/acceptLinkKind")); //$NON-NLS-1$
			AuditRule javaRule1 = createAudit("audit.attributeTarget.id3", "myJavaAudit1", attrTarget3, Severity.ERROR_LITERAL, false); //$NON-NLS-1$ //$NON-NLS-2$
			javaRule1.getRule().setLanguage(Language.JAVA_LITERAL);				
			attrAuditContainer.getAudits().add(javaRule1);
		
			DomainAttributeTarget attrTarget4 = GMFMapFactory.eINSTANCE.createDomainAttributeTarget();
			attrTarget4.setAttribute(modelAccess.findAttribute("//Container/enumAttr_Init")); //$NON-NLS-1$
			AuditRule javaRule2 = createAudit("audit.attributeTarget.id4", "myJavaAudit2", attrTarget4, Severity.ERROR_LITERAL, false); //$NON-NLS-1$ //$NON-NLS-2$
			javaRule2.getRule().setLanguage(Language.JAVA_LITERAL);		
			attrAuditContainer.getAudits().add(javaRule2);
			
			DomainAttributeTarget attrTarget5 = GMFMapFactory.eINSTANCE.createDomainAttributeTarget();
			attrTarget5.setAttribute(modelAccess.findAttribute("//Node/multiValObj")); //$NON-NLS-1$
			attrTarget5.setNullAsError(false);
			AuditRule nregexpRule = createAudit("audit.attributeTarget.nregexp.id", "a*b", attrTarget5, Severity.ERROR_LITERAL, false); //$NON-NLS-1$ //$NON-NLS-2$
			nregexpRule.getRule().setLanguage(Language.NREGEXP_LITERAL);				
			attrAuditContainer.getAudits().add(nregexpRule);
			
			AuditedMetricTarget metricTarget = GMFMapFactory.eINSTANCE.createAuditedMetricTarget();
			Assert.assertTrue("Requires at least one metric definition", //$NON-NLS-1$
					getMapping().getMetrics() != null && getMapping().getMetrics().getMetrics().size() > 0);
			metricTarget.setMetric(getMapping().getMetrics().getMetrics().get(0));
			AuditRule metricAuditRule = createAudit("audit.metricTarget.id", "self > 0 and false", metricTarget, Severity.INFO_LITERAL, false); //$NON-NLS-1$ //$NON-NLS-2$
			auditContainer.getAudits().add(metricAuditRule);			
		}

		protected void setupClassLinkMapping(LinkMapping lme) {
			addCreationConstraints(lme, null, "self.acceptLinkKind = oppositeEnd.acceptLinkKind"); //$NON-NLS-1$
		}

		protected void setupReferenceLinkMapping(LinkMapping lme) {
			addCreationConstraints(lme, 
					"not self.acceptLinkKind.oclIsUndefined()", //$NON-NLS-1$
					"self.acceptLinkKind = oppositeEnd.acceptLinkKind"); //$NON-NLS-1$
		}
		
		private void initMetricContainer(DomainModelSource domainModel) {
			MetricContainer container = GMFMapFactory.eINSTANCE.createMetricContainer();		 
			MetricRule domainElementRule = createMetric("\"dom1\"", "1.2", null, null); //$NON-NLS-1$ //$NON-NLS-2$
			DomainElementTarget domainElementTarget = GMFMapFactory.eINSTANCE.createDomainElementTarget();
			// test name and description optionality
			domainElementRule.setName(null);		
			domainElementRule.setDescription(null);			
			domainElementTarget.setElement(domainModel.getNodeA().getEClass());
			domainElementRule.setTarget(domainElementTarget);
			container.getMetrics().add(domainElementRule);
			
			
			MetricRule reusedDiagramElementRule = createMetric("reused.node.mapping.diagramElement", "150", new Double(100), new Double(200)); //$NON-NLS-1$ //$NON-NLS-2$
			// set optional desc
			reusedDiagramElementRule.setDescription("A diagram metric with reused diagram element mapping"); //$NON-NLS-1$		
			
			DiagramElementTarget reusedDiagramElementTarget = GMFMapFactory.eINSTANCE.createDiagramElementTarget();
			reusedDiagramElementTarget.setElement(getNodeB());
			reusedDiagramElementRule.setTarget(reusedDiagramElementTarget);
			container.getMetrics().add(reusedDiagramElementRule);			

			MetricRule diagramElementRule = createMetric("node.mapping.diagramElement", "15", new Double(10), new Double(20)); //$NON-NLS-1$ //$NON-NLS-2$			
			DiagramElementTarget diagramElementTarget = GMFMapFactory.eINSTANCE.createDiagramElementTarget();
			diagramElementTarget.setElement(getNodeA());
			diagramElementRule.setTarget(diagramElementTarget);
			container.getMetrics().add(diagramElementRule);			

			getMapping().setMetrics(container);
		}
		
		private static MetricRule createMetric(String key, String oclBody, Double low, Double high) {
			MetricRule rule = GMFMapFactory.eINSTANCE.createMetricRule();
			rule.setKey(key);
			// Note: use characters that need to be escaped in java source string literals
			rule.setName("Name of \"" + key + "\""); //$NON-NLS-1$ //$NON-NLS-2$
			rule.setDescription("Description of \"" + key + "\""); //$NON-NLS-1$ //$NON-NLS-2$
			rule.setRule(GMFMapFactory.eINSTANCE.createValueExpression());
			rule.getRule().setBody(oclBody);
			rule.setLowLimit(low);
			rule.setHighLimit(high);
			return rule;
		}		
	}	
}
