package com.ronnie.data.repository;

import com.ronnie.data.document.Member;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/9/1$ 14:28$
 * @Remark:
 */
public interface MemberRepository extends MongoRepository<Member,Long> {
}
