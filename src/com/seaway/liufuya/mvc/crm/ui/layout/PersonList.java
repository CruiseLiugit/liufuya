package com.seaway.liufuya.mvc.crm.ui.layout;


import com.seaway.liufuya.mvc.crm.ui.CrmManageScreen;
import com.seaway.liufuya.mvc.crm.ui.data.PersonReferenceContainer;
import com.vaadin.ui.Component;
import com.vaadin.ui.Link;
import com.vaadin.ui.Table;

@SuppressWarnings("serial")
public class PersonList extends Table {
	
	/**
	 * 基本模拟时使用
	 */
	public PersonList() {
		// 创建一个默认的数据
		// 定义两列 Property
		 this.addContainerProperty("姓名", String.class, "李平");
		 this.addContainerProperty("年龄", String.class, "28");
		 //增加两行数据 Item
		 addItem();//数据为空
		 addItem();
		 this.setSizeFull();
	}

    public PersonList(CrmManageScreen app) {
        setSizeFull();
        //this.setHeight(230, Unit.PIXELS);
        setContainerDataSource(app.getDataSource());

        setVisibleColumns(PersonReferenceContainer.NATURAL_COL_ORDER);
        setColumnHeaders(PersonReferenceContainer.COL_HEADERS_CHINESE);

        setColumnCollapsingAllowed(true);
        setColumnReorderingAllowed(true);

        /*
         * Make table selectable, react immediatedly to user events, and pass
         * events to the controller (our main application)
         */
        setSelectable(true);
        setImmediate(true);
        this.addValueChangeListener((ValueChangeListener) app);
        /* We don't want to allow users to de-select a row */
        setNullSelectionAllowed(false);

        // customize email column to have mailto: links using column generator
        addGeneratedColumn("email", new ColumnGenerator() {

            public Component generateCell(Table source, Object itemId,
                    Object columnId) {
                String email = (String) getContainerProperty(itemId, "email").getValue();
                Link l = new Link();
//                l.setResource(new ExternalResource("mailto:" + email));
                l.setCaption(email);
                return l;
            }
        });
    }
}
