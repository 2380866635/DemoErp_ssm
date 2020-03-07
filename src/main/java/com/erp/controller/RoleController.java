package com.erp.controller;

import com.erp.pojo.Role;
import com.erp.service.RoleService;
import com.erp.util.EasyUiResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @RequestMapping("findAll")
    public List<Role> findAll(){
        return roleService.findAll();
    }

    @RequestMapping("page")
    public EasyUiResultUtil<Role> page(Role role,
                                       @RequestParam(defaultValue = "1") int pageNum,
                                       @RequestParam(defaultValue = "2") int pageSize){
       return roleService.page(role,pageNum,pageSize);
    }

    @RequestMapping("remove")
    public Boolean remove(int[] ids) {
        roleService.remove(ids);
        return  true;
    }

    @RequestMapping("update")
    public Boolean update(Role role) {
        roleService.update(role);
        return true;
    }

    @RequestMapping("findById")
    public Role findById(int id) {
        return roleService.findById(id);
    }

    @RequestMapping("add")
    public Boolean add(Role role) {
        roleService.add(role);
        return  true;
    }
    @RequestMapping("findpermissionIdsByRoleId")
    public List<Integer> findpermissionIdsByRoleId(int id){
        return roleService.findpermissionIdsByRoleId(id);
    }

    @RequestMapping("updatePerm")
    public boolean updatePerm(int roleId,int[] permIds){
        roleService.updatePerm(roleId,permIds);
        return true;
    }
}
