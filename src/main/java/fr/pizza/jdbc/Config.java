package fr.pizza.jdbc;

import java.util.ResourceBundle;

public class Config {

	public static String use;
	public static String driver;
	public static String dbUrl;
	public static String user;
	public static String pwd;

	public static final void load(){
		ResourceBundle props = ResourceBundle.getBundle("jdbc");
		
		use = props.getString("use");
		driver = props.getString("driver"); 
		dbUrl = props.getString("dbUrl"); 
		user = props.getString("user"); 
		pwd = props.getString("pwd");
	}
}
