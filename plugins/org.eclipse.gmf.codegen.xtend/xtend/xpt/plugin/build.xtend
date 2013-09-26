package xpt.plugin

import org.eclipse.gmf.codegen.gmfgen.GenPlugin

class build {

def qualifiedClassName(GenPlugin it) '''build.properties'''
def fullPath(GenPlugin it) '''«qualifiedClassName(it)»'''

def build(GenPlugin it)'''
«includes»
«compileOrders»
'''

def includes(GenPlugin it)'''
bin.includes = .,\
               icons/,\
               META-INF/,\
               plugin.xml,\
               plugin.properties,\
               messages.properties,\
               .options	
'''
def compileOrders(GenPlugin it)'''
jars.compile.order = .
source.. = src/
output.. = bin/
'''}