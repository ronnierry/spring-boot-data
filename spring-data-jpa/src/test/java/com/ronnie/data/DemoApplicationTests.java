package com.ronnie.data;

import com.ronnie.data.dao.ExEntrustDao;
import com.ronnie.data.dao.MemberDao;
import com.ronnie.data.entity.Member;
import com.ronnie.data.model.ExEntrust;
import com.ronnie.data.service.ExEntrustService;
import com.ronnie.data.utils.NativeSql;
import com.ronnie.data.utils.NativeSqlBuilder;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SQLQuery;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private ExEntrustDao exEntrustDao;
    @Autowired
    private ExEntrustService exEntrustService;
    @Test
    public void contextLoads() {
        Member member = new Member();
        member.setPassword("123456");
        member.setUsername("rongyu");
        memberDao.save(member);
    }

    @Test
    public void em() {
        String sql = "SELECT * FROM ex_entrust";

        Query query = em.createNativeQuery(sql);
        query.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List resultList2 = query.getResultList();
        NativeQuery nativeQuery = query.unwrap(NativeQuery.class);
        List resultList1 = nativeQuery.getResultList();
        NativeQuery nativeQuery1 = nativeQuery.addEntity(ExEntrust.class);
        List resultList = nativeQuery1.getResultList();
        log.info("");
    }

    @Test
    public void eee() {
        String sql = "SELECT * FROM ex_entrust";
        NativeSql nativeSql = NativeSqlBuilder.builder("ex_entrust").build();
        Object o = exEntrustDao.nativeQueryOne(nativeSql);
        log.info("");
    }



    @Test
    public void exEntrustService() {
        NativeSql nativeSql = NativeSqlBuilder
                .builder("ex_entrust")
                .addCondition("and id = 20522932")
                .build();
        ExEntrust one = exEntrustService.findOne(nativeSql);
        log.info("");
    }

}
