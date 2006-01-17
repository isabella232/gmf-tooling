/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    dstadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.dashboard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;

/**
 * @author dstadnik
 */
public class ModelFigure extends RoundedRectangle {

	private Label description;

	private IFigure actionsPlate;

	private List separators;

	private List holders;

	public ModelFigure() {
		separators = new ArrayList();
		holders = new ArrayList();
		ToolbarLayout layout = new ToolbarLayout();
		layout.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
		setLayoutManager(layout);
		IFigure descriptionHolder = new Figure();
		descriptionHolder.setLayoutManager(new StackLayout());
		holders.add(descriptionHolder);
		add(descriptionHolder);
		description = new Label();
		descriptionHolder.add(description);
		SeparatorFigure s1 = new SeparatorFigure();
		separators.add(s1);
		add(s1);
		actionsPlate = new Figure();
		ToolbarLayout actionsLayout = new ToolbarLayout();
		actionsLayout.setStretchMinorAxis(false);
		actionsPlate.setLayoutManager(actionsLayout);
		holders.add(actionsPlate);
		add(actionsPlate);
		updateSpacing();
	}

	protected void updateSpacing() {
		setBorder(new MarginBorder(corner.height, 0, corner.height, 0));
		for (Iterator it = separators.iterator(); it.hasNext();) {
			SeparatorFigure separator = (SeparatorFigure) it.next();
			separator.setPreferredSize(new Dimension(0, corner.height * 2 + separator.getLineWidth()));
		}
		for (Iterator it = holders.iterator(); it.hasNext();) {
			IFigure holder = (IFigure) it.next();
			holder.setBorder(new MarginBorder(0, corner.width, 0, corner.width));
		}
	}

	public void setCornerDimensions(Dimension d) {
		super.setCornerDimensions(d);
		updateSpacing();
	}

	public String getDescription() {
		return description.getText();
	}

	public void setDescription(String description) {
		this.description.setText(description);
	}

	public void addAction(IFigure actionFigure) {
		IFigure plate = new Figure();
		ToolbarLayout layout = new ToolbarLayout(true);
		layout.setSpacing(3);
		plate.setLayoutManager(layout);
		Label bullet = new Label();
		bullet.setText("-");
		plate.add(bullet);
		plate.add(actionFigure);
		actionsPlate.add(plate);
	}
}
