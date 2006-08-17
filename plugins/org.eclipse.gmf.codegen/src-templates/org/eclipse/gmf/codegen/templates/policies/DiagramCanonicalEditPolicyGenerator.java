package org.eclipse.gmf.codegen.templates.policies;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class DiagramCanonicalEditPolicyGenerator {
 
  protected static String nl;
  public static synchronized DiagramCanonicalEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramCanonicalEditPolicyGenerator result = new DiagramCanonicalEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import java.util.List;" + NL + "import java.util.Collection;" + NL + "import org.eclipse.gmf.runtime.notation.Edge;" + NL + "import org.eclipse.emf.ecore.EObject;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {" + NL + "\t";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = "/**" + NL + " * @generated" + NL + " */" + NL + "protected ";
  protected final String TEXT_10 = " getSemanticChildrenList() {" + NL + "\t";
  protected final String TEXT_11 = " result = new ";
  protected final String TEXT_12 = "();";
  protected final String TEXT_13 = NL + "\t";
  protected final String TEXT_14 = " modelObject = ((";
  protected final String TEXT_15 = ") getHost().getModel()).getElement();" + NL + "\t";
  protected final String TEXT_16 = " viewObject = (";
  protected final String TEXT_17 = ") getHost().getModel();";
  protected final String TEXT_18 = "\t";
  protected final String TEXT_19 = " nextValue;" + NL + "\tint nodeVID;";
  protected final String TEXT_20 = "\tfor (";
  protected final String TEXT_21 = " values = ";
  protected final String TEXT_22 = ".iterator(); values.hasNext();) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_23 = ") values.next();";
  protected final String TEXT_24 = NL + "\tnextValue = ";
  protected final String TEXT_25 = ";";
  protected final String TEXT_26 = NL + "\tnodeVID = ";
  protected final String TEXT_27 = ".getNodeVisualID(viewObject, nextValue);";
  protected final String TEXT_28 = NL + "\tswitch (nodeVID) {";
  protected final String TEXT_29 = NL + "\tcase ";
  protected final String TEXT_30 = ".VISUAL_ID: {";
  protected final String TEXT_31 = NL + "\tif (";
  protected final String TEXT_32 = ".VISUAL_ID == nodeVID) {";
  protected final String TEXT_33 = NL + "\t\tresult.add(nextValue);";
  protected final String TEXT_34 = NL;
  protected final String TEXT_35 = "\t\tbreak;";
  protected final String TEXT_36 = "\t}";
  protected final String TEXT_37 = NL + "\t}";
  protected final String TEXT_38 = NL + "\t}";
  protected final String TEXT_39 = NL + "\treturn result;" + NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "protected boolean shouldDeleteView(";
  protected final String TEXT_40 = " view) {" + NL + "\treturn view.isSetElement() && view.getElement() != null && view.getElement().eIsProxy();" + NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "protected String getDefaultFactoryHint() {" + NL + "\treturn null;" + NL + "}";
  protected final String TEXT_41 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getSemanticConnectionsList() {" + NL + "\t\treturn ";
  protected final String TEXT_42 = ".EMPTY_LIST;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject getSourceElement(EObject relationship) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject getTargetElement(EObject relationship) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean shouldIncludeConnection(Edge connector, Collection children) {" + NL + "\t\treturn false;" + NL + "\t}" + NL;
  protected final String TEXT_43 = NL;
  protected final String TEXT_44 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshSemantic() {" + NL + "\t\t";
  protected final String TEXT_45 = " createdViews = new ";
  protected final String TEXT_46 = "();" + NL + "\t\tcreatedViews.addAll(refreshSemanticChildren());";
  protected final String TEXT_47 = NL + "\t\tcreatedViews.addAll(refreshPhantoms());";
  protected final String TEXT_48 = NL + "\t\t";
  protected final String TEXT_49 = " createdConnectionViews = new ";
  protected final String TEXT_50 = "();" + NL + "\t\tcreatedConnectionViews.addAll(refreshSemanticConnections());" + NL + "\t\tcreatedConnectionViews.addAll(refreshConnections());" + NL + "" + NL + "\t\tif (createdViews.size() > 1) {" + NL + "\t\t\t// perform a layout of the container" + NL + "\t\t\t";
  protected final String TEXT_51 = " layoutCmd = new ";
  protected final String TEXT_52 = "(host().getEditingDomain(), createdViews, host());" + NL + "\t\t\texecuteCommand(new ";
  protected final String TEXT_53 = "(layoutCmd));" + NL + "\t\t}" + NL + "" + NL + "\t\tcreatedViews.addAll(createdConnectionViews);" + NL + "\t\tmakeViewsImmutable(createdViews);" + NL + "\t}";
  protected final String TEXT_54 = NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_55 = " refreshPhantoms() {" + NL + "\t\t";
  protected final String TEXT_56 = " phantomNodes = new ";
  protected final String TEXT_57 = "();" + NL + "\t\t";
  protected final String TEXT_58 = " diagramModelObject = ((";
  protected final String TEXT_59 = ") getHost().getModel()).getElement();" + NL + "\t\t";
  protected final String TEXT_60 = " diagram = getDiagram();";
  protected final String TEXT_61 = NL;
  protected final String TEXT_62 = " resource = diagramModelObject.eResource();" + NL + "for (";
  protected final String TEXT_63 = " it = resource.getContents().iterator(); it.hasNext();) {" + NL + "\t";
  protected final String TEXT_64 = " nextResourceObject = (";
  protected final String TEXT_65 = ") it.next();" + NL + "\tif (nextResourceObject == diagramModelObject) {" + NL + "\t\tcontinue;" + NL + "\t}" + NL + "\tint nodeVID = ";
  protected final String TEXT_66 = ".getNodeVisualID(diagram, nextResourceObject);" + NL + "\tswitch (nodeVID) {";
  protected final String TEXT_67 = NL + "\tcase ";
  protected final String TEXT_68 = ".VISUAL_ID: {" + NL + "\t\t\tphantomNodes.add(nextResourceObject);";
  protected final String TEXT_69 = NL;
  protected final String TEXT_70 = "\t\tbreak;" + NL + "\t}";
  protected final String TEXT_71 = "\t}" + NL + "}";
  protected final String TEXT_72 = NL;
  protected final String TEXT_73 = NL;
  protected final String TEXT_74 = "for (";
  protected final String TEXT_75 = " diagramNodes = getDiagram().getChildren().iterator(); diagramNodes.hasNext();) {" + NL + "\t";
  protected final String TEXT_76 = " nextView = (";
  protected final String TEXT_77 = ") diagramNodes.next();" + NL + "\t";
  protected final String TEXT_78 = " nextViewElement = nextView.getElement();" + NL + "\tif (phantomNodes.contains(nextViewElement)) {" + NL + "\t\tphantomNodes.remove(nextViewElement);" + NL + "\t}\t" + NL + "}" + NL + "\t\treturn createPhantomNodes(phantomNodes);" + NL + "\t}" + NL;
  protected final String TEXT_79 = NL;
  protected final String TEXT_80 = "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_81 = " createPhantomNodes(";
  protected final String TEXT_82 = " nodes) {" + NL + "\tif (nodes.isEmpty()) {" + NL + "\t\treturn ";
  protected final String TEXT_83 = ".EMPTY_LIST;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_84 = " descriptors = new ";
  protected final String TEXT_85 = "();" + NL + "\tfor (";
  protected final String TEXT_86 = " elements = nodes.iterator(); elements.hasNext();) {" + NL + "\t\t";
  protected final String TEXT_87 = " element = (";
  protected final String TEXT_88 = ")elements.next();" + NL + "\t\t";
  protected final String TEXT_89 = ".ViewDescriptor descriptor = getViewDescriptor(element);" + NL + "\t\tdescriptors.add(descriptor);" + NL + "\t}" + NL + "\t";
  protected final String TEXT_90 = " diagram = getDiagram();" + NL + "\t";
  protected final String TEXT_91 = " diagramEditPart = getDiagramEditPart();" + NL + "\t" + NL + "\t";
  protected final String TEXT_92 = " request = getCreateViewRequest(descriptors);" + NL + "\t";
  protected final String TEXT_93 = " cmd = diagramEditPart.getCommand(request);" + NL + "\tif (cmd == null) {" + NL + "\t\t";
  protected final String TEXT_94 = " cc = new ";
  protected final String TEXT_95 = "(";
  protected final String TEXT_96 = ".AddCommand_Label);" + NL + "\t\tfor (";
  protected final String TEXT_97 = " descriptorsIterator = descriptors.iterator(); descriptorsIterator.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_98 = ".ViewDescriptor descriptor = (";
  protected final String TEXT_99 = ".ViewDescriptor) descriptorsIterator.next();" + NL + "\t\t\t";
  protected final String TEXT_100 = " createCommand = new ";
  protected final String TEXT_101 = "(((";
  protected final String TEXT_102 = ") getHost()).getEditingDomain(), descriptor, diagram);" + NL + "\t\t\tcc.compose(createCommand);" + NL + "\t\t}" + NL + "\t\tcmd = new ";
  protected final String TEXT_103 = "(cc);" + NL + "\t}\t" + NL + "\t" + NL + "\t";
  protected final String TEXT_104 = " adapters = ";
  protected final String TEXT_105 = ".EMPTY_LIST;" + NL + "\tif ( cmd != null && cmd.canExecute() ) {" + NL + "\t\t";
  protected final String TEXT_106 = ".makeMutable(new ";
  protected final String TEXT_107 = "(((";
  protected final String TEXT_108 = ") diagramEditPart).getNotationView())).execute();" + NL + "\t\texecuteCommand(cmd);" + NL + "\t\tadapters = (";
  protected final String TEXT_109 = ") request.getNewObject();" + NL + "\t}" + NL + "\tdiagramEditPart.refresh();" + NL + "\treturn adapters;" + NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_110 = " getDiagramEditPart() {" + NL + "\treturn (";
  protected final String TEXT_111 = ") getHost().getViewer().getEditPartRegistry().get(getDiagram());" + NL + "}";
  protected final String TEXT_112 = NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_113 = " myLinkDescriptors = new ";
  protected final String TEXT_114 = "();" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_115 = " myEObject2ViewMap = new ";
  protected final String TEXT_116 = "();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_117 = " refreshConnections() {" + NL + "\t\ttry {" + NL + "\t\t\tcollectAllLinks(getDiagram());" + NL + "\t\t\t";
  protected final String TEXT_118 = " existingLinks = new ";
  protected final String TEXT_119 = "(getDiagram().getEdges());" + NL + "\t\t\tfor (";
  protected final String TEXT_120 = " diagramLinks = existingLinks.iterator(); diagramLinks.hasNext();) {" + NL + "\t\t\t\tEdge nextDiagramLink = (Edge) diagramLinks.next();" + NL + "\t\t\t\t";
  protected final String TEXT_121 = " diagramLinkObject = nextDiagramLink.getElement();" + NL + "\t\t\t\t";
  protected final String TEXT_122 = " diagramLinkSrc = nextDiagramLink.getSource().getElement();" + NL + "\t\t\t\t";
  protected final String TEXT_123 = " diagramLinkDst = nextDiagramLink.getTarget().getElement();" + NL + "\t\t\t\tint diagramLinkVisualID = ";
  protected final String TEXT_124 = ".getVisualID(nextDiagramLink);" + NL + "\t\t\t\tfor (";
  protected final String TEXT_125 = " modelLinkDescriptors = myLinkDescriptors.iterator(); modelLinkDescriptors.hasNext();) {" + NL + "\t\t\t\t\tLinkDescriptor nextLinkDescriptor = (LinkDescriptor) modelLinkDescriptors.next();" + NL + "\t\t\t\t\tif (diagramLinkObject == nextLinkDescriptor.getLinkElement() && diagramLinkSrc == nextLinkDescriptor.getSource() && diagramLinkDst == nextLinkDescriptor.getDestination() && diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {" + NL + "\t\t\t\t\t\tdiagramLinks.remove();" + NL + "\t\t\t\t\t\tmodelLinkDescriptors.remove();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\tdeleteViews(existingLinks.iterator());" + NL + "\t\t\treturn createConnections(myLinkDescriptors);" + NL + "\t\t} finally {" + NL + "\t\t\tmyLinkDescriptors.clear();" + NL + "\t\t\tmyEObject2ViewMap.clear();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void collectAllLinks(";
  protected final String TEXT_126 = " view) {" + NL + "\t\t";
  protected final String TEXT_127 = " modelElement = view.getElement();" + NL + "\t\tint diagramElementVisualID = ";
  protected final String TEXT_128 = ".getVisualID(view);" + NL + "\t\tswitch (diagramElementVisualID) {";
  protected final String TEXT_129 = NL + "\t\tcase ";
  protected final String TEXT_130 = ".VISUAL_ID:";
  protected final String TEXT_131 = " { myEObject2ViewMap.put(modelElement, view);" + NL + "\t\t\tstoreLinks(modelElement, getDiagram());" + NL + "\t\t}" + NL + "\t\tdefault: {" + NL + "\t\t}" + NL + "\t\tfor (";
  protected final String TEXT_132 = " children = view.getChildren().iterator(); children.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_133 = " childView = (";
  protected final String TEXT_134 = ") children.next();" + NL + "\t\t\tcollectAllLinks(childView);" + NL + "\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_135 = " createConnections(";
  protected final String TEXT_136 = " linkDescriptors) {" + NL + "\t\tif (linkDescriptors.isEmpty()) {" + NL + "\t\t\treturn ";
  protected final String TEXT_137 = ".EMPTY_LIST;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_138 = " adapters = new ";
  protected final String TEXT_139 = "();" + NL + "\t\tfor (";
  protected final String TEXT_140 = " linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator.hasNext();) {" + NL + "\t\t\tfinal LinkDescriptor nextLinkDescriptor = (LinkDescriptor) linkDescriptorsIterator.next();" + NL + "\t\t\t";
  protected final String TEXT_141 = " sourceEditPart = getEditPartFor(nextLinkDescriptor.getSource());" + NL + "\t\t\t";
  protected final String TEXT_142 = " targetEditPart = getEditPartFor(nextLinkDescriptor.getDestination());" + NL + "\t\t\tif (sourceEditPart == null || targetEditPart == null) {" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_143 = ".ConnectionViewDescriptor descriptor = new ";
  protected final String TEXT_144 = ".ConnectionViewDescriptor(nextLinkDescriptor.getSemanticAdapter(), null, ";
  protected final String TEXT_145 = ".APPEND, false, ((";
  protected final String TEXT_146 = ") getHost()).getDiagramPreferencesHint());" + NL + "\t\t\t";
  protected final String TEXT_147 = " ccr = new ";
  protected final String TEXT_148 = "(descriptor);" + NL + "\t\t\tccr.setType(";
  protected final String TEXT_149 = ".REQ_CONNECTION_START);" + NL + "\t\t\tccr.setSourceEditPart(sourceEditPart);" + NL + "\t\t\tsourceEditPart.getCommand(ccr);" + NL + "\t\t\tccr.setTargetEditPart(targetEditPart);" + NL + "\t\t\tccr.setType(";
  protected final String TEXT_150 = ".REQ_CONNECTION_END);" + NL + "\t\t\t";
  protected final String TEXT_151 = " cmd = targetEditPart.getCommand(ccr);" + NL + "\t\t\tif (cmd != null && cmd.canExecute()) {" + NL + "\t\t\t\texecuteCommand(cmd);" + NL + "\t\t\t\t";
  protected final String TEXT_152 = " viewAdapter = (";
  protected final String TEXT_153 = ") ccr.getNewObject();" + NL + "\t\t\t\tif (viewAdapter != null) {" + NL + "\t\t\t\t\tadapters.add(viewAdapter);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn adapters;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_154 = " getEditPartFor(";
  protected final String TEXT_155 = " modelElement) {" + NL + "\t\t";
  protected final String TEXT_156 = " view = (";
  protected final String TEXT_157 = ") myEObject2ViewMap.get(modelElement);" + NL + "\t\tif (view != null) {" + NL + "\t\t\treturn (";
  protected final String TEXT_158 = ") getHost().getViewer().getEditPartRegistry().get(view);" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_159 = NL;
  protected final String TEXT_160 = "/**" + NL + " *@generated" + NL + " */" + NL + "private void storeLinks(";
  protected final String TEXT_161 = " container, ";
  protected final String TEXT_162 = " diagram) {" + NL + "\t";
  protected final String TEXT_163 = " containerMetaclass = container.eClass();" + NL + "\tstoreFeatureModelFacetLinks(container, containerMetaclass, diagram);" + NL + "\tstoreTypeModelFacetLinks(container, containerMetaclass);" + NL + "}" + NL + "\t" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void storeTypeModelFacetLinks(";
  protected final String TEXT_164 = " container, ";
  protected final String TEXT_165 = " containerMetaclass) {\t";
  protected final String TEXT_166 = "\t\t" + NL + "\tif (";
  protected final String TEXT_167 = ".eINSTANCE.get";
  protected final String TEXT_168 = "().isSuperTypeOf(containerMetaclass)) {";
  protected final String TEXT_169 = "\t\t" + NL + "\t\tfor (";
  protected final String TEXT_170 = " values = ";
  protected final String TEXT_171 = ".iterator(); values.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_172 = " nextValue = ((";
  protected final String TEXT_173 = ") values.next());";
  protected final String TEXT_174 = NL + "\t\t";
  protected final String TEXT_175 = " nextValue = (";
  protected final String TEXT_176 = ") ";
  protected final String TEXT_177 = ";";
  protected final String TEXT_178 = NL + "\t\tint linkVID = ";
  protected final String TEXT_179 = ".getLinkWithClassVisualID(nextValue);" + NL + "\t\tif (";
  protected final String TEXT_180 = ".VISUAL_ID == linkVID) {" + NL + "\t\t\tObject structuralFeatureResult = ";
  protected final String TEXT_181 = ";" + NL + "\t\t\tif (structuralFeatureResult instanceof ";
  protected final String TEXT_182 = ") {" + NL + "\t\t\t\t";
  protected final String TEXT_183 = " dst = (";
  protected final String TEXT_184 = ") structuralFeatureResult;";
  protected final String TEXT_185 = NL + "\t\t\t\tstructuralFeatureResult = ";
  protected final String TEXT_186 = ";" + NL + "\t\t\t\tif (structuralFeatureResult instanceof ";
  protected final String TEXT_187 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_188 = " src = (";
  protected final String TEXT_189 = ") structuralFeatureResult;";
  protected final String TEXT_190 = NL + "\t\t\t\t";
  protected final String TEXT_191 = " src = container;";
  protected final String TEXT_192 = NL + "\t\t\t\tmyLinkDescriptors.add(new LinkDescriptor(src, dst, nextValue, linkVID));";
  protected final String TEXT_193 = NL + "\t\t\t\t}";
  protected final String TEXT_194 = NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_195 = NL + "\t\t}";
  protected final String TEXT_196 = NL + "\t}";
  protected final String TEXT_197 = NL + "}" + NL + "" + NL + "/**" + NL + " *@generated" + NL + " */" + NL + "private void storeFeatureModelFacetLinks(";
  protected final String TEXT_198 = " container, ";
  protected final String TEXT_199 = " containerMetaclass, ";
  protected final String TEXT_200 = " diagram) {";
  protected final String TEXT_201 = NL;
  protected final String TEXT_202 = "\tif (";
  protected final String TEXT_203 = ".eINSTANCE.get";
  protected final String TEXT_204 = "().isSuperTypeOf(containerMetaclass)) {";
  protected final String TEXT_205 = NL + "\t\tfor (";
  protected final String TEXT_206 = " destinations = ";
  protected final String TEXT_207 = ".iterator(); destinations.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_208 = " nextDestination = (";
  protected final String TEXT_209 = ") destinations.next();";
  protected final String TEXT_210 = NL + "\t\t";
  protected final String TEXT_211 = " nextDestination = (";
  protected final String TEXT_212 = ") ";
  protected final String TEXT_213 = ";";
  protected final String TEXT_214 = NL + "\t\tif (";
  protected final String TEXT_215 = ".VISUAL_ID == ";
  protected final String TEXT_216 = ".getNodeVisualID(diagram, nextDestination)) {";
  protected final String TEXT_217 = NL + "\t\tmyLinkDescriptors.add(new LinkDescriptor(container, nextDestination, ";
  protected final String TEXT_218 = ".";
  protected final String TEXT_219 = ", ";
  protected final String TEXT_220 = ".VISUAL_ID));";
  protected final String TEXT_221 = NL + "\t\t";
  protected final String TEXT_222 = " nextNode = ViewService.createNode(diagram, nextDestination, ";
  protected final String TEXT_223 = ".getType(";
  protected final String TEXT_224 = ".VISUAL_ID), ";
  protected final String TEXT_225 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\tmyEObject2NodeMap.put(nextDestination, nextNode);" + NL + "\t\tcreate";
  protected final String TEXT_226 = "Children(nextNode, nextDestination);";
  protected final String TEXT_227 = NL;
  protected final String TEXT_228 = NL + "\t\t}";
  protected final String TEXT_229 = NL + "\t\t}";
  protected final String TEXT_230 = NL + "\t}";
  protected final String TEXT_231 = NL;
  protected final String TEXT_232 = "\tif (";
  protected final String TEXT_233 = ".eINSTANCE.get";
  protected final String TEXT_234 = "().isSuperTypeOf(containerMetaclass)) {";
  protected final String TEXT_235 = NL + "\t\tfor (";
  protected final String TEXT_236 = " destinations = ";
  protected final String TEXT_237 = ".iterator(); destinations.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_238 = " nextDestination = (";
  protected final String TEXT_239 = ") destinations.next();";
  protected final String TEXT_240 = NL + "\t\t";
  protected final String TEXT_241 = " nextDestination = (";
  protected final String TEXT_242 = ") ";
  protected final String TEXT_243 = ";";
  protected final String TEXT_244 = NL + "\t\tif (";
  protected final String TEXT_245 = ".VISUAL_ID == ";
  protected final String TEXT_246 = ".getNodeVisualID(diagram, nextDestination)) {";
  protected final String TEXT_247 = NL + "\t\tmyLinkDescriptors.add(new LinkDescriptor(container, nextDestination, ";
  protected final String TEXT_248 = ".";
  protected final String TEXT_249 = ", ";
  protected final String TEXT_250 = ".VISUAL_ID));";
  protected final String TEXT_251 = NL;
  protected final String TEXT_252 = NL + "\t\t}";
  protected final String TEXT_253 = NL + "\t\t}";
  protected final String TEXT_254 = NL + "\t}";
  protected final String TEXT_255 = NL + "}" + NL + "\t";
  protected final String TEXT_256 = NL;
  protected final String TEXT_257 = "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_258 = " getDiagram() {" + NL + "\treturn ((";
  protected final String TEXT_259 = ") getHost().getModel()).getDiagram();" + NL + "}" + NL;
  protected final String TEXT_260 = NL;
  protected final String TEXT_261 = "/**" + NL + " * @generated" + NL + " */" + NL + "private class LinkDescriptor {" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_262 = " mySource;" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_263 = " myDestination;" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_264 = " myLinkElement;" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate int myVisualID;" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_265 = " mySemanticAdapter;" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected LinkDescriptor(";
  protected final String TEXT_266 = " source, ";
  protected final String TEXT_267 = " destination, ";
  protected final String TEXT_268 = " linkElement, int linkVID) {" + NL + "\t\tthis(source, destination, linkVID);" + NL + "\t\tmyLinkElement = linkElement;" + NL + "\t\tmySemanticAdapter = new ";
  protected final String TEXT_269 = "(linkElement);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected LinkDescriptor(";
  protected final String TEXT_270 = " source, ";
  protected final String TEXT_271 = " destination, ";
  protected final String TEXT_272 = " elementType, int linkVID) {" + NL + "\t\tthis(source, destination, linkVID);" + NL + "\t\tmyLinkElement = null;" + NL + "\t\tfinal ";
  protected final String TEXT_273 = " elementTypeCopy = elementType;" + NL + "\t\tmySemanticAdapter = new ";
  protected final String TEXT_274 = "() {" + NL + "\t\t\tpublic Object getAdapter(Class adapter) {" + NL + "\t\t\t\tif (";
  protected final String TEXT_275 = ".class.equals(adapter)) {" + NL + "\t\t\t\t\treturn elementTypeCopy;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprivate LinkDescriptor(";
  protected final String TEXT_276 = " source, ";
  protected final String TEXT_277 = " destination, int linkVID) {" + NL + "\t\tmySource = source;" + NL + "\t\tmyDestination = destination;" + NL + "\t\tmyVisualID = linkVID;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_278 = " getSource() {" + NL + "\t\treturn mySource;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_279 = " getDestination() {" + NL + "\t\treturn myDestination;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_280 = " getLinkElement() {" + NL + "\t\treturn myLinkElement;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected int getVisualID() {" + NL + "\t\treturn myVisualID;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "   \t * @generated" + NL + "     */" + NL + "\tprotected ";
  protected final String TEXT_281 = " getSemanticAdapter() {" + NL + "\t\treturn mySemanticAdapter;" + NL + "\t}" + NL + "}";
  protected final String TEXT_282 = NL + NL + "}";
  protected final String TEXT_283 = NL;

	protected final String getFeatureValueGetter(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			result.append("((");
			if (feature.isListType()) {
				result.append(importManager.getImportedName("java.util.Collection"));
			} else {
				result.append(importManager.getImportedName(feature.getTypeGenClass().getQualifiedInterfaceName()));
			}
			result.append(")");
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eGet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("()))");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			result.append(".");
			result.append(feature.getGetAccessor());
			result.append("()");
		}
		return result.toString();
	}
	
	protected final String getFeatureValueSetterPrefix(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eSet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("(), ");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			if (feature.isListType()) {
				result.append(".");
				result.append(feature.getGetAccessor());
				result.append("().add(");
			} else {
				result.append(".set");
				result.append(feature.getAccessorName());
				result.append("(");
			}
		}
		return result.toString();
	}
 
	protected final String getMetaClassAccessor(GenClass genClass, ImportAssistant importManager) {
		StringBuffer buf = new StringBuffer();
		buf.append(importManager.getImportedName(genClass.getGenPackage().getQualifiedPackageInterfaceName()))
			.append(".eINSTANCE.get") //$NON-NLS-1$
			.append(genClass.getName())
			.append("()"); //$NON-NLS-1$
		return buf.toString();
	} 
 
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
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getCanonicalEditPolicyClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy"));
    stringBuffer.append(TEXT_7);
    
GenClass modelElementInterface = genDiagram.getDomainDiagramElement();
if (modelElementInterface != null) {
	List genNodes = genDiagram.getTopLevelNodes();

    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_12);
    if (genNodes.size() > 0) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_17);
    }
    
Map genFeature2genNodeMap = new LinkedHashMap();
for (int nodeIndex = 0; nodeIndex < genNodes.size(); nodeIndex++) {
	GenNode nextNode = (GenNode) genNodes.get(nodeIndex);
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet == null || typeModelFacet.isPhantomElement()) {
		// Skipping top-level phantoms
		continue;
	}
	GenFeature childMetaFeature = typeModelFacet.getChildMetaFeature();
	if (!genFeature2genNodeMap.containsKey(childMetaFeature)) {
		genFeature2genNodeMap.put(childMetaFeature, new ArrayList());
	}
	((Collection) genFeature2genNodeMap.get(childMetaFeature)).add(nextNode);
}

Set entrySet = genFeature2genNodeMap.entrySet();
if (entrySet.size() > 0) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_19);
    
}

for (Iterator entries = entrySet.iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature childMetaFeature = (GenFeature) nextEntry.getKey();
	Collection genNodesCollection = (Collection) nextEntry.getValue();
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(getFeatureValueGetter("modelObject", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_23);
    	} else {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(getFeatureValueGetter("modelObject", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_25);
    	}
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_27);
    	boolean generateSwitch = genNodesCollection.size() != 1;
	if (generateSwitch) {
    stringBuffer.append(TEXT_28);
    	}
	
	for (Iterator genNodesIterator = genNodesCollection.iterator(); genNodesIterator.hasNext();) {
		GenNode nextNode = (GenNode) genNodesIterator.next();
		if (generateSwitch) {
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_30);
    		} else {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_32);
    		}
    stringBuffer.append(TEXT_33);
    stringBuffer.append(TEXT_34);
    		if (generateSwitch) {
    stringBuffer.append(TEXT_35);
    		}
    stringBuffer.append(TEXT_36);
    	}
	if (generateSwitch) {
    stringBuffer.append(TEXT_37);
    	}
	if (childMetaFeature.isListType()) {
    stringBuffer.append(TEXT_38);
    	}
}
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_42);
    if (modelElementInterface != null) {
    stringBuffer.append(TEXT_43);
    
// Collecting all phantom elements
Map genClass2Phantom = new LinkedHashMap();
for (Iterator topLevelNodes = genDiagram.getTopLevelNodes().iterator(); topLevelNodes.hasNext();) {
	GenTopLevelNode nextTopLevelNode = (GenTopLevelNode) topLevelNodes.next();
	TypeModelFacet nextModelFacet = nextTopLevelNode.getModelFacet();
	if (nextModelFacet == null || !nextModelFacet.isPhantomElement()) {
		continue;
	}
	genClass2Phantom.put(nextModelFacet.getMetaClass(), nextTopLevelNode);
}

    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_46);
    if (genDiagram.isSynchronized() && genClass2Phantom.size() > 0) {
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy"));
    stringBuffer.append(TEXT_53);
    if (genDiagram.isSynchronized() && genClass2Phantom.size() > 0) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(TEXT_61);
    
if (!genClass2Phantom.isEmpty()) {

    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_66);
    
}
for (Iterator phantoms = genClass2Phantom.values().iterator(); phantoms.hasNext();) {
	GenTopLevelNode phantomNode = (GenTopLevelNode) phantoms.next();

    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName(phantomNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(TEXT_70);
    }
if (!genClass2Phantom.isEmpty()) {

    stringBuffer.append(TEXT_71);
    }
    stringBuffer.append(TEXT_72);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CompositeCommand"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CompositeCommand"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.ICommand"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_128);
    
for (Iterator containers = genDiagram.getAllContainers().iterator(); containers.hasNext();) {
	GenContainerBase nextContainer = (GenContainerBase) containers.next();
	if (nextContainer instanceof GenCompartment) {
		continue;
	}
	if (nextContainer instanceof GenNode && ((GenNode) nextContainer).getModelFacet() == null) {
		continue;
	}

    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName(nextContainer.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_130);
    
}		
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_134);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_135);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_136);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_137);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_138);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_139);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_140);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_141);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_142);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest"));
    stringBuffer.append(TEXT_143);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest"));
    stringBuffer.append(TEXT_144);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_145);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart"));
    stringBuffer.append(TEXT_146);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest"));
    stringBuffer.append(TEXT_147);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest"));
    stringBuffer.append(TEXT_148);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants"));
    stringBuffer.append(TEXT_149);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants"));
    stringBuffer.append(TEXT_150);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_151);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_152);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_153);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_154);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_155);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_156);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_157);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_158);
    
