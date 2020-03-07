package com.erp.mapper;

import com.erp.pojo.Emp;
import com.erp.util.TreeResultUtil;
import com.erp.vo.EmpVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    /**
     * 删除方法
     * @param ids 要删除的员工编号数组
     */
    void remove(@Param("ids") int [] ids);

    /**
     * 修改方法
     * @param emp 修改的员工信息
     */
    void update(@Param("emp") Emp emp);

    /**
     * 单个信息的查询
     * @param id 查询的员工is
     * @return 查询的的员工信息
     */
    EmpVo findById(@Param("id") int id);

    /**
     * 增加方法
     * @param emp 要增加的员工信息
     */
    void add(@Param("emp") Emp emp);

    /**
     * 查询要查询的信息条数
     * @param wheres 要查询的信息
     * @return 查询到的信息总条数
     */
    int count(@Param("wheres") EmpVo wheres);

    /**
     * 条件查询
     * @param wheres 查询的信息
     * @param start 当前页
     * @param pageSize 显示条数
     * @return 查询到的员工信息
     */
    List<EmpVo> page(@Param("wheres") EmpVo wheres,
                                 @Param("start") int start,
                                 @Param("pageSize") int pageSize);


    /**
     * 自动增长主键
     * @return
     */
    int getKey();

    /**
     * 登录界面查询
     * @param username
     * @param password
     * @return
     */
    Emp login(@Param("username") String username,@Param("password") String password);



}
