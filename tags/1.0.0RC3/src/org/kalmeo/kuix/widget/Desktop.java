/*
 * This file is part of org.kalmeo.kuix.
 * 
 * org.kalmeo.kuix is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * org.kalmeo.kuix is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with org.kalmeo.kuix.  If not, see <http://www.gnu.org/licenses/>.
 *  
 * Creation date : 21 nov. 2007
 * Copyright (c) Kalmeo 2007-2008. All rights reserved.
 * http://www.kalmeo.org
 */

package org.kalmeo.kuix.widget;

import java.util.Stack;

import javax.microedition.lcdui.Graphics;

import org.kalmeo.kuix.core.KuixCanvas;
import org.kalmeo.kuix.core.KuixConstants;
import org.kalmeo.kuix.core.focus.FocusManager;
import org.kalmeo.kuix.layout.GridLayout;
import org.kalmeo.kuix.layout.Layout;
import org.kalmeo.kuix.layout.LayoutData;
import org.kalmeo.kuix.layout.StaticLayout;
import org.kalmeo.kuix.layout.StaticLayoutData;
import org.kalmeo.kuix.transition.Transition;
import org.kalmeo.kuix.util.Insets;

/**
 * This class represent the Kuix desktop.
 * 
 * <table border="1" width="100%" cellpadding="3" cellspacing="0" >
 * 	<tr class="TableHeadingColor">
 * 		<th align="left" colspan="5"><font size="+2"> Attributes </font></th>
 * 	</tr>
 * 	<tr class="TableRowColor">
 * 		<th width="1%"> Attribute </th>
 * 		<th width="1%"> Object </th>
 * 		<th width="1%"> Set </th>
 * 		<th width="1%"> Get </th>
 * 		<th> Description </th>
 *	</tr>
 * 	<tr class="TableRowColor">
 * 		<td colspan="5"> Inherited attributes : see {@link Widget} </td>
 * 	</tr>
 * </table>
 * <br>
 * <table border="1" width="100%" cellpadding="3" cellspacing="0" >
 * 	<tr class="TableHeadingColor">
 * 		<th align="left" colspan="4"> <font size="+2"> Style properties </font> </th>
 * 	</tr>
 * 	<tr class="TableRowColor">
 * 		<th width="1%"> Property </th>
 * 		<th width="1%"> Default </th>
 * 		<th width="1%"> Inherit </th>
 * 		<th> Description </th>
 *	</tr>
 * 	<tr class="TableRowColor">
 * 		<td> <code>border</code> </th>
 * 		<td> <code>0 0 0 0</code> </td>
 * 		<td> <code>No</code> </td>
 * 		<td> <b>Uneditable</b>, see {@link Widget} </td>
 *	</tr>
 * 	<tr class="TableRowColor">
 * 		<td> <code>layout</code> </th>
 * 		<td> <code>gridlayout(1,1)</code> </td>
 * 		<td> <code>No</code> </td>
 * 		<td> <b>Uneditable</b>, see {@link Widget} </td>
 *	</tr>
 * 	<tr class="TableRowColor">
 * 		<td> <code>layout-data</code> </th>
 * 		<td> <code>null</code> </td>
 * 		<td> <code>No</code> </td>
 * 		<td> <b>Uneditable</b>, see {@link Widget} </td>
 *	</tr>
 * 	<tr class="TableRowColor">
 * 		<td> <code>margin</code> </th>
 * 		<td> <code>0 0 0 0</code> </td>
 * 		<td> <code>No</code> </td>
 * 		<td> <b>Uneditable</b>, see {@link Widget} </td>
 *	</tr>
 * 	<tr class="TableRowColor">
 * 		<td> <code>padding</code> </th>
 * 		<td> <code>0 0 0 0</code> </td>
 * 		<td> <code>No</code> </td>
 * 		<td> <b>Uneditable</b>, see {@link Widget} </td>
 *	</tr>
 * 	<tr class="TableRowColor">
 * 		<td colspan="4"> Inherited style properties : see {@link Widget} </td>
 * 	</tr>
 * </table>
 * <br>
 * <table border="1" width="100%" cellpadding="3" cellspacing="0" >
 * 	<tr class="TableHeadingColor">
 * 		<th align="left" colspan="2"> <font size="+2"> Available style pseudo-classes </font> </th>
 * 	</tr>
 * 	<tr class="TableRowColor">
 * 		<th width="1%"> Pseudo-class </th>
 * 		<th> Description </th>
 *	</tr>
 * 	<tr class="TableRowColor">
 * 		<td colspan="2"> Inherited style pseudo-classes : see {@link Widget} </td>
 * 	</tr>
 * </table>
 * <br>
 * <table border="1" width="100%" cellpadding="3" cellspacing="0" >
 * 	<tr class="TableHeadingColor">
 * 		<th align="left" colspan="2"> <font size="+2"> Available internal widgets </font> </th>
 * 	</tr>
 * 	<tr class="TableRowColor">
 * 		<th width="1%"> internal widget </th>
 * 		<th> Description </th>
 *	</tr>
 * 	<tr class="TableRowColor">
 * 		<td colspan="2"> Inherited internal widgets : see {@link Widget} </td>
 * 	</tr>
 * </table>
 * 
 * @author bbeaulant
 */
