/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.dev;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.dialogs.CheckedTreeSelectionDialog;

/**
 * @author dstadnik
 */
public class EditPartTraceRequestFilters {

	private static final Object[] NONE = new Object[0];
	private static final String REQUEST_FILTERS_TAG = "request_filters"; //$NON-NLS-1$
	private static final String CATEGORY_TAG = "category"; //$NON-NLS-1$
	private static final String CATEGORY_NAME_ATTR = "name"; //$NON-NLS-1$
	private static final String FILTER_TAG = "filter"; //$NON-NLS-1$
	private static final String REQUEST_TYPE_ATTR = "request_type"; //$NON-NLS-1$
	private static final String ENABLED_ATTR = "enabled"; //$NON-NLS-1$

	private List<Category> categories;

	public EditPartTraceRequestFilters() {
		categories = new ArrayList<Category>();
		categories.add(new Category("GEF", getRequestFilters(org.eclipse.gef.RequestConstants.class)));
		categories.add(new Category("GMF",
				getRequestFilters(org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.class)));
	}

	public boolean isEnabled(String requestType) {
		for (Category category : categories) {
			Filter filter = category.filters.get(requestType);
			if (filter != null && filter.enabled) {
				return true;
			}
		}
		return false;
	}

	public void readState(IMemento memento) {
		if (memento == null) {
			return;
		}
		IMemento requestFiltersMemento = memento.getChild(REQUEST_FILTERS_TAG);
		if (requestFiltersMemento == null) {
			return;
		}
		for (IMemento categoryMemento : requestFiltersMemento.getChildren(CATEGORY_TAG)) {
			String categoryName = categoryMemento.getString(CATEGORY_NAME_ATTR);
			if (categoryName == null) {
				continue;
			}
			for (Category category : categories) {
				if (!categoryName.equals(category.name)) {
					continue;
				}
				for (IMemento filterMemento : categoryMemento.getChildren(FILTER_TAG)) {
					String requestType = filterMemento.getString(REQUEST_TYPE_ATTR);
					if (requestType == null) {
						continue;
					}
					String enabled = filterMemento.getString(ENABLED_ATTR);
					if (!Boolean.parseBoolean(enabled)) {
						continue;
					}
					Filter filter = category.filters.get(requestType);
					if (filter != null) {
						filter.enabled = true;
					}
				}
			}
		}
	}

	public void writeState(IMemento memento) {
		if (memento == null) {
			return;
		}
		IMemento requestFiltersMemento = memento.getChild(REQUEST_FILTERS_TAG);
		if (requestFiltersMemento == null) {
			requestFiltersMemento = memento.createChild(REQUEST_FILTERS_TAG);
		}
		for (Category category : categories) {
			IMemento categoryMemento = null;
			for (IMemento existingCategoryMemento : requestFiltersMemento.getChildren(CATEGORY_TAG)) {
				String categoryName = existingCategoryMemento.getString(CATEGORY_NAME_ATTR);
				if (category.name.equals(categoryName)) {
					categoryMemento = existingCategoryMemento;
					break;
				}
			}
			if (categoryMemento == null) {
				categoryMemento = requestFiltersMemento.createChild(CATEGORY_TAG);
				categoryMemento.putString(CATEGORY_NAME_ATTR, category.name);
			}
			for (Filter filter : category.filters.values()) {
				IMemento filterMemento = null;
				for (IMemento existingFilterMemento : categoryMemento.getChildren(FILTER_TAG)) {
					String requestType = existingFilterMemento.getString(REQUEST_TYPE_ATTR);
					if (filter.type.equals(requestType)) {
						filterMemento = existingFilterMemento;
						break;
					}
				}
				if (filterMemento == null) {
					if (!filter.enabled) {
						continue;
					}
					filterMemento = categoryMemento.createChild(FILTER_TAG);
					filterMemento.putString(REQUEST_TYPE_ATTR, filter.type);
				}
				filterMemento.putString(ENABLED_ATTR, String.valueOf(filter.enabled));
			}
		}
	}

	public void edit(Shell shell) {
		CheckedTreeSelectionDialog dialog = new CheckedTreeSelectionDialog(shell, new RequestFiltersLabelProvider(),
				new RequestFiltersContentProvider());
		dialog.setContainerMode(true);
		dialog.setInput(categories);
		//dialog.setExpandedElements(categories.toArray(new Category[categories.size()]));
		dialog.setInitialElementSelections(getEnabledRequestFilters());
		dialog.setSorter(new ViewerSorter());
		dialog.setTitle("Filtered Requests");
		dialog.setMessage("Select requests that should be filtered out:");
		if (dialog.open() == Window.OK) {
			setEnabledRequestFilters(dialog.getResult());
		}
	}

	private List<Filter> getEnabledRequestFilters() {
		List<Filter> filters = new ArrayList<Filter>();
		for (Category category : categories) {
			for (Filter filter : category.filters.values()) {
				if (filter.enabled) {
					filters.add(filter);
				}
			}
		}
		return filters;
	}

	private void setEnabledRequestFilters(Object[] selection) {
		for (Category category : categories) {
			for (Filter filter : category.filters.values()) {
				boolean enabled = false;
				for (Object selected : selection) {
					if (selected == filter) {
						enabled = true;
						break;
					}
				}
				filter.enabled = enabled;
			}
		}
	}

	protected Map<String, Filter> getRequestFilters(Class clazz) {
		Map<String, Filter> filters = new HashMap<String, Filter>();
		try {
			for (Field field : clazz.getDeclaredFields()) {
				if (Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())
						&& String.class.equals(field.getType()) && !field.isSynthetic()) {
					// possibly name should start with 'REQ_'
					String requestType = (String) field.get(null);
					if (requestType != null) {
						filters.put(requestType, new Filter(requestType, false));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filters;
	}

	private static class Filter {

		public Category category;
		public String type;
		public boolean enabled;

		public Filter(String type, boolean enabled) {
			this.type = type;
			this.enabled = enabled;
		}
	}

	private static class Category {

		public String name;
		private Map<String, Filter> filters; // request type -> filter

		public Category(String name, Map<String, Filter> filters) {
			this.name = name;
			this.filters = filters;
			for (Filter filter : filters.values()) {
				filter.category = this;
			}
		}
	}

	private static class RequestFiltersLabelProvider extends LabelProvider {

		public String getText(Object element) {
			if (element instanceof Filter) {
				return ((Filter) element).type;
			} else if (element instanceof Category) {
				return ((Category) element).name;
			}
			return super.getText(element);
		}
	}

	private class RequestFiltersContentProvider implements ITreeContentProvider {

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}

		public Object getParent(Object element) {
			if (element instanceof Filter) {
				return ((Filter) element).category;
			} else if (element instanceof Category) {
				return categories;
			}
			return null;
		}

		public boolean hasChildren(Object element) {
			if (element instanceof Category) {
				return !((Category) element).filters.isEmpty();
			} else if (element == categories) {
				return !categories.isEmpty();
			}
			return false;
		}

		public Object[] getChildren(Object parentElement) {
			if (parentElement instanceof Category) {
				Collection<Filter> filters = ((Category) parentElement).filters.values();
				return filters.toArray(new Filter[filters.size()]);
			} else if (parentElement == categories) {
				return categories.toArray(new Category[categories.size()]);
			}
			return NONE;
		}

		public Object[] getElements(Object inputElement) {
			return getChildren(inputElement);
		}

		public void dispose() {}
	}
}
