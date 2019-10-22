package com.organization.api.exercise.service;


import com.organization.api.exercise.model.Organization;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

@Service("organizationService")
public class OrganizationServiceImpl implements IOrganizationService {

    HashMap<String, Organization> organizationMap = new HashMap<>();
    HashMap<String, HashSet<String>> organizationUserMap = new HashMap<>();
    @PostConstruct
    private void init() {
        // This is executed at the start of the service.
    }

    @Override
    public String addOrganization(String name, String address, String phone) {
        if(organizationMap.containsKey(name)){
            return "<h1>Name already exists, please choose a different Name.</h1>";
        } else{
            Organization newOrganization = new Organization(name, address, phone);
            organizationMap.put(name, newOrganization);
        }

        return "<h1>The organization has been added succesfully.</h1>";
    }

    @Override
    public boolean checkIfOrganizationExists(String name){
        return organizationMap.containsKey(name);
    }

    @Override
    public String addUserToOrganization(String userId, String name) {
        if(organizationMap.containsKey(name)){
            if(!organizationUserMap.containsKey(name)){
                HashSet<String> usersInOrg = new HashSet<>();
                usersInOrg.add(userId);
                organizationUserMap.put(name, usersInOrg);
            }else{
                HashSet<String> usersInOrg = organizationUserMap.get(name);
                usersInOrg.add(userId);
                organizationUserMap.put(name, usersInOrg);
            }

            return "<h1>User added to org successfully</h1>";
        }else{
            return "<h1>Please create this organization before adding user</h1>";
        }
    }

    @Override
    public String deleteUserFromOrganization(String userId, String name) {
        if(organizationMap.containsKey(name)){
            if(organizationUserMap.containsKey(name)){
                HashSet<String> usersForOrg = organizationUserMap.get(name);
                usersForOrg.remove(userId);
                organizationUserMap.put(name, usersForOrg);
            }
        }
        return "<h1>User deleted from organization successfully.</h1>";
    }

    @Override
    public HashSet<Organization> getOrganizations(HashSet<String> names){
        HashSet<Organization> result = new HashSet<>();

        for(String name : names){
            Organization oneOrganization = organizationMap.get(name);
            result.add(oneOrganization);
        }

        return result;
    }

    @Override
    public HashSet<String> getUsersInOrganization(String name){
        return organizationUserMap.get(name);
    }


}
