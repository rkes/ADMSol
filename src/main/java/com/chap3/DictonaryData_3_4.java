package com.chap3;

import java.util.HashMap;
import java.util.Map;

public class DictonaryData_3_4 {

	public static void main(String[] args) {

	}

	static class Dictonary {
		Map<Integer, String> map = new HashMap<>();

		public void insertIntoMap(String val) {
			map.put(getHashCode(val), val);
		}
		public void remove(String val){
			map.remove(getHashCode(val));
		}
		public boolean find(String val){
			if(map.get(getHashCode(val)) !=null )
				return true;
			return false;
		}
		private Integer getHashCode(String elem) {
			return elem.hashCode();
		}
	}
}
