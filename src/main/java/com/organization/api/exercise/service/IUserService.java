package com.organization.api.exercise.service;

import com.organization.api.exercise.model.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface IUserService {

    String addUser(String userId, String firstName, String lastName, String email, String address, String phone);

    boolean checkIfUserExists(String userId);

    void addOrganizationToUser(String userId, String name);

    void deleteOrganizationFromUser(String userId, String name);

     ArrayList<User> getUsers(ArrayList<String> userIds);

     ArrayList<String> getOrganizationsForUser(String userId);
}
