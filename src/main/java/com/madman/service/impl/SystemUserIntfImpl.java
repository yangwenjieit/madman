package com.madman.service.impl;

import com.madman.dao.SystemUserDao;
import com.madman.entity.SystemUser;
import com.madman.service.SystemUserIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SystemUserIntfImpl implements SystemUserIntf {
    @Autowired
    private SystemUserDao systemUserDao;
    @Override
    public SystemUser getSystemUserById(String id) {
        return systemUserDao.getSystemUserById(id);
    }

    @Override
    public void insert(SystemUser systemUser) {

    }

    @Override
    public List<SystemUser> getAllSystemUser() {
        return systemUserDao.getAllSystemUser();
    }
}
