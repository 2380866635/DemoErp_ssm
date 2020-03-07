package com.erp.controller;

import com.erp.service.PremissionService;
import com.erp.util.TreeResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("text")
public class PremissionController {
    @Autowired
    private PremissionService premissionService;
    @RequestMapping("premissionList")
    public List<TreeResultUtil> list() {
        return premissionService.list();
    }


}
