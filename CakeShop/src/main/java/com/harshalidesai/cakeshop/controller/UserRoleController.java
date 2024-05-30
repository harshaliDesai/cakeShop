package com.harshalidesai.cakeshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshalidesai.cakeshop.entity.User;
import com.harshalidesai.cakeshop.service.UserRoleService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value="/userrole")
public class UserRoleController {

	@Autowired
	private UserRoleService userRoleService;

	@GetMapping("/fetchAllUser")
	public ResponseEntity<String> fetchAllUser(){

		List<User> userList = null;
		try {
			userList = userRoleService.fetchAllUser();
		}catch(Exception e) {
			e.printStackTrace();
			log.error(":: Error in fetchAllUser() ::");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(userList.toString(),HttpStatus.OK);
	}
	
	@GetMapping("/fetchUserById/{id}")
	public User fetchUserById(@PathVariable Integer id){

		User user = null;
		try {
			user = userRoleService.fetchUserById(id);
		}catch(Exception e) {
			e.printStackTrace();
			log.error(":: Error in fetchUserById() ::");
		}
		return user;
	}
	
	@PostMapping(value="/saveUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveUser(@RequestBody User user){
		
		String response = null;
		
		try {
			response = userRoleService.saveUser(user);
			if(null == response) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			e.printStackTrace();
			log.error(":: Error in saveUser() ::");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteUserById/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Integer id){
		
		String response = null;
		
		try {
			response = userRoleService.deleteUserById(id);
			if(null == response) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			e.printStackTrace();
			log.error(":: Error in deleteUserById() ::");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
