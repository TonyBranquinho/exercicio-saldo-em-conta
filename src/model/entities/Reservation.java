package model.entities;

import model.exceptions.DomainException;

public class Reservation {

	private Integer Number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;

	public Reservation() {

	}

	public Reservation(Integer number, String holder, Double balance, Double withdrawLimit) {
		super();
		Number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return Number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void deposit(double amount) {
		balance = balance + amount;
	}

	public void withdraw(double amount) {
		validateWithdraw(amount);
		balance = balance - amount;
	}

	public void validateWithdraw(double amount) {
		if (amount > getWithdrawLimit()) {
			throw new DomainException("Erro de saque: A quantia excede o limite de saque");
		}
		if (amount > getBalance()) {
			throw new DomainException("Erro de saque: Saldo insuficiente");
		}
	}
}
