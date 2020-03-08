package com.ecommerce.ecommerce.repository;

import com.ecommerce.ecommerce.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserReprository extends JpaRepository<User, Integer> {
}