boolean createPhantoms = false;
List genLinks = genDiagram.getLinks();

    stringBuffer.append(TEXT_159);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_161);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_162);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_163);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_164);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_165);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	if (nextLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet typeLinkModelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		GenFeature childMetaFeature = typeLinkModelFacet.getChildMetaFeature();

    stringBuffer.append(TEXT_166);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_167);
    stringBuffer.append(childMetaFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_168);
    		if (childMetaFeature.isListType()) {
    stringBuffer.append(TEXT_169);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_170);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_171);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_172);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_173);
    		} else {
    stringBuffer.append(TEXT_174);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_175);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_176);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_177);
    		}
    stringBuffer.append(TEXT_178);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_179);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_180);
    stringBuffer.append(getFeatureValueGetter("nextValue", typeLinkModelFacet.getTargetMetaFeature(), true, importManager));
    stringBuffer.append(TEXT_181);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_182);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_183);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_184);
    		if (typeLinkModelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_185);
    stringBuffer.append(getFeatureValueGetter("nextValue", typeLinkModelFacet.getSourceMetaFeature(), true, importManager));
    stringBuffer.append(TEXT_186);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_187);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_188);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_189);
    		} else {
    stringBuffer.append(TEXT_190);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_191);
    		}
    stringBuffer.append(TEXT_192);
    		if (typeLinkModelFacet.getSourceMetaFeature() != null) {
    stringBuffer.append(TEXT_193);
    		}
    stringBuffer.append(TEXT_194);
    
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_195);
    
		}

    stringBuffer.append(TEXT_196);
    
	}
}

    stringBuffer.append(TEXT_197);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_198);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_199);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_200);
    
