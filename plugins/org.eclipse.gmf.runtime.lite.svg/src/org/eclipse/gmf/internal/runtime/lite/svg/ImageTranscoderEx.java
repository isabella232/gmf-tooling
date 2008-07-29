/**
 * Copyright (c) 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.runtime.lite.svg;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.batik.bridge.BaseScriptingEnvironment;
import org.apache.batik.bridge.BridgeContext;
import org.apache.batik.bridge.BridgeException;
import org.apache.batik.bridge.GVTBuilder;
import org.apache.batik.dom.svg.SVGDOMImplementation;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.dom.util.DOMUtilities;
import org.apache.batik.ext.awt.image.GraphicsUtil;
import org.apache.batik.gvt.CanvasGraphicsNode;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.ImageTranscoder;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.svg.SVGSVGElement;

public class ImageTranscoderEx extends ImageTranscoder {

	private BufferedImage bufferedImage;

	/**
	 * buildGVTTree This method builds the GVT tree that is used to render the SVG data.
	 * 
	 * @param svgDoc SVGOMDocument representing the physical SVG document.
	 * @param context BridgeContext containing information of the render to occur.
	 * @return GraphicsNode object.
	 * @throws TranscoderException thrown if a BridgeException occurs when building the root object.
	 */
	protected GraphicsNode buildGVTTree(SVGOMDocument svgDoc, BridgeContext context) throws TranscoderException {
		GVTBuilder gvtBuilder = new GVTBuilder();
		try {
			return gvtBuilder.build(context, svgDoc);
		} catch (BridgeException ex) {
			throw new TranscoderException(ex);
		}
	}

	/**
	 * calculateSizeTransform Calculates the transformation matrix that is applied during the render operation. Specifically,
	 * the transformation for changing the size of the rendered data.
	 * 
	 * @param svgRoot SVGSVGElement root element of the SVG tree.
	 * @param gvtRoot GraphicsNode graphic node root
	 * @param docWidth float width values of the original vector.
	 * @param docHeight float height values of the original vector.
	 * @param newWidth float width values of the rendered image.
	 * @param newHeight float height values of the rendered image.
	 * @return AffineTransform object that represents the size transformation to take place.
	 * @throws TranscoderException thrown if a BridgeException occurs when building the root object.
	 */
	protected AffineTransform calculateSizeTransform(SVGSVGElement svgRoot, GraphicsNode gvtRoot, float docWidth,
			float docHeight, float newWidth, float newHeight) throws TranscoderException {
		AffineTransform Px;
		float xscale = newWidth / docWidth;
		float yscale = newHeight / docHeight;
		Px = AffineTransform.getScaleInstance(xscale, yscale);

		// take the AOI into account if any
		if (hints.containsKey(KEY_AOI)) {
			Rectangle2D aoi = (Rectangle2D) hints.get(KEY_AOI);
			// transform the AOI into the image's coordinate system
			aoi = Px.createTransformedShape(aoi).getBounds2D();
			AffineTransform Mx = new AffineTransform();
			double sx = newWidth / aoi.getWidth();
			double sy = newHeight / aoi.getHeight();
			Mx.scale(sx, sy);
			double tx = -aoi.getX();
			double ty = -aoi.getY();
			Mx.translate(tx, ty);

			// take the AOI transformation matrix into account
			// we apply first the preserveAspectRatio matrix
			Px.preConcatenate(Mx);
		}

		CanvasGraphicsNode cgn = getCanvasGraphicsNode(gvtRoot);
		if (cgn != null) {
			cgn.setViewingTransform(Px);
			curTxf = new AffineTransform();
		} else {
			curTxf = Px;
		}

		return curTxf;
	}

	private boolean shouldCopyDocument(Document document) {
		if (!(document.getImplementation() instanceof SVGDOMImplementation)) {
			return true;
		}
		return false;
	}

	/**
	 * Transcodes the specified Document as an image in the specified output.
	 * 
	 * @param document the document to transcode
	 * @param uri the uri of the document or null if any
	 * @param output the ouput where to transcode
	 * @exception TranscoderException if an error occured while transcoding
	 */
	protected void transcode(Document document, String uri, TranscoderOutput output) throws TranscoderException {
		if (shouldCopyDocument(document)) {
			DOMImplementation impl;
			impl = SVGDOMImplementation.getDOMImplementation();
			document = DOMUtilities.deepCloneDocument(document, impl);
			if (uri != null) {
				try {
					URL url = new URL(uri);
					((SVGOMDocument) document).setURLObject(url);
				} catch (MalformedURLException mue) {
					//TODO: Implement error handling
				}
			}
		}

		ctx = new BridgeContext(userAgent);
		SVGOMDocument svgDoc = (SVGOMDocument) document;
		SVGSVGElement svgRoot = svgDoc.getRootElement();

		// build the GVT tree
		builder = new GVTBuilder();
		// flag that indicates if the document is dynamic
		boolean isDynamic = (hints.containsKey(KEY_EXECUTE_ONLOAD) && ((Boolean) hints.get(KEY_EXECUTE_ONLOAD)).booleanValue() && BaseScriptingEnvironment
				.isDynamicDocument(ctx, svgDoc));

		if (isDynamic) {
			ctx.setDynamicState(BridgeContext.DYNAMIC);
		}

		GraphicsNode gvtRoot;
		try {
			gvtRoot = builder.build(ctx, svgDoc);
		} catch (BridgeException ex) {
			throw new TranscoderException(ex);
		}

		// get the 'width' and 'height' attributes of the SVG document
		float docWidth = (float) ctx.getDocumentSize().getWidth();
		float docHeight = (float) ctx.getDocumentSize().getHeight();

		setImageSize(docWidth, docHeight);

		//compute the transformation matrix
		AffineTransform Px = calculateSizeTransform(svgRoot, gvtRoot, docWidth, docHeight, width, height);

		gvtRoot = renderImage(output, gvtRoot, Px, (int) width, (int) height);

		this.root = gvtRoot;
	}

	private GraphicsNode renderImage(TranscoderOutput output, GraphicsNode gvtRoot, AffineTransform Px, int w, int h)
			throws TranscoderException {
		Graphics2D g2d = createGraphics(w, h);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.clip(new java.awt.Rectangle(0, 0, w, h));
		g2d.transform(Px);
		gvtRoot.paint(g2d);
		postRenderImage(g2d);
		return null;
	}

	protected Graphics2D createGraphics(int w, int h) {
		bufferedImage = createImage(w, h);
		Graphics2D g2d = GraphicsUtil.createGraphics(bufferedImage);
		return g2d;
	}

	protected void postRenderImage(Graphics2D g2d) {
		g2d.dispose();
	}

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public BufferedImage createImage(int w, int h) {
		return new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	}

	public void writeImage(BufferedImage img, TranscoderOutput output) throws TranscoderException {
	}
}
