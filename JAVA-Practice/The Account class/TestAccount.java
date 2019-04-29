
public class TestAccount {

	public static void main(String[] args){

		Account account1 = new Account(1122, 20000);

		account1.setInterestAnnualRate(4.5);

		account1.withDraw(2500);

		account1.deposit(3000);

		System.out.println(account1.getBalance() + "\n" +

				account1.getMonthlyInterestRate() + "\n" + 

				account1.getDateCreated());

	}

}