for (int linkIndex = 0; linkIndex < genLinks.size(); linkIndex++) {
	boolean phantomsOnly = true;

    stringBuffer.append(TEXT_201);
    
GenLink nextLink = (GenLink) genLinks.get(linkIndex);
if (false == nextLink.getModelFacet() instanceof FeatureModelFacet) {
	continue;
}
FeatureModelFacet linkFMF = (FeatureModelFacet) nextLink.getModelFacet();
GenFeature genFeature = linkFMF.getMetaFeature();
GenTopLevelNode phantomNode = (GenTopLevelNode) genClass2Phantom.get(genFeature.getTypeGenClass());
if (phantomsOnly ? (!genFeature.isContains() || phantomNode == null) : (genFeature.isContains())) {
// Processing only features which are isPhantoms == phantomsOnly
	continue;
}

    stringBuffer.append(TEXT_202);
    stringBuffer.append(importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_203);
    stringBuffer.append(genFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_204);
    	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_205);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_206);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_207);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_208);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_209);
    	} else {
    stringBuffer.append(TEXT_210);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_211);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_212);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_213);
    	}
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_214);
    stringBuffer.append(importManager.getImportedName(phantomNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_215);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_216);
    	}
    stringBuffer.append(TEXT_217);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_218);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_219);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_220);
    	if (createPhantoms) {
    stringBuffer.append(TEXT_221);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_222);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_223);
    stringBuffer.append(importManager.getImportedName(phantomNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_224);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_225);
    stringBuffer.append(phantomNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_226);
    	}
    stringBuffer.append(TEXT_227);
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_228);
    	}
	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_229);
    	}
    stringBuffer.append(TEXT_230);
    
}

