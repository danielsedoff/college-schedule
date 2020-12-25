# LessonwebcontrollerApi

All URIs are relative to *https://localhost:8080/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createLessonUsingPOST**](LessonwebcontrollerApi.md#createLessonUsingPOST) | **POST** /createLesson | createLesson
[**deleteLessonUsingPOST**](LessonwebcontrollerApi.md#deleteLessonUsingPOST) | **POST** /deleteLesson | deleteLesson
[**getIdParamUsingGET**](LessonwebcontrollerApi.md#getIdParamUsingGET) | **GET** /lessonForm | getIdParam
[**getLessonsUsingGET**](LessonwebcontrollerApi.md#getLessonsUsingGET) | **GET** /lessonList | getLessons
[**updateLessonUsingPOST**](LessonwebcontrollerApi.md#updateLessonUsingPOST) | **POST** /updateLesson | updateLesson


<a name="createLessonUsingPOST"></a>
# **createLessonUsingPOST**
> String createLessonUsingPOST(endTime, groupId, id, mode, professorId, startTime)

createLesson

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LessonwebcontrollerApi;


LessonwebcontrollerApi apiInstance = new LessonwebcontrollerApi();
String endTime = "endTime_example"; // String | 
Integer groupId = 56; // Integer | 
Integer id = 56; // Integer | 
String mode = "mode_example"; // String | 
Integer professorId = 56; // Integer | 
String startTime = "startTime_example"; // String | 
try {
    String result = apiInstance.createLessonUsingPOST(endTime, groupId, id, mode, professorId, startTime);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LessonwebcontrollerApi#createLessonUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endTime** | **String**|  | [optional]
 **groupId** | **Integer**|  | [optional]
 **id** | **Integer**|  | [optional]
 **mode** | **String**|  | [optional]
 **professorId** | **Integer**|  | [optional]
 **startTime** | **String**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

<a name="deleteLessonUsingPOST"></a>
# **deleteLessonUsingPOST**
> String deleteLessonUsingPOST(endTime, groupId, id, mode, professorId, startTime)

deleteLesson

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LessonwebcontrollerApi;


LessonwebcontrollerApi apiInstance = new LessonwebcontrollerApi();
String endTime = "endTime_example"; // String | 
Integer groupId = 56; // Integer | 
Integer id = 56; // Integer | 
String mode = "mode_example"; // String | 
Integer professorId = 56; // Integer | 
String startTime = "startTime_example"; // String | 
try {
    String result = apiInstance.deleteLessonUsingPOST(endTime, groupId, id, mode, professorId, startTime);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LessonwebcontrollerApi#deleteLessonUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endTime** | **String**|  | [optional]
 **groupId** | **Integer**|  | [optional]
 **id** | **Integer**|  | [optional]
 **mode** | **String**|  | [optional]
 **professorId** | **Integer**|  | [optional]
 **startTime** | **String**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

<a name="getIdParamUsingGET"></a>
# **getIdParamUsingGET**
> String getIdParamUsingGET(id, endTime, groupId, mode, professorId, startTime)

getIdParam

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LessonwebcontrollerApi;


LessonwebcontrollerApi apiInstance = new LessonwebcontrollerApi();
String id = "id_example"; // String | id
String endTime = "endTime_example"; // String | 
Integer groupId = 56; // Integer | 
String mode = "mode_example"; // String | 
Integer professorId = 56; // Integer | 
String startTime = "startTime_example"; // String | 
try {
    String result = apiInstance.getIdParamUsingGET(id, endTime, groupId, mode, professorId, startTime);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LessonwebcontrollerApi#getIdParamUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| id |
 **endTime** | **String**|  | [optional]
 **groupId** | **Integer**|  | [optional]
 **mode** | **String**|  | [optional]
 **professorId** | **Integer**|  | [optional]
 **startTime** | **String**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="getLessonsUsingGET"></a>
# **getLessonsUsingGET**
> String getLessonsUsingGET()

getLessons

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LessonwebcontrollerApi;


LessonwebcontrollerApi apiInstance = new LessonwebcontrollerApi();
try {
    String result = apiInstance.getLessonsUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LessonwebcontrollerApi#getLessonsUsingGET");
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

<a name="updateLessonUsingPOST"></a>
# **updateLessonUsingPOST**
> String updateLessonUsingPOST(endTime, groupId, id, mode, professorId, startTime)

updateLesson

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LessonwebcontrollerApi;


LessonwebcontrollerApi apiInstance = new LessonwebcontrollerApi();
String endTime = "endTime_example"; // String | 
Integer groupId = 56; // Integer | 
Integer id = 56; // Integer | 
String mode = "mode_example"; // String | 
Integer professorId = 56; // Integer | 
String startTime = "startTime_example"; // String | 
try {
    String result = apiInstance.updateLessonUsingPOST(endTime, groupId, id, mode, professorId, startTime);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LessonwebcontrollerApi#updateLessonUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **endTime** | **String**|  | [optional]
 **groupId** | **Integer**|  | [optional]
 **id** | **Integer**|  | [optional]
 **mode** | **String**|  | [optional]
 **professorId** | **Integer**|  | [optional]
 **startTime** | **String**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

