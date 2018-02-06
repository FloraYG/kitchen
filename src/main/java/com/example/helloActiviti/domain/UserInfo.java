package com.example.helloActiviti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by guang.yang on 2017-11-07.
 */
@Entity
public class UserInfo {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String group;

    public UserInfo(){

    }

    public UserInfo(String userName, String group){
        this.group = group;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
