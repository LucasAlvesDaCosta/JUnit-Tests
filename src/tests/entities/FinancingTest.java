package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Financing;

public class FinancingTest {
	public Financing fnc;
	
	@Test
	public void financingCreateWhenValityValues() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		
		fnc = new Financing(totalAmount,income, months);
		Assertions.assertEquals(totalAmount, fnc.getTotalAmount());
		Assertions.assertEquals(income, fnc.getIncome());
		Assertions.assertEquals(months, fnc.getMonths());
		
	}
	
	@Test
	public void financingShoudThrowExceptionWhenInvalidValityValues() {
		
		 Assertions.assertThrows(IllegalArgumentException.class, () -> {
			 double totalAmount = 100000.0;
				double income = 2000.0;
				int months = 20;
				fnc = new Financing(totalAmount,income, months);
		   });
	}
	
	@Test
	public void totalAmountShoudUpdateValueWhenValidArgument() {
		double totalAmount = 100000.0;
		double income = 4000.0;
		int months = 80;
		fnc = new Financing(totalAmount,income, months);
		
		fnc.setTotalAmount(90000.0);
		Assertions.assertEquals(90000.0, fnc.getTotalAmount());
		Assertions.assertTrue(totalAmount != fnc.getTotalAmount());
  
	}
	
	@Test
	public void totalAmountDoNotShoudUpdateValueWhenInvalidArgument() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		fnc = new Financing(totalAmount,income, months);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			fnc.setTotalAmount(200000.0);
		});
	}
	
	@Test
	public void incomeShoudUpdateValueWhenValidArgument() {
		double totalAmount = 100000.0;
		double income = 4000.0;
		int months = 80;
		fnc = new Financing(totalAmount,income, months);
		
		fnc.setIncome(2000.0);
		Assertions.assertEquals(2000.0, fnc.getIncome());
		Assertions.assertTrue(income != fnc.getIncome());
  
	}
	
	@Test
	public void incomeDoNotShoudUpdateValueWhenInvalidArgument() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		fnc = new Financing(totalAmount,income, months);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			fnc.setIncome(1000.0);
		});
	}
	
	@Test
	public void monthsShoudUpdateValueWhenValidArgument() {
		double totalAmount = 100000.0;
		double income = 4000.0;
		int months = 80;
		fnc = new Financing(totalAmount,income, months);
		
		fnc.setMonths(90);
		Assertions.assertEquals(90, fnc.getMonths());
		Assertions.assertTrue(months != fnc.getMonths());
  
	}
	
	@Test
	public void monthsDoNotShoudUpdateValueWhenInvalidArgument() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		fnc = new Financing(totalAmount,income, months);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			fnc.setMonths(40);
		});
	}
	
	@Test
	public void entryShoudCalcValueOfEntryWhenValidArgument() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
	    fnc = new Financing(totalAmount,income, months);
		
		double expectedValue = 20000.0;
		Assertions.assertEquals(expectedValue, fnc.entry());
		Assertions.assertTrue(totalAmount * 0.2 == expectedValue);
	}
	
	@Test
	public void quotaShoudCalcValueOfFinancingMonthlyWhenValidArgument() {
		double totalAmount = 100000.0;
		double income = 2000.0;
		int months = 80;
		double entry = totalAmount * 0.2;
		double expectedValue = 1000.0;
		fnc = new Financing(totalAmount,income, months);	
		Assertions.assertEquals(expectedValue, fnc.quota());
		Assertions.assertTrue(totalAmount - entry == 80000.0);
	}
}