public class Desktop extends Widget {

	/**
	 * This class represent the popup content container
	 */
	private class PopupContainer extends Widget {
		
		/**
		 * Construct a {@link PopupContainer}
		 */
		public PopupContainer() {
			parent = Desktop.this;
		}

		/* (non-Javadoc)
		 * @see org.kalmeo.kuix.widget.Widget#getLayout()
		 */
		public Layout getLayout() {
			return StaticLayout.instance;
		}

		/* (non-Javadoc)
		 * @see org.kalmeo.kuix.widget.Widget#getDesktop()
		 */
		public Desktop getDesktop() {
			return Desktop.this;
		}
		
		/**
		 * Revalidate the PopupContainer
		 */
		public void revalidate() {
			super.doLayout();
		}

		/* (non-Javadoc)
		 * @see org.kalmeo.kuix.widget.Widget#onAdded(org.kalmeo.kuix.widget.Widget)
		 */
		protected void onChildAdded(Widget widget) {
			FocusManager focusManager = widget.getFocusManager();
			if (focusManager != null) {
				pushPopupFocusManager(focusManager);
			}
		}

		/* (non-Javadoc)
		 * @see org.kalmeo.kuix.widget.Widget#onRemoved(org.kalmeo.kuix.widget.Widget)
		 */
		protected void onChildRemoved(Widget widget) {
			FocusManager focusManager = widget.getFocusManager();
			if (focusManager != null) {
				removePopupFocusManager(focusManager);
			}
		}
		
	}
	
	/**
	 * This class represent the dragged widget container
	 */
	private class DraggedWidgetContainer extends Widget {

		private Widget draggedWidgetParent;
		
		/* (non-Javadoc)
		 * @see org.kalmeo.kuix.widget.Widget#getLayoutData()
		 */
		public LayoutData getLayoutData() {
			return layoutData;
		}
		
		/**
		 * @param widget
		 * @param x
		 * @param y
		 */
		protected void setDraggedWidget(Widget widget, int x, int y) {
			if (getChild() == null) {
				layoutData.x = x - widget.getWidth() / 2;
				layoutData.y = y - widget.getHeight() / 2;
				draggedWidgetParent = widget.parent;
				super.add(widget);
			}
		}
		
		/* (non-Javadoc)
		 * @see org.kalmeo.kuix.widget.Widget#add(org.kalmeo.kuix.widget.Widget)
		 */
		public Widget add(Widget widget) {
			return this;
		}
		
		/**
		 * @return the draggedWidgetParent
		 */
		public Widget getDraggedWidgetParent() {
			return draggedWidgetParent;
		}

