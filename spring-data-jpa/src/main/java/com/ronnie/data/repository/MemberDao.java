package com.ronnie.data.repository;

import com.ronnie.data.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/8/31$ 10:12$
 * @Remark:
 */
public interface MemberDao extends JpaRepository<Member,Long>{
}
