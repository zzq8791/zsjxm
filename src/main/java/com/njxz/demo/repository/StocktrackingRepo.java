package com.njxz.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.njxz.demo.domain.Stocktracking;

public interface StocktrackingRepo extends JpaRepository<Stocktracking, Integer> {

	@Query("select s from Stocktracking s where s.createTime between ?1 and ?2")
	List<Stocktracking> queryByTime(Date startTime , Date endTime);
	
	@Query("select s from Stocktracking s where s.trade in (?1)")
	List<Stocktracking> queryBytrade(List<String> trades);
	
}
