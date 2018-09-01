package com.ronnie.data.repository;

import com.ronnie.data.entity.MemberOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/9/1$ 15:51$
 * @Remark:
 */
public interface MemberOrderDao extends JpaRepository<MemberOrder, Long> {
}
