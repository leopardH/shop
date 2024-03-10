package shop;

import lombok.Data;

/**
 * 商品
 * 属性：商品名称/基础价格
 */
@Data
public class Goods {
    private int goodsId;
    private String goodsName;
    private double basicPrice;

    public Goods(String goodsName, double basicPrice) {
        this.goodsName = goodsName;
        this.basicPrice = basicPrice;
    }

}
