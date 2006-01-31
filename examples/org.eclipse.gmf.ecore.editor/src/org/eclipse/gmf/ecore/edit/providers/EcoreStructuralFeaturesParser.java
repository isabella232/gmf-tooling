package org.eclipse.gmf.ecore.edit.providers;

import java.text.FieldPosition;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeModelCommand;

/**
 * @generated
 */
public class EcoreStructuralFeaturesParser extends EcoreAbstractParser {

	/**
	 * @generated
	 */
	private List features;

	/**
	 * @generated
	 */
	public EcoreStructuralFeaturesParser(List features) {
		this.features = features;
	}

	/**
	 * @generated
	 */
	protected String getStringByPattern(IAdaptable adapter, int flags, String pattern, MessageFormat processor) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		List values = new ArrayList(features.size());
		for (Iterator it = features.iterator(); it.hasNext();) {
			Object value = element.eGet((EStructuralFeature) it.next());
			values.add(value);
		}
		return processor.format(values.toArray(new Object[values.size()]), new StringBuffer(), new FieldPosition(0)).toString();
	}

	/**
	 * @generated
	 */
	protected IParserEditStatus validateNewValues(Object[] values) {
		return values.length == features.size() ? ParserEditStatus.EDITABLE_STATUS : ParserEditStatus.UNEDITABLE_STATUS;
	}

	/**
	 * @generated
	 */
	public ICommand getParseCommand(IAdaptable adapter, Object[] newValues) {
		EObject element = (EObject) adapter.getAdapter(EObject.class);
		CompositeModelCommand command = new CompositeModelCommand("Set Values");
		for (int i = 0; i < newValues.length; i++) {
			EStructuralFeature feature = (EStructuralFeature) features.get(i);
			command.compose(getModificationCommand(element, feature, newValues[i]));
		}
		return command;
	}

	/**
	 * @generated
	 */
	public boolean isAffectingEvent(Object event, int flags) {
		if (event instanceof Notification) {
			Object feature = ((Notification) event).getFeature();
			if (features.contains(feature)) {
				return true;
			}
		}
		return false;
	}
}
