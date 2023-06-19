package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import contact.Contact;

public class ContactTest {	
    private String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private Contact contact;
    
	 @BeforeEach
	 void setUp() {
		contactId = "C123456789";
		firstName = "Thi";
		lastName = "Nguyen";
		phone = "5001234567";
		address = "123 Imagine Str, FakeCity";
	 }
	
	@Test
	@DisplayName("Create a contact with all valid arguments")
	void testContact() {
		Contact contact = new Contact(contactId,firstName, lastName, phone, address);
		assertEquals(contactId, contact.getContactId());
		assertEquals(firstName, contact.getFirstName());
		assertEquals(lastName, contact.getLastName());
		assertEquals(phone, contact.getPhone());
		assertEquals(address, contact.getAddress());
	}
	
	@Test
	@DisplayName("Creating a contact with a contact ID longer than 10 characters should throw an IllegalArgumentException")
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("C12345678900", firstName, lastName, phone, address);
		});
	}
	
	@Test
	@DisplayName("Creating a contact with a null contact ID should throw an IllegalArgumentException")
	void testContactNullId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, firstName, lastName, phone, address);
		});
	}
	
	@Test
	@DisplayName("Creating a contact with firstName longer than 10 characters should throw an IllegalArgumentException")
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, "John Junior", lastName, phone, address);
		});
	}
	
	@Test
	@DisplayName("Creating a contact with a null firstName should throw an IllegalArgumentException")
	void testContactNullFirstName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, null, lastName, phone, address);
		});
	}	
	
	@Test
	@DisplayName("Update First Name")
	void testContactUpdateFirstName() {
		Contact contact = new Contact(contactId, firstName, lastName, phone, address);
		contact.setFirstName("Jennifer");
		assertTrue(contact.getFirstName().equals("Jennifer"));
	}
	
	@Test
	@DisplayName("Updating First Name with a String longer than 10 characters should throw an IllegalArgumentException")
	void testContactUpdateFirstNameTooLong() {
		Contact contact = new Contact(contactId, firstName, lastName, phone, address);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName("Bartholomew");
		});
	}
	
	@Test
	@DisplayName("Updating First Name with a null argument should throw an IllegalArgumentException")
	void testContactUpdateFirstNameNull() {
		Contact contact = new Contact(contactId, firstName, lastName, phone, address);	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setFirstName(null);
		});
	}
	
	@Test
	@DisplayName("Creating a contact with lastName longer than 10 characters should throw an IllegalArgumentException")
	void testContactLasttNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, "Smithersmith", phone, address);
		});
	}
	
	@Test
	@DisplayName("Creating a contact with a null lastName should throw an IllegalArgumentException")
	void testContactNullLastName() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, null, phone, address);
		});
	}
	
	@Test
	@DisplayName("Update Last Name")
	void testContactUpdateLastName() {
		Contact contact = new Contact(contactId, firstName, lastName, phone, address);	
		contact.setLastName("Smith");
		assertEquals(contact.getLastName(), "Smith");
	}
	
	@Test
	@DisplayName("Updating Last Name with a String longer than 10 characters should throw an IllegalArgumentException")
	void testContactUpdateLastNameTooLong() {
		Contact contact = new Contact(contactId, firstName, lastName, phone, address);	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName("Alexandrina");
		});
	}
	
	@Test
	@DisplayName("Updating Last Name with a null argument should throw an IllegalArgumentException")
	void testContactUpdateLastNameNull() {
		Contact contact = new Contact(contactId, firstName, lastName, phone, address);	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setLastName(null);
		});
	}
	
	@Test
	@DisplayName("Creating a contact with a phone number that contains character/s should throw an IllegalArgumentException")
	void testContactPhoneContainsCharacter() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, "40811v111a", address);	
		});
	}
	
	@Test
	@DisplayName("Creating a contact with a phone number that contains less than 10 digits should throw an IllegalArgumentException")
	void testContactPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, "40823344", address);	
		});
	}
	
	@Test
	@DisplayName("Creating a contact with a phone number that contains more than 10 digits should throw an IllegalArgumentException")
	void testContactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, "4082334441125", address);	
		});
	}
	
	@Test
	@DisplayName("Creating a contact with a null phone number should throw an IllegalArgumentException")
	void testContactPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, null, address);	
		});
	}
	
	@Test
	@DisplayName("Update Phone Number")
	void testContactUpdatePhone() {
		Contact contact = new Contact(contactId, firstName, lastName, phone, address);	
		contact.setPhone("9001234567");
		assertTrue(contact.getPhone().equals("9001234567"));
	}
	
	@Test
	@DisplayName("Updating Phone Number that contains character/s should throw an IllegalArgumentException")
	void testContactUpdatePhoneContainCharacter() {
		Contact contact = new Contact(contactId, firstName, lastName, phone, address);	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("40811111k");
		});
	}
	
	@Test
	@DisplayName("Updating Phone Number less than 10 digits should throw an IllegalArgumentException")
	void testContactUpdatePhoneTooShort() {
		Contact contact = new Contact(contactId, firstName, lastName, phone, address);	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("40898754");
		});
	}
	
	@Test
	@DisplayName("Updating Phone Number longer than 10 digits should throw an IllegalArgumentException")
	void testContactUpdatePhoneTooLong() {
		Contact contact = new Contact(contactId, firstName, lastName, phone, address);	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone("40898754123");
		});
	}
	
	@Test
	@DisplayName("Updating Phone Number with a null argument should throw an IllegalArgumentException")
	void testContactUpdatePhoneNull() {
		Contact contact = new Contact(contactId, firstName, lastName, phone, address);	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setPhone(null);
		});
	}
	
	@Test
	@DisplayName("Creating a contact with an address longer than 30 characters should throw an IllegalArgumentException")
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phone, "123 Imagine Str, FakeCity, BurnsState, 50111");	
		});
	}
	
	@Test
	@DisplayName("Creating a contact with a null address should throw an IllegalArgumentException")
	void testContactAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(contactId, firstName, lastName, phone, null);	
			
		});
	}
	
	@Test
	@DisplayName("Update Address")
	void testContactUpdateAddress() {
		Contact contact = new Contact(contactId, firstName, lastName, phone, address);	
		contact.setAddress("987 Doom Str, HifiveCity");
		assertTrue(contact.getAddress().equals("987 Doom Str, HifiveCity"));
	}
	
	@Test
	@DisplayName("Updating Address longer than 30 characters should throw an IllegalArgumentException")
	void testContactUpdateAddressTooLong() {
		Contact contact = new Contact(contactId, firstName, lastName, phone, address);	
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress("9876 SweetTooth, apt 1110, Burnsville, MN, 00000");
		});
	}
	
	@Test
	@DisplayName("Updating Address with a null argument should throw an IllegalArgumentException")
	void testContactUpdateAddressNull() {
		Contact contact = new Contact(contactId, firstName, lastName, phone, address);		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			contact.setAddress(null);
		});
	}
}
