package com.wyd.spring.dao;

import com.wyd.spring.model.Role;

public interface RoleMapper {
    int insert(Role record);

    int insertSelective(Role record);
}