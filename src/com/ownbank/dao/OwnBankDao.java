package com.ownbank.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collections;

import com.ownbank.util.SortByTxn_id;
import com.ownbank.util.Transaction;
import com.ownbank.util.User;
public class OwnBankDao {
	private static Connection con;
	private static CallableStatement cs;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private static User user;
	private static String query;
	static {
		try {
			con=ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String transfer(long beneficiary,long payee,Double amount) {
		query="{call transfer(?,?,?,?)}";
		if(con!=null) {
			try {
				cs=con.prepareCall(query);
				cs.registerOutParameter(4, Types.VARCHAR);
				cs.setLong(1, beneficiary);
				cs.setLong(2, payee);
				cs.setDouble(3, amount);
				cs.execute();
				return cs.getString(4);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "Connection Unsuccessful";
	}
	public String withdraw(long payee,Double amount) {
		query="{call withdraw(?,?,?)}";
		if(con!=null) {
			try {
				cs=con.prepareCall(query);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.setLong(1, payee);
				cs.setDouble(2, amount);
				cs.execute();
				return cs.getString(3);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "Connection Unsuccessful";
	}
	public String deposit(long payee,Double amount) {
		query="{call deposit(?,?,?)}";
		if(con!=null) {
			try {
				cs=con.prepareCall(query);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.setLong(1, payee);
				cs.setDouble(2, amount);
				cs.execute();
				return cs.getString(3);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return "Connection Unsuccessful";
	}
	public User login(String id ,String password) {
		query="select account_number,first_name,last_name,pin,amount from user_details where email_id=? and password=?";
		if(con!=null) {
			try {
				ps=con.prepareStatement(query);
				ps.setString(1,id);
				ps.setString(2, password);
				rs=ps.executeQuery();
				if(rs.next()) {
					user=new User();
					user.setAccountNo(rs.getLong(1));
					user.setName(rs.getString(2)+" "+rs.getString(3));
					user.setPin(rs.getInt(4));
					user.setBlnc(rs.getDouble(5)*1.00);
					return user;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public boolean registerUser(String fn,String ln,int pin,String pass,double amt,String id,int age,long phno) {
		query="insert into user_details values(acc_no.nextval,?,?,?,?,?,?,?,?)";
		if(con!=null) {
			try {
				ps=con.prepareStatement(query);
				ps.setString(1,fn);
				ps.setString(2,ln);
				ps.setInt(3, age);
				ps.setLong(4, phno);
				ps.setString(5, pass);
				ps.setInt(6, pin);
				ps.setString(7, id);
				ps.setDouble(8, amt);
				int k=ps.executeUpdate();
				if(k>0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public String setting(int pin, long accno) {
		query="update user_details set pin=? where account_number=?";
			try {
				ps=con.prepareStatement(query);
				ps.setInt(1,pin);
				ps.setLong(2,accno);
				int k=ps.executeUpdate();
				if(k==1)
					return "Successful";
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return "Failed";
	}
	public ArrayList<Transaction> transactions(long acc) {
		ArrayList<Transaction> al=new ArrayList<Transaction>();
		try {
			ps=con.prepareStatement("select w.transaction_id,a.first_name||' '||a.last_name,w.amount,w.txn_date from transaction_withdraw w,user_details a where w.account_number=? and a.account_number=w.benfeciary");
		ps.setLong(1, acc);
		rs=ps.executeQuery();
		while(rs.next()) {
			Transaction t=new Transaction();
			t.setTxn_id(rs.getInt(1));
			t.setName(rs.getString(2));
			t.setAmt(rs.getDouble(3));
			t.setD(rs.getDate(4));
			t.setType("Debit");
			al.add(t);
		}
		ps=con.prepareStatement("select w.transaction_id,a.first_name||' '||a.last_name,w.amount,w.txn_date from transaction_deposit w,user_details a where w.account_number=? and a.account_number=w.creditor");
		ps.setLong(1, acc);
		ResultSet rsd=ps.executeQuery();
		while(rsd.next()) {
			Transaction t=new Transaction();
			t.setTxn_id(rsd.getInt(1));
			t.setName(rsd.getString(2));
			t.setAmt(rsd.getDouble(3));
			t.setD(rsd.getDate(4));
			t.setType("Credit");
			System.out.println(t);
			al.add(t);
		}
		Collections.sort(al,new SortByTxn_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}
}
