package user;

import javax.tools.DocumentationTool.Location;

public class User {
	 	private String id;
	    private String firstname;
	    private String lastname;
	    private Location location;
	    private String email;
		public User(String string, String string2, String string3,
				org.springframework.beans.factory.parsing.Location location2, String string4) {
			// TODO Auto-generated constructor stub
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public Location getLocation() {
			return location;
		}
		public void setLocation(Location location) {
			this.location = location;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}

}
