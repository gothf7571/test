package com.demo.common.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

public class DataTableResponse<T> {
    private int draw;
    private int recordsTotal;
    private int recordsFiltered;
    private List<T> data;
    private String error;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(int recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public int getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(int recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<T> getData() {
        if (null == data || CollectionUtils.isEmpty(data)) {
            return new ArrayList<T>();
        }

        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static <T> DataTableResponse<T> makeDataTableReturn(int draw, int recordsTotal, int recordsFiltered,
                                                               List<T> data) {
        DataTableResponse<T> newObj = new DataTableResponse<T>();
        newObj.setDraw(draw);
        newObj.setRecordsTotal(recordsTotal);
        newObj.setRecordsFiltered(recordsFiltered);
        newObj.setData(data);

        return newObj;
    }
}
