package com.erp.service;

import com.erp.pojo.GoodsType;
import com.erp.pojo.GoodsTypeExample;

import java.util.List;

public interface GoodsTypeService {

    /**
     * 查询符合条件的个数
     * @param
     * @return
     */
    int count(GoodsTypeExample goodsTypeExample);

    /**
     * 查询功能
     * @param
     * @return
     */
    List<GoodsType> page(GoodsTypeExample goodsTypeExample);

    /**
     * 增加
     * @param goodsType
     */
    void add(GoodsType goodsType);

    /**
     * 删除
     * @param goodsTypeExample
     */
    void remove(GoodsTypeExample goodsTypeExample);

    /**
     * 修改
     * @param goodsType
     * @param goodsTypeExample
     */
    void update(GoodsType goodsType, GoodsTypeExample goodsTypeExample);

    /**
     * 信息回显
     * @param uuid
     * @return
     */
    GoodsType findById(int uuid);
}
