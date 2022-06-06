package com.vanhieu.util;

import com.vanhieu.dto.AbstractDto;

public class PageUtils {

    public static int getPage(int totalItem, int limit) {
        int totalPage = (int) Math.ceil( (double) totalItem / limit);
        return totalPage;
    }

    public static <T extends AbstractDto<T>> T getModel(T model, int page, int limit) {
        model.setPage(page);
        model.setLimit(limit);
        model.setTotalPage((int) Math.ceil( (double) model.getTotalItem() / model.getLimit()));
        return model;
    }
}
