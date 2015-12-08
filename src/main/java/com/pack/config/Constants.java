package com.pack.config;

public class Constants {
	
	public static final String BASE_URL = "https://www.google.co.uk/";
	public static enum PageName {HOMEPAGE, LOGINPAGE, CREATEACCOUNTPAGE};
	public static enum Gender {MALE, FEMALE};
	public static enum Month {JANUARY(0),FEBRUARY(1),MARCH(2),APRIL(3),MAY(4),JUNE(5),JULY(6),AUGUST(7),SEPTEMBER(8),OCTOBER(9),NOVEMBER(10)
		,DECEMBER(12);
		
		private int value;  
		private Month(int value){  
		this.value=value;  
		}
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}  
	
	};

}
