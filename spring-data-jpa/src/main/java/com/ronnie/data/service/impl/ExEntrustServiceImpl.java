package com.ronnie.data.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ronnie.data.dao.ExEntrustDao;
import com.ronnie.data.model.ExEntrust;
import com.ronnie.data.service.ExEntrustService;
import com.ronnie.data.utils.NativeSql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/8/31$ 16:45$
 * @Remark:
 */
@Service
public class ExEntrustServiceImpl implements ExEntrustService {
    @Autowired
    private ExEntrustDao dao;

    @Override
    public ExEntrust findOne(NativeSql nativeSql) {
        ExEntrust e = null;
        Object o = dao.nativeQueryOne(nativeSql);
        if (o != null) {
            e = JSONObject.parseObject(JSONObject.toJSONString(o), ExEntrust.class);
        }
        return e;
    }
}
