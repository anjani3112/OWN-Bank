package com.ownbank.util;
import java.util.Comparator;

public class SortByTxn_id implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		Transaction t1=(Transaction)arg0;
		Transaction t2=(Transaction)arg1;
		return t2.getTxn_id()-t1.getTxn_id();
	}
}
