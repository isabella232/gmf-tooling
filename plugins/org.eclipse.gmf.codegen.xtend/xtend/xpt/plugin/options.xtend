package xpt.plugin

import org.eclipse.gmf.codegen.gmfgen.GenPlugin

class options {

def qualifiedClassName(GenPlugin it) '''.options'''
def fullPath(GenPlugin it) '''«qualifiedClassName(it)»'''

def options(GenPlugin it) '''
# Tracing options for the «ID» plug-in

# Common issues
«ID»/debug=false

# Visual IDs
«ID»/debug/visualID=false
'''
}