package com.vthinkDynamics.expensetrackerapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vthinkDynamics.expensetrackerapi.entity.Expense;
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	//select * from tbl_expenses where category =?
	Page<Expense> findByCategory(String category, Pageable page);
}
