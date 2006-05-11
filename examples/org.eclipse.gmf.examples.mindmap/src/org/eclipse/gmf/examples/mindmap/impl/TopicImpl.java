/**
 * <copyright>
 * </copyright>
 *
 * $Id: TopicImpl.java,v 1.1 2006/05/11 01:48:01 rgronback Exp $
 */
package org.eclipse.gmf.examples.mindmap.impl;

import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.Priority;
import org.eclipse.gmf.examples.mindmap.Resource;
import org.eclipse.gmf.examples.mindmap.Topic;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Topic</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getSubtopics <em>Subtopics</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getResources <em>Resources</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getPercentComplete <em>Percent Complete</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getEndDate <em>End Date</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.impl.TopicImpl#getComments <em>Comments</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TopicImpl extends EObjectImpl implements Topic {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSubtopics() <em>Subtopics</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubtopics()
	 * @generated
	 * @ordered
	 */
	protected EList subtopics = null;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList resources = null;

	/**
	 * The default value of the '{@link #getPercentComplete() <em>Percent Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentComplete()
	 * @generated
	 * @ordered
	 */
	protected static final Float PERCENT_COMPLETE_EDEFAULT = new Float(0.0F);

	/**
	 * The cached value of the '{@link #getPercentComplete() <em>Percent Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPercentComplete()
	 * @generated
	 * @ordered
	 */
	protected Float percentComplete = PERCENT_COMPLETE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected static final Priority PRIORITY_EDEFAULT = Priority.ONE_LITERAL;

	/**
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
	protected Priority priority = PRIORITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date START_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
	protected Date startDate = START_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndDate() <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date END_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEndDate() <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndDate()
	 * @generated
	 * @ordered
	 */
	protected Date endDate = END_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected static final Float DURATION_EDEFAULT = new Float(0.0F);

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected Float duration = DURATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getComments() <em>Comments</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComments()
	 * @generated
	 * @ordered
	 */
	protected EList comments = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TopicImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MindmapPackage.Literals.TOPIC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapPackage.TOPIC__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSubtopics() {
		if (subtopics == null) {
			subtopics = new EObjectResolvingEList(Topic.class, this, MindmapPackage.TOPIC__SUBTOPICS);
		}
		return subtopics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getResources() {
		if (resources == null) {
			resources = new EObjectWithInverseResolvingEList.ManyInverse(Resource.class, this, MindmapPackage.TOPIC__RESOURCES, MindmapPackage.RESOURCE__TOPICS);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getPercentComplete() {
		return percentComplete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPercentComplete(Float newPercentComplete) {
		Float oldPercentComplete = percentComplete;
		percentComplete = newPercentComplete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapPackage.TOPIC__PERCENT_COMPLETE, oldPercentComplete, percentComplete));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Priority getPriority() {
		return priority;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPriority(Priority newPriority) {
		Priority oldPriority = priority;
		priority = newPriority == null ? PRIORITY_EDEFAULT : newPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapPackage.TOPIC__PRIORITY, oldPriority, priority));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartDate(Date newStartDate) {
		Date oldStartDate = startDate;
		startDate = newStartDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapPackage.TOPIC__START_DATE, oldStartDate, startDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndDate(Date newEndDate) {
		Date oldEndDate = endDate;
		endDate = newEndDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapPackage.TOPIC__END_DATE, oldEndDate, endDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Float getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(Float newDuration) {
		Float oldDuration = duration;
		duration = newDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapPackage.TOPIC__DURATION, oldDuration, duration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getComments() {
		if (comments == null) {
			comments = new EObjectContainmentEList(org.eclipse.gmf.examples.mindmap.Thread.class, this, MindmapPackage.TOPIC__COMMENTS);
		}
		return comments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MindmapPackage.TOPIC__RESOURCES:
				return ((InternalEList)getResources()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MindmapPackage.TOPIC__RESOURCES:
				return ((InternalEList)getResources()).basicRemove(otherEnd, msgs);
			case MindmapPackage.TOPIC__COMMENTS:
				return ((InternalEList)getComments()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MindmapPackage.TOPIC__NAME:
				return getName();
			case MindmapPackage.TOPIC__SUBTOPICS:
				return getSubtopics();
			case MindmapPackage.TOPIC__RESOURCES:
				return getResources();
			case MindmapPackage.TOPIC__PERCENT_COMPLETE:
				return getPercentComplete();
			case MindmapPackage.TOPIC__PRIORITY:
				return getPriority();
			case MindmapPackage.TOPIC__START_DATE:
				return getStartDate();
			case MindmapPackage.TOPIC__END_DATE:
				return getEndDate();
			case MindmapPackage.TOPIC__DURATION:
				return getDuration();
			case MindmapPackage.TOPIC__COMMENTS:
				return getComments();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MindmapPackage.TOPIC__NAME:
				setName((String)newValue);
				return;
			case MindmapPackage.TOPIC__SUBTOPICS:
				getSubtopics().clear();
				getSubtopics().addAll((Collection)newValue);
				return;
			case MindmapPackage.TOPIC__RESOURCES:
				getResources().clear();
				getResources().addAll((Collection)newValue);
				return;
			case MindmapPackage.TOPIC__PERCENT_COMPLETE:
				setPercentComplete((Float)newValue);
				return;
			case MindmapPackage.TOPIC__PRIORITY:
				setPriority((Priority)newValue);
				return;
			case MindmapPackage.TOPIC__START_DATE:
				setStartDate((Date)newValue);
				return;
			case MindmapPackage.TOPIC__END_DATE:
				setEndDate((Date)newValue);
				return;
			case MindmapPackage.TOPIC__DURATION:
				setDuration((Float)newValue);
				return;
			case MindmapPackage.TOPIC__COMMENTS:
				getComments().clear();
				getComments().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case MindmapPackage.TOPIC__NAME:
				setName(NAME_EDEFAULT);
				return;
			case MindmapPackage.TOPIC__SUBTOPICS:
				getSubtopics().clear();
				return;
			case MindmapPackage.TOPIC__RESOURCES:
				getResources().clear();
				return;
			case MindmapPackage.TOPIC__PERCENT_COMPLETE:
				setPercentComplete(PERCENT_COMPLETE_EDEFAULT);
				return;
			case MindmapPackage.TOPIC__PRIORITY:
				setPriority(PRIORITY_EDEFAULT);
				return;
			case MindmapPackage.TOPIC__START_DATE:
				setStartDate(START_DATE_EDEFAULT);
				return;
			case MindmapPackage.TOPIC__END_DATE:
				setEndDate(END_DATE_EDEFAULT);
				return;
			case MindmapPackage.TOPIC__DURATION:
				setDuration(DURATION_EDEFAULT);
				return;
			case MindmapPackage.TOPIC__COMMENTS:
				getComments().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MindmapPackage.TOPIC__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case MindmapPackage.TOPIC__SUBTOPICS:
				return subtopics != null && !subtopics.isEmpty();
			case MindmapPackage.TOPIC__RESOURCES:
				return resources != null && !resources.isEmpty();
			case MindmapPackage.TOPIC__PERCENT_COMPLETE:
				return PERCENT_COMPLETE_EDEFAULT == null ? percentComplete != null : !PERCENT_COMPLETE_EDEFAULT.equals(percentComplete);
			case MindmapPackage.TOPIC__PRIORITY:
				return priority != PRIORITY_EDEFAULT;
			case MindmapPackage.TOPIC__START_DATE:
				return START_DATE_EDEFAULT == null ? startDate != null : !START_DATE_EDEFAULT.equals(startDate);
			case MindmapPackage.TOPIC__END_DATE:
				return END_DATE_EDEFAULT == null ? endDate != null : !END_DATE_EDEFAULT.equals(endDate);
			case MindmapPackage.TOPIC__DURATION:
				return DURATION_EDEFAULT == null ? duration != null : !DURATION_EDEFAULT.equals(duration);
			case MindmapPackage.TOPIC__COMMENTS:
				return comments != null && !comments.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", percentComplete: ");
		result.append(percentComplete);
		result.append(", priority: ");
		result.append(priority);
		result.append(", startDate: ");
		result.append(startDate);
		result.append(", endDate: ");
		result.append(endDate);
		result.append(", duration: ");
		result.append(duration);
		result.append(')');
		return result.toString();
	}

} //TopicImpl