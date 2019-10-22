# user-organization-exercise

## Prequisites

 - Java 1.8

## Building and running

 - Execute the following from command line
 
```bash
mvn clean install spring-boot:run
```

## API
 - After running the application, all api's start from the path:
 ```http://localhost:8080/api```
 
 1. Create a single Organization:
 
    ```http://localhost:8080/api/add/organization?{queryParam1=value&queryParamN=value}```
      
    Supported Query parameters:
    - Name - required and must be unique
    - Address
    - Phone
 
 2. Create a single User:
 
    ```http://localhost:8080/api/add/user?{queryParam1=value&queryParamN=value}```
    
    Supported Query parameters:
    - UserId  - required and must be unique
    - First Name - required
    - Last Name - required
    - Email
    - Address
    - Phone
   
 3. Add a User to an Organization:
 
     ```http://localhost:8080/api/add/user/organization?{queryParam1=value&queryParamN=value}```
    
    Supported Query parameters:
    - UserId - required and must already be created previously.
    - Name - required and must already be created previously.
   
 4. Delete a User from an Organization:
 
     ```http://localhost:8080/api/delete/user/organization?{queryParam1=value&queryParamN=value}```
     
    Supported Query parameters:
    - UserId - required and must already be created previously
    - Name - required and must already be created previously
  
 5. Read all Users who belong to a specific Organization:
 
     ```http://localhost:8080/api/get/user/organization?{queryParam1=value&queryParamN=value}```
        
    Supported Query parameters:
    - Name - required and must already be created previously.
 
 6. Read all Organizations to which a User belongs:
 
     ```http://localhost:8080/api/get/user/organization?{queryParam1=value&queryParamN=value}```
    
    Supported Query parameters:
    - UserId - required and must already be created previously.

## Notes/Limitations
 - Ideally we should handle all the error pages on /api, and the /error page, not done in the interest of time.
 - We do not validate the user input except organization name and userId which are expected to be unique. Ideally fields like email, phone number should be validated.
