package com.organization.api.exercise.service;

import com.organization.api.exercise.model.Organization;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IOrganizationService {

    String addOrganization(String name, String address, String phone);
    boolean checkIfOrganizationExists(String name);

    String addUserToOrganization(String userId, String name);

    String deleteUserFromOrganization(String userId, String name);

    HashSet<String> getUsersInOrganization(String name);

    HashSet<Organization> getOrganizations(HashSet<String> names);
}
