package com.erp.mapper;

import com.erp.pojo.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptMapper {
    /**
     * @param startNum 当前页
     * @param pageSize 页面显示条数
     * @return 查询到的dept数据
     */
    List<Dept> page(@Param("startNum") int startNum,@Param("pageSize") int pageSize);
    /**
     * @return 返回查询到的所有条数
     *
      */
    int count ();

    /**
     * @param dept 增加的部门信息
     */
    void  add(@Param("dept") Dept dept);

    /**
     * 通过id单个查询
     * @param id 查询的部门id
     * @return 查询到的部门信息
     */
    Dept findById(@Param("id") Integer id);

    /**
     * 修改方法
     * @param dept 修改的部门信息
     */
    void update(@Param("dept") Dept dept);

    /**
     * 删除方法
     * @param ids 要删除的多个部门id
     */
    void remove(@Param("ids") Integer[] ids);

    List<Dept> findAll();
}
