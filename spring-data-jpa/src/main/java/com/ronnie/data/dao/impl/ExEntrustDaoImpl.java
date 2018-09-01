package com.ronnie.data.dao.impl;

import com.ronnie.data.dao.ExEntrustDao;
import com.ronnie.data.dao.base.BaseEntityManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/8/31$ 10:54$
 * @Remark:
 */

@Repository
public class ExEntrustDaoImpl implements ExEntrustDao {
    private final static String TABLE_NAME = "ex_entrust";

    @Autowired
    @PersistenceContext
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return this.em;
    }

}
