package com.seaway.liufuya.mvc.crm.ui.layout;

import com.seaway.liufuya.mvc.crm.ui.CrmManageScreen;
import com.seaway.liufuya.mvc.report.ui.ReportScreen;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Tree;

@SuppressWarnings("serial")
public class NavigationTree extends Tree {
	
	public NavigationTree(CrmManageScreen app, Object[][] items) {
		// Add items as root items in the tree.
		for (int i = 0; i < items.length; i++) {
			String planet = (String) (items[i][0]);
			this.addItem(planet);

			if (items[i].length == 1) {
				// The planet has no moons so make it a leaf.
				this.setChildrenAllowed(planet, false);
			} else {
				// Add children (moons) under the items.
				for (int j = 1; j < items[i].length; j++) {
					String moon = (String) items[i][j];
					// Add the item as a regular item.
					this.addItem(moon);
					// Set it to be a child.
					this.setParent(moon, planet);
					// Make the moons look like leaves.
					this.setChildrenAllowed(moon, false);
				}

			}

			// Expand the subtree.
			this.expandItemsRecursively(planet);
		}

		
		/*
		 * We want items to be selectable but do not want the user to be able to
		 * de-select an item.
		 */
		setSelectable(true);
		setNullSelectionAllowed(false);

		// Make application handle item click events
		this.addItemClickListener((ItemClickListener) app);
	}

	public NavigationTree(ReportScreen reportScreen, Object[][] items) {
		// Add items as root items in the tree.
				for (int i = 0; i < items.length; i++) {
					String planet = (String) (items[i][0]);
					this.addItem(planet);

					if (items[i].length == 1) {
						// The planet has no moons so make it a leaf.
						this.setChildrenAllowed(planet, false);
					} else {
						// Add children (moons) under the items.
						for (int j = 1; j < items[i].length; j++) {
							String moon = (String) items[i][j];
							// Add the item as a regular item.
							this.addItem(moon);
							// Set it to be a child.
							this.setParent(moon, planet);
							// Make the moons look like leaves.
							this.setChildrenAllowed(moon, false);
						}

					}

					// Expand the subtree.
					this.expandItemsRecursively(planet);
				}

				
				/*
				 * We want items to be selectable but do not want the user to be able to
				 * de-select an item.
				 */
				setSelectable(true);
				setNullSelectionAllowed(false);
				// Make application handle item click events
				this.addItemClickListener((ItemClickListener) reportScreen);
	}
}
