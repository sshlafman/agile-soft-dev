package com.sshlafman.agile_soft_dev;

public abstract class AddEmployeeTransaction implements Transaction {
	private int m_EmpId;
	private String m_Name;
	private String m_Address;
	
	public AddEmployeeTransaction (int empId, String name, String address) {
		this.m_EmpId = empId;
		this.m_Name  = name;
		this.m_Address = address;
	}

	public void Execute() {
		PaymentClassification pc = GetClassification();
		PaymentSchedule ps = GetSchedule();
		PaymentMethod pm = new HoldMethod();
		Employee e = new Employee(m_EmpId, m_Name, m_Address);
		e.SetClassification(pc);
		e.SetSchedule(ps);
		e.SetMethod(pm);
		PayrollDatabase.instance().AddEmployee(m_EmpId, e);
	}

	public abstract PaymentClassification GetClassification();
	public abstract PaymentSchedule GetSchedule();

}
