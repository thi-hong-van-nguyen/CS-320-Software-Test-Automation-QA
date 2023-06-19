package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;


public class ContactServiceTest {
    private String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private Contact contact;
    private ContactService cs;
    
	 @BeforeEach
	 void setUp() {
		contactId = "C123456789";
		firstName = "Thi";
		lastName = "Nguyen";
		phone = "5001234567";
		address = "123 Imagine Str, FakeCity";
		contact = new Contact(contactId, firstName, lastName, phone, address);
		cs = new ContactService();
	 }
	
	@Test
	@DisplayName("Add a contact to a newly instantiated Contact Service")
	public void testAddContact() {		
		// Before adding any contact to the list, the size of the list should be 0
		assertEquals(0, cs.getContacts().size());	
		
		cs.addContact(contact);
		// Before adding one contact to the list, the size of the list should be 1
		assertEquals(1, cs.getContacts().size());	
		Contact createdContact = cs.getContacts().get(0);
		assertTrue(createdContact.getContactId().equals(contactId));
		assertTrue(createdContact.getFirstName().equals(firstName));
		assertTrue(createdContact.getLastName().equals(lastName));
		assertTrue(createdContact.getPhone().equals(phone));
		assertTrue(createdContact.getAddress().equals(address));
	}
	
	@Test
	@DisplayName("Add contact with a unique contact id to a Contact Service")
	public void testAddUniqueIdContact() {
		// Add the first contact
		cs.addContact(contact);
		assertEquals(1, cs.getContacts().size());
		
		// Add the second contact with a different contactId
		Contact newContact = new Contact("C12346", "Jennifer", "Lopez", "1234567890", "456 Candy, ImgCity");
		cs.addContact(newContact);
		
		assertEquals(2, cs.getContacts().size());	
		Contact createdContact = cs.getContacts().get(1);
		assertTrue(createdContact.getContactId().equals("C12346"));
		assertTrue(createdContact.getFirstName().equals("Jennifer"));
		assertTrue(createdContact.getLastName().equals("Lopez"));
		assertTrue(createdContact.getPhone().equals("1234567890"));
		assertTrue(createdContact.getAddress().equals("456 Candy, ImgCity"));
	}
	
	@Test
	@DisplayName("Adding contact with a duplicated contact id to a Contact Service should throw an IllegalArgumentException")
	public void testAddDuplicatedContact() {
		// Add the first contact
		cs.addContact(contact);
		
		// Add the second contact
		Contact contact2 = new Contact("C12346", "Jennifer", "Lopez", "1234567890", "456 Candy, ImgCity");
		cs.addContact(contact2);
		
		// Add the third contact with same contact ID with the first contact
		Contact contact3 = new Contact(contactId, "Amy", "Lam", "0987654321", "789 Reast Str, Hallow, MN");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.addContact(contact3);
		});
	}
	
	@Test
	@DisplayName("Delete a contact")
	public void testDeleteContact() {
		// Add three contacts
		cs.addContact(contact);
		cs.addContact(new Contact("C12346", "Jennifer", "Lopez", "1234567890", "456 Candy, ImgCity"));
		cs.addContact(new Contact("C12347", "Amy", "Lam", "0987654321", "789 Reast Str, Hallow, MN"));
		
		// Delete the second contact
		cs.deleteContact("C12346");
		
		// Check the remained contacts
		assertEquals(2, cs.getContacts().size());	
		assertTrue(cs.getContacts().get(0).getContactId().equals(contactId));
		assertTrue(cs.getContacts().get(1).getContactId().equals("C12347"));
	}
	
	@Test
	@DisplayName("Deleting a contact with an non-existing contact id should throw an IllegalArgumentException")
	public void testDeleteNonExistContact() {
		// Add three contacts
		cs.addContact(contact);
		cs.addContact(new Contact("C12346", "Jennifer", "Lopez", "1234567890", "456 Candy, ImgCity"));
		cs.addContact(new Contact("C12347", "Amy", "Lam", "0987654321", "789 Reast Str, Hallow, MN"));
		
		// Delete a non-exist ID
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.deleteContact("C12349");
		});
	}
	
	@Test
	@DisplayName("Update a contact")
	public void testUpdateContact() {
		// Add three contacts
		cs.addContact(contact);
		cs.addContact(new Contact("C12346", "Jennifer", "Lopez", "1234567890", "456 Candy, ImgCity"));
		cs.addContact(new Contact("C12347", "Amy", "Lam", "0987654321", "789 Reast Str, Hallow, MN"));
		
		// Update the first contact
		cs.updateContact(contactId, "Xhi", "Doe", "9001231234", "098 Image Blvd, Twincs City");
		
		assertEquals(3, cs.getContacts().size());	
		assertTrue(cs.getContacts().get(0).getContactId().equals(contactId));
		assertTrue(cs.getContacts().get(0).getFirstName().equals("Xhi"));
		assertTrue(cs.getContacts().get(0).getLastName().equals("Doe"));
		assertTrue(cs.getContacts().get(0).getPhone().equals("9001231234"));
		assertTrue(cs.getContacts().get(0).getAddress().equals("098 Image Blvd, Twincs City"));
	}
	
	@Test
	@DisplayName("Updating a contact with a non-existing contact id should throw an IllegalArgumentException")
	public void testUpdateNonExistContact() {
		// Add three contacts
		cs.addContact(contact);
		cs.addContact(new Contact("C12346", "Jennifer", "Lopez", "1234567890", "456 Candy, ImgCity"));
		cs.addContact(new Contact("C12347", "Amy", "Lam", "0987654321", "789 Reast Str, Hallow, MN"));		
		
		// Update with non-existing contactId
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			cs.updateContact("C12348", "Xhi", "Doe", "9001231234", "12345 Imagine Blvd, Twincs City");
		});
	}
}
