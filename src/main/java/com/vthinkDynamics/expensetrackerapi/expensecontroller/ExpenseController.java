package com.vthinkDynamics.expensetrackerapi.expensecontroller;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vthinkDynamics.expensetrackerapi.entity.Expense;
import com.vthinkDynamics.expensetrackerapi.services.ExpenseService;

@RestController
public class ExpenseController {
	@Autowired
	private ExpenseService expservice;
	
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses()
	{
		return expservice.getAllExpenses();
	}
	
	@GetMapping("/expenses/{id}")
	public Expense getExpenseByID(@PathVariable Long id)
	{
		return expservice.getExpenseByID(id);
	}
	
	@DeleteMapping("/expenses")
	public String deleteExpenseByID(@RequestParam("id") Long id)
	{
	return expservice.deleteExpenseByID(id);
	}

	@ResponseStatus(value=HttpStatus.CREATED)
	@PostMapping("/expenses")
	public Expense saveExpenseDetails(@RequestBody Expense expense)
	{
		return  expservice.saveExpenseDetails(expense);
		
		
	}
	
	@PutMapping("/expenses/{id}")
	public Expense updateExpenseDetails(@RequestBody Expense expene ,@PathVariable Long id)
	{
		return expservice.updateExpenseDetails(id ,expene);
	}
	
	
	
	
	
	
}
