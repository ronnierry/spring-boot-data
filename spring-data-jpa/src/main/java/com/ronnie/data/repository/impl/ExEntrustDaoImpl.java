package com.ronnie.data.repository.impl;

import com.ronnie.data.repository.ExEntrustDao;
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
