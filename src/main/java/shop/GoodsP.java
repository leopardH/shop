package shop;

import lombok.Data;

@Data
public class GoodsP {
    private Goods goods;
    private int num;
    private double pricesFluctuate;
    private PriceChange change;
    private boolean purchasePermit;

    public GoodsP(Goods goods, int num, PriceChange change, boolean purchasePermit) {
        this.goods = goods;
        this.num = num;
        this.pricesFluctuate = 1;
        this.purchasePermit = purchasePermit;
        updateFluctuate(change);
    }

    /**
     * 获取商品当前价格
     *
     * @return
     */
    public double getGoodsPrice() {
        return goods.getBasicPrice() * pricesFluctuate;
    }

    /**
     * 校验价格浮动
     */
    private void checkFluctuate() {
        if (this.pricesFluctuate > Constant.maxFluctuate) {
            this.pricesFluctuate = Constant.maxFluctuate;
        } else if (this.pricesFluctuate < Constant.minFluctuate) {
            this.pricesFluctuate = Constant.minFluctuate;
        }
    }

    /**
     * 更新价格浮动
     */
    private void updateFluctuate(PriceChange change) {
        this.change = change;
        double randomNum = Math.random() / 10;
        switch (change) {
            case DECREASE -> {
                pricesFluctuate -= randomNum;
            }
            case INCREASE -> {
                pricesFluctuate += randomNum;
            }
        }
        checkFluctuate();
    }
}
