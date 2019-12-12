package com.expenses.tracker.controller;


import com.expenses.tracker.Services.ExpensesOperation;
import com.expenses.tracker.entities.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@RestController
@RequestMapping("/expenseController")
public class ExpenseController {
    @Autowired
    ExpensesOperation expensesOperation;


//    HTTP.GET request with 1 parameter
    @GetMapping(path= "/getById", produces = "application/json")
    public Expense getExpenseDetails(@RequestParam(name="id") int id){
        return expensesOperation.viewById(id);
    }

//    HTTP.GET request with no parameter
    @GetMapping(path= "/getReport", produces = "application/json")
    public List<Expense> getReport(){
        return expensesOperation.showAll();
    }

//    HTTP.POST method with form data


    @PostMapping(path = "/addExpense", produces = "application/json")
    public String addExpense(@RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
                             @RequestHeader(name = "X-COM-LOCATION", defaultValue = "ASIA") String headerLocation,
                             @RequestBody Expense newExpense){return expensesOperation.addNewExpense(newExpense);}

//    HTTP.POST method for file uploading
    @PostMapping(path = "/uploadFile")
    public String uploadFile(@RequestParam("file")MultipartFile file, RedirectAttributes redirectAttributes){
        expensesOperation.uploadSingleFile(file);
        return "Success";
    }
}
