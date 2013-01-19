package org.msl.simple.gmfmap.model.triggers.parent;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.TriggerListener;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleChildReference;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleCompartment;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleLabelNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleLinkMapping;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleParentNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleSubNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleTopNode;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimplemappingsPackage;

public class ParentNodeTriggerListener extends TriggerListener implements ResourceSetListener {

	public static NotificationFilter newChildNodeFilter;

	public static NotificationFilter removeChildNodeFilter;

	public ParentNodeTriggerListener() {
		super(NotificationFilter.createNotifierTypeFilter(SimpleParentNode.class));
	}

	static {

		newChildNodeFilter = NotificationFilter.createNotifierTypeFilter(SimpleParentNode.class).and(NotificationFilter.createEventTypeFilter(Notification.ADD))
				.and(NotificationFilter.createFeatureFilter(SimpleParentNode.class, SimplemappingsPackage.SIMPLE_PARENT_NODE__CHILDREN));

		removeChildNodeFilter = NotificationFilter.createNotifierTypeFilter(SimpleParentNode.class).and(NotificationFilter.createEventTypeFilter(Notification.REMOVE))
				.and(NotificationFilter.createFeatureFilter(SimpleParentNode.class, SimplemappingsPackage.SIMPLE_PARENT_NODE__CHILDREN));
	}

	@Override
	protected Command trigger(TransactionalEditingDomain domain, Notification notification) {

		if (newChildNodeFilter.matches(notification)) {
			SimpleChildNode newChild = (SimpleChildNode) notification.getNewValue();
			Object notifier = notification.getNotifier();

			SimpleParentNode parent = (SimpleParentNode) notifier;

			if (newChild instanceof SimpleTopNode)
				return new NewTopNodeTrigger(domain, parent, (SimpleTopNode) newChild);

			if (newChild instanceof SimpleLinkMapping)
				return new NewLinkMappingTrigger(domain, parent, (SimpleLinkMapping) newChild);

			if (newChild instanceof SimpleCompartment)
				return new NewCompartmentTrigger(domain, (SimpleNode) parent, (SimpleCompartment) newChild);

			if (newChild instanceof SimpleSubNode)
				return new NewSubNodeTrigger(domain, parent, (SimpleSubNode) newChild);

			if (newChild instanceof SimpleLabelNode)
				return new NewLabelNodeTrigger(domain, parent, (SimpleLabelNode) newChild);

			if (newChild instanceof SimpleChildReference)
				return new NewChildReferenceTrigger(domain, parent, (SimpleChildReference) newChild);
		}

		if (removeChildNodeFilter.matches(notification)) {
			SimpleChildNode oldChild = (SimpleChildNode) notification.getOldValue();

			return new RemoveChildNodeTrigger(domain, oldChild);

		}

		return null;
	}

}
