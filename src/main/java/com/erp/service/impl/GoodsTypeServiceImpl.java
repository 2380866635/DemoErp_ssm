package com.erp.service.impl;

import com.erp.mapper.GoodsTypeMapper;
import com.erp.pojo.GoodsType;
import com.erp.pojo.GoodsTypeExample;
import com.erp.service.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsTypeServiceImpl  implements GoodsTypeService {
    @Autowired
    private GoodsTypeMapper goodsTypeMapper;
    @Override
    public int count(GoodsTypeExample goodsTypeExample) {
        return (int) goodsTypeMapper.countByExample(goodsTypeExample);
    }

    @Override
    public List<GoodsType> page(GoodsTypeExample goodsTypeExample) {
        return goodsTypeMapper.selectByExample(goodsTypeExample);
    }

    @Override
    public void add(GoodsType goodsType) {
        goodsTypeMapper.insert(goodsType);
    }

    @Override
    public void remove(GoodsTypeExample goodsTypeExample) {
        goodsTypeMapper.deleteByExample(goodsTypeExample);
    }

    @Override
    public void update(GoodsType goodsType, GoodsTypeExample goodsTypeExample) {
        goodsTypeMapper.updateByExample(goodsType,goodsTypeExample);
    }

    @Override
    public GoodsType findById(int uuid) {
        return goodsTypeMapper.selectByPrimaryKey(uuid);
    }
}
