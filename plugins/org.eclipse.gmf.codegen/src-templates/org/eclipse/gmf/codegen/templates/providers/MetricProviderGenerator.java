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
  protected final String TEXT_2 = NL + "/**" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ";
  protected final String TEXT_7 = " context2MetricsMap;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ";
  protected final String TEXT_8 = " metricsRegistry;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static ";
  protected final String TEXT_9 = " key2MetricMap;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static int MAX_VISIBLE_KEY_CHAR_COUNT = 5;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_10 = " createAction(String actionId," + NL + "\t\t\t";
  protected final String TEXT_11 = " partDescriptor) {" + NL + "\t\tif (MetricsAction.ACTION_KEY.equals(actionId)) {" + NL + "\t\t\treturn new MetricsAction(partDescriptor);" + NL + "\t\t}" + NL + "\t\treturn super.createAction(actionId, partDescriptor);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MetricsAction extends ";
  protected final String TEXT_12 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ACTION_KEY = \"metricsAction\"; //$NON-NLS-1$" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_13 = " workbenchPartDescriptor;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic MetricsAction(";
  protected final String TEXT_14 = " workbenchPartDescriptor) {" + NL + "\t\t\tsetId(ACTION_KEY);" + NL + "\t\t\tsetText(\"Metrics\");" + NL + "\t\t\tthis.workbenchPartDescriptor = workbenchPartDescriptor;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void run() {" + NL + "\t\t\t";
  protected final String TEXT_15 = " workbenchPart = workbenchPartDescriptor.getPartPage().getActivePart();" + NL + "\t\t\t";
  protected final String TEXT_16 = " metricsView = null;" + NL + "\t\t\ttry {" + NL + "\t\t\t\tmetricsView = ";
  protected final String TEXT_17 = ".getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(ResultView.VIEW_ID);\t\t\t\t\t\t\t" + NL + "\t\t\t\tif(metricsView == null) {" + NL + "\t\t\t\t\tmetricsView = ";
  protected final String TEXT_18 = ".getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(ResultView.VIEW_ID);\t\t\t\t\t" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tif (metricsView != null && workbenchPart instanceof IDiagramWorkbenchPart) {" + NL + "\t\t\t\t\t\tfinal IDiagramWorkbenchPart part = (IDiagramWorkbenchPart) workbenchPart;" + NL + "\t\t\t\t\t\t((ResultView)metricsView).setInput(part);" + NL + "\t\t\t\t\t}\t\t\t\t\t" + NL + "\t\t\t\t\tworkbenchPart.getSite().getPage().activate(metricsView);\t\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch (";
  protected final String TEXT_19 = " e) {" + NL + "\t\t\t\t";
  protected final String TEXT_20 = ".getInstance().logError(\"Diagram metric view failure\", e); //$NON-NLS-1$" + NL + "\t\t\t}\t\t\t" + NL + "\t\t}\t" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tstatic ";
  protected final String TEXT_21 = " calculateMetrics(IDiagramWorkbenchPart diagramPart) {" + NL + "\t\tfinal Diagram diagram = diagramPart.getDiagram();" + NL + "\t\ttry {" + NL + "\t\t\treturn (";
  protected final String TEXT_22 = ")diagramPart.getDiagramEditPart().getEditingDomain().runExclusive(\t\t\t\t" + NL + "\t\t\t\tnew org.eclipse.emf.transaction.RunnableWithResult.Impl() {" + NL + "\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_23 = " metrics = " + NL + "\t\t\t\t\t\t\tcalculateMetrics(diagram.eAllContents(), new ";
  protected final String TEXT_24 = "(50));" + NL + "\t\t\t\t\t\tsetResult(calculateMetrics(diagram.getElement().eAllContents(), metrics));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t});" + NL + "\t\t} catch(InterruptedException e) {" + NL + "\t\t\treturn ";
  protected final String TEXT_25 = ".EMPTY_LIST;\t\t" + NL + "\t\t}\t\t" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic ";
  protected final String TEXT_26 = " calculateMetrics(";
  protected final String TEXT_27 = " it, ";
  protected final String TEXT_28 = " metricsList) {" + NL + "\t\t";
  protected final String TEXT_29 = " metricsPerContext = new ";
  protected final String TEXT_30 = "();" + NL + "\t\twhile(it.hasNext()) {" + NL + "\t\t\tObject nextElement = it.next();" + NL + "\t\t\tif(nextElement instanceof EObject) {" + NL + "\t\t\t\tEObject nextEObj = (EObject)nextElement;" + NL + "\t\t\t\tEClass nextTarget = nextEObj.eClass();" + NL + "\t\t\t\t";
  protected final String TEXT_31 = " superTypeIt = nextTarget.getEAllSuperTypes().iterator();" + NL + "\t\t\t\twhile(nextTarget != null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_32 = " metricList = getMetricsForTarget(nextTarget);" + NL + "\t\t\t\t\tif(metricList != null) {" + NL + "\t\t\t\t\t\tfor (";
  protected final String TEXT_33 = " metricIt = metricList.iterator(); metricIt.hasNext();) {" + NL + "\t\t\t\t\t\t\tMetricDef nextMetric = (MetricDef) metricIt.next();" + NL + "\t\t\t\t\t\t\tif(nextMetric.appliesTo(nextEObj)) {" + NL + "\t\t\t\t\t\t\t\tMetric metric = new Metric(nextMetric, nextEObj);" + NL + "\t\t\t\t\t\t\t\tmetricsPerContext.add(metric);" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tnextTarget = superTypeIt.hasNext() ? (EClass)superTypeIt.next() : null; " + NL + "\t\t\t\t}" + NL + "\t\t\t\t" + NL + "\t\t\t\tif(!metricsPerContext.isEmpty()) {" + NL + "\t\t\t\t\tmetricsList.add(new ElementMetrics(nextEObj, " + NL + "\t\t\t\t\t\t\t(Metric[])metricsPerContext.toArray(new Metric[metricsPerContext.size()])));" + NL + "\t\t\t\t\tmetricsPerContext.clear();\t\t\t\t" + NL + "\t\t\t\t}\t\t\t\t" + NL + "\t\t\t}\t\t\t" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\treturn metricsList;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic static class ResultView extends ";
  protected final String TEXT_34 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String VIEW_ID = \"";
  protected final String TEXT_35 = "\"; //$NON-NLS-1$" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tprivate TableViewer viewer;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tprivate ";
  protected final String TEXT_36 = " diagramFile;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t    " + NL + "\t    void setInput(IDiagramWorkbenchPart diagramPart) {" + NL + "\t\t\t";
  protected final String TEXT_37 = " resource = diagramPart.getDiagram().eResource();" + NL + "\t\t\tthis.diagramFile = ";
  protected final String TEXT_38 = ".getFile(resource);" + NL + "\t\t\tsetTitleToolTip(diagramFile.getFullPath().toString());" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_39 = " metrics = calculateMetrics(diagramPart);" + NL + "\t    \tadjustLayout(metrics);" + NL + "\t    \tviewer.setInput(metrics); " + NL + "\t    }" + NL + "\t    " + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t    " + NL + "\t    private void adjustLayout(";
  protected final String TEXT_40 = " metricResultList) {" + NL + "\t    \t";
  protected final String TEXT_41 = " maxValStrMap = calcMetricMaxValueStrLenMap(metricResultList);" + NL + "\t\t\tTable table = viewer.getTable();" + NL + "\t\t\tTableLayout layout = new TableLayout();" + NL + "\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_42 = " gc = new ";
  protected final String TEXT_43 = "(table);" + NL + "\t\t\tgc.setFont(";
  protected final String TEXT_44 = ".getDialogFont());" + NL + "\t\t\tint padding = gc.stringExtent(\"X\").x * 2; //$NON-NLS-1$" + NL + "\t\t\tfor (int i = 0; i < getMetrics().size(); i++) {" + NL + "\t\t\t\tMetricDef nextMetric = (MetricDef)getMetrics().get(i);" + NL + "\t\t\t\tString valueStr = (String)maxValStrMap.get(nextMetric.key);" + NL + "\t\t\t\tint minWidth = valueStr != null ? gc.stringExtent(valueStr).x + padding : 20;\t\t\t" + NL + "\t\t\t\tlayout.addColumnData(new ColumnPixelData(minWidth, true));" + NL + "\t\t\t}" + NL + "\t\t\tgc.dispose();" + NL + "\t\t\t" + NL + "\t\t\tlayout.addColumnData(new ColumnWeightData(1, 50, true));" + NL + "\t\t\tviewer.getTable().setLayout(layout);" + NL + "\t\t\tviewer.getTable().layout(true, true);" + NL + "\t    }" + NL + "\t    " + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t    " + NL + "\t\tpublic void createPartControl(Composite parent) {\t\t\t" + NL + "\t\t\tthis.viewer = new TableViewer(parent, SWT.FULL_SELECTION);" + NL + "\t\t\tfinal Table table = viewer.getTable();" + NL + "\t\t\ttable.setHeaderVisible(true);" + NL + "\t\t\ttable.setLinesVisible(true);\t" + NL + "\t\t\t" + NL + "\t\t\tfor (int i = 0; i < getMetrics().size(); i++) {" + NL + "\t\t\t\tMetricDef nextMetric = ((MetricDef)getMetrics().get(i));\t\t" + NL + "\t\t\t\tTableColumn column = new TableColumn(table, SWT.NONE);" + NL + "\t\t\t\tcolumn.setAlignment(SWT.RIGHT);" + NL + "\t\t\t\tcolumn.setMoveable(true);\t\t\t\t" + NL + "\t\t\t\tcolumn.setText(nextMetric.key);" + NL + "\t\t\t\tcolumn.setToolTipText(nextMetric.getToolTipText());" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tTableColumn objectColumn = new TableColumn(table, SWT.NONE);\t\t\t" + NL + "\t\t\tobjectColumn.setText(\"Element\");" + NL + "\t\t\tobjectColumn.setToolTipText(\"Measurement element\");" + NL + "\t\t\t" + NL + "\t\t\tviewer.setLabelProvider(new Labels());" + NL + "\t\t\tviewer.setContentProvider(new ArrayContentProvider());\t\t\t\t\t\t" + NL + "\t\t\tviewer.addOpenListener(new IOpenListener() {" + NL + "\t\t\t\tpublic void open(OpenEvent event) {" + NL + "\t\t\t\t\thandleOpen(event);" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_45 = " headerSelListener = new ";
  protected final String TEXT_46 = "() {" + NL + "\t\t\t\tpublic void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {" + NL + "\t\t\t\t\ttable.setSortColumn((TableColumn)e.getSource());  " + NL + "\t\t\t\t\ttable.setSortDirection((table.getSortDirection() != SWT.DOWN) ? SWT.DOWN : SWT.UP);" + NL + "\t\t\t\t\tviewer.refresh();" + NL + "\t\t\t\t}\t\t\t\t" + NL + "\t\t\t\tpublic void widgetDefaultSelected(";
  protected final String TEXT_47 = " e) {\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t};\t\t\t" + NL + "\t\t\tTableColumn[] columns = viewer.getTable().getColumns();" + NL + "\t\t\tfor (int i = 0; i < columns.length; i++) {" + NL + "\t\t\t\tcolumns[i].addSelectionListener(headerSelListener);" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tviewer.setSorter(" + NL + "\t\t\t\tnew ViewerSorter() {" + NL + "\t\t\t\t\tpublic int compare(Viewer viewer, Object e1, Object e2) {" + NL + "\t\t\t\t\t\tTableColumn c = table.getSortColumn();" + NL + "\t\t\t\t\t\tint result = 0;" + NL + "\t\t\t\t\t\tif(c != null) {" + NL + "\t\t\t\t\t\t\tMetric mc1 = ((ElementMetrics)e1).getMetricByKey(c.getText());" + NL + "\t\t\t\t\t\t\tMetric mc2 = ((ElementMetrics)e2).getMetricByKey(c.getText());" + NL + "\t\t\t\t\t\t\tresult = (mc1 != null && mc2 != null) ?" + NL + "\t\t\t\t\t\t\t\tmc1.compareTo(mc2) : (mc1 == null ? -1 : 1);" + NL + "\t\t\t\t\t\t} else {" + NL + "\t\t\t\t\t\t\tresult = ((ElementMetrics)e1).targetElementQName.compareTo(((ElementMetrics)e2).targetElementQName);" + NL + "\t\t\t\t\t\t}\t\t\t\t\t\t" + NL + "\t\t\t\t\t\treturn table.getSortDirection() == SWT.DOWN ? result : -result;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t);" + NL + "\t\t\t" + NL + "\t        ";
  protected final String TEXT_48 = " editor = getSite().getPage().getActiveEditor();" + NL + "\t        if(editor != null && editor.getClass().equals(";
  protected final String TEXT_49 = ".class)) {" + NL + "\t\t\t\tsetInput((";
  protected final String TEXT_50 = ")editor);" + NL + "\t        }\t\t\t" + NL + "\t\t}" + NL + "\t\t\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t\t\t" + NL + "\t\tprivate void handleOpen(OpenEvent event) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_51 = ".openEditor(getSite().getPage(), diagramFile, true);" + NL + "\t\t\t} catch (";
  protected final String TEXT_52 = " e) {" + NL + "\t\t\t\t";
  protected final String TEXT_53 = ".getInstance().logError(\"Can't open diagram editor\", e); //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tprivate static ";
  protected final String TEXT_54 = " calcMetricMaxValueStrLenMap(";
  protected final String TEXT_55 = " allMetrics) {" + NL + "\t\t\t";
  protected final String TEXT_56 = " metric2MaxStrLen = new ";
  protected final String TEXT_57 = "();\t\t\t \t" + NL + "\t\t\tfor (int i = 0; i < getMetrics().size(); i++) {" + NL + "\t\t\t\tString nextKey = ((MetricDef)getMetrics().get(i)).key; " + NL + "\t\t\t\tint trimPos = Math.min(nextKey.length(), MAX_VISIBLE_KEY_CHAR_COUNT);" + NL + "\t\t\t\tmetric2MaxStrLen.put(nextKey, nextKey.substring(0, trimPos));\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tfor (";
  protected final String TEXT_58 = " it = allMetrics.iterator(); it.hasNext();) {" + NL + "\t\t\t\tElementMetrics elementMetrics = (ElementMetrics) it.next();" + NL + "\t\t\t\tfor (int i = 0; i < elementMetrics.metrics.length; i++) {" + NL + "\t\t\t\t\tMetric metric = elementMetrics.metrics[i];" + NL + "\t\t\t\t\tString valueStr = (String)metric2MaxStrLen.get(metric.def.key);" + NL + "\t\t\t\t\tif(valueStr == null || metric.displayValue.length() > valueStr.length()) {" + NL + "\t\t\t\t\t\tmetric2MaxStrLen.put(metric.def.key, metric.displayValue);\t" + NL + "\t\t\t\t\t}\t\t\t\t" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn metric2MaxStrLen;\t\t" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void setFocus() {" + NL + "\t\t}\t\t" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tprivate class Labels extends LabelProvider implements ITableLabelProvider, ITableColorProvider {" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t\t" + NL + "\t\t\tprivate boolean isElementColumn(int columnIndex) {" + NL + "\t\t\t\treturn columnIndex >= getMetrics().size();" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t\t" + NL + "\t\t\tpublic ";
  protected final String TEXT_59 = " getColumnImage(Object element, int columnIndex) {\t\t\t\t" + NL + "\t\t\t\treturn isElementColumn(columnIndex) ? ((ElementMetrics)element).elementImage : null;" + NL + "\t\t\t}\t\t" + NL + "\t\t\t" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t\t" + NL + "\t\t\tpublic String getColumnText(Object element, int columnIndex) {" + NL + "\t\t\t\tElementMetrics elementMetrics = (ElementMetrics)element;" + NL + "\t\t\t\t\t\t\t" + NL + "\t\t\t\tif(columnIndex == getMetrics().size()) {" + NL + "\t\t\t\t\treturn elementMetrics.targetElementQName;" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tString key = ((MetricDef)getMetrics().get(columnIndex)).key;" + NL + "\t\t\t\tMetric metric = elementMetrics.getMetricByKey(key);" + NL + "\t\t\t\treturn (metric != null) ? metric.displayValue : \"-\"; //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t\t" + NL + "\t\t\tpublic ";
  protected final String TEXT_60 = " getBackground(Object element, int columnIndex) {" + NL + "\t\t\t\treturn null; " + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t\t" + NL + "\t\t\tpublic ";
  protected final String TEXT_61 = " getForeground(Object element, int columnIndex) {" + NL + "\t\t\t\tif(isElementColumn(columnIndex)) return null;" + NL + "\t\t\t\tElementMetrics columnElement = (ElementMetrics)element;" + NL + "\t\t\t\tString key = ((MetricDef)getMetrics().get(columnIndex)).key;" + NL + "\t\t\t\tMetric metric = columnElement.getMetricByKey(key);\t\t\t" + NL + "\t\t\t\tif(metric != null && metric.value != null) {" + NL + "\t\t\t\t\tif (metric.def.highLimit != null" + NL + "\t\t\t\t\t\t\t&& metric.def.highLimit.longValue() < metric.value.longValue()) {" + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_62 = ".red;" + NL + "\t\t\t\t\t} else if (metric.def.lowLimit != null" + NL + "\t\t\t\t\t\t\t&& metric.def.lowLimit.longValue() > metric.value.longValue()) {" + NL + "\t\t\t\t\t\treturn ";
  protected final String TEXT_63 = ".blue;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t}\t\t" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class ElementMetrics {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tfinal Metric[] metrics;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal String targetElementQName;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tfinal ";
  protected final String TEXT_64 = " elementImage;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tElementMetrics(EObject target, Metric[] metrics) {" + NL + "\t\t\tthis.metrics = metrics;" + NL + "\t\t\tassert metrics.length > 0;" + NL + "\t\t\t" + NL + "\t\t\tEClass imageTarget = target.eClass();\t\t\t" + NL + "\t\t\tif (target instanceof View) {" + NL + "\t\t\t\tView viewTarget = (View) target;" + NL + "\t\t\t\tStringBuffer notationQNameBuf = new StringBuffer();" + NL + "\t\t\t\tnotationQNameBuf.append(";
  protected final String TEXT_65 = ".getQualifiedName(viewTarget, true));" + NL + "\t\t\t\tif (\"\".equals(viewTarget.getType()) && viewTarget.getElement() != null) { //$NON-NLS-1$" + NL + "\t\t\t\t\tnotationQNameBuf" + NL + "\t\t\t\t\t\t.append('-').append('>')" + NL + "\t\t\t\t\t\t.append(";
  protected final String TEXT_66 = ".getQualifiedName(viewTarget.getElement(), true));" + NL + "\t\t\t\t\timageTarget = viewTarget.getElement().eClass();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tint visualID = ";
  protected final String TEXT_67 = ".getVisualID(viewTarget);" + NL + "\t\t\t\tnotationQNameBuf.append('[').append(visualID < 0 ? Integer.toString(System.identityHashCode(viewTarget)) : Integer.toString(visualID)).append(']');\t\t\t\t" + NL + "" + NL + "\t\t\t\tthis.targetElementQName = notationQNameBuf.toString();" + NL + "\t\t\t} else {" + NL + "\t\t\t\tthis.targetElementQName = ";
  protected final String TEXT_68 = ".getQualifiedName(target, true);\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\tthis.elementImage = ";
  protected final String TEXT_69 = ".getImage(imageTarget);\t\t\t" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tMetric getMetricByKey(String key) {" + NL + "\t\t\tfor (int i = 0; i < metrics.length; i++) {" + NL + "\t\t\t\tif(metrics[i].def.key.equals(key)) {" + NL + "\t\t\t\t\treturn metrics[i]; " + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}\t\t" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static class Metric implements Comparable {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tfinal MetricDef def;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal Number value;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal String displayValue;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tMetric(MetricDef def, EObject target) {" + NL + "\t\t\tthis.def = def;" + NL + "\t\t\tvalue = def.calcMetric(target);" + NL + "\t\t\tthis.displayValue = (value != null) ? java.text.NumberFormat.getInstance().format(value) : \"null\"; //$NON-NLS-1$" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int compareTo(Object other) {" + NL + "\t\t\tMetric otherMetric = (Metric)other;" + NL + "\t\t\tif(value != null && otherMetric.value != null) {" + NL + "\t\t\t\treturn (value.longValue() < otherMetric.value.longValue()) ? " + NL + "\t\t\t\t\t\t-1 : (value.longValue() == otherMetric.value.longValue() ? 0 : 1);" + NL + "\t\t\t}" + NL + "\t\t\treturn (value == null && otherMetric.value == null) ? " + NL + "\t\t\t\t\t0 : (value == null) ? -1 : 1;  " + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class MetricDef {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t" + NL + "\t\tfinal Double lowLimit;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal Double highLimit;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal String key;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal ";
  protected final String TEXT_70 = " expression;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal int[] semanticIDs;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal String name;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tfinal String description;" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tMetricDef(String key, ";
  protected final String TEXT_71 = " expression, int[] semanticIDs, " + NL + "\t\t\tDouble low, Double high, String name, String description) {" + NL + "\t\t\tthis.key = key;" + NL + "\t\t\tthis.expression = expression;\t\t\t" + NL + "\t\t\tthis.semanticIDs = semanticIDs;\t\t\t" + NL + "\t\t\tthis.lowLimit = low;" + NL + "\t\t\tthis.highLimit = high;" + NL + "\t\t\tthis.name = name;" + NL + "\t\t\tthis.description = description;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tNumber calcMetric(Object contextInstance) {" + NL + "\t\t\tObject val = expression.evaluate(contextInstance);" + NL + "\t\t\treturn (val instanceof Number) ? (Number)val : null;" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tboolean appliesTo(EObject eObject) {" + NL + "\t\t\tif(eObject instanceof View && semanticIDs != null) {" + NL + "\t\t\t\tint eObjectID = ";
  protected final String TEXT_72 = ".getVisualID((View)eObject); " + NL + "\t\t\t\tfor(int i = 0; i < semanticIDs.length; i++) {" + NL + "\t\t\t\t\tif(semanticIDs[i] == eObjectID) {" + NL + "\t\t\t\t\t\treturn true;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn false;\t\t\t\t" + NL + "\t\t\t}" + NL + "\t\t\treturn eObject != null && (expression.context() instanceof EClass) && " + NL + "\t\t\t\t((EClass)expression.context()).isSuperTypeOf(eObject.eClass());" + NL + "\t\t}" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tString getToolTipText() {" + NL + "\t\t\tStringBuffer buf = new StringBuffer();" + NL + "\t\t\tif(name != null) buf.append(name);" + NL + "\t\t\tif(description != null) buf.append('\\n').append(description).append('\\n');" + NL + "\t\t\tif(lowLimit != null) buf.append(\"low:\").append(lowLimit);" + NL + "\t\t\tif(highLimit != null) buf.append(\" high:\").append(highLimit);" + NL + "\t\t\treturn buf.toString();" + NL + "\t\t}\t\t" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic static ";
  protected final String TEXT_73 = "/*MetricDef*/ getMetricsForTarget(EClass target) {" + NL + "\t\tif(context2MetricsMap == null) {" + NL + "\t\t\tinitializeRegistry();\t\t\t" + NL + "\t\t}" + NL + "\t\treturn (";
  protected final String TEXT_74 = ")context2MetricsMap.get(target);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_75 = " getMetrics() {" + NL + "\t\tif(metricsRegistry == null) {" + NL + "\t\t\tinitializeRegistry();" + NL + "\t\t}" + NL + "\t\treturn metricsRegistry;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic static Number calculateMetric(String metricKey, Object contextInstance) {" + NL + "\t\tif (key2MetricMap == null) {" + NL + "\t\t\tinitializeRegistry();" + NL + "\t\t}" + NL + "\t\tMetricDef metric = (MetricDef)key2MetricMap.get(metricKey);" + NL + "\t\treturn (metric != null) ? metric.calcMetric(contextInstance) : null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static void initializeRegistry() {" + NL + "\t\tif(context2MetricsMap != null) return;";
  protected final String TEXT_76 = "\t\t" + NL + "\t\t";
  protected final String TEXT_77 = NL;
  protected final String TEXT_78 = " ";
  protected final String TEXT_79 = " = new ";
  protected final String TEXT_80 = "(3);";
  protected final String TEXT_81 = ".put(\"";
  protected final String TEXT_82 = "\", ";
  protected final String TEXT_83 = "); //$NON-NLS-1$";
  protected final String TEXT_84 = NL + "\t\tregister(new MetricDef(\"";
  protected final String TEXT_85 = "\"," + NL + "\t\t\t";
  protected final String TEXT_86 = "null";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = "(\"";
  protected final String TEXT_89 = "\", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_90 = ", ";
  protected final String TEXT_91 = ")";
  protected final String TEXT_92 = ".";
  protected final String TEXT_93 = "(\"";
  protected final String TEXT_94 = "\", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_95 = ")";
  protected final String TEXT_96 = "new ";
  protected final String TEXT_97 = "(";
  protected final String TEXT_98 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_99 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_100 = " self = (";
  protected final String TEXT_101 = ")context;";
  protected final String TEXT_102 = "\t" + NL + "\t\t";
  protected final String TEXT_103 = " ";
  protected final String TEXT_104 = " = (";
  protected final String TEXT_105 = ")env.get(\"";
  protected final String TEXT_106 = "\"); //$NON-NLS-1$";
  protected final String TEXT_107 = NL + "\t\treturn ";
  protected final String TEXT_108 = ".";
  protected final String TEXT_109 = "(self";
  protected final String TEXT_110 = ", ";
  protected final String TEXT_111 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_112 = NL + ",";
  protected final String TEXT_113 = NL + "\t\t\t";
  protected final String TEXT_114 = "," + NL + "\t\t\t";
  protected final String TEXT_115 = "new Double(";
  protected final String TEXT_116 = ")";
  protected final String TEXT_117 = "null";
  protected final String TEXT_118 = ",\t\t\t\t\t" + NL + "\t\t\t";
  protected final String TEXT_119 = "new Double(";
  protected final String TEXT_120 = ")";
  protected final String TEXT_121 = "null";
  protected final String TEXT_122 = "," + NL + "\t\t\t";
  protected final String TEXT_123 = "\"";
  protected final String TEXT_124 = "\"";
  protected final String TEXT_125 = "null";
  protected final String TEXT_126 = "," + NL + "\t\t\t";
  protected final String TEXT_127 = "\"";
  protected final String TEXT_128 = "\"";
  protected final String TEXT_129 = "null";
  protected final String TEXT_130 = "));";
  protected final String TEXT_131 = "\t\t" + NL + "\t}\t" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static void register(MetricDef metric) {" + NL + "\t\tif (context2MetricsMap == null) {" + NL + "\t\t\tcontext2MetricsMap = new ";
  protected final String TEXT_132 = "();" + NL + "\t\t\tmetricsRegistry = new ";
  protected final String TEXT_133 = "();" + NL + "\t\t\tkey2MetricMap = new ";
  protected final String TEXT_134 = "();" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_135 = " metrics = (";
  protected final String TEXT_136 = ")context2MetricsMap.get(metric.expression.context());" + NL + "\t\tif(metrics == null) {" + NL + "\t\t\tmetrics = new ";
  protected final String TEXT_137 = "();" + NL + "\t\t\tcontext2MetricsMap.put(metric.expression.context(), metrics);" + NL + "\t\t}" + NL + "\t\tmetricsRegistry.add(metric);" + NL + "\t\tmetrics.add(metric);" + NL + "\t\tkey2MetricMap.put(metric.key, metric);\t\t" + NL + "\t}\t" + NL;
  protected final String TEXT_138 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class JavaRules {";
  protected final String TEXT_139 = "\t\t";
  protected final String TEXT_140 = NL;
  protected final String TEXT_141 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_142 = " ";
  protected final String TEXT_143 = "(";
  protected final String TEXT_144 = " self";
  protected final String TEXT_145 = ", ";
  protected final String TEXT_146 = " ";
  protected final String TEXT_147 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new UnsupportedOperationException(\"No user implementation provided in '";
  protected final String TEXT_148 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_149 = NL + "\t} //JavaRules";
  protected final String TEXT_150 = "\t\t" + NL + "" + NL + "}";
  protected final String TEXT_151 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenExpressionProviderContainer expressionProviders = genDiagram.getEditorGen().getExpressionProviders();

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
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
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.IAction"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.action.Action"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPart"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IViewPart"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.part.ViewPart"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genDiagram.getMetricViewID());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.resources.IFile"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.workspace.util.WorkspaceSynchronizer"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.GC"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.GC"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.JFaceResources"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.SelectionListener"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.SelectionListener"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.events.SelectionEvent"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorPart"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getEditor().getQualifiedClassName()));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getEditor().getQualifiedClassName()));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.ide.IDE"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Color"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.ColorConstants"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.swt.graphics.Image"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_75);
    
List javaRules = new ArrayList();
for(Iterator it = genDiagram.getEditorGen().getMetrics().getMetrics().iterator(); it.hasNext(); ) {
	GenMetricRule nextMetric = (GenMetricRule)it.next();
	GenClassifier __genExprContext = nextMetric.getTarget() != null ? nextMetric.getTarget().getContext() : null;
	if(__genExprContext == null || nextMetric.getRule() == null) continue;	
	ValueExpression __genValueExpression = nextMetric.getRule();
	String __javaOperationContainer = "JavaRules"; 	
	Map __exprEnvVariables = Collections.EMPTY_MAP;
	String __outEnvVarName = ""; // no env variable to initialize 
	if(expressionProviders != null && expressionProviders.getProvider(__genValueExpression) instanceof GenJavaExpressionProvider) { 
		javaRules.add(nextMetric);
	}

    stringBuffer.append(TEXT_76);
    
{ /*begin the scope*/
/*
java.util.Map __exprEnvVariables
String __outEnvVarName;
*/
if(!__exprEnvVariables.isEmpty() && genDiagram.getEditorGen().getExpressionProviders() != null && 
	genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) 
	instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {	

    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_80);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String nextVariableName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
		String varTypeEClassifierAccess = nextVariableType.getGenPackage().getQualifiedPackageInterfaceName() + ".eINSTANCE.get" + nextVariableType.getClassifierAccessorName()+"()";			


    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(varTypeEClassifierAccess);
    stringBuffer.append(TEXT_83);
    	
	} 
}

    
} /*end the scope*/

    stringBuffer.append(TEXT_84);
    stringBuffer.append(nextMetric.getKey());
    stringBuffer.append(TEXT_85);
    
{ /*begin the scope*/
/*
ValueExpression __genValueExpression;
GenClassifier __genExprContext
java.util.Map __exprEnvVariables
String __outEnvVarName;
String __javaOperationContainer;
*/
	org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase __genExprProvider = (genDiagram.getEditorGen().getExpressionProviders() != null) ? genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) : null;
	String __ctxEClassifierAccess = importManager.getImportedName(__genExprContext.getGenPackage().getQualifiedPackageInterfaceName()) + ".eINSTANCE.get" + __genExprContext.getClassifierAccessorName()+"()";
	String __importedAbstractClass = __genExprProvider != null ? importManager.getImportedName(__genExprProvider.getContainer().getAbstractExpressionQualifiedClassName()) : null;

	if(__genExprProvider == null || __importedAbstractClass == null) {

    stringBuffer.append(TEXT_86);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(__genValueExpression.getBody());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_91);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(__genValueExpression.getBody());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_95);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_96);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_101);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_106);
    		} 
    stringBuffer.append(TEXT_107);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_108);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_109);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_110);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_111);
    }
    } /*end of scope*/
    stringBuffer.append(TEXT_112);
    	
	String IDs = "null";
	if(nextMetric.getTarget() instanceof GenDiagramElementTarget) {
		GenDiagramElementTarget diagramElementTarget = (GenDiagramElementTarget) nextMetric.getTarget();
		StringBuffer buf = new StringBuffer("new int[] {");
		for(Iterator elementIt = diagramElementTarget.getElement().iterator(); elementIt.hasNext();) {
			GenCommonBase nextElement = (GenCommonBase)elementIt.next();
			buf.append(importManager.getImportedName(nextElement.getEditPartQualifiedClassName()) + ".VISUAL_ID");
			if(elementIt.hasNext()) buf.append(',').append(' ');
		}
		buf.append(" }");
		IDs = buf.toString();
	} 
    stringBuffer.append(TEXT_113);
    stringBuffer.append(IDs);
    stringBuffer.append(TEXT_114);
    if(nextMetric.getLowLimit()!=null){
    stringBuffer.append(TEXT_115);
    stringBuffer.append(nextMetric.getLowLimit());
    stringBuffer.append(TEXT_116);
    }else{
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    if(nextMetric.getHighLimit()!=null){
    stringBuffer.append(TEXT_119);
    stringBuffer.append(nextMetric.getHighLimit());
    stringBuffer.append(TEXT_120);
    }else{
    stringBuffer.append(TEXT_121);
    }
    stringBuffer.append(TEXT_122);
    if(nextMetric.getName()!=null){
    stringBuffer.append(TEXT_123);
    stringBuffer.append(nextMetric.getName());
    stringBuffer.append(TEXT_124);
    }else{
    stringBuffer.append(TEXT_125);
    }
    stringBuffer.append(TEXT_126);
    if(nextMetric.getDescription()!=null){
    stringBuffer.append(TEXT_127);
    stringBuffer.append(nextMetric.getDescription());
    stringBuffer.append(TEXT_128);
    }else{
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    
} /* metrics iteration */

    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_137);
    
if(!javaRules.isEmpty()) {	

    stringBuffer.append(TEXT_138);
    
	for(Iterator it = javaRules.iterator(); it.hasNext();) {
		GenMetricRule nextMetric = (GenMetricRule)it.next();
		GenClassifier __genExprContext = nextMetric.getTarget().getContext();		
		ValueExpression __genValueExpression = nextMetric.getRule();
		String __genExprResultType = "java.lang.Double";		
		Map __exprEnvVariables = Collections.EMPTY_MAP;		

    stringBuffer.append(TEXT_139);
    stringBuffer.append(TEXT_140);
    
/* 
ValueExpression __genValueExpression
java.util.Map __exprEnvVariables
GenClassifier __genExprContext
GenClassifier || String/qualifiedClassName/__genExprResultType
*/
org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase __genExprProvider = (genDiagram.getEditorGen().getExpressionProviders() != null) ? genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) : null;
if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) {
	String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
	// support GenClassifier and also String based qualified java class name
	Object __genExprResultTypeObj = __genExprResultType;
	String __exprResultTypeQualifiedName = null;
	if(__genExprResultTypeObj instanceof String) 
		__exprResultTypeQualifiedName = (String)__genExprResultTypeObj;
	else if(__genExprResultTypeObj instanceof org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)
		__exprResultTypeQualifiedName = __genExprProvider.getQualifiedInstanceClassName((org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__genExprResultTypeObj);
	String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);

    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_144);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_147);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_148);
    
}

    
	}

    stringBuffer.append(TEXT_149);
    
} /* end of JavaRules */

    stringBuffer.append(TEXT_150);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_151);
    return stringBuffer.toString();
  }
}
