package com.ronnie.data.utils;

import org.springframework.util.StringUtils;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/8/30$ 11:49$
 * @Remark:
 */
public class NativeSqlBuilder {

    private final static String BLANK = " ";
    private final static String COMMA = ",";
    private final static String DEFAULT_SELECT_FIELD = "*";
    private final static String DEFAULT_ORDER = "id DESC";

    private String tableName;
    private StringBuffer fields = new StringBuffer();
    private StringBuffer conditions = new StringBuffer("1=1 ");
    private StringBuffer sorts = new StringBuffer();

    // 表名
    public NativeSqlBuilder(String tableName) {
        this.tableName = tableName;
    }

    // 表字段
    public NativeSqlBuilder addField(String field) {
        if (!StringUtils.isEmpty(fields)) {
            fields.append(COMMA + field);
        } else {
            fields.append(field);
        }
        return this;
    }

    // 条件
    public NativeSqlBuilder addCondition(String condition) {
        conditions.append(condition + BLANK);
        return this;
    }

    // 排序
    public NativeSqlBuilder addSort(String sort) {
        if (!StringUtils.isEmpty(sorts)) {
            sorts.append(COMMA + sort);
        } else {
            sorts.append(sort);
        }
        return this;
    }

    public static NativeSqlBuilder builder(String tableName) {
        return new NativeSqlBuilder(tableName);
    }

    public NativeSql build() {
        return NativeSql.builder()
                .tableName(tableName)
                .conditions(conditions.toString())
                .fields(!StringUtils.isEmpty(fields.toString()) ? fields.toString() : DEFAULT_SELECT_FIELD)
                .sorts(!StringUtils.isEmpty(sorts.toString()) ? sorts.toString() : DEFAULT_ORDER)
                .build();
    }

}
