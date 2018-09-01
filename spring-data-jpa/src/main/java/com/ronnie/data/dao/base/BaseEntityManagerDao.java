package com.ronnie.data.dao.base;

import com.alibaba.fastjson.JSONObject;
import com.ronnie.data.utils.NativeSql;
import com.ronnie.data.utils.PageModel;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/8/31$ 10:14$
 * @Remark:
 */
public interface BaseEntityManagerDao {

    /**
     * 设置实体管理器
     *
     * @return
     */
    EntityManager getEntityManager();

    /**
     * 分页查询
     *
     * @param nativeSql
     * @param pageModel
     * @return
     */
    default Page createNativePageQuery(NativeSql nativeSql, PageModel pageModel) {
        String countSql = "SELECT COUNT(1) FROM " + nativeSql.getTableName() + " WHERE " + nativeSql.getConditions();
        StringBuilder sql = new StringBuilder("SELECT ");
        sql.append(nativeSql.getFields())
                .append(" FROM ")
                .append(nativeSql.getTableName())
                .append(" WHERE ")
                .append(nativeSql.getConditions());
        Query countQuery = getEntityManager().createNativeQuery(countSql);
        long count = ((BigInteger) countQuery.getSingleResult()).longValue();
        if (pageModel.getProperty() != null && pageModel.getProperty().size() > 0 && pageModel.getDirection().size() == pageModel.getProperty().size()) {
            sql.append("ORDER BY");
            for (int i = 0; i < pageModel.getProperty().size(); i++) {
                sql.append(" " + pageModel.getProperty().get(i) + " " + pageModel.getDirection().get(i) + " ");
                if (i < pageModel.getProperty().size() - 1) {
                    sql.append(",");
                }
            }
        }
        sql.append(" limit " + pageModel.getPageSize() * (pageModel.getPageNo() - 1) + " , " + pageModel.getPageSize());
        javax.persistence.Query query2 = getEntityManager().createNativeQuery(sql.toString());
        //query2.unwrap(NativeQuery.class).addEntity(Map.class).getResultList();
        query2.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List list = query2.getResultList();
        return new PageImpl<>(list, pageModel.getPageable(), count);
    }

    /**
     * 查询
     *
     * @param nativeSql
     * @return
     */
    default List<Map> nativeQueryAll(NativeSql nativeSql) {
        String sql = getSimpleSqlStringBuilder(nativeSql).toString();
        Query query = getEntityManager().createNativeQuery(sql);
        query.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        List<Map> list = (List<Map>) query.getResultList();
        return list;
    }

    /**
     * 查询
     *
     * @param nativeSql
     * @return
     */
    default Object nativeQueryOne(NativeSql nativeSql) {
        String sql = getSimpleSqlStringBuilder(nativeSql).append(" LIMIT 1 ").toString();
        Query query = getEntityManager().createNativeQuery(sql);
        query.unwrap(NativeQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        Object o = query.getSingleResult();
        return o;
    }

    default StringBuilder getSimpleSqlStringBuilder(NativeSql nativeSql) {
        StringBuilder sql = new StringBuilder("SELECT ");
        return sql.append(nativeSql.getFields())
                .append(" FROM ")
                .append(nativeSql.getTableName())
                .append(" WHERE ")
                .append(nativeSql.getConditions())
                .append(" ORDER BY ")
                .append(nativeSql.getSorts());
    }

}
