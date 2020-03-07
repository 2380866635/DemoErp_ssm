package com.erp.mapper;
import com.erp.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    /**
     * 查询所有职位
     * @return
     */
    List<Role> findAll();

    /**
     * 查询信息
     * @param role
     * @return
     */
    List<Role> page(@Param("role") Role role,@Param("start") int start,@Param("pageSize") int pageSize);

    /**
     * 删除方法
     * @param ids
     */
    void remove(@Param("ids") int [] ids);

    /**
     * 修改方法
     * @param role
     */
    void update(@Param("role") Role role);

    /**
     * 单个查找
     * @param id
     * @return
     */

    Role findById(@Param("id") int id);

    /**
     * 添加方法
     * @param role
     */
    void add(@Param("role") Role role);

    /**
     * 查找到的条数
     * @param
     * @return
     */
    int count(@Param("role") Role role);


    List<Integer> findpermissionIdsByRoleId(@Param("roleId") int roleId);

    void updatePerm(@Param("roleId") int roleId,@Param("permIds") int[] permIds);
    void removePerm(@Param("roleId") int roleId);
}
