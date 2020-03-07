package com.erp.service;

import com.erp.pojo.Goods;
import com.erp.pojo.GoodsExample;
import com.erp.pojo.GoodsType;
import com.erp.util.EasyUiResultUtil;

import java.util.List;

public interface GoodsService {
    /**
     *
     * @return 显示全部商品 信息和所属类别
     */

    public List<Goods> page(GoodsExample goodsExample);

    public int count(GoodsExample goodsExample);

    /**
     * 增加方法
     * @param
     */
    public void add(Goods goods);

    /**
     * 修改方法
     * @param goodsExample
     */
    public void update(Goods goods,GoodsExample goodsExample);

    /**
     * 删除方法
     * @param goodsExample
     */
    public void remove(GoodsExample goodsExample);

    /**
     * 修改界面的信息回显
     * @param
     * @return
     */
    Goods findById(int uuid);

    /**
     * c查询商品类别
     * @return
     */
    List<GoodsType> rightFindAll();
}
