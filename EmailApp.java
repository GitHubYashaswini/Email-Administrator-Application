import java.util.*;
import java.io.*;

class Email
{
    //Scanner class global
    public Scanner s = new Scanner(System.in); 

    //Setting variables as private to not give  access directly
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alterEmail;

    //Constructor to receive firstname ,lastname
    public Email(String fname,String lname)
    {
         this.fname = fname;
         this.lname=lname;
         System.out.println("New Employee:"+ this.fname+" "+ this.lname);

         //calling methods
         this.dept = this.setDept(); //department
         this.password = this.generatePassword(8); //password
         this.email = this.generateEmail();//email generation
    }

    //Asking for dept method
    private String setDept()
    {
        System.out.println("Department codes \n1. For sales \n2. For Development \n3. For Accounting \n4. None");
        boolean flag = false;
        do
        {
            System.out.println("Enter Department code");
            int choice = s.nextInt();
            switch(choice)
            {
                case 1 :
                    return "Sales";
                case 2 :
                    return "Development";
                case 3 : 
                    return "Accounting";
                case 4 :
                    return "None";
                default:
                    System.out.println("Invalid choice please choose it again");
            }
        }while(!flag);
        return null;
    }

    //Generate Random password method
    private String generatePassword(int length)
    {
        Random r = new Random();
        String CapitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String SmallChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%&?";
        String values = CapitalChars+SmallChars+numbers+symbols;
        String password="";
        for(int i=0;i<length;i++)
        {
          password = password+values.charAt(r.nextInt(values.length()));
        }
        return password;
    }

        
    //Generate mail method
    private String generateEmail()
    {
        return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".com";
    }

    //Change password method
    public void setPassword()
    {
        boolean flag = false;
        do
        {
            System.out.println("Do you want to change your password!(Y/N)");
            char choice = s.next().charAt(0);
            if(choice == 'Y' || choice == 'y')
            {
                flag = true;
                System.out.println("Enter the current password");
                String temp = s.next();
                if(temp.equals(this.password))
                {
                    System.out.println("Enter new password:");
                    this.password = s.next();
                    System.out.println("Password changed successfully");
                }
                else
                {
                     System.out.println("Incorrect password");
                     System.out.println("Enter the current password");
                     String temp1 = s.next();

                if(temp1.equals(this.password))
                {
                    System.out.println("Enter new password:");
                    this.password = s.next();
                    System.out.println("Password changed successfully");
                }
                else
                {
                     System.out.println("Incorrect password");
                     
                }
                }
             
            } 
            else if(choice == 'N' || choice ==  'n')
                {
                   flag = true;
                   System.out.println("password changed option cancelled!");
                }
            else 
                {
                    System.out.println("Enter valid choice");
                } 
        }while(!flag);
    }

    //set mailbox capacity method
    public void setMailCap()
    {
        System.out.println("Current capacity ="+this.mailCapacity+"mb");
        System.out.println("Enter new mailbox capacity:");
        this.mailCapacity = s.nextInt();
        System.out.println("Mailbox Capacity is successfully changed");
    }

    // set alternate email method
    public void alternateEmail()
    {
        System.out.println("Enter new alternate mail:");
        this.alterEmail = s.next();
        System.out.println("Alternate email is set");
    }

    //Display user information method
    public void getInfo()
    {
        System.out.println("New Employee:"+ this.fname+ " "+ this.lname);
        System.out.println("Department:"+ this.dept);
        System.out.println("Email:" + this.email);
        System.out.println("Password:"+ this.password);
        System.out.println("Mailbox Capacity:"+ this.mailCapacity+"mb");
        System.out.println("Alternate e-mail:"+ this.alterEmail);
    }


}

public class EmailApp
{
    public static void main(String[] args)
    {
       Scanner s1 = new Scanner(System.in);

       //User ifo 
       System.out.print("Enter first name : ");
       String f_name = s1.next();
       System.out.print("Enter last name : ") ;
       String l_name = s1.next();

       //creating object for email class
       Email em1 = new Email(f_name,l_name);
       int choice = -1;
       do
       {
         System.out.println("\n**********************\nEnter your choice \n1. Show Information \n2. Change password \n3. Change mailbox capacity \n4. Set alternate email \n5. Exit");
         choice = s1.nextInt();
            switch(choice)
            {
                case 1 :
                    em1.getInfo();
                    break;
                case 2 :
                    em1.setPassword();
                    break;
                case 3 : 
                    em1.setMailCap();
                    break;
                case 4 :
                    em1.alternateEmail();
                    break;
                case 5 :
                     System.out.println("Thank You for using Email Application");
                     break;
                default:
                    System.out.println("Invalid choice!!\n Enter proper choice again..");
                    break;
            }
       }while(choice!=5);
    }
}    

