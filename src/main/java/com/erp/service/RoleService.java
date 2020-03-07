package com.erp.service;

import com.erp.pojo.Role;
import com.erp.util.EasyUiResultUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    /**
     * 查询信息
     * @param role
     * @return
     */
    EasyUiResultUtil<Role> page(Role role, int pageNum, int pageSize);

    /**
     * 删除方法
     * @param ids
     */
    void remove(int [] ids);

    /**
     * 修改方法
     * @param role
     */
    void update( Role role);

    /**
     * 单个查找
     * @param id
     * @return
     */

    Role findById (int id);

    /**
     * 添加方法
     * @param role
     */
    void add( Role role);

    List<Integer> findpermissionIdsByRoleId(int roleId);

    void updatePerm(int roleId, int[] permIds);
}
