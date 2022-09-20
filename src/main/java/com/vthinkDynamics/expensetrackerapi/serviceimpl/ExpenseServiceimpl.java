package com.vthinkDynamics.expensetrackerapi.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vthinkDynamics.expensetrackerapi.entity.Expense;
import com.vthinkDynamics.expensetrackerapi.repository.ExpenseRepository;
import com.vthinkDynamics.expensetrackerapi.services.ExpenseService;
@Service
public class ExpenseServiceimpl implements ExpenseService {

	@Autowired
	ExpenseRepository expenseRepo;
	
	@Override
	public List<Expense> getAllExpenses() {
		
		return expenseRepo.findAll();
	}

	@Override
	public Expense getExpenseByID(Long id) {
		Optional<Expense> expense = expenseRepo.findById(id);
		if(expense.isPresent()) {
			return expense.get();
		}
		throw new RuntimeException("ID is not found in DB");
	}

	@Override
	public String deleteExpenseByID(Long id) {
		 expenseRepo.deleteById(id);
		 return "Record deleted";
	}

	@Override
	public Expense saveExpenseDetails(Expense expense) {
		return expenseRepo.save(expense);
	}

	@Override
	public Expense updateExpenseDetails(Long id, Expense expene) {
		Expense ExExpenceObj = getExpenseByID(id);
		ExExpenceObj.setName(expene.getName() != null ? expene.getName() : ExExpenceObj.getName());
		ExExpenceObj.setDescription(expene.getDescription() != null ? expene.getDescription() : ExExpenceObj.getDescription());
		ExExpenceObj.setCategory(expene.getCategory() != null ? expene.getCategory() : ExExpenceObj.getCategory());
		ExExpenceObj.setAmount(expene.getAmount() != null ? expene.getAmount() : ExExpenceObj.getAmount());
		ExExpenceObj.setDate(expene.getDate() != null ? expene.getDate() : ExExpenceObj.getDate());
		return expenseRepo.save(ExExpenceObj);
	}
	
	
	
	
	
	
	

}
