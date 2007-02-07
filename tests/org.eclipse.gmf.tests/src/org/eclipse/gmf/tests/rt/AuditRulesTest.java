/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Radek Dvorak (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.rt;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.model.CategoryManager;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.emf.validation.service.IValidationListener;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.emf.validation.service.ValidationEvent;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenDomainElementTarget;
import org.eclipse.gmf.mappings.AuditContainer;
import org.eclipse.gmf.mappings.AuditRule;
import org.eclipse.gmf.mappings.AuditedMetricTarget;
import org.eclipse.gmf.mappings.DiagramElementTarget;
import org.eclipse.gmf.mappings.DomainAttributeTarget;
import org.eclipse.gmf.mappings.DomainElementTarget;
import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.gmf.mappings.MappingEntry;
import org.eclipse.gmf.mappings.NodeMapping;
import org.eclipse.gmf.mappings.NotationElementTarget;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.setup.MapDefSource;

/**
 * Tests valid registration of audit rule definitions in emft validation framework
 * constraint registry and correct evaluation on targeted objects.
 * 
 * Remark:
 * Assertion logic is separated into <code>AuditAssert</code> nested class to avoid 
 * initialization of the emft validation framework constraint registry before 
 * the gmf editor plugin is generated and installed.
 * This would happen during reflective inspection of this testcase class by junit test 
 * runner.
 * The reason is that the validation framework collects all constraint 
 * providers descriptor only once during its bundle activation and newly installed extensions
 *  would not be added  
 */
public class AuditRulesTest extends RuntimeDiagramTestBase {
	private AuditContainer audits;
	private AuditAssert auditAssert;
	private EList targetedPackages;

	public AuditRulesTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		MapDefSource mapSource = getSetup().getMapModel();
		assertNotNull("Requires MapDefSource in setup", mapSource); //$NON-NLS-1$
		Mapping mapping = mapSource.getMapping();
		this.audits = mapping.getAudits();
		assertNotNull("Requires mapping with audit rules", audits); //$NON-NLS-1$
		final GenDiagram genDiagram = getSetup().getGenModel().getGenDiagram();
		
		this.targetedPackages = genDiagram.getEditorGen().getAudits().getAllTargetedModelPackages();
		auditAssert = new AuditAssert(genDiagram.getEditorGen().getPlugin().getID());
	}

	
	public void testNestedPackageAuditTarget() throws Exception {
		GenModel domainGenModel = getSetup().getGenModel().getGenDiagram().getDomainDiagramElement().getGenPackage().getGenModel();
		GenClass genClass = null;
		String qualifiedClassName = null;
		for (Iterator it = domainGenModel.getAllGenPackagesWithClassifiers().iterator(); it.hasNext();) {
			GenPackage nextPackage = (GenPackage) it.next();
			if(nextPackage.getSuperGenPackage() != null) {
				assertFalse(nextPackage.getGenClasses().isEmpty());				
				genClass = (GenClass)nextPackage.getGenClasses().get(0);
				qualifiedClassName = nextPackage.getSuperGenPackage().getPackageName() + "." + //$NON-NLS-1$ 
										nextPackage.getPackageName() + "." + genClass.getName(); //$NON-NLS-1$
			}
		}
		
		assertNotNull("Test requires EClass in a nested package", genClass); //$NON-NLS-1$
		GenDomainElementTarget domainElementTarget = GMFGenFactory.eINSTANCE.createGenDomainElementTarget();
		domainElementTarget.setElement(genClass);		
		assertEquals(qualifiedClassName, domainElementTarget.getTargetClassModelQualifiedName());		
	}	
	
	public void testAuditConstraints() throws Exception {		
		auditAssert.assertAuditContainer(audits);
		assertTrue("Tests requires at least one audit with LIVE constraint", auditAssert.liveConstraintTested);		
	}

	private class AuditAssert {
		private String pluginId;
		private boolean liveConstraintTested = false;
		
		AuditAssert(String pluginIdentifier) {
			this.pluginId = pluginIdentifier;
		}

		String constraintGlobalId(AuditRule audit) {
			return pluginId + "." + audit.getId(); //$NON-NLS-1$			
		}

		void assertAudit(AuditRule audit) { 			
			EClass target = findCanonicalEClass(getTargetEClass(audit));
			EObject validatedInstance = null;
			if(NotationPackage.eINSTANCE.getView().isSuperTypeOf(target)) {
				validatedInstance = createNode(getSetup().getGenModel().getNodeB(), getDiagram());
			} else {
				validatedInstance = target.getEPackage().getEFactoryInstance().create(target);
			}
			
			assertEvaluation(audit, validatedInstance);

			// Note: Only when the constraint is used in evaluation, its descriptor gets 
			// registered in ConstraintRegistry (lazily constructed)
			IConstraintDescriptor descriptor = org.eclipse.emf.validation.service.ConstraintRegistry.getInstance().getDescriptor(pluginId, audit.getId());
			assertNotNull("Audit rule must be in ConstraintRegistry", descriptor); //$NON-NLS-1$

			assertTrue("The target class must be accepted", descriptor.targetsTypeOf(validatedInstance)); //$NON-NLS-1$
			

			// augment to reveal reason for test failures
			if (!descriptor.isEnabled()) {
				System.err.println("descriptor is dispabled"); //$NON-NLS-1$
				System.err.println("descriptor.isError:" + descriptor.isError()); //$NON-NLS-1$
				if (descriptor.isError()) {
					descriptor.getException().printStackTrace(System.err);
				}
			}
			assertTrue("Descriptor shoud be valid and enabled", //$NON-NLS-1$ 
					descriptor.isEnabled());
			assertEquals("Constraint id must match", //$NON-NLS-1$
					constraintGlobalId(audit), descriptor.getId());
			assertEquals("Constraint Name must match", //$NON-NLS-1$ 
					audit.getName(), descriptor.getName());
			assertEquals("Severity must match", //$NON-NLS-1$
					audit.getSeverity().getName(), descriptor.getSeverity().getName());
			assertNotNull("target class is required", audit.getTarget()); //$NON-NLS-1$

			if (audit.isUseInLiveMode()) {
				// mixed mode expected
				assertEquals(descriptor.getEvaluationMode(), org.eclipse.emf.validation.model.EvaluationMode.LIVE);
				liveConstraintTested = true;				
			} else {
				assertEquals(descriptor.getEvaluationMode(), org.eclipse.emf.validation.model.EvaluationMode.BATCH);
			}
 
			assertEquals("Constraint description must match", //$NON-NLS-1$
				audit.getDescription(), descriptor.getDescription());
			assertEquals("Constraint message must match", //$NON-NLS-1$
				audit.getMessage(), descriptor.getMessagePattern());
			// check categories
			Set categories = descriptor.getCategories();
			assertEquals("Single category expected", 1, categories.size()); //$NON-NLS-1$

			assertEquals(".Constraint category must be registered", //$NON-NLS-1$
					categories.iterator().next(), CategoryManager.getInstance().getCategory(getCategoryPath(audit.getContainer())));
		}

		/*
		 * Checks if the constraint is correctly targeted to validated instances.
		 */
		void assertEvaluation(final AuditRule audit, final EObject target) {
			final EObject[] validatedInstance = new EObject[1];		
			// Note: use notation::View host for the validated element in case of domain EObject to adapt the
			// runValidation method in the Validation provider
			if(target instanceof View) {
				validatedInstance[0] = target;
			} else {				
				Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
				View node = NotationFactory.eINSTANCE.createNode();
				node.setElement(target);
				validatedInstance[0] = node;
				diagram.getTransientChildren().add(node);

				ResourceSet rset = new ResourceSetImpl();
				Resource r = rset.createResource(URI.createURI("xttp://myresource"));
				r.getContents().add(diagram);
				TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rset);
			}
			
			final IModelConstraint[] constraintFound = new IModelConstraint[1];
			IValidationListener listener = new IValidationListener() {
				public void validationOccurred(ValidationEvent event) {
					boolean isTargetMatch = false;
					for (Iterator it = event.getValidationTargets().iterator(); it.hasNext();) {
						if(it.next() == target) {
							isTargetMatch = true; //
							break;
						}						
					}
					if(!isTargetMatch) return;

					for (Iterator it = event.getValidationResults().iterator(); it.hasNext();) {
						IConstraintStatus status = (IConstraintStatus) it.next();
						if (constraintGlobalId(audit).equals(status.getConstraint().getDescriptor().getId())) {
							constraintFound[0] = status.getConstraint();
							break;
						}
					}
				}
			};

			Method validationMethod = null;
			try {
				Class validationProviderClass = loadGeneratedClass(getGenModel().getGenDiagram().getValidationProviderQualifiedClassName() + "$ValidateAction"); //$NON-NLS-1$
				validationMethod = validationProviderClass.getMethod("runNonUIValidation", new Class[] { View.class } ); //$NON-NLS-1$
			} catch (Exception e) {
				fail(" Could not find runValidation operation in ValidationProvider"); //$NON-NLS-1$ 
				e.printStackTrace();
			}

			try {
				ModelValidationService.getInstance().addValidationListener(listener);
				validationMethod.invoke(null, new Object[] { validatedInstance[0] });
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ModelValidationService.getInstance().removeValidationListener(listener);					
			}

			assertNotNull("Constraint must be involved in validation", constraintFound[0]); //$NON-NLS-1$			
		}

		void assertAuditContainer(AuditContainer auditContainer) {
			final String categoryPath = getCategoryPath(auditContainer);
			assertNotNull("Category should be registered", CategoryManager.getInstance().findCategory(categoryPath));
			org.eclipse.emf.validation.model.Category category = org.eclipse.emf.validation.model.CategoryManager.getInstance().getCategory(categoryPath);
			assertEquals("Category id must match", //$NON-NLS-1$ 
					auditContainer.getId(), category.getId());
			assertEquals("Category name must match", //$NON-NLS-1$
					auditContainer.getName(), category.getName());
			assertEquals("Category description must match", //$NON-NLS-1$
					auditContainer.getDescription(), category.getDescription());		

			for (Iterator it = auditContainer.getAudits().iterator(); it.hasNext();) {
				AuditRule nextRule = (AuditRule) it.next();
				assertAudit(nextRule);
			}
			for (Iterator it = auditContainer.getChildContainers().iterator(); it.hasNext();) {
				assertAuditContainer((AuditContainer) it.next());
			}
		}

		String getCategoryPath(AuditContainer container) {
			List<AuditContainer> pathElements = new ArrayList<AuditContainer>();
			for (AuditContainer current = container; current != null; current = current.getParentContainer()) {
				pathElements.add(0, current);
			}
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < pathElements.size(); i++) {
				AuditContainer nextContainer = pathElements.get(i);
				if (i > 0) {
					buf.append('/');
				}
				buf.append(nextContainer.getId());
			}
			return buf.toString();
		}
	}
	
	EClass findCanonicalEClass(EClass eClass) {
		String nsURI = eClass.getEPackage().getNsURI();
		GenPackage genPackage = null;
		for (Iterator it = targetedPackages.iterator(); it.hasNext();) {
			GenPackage nextPackage = (GenPackage) it.next();
			if(nsURI.equals(nextPackage.getNSURI())) {
				genPackage = nextPackage;
				break;
			}
		}
		assertNotNull("GenPackage for EClass target not found", genPackage); //$NON-NLS-1$		
		try {
			Class packageInterfaceClass = getSetup().getGenProject().getBundle().loadClass(genPackage.getQualifiedPackageInterfaceName());
			Field instanceField = packageInterfaceClass.getField("eINSTANCE"); //$NON-NLS-1$
			Object packageInstance = instanceField.get(packageInterfaceClass);
			assertTrue("Expected EPackage instance", packageInstance instanceof EPackage); //$NON-NLS-1$
			EPackage ePackage = (EPackage)packageInstance;
			EClassifier eClassifier = ePackage.getEClassifier(eClass.getName());
			assertTrue("EClassifier must be eclass", eClassifier instanceof EClass); //$NON-NLS-1$
			return (EClass)eClassifier;
		} catch (Exception e) {
			e.printStackTrace();
		}
		fail("Failed to access EPackage from the generated model"); //$NON-NLS-1$		
		return null; // make compiler happy
	}
	
	static EClass getTargetEClass(AuditRule rule) {
		assertNotNull("Audit target must be set", rule.getTarget()); //$NON-NLS-1$
		return getTargetEClass(rule.getTarget());
	}
	
	static EClass getTargetEClass(EObject target) {
		if(target instanceof DomainElementTarget) {
			return ((DomainElementTarget)target).getElement();
		} else if(target instanceof NotationElementTarget) {
			return ((NotationElementTarget)target).getElement();
		} else if(target instanceof DiagramElementTarget) {
			DiagramElementTarget diagramElementTarget = (DiagramElementTarget)target;
			MappingEntry entry = diagramElementTarget.getElement();
			if(entry instanceof NodeMapping) {
				return NotationPackage.eINSTANCE.getNode();
			} else if(entry instanceof LinkMapping) {
				return NotationPackage.eINSTANCE.getEdge();
			}
		} else if(target instanceof DomainAttributeTarget) {
			DomainAttributeTarget attrTarget = (DomainAttributeTarget)target;
			return attrTarget.getAttribute().getEContainingClass();
		} else if(target instanceof AuditedMetricTarget) {
			return getTargetEClass(((AuditedMetricTarget)target).getMetric().getTarget());
		}
		fail("No target class"); //$NON-NLS-1$
		return null;
	}	
}
