package com.organization.api.exercise.controller;

import com.organization.api.exercise.model.Organization;
import com.organization.api.exercise.model.User;
import com.organization.api.exercise.service.IOrganizationService;
import com.organization.api.exercise.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.*;

@RestController
@RequestMapping(path = "/api")
public class MainController {

    @Autowired
    public IOrganizationService organizationService;

    @Autowired
    public IUserService userService;

    @RequestMapping(value = "/add/organization", method = RequestMethod.GET)
    public String addOrganization(@RequestParam String name,
                                  @RequestParam Optional<String> address,
                                  @RequestParam Optional<String> phone){
        String addressValue = address.orElse(null);
        String phoneValue = phone.orElse(null);
        return organizationService.addOrganization(name, addressValue, phoneValue);
    }

    @RequestMapping(value = "/add/user", method = RequestMethod.GET)
    public String addUser(@RequestParam String userId,
                          @RequestParam String firstName,
                          @RequestParam String lastName,
                          @RequestParam Optional<String> email,
                          @RequestParam Optional<String> address,
                          @RequestParam Optional<String> phone){
        String emailValue = email.orElse(null);
        String addressValue = address.orElse(null);
        String phoneValue = phone.orElse(null);

        return userService.addUser(userId, firstName, lastName, emailValue, addressValue, phoneValue);
    }

    @RequestMapping(value = "/add/user/organization", method = RequestMethod.GET)
    public String addUserToOrganization(@RequestParam String userId,
                                  @RequestParam String name){

        // Check if both user and organization are valid.
        if(!organizationService.checkIfOrganizationExists(name) ||
                !userService.checkIfUserExists(userId)){
            return "<h1>Please enter a valid organization and a valid user.</h1>";
        }

        userService.addOrganizationToUser(userId, name);
        return organizationService.addUserToOrganization(userId, name);
    }

    @RequestMapping(value = "/delete/user/organization", method = RequestMethod.GET)
    public String deleteUserFromOrganization(@RequestParam String userId,
                                        @RequestParam String name){

        // Check if both user and organization are valid.
        if(!organizationService.checkIfOrganizationExists(name) ||
                !userService.checkIfUserExists(userId)){
            return "<h1>Please enter a valid organization and a valid user.</h1>";
        }

        userService.deleteOrganizationFromUser(userId, name);
        return organizationService.deleteUserFromOrganization(userId, name);
    }

    @RequestMapping(value = "/get/user/organization", method = RequestMethod.GET)
    public HashSet<User> getUsersInOrganization(@RequestParam String name){

        // Check if organization is valid.
        if(!organizationService.checkIfOrganizationExists(name)){
            return new HashSet<>();
        }


        HashSet<String> users = organizationService.getUsersInOrganization(name);

        return userService.getUsers(users);
    }

    @RequestMapping(value = "/get/organization/user", method = RequestMethod.GET)
    public HashSet<Organization> getOrganizationsForUser(@RequestParam String userId){

        // Check if user is valid.
        if(!userService.checkIfUserExists(userId)){
            return new HashSet<>();
        }

        HashSet<String> organizations = userService.getOrganizationsForUser(userId);

        return organizationService.getOrganizations(organizations);
    }
}
