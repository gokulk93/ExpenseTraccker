package com.expenses.tracker.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Expense {
    private int id;
    private String expenseName;
    private double expenseAmount;
    private String description;
    private LocalDate date;

    public Expense() {
    }

    public Expense(int id, String expenseName, double expenseAmount, String description, LocalDate date) {
        this.id = id;
        this.expenseName = expenseName;
        this.expenseAmount = expenseAmount;
        this.description = description;
        this.date = date;
    }
    public Expense(String expenseName, double expenseAmount, String description, LocalDate date) {

        this.expenseName = expenseName;
        this.expenseAmount = expenseAmount;
        this.description = description;
        this.date = date;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
