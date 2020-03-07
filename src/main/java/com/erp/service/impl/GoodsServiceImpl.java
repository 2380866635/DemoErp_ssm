package com.erp.service.impl;

import com.erp.mapper.GoodsMapper;
import com.erp.mapper.GoodsTypeMapper;
import com.erp.pojo.Goods;
import com.erp.pojo.GoodsExample;
import com.erp.pojo.GoodsType;
import com.erp.service.GoodsService;
import com.erp.util.EasyUiResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class GoodsServiceImpl implements GoodsService {
@Autowired
private GoodsMapper goodsMapper;
@Autowired
private GoodsTypeMapper goodsTypeMapper;


    @Override
    public List<Goods> page(GoodsExample goodsExample) {
        return  goodsMapper.selectByExample(goodsExample);

    }

    @Override
    public int count(GoodsExample goodsExample) {
        return (int) goodsMapper.countByExample(goodsExample);
    }


    @Override
    public void add(Goods goods) {
        goodsMapper.insert(goods);
    }

    @Override
    public void update(Goods goods,GoodsExample goodsExample) {
            goodsMapper.updateByExample(goods,goodsExample);
    }

    @Override
    public void remove(GoodsExample goodsExample) {
            goodsMapper.deleteByExample(goodsExample);
    }

    @Override
    public Goods findById(int uuid) {
        return goodsMapper.selectByPrimaryKey(uuid);
    }

    @Override
    public List<GoodsType> rightFindAll() {
        return  goodsTypeMapper.selectByExample(null);

    }

}
