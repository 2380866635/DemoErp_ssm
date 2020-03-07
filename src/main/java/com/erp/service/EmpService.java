package com.erp.service;

import com.erp.pojo.Emp;
import com.erp.util.EasyUiResultUtil;
import com.erp.vo.EmpVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpService {
    /**
     * 删除方法
     * @param ids 要删除的员工编号数组
     */
    void remove(int [] ids);


    /**
     * 修改方法
     * @param emp 修改的员工信息
     */
    void update(Emp emp,int[] roleIds);

    /**
     * 单个信息的查询
     * @param id 查询的员工is
     * @return 查询的的员工信息
     */
    EmpVo findById(int id);

    /**
     * 增加方法
     * @param emp 要增加的员工信息
     */
    void add(Emp emp,int[] roleIds);

    /**
     * 获取增加的员工信息的id
     * @return
     */
    int getKey();

    /**
     * 条件查询
     * @param wheres 查询的信息
     * @param start 当前页
     * @param pageSize 显示条数
     * @return 查询到的员工信息
     */
    EasyUiResultUtil<EmpVo> page(EmpVo wheres,
                                 int pageNum,
                                 int pageSize);

}