		/* (non-Javadoc)
		 * @see org.kalmeo.kuix.widget.Widget#processPointerEvent(byte, int, int)
		 */
		public boolean processPointerEvent(byte type, int x, int y) {
			layoutData.x = x - getWidth() / 2;
			layoutData.y = y - getHeight() / 2;
			this.invalidate();
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.kalmeo.kuix.widget.Widget#onChildAdded(org.kalmeo.kuix.widget.Widget)
		 */
		protected void onChildAdded(Widget widget) {
			popupContainer.add(this);
		}

		/* (non-Javadoc)
		 * @see org.kalmeo.kuix.widget.Widget#onChildRemoved(org.kalmeo.kuix.widget.Widget)
		 */
		protected void onChildRemoved(Widget widget) {
			draggedWidgetParent = null;
			remove();
		}
		
	};
	
	// Instance of PopupMenu StaticLayoutData
	private final StaticLayoutData layoutData = new StaticLayoutData(null, -1, -1);
	
	// The associated KuixCanvas
	private final KuixCanvas canvas;

	// FocusManagers
	private final Stack popupFocusManagers;
	private FocusManager screenFocusManagers;
	
	// The content's widgets
	private final PopupContainer popupContainer;
	private Screen screen;
	
	// Drag
	private final DraggedWidgetContainer draggedWidgetContainer;
	
	/**
	 * Construct a {@link Desktop}
	 */
	public Desktop(KuixCanvas canvas) {
		super(KuixConstants.DESKTOP_WIDGET_TAG);
		this.canvas = canvas;
		
		// Init focusManagers
		popupFocusManagers = new Stack();
		screenFocusManagers = null;
		
		// Init content's widgets
		popupContainer = new PopupContainer();
		
		// Init dragged widget container
		draggedWidgetContainer = new DraggedWidgetContainer();
	}
	
	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#setBounds(int, int, int, int)
	 */
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		popupContainer.setBounds(x, y, width, height);
	}

	/**
	 * @return the canvas
	 */
	public KuixCanvas getCanvas() {
		return canvas;
	}
	
	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#isInWidgetTree()
	 */
	public boolean isInWidgetTree() {
		return true;
	}

	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#getDesktop()
	 */
	public Desktop getDesktop() {
		return this;
	}
	
	/**
	 * @return the screen
	 */
	public Screen getCurrentScreen() {
		return screen;
	}

	/**
	 * @param screen the screen to set
	 */
	public void setCurrentScreen(Screen screen) {
		if (this.screen == screen) {
			return;
		}
		if (this.screen != null) {
			this.screen.remove();
		}
		
		// Check transition
		Transition transition = screen.getTransition();
		if (transition != null && this.screen != null) {
			getCanvas().setTransition(transition);
		}
		
		this.screen = screen;
		if (screen != null) {
			super.add(screen);
		}
	}

	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#getWidget(java.lang.String)
	 */
	public Widget getWidget(String id) {
		Widget widget = super.getWidget(id);
		if (widget == null) {
			widget = popupContainer.getWidget(id);
		}
		return widget;
	}

	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#getFocusManager()
	 */
	public FocusManager getFocusManager() {
		return null;
	}
	
	/**
	 * @return the current focusManager
	 */
	public FocusManager getCurrentFocusManager() {
		if (popupFocusManagers.isEmpty()) {
			return screenFocusManagers;
		}
		return (FocusManager) popupFocusManagers.lastElement();
	}
	
	/**
	 * @param focusManager the popup focusManager to set
	 */
	public void pushPopupFocusManager(FocusManager focusManager) {
		if (focusManager != null) {
			if (!popupFocusManagers.contains(focusManager)) {
				popupFocusManagers.push(focusManager);
				// Select the first selectable if there is no focused widget
				if (focusManager.getFocusedWidget() == null) {
					focusManager.requestFirstFocus();
				}
			}
		}
	}
	
