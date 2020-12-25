# StudentwebcontrollerApi

All URIs are relative to *https://localhost:8080/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createStudentUsingPOST**](StudentwebcontrollerApi.md#createStudentUsingPOST) | **POST** /createStudent | createStudent
[**deleteStudentUsingPOST**](StudentwebcontrollerApi.md#deleteStudentUsingPOST) | **POST** /deleteStudent | deleteStudent
[**getIdParamUsingGET2**](StudentwebcontrollerApi.md#getIdParamUsingGET2) | **GET** /studentForm | getIdParam
[**getStudentsUsingGET**](StudentwebcontrollerApi.md#getStudentsUsingGET) | **GET** /studentList | getStudents
[**updateStudentUsingPOST**](StudentwebcontrollerApi.md#updateStudentUsingPOST) | **POST** /updateStudent | updateStudent


<a name="createStudentUsingPOST"></a>
# **createStudentUsingPOST**
> String createStudentUsingPOST(groupId, id, mode, name, schoolYear)

createStudent

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StudentwebcontrollerApi;


StudentwebcontrollerApi apiInstance = new StudentwebcontrollerApi();
Integer groupId = 56; // Integer | 
Integer id = 56; // Integer | 
String mode = "mode_example"; // String | 
String name = "name_example"; // String | 
Integer schoolYear = 56; // Integer | 
try {
    String result = apiInstance.createStudentUsingPOST(groupId, id, mode, name, schoolYear);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentwebcontrollerApi#createStudentUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**|  | [optional]
 **id** | **Integer**|  | [optional]
 **mode** | **String**|  | [optional]
 **name** | **String**|  | [optional]
 **schoolYear** | **Integer**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

<a name="deleteStudentUsingPOST"></a>
# **deleteStudentUsingPOST**
> String deleteStudentUsingPOST(groupId, id, mode, name, schoolYear)

deleteStudent

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StudentwebcontrollerApi;


StudentwebcontrollerApi apiInstance = new StudentwebcontrollerApi();
Integer groupId = 56; // Integer | 
Integer id = 56; // Integer | 
String mode = "mode_example"; // String | 
String name = "name_example"; // String | 
Integer schoolYear = 56; // Integer | 
try {
    String result = apiInstance.deleteStudentUsingPOST(groupId, id, mode, name, schoolYear);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentwebcontrollerApi#deleteStudentUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**|  | [optional]
 **id** | **Integer**|  | [optional]
 **mode** | **String**|  | [optional]
 **name** | **String**|  | [optional]
 **schoolYear** | **Integer**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

<a name="getIdParamUsingGET2"></a>
# **getIdParamUsingGET2**
> String getIdParamUsingGET2(id, groupId, mode, name, schoolYear)

getIdParam

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StudentwebcontrollerApi;


StudentwebcontrollerApi apiInstance = new StudentwebcontrollerApi();
String id = "id_example"; // String | id
Integer groupId = 56; // Integer | 
String mode = "mode_example"; // String | 
String name = "name_example"; // String | 
Integer schoolYear = 56; // Integer | 
try {
    String result = apiInstance.getIdParamUsingGET2(id, groupId, mode, name, schoolYear);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentwebcontrollerApi#getIdParamUsingGET2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| id |
 **groupId** | **Integer**|  | [optional]
 **mode** | **String**|  | [optional]
 **name** | **String**|  | [optional]
 **schoolYear** | **Integer**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="getStudentsUsingGET"></a>
# **getStudentsUsingGET**
> String getStudentsUsingGET()

getStudents

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StudentwebcontrollerApi;


StudentwebcontrollerApi apiInstance = new StudentwebcontrollerApi();
try {
    String result = apiInstance.getStudentsUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentwebcontrollerApi#getStudentsUsingGET");
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

<a name="updateStudentUsingPOST"></a>
# **updateStudentUsingPOST**
> String updateStudentUsingPOST(groupId, id, mode, name, schoolYear)

updateStudent

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StudentwebcontrollerApi;


StudentwebcontrollerApi apiInstance = new StudentwebcontrollerApi();
Integer groupId = 56; // Integer | 
Integer id = 56; // Integer | 
String mode = "mode_example"; // String | 
String name = "name_example"; // String | 
Integer schoolYear = 56; // Integer | 
try {
    String result = apiInstance.updateStudentUsingPOST(groupId, id, mode, name, schoolYear);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentwebcontrollerApi#updateStudentUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **groupId** | **Integer**|  | [optional]
 **id** | **Integer**|  | [optional]
 **mode** | **String**|  | [optional]
 **name** | **String**|  | [optional]
 **schoolYear** | **Integer**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

