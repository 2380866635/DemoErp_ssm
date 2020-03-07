package com.erp.service;

import com.erp.pojo.Dept;
import com.erp.util.EasyUiResultUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DeptService {
    
    /**
     *
     * @param pageNum 当前页
     * @param pageSize 当前页显示条数
     * @return 查询到的Dept信息
     */
    EasyUiResultUtil<Dept> page(int pageNum, int pageSize);

    /**
     * @param dept 增加部门信息
     */
    void add(Dept dept);
    /**
     * 通过id单个查询
     * @param id 查询的部门id
     * @return 查询到的部门信息
     */
    Dept findById(Integer id);

    /**
     * 修改方法
     * @param dept 修改的部门信息
     */
    void update(Dept dept);

    /**
     * 删除方法
     * @param ids 要删除的多个部门id
     */
    void remove(Integer[] ids);

    /**
     * 查询所有部门
     * @return
     */
    List<Dept> findAll();
}
