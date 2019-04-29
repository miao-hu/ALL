import java.util.Date;   //这个类提供了与系统无关的对日期和时间的封装

public class Account {

	private int id;      //数据域

	private double balance;

	private double annualInterestRate;

	private Date dateCreated;

	Account(){      //无参构造方法

		id = 0;

		balance = 0;

		annualInterestRate = 0;

		//dateCreated.getDate();

		//dateCreated.toGMTString();

	}


	Account(int uId, double initBalance){         //有参构造方法

		id = uId;

		balance = initBalance;

	}

	public void setId(int newId){

		id = newId;

	}

	public int getId(){

		return id;

	}

	

	public void setBalance(int newBalance){

		balance = newBalance;

	}

	public double getBalance(){

		return balance;

	}

	public void setInterestAnnualRate(double newAnnualRate){

		annualInterestRate = newAnnualRate;

	}

	public double getInterestAnnualRate(){

		return annualInterestRate;

	}

	public Date getDateCreated(){

		return dateCreated;

	}

	public double getMonthlyInterestRate(){

		return balance * annualInterestRate / 100 / 12;

	}

	public void withDraw(double withDrawBalance){

		balance -= withDrawBalance;

	}

	public void deposit(double depositBalance){

		balance += depositBalance;

	}

}
