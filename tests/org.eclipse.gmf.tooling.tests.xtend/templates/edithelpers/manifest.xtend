package edithelpers

class manifest {
def main(String it)'''
Manifest-Version: 1.0 
Bundle-ManifestVersion: 2
Bundle-Name: editHelpers
Bundle-SymbolicName: «it»;singleton:=true 
Bundle-Version: 1.0.0
Bundle-ClassPath: ., bin/
Bundle-Vendor: %providerName
Bundle-Localization: plugin
Require-Bundle: org.eclipse.gmf.runtime.emf.type.core,
 org.eclipse.gmf.runtime.common.core,
 org.eclipse.gmf.runtime.emf.type.core,
 org.eclipse.core.runtime
Eclipse-LazyStart: true
Bundle-ActivationPolicy: lazy
'''
}