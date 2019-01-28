package com.masterclass;

public class Burger {
    private String rollType, meat, name;
    private double price;
    private boolean selected1,selected2,selected3,selected4;
    private Addition addition1 = new Addition("Lettuce", 1.5);
    private Addition addition2 = new Addition("Tomato", 2);
    private Addition addition3 = new Addition("Cheese", 2.5);
    private Addition addition4 = new Addition("Pickles", 3);

    public Burger(String rollType, String meat, double price) {
        this(rollType, meat, price, "");
    }
    public Burger(String rollType, String meat, double price, String name) {
        this.rollType  = rollType;
        this.meat      = meat;
        this.price     = price;
        this.name      = name;
    }

    public void setName(String name) { this.name = name; }
    public void setSelected1(boolean selected1) { this.selected1 = selected1; }
    public void setSelected2(boolean selected2) { this.selected2 = selected2; }
    public void setSelected3(boolean selected3) { this.selected3 = selected3; }
    public void setSelected4(boolean selected4) { this.selected4 = selected4; }
    public void setAddition1(Addition addition) { this.addition1 = addition; }
    public void setAddition2(Addition addition) { this.addition2 = addition; }

    public String getName()      { return (name == "") ? "" : name + " "; }
    public String getRollType() { return rollType; }
    public String getMeat()     { return meat; }
    public double getPrice()    { return price; }
    public double getAddPrice() {
        return (isSelected1() ? addition1.getPrice() : 0)
                + (isSelected2() ? addition2.getPrice() : 0)
                + (isSelected3() ? addition3.getPrice() : 0)
                + (isSelected4() ? addition4.getPrice() : 0);
    }
    public String getAddDesc() {
        return (isSelected1() ? " + " + addition1.getDesc() + "(" + addition1.getPrice() + ")" : "")
                + (isSelected2() ? " + " + addition2.getDesc() + "(" + addition2.getPrice() + ")" : "")
                + (isSelected3() ? " + " + addition3.getDesc() + "(" + addition3.getPrice() + ")" : "")
                + (isSelected4() ? " + " + addition4.getDesc() + "(" + addition4.getPrice() + ")" : "");
    }

    public String getBurgerData() {
        return "Burger " + getName() + "(" + getPrice() + ") -> "
                + meat + " on " + rollType + " roll " + getAddDesc()
                + ", price " + (getPrice() + getAddPrice());
    }

    private boolean isSelected1() { return selected1; }
    private boolean isSelected2() { return selected2; }
    private boolean isSelected3() { return selected3; }
    private boolean isSelected4() { return selected4; }

}
