package com.masterclass;

public class Main {

    public static void main(String[] args) {
        Burger burger;

        oln("* burger = new Burger(\"White\", \"Beef\", 4.5)", false);
        burger = new Burger("White", "Beef", 4.5);
        oln(burger.getBurgerData());
        o("Select 1 "); burger.setSelected1(true);
        o("Select 2 "); burger.setSelected2(true);
        o("Select 3 "); burger.setSelected3(true);
        o("Select 4 "); burger.setSelected4(true);
        o("Set name Fat Boy"); burger.setName("Fat Boy");
        o("", false, true);
        oln(burger.getBurgerData());
        o("Deselect 2 "); burger.setSelected2(false);
        o("Deselect 3 "); burger.setSelected3(false);
        o("", false, true);
        oln(burger.getBurgerData());
        o("------", false, true);

        oln("* burger = new HealthyBurger(\"Chicken\", 4.5)", false);
        burger = new HealthyBurger("Chicken", 4.5);
        o("Select 1 "); burger.setSelected1(true);
        o("Select 3 "); burger.setSelected3(true);
        o("Select 5 "); ((HealthyBurger) burger).setSelected5(true);
        o("Select 6 "); ((HealthyBurger) burger).setSelected6(true);
        o("", false, true);
        oln(burger.getBurgerData());
        o("------", false, true);

        oln("* HealthyBurger healthyBurger = new HealthyBurger(\"Beef\", 4.5)", false);
        HealthyBurger healthyBurger = new HealthyBurger("Beef", 4.5);
        oln(healthyBurger.getBurgerData());
        o("Select 1 "); healthyBurger.setSelected1(true);
        o("Select 2 "); healthyBurger.setSelected2(true);
        o("Select 3 "); healthyBurger.setSelected3(true);
        o("Select 4 "); healthyBurger.setSelected4(true);
        o("Select 5 "); healthyBurger.setSelected5(true);
        o("Select 6 "); healthyBurger.setSelected6(true);
        o("Set name Fat Boy"); healthyBurger.setName("Fat Boy");
        o("", false, true);
        oln(healthyBurger.getBurgerData());
        o("Deselect 2 "); healthyBurger.setSelected2(false);
        o("Deselect 3 "); healthyBurger.setSelected3(false);
        o("Deselect 4 "); healthyBurger.setSelected4(false);
        o("", false, true);
        oln(healthyBurger.getBurgerData());
        o("------", false, true);

        oln("* burger = new DeluxeBurger()", false);
        burger = new DeluxeBurger();
        o("Deselect 1 "); ((DeluxeBurger) burger).setSelected1(false);
        o("Deselect 2 "); ((DeluxeBurger) burger).setSelected2(false);
        o("Set name Fat Boy"); ((DeluxeBurger) burger).setName("Fat Boy");
        o("\n", false);
        oln(burger.getBurgerData());
        o("------", false, true);
    }

    private static void o(String text) {
        System.out.print("- " + text);
    }
    private static void o(String text, boolean prefix) {
        System.out.print((prefix ? "- " : "") + text);
    }
    private static void o(String text, boolean prefix, boolean newLine) {
        System.out.print((prefix ? "- " : "") + text + (newLine ? "\n" : "" ));
    }
    private static void oln(String text) {
        System.out.println("= " + text);
    }
    private static void oln(String text, boolean prefix) {
        System.out.println((prefix ? "= " : "") + text);
    }
}
