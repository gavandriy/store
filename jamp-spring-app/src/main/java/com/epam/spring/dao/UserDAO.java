package com.epam.spring.dao;

import com.epam.spring.model.User;

public interface UserDAO extends CommonDAO<User> {

	User getUserByEmail(String email);

}
