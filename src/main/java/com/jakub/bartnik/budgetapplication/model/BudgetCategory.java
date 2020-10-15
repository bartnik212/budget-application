package com.jakub.bartnik.budgetapplication.model;

public enum BudgetCategory {

    RENT ("Czynsz"),
    FOOD ("Jedzenie"),
    BILLS ("Rachunki"),
    TRANSPORT ("Transport"),
    HAIRDRESSER ("Fryzjer"),
    OTHERS ("Inne");

    private final String name;

    BudgetCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
