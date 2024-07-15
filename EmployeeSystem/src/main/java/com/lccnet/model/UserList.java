package com.lccnet.model;
import java.util.ArrayList;
public class UserList {
	private ArrayList<User> users=new ArrayList<User> ();

	public UserList(User user) {
		super();
		users.add(user);
	}

	public ArrayList getUsers() {
		return users;
	}
	
	
}
