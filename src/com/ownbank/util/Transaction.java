package com.ownbank.util;
import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable{
	private int txn_id;
	private String name;
	private String type;
	private double amt;
	private Date d;
	@Override
	public String toString() {
		return "Transaction [txn_id=" + txn_id + ", name=" + name + ", type=" + type + ", amt=" + amt + ", d=" + d
				+ "]";
	}
	public int getTxn_id() {
		return txn_id;
	}
	public void setTxn_id(int txn_id) {
		this.txn_id = txn_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
}
