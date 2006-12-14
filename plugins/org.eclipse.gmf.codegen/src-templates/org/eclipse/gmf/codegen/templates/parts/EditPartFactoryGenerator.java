package org.eclipse.gmf.codegen.templates.parts;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class EditPartFactoryGenerator
{
  protected static String nl;
  public static synchronized EditPartFactoryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    EditPartFactoryGenerator result = new EditPartFactoryGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.draw2d.FigureUtilities;" + NL + "import org.eclipse.draw2d.IFigure;" + NL + "import org.eclipse.draw2d.Label;" + NL + "import org.eclipse.draw2d.geometry.Dimension;" + NL + "import org.eclipse.draw2d.geometry.Rectangle;" + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gef.EditPartFactory;" + NL + "import org.eclipse.gef.tools.CellEditorLocator;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;" + NL + "import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.jface.viewers.CellEditor;" + NL + "import org.eclipse.swt.SWT;" + NL + "import org.eclipse.swt.widgets.Text;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " implements EditPartFactory {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart createEditPart(EditPart context, Object model) {" + NL + "\t\tif (model instanceof View) {" + NL + "\t\t\tView view = (View) model;" + NL + "\t\t\tint viewVisualID = ";
  protected final String TEXT_7 = ".getVisualID(view);" + NL + "\t\t\tswitch (viewVisualID) {";
  protected final String TEXT_8 = NL + "\t\t\tcase ";
  protected final String TEXT_9 = ".VISUAL_ID:" + NL + "\t\t\t\t return new ";
  protected final String TEXT_10 = "(view);";
  protected final String TEXT_11 = NL + "\t\t\tcase ";
  protected final String TEXT_12 = ".VISUAL_ID:" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_13 = "(view);";
  protected final String TEXT_14 = "\t\t" + NL + "\t\t\tcase ";
  protected final String TEXT_15 = ".VISUAL_ID:" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_16 = "(view);";
  protected final String TEXT_17 = NL + "\t\t\tcase ";
  protected final String TEXT_18 = ".VISUAL_ID:" + NL + "\t\t\t\treturn new ";
  protected final String TEXT_19 = "(view);";
  protected final String TEXT_20 = NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn createUnrecognizedEditPart(context, model);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private EditPart createUnrecognizedEditPart(EditPart context, Object model) {" + NL + "\t \t// Handle creation of unrecognized child node EditParts here" + NL + "\t \treturn null;" + NL + "\t }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source){" + NL + "        if (source.getFigure() instanceof WrapLabel)" + NL + "            return new TextCellEditorLocator((WrapLabel) source.getFigure());" + NL + "        else {" + NL + "            IFigure figure = source.getFigure();" + NL + "            return new LabelCellEditorLocator((Label) figure);" + NL + "        }" + NL + "    }" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic private class TextCellEditorLocator implements CellEditorLocator {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate WrapLabel wrapLabel;" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic TextCellEditorLocator(WrapLabel wrapLabel) {" + NL + "\t\t\tsuper();" + NL + "\t\t\tthis.wrapLabel = wrapLabel;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic WrapLabel getWrapLabel() {" + NL + "\t\t\treturn wrapLabel;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void relocate(CellEditor celleditor) {" + NL + "\t\t\tText text = (Text) celleditor.getControl();" + NL + "\t\t\tRectangle rect = getWrapLabel().getTextBounds().getCopy();" + NL + "\t\t\tgetWrapLabel().translateToAbsolute(rect);" + NL + "\t\t\t" + NL + "\t\t\tif (getWrapLabel().isTextWrapped() && getWrapLabel().getText().length() > 0)" + NL + "\t\t\t\trect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));" + NL + "\t\t\telse {" + NL + "\t\t\t\tint avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();" + NL + "\t\t\t\trect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr*2, 0));" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tif (!rect.equals(new Rectangle(text.getBounds())))" + NL + "\t\t\t\ttext.setBounds(rect.x, rect.y, rect.width, rect.height);" + NL + "\t\t}" + NL + "" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class LabelCellEditorLocator implements CellEditorLocator {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate Label label;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic LabelCellEditorLocator(Label label) {" + NL + "\t\t\tthis.label = label;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Label getLabel() {" + NL + "\t\t\treturn label;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void relocate(CellEditor celleditor) {" + NL + "\t\t\tText text = (Text) celleditor.getControl();" + NL + "\t\t\tRectangle rect = getLabel().getTextBounds().getCopy();" + NL + "\t\t\tgetLabel().translateToAbsolute(rect);" + NL + "" + NL + "\t\t\tint avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();" + NL + "\t\t\trect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));" + NL + "" + NL + "\t\t\tif (!rect.equals(new Rectangle(text.getBounds())))" + NL + "\t\t\t\ttext.setBounds(rect.x, rect.y, rect.width, rect.height);" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_21 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    
importManager.markImportLocation(stringBuffer);
final String visualIDRegistryClassName = importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName());

    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getEditPartFactoryClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(visualIDRegistryClassName);
    stringBuffer.append(TEXT_7);
    
for (Iterator containers = genDiagram.getAllContainers().iterator(); containers.hasNext();) {
	GenContainerBase container = (GenContainerBase) containers.next();

    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(container.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(container.getEditPartClassName());
    stringBuffer.append(TEXT_10);
    
	if (container instanceof GenNode) {
		GenNode node = (GenNode) container;
		for (Iterator labels = node.getLabels().iterator(); labels.hasNext();) {
			GenNodeLabel label = (GenNodeLabel) labels.next();

    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(label.getEditPartClassName());
    stringBuffer.append(TEXT_13);
    
		}
	}
}
for (Iterator links = genDiagram.getLinks().iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();

    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(link.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(link.getEditPartClassName());
    stringBuffer.append(TEXT_16);
    
	for (Iterator linkLabels = link.getLabels().iterator(); linkLabels.hasNext();) {
		GenLinkLabel linkLabel = (GenLinkLabel) linkLabels.next();

    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName(linkLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(linkLabel.getEditPartClassName());
    stringBuffer.append(TEXT_19);
    
	}
}

    stringBuffer.append(TEXT_20);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}
