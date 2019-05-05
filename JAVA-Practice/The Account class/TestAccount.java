//测试Account类
public class TestAccount {

	public static void main(String[] args){

		Account account1 = new Account(1122, 20000);    //创建一个账户id为1122，余额为20000的对象，对象名为account1

		account1.setInterestAnnualRate(4.5);      //设置这个对象的年利率

		account1.withDraw(2500);    //从这个对象提取2500元

		account1.deposit(3000);       //向这个对象存款3000元

		System.out.println(account1.getBalance() + "\n" +       //打印余额

				account1.getMonthlyInterestRate() + "\n" +      //打印月利率

				account1.getDateCreated());       //打印开户日期

	}

}
