/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking;
import java.util.Scanner;

class Bank{
    Scanner s=new Scanner(System.in);
    double bal,dep,wit,tran;
    int ANo;
    String Name, Add;
    
    Bank(String name,int accNo,String add)
    {
        Name=name;
        ANo=accNo;
        Add=add;
        bal=500;
    }
    
    void deposite(){
       System.out.println("Enter the account number:");
       int ano=s.nextInt();
       System.out.println("Enter the ammount to be deposited:");
       dep=s.nextDouble();
       bal+=dep;
    }
    
    void withdraw(){
       System.out.println("Enter the account number:");
       int ano=s.nextInt();
       System.out.println("Enter the ammount to be withdrawn:");
       wit=s.nextDouble();
       if( (bal-wit)<500)
           System.out.println("insufficient balance!");
       else{
            bal-=wit; 
        }
    }
    
    
    
    void transfer(){
        System.out.println("Enter your account number:");
       int ano=s.nextInt();
       System.out.println("Enter the beneficiery's account number:");
       int Bano=s.nextInt();
        System.out.println("Enter the ammount to be transfered:");
        tran=s.nextDouble();
        if( (bal-tran)<500)
           System.out.println("insufficient balance!");
       else{
            bal-=tran; 
    }
}
}

public class Banking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Bank b=new Bank("Putta",143,"abc");
        
        Scanner s=new Scanner(System.in);
        for(;;){
        System.out.println("Enter your choice as follows!!");
        System.out.println("1.Create Account\n2.Deposite\n3.Withdraw\n4.Transfer\5Total money in the Bank\n6.Know the RICHEST person!!\n7Exit");
        int ch=s.nextInt();
        
        switch(ch)
        {
            case 1: CreateAcc();
                    break;
                    
            case 2: b.deposite();
                    break;
                    
            case 3: b.withdraw();
                    break;
                    
            case 4: b.transfer();
                    break;
                    
            case 5: totalBal();
                    break;
                    
            case 6: Rich();
                    break;
                    
            case 7: return;
                        
        }
       }
    }
    
    static void totalBal(){
        return;
    }
    
    static void Rich(){
        return;
    }
     
    static void CreateAcc(){
        return;
    }
    
}
