package com.vthinkDynamics.expensetrackerapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vthinkDynamics.expensetrackerapi.entity.Expense;


@Service
public interface ExpenseService {

	List<Expense> getAllExpenses();

	Expense getExpenseByID(Long id);

	String deleteExpenseByID(Long id);

	Expense saveExpenseDetails(Expense expense);

	Expense updateExpenseDetails(Long id, Expense expene);
}
