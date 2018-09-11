package com.ronnie.data.config;

import com.ronnie.data.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * @Description:
 * @Author: rongyu
 * @CreateDate: 2018/9/8$ 16:08$
 * @Remark:
 */
@Configuration
public class ApplicationConfig {


    // TODO remove config of redis to application.yml
    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration configuration =
                new RedisStandaloneConfiguration("192.168.1.12", 6379);
        RedisPassword redisPassword = RedisPassword.of("lcex123");
        configuration.setDatabase(5);
        configuration.setPassword(redisPassword);
        return new LettuceConnectionFactory(configuration);
    }

    @Bean
    public RedisTemplate<String, Serializable> redisCacheTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Serializable> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public RedisTemplate<String, User> redisUserTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, User> stringUserRedisTemplate = new RedisTemplate<>();
        stringUserRedisTemplate.setKeySerializer(new StringRedisSerializer());
        stringUserRedisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        stringUserRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return stringUserRedisTemplate;
    }

}
