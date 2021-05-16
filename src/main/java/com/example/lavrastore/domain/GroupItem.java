package com.example.lavrastore.domain;
import java.io.Serializable;
import com.example.lavrastore.domain.Item;

@SuppressWarnings("serial")
public class GroupItem implements Serializable {
	
	Item gitem;
	String regiDate;
	String payDate;
	int nowBalance;
	int targetBalance;
	double percent; // nowB / targetB
	int status; //0 : 진행 1 : 마감-성공 2: 마감-실패
	
	
	public Item getGitem() {
		return gitem;
	}
	public void setGitem(Item gitem) {
		this.gitem = gitem;
	}
	public String getRegiDate() {
		return regiDate;
	}
	public void setRegiDate(String regiDate) {
		this.regiDate = regiDate;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public int getNowBalance() {
		return nowBalance;
	}
	public void setNowBalance(int nowBalance) {
		this.nowBalance = nowBalance;
	}
	public int getTargetBalance() {
		return targetBalance;
	}
	public void setTargetBalance(int targetBalance) {
		this.targetBalance = targetBalance;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public double getPercent() {
		return percent;
	}
	public void setStatus() {
		this.percent = nowBalance / (double) targetBalance;
	}
	
}
