package jscratch.traces;

import jscratch.vue.widgets.Widget;
import org.jdom2.Element;

/**
 * @since 1.0
 * @version 1.0
 */
public class TraceWidgetSuppression extends Trace {

	/**
	 * Le widget.
	 */
	private Widget widget;
	
	/**
	 * Constructeur par défaut de <code>TraceSuppressionWidget</code>.
	 */
	public TraceWidgetSuppression(final Widget widget) {
		super(TypeTrace.WIDGET_SUPPRESSION);
		this.widget = widget;
	}

	@Override
	public Element toXml() {
		Element thisXml = super.toXml();
		
		thisXml.addContent(widget.toXml());
		
		return thisXml;
	}
}