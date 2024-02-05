package com.huang;

import com.huang.mapper.RecordsMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//@SpringBootTest
class FilmApplicationTests {

    @Autowired
    private RecordsMapper recordsMapper;

    @Test
    void contextLoads() {

    }

    @Test
    public void testGenJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "tom");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"huang")//设置签名算法
                .setClaims(claims)//设置自定义的内容(载荷)
                .setExpiration(new Date(System.currentTimeMillis()))//设置有效期
                .compact();
        System.out.println(jwt);
    }

    /**
     * 解析JWT
     */
    @Test
    public void testParseJwt(){
        Claims huang = Jwts.parser()
                .setSigningKey("huang")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcwNjg3NDE0NH0.9tu_11xdcqvM9gzo6abLDtW_DcaMKd7QxegVPFmkBag")
                .getBody();
        System.out.println(huang);
    }

}
