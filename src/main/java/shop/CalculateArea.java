package shop;

import java.util.ArrayList;
import java.util.List;

public class CalculateArea {
    private List<Area> areaList;

    private CalculateArea() {
    }

    public static CalculateArea getInstance() {
        return ClassInner.area;
    }

    public void addProductArea(Area area) {
        if (areaList == null) {
            areaList = new ArrayList<>();
        }
        areaList.add(area);
    }

    public void priceGapCal(Area source, Area target) {
        double distance = calDistance(source, target);
        double proportion = distance / 100 * Constant.increasePer100mile + 1;
        for (GoodsP temp : source.getGoodsList()) {
            if (!temp.isPurchasePermit()) {
                continue;
            }
            for (GoodsP targetTemp : target.getGoodsList()) {
                if (targetTemp.getGoods().getGoodsName().equals(temp.getGoods().getGoodsName())) {
                    double sourcePrice = temp.getGoodsPrice() * proportion;
                    double targetPrice = targetTemp.getGoodsPrice();
                    System.out.print("差价：");
                    System.out.print(sourcePrice - targetPrice);
                    System.out.println();
                }
            }
        }
    }

    public void countAll() {
        for (Area area : areaList) {
            for (Area area1 : areaList) {
                if (!area.getName().equals(area1.getName())) {
                    priceGapCal(area, area1);
                }
            }
        }
    }

    public double calDistance(Area source, Area target) {
        double sourceX = source.getX();
        double sourceY = source.getY();
        double targetX = target.getX();
        double targetY = target.getY();

        return Math.sqrt((sourceX - targetX) * (sourceX - targetX) + (targetY - sourceY) * (targetY - sourceY));
    }

    private static class ClassInner {

        private static final CalculateArea area = new CalculateArea();
    }
}
