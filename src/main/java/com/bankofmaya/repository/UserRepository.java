package com.bankofmaya.repository;

import com.bankofmaya.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Boolean existsByEmail(String email);
//    Boolean existsByPhoneNumber(String phone);


}
