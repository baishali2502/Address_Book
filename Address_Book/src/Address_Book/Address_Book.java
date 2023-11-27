package Address_Book;
import java.util.*;


class contact_node
{
	String firstname;
	String lastname;
	long phone;
	String email;
	String address;
	String city;
	String state;
	long zip;
	
	
	contact_node next;
	
	contact_node(String firstname, String lastname, long phone,String email,
			     String address, String city, String state, long zip) 
	{
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		
		this.next = null;
	}
	contact_node()
	{
		next = null;
	}
}

public class Address_Book 
{
	//main function
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		AddressBook book = new AddressBook();
		System.out.println("Welcome to Address Book Program !!");
		System.out.println("\nMenu:-\n"
				+ "1.)Add new contact\n"
				+ "2.)Delete new contact\n"
				+ "3.)Edit new contact\n"
				+ "4.)Display all contacts\n"
				+ "5.)No. of contacts\n"
				+ "Choose : ");
		int choice = s.nextInt();
		
		while(choice!=-1)
		{
			if(choice==1)
			{
				book.insert();
				System.out.println("New contact added\n");
			}
			else if(choice==2)
			{
				System.out.print("Enter first name of contact:");
				String first = s.next();
				
				System.out.print("Enter last name of contact:");
				String last = s.next();
				contact_node c = book.delete(first,last);
				if(c==null)
					System.out.println("Contact not found");
				else
				    System.out.println("Contact deleted\n");
			}
			else if(choice==3)
			{
				System.out.print("Enter first name of contact:");
				String first = s.next();
				
				System.out.print("Enter last name of contact:");
				String last = s.next();
				
				boolean ans = book.editContact(first,last);
				System.out.println("Contact edited = "+ans);
				
			}
			else if(choice==4)
			{
				book.print();
			}
			else
			{
				System.out.println("No. of contacts = "+book.size);
			}
			System.out.println("Enter choice : ");
			choice = s.nextInt();
		}
		
	}
}

class AddressBook
{
	contact_node head = null; // initially when 
	int size=0; // size of linked-list
	
	
	/*
	 * @desc:This function creates a new contact
	 * 
	 * @returns:The new contact created
	 * 
	 * @params:none
	 */
	 contact_node create()
	{ 
		Scanner s = new Scanner(System.in);
		
		System.out.print("Enter first-name : ");
		String firstname = s.nextLine();
		System.out.print("Enter last-name : ");
		String lastname = s.nextLine();
		System.out.println("Enter email : ");
		String email = s.nextLine();
		System.out.print("Enter address : ");
		String address = s.nextLine();
		System.out.print("Enter city : ");
		String city = s.nextLine();
		System.out.print("Enter state : ");
		String state = s.nextLine();
		System.out.print("Enter zip : ");
		long zip = s.nextInt();
		System.out.print("Enter phone-no. : ");
		long phone = s.nextLong();
		
		
		
		contact_node c = new contact_node(firstname,lastname,phone,email,address,city,state,zip);
				
		return c;
	}
}