package com.expenses.tracker.Services;

import com.expenses.tracker.entities.Expense;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;


public interface ExpensesOperation {
    public String addNewExpense(Expense expense);
    public String viewReportByDate(LocalDate date);
    public Expense viewById(int id);
    public List<Expense> showAll();
    public void uploadSingleFile(MultipartFile file);
}
