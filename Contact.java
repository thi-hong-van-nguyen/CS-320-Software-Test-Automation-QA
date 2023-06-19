package contact;

public class Contact {
    private String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
    	// Validate and throw error if the arguments are not valid
    	validateId(contactId);    	
    	validateFirstName(firstName);
    	validateLastName(lastName);
    	validatePhone(phone);
    	validateAddress(address);		
    	
    	// Set the variables to arguments
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Since Id should not be updatable, there will be only Getter, no Setter for contactId
    public String getContactId() {
        return contactId;
    }

    // Getter for First Name
    public String getFirstName() {
        return firstName;
    }

    // Setter for First Name
    public void setFirstName(String firstName) {
    	validateFirstName(firstName);
        this.firstName = firstName;
    }

    // Getter for Last Name
    public String getLastName() {
        return lastName;
    }
    
    // Setter for Last Name
    public void setLastName(String lastName) {
    	validateLastName(lastName);
        this.lastName = lastName;
    }

    // Getter for Phone
    public String getPhone() {
        return phone;
    }

    // Setter for Phone
    public void setPhone(String phone) {
    	validatePhone(phone);
        this.phone = phone;
    }

    // Getter for Address
    public String getAddress() {
        return address;
    }

    // Setter for Address
    public void setAddress(String address) {
    	validateAddress(address);
        this.address = address;
    }
    
    /////////////////////////////////////////////////////
    //    ARGUMENTS VALIDATIONS
	/////////////////////////////////////////////////////
    // unique contact ID string that cannot be longer than 10 characters. The contact ID shall not be null
    private void validateId(String id) {
    	if(id == null || id.length() > 10) {
    		throw new IllegalArgumentException("Invalid id.");
    	}
    }
    
    // firstName String field that cannot be longer than 10 characters. The firstName field shall not be null.
    private void validateFirstName(String firstName) {
    	if(firstName == null || firstName.length() > 10) {
    		throw new IllegalArgumentException("Invalid first name.");
    	}    	
    }
    
	// lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.
    private void validateLastName(String lastName) {
    	if(lastName == null || lastName.length() > 10) {
    		throw new IllegalArgumentException("Invalid last name.");
    	}    	
    }
    
    // phone String field must be exactly 10 digits. The phone field shall not be null.
    private void validatePhone(String phone){
    	if(phone == null || !phone.matches("\\d{10}")) {
    		throw new IllegalArgumentException("Invalid phone number.");
    	}
    }
    
    // address field must be no longer than 30 characters. The address field shall not be null.
    private void validateAddress(String address) {
    	if(address == null || address.length() > 30) {
    		throw new IllegalArgumentException("Invalid address.");
    	}
    }
}
