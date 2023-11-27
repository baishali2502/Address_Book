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
	 /*
		 * @desc:This function inserts new contact
		 * 
		 * @params: the new contact to be added
		 * 
		 * @returns: void
		 */
		void insert()
		{
			contact_node newcontact = create();
			if(head==null) {
				head = newcontact;
			}
			else
			{
				newcontact.next = head;
				head = newcontact;
			}
			size++;
		}
		/*
		 * @desc:This function edits an already present contact
		 * 
		 * @params:firstname and lastname of already present contact
		 * 
		 * @returns:void
		 */
		boolean editContact(String first,String last)
		{
			boolean editted = false;
			Scanner s = new Scanner(System.in);
			contact_node temp = head;
			while(temp!=null)
			{
				if(temp.firstname.equals(first) && temp.lastname.equals(last))
				{
					editted=true;
					System.out.println("Do you want to change firstname?");
					boolean changefirst=s.nextBoolean();
					if(changefirst) {
						System.out.print("Enter new firstname : ");
						temp.firstname = s.next();
					}
					
					System.out.println("Do you want to change lastname?");
					boolean changelast=s.nextBoolean();
					if(changelast) {
						System.out.print("Enter new lastname : ");
						temp.lastname = s.next();
					}
					
					System.out.print("Do you want to change email?");
					boolean changeemail=s.nextBoolean();
					if(changeemail) {
						System.out.print("Enter new email-id : ");
						temp.email = s.next();
					}
					
					System.out.print("Do you want to change address?");
					boolean changeaddress=s.nextBoolean();
					if(changeaddress) {
						System.out.print("Enter new address : ");
						temp.address = s.next();
					}
					
					System.out.print("Do you want to change city?");
					boolean changecity=s.nextBoolean();
					if(changecity) {
						System.out.print("Enter new city : ");
						temp.city = s.next();
					}
					
					System.out.print("Do you want to change state?");
					boolean changestate=s.nextBoolean();
					if(changestate) {
						System.out.print("Enter new state : ");
						temp.state = s.next();
					}
					
					System.out.print("Do you want to change zip?");
					boolean changezip=s.nextBoolean();
					if(changezip) {
						System.out.print("Enter new zip : ");
						temp.zip = s.nextInt();
					}
					
					System.out.print("Do you want to change phone?");
					boolean changephone=s.nextBoolean();
					if(changephone) {
						System.out.print("Enter new phone : ");
						temp.phone = s.nextLong();
					}
					
					return true;
				}
				temp = temp.next;
			}
			return editted;
		}
		/*
		 * @desc:This function deletes an already existing contact
		 * 
		 * @params:firstname & lastname of already existing contact
		 * 
		 * @returns:the deleted contact
		 */
		contact_node delete(String firstname,String lastname)
		{
			contact_node deleted_node = null;
			//linked-list is empty
			if(head==null)
				return null;
			size--;
			//if head is the node to be deleted
			if(head.firstname.equals(firstname) && head.lastname.equals(lastname))
			{
				deleted_node = head;
				head = head.next;
				return deleted_node;
			}
			//linked-list is not empty & head is not the node to be deleted
			contact_node temp = head.next; // we start checking from 2nd node 
			contact_node prev = head;
			while(temp!=null)
			{
				String first = temp.firstname;
				String last = temp.lastname;
				if(first.equals(firstname) && last.equals(lastname)) {
					deleted_node = temp;
					prev.next = temp.next;
					return deleted_node;
				}
				temp = temp.next;
				prev = prev.next;
			}
			
			return null;
		}

		/*
		 * @desc:This function displays all contacts in the address-book
		 * 
		 * @params:none
		 * 
		 * @returns:void
		 */
		void print()
		{
			contact_node temp = head;
			int count = 1;
			while(temp!=null)
			{
				System.out.println("\nContact - "+count+" :- ");
				System.out.println("\nFirstname :"+temp.firstname);
				System.out.println("Lastname :"+temp.lastname);
				System.out.println("Address :"+temp.address);
				System.out.println("City :"+temp.city);
				System.out.println("State :"+temp.state);
				System.out.println("Zip :"+temp.zip);
				System.out.println("Phone no. :"+temp.phone);
				System.out.println("Email :"+temp.email);
				
				temp=temp.next;
				count++;
			}
			System.out.println();
		}
}