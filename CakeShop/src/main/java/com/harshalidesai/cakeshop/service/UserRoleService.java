package com.harshalidesai.cakeshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.harshalidesai.cakeshop.entity.User;

@Service
public interface UserRoleService {

	public List<User> fetchAllUser();
	public User fetchUserById(Integer id);
	public String saveUser(User user);
	public String deleteUserById(Integer id);
}
