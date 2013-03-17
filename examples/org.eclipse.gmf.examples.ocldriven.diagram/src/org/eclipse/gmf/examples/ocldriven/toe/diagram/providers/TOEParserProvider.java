package org.eclipse.gmf.examples.ocldriven.toe.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.ocldriven.toe.TOEPackage;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentName2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.DepartmentNameEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.EmployeeName2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.EmployeeNameEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ManagerNameEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.ProjectNameEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.WrappingLabel2EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.WrappingLabel3EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.WrappingLabel4EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.WrappingLabel5EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.WrappingLabel6EditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.edit.parts.WrappingLabelEditPart;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.parsers.DepartmentLabelExpressionLabelParser;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.parsers.MessageFormatParser;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.parsers.ProjectLabelExpressionLabelParser;
import org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TOEParserProvider extends AbstractProvider implements IParserProvider {

	/**
	* @generated
	*/
	private IParser employeeName_5001Parser;

	/**
	* @generated
	*/
	private IParser getEmployeeName_5001Parser() {
		if (employeeName_5001Parser == null) {

			EAttribute[] features = new EAttribute[] { TOEPackage.eINSTANCE.getEmployee_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { TOEPackage.eINSTANCE.getEmployee_Name() };
			MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
			employeeName_5001Parser = parser;
		}
		return employeeName_5001Parser;
	}

	/**
	* @generated
	*/
	private IParser departmentName_5006Parser;

	/**
	* @generated
	*/
	private IParser getDepartmentName_5006Parser() {
		if (departmentName_5006Parser == null) {

			EAttribute[] features = new EAttribute[] { TOEPackage.eINSTANCE.getDepartment_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { TOEPackage.eINSTANCE.getDepartment_Name() };
			MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
			departmentName_5006Parser = parser;
		}
		return departmentName_5006Parser;
	}

	/**
	* @generated
	*/
	private IParser getDepartmentLabel_5007Parser() {
		return new DepartmentLabelExpressionLabelParser();
	}

	/**
	* @generated
	*/
	private IParser getDepartmentLabel_5008Parser() {
		return new DepartmentLabelExpressionLabelParser();
	}

	/**
	* @generated
	*/
	private IParser projectName_5009Parser;

	/**
	* @generated
	*/
	private IParser getProjectName_5009Parser() {
		if (projectName_5009Parser == null) {

			EAttribute[] features = new EAttribute[] { TOEPackage.eINSTANCE.getProject_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { TOEPackage.eINSTANCE.getProject_Name() };
			MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
			projectName_5009Parser = parser;
		}
		return projectName_5009Parser;
	}

	/**
	* @generated
	*/
	private IParser getProjectLabel_5010Parser() {
		return new ProjectLabelExpressionLabelParser();
	}

	/**
	* @generated
	*/
	private IParser getProjectLabel_5011Parser() {
		return new ProjectLabelExpressionLabelParser();
	}

	/**
	* @generated
	*/
	private IParser managerName_5012Parser;

	/**
	* @generated
	*/
	private IParser getManagerName_5012Parser() {
		if (managerName_5012Parser == null) {

			EAttribute[] features = new EAttribute[] { TOEPackage.eINSTANCE.getEmployee_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { TOEPackage.eINSTANCE.getEmployee_Name() };
			MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
			managerName_5012Parser = parser;
		}
		return managerName_5012Parser;
	}

	/**
	* @generated
	*/
	private IParser employeeName_5002Parser;

	/**
	* @generated
	*/
	private IParser getEmployeeName_5002Parser() {
		if (employeeName_5002Parser == null) {

			EAttribute[] features = new EAttribute[] { TOEPackage.eINSTANCE.getEmployee_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { TOEPackage.eINSTANCE.getEmployee_Name() };
			MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
			employeeName_5002Parser = parser;
		}
		return employeeName_5002Parser;
	}

	/**
	* @generated
	*/
	private IParser departmentName_5003Parser;

	/**
	* @generated
	*/
	private IParser getDepartmentName_5003Parser() {
		if (departmentName_5003Parser == null) {

			EAttribute[] features = new EAttribute[] { TOEPackage.eINSTANCE.getDepartment_Name() };
			EAttribute[] editableFeatures = new EAttribute[] { TOEPackage.eINSTANCE.getDepartment_Name() };
			MessageFormatParser parser = new MessageFormatParser(features, editableFeatures);
			departmentName_5003Parser = parser;
		}
		return departmentName_5003Parser;
	}

	/**
	* @generated
	*/
	private IParser getDepartmentLabel_5004Parser() {
		return new DepartmentLabelExpressionLabelParser();
	}

	/**
	* @generated
	*/
	private IParser getDepartmentLabel_5005Parser() {
		return new DepartmentLabelExpressionLabelParser();
	}

	/**
	* @generated
	*/
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case EmployeeNameEditPart.VISUAL_ID:
			return getEmployeeName_5001Parser();
		case DepartmentNameEditPart.VISUAL_ID:
			return getDepartmentName_5006Parser();
		case WrappingLabelEditPart.VISUAL_ID:
			return getDepartmentLabel_5007Parser();
		case WrappingLabel2EditPart.VISUAL_ID:
			return getDepartmentLabel_5008Parser();
		case ProjectNameEditPart.VISUAL_ID:
			return getProjectName_5009Parser();
		case WrappingLabel3EditPart.VISUAL_ID:
			return getProjectLabel_5010Parser();
		case WrappingLabel4EditPart.VISUAL_ID:
			return getProjectLabel_5011Parser();
		case ManagerNameEditPart.VISUAL_ID:
			return getManagerName_5012Parser();
		case EmployeeName2EditPart.VISUAL_ID:
			return getEmployeeName_5002Parser();
		case DepartmentName2EditPart.VISUAL_ID:
			return getDepartmentName_5003Parser();
		case WrappingLabel5EditPart.VISUAL_ID:
			return getDepartmentLabel_5004Parser();
		case WrappingLabel6EditPart.VISUAL_ID:
			return getDepartmentLabel_5005Parser();
		}
		return null;
	}

	/**
	* Utility method that consults ParserService
	* @generated
	*/
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	* @generated
	*/
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(TOEVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(TOEVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	* @generated
	*/
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (TOEElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	* @generated
	*/
	private static class HintAdapter extends ParserHintAdapter {

		/**
		* @generated
		*/
		private final IElementType elementType;

		/**
		* @generated
		*/
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		* @generated
		*/
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
