package com.appsstuff.pattern.proxy.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appsstuff.pattern.proxy.domian.Auther;

@Repository
public interface AutherRepos extends JpaRepository<Auther , String> {
	
}
