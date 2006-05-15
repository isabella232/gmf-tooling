How to enable tracing for the plugin X:

1. Convert X to aspectj project (project context menu -> AspectJ Tools -> Convert...)
2. Add to X dependency to this plugin (org.eclipse.gmf.dev)
3. Add compiled aspect to aspectpath of X (org.eclipse.gmf.dev/bin to project properties -> AspectJ Aspect Path -> Libraries -> Add Class Folder...)

Checkout org.eclipse.gmf.dev.runtime to enable GMF runtime detailed tracing.
ExtEditPartTracer.aj is a tracing aspect for element types.