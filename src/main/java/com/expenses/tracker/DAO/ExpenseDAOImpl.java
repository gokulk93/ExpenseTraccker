package com.expenses.tracker.DAO;

import com.expenses.tracker.entities.Expense;
import com.expenses.tracker.exceptions.FileStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ExpenseDAOImpl implements ExpenseDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final String FETCH_QUERY_BY_ID="SELECT * FROM TblExpenses where id=?";
    private final String FETCH_QUERY="SELECT * FROM TblExpenses";
    private final String INSERT_QUERY="INSERT INTO TblExpenses (expenseName, expenseAmount, description,date) VALUES (?,?,?,?)";

    @Override
    public Expense findById(int id) {
        /*List<Expense> expenseList = new ArrayList<Expense>();
        expenseList.add(new Expense(101,"Petrol",500.00,"Petrol for bike", LocalDate.now()));
        expenseList.add(new Expense(102,"Grocessry",1000.00,"Monthly grocessary", LocalDate.now()));
        expenseList.add(new Expense(103,"Food",750.00,"Lunch", LocalDate.now()));

        *//*for(Expense expense : expenseList){
            if(expense.getId()==Id)
                return expense;
        }*//*
        return expenseList.stream().filter(a -> a.getId()==Id).findFirst().orElse(null);
*/
        return jdbcTemplate.queryForObject(FETCH_QUERY_BY_ID,
                                            new Object[] {id},
                                            new BeanPropertyRowMapper<>(Expense.class)); //Bean Property Row Mapper peformance is slower than Row Mapper

    }

    @Override
    public List<Expense> findAll() {
        return jdbcTemplate.query(FETCH_QUERY,
               (ResultSet rs, int rowNum) ->{
                        Expense expense = new Expense();
                        expense.setId(rs.getInt("id"));
                        expense.setExpenseName(rs.getString("expenseName"));
                        expense.setExpenseAmount(rs.getDouble("expenseAmount"));
                        expense.setDescription(rs.getString("description"));
                        expense.setDate(rs.getDate("date").toLocalDate());
                        return expense;
                });
    }

    @Override
    public int insertExpense(Expense expense) {

        return jdbcTemplate.update(INSERT_QUERY,
                                    expense.getExpenseName(),expense.getExpenseAmount(),expense.getDescription(),expense.getDate());
    }

    @Override
    public void storeFile(MultipartFile file, String directory) {
        try{
            Path fileLocation = Paths.get(directory+ File.separator+ StringUtils.cleanPath(file.getOriginalFilename()));

            System.out.println("Location >>>>"+fileLocation);
            System.out.println("File Name >>>>"+StringUtils.cleanPath(file.getOriginalFilename()));
            System.out.println("Directory >>>>"+directory);
            Files.copy(file.getInputStream(),fileLocation, StandardCopyOption.REPLACE_EXISTING);
        }catch(Exception e){
            throw new FileStorageException("Could not store file "+file.getOriginalFilename()+". Please try again later...");
        }

    }
}
