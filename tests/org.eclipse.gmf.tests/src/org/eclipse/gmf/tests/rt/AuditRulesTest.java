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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import junit.framework.Assert;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.CategoryManager;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.model.IModelConstraint;
import org.eclipse.emf.validation.service.IConstraintDescriptor;
import org.eclipse.emf.validation.service.IValidationListener;
import org.eclipse.emf.validation.service.IValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.emf.validation.service.ValidationEvent;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.mappings.AuditContainer;
import org.eclipse.gmf.mappings.AuditRule;
import org.eclipse.gmf.mappings.Mapping;
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
		auditAssert = new AuditAssert(genDiagram.getEditorGen().getPlugin().getID(), genDiagram.getDomainDiagramElement().getGenPackage());
	}

	public void testAuditConstraints() throws Exception {		
		auditAssert.assertAuditContainer(audits);
	}

	private static class AuditAssert {
		private String pluginId;
		private GenPackage domainModel;

		AuditAssert(String pluginIdentifier, GenPackage domainModel) {
			this.pluginId = pluginIdentifier;
			this.domainModel = domainModel;
		}

		String constraintGlobalId(AuditRule audit) {
			return pluginId + "." + audit.getId(); //$NON-NLS-1$			
		}

		void assertAudit(AuditRule audit) {
			EClass target = ModelValidationService.findClass(domainModel.getNSURI(), audit.getTarget().getName());
			EObject validatedInstance = target.getEPackage().getEFactoryInstance().create(target);
			
			assertEvaluation(audit, validatedInstance);			
			// Note: Only when the constraint is used in evaluation, its descriptor gets 
			// registered in ConstraintRegistry (lazily constructed)
			IConstraintDescriptor descriptor = org.eclipse.emf.validation.service.ConstraintRegistry.getInstance().getDescriptor(pluginId, audit.getId());
			assertNotNull("Audit rule must be in ConstraintRegistry", descriptor); //$NON-NLS-1$

			assertTrue("The target class must be accepted", descriptor.targetsTypeOf(validatedInstance)); //$NON-NLS-1$
			

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
				assertEquals(descriptor.getEvaluationMode(), org.eclipse.emf.validation.model.EvaluationMode.NULL);
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

			assertEquals("Constraint category must be registered", //$NON-NLS-1$
					categories.iterator().next(), CategoryManager.getInstance().getCategory(AuditAssert.getCategoryPath(audit.getContainer())));
			assertEvaluation(audit, validatedInstance);
		}

		/*
		 * Checks if the constraint is correctly targeted to validated instances.
		 */
		void assertEvaluation(final AuditRule audit, final EObject validatedInstance) {
			final IModelConstraint[] constraintFound = new IModelConstraint[1];
			IValidationListener listener = new IValidationListener() {
				public void validationOccurred(ValidationEvent event) {
					boolean isTargetMatch = false;
					for (Iterator it = event.getValidationTargets().iterator(); it.hasNext();) {
						if(it.next() == validatedInstance) {
							isTargetMatch = true; //
							break;
						}						
					}
					Assert.assertTrue("Target object must be validated", isTargetMatch); //$NON-NLS-1$

					for (Iterator it = event.getValidationResults().iterator(); it.hasNext();) {
						IConstraintStatus status = (IConstraintStatus) it.next();
						if (constraintGlobalId(audit).equals(status.getConstraint().getDescriptor().getId())) {
							constraintFound[0] = status.getConstraint();
							break;
						}
					}
				}
			};

			ModelValidationService.getInstance().addValidationListener(listener);

			IValidator validator = ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
			validator.setReportSuccesses(true);
			validator.validate(validatedInstance);

			ModelValidationService.getInstance().removeValidationListener(listener);

			assertNotNull("Constraint must be involved in validation", constraintFound[0]); //$NON-NLS-1$			
		}

		void assertAuditContainer(AuditContainer auditContainer) {
			org.eclipse.emf.validation.model.Category category = org.eclipse.emf.validation.model.CategoryManager.getInstance().getCategory(getCategoryPath(auditContainer));
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

		static String getCategoryPath(AuditContainer container) {
			List pathElements = new ArrayList();
			for (AuditContainer current = container; current != null; current = current.getParentContainer()) {
				pathElements.add(0, current);
			}
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < pathElements.size(); i++) {
				AuditContainer nextContainer = (AuditContainer) pathElements.get(i);
				if (i > 0) {
					buf.append('/');
				}
				buf.append(nextContainer.getId());
			}
			return buf.toString();
		}
	}
}
