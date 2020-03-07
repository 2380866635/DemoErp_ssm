package com.erp.mapper;

import com.erp.pojo.Premission;
import com.erp.util.TreeResultUtil;

import java.util.List;

public interface PremissionMapper {
    List<TreeResultUtil>  list();
    /**
     * 权限查找
     * @param username
     * @return
     */
    List<TreeResultUtil> getPerms(String username);
}
