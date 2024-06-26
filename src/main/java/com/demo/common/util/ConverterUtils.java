package com.demo.common.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.common.entity.SearchCriteria;
import com.demo.common.entity.DataTableRequest;
import com.demo.common.entity.DataTableColumn;
import com.demo.common.entity.DataTableOrder;

public class ConverterUtils {
    private static final Logger logger = LoggerFactory.getLogger(ConverterUtils.class);

    public static void setCriteriaFromDtParams(DataTableRequest dt, SearchCriteria sc) {
        if(dt == null) {
            return;
        }

        sc.setLimit(dt.getLength());
        sc.setStart(dt.getStart());

        if(dt.getSearch() == null) {
            return;
        }

        sc.setSearchText(dt.getSearch().getValue());

        if (null == dt.getOrder() || dt.getOrder().size() == 0) {
            throw new IllegalArgumentException("order param is requried.");
        }

        DataTableOrder order = dt.getOrder().get(0);

        int orderColumn = order.getColumn();
        String orderDir = order.getDir();

        if(!StringUtils.equalsAnyIgnoreCase(orderDir, "", "ASC", "DESC")) {
            throw new IllegalArgumentException("dir parameter is invalid.");
        }

        if (dt.getColumns().size() < orderColumn) {
            throw new IllegalArgumentException("order column is invalid.");
        }

        DataTableColumn column = dt.getColumns().get(orderColumn);

        String orderName = column.getName();

        sc.setOrderColumn(orderName);
        sc.setOrderDir(orderDir);

        logger.debug("DataTables order params: column[{}:{}], dir[{}]", orderColumn, orderName, orderDir);
    }
}
