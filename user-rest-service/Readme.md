#User-rest-service

- Tech Stack - Spring boot starter web.
  (JPA will be upgraded later)
- Exposes 4 URIs for the USER resource.
- User data is persisted in a local array.
  - features added - 1) Centralized exception handling
                     2) Internationalization
                     3) Hateos
                     4) Open API swagger specification
                     5) Data validation through Validation API
  - Collections:
    - Hello world.postman_collection.json (internationalization)
    - Open APi.postman_collection.json (Open API swagger generation)
    - User rest services.postman_collection.json (User resource URIs)
  

  - To run the application:
    - mvn clean install
    - cd target
    - java -jar user-rest-service-0.0.1-SNAPSHOT.jar
