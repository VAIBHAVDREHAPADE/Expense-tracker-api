package com.vthinkDynamics.expensetrackerapi.expensecontroller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vthinkDynamics.expensetrackerapi.entity.Expense;
import com.vthinkDynamics.expensetrackerapi.services.ExpenseService;

@RestController
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	
	@GetMapping("/expenses")
	public Page<Expense> getAllExpenses(Pageable page)
	{
		return expenseService.getAllExpenses(page);
	}
	
	@GetMapping("/expenses/{id}")
	public Expense getExpenseByID(@PathVariable Long id)
	{
		return expenseService.getExpenseByID(id);
	}
	
	@DeleteMapping("/expenses")
	public String deleteExpenseByID(@RequestParam("id") Long id)
	{
	return expenseService.deleteExpenseByID(id);
	}

	@ResponseStatus(value=HttpStatus.CREATED)
	@PostMapping("/expenses")
	public Expense saveExpenseDetails(@Validated @RequestBody Expense expense)
	{
		return  expenseService.saveExpenseDetails(expense);
	}
	
	@PutMapping("/expenses/{id}")
	public Expense updateExpenseDetails(@RequestBody Expense expene ,@PathVariable Long id)
	{
		return expenseService.updateExpenseDetails(id ,expene);
	}
	
	@GetMapping("expenses/category")
	List<Expense> getExpenceByCategory(@RequestParam String Category ,Pageable page)
	{
		return expenseService.readByCategory(Category ,page);
	}
	
	
	
}
