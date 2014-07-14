package com.seaway.liufuya.mvc.crm.ui.layout;

import com.seaway.liufuya.mvc.crm.ui.CrmManageScreen;
import com.vaadin.event.FieldEvents.FocusEvent;
import com.vaadin.event.FieldEvents.FocusListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class SearchView extends Panel {

	private TextField tf;
	private NativeSelect fieldToSearch;
	private CheckBox saveSearch;
	private TextField searchName;
	private CrmManageScreen app;

	public SearchView(final CrmManageScreen app) {
		this.app = app;
		addStyleName("view");

		setCaption("Search contacts");
		setSizeFull();

		/* Use a FormLayout as main layout for this Panel */
		FormLayout formLayout = new FormLayout();
		setContent(formLayout);

		/* Create UI components */
		tf = new TextField("Search term");
		fieldToSearch = new NativeSelect("Field to search");
		saveSearch = new CheckBox("Save search");
		searchName = new TextField("Search name");
		Button search = new Button("Search");

		/* Initialize fieldToSearch */
		// for (int i = 0; i <
		// PersonReferenceContainer.NATURAL_COL_ORDER.length; i++) {
		// fieldToSearch.addItem(PersonReferenceContainer.NATURAL_COL_ORDER[i]);
		// fieldToSearch.setItemCaption(PersonReferenceContainer.NATURAL_COL_ORDER[i],
		// PersonReferenceContainer.COL_HEADERS_ENGLISH[i]);
		// }

		fieldToSearch.setValue("lastName");
		fieldToSearch.setNullSelectionAllowed(false);

		/* Initialize save checkbox */
		saveSearch.setValue(true);
		saveSearch.setImmediate(true);
		// CheckBox 事件监听处理
		saveSearch.addFocusListener(new FocusListener() {
			@Override
			public void focus(FocusEvent event) {
				// searchName.setVisible(event.getButton().booleanValue());
				searchName.setVisible(((CheckBox) event.getComponent())
						.getValue());
			}
		});

		search.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				performSearch();
			}
		});

		/* Add all the created components to the form */
		formLayout.addComponent(tf);
		formLayout.addComponent(fieldToSearch);
		formLayout.addComponent(saveSearch);
		formLayout.addComponent(searchName);
		formLayout.addComponent(search);
	}

	private void performSearch() {
		String searchTerm = (String) tf.getValue();
		if (searchTerm == null || searchTerm.equals("")) {
			Notification.show("Search term cannot be empty!");
			return;
		}

//		SearchFilter searchFilter = new SearchFilter(fieldToSearch.getValue(),
//				searchTerm, (String) searchName.getValue());
//		if (saveSearch.booleanValue()) {
//			if (searchName.getValue() == null
//					|| searchName.getValue().equals("")) {
//				getWindow().showNotification(
//						"Please enter a name for your search!",
//						Notification.TYPE_WARNING_MESSAGE);
//				return;
//			}
//			app.saveSearch(searchFilter);
//		}
//		app.search(searchFilter);
	}
}
