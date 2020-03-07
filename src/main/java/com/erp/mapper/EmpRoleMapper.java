package com.erp.mapper;

import org.apache.ibatis.annotations.Param;

public interface EmpRoleMapper {
    /**
     *
     * @param ids
     * @return
     */
    void remove (@Param("ids") int[]ids);

    void add(@Param("id") Integer id,@Param("roleIds") int[] roleIds);

}
