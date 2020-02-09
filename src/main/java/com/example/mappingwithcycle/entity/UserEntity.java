package com.example.mappingwithcycle.entity;

public class UserEntity {
    private UserProfileEntity userProfileEntity;

    public UserProfileEntity getUserProfileEntity() {
        return userProfileEntity;
    }

    public void setUserProfileEntity(UserProfileEntity userProfileEntity) {
        this.userProfileEntity = userProfileEntity;
    }
}
