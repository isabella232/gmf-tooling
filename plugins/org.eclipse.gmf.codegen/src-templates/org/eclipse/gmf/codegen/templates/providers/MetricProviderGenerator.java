package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class MetricProviderGenerator
{
  protected static String nl;
  public static synchronized MetricProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    MetricProviderGenerator result = new MetricProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ";
  protected final String TEXT_7 = " context2MetricsMap;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ";
  protected final String TEXT_8 = " metricsRegistry;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static int MAX_VISIBLE_KEY_CHAR_COUNT = 5;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_9 = " createAction(String actionId," + NL + "\t\t\t";
  protected final String TEXT_10 = " partDescriptor) {" + NL + "\t\tif (MetricsAction.ACTION_KEY.equals(actionId)) {" + NL + "\t\t\treturn new MetricsAction(partDescriptor);" + NL + "\t\t}" + NL + "\t\treturn super.createAction(actionId, partDescriptor);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MetricsAction extends ";
  protected final String TEXT_11 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ACTION_KEY = \"metricsAction\"; //$NON-NLS-1$" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_12 = " workbenchPartDescriptor;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic MetricsAction(";
  protected final String TEXT_13 = " workbenchPartDescriptor) {" + NL + "\t\t\tsetId(ACTION_KEY);" + NL + "\t\t\tsetText(\"Metrics\");" + NL + "\t\t\tthis.workbenchPartDescriptor = workbenchPartDescriptor;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void run() {" + NL + "\t\t\t";
  protected final String TEXT_14 = " workbenchPart = workbenchPartDescriptor.getPartPage().getActivePart();" + NL + "\t\t\t";
  protected final String TEXT_15 = " metricsView = null;" + NL + "\t\t\ttry {" + NL + "\t\t\t\tmetricsView = ";
  protected final String TEXT_16 = ".getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(ResultView.VIEW_ID);\t\t\t\t\t\t\t" + NL + "\t\t\t\tif(metricsView == null) {" + NL + "\t\t\t\t\tmetricsView = ";
  protected final String TEXT_17 = ".getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(ResultView.VIEW_ID);\t\t\t\t\t" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tif (metricsView != null && workbenchPart instanceof IDiagramWorkbenchPart) {" + NL + "\t\t\t\t\t\tfinal IDiagramWorkbenchPart part = (IDiagramWorkbenchPart) workbenchPart;" + NL + "\t\t\t\t\t\t((ResultView)metricsView).setInput(part);" + NL + "\t\t\t\t\t}\t\t\t\t\t" + NL + "\t\t\t\t\tworkbenchPart.getSite().getPage().activate(metricsView);\t\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch (";
  protected final String TEXT_18 = " e) {" + NL + "\t\t\t\t";
  protected final String TEXT_19 = ".getInstance().logError(\"Diagram metric view failure\", e); //$NON-NLS-1$" + NL + "\t\t\t}\t\t\t" + NL + "\t\t}\t" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tstatic ";
  protected final String TEXT_20 = " calculateMetrics(IDiagramWorkbenchPart diagramPart) {" + NL + "\t\tfinal Diagram diagram = diagramPart.getDiagram();" + NL + "\t\ttry {" + NL + "\t\t\treturn (";
  protected final String TEXT_21 = ")diagramPart.getDiagramEditPart().getEditingDomain().runExclusive(\t\t\t\t" + NL + "\t\t\t\tnew org.eclipse.emf.transaction.RunnableWithResult.Impl() {" + NL + "\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_22 = " metrics = " + NL + "\t\t\t\t\t\t\tcalculateMetrics(diagram.eAllContents(), new ";
  protected final String TEXT_23 = "(50));" + NL + "\t\t\t\t\t\tsetResult(calculateMetrics(diagram.getElement().eAllContents(), metrics));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t});" + NL + "\t\t} catch(InterruptedException e) {" + NL + "\t\t\treturn ";
  protected final String TEXT_24 = ".EMPTY_LIST;\t\t" + NL + "\t\t}\t\t" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic ";
  protected final String TEXT_25 = " calculateMetrics(";
  protected final String TEXT_26 = " it, ";
  protected final String TEXT_27 = " metricsList) {" + NL + "\t\t";
  protected final String TEXT_28 = " metricsPerContext = new ";
  protected final String TEXT_29 = "();" + NL + "\t\twhile(it.hasNext()) {" + NL + "\t\t\tObject nextElement = it.next();" + NL + "\t\t\tif(nextElement instanceof EObject) {" + NL + "\t\t\t\tEObject nextEObj = (EObject)nextElement;" + NL + "\t\t\t\tEClass nextTarget = nextEObj.eClass();" + NL + "\t\t\t\t";
  protected final String TEXT_30 = " superTypeIt = nextTarget.getEAllSuperTypes().iterator();" + NL + "\t\t\t\twhile(nextTarget != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_31 = " metricList = getMetricsForTarget(nextTarget);" + NL + "\t\t\t\t\tif(metricList != null) {" + NL + "\t\t\t\t\t\tfor (";
  protected final String TEXT_32 = " metricIt = metricList.iterator(); metricIt.hasNext();) {" + NL + "\t\t\t\t\t\t\tMetricDef nextMetric = (MetricDef) metricIt.next();" + NL + "\t\t\t\t\t\t\tif(nextMetric.appliesTo(nextEObj)) {" + NL + "\t\t\t\t\t\t\t\tMetric metric = new Metric(nextMetric, nextEObj);" + NL + "\t\t\t\t\t\t\t\tmetricsPerContext.add(metric);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tnextTarget = superTypeIt.hasNext() ? (EClass)superTypeIt.next() : null; " + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tif(!metricsPerContext.isEmpty()) {" + NL + "\t\t\t\t\tmetricsList.add(new ElementMetrics(nextEObj, " + NL + "\t\t\t\t\t\t\t(Metric[])metricsPerContext.toArray(new Metric[metricsPerContext.size()])));" + NL + "\t\t\t\t\tmetricsPerContext.clear();\t\t\t\t" + NL + "\t\t\t\t}\t\t\t\t" + NL + "\t\t\t}\t\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\treturn metricsList;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic static class ResultView extends ";
  protected final String TEXT_33 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String VIEW_ID = \"";
  protected final String TEXT_34 = "\"; //$NON-NLS-1$" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tprivate TableViewer viewer;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tprivate ";
  protected final String TEXT_35 = " diagramFile;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t    " + NL + "\t    void setInput(IDiagramWorkbenchPart diagramPart) {" + NL + "\t\t\t";
  protected final String TEXT_36 = " resource = diagramPart.getDiagram().eResource();" + NL + "\t\t\tthis.diagramFile = ";
  protected final String TEXT_37 = ".getFile(resource);" + NL + "\t\t\tsetTitleToolTip(diagramFile.getFullPath().toString());" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_38 = " metrics = calculateMetrics(diagramPart);" + NL + "\t    \tadjustLayout(metrics);" + NL + "\t    \tviewer.setInput(metrics); " + NL + "\t    }" + NL + "\t    " + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t    " + NL + "\t    private void adjustLayout(";
  protected final String TEXT_39 = " metricResultList) {" + NL + "\t    \t";
  protected final String TEXT_40 = " maxValStrMap = calcMetricMaxValueStrLenMap(metricResultList);" + NL + "\t\t\tTable table = viewer.getTable();" + NL + "\t\t\tTableLayout layout = new TableLayout();" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_41 = " gc = new ";
  protected final String TEXT_42 = "(table);" + NL + "\t\t\tgc.setFont(";
  protected final String TEXT_43 = ".getDialogFont());" + NL + "\t\t\tint padding = gc.stringExtent(\"X\").x * 2; //$NON-NLS-1$" + NL + "\t\t\tfor (int i = 0; i < getMetrics().size(); i++) {" + NL + "\t\t\t\tMetricDef nextMetric = (MetricDef)getMetrics().get(i);" + NL + "\t\t\t\tString valueStr = (String)maxValStrMap.get(nextMetric.key);" + NL + "\t\t\t\tint minWidth = valueStr != null ? gc.stringExtent(valueStr).x + padding : 20;\t\t\t" + NL + "\t\t\t\tlayout.addColumnData(new ColumnPixelData(minWidth, true));" + NL + "\t\t\t}" + NL + "\t\t\tgc.dispose();" + NL + "\t\t\t" + NL + "\t\t\tlayout.addColumnData(new ColumnWeightData(1, 50, true));" + NL + "\t\t\tviewer.getTable().setLayout(layout);" + NL + "\t\t\tviewer.getTable().layout(true, true);" + NL + "\t    }" + NL + "\t    " + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t    " + NL + "\t\tpublic void createPartControl(Composite parent) {\t\t\t" + NL + "\t\t\tthis.viewer = new TableViewer(parent, SWT.FULL_SELECTION);" + NL + "\t\t\tfinal Table table = viewer.getTable();" + NL + "\t\t\ttable.setHeaderVisible(true);" + NL + "\t\t\ttable.setLinesVisible(true);\t" + NL + "\t\t\t" + NL + "\t\t\tfor (int i = 0; i < getMetrics().size(); i++) {" + NL + "\t\t\t\tMetricDef nextMetric = ((MetricDef)getMetrics().get(i));\t\t" + NL + "\t\t\t\tTableColumn column = new TableColumn(table, SWT.NONE);" + NL + "\t\t\t\tcolumn.setAlignment(SWT.RIGHT);" + NL + "\t\t\t\tcolumn.setMoveable(true);\t\t\t\t" + NL + "\t\t\t\tcolumn.setText(nextMetric.key);" + NL + "\t\t\t\tcolumn.setToolTipText(nextMetric.getToolTipText());" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tTableColumn objectColumn = new TableColumn(table, SWT.NONE);\t\t\t" + NL + "\t\t\tobjectColumn.setText(\"Element\");" + NL + "\t\t\tobjectColumn.setToolTipText(\"Measurement element\");" + NL + "\t\t\t" + NL + "\t\t\tviewer.setLabelProvider(new Labels());" + NL + "\t\t\tviewer.setContentProvider(new ArrayContentProvider());\t\t\t\t\t\t" + NL + "\t\t\tviewer.addOpenListener(new IOpenListener() {" + NL + "\t\t\t\tpublic void open(OpenEvent event) {" + NL + "\t\t\t\t\thandleOpen(event);" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_44 = " headerSelListener = new ";
  protected final String TEXT_45 = "() {" + NL + "\t\t\t\tpublic void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {" + NL + "\t\t\t\t\ttable.setSortColumn((TableColumn)e.getSource());  " + NL + "\t\t\t\t\ttable.setSortDirection((table.getSortDirection() != SWT.DOWN) ? SWT.DOWN : SWT.UP);" + NL + "\t\t\t\t\tviewer.refresh();" + NL + "\t\t\t\t}\t\t\t\t" + NL + "\t\t\t\tpublic void widgetDefaultSelected(";
  protected final String TEXT_46 = " e) {\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t};\t\t\t" + NL + "\t\t\tTableColumn[] columns = viewer.getTable().getColumns();" + NL + "\t\t\tfor (int i = 0; i < columns.length; i++) {" + NL + "\t\t\t\tcolumns[i].addSelectionListener(headerSelListener);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tviewer.setSorter(" + NL + "\t\t\t\tnew ViewerSorter() {" + NL + "\t\t\t\t\tpublic int compare(Viewer viewer, Object e1, Object e2) {" + NL + "\t\t\t\t\t\tTableColumn c = table.getSortColumn();" + NL + "\t\t\t\t\t\tint result = 0;" + NL + "\t\t\t\t\t\tif(c != null) {" + NL + "\t\t\t\t\t\t\tMetric mc1 = ((ElementMetrics)e1).getMetricByKey(c.getText());" + NL + "\t\t\t\t\t\t\tMetric mc2 = ((ElementMetrics)e2).getMetricByKey(c.getText());" + NL + "\t\t\t\t\t\t\tresult = (mc1 != null && mc2 != null) ?" + NL + "\t\t\t\t\t\t\t\tmc1.compareTo(mc2) : (mc1 == null ? -1 : 1);" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tresult = ((ElementMetrics)e1).targetElementQName.compareTo(((ElementMetrics)e2).targetElementQName);" + NL + "\t\t\t\t\t\t}\t\t\t\t\t\t" + NL + "\t\t\t\t\t\treturn table.getSortDirection() == SWT.DOWN ? result : -result;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t);" + NL + "\t\t\t" + NL + "\t        ";
  protected final String TEXT_47 = " editor = getSite().getPage().getActiveEditor();" + NL + "\t        if(editor != null && editor.getClass().equals(";
  protected final String TEXT_48 = ".class)) {" + NL + "\t\t\t\tsetInput((";
  protected final String TEXT_49 = ")editor);" + NL + "\t        }\t\t\t" + NL + "\t\t}" + NL + "\t\t\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t\t\t" + NL + "\t\tprivate void handleOpen(OpenEvent event) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_50 = ".openEditor(getSite().getPage(), diagramFile, true);" + NL + "\t\t\t} catch (";
  protected final String TEXT_51 = " e) {" + NL + "\t\t\t\t";
  protected final String TEXT_52 = ".getInstance().logError(\"Can't open diagram editor\", e); //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tprivate static ";
  protected final String TEXT_53 = " calcMetricMaxValueStrLenMap(";
  protected final String TEXT_54 = " allMetrics) {" + NL + "\t\t\t";
  protected final String TEXT_55 = " metric2MaxStrLen = new ";
  protected final String TEXT_56 = "();\t\t\t \t" + NL + "\t\t\tfor (int i = 0; i < getMetrics().size(); i++) {" + NL + "\t\t\t\tString nextKey = ((MetricDef)getMetrics().get(i)).key; " + NL + "\t\t\t\tint trimPos = Math.min(nextKey.length(), MAX_VISIBLE_KEY_CHAR_COUNT);" + NL + "\t\t\t\tmetric2MaxStrLen.put(nextKey, nextKey.substring(0, trimPos));\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tfor (";
  protected final String TEXT_57 = " it = allMetrics.iterator(); it.hasNext();) {" + NL + "\t\t\t\tElementMetrics elementMetrics = (ElementMetrics) it.next();" + NL + "\t\t\t\tfor (int i = 0; i < elementMetrics.metrics.length; i++) {" + NL + "\t\t\t\t\tMetric metric = elementMetrics.metrics[i];" + NL + "\t\t\t\t\tString valueStr = (String)metric2MaxStrLen.get(metric.def.key);" + NL + "\t\t\t\t\tif(valueStr == null || metric.displayValue.length() > valueStr.length()) {" + NL + "\t\t\t\t\t\tmetric2MaxStrLen.put(metric.def.key, metric.displayValue);\t" + NL + "\t\t\t\t\t}\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn metric2MaxStrLen;\t\t" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void setFocus() {" + NL + "\t\t}\t\t" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tprivate class Labels extends LabelProvider implements ITableLabelProvider, ITableColorProvider {" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t\t" + NL + "\t\t\tprivate boolean isElementColumn(int columnIndex) {" + NL + "\t\t\t\treturn columnIndex >= getMetrics().size();" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t\t" + NL + "\t\t\tpublic ";
  protected final String TEXT_58 = " getColumnImage(Object element, int columnIndex) {\t\t\t\t" + NL + "\t\t\t\treturn isElementColumn(columnIndex) ? ((ElementMetrics)element).elementImage : null;" + NL + "\t\t\t}\t\t" + NL + "\t\t\t" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t\t" + NL + "\t\t\tpublic String getColumnText(Object element, int columnIndex) {" + NL + "\t\t\t\tElementMetrics elementMetrics = (ElementMetrics)element;" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\tif(columnIndex == getMetrics().size()) {" + NL + "\t\t\t\t\treturn elementMetrics.targetElementQName;" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tString key = ((MetricDef)getMetrics().get(columnIndex)).key;" + NL + "\t\t\t\tMetric metric = elementMetrics.getMetricByKey(key);" + NL + "\t\t\t\treturn (metric != null) ? metric.displayValue : \"-\"; //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t\t" + NL + "\t\t\tpublic ";
  protected final String TEXT_59 = " getBackground(Object element, int columnIndex) {" + NL + "\t\t\t\treturn null; " + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t\t" + NL + "\t\t\tpublic ";
  protected final String TEXT_60 = " getForeground(Object element, int columnIndex) {" + NL + "\t\t\t\tif(isElementColumn(columnIndex)) return null;" + NL + "\t\t\t\tElementMetrics columnElement = (ElementMetrics)element;" + NL + "\t\t\t\tString key = ((MetricDef)getMetrics().get(columnIndex)).key;" + NL + "\t\t\t\tMetric metric = columnElement.getMetricByKey(key);\t\t\t" + NL + "\t\t\t\tif(metric != null && metric.value != null) {" + NL + "\t\t\t\t\tif (metric.def.highLimit != null" + NL + "\t\t\t\t\t\t\t&& metric.def.highLimit.longValue() < metric.value.longValue()) {" + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_61 = ".red;" + NL + "\t\t\t\t\t} else if (metric.def.lowLimit != null" + NL + "\t\t\t\t\t\t\t&& metric.def.lowLimit.longValue() > metric.value.longValue()) {" + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_62 = ".blue;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t}\t\t" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class ElementMetrics {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tfinal Metric[] metrics;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal String targetElementQName;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tfinal ";
  protected final String TEXT_63 = " elementImage;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tElementMetrics(EObject target, Metric[] metrics) {" + NL + "\t\t\tthis.metrics = metrics;" + NL + "\t\t\tassert metrics.length > 0;" + NL + "\t\t\t" + NL + "\t\t\tEClass imageTarget = target.eClass();\t\t\t" + NL + "\t\t\tif (target instanceof View) {" + NL + "\t\t\t\tView viewTarget = (View) target;" + NL + "\t\t\t\tStringBuffer notationQNameBuf = new StringBuffer();" + NL + "\t\t\t\tnotationQNameBuf.append(";
  protected final String TEXT_64 = ".getQualifiedName(viewTarget, true));" + NL + "\t\t\t\tif (\"\".equals(viewTarget.getType()) && viewTarget.getElement() != null) { //$NON-NLS-1$" + NL + "\t\t\t\t\tnotationQNameBuf" + NL + "\t\t\t\t\t\t.append('-').append('>')" + NL + "\t\t\t\t\t\t.append(";
  protected final String TEXT_65 = ".getQualifiedName(viewTarget.getElement(), true));" + NL + "\t\t\t\t\timageTarget = viewTarget.getElement().eClass();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tint visualID = getVisualID(viewTarget);" + NL + "\t\t\t\tnotationQNameBuf.append('[').append(visualID < 0 ? Integer.toString(System.identityHashCode(viewTarget)) : Integer.toString(visualID)).append(']');\t\t\t\t" + NL + "" + NL + "\t\t\t\tthis.targetElementQName = notationQNameBuf.toString();" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthis.targetElementQName = ";
  protected final String TEXT_66 = ".getQualifiedName(target, true);\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\tthis.elementImage = ";
  protected final String TEXT_67 = ".getImage(imageTarget);\t\t\t" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tMetric getMetricByKey(String key) {" + NL + "\t\t\tfor (int i = 0; i < metrics.length; i++) {" + NL + "\t\t\t\tif(metrics[i].def.key.equals(key)) {" + NL + "\t\t\t\t\treturn metrics[i]; " + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}\t\t" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static class Metric implements Comparable {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tfinal MetricDef def;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal Number value;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal String displayValue;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tMetric(MetricDef def, EObject target) {" + NL + "\t\t\tthis.def = def;" + NL + "\t\t\tvalue = def.calcMetric(target);" + NL + "\t\t\tthis.displayValue = (value != null) ? java.text.NumberFormat.getInstance().format(value) : \"null\"; //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int compareTo(Object other) {" + NL + "\t\t\tMetric otherMetric = (Metric)other;" + NL + "\t\t\tif(value != null && otherMetric.value != null) {" + NL + "\t\t\t\treturn (value.longValue() < otherMetric.value.longValue()) ? " + NL + "\t\t\t\t\t\t-1 : (value.longValue() == otherMetric.value.longValue() ? 0 : 1);" + NL + "\t\t\t}" + NL + "\t\t\treturn (value == null && otherMetric.value == null) ? " + NL + "\t\t\t\t\t0 : (value == null) ? -1 : 1;  " + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MetricDef {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tfinal Double lowLimit;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal Double highLimit;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal String key;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal org.eclipse.emf.ocl.query.Query expression;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal EClass ctxClass;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal int semanticID;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal String name;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal String description;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tMetricDef(String key, String body, EClass context, int semanticID, " + NL + "\t\t\tDouble high, Double low, String name, String description) {" + NL + "\t\t\tthis.key = key;" + NL + "\t\t\tthis.ctxClass = context;" + NL + "\t\t\tthis.expression = org.eclipse.emf.ocl.query.QueryFactory.eINSTANCE.createQuery(body, context);\t\t\t" + NL + "\t\t\tthis.semanticID = semanticID;\t\t\t" + NL + "\t\t\tthis.lowLimit = low;" + NL + "\t\t\tthis.highLimit = high;" + NL + "\t\t\tthis.name = name;" + NL + "\t\t\tthis.description = description;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tNumber calcMetric(Object contextInstance) {" + NL + "\t\t\tObject val = expression.evaluate(contextInstance);" + NL + "\t\t\treturn (val instanceof Number) ? (Number)val : null;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tboolean appliesTo(EObject eObject) {" + NL + "\t\t\tif(eObject instanceof View && semanticID >= 0) { " + NL + "\t\t\t\treturn semanticID == getVisualID((View)eObject);\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\treturn eObject != null && ctxClass.isSuperTypeOf(eObject.eClass());" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tString getToolTipText() {" + NL + "\t\t\tStringBuffer buf = new StringBuffer();" + NL + "\t\t\tif(name != null) buf.append(name);" + NL + "\t\t\tif(description != null) buf.append('\\n').append(description).append('\\n');" + NL + "\t\t\tif(lowLimit != null) buf.append(\"low:\").append(lowLimit);" + NL + "\t\t\tif(highLimit != null) buf.append(\" high:\").append(highLimit);" + NL + "\t\t\treturn buf.toString();" + NL + "\t\t}\t\t" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic static ";
  protected final String TEXT_68 = "/*MetricDef*/ getMetricsForTarget(EClass target) {" + NL + "\t\tif(context2MetricsMap == null) {" + NL + "\t\t\tinitializeRegistry();\t\t\t" + NL + "\t\t}" + NL + "\t\treturn (";
  protected final String TEXT_69 = ")context2MetricsMap.get(target);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_70 = " getMetrics() {" + NL + "\t\tif(metricsRegistry == null) {" + NL + "\t\t\tinitializeRegistry();" + NL + "\t\t}" + NL + "\t\treturn metricsRegistry;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static void initializeRegistry() {" + NL + "\t\tif(context2MetricsMap != null) return;";
  protected final String TEXT_71 = "\t\t" + NL + "\t\tregister(new MetricDef(\"";
  protected final String TEXT_72 = "\", \"";
  protected final String TEXT_73 = "\", " + NL + "\t\t\t\t\t";
  protected final String TEXT_74 = ", ";
  protected final String TEXT_75 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_76 = "new Double(";
  protected final String TEXT_77 = ")";
  protected final String TEXT_78 = "null";
  protected final String TEXT_79 = ",\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_80 = "new Double(";
  protected final String TEXT_81 = ")";
  protected final String TEXT_82 = "null";
  protected final String TEXT_83 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_84 = "\"";
  protected final String TEXT_85 = "\"";
  protected final String TEXT_86 = "null";
  protected final String TEXT_87 = "," + NL + "\t\t\t\t\t";
  protected final String TEXT_88 = "\"";
  protected final String TEXT_89 = "\"";
  protected final String TEXT_90 = "null";
  protected final String TEXT_91 = "));";
  protected final String TEXT_92 = "\t\t" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static void register(MetricDef metric) {" + NL + "\t\tif (context2MetricsMap == null) {" + NL + "\t\t\tcontext2MetricsMap = new ";
  protected final String TEXT_93 = "();" + NL + "\t\t\tmetricsRegistry = new ";
  protected final String TEXT_94 = "();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_95 = " metrics = (";
  protected final String TEXT_96 = ")context2MetricsMap.get(metric.ctxClass);" + NL + "\t\tif(metrics == null) {" + NL + "\t\t\tmetrics = new ";
  protected final String TEXT_97 = "();" + NL + "\t\t\tcontext2MetricsMap.put(metric.ctxClass, metrics);" + NL + "\t\t}" + NL + "\t\tmetricsRegistry.add(metric);" + NL + "\t\tmetrics.add(metric);" + NL + "\t}\t" + NL + "\t";
  protected final String TEXT_98 = NL;
  protected final String TEXT_99 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static int getVisualID(View containerView) {" + NL + "\t\t";
  protected final String TEXT_100 = " annotation = containerView.getEAnnotation(\"ViewIdentifier\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tString visualID = (String) annotation.getDetails().get(\"visualID\"); //$NON-NLS-1$" + NL + "\t\tif (visualID == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\ttry {" + NL + "\t\t\treturn Integer.parseInt(visualID);" + NL + "\t\t} catch (NumberFormatException e) {" + NL + "\t\t\t";
  protected final String TEXT_101 = ".getInstance().logError(\"Unable to parse \\\"visualID\\\" annotation: \" + visualID, e);" + NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_102 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    
importManager.emitPackageStatement(stringBuffer);

importManager.addImport("org.eclipse.emf.ecore.EClass");
importManager.addImport("org.eclipse.emf.ecore.EObject");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart");
importManager.addImport("org.eclipse.gmf.runtime.notation.Diagram");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.addImport("org.eclipse.jface.viewers.ArrayContentProvider");
importManager.addImport("org.eclipse.jface.viewers.ColumnPixelData");
importManager.addImport("org.eclipse.jface.viewers.ColumnWeightData");
importManager.addImport("org.eclipse.jface.viewers.IOpenListener");
importManager.addImport("org.eclipse.jface.viewers.ITableColorProvider");
importManager.addImport("org.eclipse.jface.viewers.ITableLabelProvider");
importManager.addImport("org.eclipse.jface.viewers.LabelProvider");
importManager.addImport("org.eclipse.jface.viewers.OpenEvent");
importManager.addImport("org.eclipse.jface.viewers.TableLayout");
importManager.addImport("org.eclipse.jface.viewers.TableViewer");
importManager.addImport("org.eclipse.jface.viewers.Viewer");
importManager.addImport("org.eclipse.jface.viewers.ViewerSorter");
importManager.addImport("org.eclipse.swt.SWT");
importManager.addImport("org.eclipse.swt.widgets.Composite");
importManager.addImport("org.eclipse.swt.widgets.Table");
importManager.addImport("org.eclipse.swt.widgets.TableColumn");

importManager.registerInnerClass("Metric");
importManager.registerInnerClass("MetricDef");
importManager.registerInnerClass("MetricsAction");
importManager.registerInnerClass("ElementMetrics");
importManager.registerInnerClass("ResultView");

importManager.markImportLocation(stringBuffer);
final String pluginActivatorClass = importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName());

    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getMetricProviderClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.Action"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPart"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IViewPart"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.part.ViewPart"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genDiagram.getMetricViewID());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.workspace.util.WorkspaceSynchronizer"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.GC"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.GC"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.JFaceResources"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.SelectionListener"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.SelectionListener"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.SelectionEvent"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorPart"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getEditor().getQualifiedClassName()));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getEditor().getQualifiedClassName()));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.ide.IDE"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_70);
    
for(Iterator it = genDiagram.getEditorGen().getMetrics().getMetrics().iterator(); it.hasNext();) {
	GenMetricRule nextMetric = (GenMetricRule)it.next();
	GenClassifier ctx = nextMetric.getTarget() != null ? nextMetric.getTarget().getContext() : null;
	if(ctx == null) continue;	
	String ctxAccessor = ctx.getGenPackage().getQualifiedPackageInterfaceName() + ".eINSTANCE.get" + ctx.getClassifierAccessorName() + "()";
	String body = nextMetric.getRule() != null ? nextMetric.getRule().getBody() : null;
	int visualID = nextMetric.getTarget() instanceof GenDiagramElementTarget ? ((GenDiagramElementTarget)nextMetric.getTarget()).getElement().getVisualID() : -1;	

    stringBuffer.append(TEXT_71);
    stringBuffer.append(nextMetric.getKey());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(body);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(ctxAccessor);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(visualID);
    stringBuffer.append(TEXT_75);
    if(nextMetric.getLowLimit()!=null){
    stringBuffer.append(TEXT_76);
    stringBuffer.append(nextMetric.getLowLimit());
    stringBuffer.append(TEXT_77);
    }else{
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    if(nextMetric.getHighLimit()!=null){
    stringBuffer.append(TEXT_80);
    stringBuffer.append(nextMetric.getHighLimit());
    stringBuffer.append(TEXT_81);
    }else{
    stringBuffer.append(TEXT_82);
    }
    stringBuffer.append(TEXT_83);
    if(nextMetric.getName()!=null){
    stringBuffer.append(TEXT_84);
    stringBuffer.append(nextMetric.getName());
    stringBuffer.append(TEXT_85);
    }else{
    stringBuffer.append(TEXT_86);
    }
    stringBuffer.append(TEXT_87);
    if(nextMetric.getDescription()!=null){
    stringBuffer.append(TEXT_88);
    stringBuffer.append(nextMetric.getDescription());
    stringBuffer.append(TEXT_89);
    }else{
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(TEXT_91);
    
}

    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_101);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_102);
    return stringBuffer.toString();
  }
}
