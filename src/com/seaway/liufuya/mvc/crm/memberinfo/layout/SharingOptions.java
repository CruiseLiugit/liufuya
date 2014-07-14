package com.seaway.liufuya.mvc.crm.memberinfo.layout;

import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class SharingOptions extends Window {

    public SharingOptions() {
        /*
         * Make the window modal, which will disable all other components while
         * it is visible
         */
        setModal(true);

        /* Make the sub window 50% the size of the browser window */
        setWidth("50%");
        /*
         * Center the window both horizontally and vertically in the browser
         * window
         */
        center();

        setCaption("当前用户信息");
		setContent(new Label("用户名:刘立立"));
		
		setContent(new CheckBox(".Mac"));

		
		Button close = new Button("关闭");
		close.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// 关闭窗口
				SharingOptions.this.close();
			}
		});

		setContent(close);
    }
}
