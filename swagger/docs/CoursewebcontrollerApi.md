# CoursewebcontrollerApi

All URIs are relative to *https://localhost:8080/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createCourseUsingPOST**](CoursewebcontrollerApi.md#createCourseUsingPOST) | **POST** /createCourse | createCourse
[**deleteCourseUsingPOST**](CoursewebcontrollerApi.md#deleteCourseUsingPOST) | **POST** /deleteCourse | deleteCourse
[**gedItParamUsingGET**](CoursewebcontrollerApi.md#gedItParamUsingGET) | **GET** /courseForm | gedItParam
[**getCoursesUsingGET**](CoursewebcontrollerApi.md#getCoursesUsingGET) | **GET** /courseList | getCourses
[**updateCourseUsingPOST**](CoursewebcontrollerApi.md#updateCourseUsingPOST) | **POST** /updateCourse | updateCourse


<a name="createCourseUsingPOST"></a>
# **createCourseUsingPOST**
> String createCourseUsingPOST(description, id, mode, name, professorId)

createCourse

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CoursewebcontrollerApi;


CoursewebcontrollerApi apiInstance = new CoursewebcontrollerApi();
String description = "description_example"; // String | 
Integer id = 56; // Integer | 
String mode = "mode_example"; // String | 
String name = "name_example"; // String | 
Integer professorId = 56; // Integer | 
try {
    String result = apiInstance.createCourseUsingPOST(description, id, mode, name, professorId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CoursewebcontrollerApi#createCourseUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **description** | **String**|  | [optional]
 **id** | **Integer**|  | [optional]
 **mode** | **String**|  | [optional]
 **name** | **String**|  | [optional]
 **professorId** | **Integer**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

<a name="deleteCourseUsingPOST"></a>
# **deleteCourseUsingPOST**
> String deleteCourseUsingPOST(description, id, mode, name, professorId)

deleteCourse

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CoursewebcontrollerApi;


CoursewebcontrollerApi apiInstance = new CoursewebcontrollerApi();
String description = "description_example"; // String | 
Integer id = 56; // Integer | 
String mode = "mode_example"; // String | 
String name = "name_example"; // String | 
Integer professorId = 56; // Integer | 
try {
    String result = apiInstance.deleteCourseUsingPOST(description, id, mode, name, professorId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CoursewebcontrollerApi#deleteCourseUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **description** | **String**|  | [optional]
 **id** | **Integer**|  | [optional]
 **mode** | **String**|  | [optional]
 **name** | **String**|  | [optional]
 **professorId** | **Integer**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

<a name="gedItParamUsingGET"></a>
# **gedItParamUsingGET**
> String gedItParamUsingGET(id, description, mode, name, professorId)

gedItParam

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CoursewebcontrollerApi;


CoursewebcontrollerApi apiInstance = new CoursewebcontrollerApi();
String id = "id_example"; // String | id
String description = "description_example"; // String | 
String mode = "mode_example"; // String | 
String name = "name_example"; // String | 
Integer professorId = 56; // Integer | 
try {
    String result = apiInstance.gedItParamUsingGET(id, description, mode, name, professorId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CoursewebcontrollerApi#gedItParamUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| id |
 **description** | **String**|  | [optional]
 **mode** | **String**|  | [optional]
 **name** | **String**|  | [optional]
 **professorId** | **Integer**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="getCoursesUsingGET"></a>
# **getCoursesUsingGET**
> String getCoursesUsingGET()

getCourses

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CoursewebcontrollerApi;


CoursewebcontrollerApi apiInstance = new CoursewebcontrollerApi();
try {
    String result = apiInstance.getCoursesUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CoursewebcontrollerApi#getCoursesUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="updateCourseUsingPOST"></a>
# **updateCourseUsingPOST**
> String updateCourseUsingPOST(description, id, mode, name, professorId)

updateCourse

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CoursewebcontrollerApi;


CoursewebcontrollerApi apiInstance = new CoursewebcontrollerApi();
String description = "description_example"; // String | 
Integer id = 56; // Integer | 
String mode = "mode_example"; // String | 
String name = "name_example"; // String | 
Integer professorId = 56; // Integer | 
try {
    String result = apiInstance.updateCourseUsingPOST(description, id, mode, name, professorId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CoursewebcontrollerApi#updateCourseUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **description** | **String**|  | [optional]
 **id** | **Integer**|  | [optional]
 **mode** | **String**|  | [optional]
 **name** | **String**|  | [optional]
 **professorId** | **Integer**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

