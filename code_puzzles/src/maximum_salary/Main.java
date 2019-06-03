package maximum_salary;
/* Save this in a file called Main.java to compile and test it */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/* Do not add a package declaration */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
/* Do not add a namespace declaration */
public class Main {
    public static Map<String,Integer> processData(ArrayList<String> array) {
        /* 
         * Modify this method to process `array` as indicated
         * in the question. At the end, return the appropriate value.
         *
         * Please create appropriate classes, and use appropriate
         * data structures as necessary.
         *
         * Do not print anything in this method.
         *
         * Submit this entire program (not just this method)
         * as your answer
         */
        Map<String,Integer> finalResult = new HashMap<>();
        Map<Integer, Employee> tempMap = new HashMap<>();
        
        // Parsing & getting ArrayList into a Map in Integer as Key & Employee as Value
		for(String token: array) {
			tempMap.put(Integer.parseInt(token.split(",")[0]), populateEmployee(token));
    	}
		
		// Created another arraylist for getting only parsed & newly created employee objects 
		ArrayList<Employee> empList = new ArrayList<>();
		for(Map.Entry<Integer, Employee> token : tempMap.entrySet()) {
			empList.add(token.getValue());
		}
		
		// This is the question solving code of Java8
		Map<Object, Object> topEmployees = empList.stream().collect(
				Collectors.groupingBy(e -> e.department, Collectors
				.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(e -> e.salary)), Optional::get)));

		// just getting the result in the desired format for the sake of Driver Code convenience
		for(Map.Entry<Object, Object> token : topEmployees.entrySet()) {
			Employee emp = (Employee) token.getValue();
			finalResult.put((String) token.getKey(), emp.getId());
		}
		
		return finalResult;
    }

    /**
     * creates an employee object based on the tokenized string given
     * @param String token for instance has to be {22, Rajan Anand, Engineering, 1600000}
     * @return employee object
     */
	public static Employee populateEmployee(String token) {
		Integer id = Integer.parseInt(token.split(",")[0]);
		String name = token.split(",")[1];
		String dept = token.split(",")[2];
		Float salary = Float.parseFloat(token.split(",")[3]);
		return new Employee(id, name, dept, salary);
	}

	// Driver Code
	public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("input.txt")));
            
            while(in.hasNextLine())
                inputData.add(in.nextLine());
            
            Map<String,Integer> retVal = processData(inputData);
            
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            
            for(Map.Entry<String,Integer> e: retVal.entrySet())
                output.println(e.getKey() + ": " + e.getValue());
            
            output.close();
            in.close();
        } catch (IOException e) {
            System.out.println("IO error in input.txt or output.txt");
		}
    }
    
	static class Employee {
		private Integer id;
		private String name;
		private String department;
		private Float salary;

		public Employee(Integer id, String name, String department, Float salary) {
			super();
			this.id = id;
			this.name = name;
			this.department = department;
			this.salary = salary;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public Float getSalary() {
			return salary;
		}

		public void setSalary(Float salary) {
			this.salary = salary;
		}
	}
}
