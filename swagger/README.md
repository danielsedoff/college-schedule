# swagger-java-client

## Requirements

Building the API client library requires [Maven](https://maven.apache.org/) to be installed.

## Installation

To install the API client library to your local Maven repository, simply execute:

```shell
mvn install
```

To deploy it to a remote Maven repository instead, configure the settings of the repository and execute:

```shell
mvn deploy
```

Refer to the [official documentation](https://maven.apache.org/plugins/maven-deploy-plugin/usage.html) for more information.

### Maven users

Add this dependency to your project's POM:

```xml
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-java-client</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

### Gradle users

Add this dependency to your project's build file:

```groovy
compile "io.swagger:swagger-java-client:1.0.0"
```

### Others

At first generate the JAR by executing:

    mvn package

Then manually install the following JARs:

* target/swagger-java-client-1.0.0.jar
* target/lib/*.jar

## Getting Started

Please follow the [installation](#installation) instruction and execute the following Java code:

```java

import io.swagger.client.*;
import io.swagger.client.auth.*;
import io.swagger.client.model.*;
import io.swagger.client.api.CourserestcontrollerApi;

import java.io.File;
import java.util.*;

public class CourserestcontrollerApiExample {

    public static void main(String[] args) {
        
        CourserestcontrollerApi apiInstance = new CourserestcontrollerApi();
        CourseDTO resource = new CourseDTO(); // CourseDTO | resource
        try {
            String result = apiInstance.createUsingPOST(resource);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling CourserestcontrollerApi#createUsingPOST");
            e.printStackTrace();
        }
    }
}

```

## Documentation for API Endpoints

All URIs are relative to *https://localhost:8080/*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*CourserestcontrollerApi* | [**createUsingPOST**](docs/CourserestcontrollerApi.md#createUsingPOST) | **POST** /courses | create
*CourserestcontrollerApi* | [**deleteUsingDELETE**](docs/CourserestcontrollerApi.md#deleteUsingDELETE) | **DELETE** /courses/{id} | delete
*CourserestcontrollerApi* | [**findAllUsingGET**](docs/CourserestcontrollerApi.md#findAllUsingGET) | **GET** /courses | findAll
*CourserestcontrollerApi* | [**findByIdUsingGET**](docs/CourserestcontrollerApi.md#findByIdUsingGET) | **GET** /courses/{id} | findById
*CourserestcontrollerApi* | [**updateUsingPUT**](docs/CourserestcontrollerApi.md#updateUsingPUT) | **PUT** /courses/{id} | update
*CoursewebcontrollerApi* | [**createCourseUsingPOST**](docs/CoursewebcontrollerApi.md#createCourseUsingPOST) | **POST** /createCourse | createCourse
*CoursewebcontrollerApi* | [**deleteCourseUsingPOST**](docs/CoursewebcontrollerApi.md#deleteCourseUsingPOST) | **POST** /deleteCourse | deleteCourse
*CoursewebcontrollerApi* | [**gedItParamUsingGET**](docs/CoursewebcontrollerApi.md#gedItParamUsingGET) | **GET** /courseForm | gedItParam
*CoursewebcontrollerApi* | [**getCoursesUsingGET**](docs/CoursewebcontrollerApi.md#getCoursesUsingGET) | **GET** /courseList | getCourses
*CoursewebcontrollerApi* | [**updateCourseUsingPOST**](docs/CoursewebcontrollerApi.md#updateCourseUsingPOST) | **POST** /updateCourse | updateCourse
*GrouprestcontrollerApi* | [**createUsingPOST1**](docs/GrouprestcontrollerApi.md#createUsingPOST1) | **POST** /groups | create
*GrouprestcontrollerApi* | [**deleteUsingDELETE1**](docs/GrouprestcontrollerApi.md#deleteUsingDELETE1) | **DELETE** /groups/{id} | delete
*GrouprestcontrollerApi* | [**findAllUsingGET1**](docs/GrouprestcontrollerApi.md#findAllUsingGET1) | **GET** /groups | findAll
*GrouprestcontrollerApi* | [**findByIdUsingGET1**](docs/GrouprestcontrollerApi.md#findByIdUsingGET1) | **GET** /groups/{id} | findById
*GrouprestcontrollerApi* | [**updateUsingPUT1**](docs/GrouprestcontrollerApi.md#updateUsingPUT1) | **PUT** /groups/{id} | update
*GroupwebcontrollerApi* | [**createGroupUsingPOST**](docs/GroupwebcontrollerApi.md#createGroupUsingPOST) | **POST** /createGroup | createGroup
*GroupwebcontrollerApi* | [**deleteGroupUsingPOST**](docs/GroupwebcontrollerApi.md#deleteGroupUsingPOST) | **POST** /deleteGroup | deleteGroup
*GroupwebcontrollerApi* | [**gedItParamUsingGET1**](docs/GroupwebcontrollerApi.md#gedItParamUsingGET1) | **GET** /groupForm | gedItParam
*GroupwebcontrollerApi* | [**getGroupsUsingGET**](docs/GroupwebcontrollerApi.md#getGroupsUsingGET) | **GET** /groupList | getGroups
*GroupwebcontrollerApi* | [**updateGroupUsingPOST**](docs/GroupwebcontrollerApi.md#updateGroupUsingPOST) | **POST** /updateGroup | updateGroup
*LessonrestcontrollerApi* | [**createUsingPOST2**](docs/LessonrestcontrollerApi.md#createUsingPOST2) | **POST** /lessons | create
*LessonrestcontrollerApi* | [**deleteUsingDELETE2**](docs/LessonrestcontrollerApi.md#deleteUsingDELETE2) | **DELETE** /lessons/{id} | delete
*LessonrestcontrollerApi* | [**findAllUsingGET2**](docs/LessonrestcontrollerApi.md#findAllUsingGET2) | **GET** /lessons | findAll
*LessonrestcontrollerApi* | [**findByIdUsingGET2**](docs/LessonrestcontrollerApi.md#findByIdUsingGET2) | **GET** /lessons/{id} | findById
*LessonrestcontrollerApi* | [**updateUsingPUT2**](docs/LessonrestcontrollerApi.md#updateUsingPUT2) | **PUT** /lessons/{id} | update
*LessonwebcontrollerApi* | [**createLessonUsingPOST**](docs/LessonwebcontrollerApi.md#createLessonUsingPOST) | **POST** /createLesson | createLesson
*LessonwebcontrollerApi* | [**deleteLessonUsingPOST**](docs/LessonwebcontrollerApi.md#deleteLessonUsingPOST) | **POST** /deleteLesson | deleteLesson
*LessonwebcontrollerApi* | [**getIdParamUsingGET**](docs/LessonwebcontrollerApi.md#getIdParamUsingGET) | **GET** /lessonForm | getIdParam
*LessonwebcontrollerApi* | [**getLessonsUsingGET**](docs/LessonwebcontrollerApi.md#getLessonsUsingGET) | **GET** /lessonList | getLessons
*LessonwebcontrollerApi* | [**updateLessonUsingPOST**](docs/LessonwebcontrollerApi.md#updateLessonUsingPOST) | **POST** /updateLesson | updateLesson
*MainpagecontrollerApi* | [**mainUsingGET**](docs/MainpagecontrollerApi.md#mainUsingGET) | **GET** / | main
*ProfessorrestcontrollerApi* | [**createUsingPOST3**](docs/ProfessorrestcontrollerApi.md#createUsingPOST3) | **POST** /professors | create
*ProfessorrestcontrollerApi* | [**deleteUsingDELETE3**](docs/ProfessorrestcontrollerApi.md#deleteUsingDELETE3) | **DELETE** /professors/{id} | delete
*ProfessorrestcontrollerApi* | [**findAllUsingGET3**](docs/ProfessorrestcontrollerApi.md#findAllUsingGET3) | **GET** /professors | findAll
*ProfessorrestcontrollerApi* | [**findByIdUsingGET3**](docs/ProfessorrestcontrollerApi.md#findByIdUsingGET3) | **GET** /professors/{id} | findById
*ProfessorrestcontrollerApi* | [**updateUsingPUT3**](docs/ProfessorrestcontrollerApi.md#updateUsingPUT3) | **PUT** /professors/{id} | update
*ProfessorwebcontrollerApi* | [**createProfessorUsingPOST**](docs/ProfessorwebcontrollerApi.md#createProfessorUsingPOST) | **POST** /createProfessor | createProfessor
*ProfessorwebcontrollerApi* | [**deleteProfessorUsingPOST**](docs/ProfessorwebcontrollerApi.md#deleteProfessorUsingPOST) | **POST** /deleteProfessor | deleteProfessor
*ProfessorwebcontrollerApi* | [**getIdParamUsingGET1**](docs/ProfessorwebcontrollerApi.md#getIdParamUsingGET1) | **GET** /professorForm | getIdParam
*ProfessorwebcontrollerApi* | [**getProfessorsUsingGET**](docs/ProfessorwebcontrollerApi.md#getProfessorsUsingGET) | **GET** /professorList | getProfessors
*ProfessorwebcontrollerApi* | [**updateProfessorUsingPOST**](docs/ProfessorwebcontrollerApi.md#updateProfessorUsingPOST) | **POST** /updateProfessor | updateProfessor
*StudentrestcontrollerApi* | [**createUsingPOST4**](docs/StudentrestcontrollerApi.md#createUsingPOST4) | **POST** /students | create
*StudentrestcontrollerApi* | [**deleteUsingDELETE4**](docs/StudentrestcontrollerApi.md#deleteUsingDELETE4) | **DELETE** /students/{id} | delete
*StudentrestcontrollerApi* | [**findAllUsingGET4**](docs/StudentrestcontrollerApi.md#findAllUsingGET4) | **GET** /students | findAll
*StudentrestcontrollerApi* | [**findByIdUsingGET4**](docs/StudentrestcontrollerApi.md#findByIdUsingGET4) | **GET** /students/{id} | findById
*StudentrestcontrollerApi* | [**updateUsingPUT4**](docs/StudentrestcontrollerApi.md#updateUsingPUT4) | **PUT** /students/{id} | update
*StudentwebcontrollerApi* | [**createStudentUsingPOST**](docs/StudentwebcontrollerApi.md#createStudentUsingPOST) | **POST** /createStudent | createStudent
*StudentwebcontrollerApi* | [**deleteStudentUsingPOST**](docs/StudentwebcontrollerApi.md#deleteStudentUsingPOST) | **POST** /deleteStudent | deleteStudent
*StudentwebcontrollerApi* | [**getIdParamUsingGET2**](docs/StudentwebcontrollerApi.md#getIdParamUsingGET2) | **GET** /studentForm | getIdParam
*StudentwebcontrollerApi* | [**getStudentsUsingGET**](docs/StudentwebcontrollerApi.md#getStudentsUsingGET) | **GET** /studentList | getStudents
*StudentwebcontrollerApi* | [**updateStudentUsingPOST**](docs/StudentwebcontrollerApi.md#updateStudentUsingPOST) | **POST** /updateStudent | updateStudent


## Documentation for Models

 - [CourseDTO](docs/CourseDTO.md)
 - [GroupDTO](docs/GroupDTO.md)
 - [LessonDTO](docs/LessonDTO.md)
 - [ProfessorDTO](docs/ProfessorDTO.md)
 - [StudentDTO](docs/StudentDTO.md)


## Documentation for Authorization

All endpoints do not require authorization.
Authentication schemes defined for the API:

## Recommendation

It's recommended to create an instance of `ApiClient` per thread in a multithreaded environment to avoid any potential issue.

## Author

sedoff@zohomail.com

