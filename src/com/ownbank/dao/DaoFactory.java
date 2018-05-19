package com.ownbank.dao;
public class DaoFactory {
	private static OwnBankDao ownBankDao;
	static {
		ownBankDao=new OwnBankDao();
	}
	public static OwnBankDao getDao()
	{
		return ownBankDao;
	}
}
