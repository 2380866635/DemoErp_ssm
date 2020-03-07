package com.erp.service.impl;

import com.erp.mapper.EmpMapper;
import com.erp.mapper.EmpRoleMapper;
import com.erp.pojo.Emp;
import com.erp.service.EmpService;
import com.erp.util.EasyUiResultUtil;
import com.erp.vo.EmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmpServiceImpl implements EmpService {
   @Autowired
   private EmpMapper empMapper;
   @Autowired
   private EmpRoleMapper empRoleMapper;

    @Override
    public void remove(int[] ids) {
        empMapper.remove(ids);
        empRoleMapper.remove(ids);
    }

    @Override
    public void update(Emp emp, int[] roleIds) {
        empMapper.update(emp);
        int [] ids={emp.getId()};
        empRoleMapper.remove(ids);
        empRoleMapper.add(emp.getId(),roleIds);
    }

    @Override
    public EmpVo findById(int id) {
        return empMapper.findById(id);
    }


    @Override
    public void add(Emp emp, int[] roleIds) {
        empMapper.add(emp);
        int empId=getKey();
       /* System.out.println("这是增加的信息"+empId);
        for(int i=0;i<roleIds.length;i++){
            System.out.println("增加的信息"+roleIds[i]);
        }*/
        empRoleMapper.add(empId,roleIds);
    }

    @Override
    public int getKey() {
        return empMapper.getKey();
    }

    @Override
    public EasyUiResultUtil<EmpVo> page(EmpVo wheres, int pageNum, int pageSize) {
        EasyUiResultUtil<EmpVo> resultUtil=new EasyUiResultUtil<>(empMapper.count(wheres),
                 empMapper.page(wheres,(pageNum-1)*pageSize,pageSize));
        return resultUtil;
    }
}
