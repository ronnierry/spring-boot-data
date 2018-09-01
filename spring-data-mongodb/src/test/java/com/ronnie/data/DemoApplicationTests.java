package com.ronnie.data;

import com.ronnie.data.document.Member;
import com.ronnie.data.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void queryDemo() {
        // add Sort
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC,"id");
        Sort.Order order2 = new Sort.Order(Sort.Direction.ASC,"username");
        Sort sort = Sort.by(order1,order2);
        // add condition
        Member member = new Member();
        member.setUsername("admin");
        Example<Member> memberExample = Example.of(member);
        // add pageRequest
        PageRequest pageRequest = PageRequest.of(0, 10, sort);
        // query result
        Page<Member> page = memberRepository.findAll(memberExample,pageRequest);
        log.info("page={}", page);
    }


}
