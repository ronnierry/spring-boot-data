package com.ronnie.data.service;

import com.ronnie.data.model.ExEntrust;
import com.ronnie.data.utils.NativeSql;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/8/31$ 16:44$
 * @Remark:
 */
public interface ExEntrustService {
    ExEntrust findOne(NativeSql nativeSql);
}
