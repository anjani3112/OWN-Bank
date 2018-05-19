package com.ownbank.util;

import java.io.Serializable;

public class User implements Serializable{
	
	private String name;
	private int pin;
	private double blnc;
	private long accountNo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public double getBlnc() {
		return blnc;
	}
	public void setBlnc(double blnc) {
		this.blnc = blnc;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", pin=" + pin + ", blnc=" + blnc + ", accountNo=" + accountNo + "]";
	}
}
