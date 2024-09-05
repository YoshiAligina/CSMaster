public class BankAccount{

	private String accountNumber;
	public String name;
	private double balance;

	
	public BankAccount(String acctnum, String name){ 
		this.accountNumber = acctnum;
		this.name = name;
		this.balance = 0;
	}
	
	public BankAccount(String acctnum, String name, double initialDeposit){
		this.accountNumber = acctnum;
		this.name = name;
		this.balance = initialDeposit;
	}
    

    
    public boolean depositMoney(double amount){
		if(amount > 0){
			this.balance += amount;
			return true;
		}
		return false;
	}

    
	public boolean withdrawMoney(double amount){
		if(amount > 0  &&  this.balance >= amount){
			this.balance -= amount;
			return true;
		}
		return false;
	}
    
    
    public boolean transferMoney(BankAccount to, double amount){
		if(this.withdrawMoney(amount)){
			to.depositMoney(amount);
			return true;
		}
		return false;
	}
    

    public String getAccountNumber(){ 
		return this.accountNumber;
	}
	public double getBalance(){ 
		return this.balance;
	}

    @Override
    //^ think – why do we need this?
	public String toString(){
		return this.accountNumber + " - " + this.name + ": $" + this.balance;
	}

	public boolean equals(SBankAccount other){
		if(this.accountNumber.equals(other.accountNumber)){
			return true;
		}
		return false;
	}

    public static void main(String [] args){
        BankAccount rushd = new BankAccount("001", "Rushd Syed", 99);
        BankAccount jane = new BankAccount("002", "Jane Doe", 999);
        BankAccount secondConstructorExample = new BankAccount("003", "John Doe");

        //example of how our conditional logic handles incorrect usage
        if(rushd.depositMoney(-99)){
            System.out.println("successfully deposited negative money :/");
        }
        else System.out.println("unable to deposit.");
        //feel free to test the other methods as well!
        

        System.out.println(rushd); //pre deposit. notice how toString is called automatically?
        rushd.depositMoney(999);
        System.out.println(rushd);//post deposit         
    }

}