package com.sshlafman.agile_soft_dev;

import junit.framework.TestCase;

public class PayrollTest extends TestCase {
	public void testAddSalariedEmployee() {
		int empId = 1;
		AddSalariedEmployee t(empId, "Bob", "Home", 1000.00);
		t.Execute();
		
		Employee e = gPayrollDatabase.GetEmployee(empId);
		assertEquals("Bob", e.GetName());
		
		PaymentClassification pc = e.GetClassification();
		assertEquals(SalariedClassification.getClass(), pc.getClass());
		
		assertEquals(1000.00, ((SalariedClassification)pc).GetSalary(), 0.001);
		PaymentSchedule ps = e.GetSchedule();
		assertEquals(MonthlySchedule.getClass(), ps.getClass());
		
		PaymentMethod pm = e.GetMethod();
		assertEquals(HoldMethod.getClass(), pm.getClass());
	}

}
