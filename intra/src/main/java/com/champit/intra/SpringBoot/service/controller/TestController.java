package com.champit.intra.SpringBoot.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.champit.intra.SpringBoot.service.dao.TestDao;
import com.champit.intra.vo.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TestController {

    @Autowired
    TestDao testDao;

    // @Autowired 
    // JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/intra/testName", method = RequestMethod.POST)
    public ResponseEntity<?>  getTestNameString(){

        List<User> userName = testDao.getTestNameString();

        userName.forEach(System.out::println);
        return new ResponseEntity<>(userName, HttpStatus.OK);
    }

    @RequestMapping(value="/intra/nameStringByStatus", method = RequestMethod.POST)
    public ResponseEntity<?>  getNameStringByStatus(@RequestBody User user){

        log.info("◎◎◎◎◎◎◎◎ nameStringByStatus Input {}/{}/{}", user.getUsername(), user.getDefault_tablespace(), user.getAccount_status());
        
        List<User> userList = testDao.getNameStringByStatus(user);

        for ( User userName : userList){
            log.info("★★★★★★ nameStringByStatus Result {}/{}/{}", userName.getUsername(), userName.getDefault_tablespace(), userName.getAccount_status());
        }

        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    // @RequestMapping(value="/intra/testConn", method = RequestMethod.POST)
    // public String getTestConn(){

    //     System.out.println(" ■■■■■■■■ START!!! /intra/testConn ■■■■■■■■");
    //     System.out.println(" ■■■■■■■■ " +  jdbcTemplate.queryForObject("select 'champ'", String.class)  + "■■■■■■■■");
    //     System.out.println(" ■■■■■■■■ END!!! /intra/testConn ■■■■■■■■");
    //     return "{\"result\" : \"ok\"}";
        
    // }

}
