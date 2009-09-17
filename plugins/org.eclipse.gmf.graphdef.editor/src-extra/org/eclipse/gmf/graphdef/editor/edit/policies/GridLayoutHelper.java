/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.edit.policies;

import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.graphdef.editor.edit.parts.AbstractFigureEditPart;
import org.eclipse.swt.SWT;

public class GridLayoutHelper {

	private GridLayout myGridLayout;

	private int myColumnCount;

	private int myRowCount;

	private int[] myWidths;

	private int[] myHeights;

	private IFigure[][] myGrid;

	private List<IFigure> myChildren;

	public GridLayoutHelper(AbstractFigureEditPart host) {
		IFigure contentPane = host.getContentPane();
		LayoutManager layout = contentPane.getLayoutManager();
		assert layout instanceof GridLayout;
		myGridLayout = (GridLayout) layout;
		myColumnCount = myGridLayout.numColumns;
		myChildren = contentPane.getChildren();
		myGrid = buildGrid(contentPane.getChildren());
		myWidths = getColumnWidths(contentPane.getBounds().width);
		myHeights = getRowHeights(contentPane.getBounds().height);

	}
	
	public IFigure[][] getGrid() {
		return myGrid;
	}
	
	public int[] getWidths() {
		return myWidths;
	}
	
	public int[] getHeights() {
		return myHeights;
	}
	
	public GridLayout getGridLayout() {
		return myGridLayout;
	}
	
	public int getNewChildPosition(Point where) {
		int xIndex = getIndex(myWidths, where.x);
		int yIndex = getIndex(myHeights, where.y);
		if (xIndex == myWidths.length || yIndex == myHeights.length) {
			return myChildren.size() - 1;
		} else {
			if (myGrid[yIndex][xIndex] == null) {
				// do not know what to show in null cells
				return -1;
			}
			return myChildren.indexOf(myGrid[yIndex][xIndex]);
		}
	}
	
	public Rectangle getFeedbackBounds(Point where, IFigure childFigure) {
		int xIndex = getIndex(myWidths, where.x);
		int yIndex = getIndex(myHeights, where.y);
		GridData gridData = (GridData) myGridLayout.getConstraint(childFigure);
		if (xIndex == myWidths.length || yIndex == myHeights.length) {
			if (myChildren.size() == 0) {
				xIndex = 0;
				yIndex = 0;
			} else {
				IFigure lastFigure = myChildren.get(myChildren.size() - 1);
				int column = myColumnCount - 1;
				int row = myHeights.length - 1;
				boolean figureFound = false;
				for (; !figureFound && row >= 0; ) {
					column = myColumnCount - 1;
					for (; !figureFound && column >= 0;) {
						if (myGrid[row][column] == lastFigure) {
							figureFound = true;
						} else {
							column--;
						}
					}
					if (!figureFound) {
						row--;
					}
				}
				if (!figureFound) {
					// should not be here
					return null;
				}
				for (; row > 0 && myGrid[row][column] == myGrid[row - 1][column]; row--) {
				}
				
				int hSpan = Math.max(1, Math.min(gridData.horizontalSpan, myColumnCount));
				while (row < myHeights.length) {
					while (column < myColumnCount && myGrid[row][column] != null) {
						column++;
					}
					int endCount = column + hSpan;
					if (endCount <= myColumnCount) {
						int index = column;
						while (index < endCount && myGrid[row][index] == null) {
							index++;
						}
						if (index == endCount)
							break;
						column = index;
					}
					if (column + hSpan >= myColumnCount) {
						column = 0;
						row++;
					}
				}
				xIndex = column;
				yIndex = row;
			}
		} else {
			if (myGrid[yIndex][xIndex] == null) {
				// do not know what to show in null cells
				return null;
			}
			for (; xIndex > 0 && myGrid[yIndex][xIndex] == myGrid[yIndex][xIndex - 1]; xIndex--) {
			}
			for (; yIndex > 0 && myGrid[yIndex][xIndex] == myGrid[yIndex - 1][xIndex]; yIndex--) {
			}
		}

		int xPosition = 0;
		for (int i = 0; i < xIndex; i++) {
			xPosition += myWidths[i];
		}
		int yPosition = 0;
		for (int i = 0; i < yIndex; i++) {
			yPosition += myHeights[i];
		}
		int width = myWidths[xIndex];
		int height = myHeights[yIndex];
		if (childFigure != null) {
			if (xIndex + gridData.horizontalSpan > myWidths.length) {
				width = childFigure.getBounds().width;
			} else {
				for (int i = xIndex + 1; i < xIndex + gridData.horizontalSpan; i++) {
					width += myWidths[i];
				}
			}
			if (yIndex + gridData.verticalAlignment > myHeights.length) {
				height = childFigure.getBounds().height;
			} else {
				for (int i = yIndex + 1; i < yIndex + gridData.verticalSpan; i++) {
					height += myHeights[i];
				}
			}
		}

		return new Rectangle(xPosition, yPosition, width, height);
	}

