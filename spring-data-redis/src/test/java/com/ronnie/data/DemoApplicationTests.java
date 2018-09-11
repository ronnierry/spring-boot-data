package com.ronnie.data;

import com.ronnie.data.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;
    @Autowired
    private RedisTemplate<String, User> userRedisTemplate;

    @Test
    public void saveString() {
        // 保存字符串
        redisTemplate.opsForValue().set("a:b:c", "111");
        Serializable serializable = redisTemplate.opsForValue().get("a:b:c");
        log.info("s={}", serializable);
    }

    @Test
    public void saveUser() {
        // 保存字符串
        User user = new User();
        user.setUsername("root");
        user.setPassword("root");
        ValueOperations<String, User> opsForValue = userRedisTemplate.opsForValue();
        opsForValue.set("1", user);
        User user1 = opsForValue.get("1");
        log.info("user={}", user1);
    }


}
