package com.erp.controller;

import com.erp.pojo.Dept;
import com.erp.service.DeptService;
import com.erp.util.EasyUiResultUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController  //@ResponseBody和@Controller的结合
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptService deptService;
    @RequestMapping("findAll")
    public List<Dept> findAll(){
        return deptService.findAll();
    }
    //@ResponseBody//返回json对象
    @RequestMapping("/page")
    public EasyUiResultUtil<Dept> page(@RequestParam(defaultValue = "1")int pageNum,
                                       @RequestParam(defaultValue = "2")int pageSize){
        return deptService.page(pageNum,pageSize);
    }
    @RequestMapping("/add")
    public boolean add(Dept dept){
        deptService.add(dept);
        return true;
    }

    /**
     * 通过id单个查询
     * @param id 查询的部门id
     * @return 查询到的部门信息
     */
    @RequestMapping("/findById")
    public Dept findById(Integer id){
        Dept byId = deptService.findById(id);
        return byId;
    }

    /**
     * 修改方法
     * @param dept 修改的部门信息
     */
    @RequestMapping("/update")
    public boolean update( Dept dept){
        deptService.update(dept);
        return true;
    }

    /**
     * 删除方法
     * @param ids 要删除的多个部门id
     */
    @RequestMapping("/remove")
    public boolean remove( Integer[] ids){
        deptService.remove(ids);
        return true;
    }



}