	/**
	 * @return index of current coordinate in the array of cell sizes or
	 *         cellSizes.length in case we are outside of this array.
	 */
	private int getIndex(int[] cellSizes, int coordinate) {
		int position = 0;
		for (int i = 0; i < cellSizes.length; i++) {
			if (position <= coordinate && coordinate < cellSizes[i] + position) {
				return i;
			}
			position += cellSizes[i];
		}
		return cellSizes.length;
	}

	private IFigure[][] buildGrid(List children) {
		myRowCount = 0;
		int row = 0, column = 0;
		IFigure[][] grid = new IFigure[4][myColumnCount];
		for (int i = 0; i < children.size(); i++) {
			IFigure child = (IFigure) children.get(i);
			GridData data = (GridData) myGridLayout.getConstraint(child);
			int hSpan = Math.max(1, Math.min(data.horizontalSpan, myColumnCount));
			int vSpan = Math.max(1, data.verticalSpan);
			while (true) {
				int lastRow = row + vSpan;
				if (lastRow >= grid.length) {
					IFigure[][] newGrid = new IFigure[lastRow + 4][myColumnCount];
					System.arraycopy(grid, 0, newGrid, 0, grid.length);
					grid = newGrid;
				}
				if (grid[row] == null) {
					grid[row] = new IFigure[myColumnCount];
				}
				while (column < myColumnCount && grid[row][column] != null) {
					column++;
				}
				int endCount = column + hSpan;
				if (endCount <= myColumnCount) {
					int index = column;
					while (index < endCount && grid[row][index] == null) {
						index++;
					}
					if (index == endCount)
						break;
					column = index;
				}
				if (column + hSpan >= myColumnCount) {
					column = 0;
					row++;
				}
			}
			for (int j = 0; j < vSpan; j++) {
				if (grid[row + j] == null) {
					grid[row + j] = new IFigure[myColumnCount];
				}
				for (int k = 0; k < hSpan; k++) {
					grid[row + j][column + k] = child;
				}
			}
			myRowCount = Math.max(myRowCount, row + vSpan);
			column += hSpan;
		}
		return grid;
	}

