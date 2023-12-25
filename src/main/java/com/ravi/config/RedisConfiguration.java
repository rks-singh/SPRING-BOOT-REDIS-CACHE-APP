package com.ravi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.ravi.model.Book;

@Configuration
public class RedisConfiguration {

	@Bean
	JedisConnectionFactory getJedisConnectionFactory() {
		JedisConnectionFactory jcf = new JedisConnectionFactory();
		return jcf;
	}
	
	@Bean
	RedisTemplate<String, Book> getRedisTemplate(){
		RedisTemplate<String, Book> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(getJedisConnectionFactory());
		return redisTemplate;
	}
}
