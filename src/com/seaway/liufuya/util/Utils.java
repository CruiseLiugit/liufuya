package com.seaway.liufuya.util;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.nutz.log.Log;
import org.nutz.log.Logs;

import com.seaway.liufuya.common.NotNull;
import com.seaway.liufuya.common.SelectBox;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.Caption;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.event.FieldEvents.FocusEvent;
import com.vaadin.event.FieldEvents.FocusListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;

public class Utils {
	private static final Log log = Logs.get();
	
	//-----------------------表单相关-----------------------------------------
	/**
	 * 为指定{@link BeanFieldGroup}绑定字段。同时生成UI Field并添加到 layout 中。</p>
	 * 如果fieldNames为null, 则beanClass中有{@link Caption}注解的字段被绑定 ，否则按fieldNames指定字段绑定。 </p>
	 * 最终UI上显示的caption根据{@link Caption}注解生成
	 * 该方法只负责确定生成哪些字段，生成Caption。创建字段工作最终调用{@link EntityFieldGroupFieldFactory}完成
	 * @param fieldGroup 
	 * @param beanClass 要绑定到{@link BeanFieldGroup}上的beanClass
	 * @param layout 目标UI
	 * @param fieldNames 指定的字段必须在beanClass中存在，否则抛出{@link LunaException}
	 */
	@SuppressWarnings("serial")
	public static void buildAndBindFieldGroup(FieldGroup fieldGroup, Class<?> beanClass,ComponentContainer layout,String... fieldNames){
		//如果指定了fieldNames则按指定字段及顺序绑定
		if(fieldNames != null && fieldNames.length > 0){
			for(String fn : fieldNames){
				try {
					Field f = beanClass.getDeclaredField(fn);     //得到 Person 对象中的字段
					String caption = getCaption(beanClass, fn);   //得到 显示给用户看的表单输入框名称
					buildAndBind(fieldGroup,  beanClass, layout,  f,  caption);
				} catch (Exception e) {
					e.printStackTrace();
					throw new LunaException("从"+beanClass.getName()+"获取字段"+fn+"出错。请确认设置了正确的字段名。");
				}
			}
		}else{
			//如果未绑定字段，则使用有Caption注解的字段绑定
			for(Field f : beanClass.getDeclaredFields()){
				Caption caption = f.getAnnotation(Caption.class);
				if(caption != null){
					//String captionvalue = getCaption(f,true); //得到 * 显示给用户看的表单输入框名称
					buildAndBind(fieldGroup,  beanClass, layout,  f,  caption.value());
				}
			}
		}
		//设置绑定后字段的默认属性
		Collection<com.vaadin.ui.Field<?>> fs =  fieldGroup.getFields();
		for(com.vaadin.ui.Field<?> f : fs){
			if(f instanceof TextField){
				final TextField tf = (TextField)f;
				tf.addFocusListener(new FocusListener() {
					@Override
					public void focus(FocusEvent event) {
						tf.selectAll();
					}
				});
			}
		}
	
	}
	
	
	private static void buildAndBind(FieldGroup fieldGroup, Class<?> beanClass,ComponentContainer layout, Field f, String caption){
		SelectBox box = f.getAnnotation(SelectBox.class);
		NotNull notNull = f.getAnnotation(NotNull.class);
		//log.info("buildAndBind() 是否带下拉注解  name ="+f.getName()+",  box="+box);
		//如果带 注解  @SelectBox的字段，生成下拉框
		if (box != null ){ //实体、enum类型自动生成下拉框
			log.info(">>>>>>>>>>>>>>>>>>>>>"+f.getName()+"带下拉框，不添加到界面中");
			//layout.addComponent(fieldGroup.buildAndBind(caption,f.getName(),ComboBox.class));
		}else if (notNull != null) {
			//加了 @NotNull 的字段，必须填写
			TextField tf = (TextField)fieldGroup.buildAndBind(caption,f.getName());
			tf.setRequired(true);
			layout.addComponent(tf);
			
		}
		else{
			layout.addComponent(fieldGroup.buildAndBind(caption,f.getName()));
		}
	}
	
	
	/**
	 * 根据Caption注解返回caption,不生成必填标识
	 * @param clazz
	 * @param fieldname
	 * @return 找不到则返回fieldname
	 */
	public static String getCaption(Class<?> clazz, String fieldname){
		return getCaption(clazz, fieldname, false);
	}
	
