/**
 * Copyright (c) 2006, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package gmfgraph

import org.eclipse.gmf.gmfgraph.Dimension
import org.eclipse.gmf.gmfgraph.Insets
import org.eclipse.gmf.gmfgraph.Point

/**
 * No mapMode at all, provided only as hook for extenders
 */
@com.google.inject.Singleton class MapMode {
	def dispatch mapMode(Dimension it) '''«dx», «dy»'''

	def dispatch mapMode(Point it) '''«x», «y»'''

	def dispatch mapMode(Integer it) '''«it»'''

	def dispatch mapMode(Insets it) '''«top», «left», «bottom», «right»'''

	def Activator() ''''''
}
