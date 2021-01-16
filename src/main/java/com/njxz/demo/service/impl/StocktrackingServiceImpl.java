package com.njxz.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njxz.demo.domain.Stocktracking;
import com.njxz.demo.repository.StocktrackingRepo;
import com.njxz.demo.service.StocktrackingService;

@Service
public class StocktrackingServiceImpl implements StocktrackingService {

	@Autowired
	StocktrackingRepo stocktrackingRepo;

	@Override
	public List<Stocktracking> queryByTime(Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return stocktrackingRepo.queryByTime(startTime, endTime);
	}

	@Override
	public List<Stocktracking> queryBytrade(List<String> trades) {
		// TODO Auto-generated method stub
		return stocktrackingRepo.queryBytrade(trades);
	}

	@Override
	@Transactional
	public void saveStocktrackings(List<Stocktracking> stocktracking) {
		stocktrackingRepo.saveAll(stocktracking);
	}
	
}
