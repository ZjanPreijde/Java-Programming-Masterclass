package com.masterclass;

public class HealthyBurger extends Burger {
    private Addition addition5 = new Addition("Mayonaise", 2);
    private Addition addition6 = new Addition("Ketchup", 2);
    private boolean selected5, selected6;

    public HealthyBurger(String meat, double price) {
        super("Brown rye", meat, price, "Healthy");
    }

    public boolean isSelected5() { return selected5; }
    public boolean isSelected6() { return selected6; }

    public void setSelected5(boolean selected5) { this.selected5 = selected5; }
    public void setSelected6(boolean selected6) { this.selected6 = selected6; }

    @Override
    public void setName(String name) { /* name can not be changed */ }

    @Override
    public double getAddPrice() {
        return super.getAddPrice()
                + (isSelected5() ? addition5.getPrice() : 0)
                + (isSelected6() ? addition6.getPrice() : 0);
    }
    @Override
    public String getAddDesc() {
        return super.getAddDesc()
                + (isSelected5() ? " + " + addition5.getDesc() + "(" + addition5.getPrice() + ")" : "")
                + (isSelected6() ? " + " + addition6.getDesc() + "(" + addition6.getPrice() + ")" : "");
    }
}