	/**
	 * 根据Caption注解返回caption
	 * @param clazz
	 * @param fieldname
	 * @param showRequiredSign 是否生成必填标识
	 * @return
	 */
	public static String getCaption(Class<?> clazz, String fieldname, boolean showRequiredSign){
		try {
			Field f = clazz.getDeclaredField(fieldname);
			String caption = getCaption(f,showRequiredSign);
			return caption == null ? fieldname : caption;
		} catch (Exception e1) {
			return fieldname;
		}
	}
	
	/**
	 * 获得Caption
	 * @param field
	 * @param showRequiredSign 是否生成必填标识(红*)
	 * @return
	 */
	public static  String getCaption(Field field, boolean showRequiredSign){
		Caption caption = field.getAnnotation(Caption.class);
		NotNull notNull = field.getAnnotation(NotNull.class);
		if(caption != null){
			String cap = caption.value();
			if(showRequiredSign && notNull != null){
				//cap += "<font color=red>*</font>";
				cap += " * ";
			}
			return cap;
		}else{
			return field.getName();
		}
	}

	/**
	 * 根据异常信息生成友好提示
	 * @param e
	 * @return
	 */
	public static String getPersistenceErrorMsg(Exception e){
		String msg = e.getMessage();
		if(msg == null){
			return null;
		}
		if(msg.contains("FOREIGN KEY")){
			msg = "该数据已被引用，禁止删除:"+e.getMessage();
		}else if(msg.contains("Unique")){
			msg ="关键字段数据重复\n"+e.getMessage();
		}
		return msg;
	}
	
	
	
	
	
	
	
	
	
	//-----------------------表格相关-----------------------------------------
	/**
	 * 为table中已经存在的列设置caption，(根据{@link Caption},beanClass的字段上有该注解则增加 )
	 * @param table
	 * @param beanClass
	 */
	public static void setTableCaption(Table table,Class<?> beanClass){
		Object[] vcols = table.getVisibleColumns();
		for(Object col : vcols){
			try {
				Field f = beanClass.getDeclaredField(col.toString());
				Caption caption = f.getAnnotation(Caption.class);
				if(caption != null){
					table.setColumnHeader(col, caption.value());
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 为table设置默认列与caption(根据{@link Caption},beanClass的字段上有该注解则增加 )
	 * @param table
	 * @param beanClass
	 */
	public static void configTableHead(Table table,Class<?> beanClass, String... fieldNames){
		Map<String, String> map = new LinkedHashMap<String, String>();
		if(fieldNames != null && fieldNames.length > 0){
			//如果指定了fieldNames则不管存在不存在都增加，因为有可能是使用的自定义列
			for(String fn : fieldNames){
				//String caption = getCaption(beanClass, fn);
				//map.put(fn, caption);
			}
		}else{
			//如果没指定fieldNames，则只增加有注解的
			for(Field f : beanClass.getDeclaredFields()){
				Caption caption = f.getAnnotation(Caption.class);
				if(caption != null){
					//map.put(f.getName(), caption.value());
				}
			}
		}
		//设置数据
		Object[] cols = map.keySet().toArray();
		table.setVisibleColumns(cols);
		for(Object col : cols){
			table.setColumnHeader(col, map.get(col));
		}
	}

	

	
	
	
	
	
	/**
	 * 根据类获得增加功能按钮的KEY
	 * @param calss
	 * @return
	 */
	public static String getAddActionKey(Class<?> viewCalss){
		return viewCalss.getName()+":ADD";
	}
	/**
	 * 根据类获得删除功能按钮的KEY
	 * @param viewCalss
	 * @return
	 */
	public static String getDelActionKey(Class<?> viewCalss){
		return viewCalss.getName()+":DEL";
	}
	/**
	 * 根据类获得编辑功能按钮的KEY
	 * @param viewCalss
	 * @return
	 */
	public static String getEditActionKey(Class<?> viewCalss){
		return viewCalss.getName()+":EDIT";
	}

}
