package custom;



import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.graphics.Image;

public class MultilineWrappingLabel extends WrappingLabel {
    public MultilineWrappingLabel() {
        super();
        setTextWrap(true);
    }

    public MultilineWrappingLabel(String text) {
        super(text);
        setTextWrap(true);
    }

    public MultilineWrappingLabel(Image image) {
        super(image);
        setTextWrap(true);
    }

    public MultilineWrappingLabel(String text, Image image) {
        super(text, image);
        setTextWrap(true);
    }
}
