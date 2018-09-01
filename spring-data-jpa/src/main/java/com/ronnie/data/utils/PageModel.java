package com.ronnie.data.utils;

import lombok.Data;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * rongyu
 * 分页接受参数
 */
@Data
public class PageModel {
    Integer pageNo = 1;
    Integer pageSize = 10;
    List<Sort.Direction> direction;
    List<String> property;

    public void setSort() {
        if (property == null || property.size() == 0) {
            List<String> list = new ArrayList<>();
            list.add("id");
            List<Sort.Direction> directions = new ArrayList<>();
            directions.add(Sort.Direction.DESC);
            property = list;
            direction = directions;
        }
    }

    private Sort getSort() {
        List<Sort.Order> orders = null;
        setSort();
        if (direction.size() == property.size()) {
            orders = new ArrayList<>();
            int length = direction.size();
            for (int i = 0; i < length; i++) {
                orders.add(new Sort.Order(direction.get(i), property.get(i)));
            }
        }
        return new Sort(orders);
    }

    public Pageable getPageable() {
        Sort sort = getSort();
        if (sort == null)
            return new PageRequest(pageNo - 1, pageSize);
        return new PageRequest(pageNo - 1, pageSize, sort);
    }
}
