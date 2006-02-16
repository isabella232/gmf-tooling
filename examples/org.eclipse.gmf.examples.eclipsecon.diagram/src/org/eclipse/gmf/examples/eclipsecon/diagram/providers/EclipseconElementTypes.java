package org.eclipse.gmf.examples.eclipsecon.diagram.providers;

import java.util.IdentityHashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IMetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;

import org.eclipse.gmf.examples.eclipsecon.diagram.part.EclipseconDiagramEditorPlugin;

import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper;

/**
 * @generated
 */
public class EclipseconElementTypes {

	/**
	 * @generated
	 */
	private EclipseconElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map elements;

	/**
	 * @generated
	 */
	private static ImageRegistry imageRegistry;

	/**
	 * @generated
	 */
	private static ImageRegistry getImageRegistry() {
		if (imageRegistry == null) {
			imageRegistry = new ImageRegistry();
		}
		return imageRegistry;
	}

	/**
	 * @generated
	 */
	private static String getImageRegistryKey(ENamedElement element) {
		return element.getName();
	}

	/**
	 * @generated
	 */
	private static ImageDescriptor getProvidedImageDescriptor(
			ENamedElement element) {
		if (element instanceof EStructuralFeature) {
			element = ((EStructuralFeature) element).getEContainingClass();
		}
		if (element instanceof EClass) {
			EClass eClass = (EClass) element;
			if (!eClass.isAbstract()) {
				return EclipseconDiagramEditorPlugin.getInstance()
						.getItemImageDescriptor(
								eClass.getEPackage().getEFactoryInstance()
										.create(eClass));
			}
		}
		// TODO : support structural features
		return null;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		String key = getImageRegistryKey(element);
		ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
		if (imageDescriptor == null) {
			imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
		}
		return imageDescriptor;
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		String key = getImageRegistryKey(element);
		Image image = getImageRegistry().get(key);
		if (image == null) {
			ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
			if (imageDescriptor == null) {
				imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
			}
			getImageRegistry().put(key, imageDescriptor);
			image = getImageRegistry().get(key);
		}
		return image;
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		ENamedElement element = getElement(hint);
		if (element == null) {
			return null;
		}
		return getImage(element);
	}

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap();
			elements.put(Conference_79, EclipseconPackage.eINSTANCE
					.getConference());
			elements.put(TimeSlot_2001, EclipseconPackage.eINSTANCE
					.getTimeSlot());
			elements.put(Presenter_1001, EclipseconPackage.eINSTANCE
					.getPresenter());
			elements.put(Schedule_1002, EclipseconPackage.eINSTANCE
					.getSchedule());
			elements.put(Tutorial_1003, EclipseconPackage.eINSTANCE
					.getTutorial());
			elements.put(Resource_1004, EclipseconPackage.eINSTANCE
					.getResource());
			elements
					.put(Handout_3001, EclipseconPackage.eINSTANCE.getHandout());
			elements.put(TutorialPresenters_3002, EclipseconPackage.eINSTANCE
					.getTutorial_Presenters());
			elements.put(TutorialAssigned_3003, EclipseconPackage.eINSTANCE
					.getTutorial_Assigned());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	public static final IMetamodelType Conference_79 = new MetamodelType(
			"Conference_79", null, "Conference", EclipseconPackage.eINSTANCE
					.getConference(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType TimeSlot_2001 = new MetamodelType(
			"TimeSlot_2001", null, "TimeSlot", EclipseconPackage.eINSTANCE
					.getTimeSlot(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType Presenter_1001 = new MetamodelType(
			"Presenter_1001", null, "Presenter", EclipseconPackage.eINSTANCE
					.getPresenter(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType Schedule_1002 = new MetamodelType(
			"Schedule_1002", null, "Schedule", EclipseconPackage.eINSTANCE
					.getSchedule(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType Tutorial_1003 = new MetamodelType(
			"Tutorial_1003", null, "Tutorial", EclipseconPackage.eINSTANCE
					.getTutorial(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType Resource_1004 = new MetamodelType(
			"Resource_1004", null, "Resource", EclipseconPackage.eINSTANCE
					.getResource(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType Handout_3001 = new MetamodelType(
			"Handout_3001", null, "Handout", EclipseconPackage.eINSTANCE
					.getHandout(), new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType TutorialPresenters_3002 = new MetamodelType(
			"TutorialPresenters_3002", null, "TutorialPresenters", null,
			new NullEditHelper());

	/**
	 * @generated
	 */
	public static final IMetamodelType TutorialAssigned_3003 = new MetamodelType(
			"TutorialAssigned_3003", null, "TutorialAssigned", null,
			new NullEditHelper());

	/**
	 * @generated
	 */
	public static void register() {
		ElementTypeRegistry.getInstance().register(Conference_79);
		ElementTypeRegistry.getInstance().register(TimeSlot_2001);
		ElementTypeRegistry.getInstance().register(Presenter_1001);
		ElementTypeRegistry.getInstance().register(Schedule_1002);
		ElementTypeRegistry.getInstance().register(Tutorial_1003);
		ElementTypeRegistry.getInstance().register(Resource_1004);
		ElementTypeRegistry.getInstance().register(Handout_3001);
		ElementTypeRegistry.getInstance().register(TutorialPresenters_3002);
		ElementTypeRegistry.getInstance().register(TutorialAssigned_3003);
	}

	/**
	 * @generated
	 */
	public static class NullEditHelper extends AbstractEditHelper {

		/**
		 * @generated
		 */
		public ICommand getEditCommand(IEditCommandRequest req) {
			if (!(req instanceof ConfigureRequest)) {
				EclipseconDiagramEditorPlugin.getInstance().logError(
						"unserved request " + req);
			}
			return null;
		}
	}
}
