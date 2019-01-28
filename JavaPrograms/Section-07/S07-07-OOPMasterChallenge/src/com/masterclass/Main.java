package com.masterclass;

public class Main {

    public static void main(String[] args) {
        Burger burger;

        burger = new Burger("White Bread", "Beef", 4.5);
        oln(burger.getBurgerData());
        o("Select 1 "); burger.setSelected1(true);
        o("Select 2 "); burger.setSelected2(true);
        o("Select 3 "); burger.setSelected3(true);
        o("Select 4 "); burger.setSelected4(true);
        o("Set name Fat Boy"); burger.setName("Fat Boy");
        o("\n", false);
        oln(burger.getBurgerData());
        o("Deselect 2 "); burger.setSelected2(false);
        o("Deselect 3 "); burger.setSelected3(false);
        o("\n", false);
        oln(burger.getBurgerData());
        o("------\n", false);

        burger = new HealthyBurger("Beef", 4.5);
        burger.setSelected1(true);
        ((HealthyBurger) burger).setSelected5(true);
        ((HealthyBurger) burger).setSelected6(true);
        o("\n", false);
        oln(burger.getBurgerData());
        o("------\n", false);

        HealthyBurger healthyBurger = new HealthyBurger("Beef", 4.5);
        oln(healthyBurger.getBurgerData());
//        o("Select 1 "); healthyBurger.setSelected1(true);
        o("Select 2 "); healthyBurger.setSelected2(true);
        o("Select 3 "); healthyBurger.setSelected3(true);
//        o("Select 4 "); healthyBurger.setSelected4(true);
        o("Select 5 "); healthyBurger.setSelected5(true);
        o("Select 6 "); healthyBurger.setSelected6(true);
        o("Set name Fat Boy"); healthyBurger.setName("Fat Boy");
        o("\n", false);
        oln(healthyBurger.getBurgerData());
        o("Deselect 2 "); healthyBurger.setSelected2(false);
        o("Deselect 3 "); healthyBurger.setSelected3(false);
        o("Deselect 4 "); healthyBurger.setSelected4(false);
        o("\n", false);
        oln(healthyBurger.getBurgerData());
        o("------\n", false);

        burger = new DeluxeBurger();
        o("Deselect 1 "); ((DeluxeBurger) burger).setSelected1(false);
        o("Deselect 2 "); ((DeluxeBurger) burger).setSelected2(false);
        o("Set name Fat Boy"); ((DeluxeBurger) burger).setName("Fat Boy");
        o("\n", false);
        oln(burger.getBurgerData());
        o("------\n", false);


    }
    private static void o(String text) {
        System.out.print("- " + text);
    }
    private static void o(String text, boolean prefix) {
        System.out.print((prefix ? "- " : "") + text);
    }
    private static void oln(String text) {
        System.out.println("= " + text);
    }
}
