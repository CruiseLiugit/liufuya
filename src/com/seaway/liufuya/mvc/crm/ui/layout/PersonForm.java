package com.seaway.liufuya.mvc.crm.ui.layout;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.lang.reflect.Field;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.NotNull;
import com.seaway.liufuya.common.SelectBox;
import com.seaway.liufuya.mvc.crm.ui.CrmManageScreen;
import com.seaway.liufuya.mvc.crm.ui.data.Person;
import com.seaway.liufuya.mvc.crm.ui.data.PersonReference;
import com.seaway.liufuya.mvc.crm.ui.data.PersonReferenceContainer;
import com.seaway.liufuya.util.LunaException;
import com.seaway.liufuya.util.Utils;
import com.vaadin.data.Item;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CustomComponent;
//import com.vaadin.ui.Field;
//import com.vaadin.ui.Form;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

@SuppressWarnings("serial")
public class PersonForm extends CustomComponent implements ClickListener {
	private static final Log log = Logs.get();

	private Button save = new Button("保存", (ClickListener) this);
	private Button cancel = new Button("取消", (ClickListener) this);
	private Button edit = new Button("编辑", (ClickListener) this);
	private final ComboBox cities = new ComboBox("城市");
	private HorizontalLayout footer; // 底部

	private CrmManageScreen app;
	private boolean newContactMode = false; // 新建表单时，是否绑定数据
	private Person person = null; // 被绑定的数据

	// Member that will bind to the "name" property
	// TextField 对象名称与传递进来的 PropertyId 数据名称一致，就不用
	// @PropertyId("firstName")
	// 只有两者不一样的时候，才用 @PropertyId 进行统一
	TextField firstName = new TextField("姓氏");
	TextField lastName = new TextField("名称");
	TextField phoneNumber = new TextField("电话");
	TextField email = new TextField("邮箱");
	TextField streetAddress = new TextField("地址");
	TextField postalCode = new TextField("邮编");

	FormLayout layout = new FormLayout();

	// Now use a binder to bind the members
	FieldGroup binder = null;
	
	//为了美观，底部添加一个 TabSheet
	TabSheet tabsheet = new TabSheet();

	// 第一步看到的简单 Demo
	public PersonForm() {
		layout.setWidth(100, Unit.PERCENTAGE);
		layout.setSpacing(true);

		layout.addComponent(new TextField("First Name"));
		layout.addComponent(new TextField("Last Name"));

		HorizontalLayout footer = new HorizontalLayout();
		footer.setSpacing(true);
		footer.addComponent(save);
		footer.addComponent(cancel);
		layout.addComponent(footer);
		this.setCompositionRoot(layout);
	}

	public PersonForm(CrmManageScreen app) {
		this.app = app;

		/*
		 * Enable buffering so that commit() must be called for the form before
		 * input is written to the data. (Form input is not written immediately
		 * through to the underlying object.)
		 */
		// setWriteThrough(false);

		footer = new HorizontalLayout();
		footer.setSpacing(true);
		footer.addComponent(save);
		footer.addComponent(cancel);
		footer.addComponent(edit);
		footer.setVisible(false);

		// setFooter(footer);

		/* Allow the user to enter new cities */
		// 允许用户输入新的城市
		cities.setNewItemsAllowed(true);
		/* We do not want to use null values */
		// 不允许输入空值
		cities.setNullSelectionAllowed(false);
		/* Add an empty city used for selecting no city */
		cities.addItem("");

		/* Populate cities select using the cities in the data container */
		PersonReferenceContainer ds = app.getDataSource();
		for (PersonReference pf : ds.getItems()) {
			String city = (String) pf.getItemProperty("city").getValue();
			cities.addItem(city);
		}

		////////////////////////////////////////////////
		// 输入校验
		firstName.setNullRepresentation(""); // 为空是替换为""
		firstName.setRequired(true); // 必填项
		email.addValidator(new EmailValidator("请输入正确的邮箱地址，如xxx@163.com"));
		email.setRequired(true);
		// 正则表达式验证
		postalCode
				.addValidator(new RegexpValidator("[1-9][0-9]{4}", "请输入6位数字"));
		postalCode.setRequired(true);
		streetAddress.setWidth(400, Unit.PIXELS);

		// 往 FormLayout 中添加组件
		layout.setWidth(100, Unit.PERCENTAGE);
		layout.setSpacing(true);
		layout.addComponent(firstName);
		layout.addComponent(lastName);
		layout.addComponent(phoneNumber);
		layout.addComponent(email);
		layout.addComponent(cities);
		layout.addComponent(postalCode);
		layout.addComponent(streetAddress);
		layout.addComponent(cities);

		// 默认不显示表单
		layout.setVisible(false);
		
		//默认显示图标
		tabsheet.addTab(layout, "会员管理",new ThemeResource("icons/16/user-normal.png"));
		this.setCompositionRoot(tabsheet);
	}

