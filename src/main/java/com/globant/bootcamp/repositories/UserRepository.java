package com.globant.bootcamp.repositories;

import com.globant.bootcamp.objects.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
}
