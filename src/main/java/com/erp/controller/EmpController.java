package com.erp.controller;

import com.erp.pojo.Emp;
import com.erp.service.EmpService;
import com.erp.util.EasyUiResultUtil;
import com.erp.vo.EmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("emp")
public class EmpController {
@Autowired
    private EmpService empService;
    @RequestMapping("remove")
    public Boolean remove(int[] ids) {
        empService.remove(ids);
        return true;
    }
    @RequestMapping("update")
    public boolean update(Emp emp, int[] roleIds) {
        empService.update(emp,roleIds);

        return true;
    }
    @RequestMapping("findById")
    public EmpVo findById(int id) {
        return empService.findById(id);
    }

    @RequestMapping("add")
    public boolean add(Emp emp, int[] roleIds) {
        empService.add(emp,roleIds);
        return true;
    }

    @RequestMapping("page")
    public EasyUiResultUtil<EmpVo> page(EmpVo wheres,
                                        @RequestParam(defaultValue = "1") int pageNum,
                                       @RequestParam(defaultValue = "2") int pageSize) {

        return empService.page(wheres,pageNum,pageSize);
    }
}
