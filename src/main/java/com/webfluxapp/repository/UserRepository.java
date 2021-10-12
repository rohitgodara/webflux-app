package com.webfluxapp.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

import com.webfluxapp.entity.User;

import reactor.core.publisher.Flux;

@Repository
public interface UserRepository extends ReactiveSortingRepository<User, Long> {

	Flux<User> findAllBy(Pageable pageable);
	

}
