package edithelpers;

import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class manifest {
  public CharSequence main(final String it) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Manifest-Version: 1.0 ");
    _builder.newLine();
    _builder.append("Bundle-ManifestVersion: 2");
    _builder.newLine();
    _builder.append("Bundle-Name: editHelpers");
    _builder.newLine();
    _builder.append("Bundle-SymbolicName: ");
    _builder.append(it, "");
    _builder.append(";singleton:=true ");
    _builder.newLineIfNotEmpty();
    _builder.append("Bundle-Version: 1.0.0");
    _builder.newLine();
    _builder.append("Bundle-ClassPath: ., bin/");
    _builder.newLine();
    _builder.append("Bundle-Vendor: %providerName");
    _builder.newLine();
    _builder.append("Bundle-Localization: plugin");
    _builder.newLine();
    _builder.append("Require-Bundle: org.eclipse.gmf.runtime.emf.type.core,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.gmf.runtime.common.core,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.gmf.runtime.emf.type.core,");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("org.eclipse.core.runtime");
    _builder.newLine();
    _builder.append("Eclipse-LazyStart: true");
    _builder.newLine();
    _builder.append("Bundle-ActivationPolicy: lazy");
    _builder.newLine();
    return _builder;
  }
}
