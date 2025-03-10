package com.yaksha.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yaksha.assignment.models.User;

@Service
public class UserService {

	// Simulating an in-memory list to store registered users
	private List<User> users = new ArrayList<>();

	/**
	 * Registers a new user and stores it in the in-memory list.
	 * 
	 * @param user - The user to be registered.
	 */
	public void registerUser(User user) {
		// Save user in memory (in a real-world scenario, this would save the user to a
		// database)
		user.setId(generateUserId());
		users.add(user);
		System.out.println("User registered: " + user.getName());
	}

	/**
	 * Generates a new unique user ID.
	 * 
	 * @return A unique user ID.
	 */
	private long generateUserId() {
		return users.size() + 1; // Just a simple ID generation logic for demo
	}

	/**
	 * Retrieves a list of all registered users.
	 * 
	 * @return List of all registered users.
	 */
	public List<User> getAllUsers() {
		return users;
	}

	/**
	 * Finds a user by their ID.
	 * 
	 * @param id - The ID of the user to be fetched.
	 * @return The user with the specified ID, or null if not found.
	 */
	public User getUserById(long id) {
		return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
	}

	/**
	 * Updates an existing user's details.
	 * 
	 * @param updatedUser - The user with updated information.
	 * @return true if the user was updated, false otherwise.
	 */
	public boolean updateUser(User updatedUser) {
		User existingUser = getUserById(updatedUser.getId());

		if (existingUser == null) {
			return false; // User not found
		}

		existingUser.setName(updatedUser.getName());
		existingUser.setEmail(updatedUser.getEmail());
		existingUser.setPassword(updatedUser.getPassword());
		return true;
	}

	/**
	 * Deletes a user by their ID.
	 * 
	 * @param id - The ID of the user to be deleted.
	 * @return true if the user was deleted, false otherwise.
	 */
	public boolean deleteUser(long id) {
		return users.removeIf(user -> user.getId() == id);
	}
}