for (int linkIndex = 0; linkIndex < genLinks.size(); linkIndex++) {
	boolean phantomsOnly = false;

    stringBuffer.append(TEXT_231);
    
GenLink nextLink = (GenLink) genLinks.get(linkIndex);
if (false == nextLink.getModelFacet() instanceof FeatureModelFacet) {
	continue;
}
FeatureModelFacet linkFMF = (FeatureModelFacet) nextLink.getModelFacet();
GenFeature genFeature = linkFMF.getMetaFeature();
GenTopLevelNode phantomNode = (GenTopLevelNode) genClass2Phantom.get(genFeature.getTypeGenClass());
if (phantomsOnly ? (!genFeature.isContains() || phantomNode == null) : (genFeature.isContains())) {
// Processing only features which are isPhantoms == phantomsOnly
	continue;
}

    stringBuffer.append(TEXT_232);
    stringBuffer.append(importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_233);
    stringBuffer.append(genFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_234);
    	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_235);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_236);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_237);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_238);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_239);
    	} else {
    stringBuffer.append(TEXT_240);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_241);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_242);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_243);
    	}
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_244);
    stringBuffer.append(importManager.getImportedName(phantomNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_245);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_246);
    	}
    stringBuffer.append(TEXT_247);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_248);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_249);
    stringBuffer.append(importManager.getImportedName(nextLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_250);
    stringBuffer.append(TEXT_251);
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_252);
    	}
	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_253);
    	}
    stringBuffer.append(TEXT_254);
    }
    stringBuffer.append(TEXT_255);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_258);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_259);
    stringBuffer.append(TEXT_260);
    
// an inner class 

    stringBuffer.append(TEXT_261);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_262);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_263);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_264);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_265);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_266);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_267);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_268);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_269);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_270);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_271);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_272);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_273);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_274);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_275);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_276);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_277);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_278);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_279);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_280);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_281);
    }
    stringBuffer.append(TEXT_282);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_283);
    return stringBuffer.toString();
  }
}