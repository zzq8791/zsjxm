package com.njxz.demo.controller;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.njxz.demo.domain.Stocktracking;
import com.njxz.demo.domain.Vo.StocktrackingVo;
import com.njxz.demo.service.StocktrackingService;

@Controller
public class StocktrackingController {

	@Autowired
	StocktrackingService stocktrackingService;
	
	
	@RequestMapping("/stockPage")
    public String findBookPage(){
        return "user/stock";
    }
	
	/**
	 * 获取股票列表信息
	 * @return
	 */
	@RequestMapping("/getStockLastSeven")
	public String getStock(Model model){
		try {
			LocalDate local = LocalDate.now();
			List<String> trades = new ArrayList<>();
			for(int i = 8 ; i>0;i--){
				trades.add(local.minusDays(i).toString());
			}
			List<Stocktracking> Stocktrackings = stocktrackingService.queryBytrade(trades);
			List<StocktrackingVo> stocktrackingVo = new ArrayList<>();
			Map<String,StocktrackingVo> voMap = new HashMap<>();
			for(Stocktracking stocktracking : Stocktrackings){
				StocktrackingVo vo = voMap.get(stocktracking.getCode());
				if(vo == null){
					vo = new StocktrackingVo();
					vo.setCode(stocktracking.getCode());
					vo.setCodeName(stocktracking.getCodeName());
					vo.setCount(1);
					voMap.put(stocktracking.getCode(), vo);
				}else{
					vo.setCount(vo.getCount() + 1);
				}
			}
			
			List<StocktrackingVo> list = new ArrayList<>();
			for(StocktrackingVo vv : voMap.values()){
				list.add(vv);
			}
			
			//Collection<StocktrackingVo> vos = voMap.values();
			Collections.sort(list);
			//stocktrackingVo = voMap.values();
			model.addAttribute("stocktrackingVos",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "user/stock";
	}
	
	/**
	 * 导入股票excel表格
	 * @param request
	 * @param file
	 * @return
	 */
	@RequestMapping(value="/importExcel" ,method = RequestMethod.POST)
	@ResponseBody
	public String importExcel(HttpServletRequest request, //
			@RequestParam("file") MultipartFile file){
		try {
			
			List<Stocktracking> stocktrackings = new ArrayList<>();
			String trade = LocalDate.now().minusDays(1).toString();
			Date time = new Date();
			// 转换文件流
			InputStream inFile = (InputStream) file.getInputStream();
			// 创建Excel工作区间
			Workbook book = WorkbookFactory.create(inFile);
			// 读取第一个sheet内容
			Iterator<Row> rowIterator = book.getSheetAt(0).iterator();
			// 记录行号，特定行处理特定，从1开始
			int rowNum = 0;
			// 记录列号，特定行的特定列为特定字段，从1开始
			//int colNum = 0;
			while (rowIterator != null && rowIterator.hasNext()) {
				Row row = rowIterator.next();
				rowNum++;
				if (rowNum > 1) {
					//Iterator<Cell> cellIterator = row.cellIterator();
					
					Stocktracking stocktracking = new Stocktracking();
					stocktracking.setRanking(row.getCell(0).toString());
					stocktracking.setCode(row.getCell(1).toString());
					stocktracking.setCodeName(row.getCell(2).toString());
					stocktracking.setPe(row.getCell(3).toString());
					stocktracking.setPB(row.getCell(4).toString());
					stocktracking.setRadio(row.getCell(5).toString());
					stocktracking.setMarketValue(row.getCell(6).toString());
					stocktracking.setChg(row.getCell(7).toString());
					stocktracking.setHoldStock(row.getCell(8).toString());
					stocktracking.setHoldAmount(row.getCell(9).toString());
					stocktracking.setShareholdingRatio(row.getCell(10).toString());
					stocktracking.setLastOne(row.getCell(12).toString());
					stocktracking.setLastFive(row.getCell(13).toString());
					stocktracking.setTwenty(row.getCell(14).toString());
					stocktracking.setTrade(trade);
					stocktracking.setCreateTime(time);
					stocktrackings.add(stocktracking);
				}
			}
			stocktrackingService.saveStocktrackings(stocktrackings);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
}
