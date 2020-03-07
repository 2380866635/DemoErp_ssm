package com.erp.service.impl;

import com.erp.mapper.PremissionMapper;
import com.erp.service.PremissionService;
import com.erp.util.TreeResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PremissionServiceImpl implements PremissionService {
    @Autowired
    private PremissionMapper premissionMapper;
    @Override
    public List<TreeResultUtil> list() {
        return premissionMapper.list();
    }
}
