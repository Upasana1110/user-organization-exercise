package com.organization.api.exercise.service;

import com.organization.api.exercise.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;

@Service("userService")
public class UserServiceImpl implements IUserService{
    HashMap<String, User> userMap = new HashMap<>();
    HashMap<String, ArrayList<String>> userOrganizationMap = new HashMap<>();

    @PostConstruct
    private void init() {
        // This is executed at the start of the service.
    }

    @Override
    public String addUser(String userId, String firstName, String lastName, String email, String address, String phone) {
        if(userMap.containsKey(userId)){
            return "<h1>userId: '" + userId + "' already exists, please choose a different userId.</h1>";
        } else{
            User newUser = new User(userId, firstName, lastName, email, address, phone);
            userMap.put(userId, newUser);
        }

        return "<h1>The User has been added succesfully.</h1>";
    }

    @Override
    public boolean checkIfUserExists(String name){
        return userMap.containsKey(name);
    }

    @Override
    public void addOrganizationToUser(String userId, String name) {
        if(userMap.containsKey(userId)){
            if(!userOrganizationMap.containsKey(userId)){
                ArrayList<String> orgList = new ArrayList<>();
                orgList.add(name);
                userOrganizationMap.put(userId, orgList);
            }else{
                ArrayList<String> orgsForUser = userOrganizationMap.get(userId);
                orgsForUser.add(name);
                userOrganizationMap.put(userId, orgsForUser);
            }
        }
    }

    @Override
    public void deleteOrganizationFromUser(String userId, String name) {
        if(userMap.containsKey(userId)){
            if(userOrganizationMap.containsKey(userId)){
                ArrayList<String> orgsForUser = userOrganizationMap.get(userId);
                orgsForUser.remove(name);
                userOrganizationMap.put(userId, orgsForUser);
            }
        }
    }

    @Override
    public ArrayList<User> getUsers(ArrayList<String> userIds) {
        ArrayList<User> result = new ArrayList<>();

        for(String userId : userIds){
            User oneUser = userMap.get(userId);
            result.add(oneUser);
        }

        return result;
    }

    @Override
    public ArrayList<String> getOrganizationsForUser(String userId){
        return userOrganizationMap.get(userId);
    }
}
