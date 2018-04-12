package com.madman.service;

import com.madman.entity.SystemUser;

import java.util.List;

public interface SystemUserIntf {

    public List<SystemUser> getAllSystemUser();
    public SystemUser getSystemUserById(String id);
}
