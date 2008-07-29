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
package org.eclipse.gmf.runtime.lite.svg;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import org.apache.batik.dom.svg.SAXSVGDocumentFactory;
import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.ImageTranscoder;
import org.apache.batik.util.XMLResourceDescriptor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.gmf.internal.runtime.lite.svg.Activator;
import org.eclipse.gmf.internal.runtime.lite.svg.ImageTranscoderEx;
import org.eclipse.gmf.internal.runtime.lite.svg.SVGGraphics2D;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.w3c.dom.Document;

public class SVGFigure extends Figure {

	private String uri;
	private Document document;
	private boolean failedToLoadDocument;

	public final String getURI() {
		return uri;
	}

	public void setURI(String uri, boolean loadOnDemand) {
		this.uri = uri;
		document = null;
		failedToLoadDocument = false;
		if (loadOnDemand) {
			loadDocument();
		}
	}

	private void loadDocument() {
		failedToLoadDocument = true;
		if (uri == null) {
			return;
		}
		String parser = XMLResourceDescriptor.getXMLParserClassName();
		SAXSVGDocumentFactory factory = new SAXSVGDocumentFactory(parser);
		try {
			document = factory.createDocument(uri);
			failedToLoadDocument = false;
		} catch (IOException e) {
			Activator.logError("Error loading SVG file", e);
		}
	}

	private Document getDocument() {
		if (failedToLoadDocument) {
			return null;
		}
		if (document == null) {
			loadDocument();
		}
		return document;
	}

	private void renderDocument(Transcoder transcoder, Document document) {
		try {
			transcoder.addTranscodingHint(ImageTranscoder.KEY_WIDTH, new Float(getBounds().width));
			transcoder.addTranscodingHint(ImageTranscoder.KEY_HEIGHT, new Float(getBounds().height));
			transcoder.transcode(new TranscoderInput(document), new TranscoderOutput());
		} catch (TranscoderException e) {
			Activator.logError("Error rendering SVG image", e);
		}
	}

	@Override
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		Document document = getDocument();
		if (document != null) {
			try {
				graphics.pushState();
				paintDirectly(graphics, document);
			} catch (RuntimeException e) {
				Activator.log(IStatus.INFO, "Failed to paint SVG image directly", e);
				graphics.restoreState();
				paintUsingAWT(graphics, document);
			} finally {
				graphics.popState();
			}
		}
	}

	private void paintDirectly(final Graphics graphics, Document document) {
		ImageTranscoderEx transcoder = new ImageTranscoderEx() {

			@Override
			protected Graphics2D createGraphics(int w, int h) {
				return new SVGGraphics2D(graphics);
			}
		};
		renderDocument(transcoder, document);
	}

	private void paintUsingAWT(Graphics graphics, Document document) {
		Image image = null;
		try {
			// SimpleImageTranscoder transcoder = new SimpleImageTranscoder();
			ImageTranscoderEx transcoder = new ImageTranscoderEx();
			renderDocument(transcoder, document);
			BufferedImage awtImage = transcoder.getBufferedImage();
			if (awtImage != null) {
				image = SVGGraphics2D.toSWT(Display.getCurrent(), awtImage);
				graphics.drawImage(image, getBounds().x, getBounds().y);
			}
		} finally {
			if (image != null) {
				image.dispose();
			}
		}
	}
}
