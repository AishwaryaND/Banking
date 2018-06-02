/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;


import java.util.ArrayList;
import java.util.Scanner;


class Customer{
   Scanner scan = new Scanner(System.in);
   private int AccNo;
   String custName,custAdd;
   double bal;
   
   Customer(int AccountNo){
      AccNo =AccountNo; 
   }  
   
   void createCustomerAcc() {
        System.out.println("Your Bank Account Number is : "+ AccNo);
        System.out.print("Enter Your Name : ");
        custName = scan.next();
        scan.nextLine();
        System.out.print("Enter your Address : ");
        custAdd = scan.nextLine();
        bal=500;
	System.out.println("Your Account with Account Number " +AccNo+ " is created!!");
        
    }

    void deposite() {
            System.out.print("Enter the amount to be deposited : ");
            double deposite = scan.nextDouble();
            if(deposite > 0.0) {
                bal +=deposite;
                System.out.println("The balance after deposite is : "+bal);
            }
            else
                System.out.println("Invalid Deposite amount!!");
       
    }

    void withdraw() {
        
            System.out.print("Enter the amount to be Withdrawn : ");
            double withdraw = scan.nextDouble();
            
            if((bal-withdraw)<500) {
                System.out.println("Insufficient Bank Balance!!");
            }
            else{
		bal -=withdraw;
                System.out.println("The balance after withdrawal is : "+bal);
		}
        
    }
    
}


public class Banking {

    
   static int count=0;
       static ArrayList<Customer> customerArray = new ArrayList<>(200);
       static Scanner s = new Scanner(System.in);
        
    public static void main(String[] args) {
        for(;;) {
            System.out.println("1.Create Bank Account\n"
                              +"2.Deposite\n"
                              +"3.Withdraw\n"
                              +"4.Transfer Money\n"
                              +"5.Total Bank Balance\n"
                              +"6.Know the Richest Person\n"
                              +"7.Exit\n\n");
            System.out.print("Enter your choice : ");
            int choice = s.nextInt();
            switch(choice) {
                case 1 :   
                            addCustomer();
                            break;
                case 2 : 
                           dep();
                           break;
                
                case 3 :  with();
                           break;
                          
                case 4 : 
                            transfer();
                            break;
                
                case 5 : 
                            totalBankBalance();
                            break;
                
                case 6 : 
                            richestPerson();
                            break;
                
                case 7 : 
                            System.exit(0);
                
                     }
        }
    }

    static void addCustomer() {
        Customer c = new Customer(count);
        c.createCustomerAcc();
        count++;
        customerArray.add(c);
    }

    static void dep() {
        System.out.print("Enter your Account number : ");
        int input = s.nextInt();
         try {
             customerArray.get(input).deposite();
        }
        catch(ArrayIndexOutOfBoundsException b) {
            System.out.println("Invalid Account number.");
        }
    }

    static void with() {
        System.out.print("Please enter your Account number : ");
        int input = s.nextInt();
        try {
             customerArray.get(input).withdraw();
        }
        catch(ArrayIndexOutOfBoundsException b) {
            System.out.println("Invalid Account number.");
        }
    }

    static void transfer() {
        System.out.print("Enter your account number : ");
        int inAccountNo = s.nextInt();
        System.out.print("Enter the Account number to which u ant to transfer Money : ");
        int outAccountNo=s.nextInt();
        try {
            double CurrentBal = customerArray.get(inAccountNo).bal;
            double benificiaryBalance = customerArray.get(outAccountNo).bal;
            System.out.print("Please enter the amount to transfer : ");
            double transferAmt = s.nextDouble();
            if((CurrentBal-transferAmt)>= 500) {
                customerArray.get(inAccountNo).bal -= transferAmt;
                customerArray.get(outAccountNo).bal += transferAmt;
                System.out.println("The Money was Transferred Successfully");
            }
            else {
                System.out.println("Insufficent balance. Transfer Failed");
            }
        }
        catch (ArrayIndexOutOfBoundsException b){
            System.out.println("Invaild Account Numbers!!");
        }
    }

    static void totalBankBalance() {
        double totBankBal=0;
        for(int j=0;j<count;j++)
        {
            totBankBal += customerArray.get(j).bal;
        }
        
            System.out.println("The Total Money in bank is : "+totBankBal);
    }

    static void richestPerson() {
        try {
                int richestPersonAccNo=0;
                double max = customerArray.get(0).bal;
                for(int j=1;j<count;j++) {
                    double balance = customerArray.get(j).bal;
                    if(max<balance){
                        max = balance;
                        richestPersonAccNo = j;
                    }
                }
                //String name = customerArray.get(accountWithHighestBalance).customerName;
                System.out.println("The person with highest bank balance is : "+customerArray.get(richestPersonAccNo).custName+" With balance : "+max);
        }
        catch (ArrayIndexOutOfBoundsException b) {
            System.out.println("The Bank has No Accounts.");
        }
    }
}
