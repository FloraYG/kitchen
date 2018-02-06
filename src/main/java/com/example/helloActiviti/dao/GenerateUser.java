package com.example.helloActiviti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.helloActiviti.domain.UserInfo;

/**
 * Created by guang.yang on 2017-11-07.
 */
public interface GenerateUser extends JpaRepository<UserInfo,Long>{
}
