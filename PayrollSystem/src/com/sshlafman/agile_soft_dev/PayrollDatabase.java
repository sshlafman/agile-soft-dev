package com.sshlafman.agile_soft_dev;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {
	private static PayrollDatabase database = null;
	private Map<Integer, Employee> m_Employees = new HashMap<Integer, Employee>();
	
	public static PayrollDatabase instance() {
		if (database == null) {
			database = new PayrollDatabase();
		}
		return database;
	}
	
	private PayrollDatabase() {
	}
	
	public Employee GetEmployee(int empId) {
		return m_Employees.get(empId);
	}

	public void AddEmployee(int empId, Employee e) {
		m_Employees.put(empId, e);
	}
	
	public void clear() {
		m_Employees.clear();
	}
}