	private int[] getColumnWidths(int width) {
		int availableWidth = width - myGridLayout.horizontalSpacing * (myColumnCount - 1) - myGridLayout.marginWidth * 2;
		int expandCount = 0;
		int[] widths = new int[myColumnCount];
		int[] minWidths = new int[myColumnCount];
		boolean[] expandColumn = new boolean[myColumnCount];
		for (int j = 0; j < myColumnCount; j++) {
			for (int i = 0; i < myRowCount; i++) {
				GridData data = getData(myGrid, i, j, myRowCount, myColumnCount, true);
				if (data != null) {
					int hSpan = Math.max(1, Math.min(data.horizontalSpan, myColumnCount));
					if (hSpan == 1) {
						int cacheWidth = getCacheWidth(myGrid, i, j, data);
						int w = cacheWidth + data.horizontalIndent;
						widths[j] = Math.max(widths[j], w);
						if (data.grabExcessHorizontalSpace) {
							if (!expandColumn[j])
								expandCount++;
							expandColumn[j] = true;
						}
						if (data.widthHint != SWT.DEFAULT || !data.grabExcessHorizontalSpace) {
							minWidths[j] = Math.max(minWidths[j], w);
						}
					}
				}
			}
			for (int i = 0; i < myRowCount; i++) {
				GridData data = getData(myGrid, i, j, myRowCount, myColumnCount, false);
				if (data != null) {
					int hSpan = Math.max(1, Math.min(data.horizontalSpan, myColumnCount));
					if (hSpan > 1) {
						int spanWidth = 0, spanMinWidth = 0, spanExpandCount = 0;
						for (int k = 0; k < hSpan; k++) {
							spanWidth += widths[j - k];
							spanMinWidth += minWidths[j - k];
							if (expandColumn[j - k])
								spanExpandCount++;
						}
						if (data.grabExcessHorizontalSpace && spanExpandCount == 0) {
							expandCount++;
							expandColumn[j] = true;
						}
						int cacheWidth = getCacheWidth(myGrid, i, j, data);
						int w = cacheWidth + data.horizontalIndent - spanWidth - (hSpan - 1) * myGridLayout.horizontalSpacing;
						if (w > 0) {
							if (spanExpandCount == 0) {
								widths[j] += w;
							} else {
								int delta = w / spanExpandCount;
								int remainder = w % spanExpandCount, last = -1;
								for (int k = 0; k < hSpan; k++) {
									if (expandColumn[j - k]) {
										widths[last = j - k] += delta;
									}
								}
								if (last > -1)
									widths[last] += remainder;
							}
						}
						if (data.widthHint != SWT.DEFAULT || !data.grabExcessHorizontalSpace) {
							w = cacheWidth + data.horizontalIndent - spanMinWidth - (hSpan - 1) * myGridLayout.horizontalSpacing;
							if (w > 0) {
								if (spanExpandCount == 0) {
									minWidths[j] += w;
								} else {
									int delta = w / spanExpandCount;
									int remainder = w % spanExpandCount, last = -1;
									for (int k = 0; k < hSpan; k++) {
										if (expandColumn[j - k]) {
											minWidths[last = j - k] += delta;
										}
									}
									if (last > -1)
										minWidths[last] += remainder;
								}
							}
						}
					}
				}
			}
		}
		if (myGridLayout.makeColumnsEqualWidth) {
			int minColumnWidth = 0;
			int columnWidth = 0;
			for (int i = 0; i < myColumnCount; i++) {
				minColumnWidth = Math.max(minColumnWidth, minWidths[i]);
				columnWidth = Math.max(columnWidth, widths[i]);
			}
			columnWidth = width == SWT.DEFAULT || expandCount == 0 ? columnWidth : Math.max(minColumnWidth, availableWidth / myColumnCount);
			for (int i = 0; i < myColumnCount; i++) {
				expandColumn[i] = expandCount > 0;
				widths[i] = columnWidth;
			}
		} else {
			if (width != SWT.DEFAULT && expandCount > 0) {
				int totalWidth = 0;
				for (int i = 0; i < myColumnCount; i++) {
					totalWidth += widths[i];
				}
				int count = expandCount;
				int delta = (availableWidth - totalWidth) / count;
				int remainder = (availableWidth - totalWidth) % count;
				int last = -1;
				while (totalWidth != availableWidth) {
					for (int j = 0; j < myColumnCount; j++) {
						if (expandColumn[j]) {
							if (widths[j] + delta > minWidths[j]) {
								widths[last = j] = widths[j] + delta;
							} else {
								widths[j] = minWidths[j];
								expandColumn[j] = false;
								count--;
							}
						}
					}
					if (last > -1)
						widths[last] += remainder;

					for (int j = 0; j < myColumnCount; j++) {
						for (int i = 0; i < myRowCount; i++) {
							GridData data = getData(myGrid, i, j, myRowCount, myColumnCount, false);
							if (data != null) {
								int hSpan = Math.max(1, Math.min(data.horizontalSpan, myColumnCount));
								if (hSpan > 1) {
									if (data.widthHint != SWT.DEFAULT || !data.grabExcessHorizontalSpace) {
										int spanWidth = 0, spanExpandCount = 0;
										for (int k = 0; k < hSpan; k++) {
											spanWidth += widths[j - k];
											if (expandColumn[j - k])
												spanExpandCount++;
										}
										int cacheWidth = getCacheWidth(myGrid, i, j, data);
										int w = cacheWidth + data.horizontalIndent - spanWidth - (hSpan - 1) * myGridLayout.horizontalSpacing;
										if (w > 0) {
											if (spanExpandCount == 0) {
												widths[j] += w;
											} else {
												int delta2 = w / spanExpandCount;
												int remainder2 = w % spanExpandCount, last2 = -1;
												for (int k = 0; k < hSpan; k++) {
													if (expandColumn[j - k]) {
														widths[last2 = j - k] += delta2;
													}
												}
												if (last2 > -1)
													widths[last2] += remainder2;
											}
										}
									}
								}
							}
						}
					}
					if (count == 0)
						break;
					totalWidth = 0;
					for (int i = 0; i < myColumnCount; i++) {
						totalWidth += widths[i];
					}
					delta = (availableWidth - totalWidth) / count;
					remainder = (availableWidth - totalWidth) % count;
					last = -1;
				}
			}
		}
		return widths;
	}

