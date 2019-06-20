//（账户类Account）设计一个名为Account的类，他包括：
//		  *一个名为id的Int 类型的私有账户数据域（默认值为0）
//		  *一个名为balance的double类型的私有账户数据域（默认值为0）
//		  *一个名为annualInterestRate的double类型的私有数据域存储当前的利率（默认值为0），假设所有的账户都有相同的利率
//		  *一个名为dataCreated的Date型的私有数据与存储账户的开户日期
//		  *一个能创建默认账户的的无参构造方法
//		  *一个能创建带指定的id和初始余额账户的构造方法
//		  *Id,balance,annualInterestRare的访问器和修改器
//		  *dataCreated的访问器
//		  *一个名为getMonthlyInterestRate()方法返回月利率
//		  *一个名为withdraw()方法从账户提取特定数额
//	  	  *一个名为deposit()方法向账户存储特定的数额

//		实现这个类，编写一个测试程序，创建一个账户id为1122，余额为200000美元，年利率为4.5%的Account对象。
//		使用withdraw()方法提款2500美元，使用desposit()方法存款3000美元，打印余额，月利率以及这个账户的开户日期。



import java.util.Date;           //这个类提供了与系统无关的对日期和时间的封装

public class Account {           //一个名为Account的类

	private int id;          //数据域（私有的）

	private double balance;            //余额

	private double annualInterestRate;

	private Date dateCreated;       //一个名为dateCreated的Date类型的私有数据域存储账户的开户日期

	Account(){      //无参构造方法    目的：初始化数据域（创建默认账户）

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

	public void setId(int newId){        //修改器

		id = newId;

	}

	public int getId(){                //访问器

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

	public double getMonthlyInterestRate(){               //函数（计算月利率）

		return balance * annualInterestRate / 100 / 12;

	}

	public void withDraw(double withDrawBalance){         //函数（计算余额）withDrawBalance为提取的特定数额

		balance -= withDrawBalance;

	}

	public void deposit(double depositBalance){            //函数（计算余额）depositBalance为存储的特定数额

		balance += depositBalance;

	}

}
