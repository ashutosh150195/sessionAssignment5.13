package com.java.assignmentfive.three;

import java.io.IOException;

public abstract class Employee {
	
	public static int empId ;
	public static String empName ;
	public static int total_leaves ; 
	public static double total_salary ;

	public abstract void calculate_balance_leaves();
	
	public abstract boolean avail_leave(int no_of_leaves, char type_of_leave);
	
	public abstract void calculate_salary() throws IOException ;
}
