package com.NeoStox.Constant;

public final  class AppConstant {

	private AppConstant() {
		throw new IllegalStateException("AppConstant class");
		
	}
	
	private static final String User_Directory =  System.getProperty("user.dir");
	private static final String ChromePath =  System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	private static final String FirefoxPath = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
	private static final String EdgePath = System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe";
	private static final String SparkReportPath = System.getProperty("user.dir") + "\\Reports\\SparkReport.html";
	private static final String ArcheiveSparkReportPath = System.getProperty("user.dir") + "\\Reports\\archive\\Spark Report"; 
	private static final String ExcelTestDataPath = System.getProperty("user.dir") + "\\test-data\\NeoStoxTestData.xlsx";
	private static final String PropertiesFilePath = System.getProperty("user.dir") + "\\application.properties";
	
	public static String getPropfilepath() {
		return PropertiesFilePath;
	}

	public static String getUserDirectory() {
		return User_Directory;
	}

	public static String getChromePath() {
		return ChromePath;
	}
	
	public static String getfirefoxPath() {
		return FirefoxPath;
	}
	
	public static String getedgePath() {
		return EdgePath;
	}
	
	public static String getsparkreportPath() {
		return SparkReportPath;
	}
	
	public static String getarcheiveSparkReportPath() {
		return ArcheiveSparkReportPath;
	}
	
	public static String getexcelTestDataPath() {
		return ExcelTestDataPath;
	}
}
