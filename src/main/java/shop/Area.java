package shop;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 城市
 * 属性：产地名称/产地商品/价格增幅
 */
@Data
public class Area {
    private int areaId;
    private String name;
    private double x;
    private double y;
    private List<GoodsP> goodsList;

    public Area(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.goodsList = new ArrayList<>();
    }

    public void addGoods(Goods goods, int num, PriceChange change, boolean purchasePermit) {
        GoodsP goodsP = new GoodsP(goods, num, change, purchasePermit);
        goodsList.add(goodsP);
    }
}
