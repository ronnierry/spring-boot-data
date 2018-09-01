package com.ronnie.data;

import com.ronnie.data.entity.Member;
import com.ronnie.data.entity.MemberOrder;
import com.ronnie.data.repository.MemberDao;
import com.ronnie.data.repository.MemberOrderDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    MemberDao memberDao;
    @Autowired
    MemberOrderDao orderDao;

    @Test
    public void addTestData() throws InterruptedException {
        // Member member = memberDao.getOne(1L); bad way
        Optional<Member> optionalMember = memberDao.findById(1L);
        Member member = optionalMember.get();
        for (int i = 0; i < 12; i++) {
            MemberOrder order = new MemberOrder();
            order.setGoodsName("coco");
            order.setMember(member);
            order.setNumber(10);
            Thread.sleep(1000);
            orderDao.save(order);
        }
    }

    @Test
    public void queryDemo() {
        // add condition
        MemberOrder order = new MemberOrder();
        Member member = new Member();
        member.setUsername("root");
        order.setMember(member);
        Example<MemberOrder> example = Example.of(order);
        // add order by
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "id");
        Sort.Order order2 = new Sort.Order(Sort.Direction.ASC, "number");
        Sort sort = Sort.by(order1, order2);
        // add pageable
        PageRequest pageRequest = PageRequest.of(0, 10, sort);
        // findAll with page
        Page<MemberOrder> result = orderDao.findAll(example, pageRequest);
        log.info("result={}", result);
    }

}
