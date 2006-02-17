package org.eclipse.gmf.examples.eclipsecon.diagram.custom.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.render.RenderedImage;
import org.eclipse.gmf.runtime.draw2d.ui.render.factory.RenderedImageFactory;
import org.eclipse.gmf.runtime.draw2d.ui.render.figures.ScalableImageFigure;


public class ImageResizableCompartmentEditPart
	extends ResizableCompartmentEditPart {

	public ImageResizableCompartmentEditPart(EObject model) {
		super(model);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		ResizableCompartmentFigure fig = (ResizableCompartmentFigure)super.createFigure();
		
		RenderedImage rndImg = RenderedImageFactory.getInstance("c:\\boat.svg");//$NON-NLS-1$
		ScalableImageFigure sif = new ScalableImageFigure(rndImg, false, true, true);
		sif.setPreferredImageSize(getMapMode().DPtoLP(140), getMapMode().DPtoLP(100));
		fig.getContentPane().add(sif);
		fig.getContentPane().setLayoutManager(new StackLayout());
		
		return fig;
	}

}
