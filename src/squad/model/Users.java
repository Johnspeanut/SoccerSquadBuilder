package squad.model;

public class Users {
	protected String userName;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected long budget;
	
	
	public Users(String userName, String password, String firstName, String lastName, String email, long budget) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.budget = budget;
	}


	
	public Users(String userName, String password, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}



	public Users(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public Users(String userName) {
		super();
		this.userName = userName;
	}



	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getBudget() {
		return budget;
	}


	public void setBudget(long budget) {
		this.budget = budget;
	}

	

}