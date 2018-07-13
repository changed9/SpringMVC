package com.wyd.spring.dao;

import com.wyd.spring.model.TPermission;

public interface TPermissionMapper {
    int insert(TPermission record);

    int insertSelective(TPermission record);
}