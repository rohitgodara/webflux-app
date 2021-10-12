package com.webfluxapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.webfluxapp.entity.User;
import com.webfluxapp.exception.UserNotFoundException;
import com.webfluxapp.form.UserForm;
import com.webfluxapp.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public Mono<User> register(UserForm userForm) {
		return repository.save(new User(userForm.getName())).log();
	}

	public Mono<User> findById(Long id) {
		return repository.findById(id).doOnSuccess(user -> {
			if (user == null) {
				throw new UserNotFoundException(HttpStatus.NOT_FOUND, "username is required");
			}
		});
	}

	public Flux<List<User>> findAll() {
		return repository.findAll().buffer(2);
	}

	public Mono<Object> findAllUsers(PageRequest pageRequest) {
		return this.repository.findAllBy(pageRequest).collectList().zipWith(this.repository.count())
				.map(t -> new PageImpl<>(t.getT1(), pageRequest, t.getT2()));
	}

}
