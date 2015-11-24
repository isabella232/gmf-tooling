/**
 * Copyright (c) 2015 Montages AG
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.gmf.tooling.codegen.maven;

import org.codehaus.plexus.component.annotations.Component;
import org.eclipse.sisu.equinox.launching.EquinoxLauncher;
import org.eclipse.sisu.equinox.launching.internal.DefaultEquinoxLauncher;

@Component(role=EquinoxLauncher.class)
public class GenerateEquinoxLauncher extends DefaultEquinoxLauncher {

}
