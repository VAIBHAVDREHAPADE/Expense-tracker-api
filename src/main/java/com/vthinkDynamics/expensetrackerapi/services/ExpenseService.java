package com.vthinkDynamics.expensetrackerapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vthinkDynamics.expensetrackerapi.entity.Expense;


@Service
public interface ExpenseService {

	Page<Expense> getAllExpenses(Pageable page);

	Expense getExpenseByID(Long id);

	String deleteExpenseByID(Long id);

	Expense saveExpenseDetails(Expense expense);

	Expense updateExpenseDetails(Long id, Expense expene);
	
	List<Expense> readByCategory(String category , Pageable page);
	
	
	
}
