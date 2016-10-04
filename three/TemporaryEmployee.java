package com.java.assignmentfive.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TemporaryEmployee extends Employee {
	
	public static int paid_leave, sick_leave, casual_leave ;
	public static double basic, hra,pfa ; 
	public static BufferedReader br ;
	public static String input ;
	public static TemporaryEmployee te ;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		te = new TemporaryEmployee();
		System.out.println("TemporaryEmployee details are : ");
		input();
		te.calculate_salary();
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

	@Override
	public void calculate_salary() {
		// TODO Auto-generated method stub
		System.out.println("Provient fund : "+(pfa = ((double)(0.12)*basic)));
		System.out.println("Home Allowence : "+(hra = ((double)(0.5)*basic)));
		System.out.println("Total Salary : "+(total_salary = (basic+hra-pfa)));
		
		te.avail_leave(paid_leave , 'P');
		te.avail_leave(casual_leave , 'C');
		te.avail_leave(sick_leave , 'S');
		
		te.calculate_balance_leaves();
	}

	@Override
	public void calculate_balance_leaves() {
		// TODO Auto-generated method stub
		if(total_leaves <=6 ) {
			System.out.println("Remaining Leaves : "+(3 - total_leaves));
		} else {
			System.out.println("OverDues(Extra) Leaves : "+Math.abs((3 - total_leaves)));
		}
	}

	@Override
	public boolean avail_leave(int no_of_leaves, char type_of_leave) {
		// TODO Auto-generated method stub
		if (no_of_leaves <= 4 && (type_of_leave == 'S' || type_of_leave == 'P')) {
			return true;
		}else if(no_of_leaves <= 2 && (type_of_leave == 'C' )){
			return true;
		}else{
			return false;
		}	
	}
	

}
