package com.seaway.liufuya.mvc.crm.ui.layout;

import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

@SuppressWarnings("serial")
public class HelpWindow extends Window {

    private static final String HELP_HTML_SNIPPET = "帮助窗口，这里是帮助页面.";

    public HelpWindow() {
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

        setCaption("系统使用帮助");
        this.setContent(new Label(HELP_HTML_SNIPPET));
        
		Button close = new Button("关闭");
		close.addClickListener(new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				// 关闭窗口
				HelpWindow.this.close();
			}
		});

		setContent(close);
    }
}
