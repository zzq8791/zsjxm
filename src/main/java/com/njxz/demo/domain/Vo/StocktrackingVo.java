package com.njxz.demo.domain.Vo;

public class StocktrackingVo implements Comparable<StocktrackingVo>{

	private String code;
	private String codeName;
	private int count;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public int compareTo(StocktrackingVo o) {
		// TODO Auto-generated method stub
		return o.count - this.count;
	}
	
	
	
	
}
