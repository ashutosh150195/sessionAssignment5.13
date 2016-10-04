package com.java.assignmentfive.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PermanentEmployee extends Employee {
	
	public static int paid_leave, sick_leave, casual_leave ;
	public static double basic, hra,pfa ; 
	public static BufferedReader br ;
	public static String input ;
	public static PermanentEmployee pm ;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		pm = new PermanentEmployee();
		System.out.println("PermanentEmployee details are : ");
		input();
		print_leave_details();
		pm.calculate_salary();
	}
	
	public void calculate_salary() throws IOException{
		
		System.out.println("Provient fund : "+(pfa = ((double)(0.12)*basic)));
		System.out.println("Home Allowence : "+(hra = ((double)(0.5)*basic)));
		System.out.println("Total Salary : "+(total_salary = (basic+hra-pfa)));
		
	}
	
	private static void input() throws IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter employeeID : ");
		input = br.readLine();
		empId = Integer.parseInt(input);
		
		System.out.println("Enter employeeName : ");
		input = br.readLine();
		empName = input ;
		
		System.out.println("Enter basic salary : ");
		input = br.readLine();
		basic = Double.parseDouble(input);
		
		System.out.println("Enter Number paidLeaves : ");
		input = br.readLine();
		paid_leave = Integer.parseInt(input);
		
		System.out.println("Enter Number sickLeaves : ");
		input = br.readLine();
		sick_leave = Integer.parseInt(input);
		
		System.out.println("Enter Number casualLeaves : ");
		input = br.readLine();
		casual_leave = Integer.parseInt(input);
		
	}

	public static void print_leave_details(){
		
		System.out.println("SickLeave sanction : "+pm.avail_leave(sick_leave , 'S'));
		System.out.println("PaidLeave sanction : "+pm.avail_leave(paid_leave , 'P'));
		System.out.println("CausalLeave sanction : "+pm.avail_leave(casual_leave , 'C'));
		
		System.out.println("Total number of Leaves : "
		+(total_leaves = (paid_leave+casual_leave+sick_leave)));
		
		pm.calculate_balance_leaves();
	}
	
	public void calculate_balance_leaves(){
		if(total_leaves <=6 ) {
			System.out.println("Remaining Leaves : "+(6 - total_leaves));
		} else {
			System.out.println("OverDues(Extra) Leaves : "+Math.abs((6 - total_leaves)));
		}
	}
	
	public boolean avail_leave(int no_of_leaves, char type_of_leave){
		if (no_of_leaves <= 4 && (type_of_leave == 'S' || type_of_leave == 'P')) {
			return true;
		}else if(no_of_leaves <= 2 && (type_of_leave == 'C' )){
			return true;
		}else{
			return false;
		}	
	}

}
