package com.example.mappingwithcycle.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.mappingwithcycle.UserMapperImpl;
import com.example.mappingwithcycle.domain.User;
import com.example.mappingwithcycle.domain.UserProfile;
import com.example.mappingwithcycle.entity.UserEntity;
import com.example.mappingwithcycle.entity.UserProfileEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserMapperTest {

    private UserMapper sut;

    @BeforeEach
    void beforeEach() {
        sut = new UserMapperImpl();
    }

    @Test
    void mapsUserDomainObjectToEntity() {
        User user = new User();
        UserProfile userProfile = new UserProfile();
        user.setUserProfile(userProfile);
        userProfile.setUser(user);

        UserEntity mappedUserEntity = sut.mapToEntity(user,
            new CycleAvoidingMappingContext());

        assertThat(mappedUserEntity)
            .isNotNull()
            .extracting("userProfileEntity.userEntity")
            .isSameAs(mappedUserEntity);
    }

    @Test
    void mapsUserEntityToDomainObject() {
        UserEntity userEntity = new UserEntity();
        UserProfileEntity userProfileEntity = new UserProfileEntity();
        userEntity.setUserProfileEntity(userProfileEntity);
        userProfileEntity.setUserEntity(userEntity);

        User mappedUser = sut.mapToDomain(userEntity,
            new CycleAvoidingMappingContext());

        assertThat(mappedUser)
            .isNotNull()
            .extracting("userProfile.user")
            .isSameAs(mappedUser);
    }
}
