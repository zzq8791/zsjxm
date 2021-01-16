package com.njxz.demo;

import com.njxz.demo.domain.Stocktracking;
import com.njxz.demo.domain.User;
import com.njxz.demo.mapper.UserMapper;
import com.njxz.demo.repository.StocktrackingRepo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Resource
    private StocktrackingRepo stocktrackingRepo;
    
    public static void main(String[] args) {
    	LocalDate local = LocalDate.now();
		List<String> trades = new ArrayList<>();
//		for(int i = 8 ; i>0;i--){
//			trades.add(local.minusDays(i).toString());
//			System.err.println(local.minusDays(i).toString());
//		}
		
		String trade = LocalDate.now().minusDays(1).toString();
		System.out.println("trade"+trade);
		
		
	}
    
  /*  @Test
   // @Transactional
    public void contextLoads() {

    	Stocktracking Stocktracking = new Stocktracking();
    	Stocktracking.setCode("603734");
    	Stocktracking.setCodeName("仙鹤股份");
    	Stocktracking.setTrade("2020-06-10");
    	Stocktracking.setCreateTime(new Date());
    	stocktrackingRepo.save(Stocktracking);
    	System.err.println("asd"+Stocktracking.getId());
    }*/
    
    @Test
    // @Transactional
     public void query() {

//     	Stocktracking Stocktracking = new Stocktracking();
//     	Stocktracking.setCode("603735");
//     	Stocktracking.setCodeName("仙鹤股份");
//     	Stocktracking.setTrade("2020-06-10");
//     	Stocktracking.setCreateTime(new Date());
     	//Date startTime = 
     	List<String> list = new ArrayList<>();
     	list.add("2020-06-10");
     	list.add("2020-06-09");
     	List<Stocktracking> Stocktrackings = stocktrackingRepo.queryBytrade(list);
     	System.err.println(Stocktrackings.size());
     	for(Stocktracking stock : Stocktrackings){
     		System.out.println(stock.toString());
     	}
     }


}