	public void buttonClick(ClickEvent event) {
		Button source = event.getButton();

		if (source == save) {
			/* If the given input is not valid there is no point in continuing */
			if (!this.binder.isValid()) {
				log.info("保存时，没有通过验证");
				Notification.show("带 * 字段不能为空，请填写完成再提交");
				return;
			}
			try {
				log.info("保存时，通过验证，提交.....");
				this.binder.commit();
				footer.setVisible(false); // 隐藏掉底部按钮布局
				// 新增
				log.info("保存，更新数据库数据，更新 app 中的数据源");
				person = app.getPersonManager().savePerson(person);
				setItemDataSource(new BeanItem(person));
				newContactMode = false;
				app.getDataSource().refresh();

			} catch (CommitException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			setReadOnly(true);
		} else if (source == cancel) {
			if (newContactMode) {
				newContactMode = false;
				/* Clear the form and make it invisible */
				setItemDataSource(null);
			} else {
				binder.discard();
			}
			setReadOnly(true);
		} else if (source == edit) {
			setReadOnly(false);
		}
	}

	// @Override
	public void setItemDataSource(Item newDataSource) {
		newContactMode = false;
		log.info(">>>>>>>>>>>>>>> setItemDataSource()  newDataSource ="+newDataSource);  
		if (newDataSource != null) {
			//手动控制  Field 字段的生成顺序
			//List<Object> orderedProperties = Arrays.asList(PersonReferenceContainer.NATURAL_COL_ORDER);
			// super.setItemDataSource(newDataSource, orderedProperties);
			// Now create a binder that can also create the fields
			// using the default field factory
			binder = new FieldGroup(newDataSource);
			// 增加默认字段，动态生成
			// Utils.buildAndBindFieldGroup(binder, Person.class, layout);
			// layout.addComponent(cities); //城市字段，单独添加

			// Buffer the form content
			binder.setBuffered(true);

			// 只绑定
			binder.bind(firstName, "firstName");
			binder.bind(lastName, "lastName");
			binder.bind(phoneNumber, "phoneNumber");
			binder.bind(email, "email");
			binder.bind(postalCode, "postalCode");
			binder.bind(streetAddress, "streetAddress");
			
			// 创建
			// layout.addComponent(binder.buildAndBind("姓氏", "firstName"));
			// layout.addComponent(binder.buildAndBind("名称", "lastName"));
			// layout.addComponent(binder.buildAndBind("电话", "phoneNumber"));
			// layout.addComponent(binder.buildAndBind("邮箱", "email"));
			// //layout.addComponent(binder.buildAndBind("城市", "city"));
			// layout.addComponent(city);
			// layout.addComponent(binder.buildAndBind("邮编", "postalCode"));
			// layout.addComponent(binder.buildAndBind("地址", "streetAddress"));

			layout.setVisible(true);       //控制表单显示
			layout.addComponent(footer);
			footer.setVisible(true);
			//tabsheet.addTab(layout, "会员管理",new ThemeResource("icons/16/user-edit.png"));
			// 默认不显示表单
			//this.setCompositionRoot(tabsheet);
		} else {
			//新增会员时，点击  <取消> 按钮，隐藏表单
			layout.setVisible(false);     //控制表单隐藏
			Tab tab = tabsheet.getTab(layout);
			tab.setIcon(new ThemeResource("icons/16/user-block.png"));
			
			//tabsheet.addTab(layout, "会员管理",new ThemeResource("icons/16/user-block.png"));
			// 默认不显示表单
			//this.setCompositionRoot(tabsheet);
		}
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		//super.setReadOnly(readOnly);
		//设置文本框为不可编辑模式
		//@see com.vaadin.ui.Component#setReadOnly(boolean)
		if (layout!= null && binder != null) {
			Collection<Object> propertyIds = binder.getBoundPropertyIds();
			for (Iterator iterator = propertyIds.iterator(); iterator.hasNext();) {
				String propertyId = (String) iterator.next();
				com.vaadin.ui.Field fid = binder.getField(propertyId);
				if (fid instanceof TextField) {
					//变成不可编辑状态
					fid.setReadOnly(readOnly);
				}
			}
		}
		save.setVisible(!readOnly);
		cancel.setVisible(!readOnly);
		edit.setVisible(readOnly);
	}

	public void addContact() {
		log.info("点击    增加   按钮...........");
		person = new Person();
		
		Tab tab = tabsheet.getTab(layout);
		tab.setIcon(new ThemeResource("icons/16/user.png"));
		
		setItemDataSource(new BeanItem(person));
		newContactMode = true;
		setReadOnly(false);
	}

	/**
	 * 表格选中某一行后，跳转过来到这里编辑
	 * 
	 * @param person
	 */
	public void editContact(Person person) {
		log.info("点击    编辑   按钮...........");
		this.person = person;
		
		Tab tab = tabsheet.getTab(layout);
		tab.setIcon(new ThemeResource("icons/16/user-edit.png"));
		
		// 根据穿过来的 Bean 对象，创建表格输入框
		setItemDataSource(new BeanItem(person));
		newContactMode = false;
		setReadOnly(true);
	}
}
