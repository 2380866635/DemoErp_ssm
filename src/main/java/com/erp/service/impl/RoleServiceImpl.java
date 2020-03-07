package com.erp.service.impl;

import com.erp.mapper.RoleMapper;
import com.erp.pojo.Role;
import com.erp.service.RoleService;
import com.erp.util.EasyUiResultUtil;
import com.erp.vo.EmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public EasyUiResultUtil<Role> page(Role role, int pageNum, int pageSize) {
        EasyUiResultUtil<Role> resultUtil=new EasyUiResultUtil<>(roleMapper.count(role),
                roleMapper.page(role,(pageNum-1)*pageSize,pageSize));
        return resultUtil;

    }

    @Override
    public void remove(int[] ids) {
        roleMapper.remove(ids);
    }

    @Override
    public void update(Role role) {
        roleMapper.update(role);
    }

    @Override
    public Role findById(int id) {
        return roleMapper.findById(id);
    }

    @Override
    public void add(Role role) {
        roleMapper.add(role);
    }

    @Override
    public List<Integer> findpermissionIdsByRoleId(int roleId) {
        return roleMapper.findpermissionIdsByRoleId(roleId);
    }

    @Override
    public void updatePerm(int roleId, int[] permIds) {
        roleMapper.removePerm(roleId);
        roleMapper.updatePerm(roleId, permIds);

    }
}
