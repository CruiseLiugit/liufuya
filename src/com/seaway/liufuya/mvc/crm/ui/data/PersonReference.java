package com.seaway.liufuya.mvc.crm.ui.data;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.ObjectProperty;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现了 Item 接口，表示该 Person 可以直接跟 组件进行数据绑定
 * 
 * @author lililiu
 *
 */
@SuppressWarnings("serial")
public class PersonReference implements Serializable, Item {

    private int personId;
    private Map<Object, Property> propertyMap;

    /**
     * 构造方法，把 参数封装到 personId propertyMap 两个属性里面
     * @param personId      人的数据库 id
     * @param propertyMap   
     */
    public PersonReference(int personId, Map<String, Object> propertyMap) {
        this.personId = personId;
        this.propertyMap = new HashMap<Object, Property>(); //新建一个 Map，存放数据
        for (String key : propertyMap.keySet()) {
            this.propertyMap.put(key, new ObjectProperty(propertyMap.get(key)));
        }
    }

    public int getPersonId() {
        return personId;
    }

    
    //----------------------------------------------------------
    //Item 接口方法
    public Property getItemProperty(Object id) {
        return propertyMap.get(id);
    }

    public Collection<?> getItemPropertyIds() {
        return Collections.unmodifiableSet(propertyMap.keySet());
    }

    public boolean addItemProperty(Object id, Property property) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Item is read-only.");
    }

    public boolean removeItemProperty(Object id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Item is read-only.");
    }
}
