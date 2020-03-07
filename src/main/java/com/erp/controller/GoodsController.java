package com.erp.controller;

import com.erp.pojo.Goods;
import com.erp.pojo.GoodsExample;
import com.erp.pojo.GoodsType;
import com.erp.service.GoodsService;
import com.erp.util.EasyUiResultUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("page")
    public EasyUiResultUtil<Goods> page(Goods goods, @RequestParam(defaultValue = "1") int pageNum,
                                        @RequestParam(defaultValue = "2") int pageSize){
        GoodsExample goodsExample=new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        if (goods==null) {
            criteria.andInPriceIsNotNull();
        }else if(goods.getName()!=null&&goods.getName()!=""){
            criteria.andNameLike("%"+goods.getName()+"%");
        }else if(goods.getOrigin()!=null&&goods.getOrigin()!=""){
            criteria.andOriginLike("%"+goods.getOrigin()+"%");
        }else if(goods.getProducer()!=null&&goods.getProducer()!=""){
            criteria.andProducerLike("%"+goods.getProducer()+"%");
        }

        System.out.println(goods.toString());
        int count = goodsService.count(goodsExample);
        PageHelper.startPage(pageNum,pageSize);
        List<Goods> page = goodsService.page(goodsExample);
        EasyUiResultUtil util =new EasyUiResultUtil(count,page);
        return util;
    }

    /**
     * 修改界面的信息回显
     * @param uuid
     * @return
     */
    @RequestMapping("findById")
    public Goods findById(int uuid){
       return goodsService.findById(uuid);
    }

    /**
     *
     * @param goods
     * @return 增加方法
     */
    @RequestMapping("add")
    public boolean add(Goods goods){
        goodsService.add(goods);
        return  true;
    }

    /**
     * 根据uuid进行修改
     * @param goods
     * @return
     */
    @RequestMapping("update")
    public boolean update(Goods goods){
        GoodsExample goodsExample=new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        criteria.andUuidEqualTo(goods.getUuid());
        goodsService.update(goods,goodsExample);
        return true;
    }
    @RequestMapping("rightFindAll")
    public List<GoodsType> rightFindAll(){
        return goodsService.rightFindAll();
    }

    //删除
    @RequestMapping("remove")
    public boolean remove(Integer[] uuid){
        GoodsExample goodsExample=new GoodsExample();
        GoodsExample.Criteria criteria = goodsExample.createCriteria();
        for (int i=0;i<uuid.length;i++){
            criteria.andUuidEqualTo(uuid[i]);
            goodsService.remove(goodsExample);
        }
        return  true;
    }


    
}
