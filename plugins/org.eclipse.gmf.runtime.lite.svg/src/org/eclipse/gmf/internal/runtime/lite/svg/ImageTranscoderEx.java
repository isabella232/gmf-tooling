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
import java.awt.image.BufferedImage;

import org.apache.batik.bridge.BridgeContext;
import org.apache.batik.dom.svg.SVGOMDocument;
import org.apache.batik.ext.awt.image.GraphicsUtil;
import org.apache.batik.transcoder.SVGAbstractTranscoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderOutput;
import org.w3c.dom.Document;

public class ImageTranscoderEx extends SVGAbstractTranscoder {

	private BufferedImage bufferedImage;

	/**
	 * Call before querying for CSS properties. If document has CSS engine installed returns null. Client is responsible to
	 * dispose bridge context if it was returned by this method.
	 */
	public BridgeContext initCSSEngine(final Document d) {
		SVGOMDocument sd = (SVGOMDocument) d;
		if (sd.getCSSEngine() != null) {
			return null;
		}
		class BridgeContextEx extends BridgeContext {

			public BridgeContextEx() {
				super(ImageTranscoderEx.this.userAgent);
				BridgeContextEx.this.setDocument(d);
				BridgeContextEx.this.initializeDocument(d);
			}
		}
		return new BridgeContextEx();
	}

	protected void transcode(Document document, String uri, TranscoderOutput output) throws TranscoderException {
		super.transcode(document, uri, output);
		Graphics2D g2d = createGraphics();
		g2d.transform(curTxf);
		root.paint(g2d);
		g2d.dispose();
	}

	protected Graphics2D createGraphics() {
		int w = (int) (width + 0.5);
		int h = (int) (height + 0.5);
		bufferedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = GraphicsUtil.createGraphics(bufferedImage);
		return g2d;
	}

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}
}
