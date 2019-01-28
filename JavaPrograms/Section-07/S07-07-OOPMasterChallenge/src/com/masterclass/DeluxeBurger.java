package com.masterclass;

public class DeluxeBurger extends Burger {
    public DeluxeBurger() {
        super("White", "Sausage & Bacon", 14.54, "Deluxe");
        super.setAddition1(new Addition("Chips", 2.75));
        super.setAddition2(new Addition("Drink", 1.75));
        super.setSelected1(true);
        super.setSelected2(true);
    }

    @Override
    public void setName(String name) {}
    @Override
    public void setSelected1(boolean selected1) { }
    @Override
    public void setSelected2(boolean selected2) { }
    @Override
    public void setSelected3(boolean selected3) { }
    @Override
    public void setSelected4(boolean selected4) { }
    @Override
    public void setAddition1(Addition addition) { }
    @Override
    public void setAddition2(Addition addition) { }

}