	/**
	 * Remove the specified popup focusManager
	 * 
	 * @param focusManager
	 */
	public void removePopupFocusManager(FocusManager focusManager) {
		popupFocusManagers.removeElement(focusManager);
	}
	
	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#getLayout()
	 */
	public Layout getLayout() {
		return GridLayout.instanceOneByOne;
	}

	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#getLayoutData()
	 */
	public LayoutData getLayoutData() {
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#getMargin()
	 */
	public Insets getMargin() {
		return DEFAULT_MARGIN;
	}

	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#getBorder()
	 */
	public Insets getBorder() {
		return DEFAULT_BORDER;
	}
 
	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#getPadding()
	 */
	public Insets getPadding() {
		return DEFAULT_PADDING;
	}
	
	/**
	 * Define the dragged widget.
	 * 
	 * @param widget
	 */
	public void setDraggedWidget(Widget widget, int x, int y) {
		if (widget != null) {
			draggedWidgetContainer.setDraggedWidget(widget, x, y);
		}
	}
	
	/**
	 * @return the dragged widget if it exists
	 */
	public Widget getDraggedWidget() {
		return draggedWidgetContainer.getChild();
	}
	
	/**
	 * Remove the dragged widget and returns its instance. If
	 * <code>restore</code> is <code>true</code> the dragged widget is
	 * restor to its original parent.
	 * 
	 * @param restore restore the dragged widget to its original parent
	 * @return the removed dragged widget
	 */
	public Widget removeDraggedWidget(boolean restore) {
		Widget draggedWidget = getDraggedWidget();
		Widget draggedWidgetParent = draggedWidgetContainer.getDraggedWidgetParent();
		if (restore && draggedWidgetParent != null) {
			draggedWidgetParent.add(draggedWidget);
		} else if (draggedWidget != null) {
			draggedWidget.remove();
		}
		return draggedWidget;
	}
	
	/**
	 * Add a popup widget
	 * 
	 * @param widget
	 * @param defaultFocusManager
	 */
	public void addPopup(Widget widget) {
		popupContainer.add(widget);
	}
	
	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#add(org.kalmeo.kuix.widget.Widget)
	 */
	public Widget add(Widget widget) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#removeAll()
	 */
	public void removeAll() {
		getCurrentFocusManager().reset();
		popupFocusManagers.removeAllElements();
		setCurrentScreen(null);
	}
	
	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#invalidate()
	 */
	public void invalidate() {
		super.invalidate();
		getCanvas().revalidateNextFrame();
	}

	/**
	 * Revalidate the Desktop
	 */
	public void revalidate() {
		doLayout();
	}
	
	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#doLayout()
	 */
	protected void doLayout() {
		super.doLayout();
		popupContainer.doLayout();
	}

	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#invalidateAppearanceRegion(int, int, int, int)
	 */
	protected void invalidateAppearanceRegion(int x, int y, int width, int height) {
		getCanvas().repaintNextFrame(x, y, width, height);
	}
	
	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#paintImpl(javax.microedition.lcdui.Graphics)
	 */
	public void paintImpl(Graphics g) {
		g.setColor(0xFFFFFF);
		g.fillRect(0, 0, getWidth(), getHeight());
		super.paintImpl(g);
		popupContainer.paintImpl(g);
	}

	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#paint(javax.microedition.lcdui.Graphics)
	 */
	public void paint(Graphics g) {
		paintBackground(g);
	}
	
	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#onAdded(org.kalmeo.kuix.widget.Widget)
	 */
	protected void onChildAdded(Widget widget) {
		FocusManager focusManager = widget.getFocusManager();
		if (focusManager != null) {
			screenFocusManagers = focusManager;
			// Select the first selectable if there is no focused widget
			if (focusManager.getFocusedWidget() == null) {
				focusManager.requestFirstFocus();
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.kalmeo.kuix.widget.Widget#onRemoved(org.kalmeo.kuix.widget.Widget)
	 */
	protected void onChildRemoved(Widget widget) {
		screenFocusManagers = null;
	}
	
}