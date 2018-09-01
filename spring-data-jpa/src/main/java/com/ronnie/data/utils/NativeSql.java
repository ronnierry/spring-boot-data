package com.ronnie.data.utils;

import lombok.Builder;
import lombok.Data;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/8/30$ 12:23$
 * @Remark:
 */
@Data
@Builder
public class NativeSql {
    private String tableName;
    private String fields;
    private String conditions;
    private String sorts;
}
