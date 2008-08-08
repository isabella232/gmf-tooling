/*
 * Copyright (c) 2005,2006 Sven Efftinge and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sven Efftinge - Initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.model;

import org.eclipse.emf.ecore.EClassifier;

/**
 * FIXME Do we need Variables now, with explicit OCLEnvironment available? 
 * @author Sven Efftinge
 * @author Arno Haase
 */
public class Variable {

    private final String name;

    private final Object value;

	private final EClassifier type;

	/**
	 * type and value may be null 
	 */
    public Variable(final String name, final EClassifier type, final Object value) {
		if (name == null) {
			throw new NullPointerException("name must not be null!");
		}
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public EClassifier getType() {
		return type;
	}

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((name == null) ? 0 : name.hashCode());
        result = PRIME * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
			return true;
		}
        if (obj == null) {
			return false;
		}
        if (getClass() != obj.getClass()) {
			return false;
		}
        final Variable other = (Variable) obj;
        if (name == null) {
            if (other.name != null) {
				return false;
			}
        } else if (!name.equals(other.name)) {
			return false;
		}
        if (value == null) {
            return other.value == null;
        } else {
			return value.equals(other.value);
		}
    }

    @Override
	public String toString () {
        return "Variable [" + name + "="+ value + "]";
    }
}
