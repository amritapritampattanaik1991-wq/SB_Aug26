package com.jt.expense_tracker;

import java.util.List

import org.springframework.http.HttpStatus;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ExpenseController {
  private final ExpenseService expenseService;
  private final JdbcTemplate jdbcTemplate;
  private final ExpenseRepository expenseRepository;
  private static final String EXPENSES_TABLE = "expenses";

  ExpenseController(ExpenseService expenseService) {
    this.expenseService = expenseService;
  }

  @GetMapping("/expense")
  public List<Expense> getExpenses() {
    return expenseService.getExpenses();
  }
  
  @GetMapping("/expense/{id}")
  public Expense getExpenseById(@PathVariable int id) {
      return expenseService.getExpenseById(id);
 }
  
  @PostMapping("/expense")
  @ResponseStatus(code = HttpStatus.CREATED)
  public Expense createExpense(@RequestBody Expense expense) {
    
    return expenseService.addExpense(expense);
  }
  
  @DeleteMapping("/expense/{id}")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void deleteExpense(@PathVariable int id) {
    expenseService.deleteExpenseById(id);
  

  }

  @PutMapping("/expense")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public Expense updateExpense(@RequestBody Expense expense) {
  
  
  return expenseService.updaExpense(expense);
  }
}

