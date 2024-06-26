package com.demo.common.entity;

public class SearchCriteria {
    int start;
    int limit;
    String searchText;
    String orderColumn;
    String orderDir;
    Object entity;
    StringParams extraParams;

    public SearchCriteria() {
    }

    public SearchCriteria(Object entity) {
        this.entity = entity;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderDir() {
        return orderDir;
    }

    public void setOrderDir(String orderDir) {
        this.orderDir = orderDir;
    }

    public Object getEntity() {
        return entity;
    }

    public void setEntity(Object entity) {
        this.entity = entity;
    }

    public StringParams getExtraParams() {
        return extraParams;
    }

    public void setExtraParams(StringParams extraParams) {
        this.extraParams = extraParams;
    }

}
