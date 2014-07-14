package com.seaway.liufuya.mvc.crm.ui.data;

import java.io.Serializable;

/**
 * 封装排序、升降序、搜索字段等信息的类
 * @author lililiu
 *
 */
@SuppressWarnings("serial")
public class QueryMetaData implements Serializable {

    private boolean[] ascending;  //升降序
    private String[] orderBy;     //按字段排序
    private String searchTerm;    //搜索字段
    private String propertyName;  //某个列的名称

    public QueryMetaData(String propertyName, String searchTerm, String[] orderBy, boolean[] ascending) {
        this.propertyName = propertyName;
        this.searchTerm = searchTerm;
        this.ascending = ascending;
        this.orderBy = orderBy;
    }

    public QueryMetaData(String[] orderBy, boolean[] ascending) {
        this(null, null, orderBy, ascending);
    }

    public boolean[] getAscending() {
        return ascending;
    }

    public String[] getOrderBy() {
        return orderBy;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public String getPropertyName() {
        return propertyName;
    }
}
