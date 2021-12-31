package com.ratnesh.mongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratnesh.mongo.document.User;
import com.ratnesh.mongo.dto.UserDto;
import com.ratnesh.mongo.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public User getOne(@PathVariable("id") Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return user.get();
		}
		return null;
	}

	@PostMapping
	public User create(@RequestBody UserDto userDto) {
		return userRepository.save(new User(userDto.getId(), userDto.getName(), userDto.getSalary()));
	}

	@PutMapping("/{id}")
	public User update(@RequestBody UserDto userDto, @PathVariable("id") Integer id) {
		return userRepository.save(new User(id, userDto.getName(), userDto.getSalary()));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		userRepository.deleteById(id);
	}

}