package com.madman.servicetest;

import com.madman.common.SpringTestCase;
import com.madman.entity.SystemUser;
import com.madman.service.SystemUserIntf;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SystemUserServiceTest extends SpringTestCase {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SystemUserIntf systemUserIntf;

    @Test
    public void getAllSystemUser(){
        List<SystemUser> allSystemUser = systemUserIntf.getAllSystemUser();
        for (SystemUser s:allSystemUser) {
            logger.info("sss"+s.getUserName());
        }
    }

}
