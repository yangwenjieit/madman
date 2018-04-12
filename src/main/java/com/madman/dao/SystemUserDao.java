package com.madman.dao;

import com.madman.entity.SystemUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SystemUserDao {
    public List<SystemUser> getAllSystemUser();
    public SystemUser getSystemUserById(String id);
}