	private int[] getRowHeights(int height) {
		int availableHeight = height - myGridLayout.verticalSpacing * (myRowCount - 1) - myGridLayout.marginHeight * 2;
		int expandCount = 0;
		int[] heights = new int[myRowCount];
		int[] minHeights = new int[myRowCount];
		boolean[] expandRow = new boolean[myRowCount];
		for (int i = 0; i < myRowCount; i++) {
			for (int j = 0; j < myColumnCount; j++) {
				GridData data = getData(myGrid, i, j, myRowCount, myColumnCount, true);
				if (data != null) {
					int vSpan = Math.max(1, Math.min(data.verticalSpan, myRowCount));
					if (vSpan == 1) {
						int h = getCacheHeight(myGrid, i, j, data); // +
						// data.verticalIndent;
						heights[i] = Math.max(heights[i], h);
						if (data.grabExcessVerticalSpace) {
							if (!expandRow[i])
								expandCount++;
							expandRow[i] = true;
						}
						if (data.heightHint != SWT.DEFAULT || !data.grabExcessVerticalSpace) {
							minHeights[i] = Math.max(minHeights[i], h);
						}
					}
				}
			}
			for (int j = 0; j < myColumnCount; j++) {
				GridData data = getData(myGrid, i, j, myRowCount, myColumnCount, false);
				if (data != null) {
					int vSpan = Math.max(1, Math.min(data.verticalSpan, myRowCount));
					if (vSpan > 1) {
						int spanHeight = 0, spanMinHeight = 0, spanExpandCount = 0;
						for (int k = 0; k < vSpan; k++) {
							spanHeight += heights[i - k];
							spanMinHeight += minHeights[i - k];
							if (expandRow[i - k])
								spanExpandCount++;
						}
						if (data.grabExcessVerticalSpace && spanExpandCount == 0) {
							expandCount++;
							expandRow[i] = true;
						}
						int cacheHeight = getCacheHeight(myGrid, i, j, data);
						int h = cacheHeight - spanHeight - (vSpan - 1) * myGridLayout.verticalSpacing; // +
						// data.verticalalIndent
						if (h > 0) {
							if (spanExpandCount == 0) {
								heights[i] += h;
							} else {
								int delta = h / spanExpandCount;
								int remainder = h % spanExpandCount, last = -1;
								for (int k = 0; k < vSpan; k++) {
									if (expandRow[i - k]) {
										heights[last = i - k] += delta;
									}
								}
								if (last > -1)
									heights[last] += remainder;
							}
						}
						if (data.heightHint != SWT.DEFAULT || !data.grabExcessVerticalSpace) {
							h = cacheHeight - spanMinHeight - (vSpan - 1) * myGridLayout.verticalSpacing; // +
							// data.verticalIndent
							if (h > 0) {
								if (spanExpandCount == 0) {
									minHeights[i] += h;
								} else {
									int delta = h / spanExpandCount;
									int remainder = h % spanExpandCount, last = -1;
									for (int k = 0; k < vSpan; k++) {
										if (expandRow[i - k]) {
											minHeights[last = i - k] += delta;
										}
									}
									if (last > -1)
										minHeights[last] += remainder;
								}
							}
						}
					}
				}
			}
		}
		if (height != SWT.DEFAULT && expandCount > 0) {
			int totalHeight = 0;
			for (int i = 0; i < myRowCount; i++) {
				totalHeight += heights[i];
			}
			int count = expandCount;
			int delta = (availableHeight - totalHeight) / count;
			int remainder = (availableHeight - totalHeight) % count;
			int last = -1;
			while (totalHeight != availableHeight) {
				for (int i = 0; i < myRowCount; i++) {
					if (expandRow[i]) {
						if (heights[i] + delta > minHeights[i]) {
							heights[last = i] = heights[i] + delta;
						} else {
							heights[i] = minHeights[i];
							expandRow[i] = false;
							count--;
						}
					}
				}
				if (last > -1)
					heights[last] += remainder;

				for (int i = 0; i < myRowCount; i++) {
					for (int j = 0; j < myColumnCount; j++) {
						GridData data = getData(myGrid, i, j, myRowCount, myColumnCount, false);
						if (data != null) {
							int vSpan = Math.max(1, Math.min(data.verticalSpan, myRowCount));
							if (vSpan > 1) {
								if (data.heightHint != SWT.DEFAULT || !data.grabExcessVerticalSpace) {
									int spanHeight = 0, spanExpandCount = 0;
									for (int k = 0; k < vSpan; k++) {
										spanHeight += heights[i - k];
										if (expandRow[i - k])
											spanExpandCount++;
									}
									int cacheHeight = getCacheHeight(myGrid, i, j, data);
									int h = cacheHeight - spanHeight - (vSpan - 1) * myGridLayout.verticalSpacing; // +
									// data.verticalIndent
									if (h > 0) {
										if (spanExpandCount == 0) {
											heights[i] += h;
										} else {
											int delta2 = h / spanExpandCount;
											int remainder2 = h % spanExpandCount, last2 = -1;
											for (int k = 0; k < vSpan; k++) {
												if (expandRow[i - k]) {
													heights[last2 = i - k] += delta2;
												}
											}
											if (last2 > -1)
												heights[last2] += remainder2;
										}
									}
								}
							}
						}
					}
				}
				if (count == 0)
					break;
				totalHeight = 0;
				for (int i = 0; i < myRowCount; i++) {
					totalHeight += heights[i];
				}
				delta = (availableHeight - totalHeight) / count;
				remainder = (availableHeight - totalHeight) % count;
				last = -1;
			}
		}
		return heights;
	}

	private GridData getData(IFigure[][] grid, int row, int column, int rowCount, int columnCount, boolean first) {
		IFigure figure = grid[row][column];
		if (figure != null) {
			GridData data = (GridData) myGridLayout.getConstraint(figure);
			int hSpan = Math.max(1, Math.min(data.horizontalSpan, columnCount));
			int vSpan = Math.max(1, data.verticalSpan);
			int i = first ? row + vSpan - 1 : row - vSpan + 1;
			int j = first ? column + hSpan - 1 : column - hSpan + 1;
			if (0 <= i && i < rowCount) {
				if (0 <= j && j < columnCount) {
					if (figure == grid[i][j])
						return data;
				}
			}
		}
		return null;
	}

	private int getCacheHeight(IFigure[][] grid, int row, int column, GridData data) {
		return grid[row][column].getPreferredSize(data.widthHint, data.heightHint).height;
	}

	private int getCacheWidth(IFigure[][] grid, int row, int column, GridData data) {
		return grid[row][column].getPreferredSize(data.widthHint, data.heightHint).width;
	}

}
