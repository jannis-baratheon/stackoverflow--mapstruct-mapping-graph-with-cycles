package com.example.mappingwithcycle.mapper;

import com.example.mappingwithcycle.domain.User;
import com.example.mappingwithcycle.domain.UserProfile;
import com.example.mappingwithcycle.entity.UserEntity;
import com.example.mappingwithcycle.entity.UserProfileEntity;
import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "userProfileEntity", source = "userProfile")
    UserEntity mapToEntity(User user,
                           @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @InheritInverseConfiguration
    User mapToDomain(UserEntity userEntity,
                     @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @Mapping(target = "userEntity", source = "user")
    UserProfileEntity mapToEntity(UserProfile userProfile,
                                  @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    @InheritInverseConfiguration
    UserProfile mapToDomain(UserProfileEntity userProfileEntity,
                            @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}

