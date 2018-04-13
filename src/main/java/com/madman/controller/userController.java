package com.madman.controller;

import com.madman.entity.SystemUser;
import com.madman.service.SystemUserIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class userController {

    @Autowired
    SystemUserIntf systemUserIntf;
    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public List<SystemUser> getAllUser(){
        return systemUserIntf.getAllSystemUser();
    }
}
