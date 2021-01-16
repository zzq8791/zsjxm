package com.njxz.demo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STOCKTRACKING")
public class Stocktracking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	@Column(name="RANKING")
	private String ranking;
	@Column(name="CODE")
	private String code;
	@Column(name="CODENAME")
	private String codeName;
	@Column(name="PE")
	private String pe;
	@Column(name="PB")
	private String PB;
	@Column(name="RADIO")
	private String radio;
	@Column(name="MARKETVALUE")
	private String marketValue;
	@Column(name="CHG")
	private String chg;
	@Column(name="HOLDSTOCK")
	private String holdStock;
	@Column(name="HOLDAMOUNT")
	private String holdAmount;
	@Column(name="SHAREHOLDINGRATIO")
	private String shareholdingRatio;
	@Column(name="LASTONE")
	private String lastOne;
	@Column(name="LASTFIVE")
	private String lastFive;
	@Column(name="TWENTY")
	private String twenty;
	@Column(name="TRADE")
	private String trade;
	@Column(name="CREATETIME")
	private Date createTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRanking() {
		return ranking;
	}
	public void setRanking(String ranking) {
		this.ranking = ranking;
	}
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
	public String getPe() {
		return pe;
	}
	public void setPe(String pe) {
		this.pe = pe;
	}
	public String getPB() {
		return PB;
	}
	public void setPB(String pB) {
		PB = pB;
	}
	public String getRadio() {
		return radio;
	}
	public void setRadio(String radio) {
		this.radio = radio;
	}
	public String getMarketValue() {
		return marketValue;
	}
	public void setMarketValue(String marketValue) {
		this.marketValue = marketValue;
	}
	public String getChg() {
		return chg;
	}
	public void setChg(String chg) {
		this.chg = chg;
	}
	public String getHoldStock() {
		return holdStock;
	}
	public void setHoldStock(String holdStock) {
		this.holdStock = holdStock;
	}
	public String getHoldAmount() {
		return holdAmount;
	}
	public void setHoldAmount(String holdAmount) {
		this.holdAmount = holdAmount;
	}
	public String getShareholdingRatio() {
		return shareholdingRatio;
	}
	public void setShareholdingRatio(String shareholdingRatio) {
		this.shareholdingRatio = shareholdingRatio;
	}
	public String getLastOne() {
		return lastOne;
	}
	public void setLastOne(String lastOne) {
		this.lastOne = lastOne;
	}
	public String getLastFive() {
		return lastFive;
	}
	public void setLastFive(String lastFive) {
		this.lastFive = lastFive;
	}
	public String getTwenty() {
		return twenty;
	}
	public void setTwenty(String twenty) {
		this.twenty = twenty;
	}
	public String getTrade() {
		return trade;
	}
	public void setTrade(String trade) {
		this.trade = trade;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "Stocktracking [id=" + id + ", ranking=" + ranking + ", code=" + code + ", codeName=" + codeName
				+ ", pe=" + pe + ", PB=" + PB + ", radio=" + radio + ", marketValue=" + marketValue + ", chg=" + chg
				+ ", holdStock=" + holdStock + ", holdAmount=" + holdAmount + ", shareholdingRatio=" + shareholdingRatio
				+ ", lastOne=" + lastOne + ", lastFive=" + lastFive + ", twenty=" + twenty + ", trade=" + trade
				+ ", createTime=" + createTime + "]";
	}
	
	
}
