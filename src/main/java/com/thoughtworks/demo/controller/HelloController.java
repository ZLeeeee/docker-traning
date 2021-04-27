package com.thoughtworks.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisPool;

import javax.annotation.PostConstruct;

@RestController
public class HelloController {

    private static String HELLO = "hello";

    private final JedisPool jedisPool;

    public HelloController(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    @PostConstruct
    private void init(){
        jedisPool.getResource().set(HELLO,"hello");
    }

    @GetMapping("/hello")
    public String helloWord(){
        return jedisPool.getResource().get(HELLO);
    }
}
