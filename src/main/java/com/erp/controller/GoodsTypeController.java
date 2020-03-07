package com.erp.controller;
import com.erp.pojo.Goods;
import com.erp.pojo.GoodsExample;
import com.erp.pojo.GoodsType;
import com.erp.pojo.GoodsTypeExample;
import com.erp.service.GoodsTypeService;
import com.erp.util.EasyUiResultUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("type")
public class GoodsTypeController {
    @Autowired
    private GoodsTypeService goodsTypeService;

    /**
     * 查询
     * @return
     */
    @RequestMapping("page")
    public EasyUiResultUtil<GoodsType> page(GoodsType goodsType,@RequestParam(defaultValue = "1")int pageNum,
    @RequestParam(defaultValue = "2") int pageSize){
       GoodsTypeExample goodsTypeExample=new GoodsTypeExample();
        GoodsTypeExample.Criteria criteria = goodsTypeExample.createCriteria();
        if (goodsType==null) {
            criteria.andNameIsNotNull();
        }else if(goodsType.getName()!=null&&goodsType.getName()!=""){
            criteria.andNameLike("%"+goodsType.getName()+"%");
        }else if(goodsType.getUuid()!=null){
            criteria.andUuidEqualTo(goodsType.getUuid());
        }
        System.out.println(goodsType.toString());
        int count = goodsTypeService.count(goodsTypeExample);
        PageHelper.startPage(pageNum,pageSize);
        List<GoodsType> page = goodsTypeService.page(goodsTypeExample);
        EasyUiResultUtil<GoodsType> util=new EasyUiResultUtil(count,page);
        return util;
    }
    
    @RequestMapping("add")
    public boolean add(GoodsType goodsType){
        goodsTypeService.add(goodsType);
        return true;
    }
    @RequestMapping("remove")
    public boolean remove(int [] uuid){
        GoodsTypeExample goodsTypeExample=new GoodsTypeExample();
        GoodsTypeExample.Criteria criteria = goodsTypeExample.createCriteria();
        for (int i=0;i<uuid.length;i++){
            criteria.andUuidEqualTo(uuid[i]);
            goodsTypeService.remove(goodsTypeExample);
        }
        return true;
    }

    @RequestMapping("update")
    public boolean update(GoodsType goodsType){
        GoodsTypeExample goodsTypeExample=new GoodsTypeExample();
        GoodsTypeExample.Criteria criteria = goodsTypeExample.createCriteria();
        criteria.andUuidEqualTo(goodsType.getUuid());
        goodsTypeService.update(goodsType,goodsTypeExample);
        return true;
    }
    @RequestMapping("findById")
    public GoodsType findById(int uuid){
        return goodsTypeService.findById(uuid);
    }


}
