package shop;

public class Main {
    public static void main(String[] args) {
        CalculateArea calArea = CalculateArea.getInstance();
        Goods item1 = new Goods("CS大笨蛋", 100);
        Goods item2 = new Goods("鼠饼大人", 10000);
        Area area1 = new Area("武汉", 0, 0);
        Area area2 = new Area("杭州", 100, 100);
        area1.addGoods(item1, 100, PriceChange.INCREASE, true);
        area1.addGoods(item2, 1, PriceChange.INCREASE, false);
        area2.addGoods(item2, 1, PriceChange.INCREASE, false);
        area2.addGoods(item1, 100, PriceChange.DECREASE, true);
        calArea.addProductArea(area1);
        calArea.addProductArea(area2);
        calArea.countAll();
    }
}
