package com.seaway.liufuya.mvc.crm.ui.data;

import com.seaway.liufuya.mvc.crm.ui.dao.PersonManager;
import com.vaadin.data.Item;
import com.vaadin.data.Property;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.vaadin.data.Container;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.nutz.ioc.loader.annotation.IocBean;

/**
 * 可以直接放入组件中的 数据容器，也可以理解为 DataSource
 *  
 * @author lililiu
 *
 */
@IocBean
@SuppressWarnings("serial")
public class PersonReferenceContainer implements Container, Container.ItemSetChangeNotifier {

    /**
     * Natural property order for Person bean. Used in tables and forms.
     */
    public static final Object[] NATURAL_COL_ORDER = new String[]{
        "firstName", "lastName", "email", "phoneNumber", "streetAddress",
        "postalCode", "city"};
    protected static final Collection<Object> NATURAL_COL_ORDER_COLL = Collections.unmodifiableList(Arrays.asList(NATURAL_COL_ORDER));
    /**
     * "表头列名" captions for properties in same order as in
     * NATURAL_COL_ORDER.
     */
    public static final String[] COL_HEADERS_ENGLISH = new String[]{
        "First name", "Last name", "Email", "Phone number",
        "Street Address", "Postal Code", "City"};
    public static final String[] COL_HEADERS_CHINESE = new String[]{
        "姓氏", "名称", "邮箱", "电话",
        "地址", "邮编", "城市"};
    
    protected final PersonManager personManager;
    protected List<PersonReference> personReferences;
    protected Map<Object, PersonReference> idIndex;
    
    
    /**
     * Default query meta data.
     * 定义好查询的一些参数
     */
    public static QueryMetaData defaultQueryMetaData = new QueryMetaData(new String[]{"firstName", "lastName"}, new boolean[]{true, true});
    protected QueryMetaData queryMetaData = defaultQueryMetaData;
    protected ArrayList<ItemSetChangeListener> listeners = new ArrayList<ItemSetChangeListener>();

    public PersonReferenceContainer(PersonManager personManager) {
        this.personManager = personManager;
    }

    public void refresh() {
        refresh(queryMetaData);
    }

    public void refresh(QueryMetaData queryMetaData) {
        this.queryMetaData = queryMetaData;
        personReferences = personManager.getPersonReferences(queryMetaData, (String[]) NATURAL_COL_ORDER);
        idIndex = new HashMap<Object, PersonReference>(personReferences.size());
        for (PersonReference pf : personReferences) {
            idIndex.put(pf.getPersonId(), pf);
        }
        notifyListeners();
    }

    public QueryMetaData getQueryMetaData() {
        return queryMetaData;
    }

    public void close() {
        if (personReferences != null) {
            personReferences.clear();
            personReferences = null;
        }
    }

    public boolean isOpen() {
        return personReferences != null;
    }

    public int size() {
        return personReferences == null ? 0 : personReferences.size();
    }

    public Item getItem(Object itemId) {
        return idIndex.get(itemId);
    }

    public Collection<?> getContainerPropertyIds() {
        return NATURAL_COL_ORDER_COLL;
    }

    public Collection<?> getItemIds() {
        return Collections.unmodifiableSet(idIndex.keySet());
    }

    public List<PersonReference> getItems() {
        return Collections.unmodifiableList(personReferences);
    }

    public Property getContainerProperty(Object itemId, Object propertyId) {
        Item item = idIndex.get(itemId);
        if (item != null) {
            return item.getItemProperty(propertyId);
        }
        return null;
    }

    public Class<?> getType(Object propertyId) {
        try {
            // TODO Optimize, please!
            PropertyDescriptor pd = new PropertyDescriptor((String) propertyId, Person.class);
            return pd.getPropertyType();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean containsId(Object itemId) {
        return idIndex.containsKey(itemId);
    }

    public Item addItem(Object itemId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This container is read-only.");
    }

    public Object addItem() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This container is read-only.");
    }

    public boolean removeItem(Object itemId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This container is read-only.");
    }

    public boolean addContainerProperty(Object propertyId, Class<?> type, Object defaultValue) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This container is read-only.");
    }

    public boolean removeContainerProperty(Object propertyId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This container is read-only.");
    }

    public boolean removeAllItems() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("This container is read-only.");
    }

    public synchronized void addListener(ItemSetChangeListener listener) {
        listeners.add(listener);
    }

    public synchronized void removeListener(ItemSetChangeListener listener) {
        listeners.remove(listener);
    }

    @SuppressWarnings("unchecked")
    protected void notifyListeners() {
        ArrayList<ItemSetChangeListener> cl = (ArrayList<ItemSetChangeListener>) listeners.clone();
        ItemSetChangeEvent event = new ItemSetChangeEvent() {

            public Container getContainer() {
                return PersonReferenceContainer.this;
            }
        };

        for (ItemSetChangeListener listener : cl) {
            listener.containerItemSetChange(event);
        }
    }

	@Override
	public void addItemSetChangeListener(ItemSetChangeListener listener) {
		listeners.add(listener);
	}

	@Override
	public void removeItemSetChangeListener(ItemSetChangeListener listener) {
		listeners.remove(listener);
	}
}
