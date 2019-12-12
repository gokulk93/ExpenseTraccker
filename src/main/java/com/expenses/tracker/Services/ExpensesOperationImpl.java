package com.expenses.tracker.Services;

import com.expenses.tracker.DAO.ExpenseDAO;
import com.expenses.tracker.entities.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpensesOperationImpl implements ExpensesOperation {
    @Autowired
    ExpenseDAO expenseDAO;


    @Override
    public String addNewExpense(Expense expense) {
        if(expenseDAO.insertExpense(expense)<=0)
            return "fails";
        return "success";
    }

    @Override
    public String viewReportByDate(LocalDate date) {
        return null;
    }

    @Override
    public Expense viewById(int id) {

        return expenseDAO.findById(id);
    }

    @Override
    public List<Expense> showAll() {

        return expenseDAO.findAll();
    }

    @Override
    public void uploadSingleFile(MultipartFile file) {
        final String directory="C:\\Users\\gkumar24\\Desktop\\report\\";
        expenseDAO.storeFile(file,directory);

    }
}
