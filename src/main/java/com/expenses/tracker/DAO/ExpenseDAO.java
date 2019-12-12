package com.expenses.tracker.DAO;

import com.expenses.tracker.entities.Expense;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface ExpenseDAO {
    public Expense findById(int Id);
    public List<Expense> findAll();
    public int insertExpense(Expense expense);
    public void storeFile(MultipartFile file, String directory);
}
