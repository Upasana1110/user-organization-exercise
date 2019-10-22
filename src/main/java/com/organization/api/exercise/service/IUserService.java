package com.organization.api.exercise.service;

import com.organization.api.exercise.model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

public interface IUserService {

    String addUser(String userId, String firstName, String lastName, String email, String address, String phone);

    boolean checkIfUserExists(String userId);

    void addOrganizationToUser(String userId, String name);

    void deleteOrganizationFromUser(String userId, String name);

    HashSet<User> getUsers(HashSet<String> userIds);

    HashSet<String> getOrganizationsForUser(String userId);
}
