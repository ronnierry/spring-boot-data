package com.ronnie.data.dao;

import com.ronnie.data.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/9/19$ 14:17$
 * @Remark:
 */
@RestResource()
@Repository
public interface MemberDao extends JpaRepository<Member, Long> {
    Page<Member> findAllByUsername(@Param("username") String username, Pageable pageable);
}
