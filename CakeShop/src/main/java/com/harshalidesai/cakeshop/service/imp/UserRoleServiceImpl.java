package com.harshalidesai.cakeshop.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshalidesai.cakeshop.entity.User;
import com.harshalidesai.cakeshop.repository.UserRoleRepository;
import com.harshalidesai.cakeshop.service.UserRoleService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepo;

	@Override
	public List<User> fetchAllUser() {

		List<User> userList = null;

		try {
			userList = userRoleRepo.findAll();
		}catch(Exception e) {
			e.printStackTrace();
			log.error(":: Error in fetchAllUser() :: ");
		}
		return userList;
	}

	@Override
	public User fetchUserById(Integer id) {
		User user = null;
	
		try {
			user = userRoleRepo.getReferenceById(id);
		}catch(Exception e) {
			e.printStackTrace();
			log.error(":: Error in fetchUserById() :: ");
		}
		return user;
	}

	@Override
	public String saveUser(User user) {
		
		String response = null;
		try {
			userRoleRepo.save(user);
			response = "User saved successfully";
		}catch(Exception e) {
			e.printStackTrace();
			log.error(":: Error in saveUser() :: ");
			response = "Error while saving user";
		}
		return response;
	}

	@Override
	public String deleteUserById(Integer id) {
	
		String response = null;
		try {
			 userRoleRepo.deleteById(id);
			 response = "User deleted successfully";
		}catch(Exception e) {
			e.printStackTrace();
			log.error(":: Error in deleteUserById() :: ");
			response = "Error while deleting user";
		}
		return response;
	}

}
