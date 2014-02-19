package edithelpers

import org.eclipse.gmf.codegen.gmfgen.ElementType
import org.eclipse.gmf.codegen.gmfgen.MetamodelType
import org.eclipse.gmf.codegen.gmfgen.SpecializationType

class edithelper {

def main(ElementType it)'''
public class «className(it)» extends org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice {

	public org.eclipse.gmf.runtime.common.core.command.ICommand getBeforeEditCommand(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest request) {
		return new MarkerCommand("before");
	}
	
	public org.eclipse.gmf.runtime.common.core.command.ICommand getAfterEditCommand(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest request) {
		return new MarkerCommand("after");
	}
	
	private class MarkerCommand extends org.eclipse.gmf.runtime.common.core.command.AbstractCommand {
		public MarkerCommand(String name) {
			super(name + "MarkerCommand«diagramElement.visualID»");
		}
		
		protected org.eclipse.gmf.runtime.common.core.command.CommandResult doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor progressMonitor, org.eclipse.core.runtime.IAdaptable info) {
			return null;
		}
		
		protected org.eclipse.gmf.runtime.common.core.command.CommandResult doRedoWithResult(org.eclipse.core.runtime.IProgressMonitor progressMonitor, org.eclipse.core.runtime.IAdaptable info) {
			return null;
		}
		
		protected org.eclipse.gmf.runtime.common.core.command.CommandResult doUndoWithResult(org.eclipse.core.runtime.IProgressMonitor progressMonitor, org.eclipse.core.runtime.IAdaptable info) {
			return null;
		}
	}
}
'''

def dispatch className(ElementType it) {
	throw new IllegalStateException('Should never be called')
}

def dispatch className(MetamodelType it)'''«editHelperClassName»ExternalAdvice'''

def dispatch className(SpecializationType it)'''«IF editHelperAdviceClassName == null || editHelperAdviceClassName.length == 0»«diagramElement.getUniqueIdentifier()»«ELSE»«editHelperAdviceClassName»«ENDIF»ExternalAdvice'''
}