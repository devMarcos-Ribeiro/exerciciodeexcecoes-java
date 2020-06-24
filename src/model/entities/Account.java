package model.entities;

import model.exceptions.DomainException;

public class Account {
	
	private int number;
	private String holder;
	private double balance;
	private double withDrawLimit;
	
	public Account() {
	}
	
	public Account(int number, String holder, double balance, double withDrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withDrawLimit = withDrawLimit;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public double getWithDrawLimit() {
		return withDrawLimit;
	}

	public void setWithDrawLimit(double withDrawLimit) {
		this.withDrawLimit = withDrawLimit;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withDraw(double amount) {
		if(amount > balance) {
			throw new DomainException("Not enough balance");
		}
		if(amount > withDrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit!");
		}
		
		balance -= amount;
	}
	
	@Override
	public String toString() {
		return "Account number :"
		+this.getNumber()
		+", holder: "
		+this.getHolder()
		+", balance: "
		+this.getBalance();
	}
}
