package org.eclipse.gmf.examples.layers.subdiagrams.popup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.dialogs.IInputValidator;

class UniqueNameValidator implements IInputValidator {

	private final Set<String> myAllNames = new HashSet<String>();

	private boolean myAllowEmptyName;

	public UniqueNameValidator(List<? extends EObject> objects, EStructuralFeature nameFeature) {
		for (EObject next : objects) {
			Object nextValue = next.eGet(nameFeature);
			if (nextValue != null) {
				myAllNames.add(String.valueOf(nextValue));
			}
		}
	}

	public void setAllowEmptyName(boolean allowEmptyName) {
		myAllowEmptyName = allowEmptyName;
	}

	@Override
	public String isValid(String newText) {
		if (newText == null) {
			return myAllowEmptyName ? null : "Empty Name Is Not Allowed";
		}
		newText = newText.trim();
		if (newText.length() == 0 && !myAllowEmptyName) {
			return "Empty Name Is Not Allowed";
		}
		if (myAllNames.contains(newText)) {
			return "This Name Already Exists";
		}
		return null;
	}

	public String guessNewName(String prefix) {
		for (int i = 0; i < 26; i++) {
			String nextCandidate = prefix + (char) ('A' + i);
			if (isValid(nextCandidate) == null) {
				return nextCandidate;
			}
		}

		//wow
		int i = 0;
		while (++i < 1000) {
			String nextCandidate = prefix + i;
			if (isValid(nextCandidate) == null) {
				return nextCandidate;
			}
		}

		return "<can't guess -- too many names already>";
	}

}