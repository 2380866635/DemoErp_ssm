package com.erp.service.impl;

import com.erp.mapper.DeptMapper;
import com.erp.pojo.Dept;
import com.erp.service.DeptService;
import com.erp.util.EasyUiResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl  implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    /**
     *
     * @param pageNum 当前页
     * @param pageSize 当前页显示条数
     * @return
     */
    @Override
    public EasyUiResultUtil<Dept> page(int pageNum, int pageSize) {
        return  new EasyUiResultUtil<Dept>(deptMapper.count(),
                deptMapper.page((pageNum - 1) * pageSize, pageSize));

    }

    /**
     *
     * @param dept 增加部门信息
     */
    @Override
    public void add(Dept dept) {
       deptMapper.add(dept);
    }

    @Override
    public Dept findById(Integer id) {
        return deptMapper.findById(id);
    }

    @Override
    public void update(Dept dept) {
        deptMapper.update(dept);
    }

    @Override
    public void remove(Integer[] ids) {
        deptMapper.remove(ids);
    }

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
