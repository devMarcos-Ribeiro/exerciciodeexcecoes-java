package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Enter account data: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		String holder = sc.next();
		System.out.print("Initial balance: $");
		double balance = sc.nextDouble();
		System.out.print("Withdraw limit: $");
		double withDrawLimit = sc.nextDouble();
		
		Account account = new Account(number, holder, balance, withDrawLimit);
		System.out.print("Enter ammount for withdraw: ");
		double amount = sc.nextDouble();
		
		try {
			account.withDraw(amount);
			System.out.println("New balance: "+String.format("%.2f", account.getBalance()));
		}
		catch(DomainException e) {
			System.out.println("Withdraw error: "+e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error.");
		} 
		
		sc.close();
		
	}

}