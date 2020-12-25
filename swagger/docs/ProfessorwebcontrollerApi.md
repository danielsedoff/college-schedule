# ProfessorwebcontrollerApi

All URIs are relative to *https://localhost:8080/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createProfessorUsingPOST**](ProfessorwebcontrollerApi.md#createProfessorUsingPOST) | **POST** /createProfessor | createProfessor
[**deleteProfessorUsingPOST**](ProfessorwebcontrollerApi.md#deleteProfessorUsingPOST) | **POST** /deleteProfessor | deleteProfessor
[**getIdParamUsingGET1**](ProfessorwebcontrollerApi.md#getIdParamUsingGET1) | **GET** /professorForm | getIdParam
[**getProfessorsUsingGET**](ProfessorwebcontrollerApi.md#getProfessorsUsingGET) | **GET** /professorList | getProfessors
[**updateProfessorUsingPOST**](ProfessorwebcontrollerApi.md#updateProfessorUsingPOST) | **POST** /updateProfessor | updateProfessor


<a name="createProfessorUsingPOST"></a>
# **createProfessorUsingPOST**
> String createProfessorUsingPOST(id, mode, name, notes, ranks)

createProfessor

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProfessorwebcontrollerApi;


ProfessorwebcontrollerApi apiInstance = new ProfessorwebcontrollerApi();
Integer id = 56; // Integer | 
String mode = "mode_example"; // String | 
String name = "name_example"; // String | 
String notes = "notes_example"; // String | 
String ranks = "ranks_example"; // String | 
try {
    String result = apiInstance.createProfessorUsingPOST(id, mode, name, notes, ranks);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProfessorwebcontrollerApi#createProfessorUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  | [optional]
 **mode** | **String**|  | [optional]
 **name** | **String**|  | [optional]
 **notes** | **String**|  | [optional]
 **ranks** | **String**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

<a name="deleteProfessorUsingPOST"></a>
# **deleteProfessorUsingPOST**
> String deleteProfessorUsingPOST(id, mode, name, notes, ranks)

deleteProfessor

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProfessorwebcontrollerApi;


ProfessorwebcontrollerApi apiInstance = new ProfessorwebcontrollerApi();
Integer id = 56; // Integer | 
String mode = "mode_example"; // String | 
String name = "name_example"; // String | 
String notes = "notes_example"; // String | 
String ranks = "ranks_example"; // String | 
try {
    String result = apiInstance.deleteProfessorUsingPOST(id, mode, name, notes, ranks);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProfessorwebcontrollerApi#deleteProfessorUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  | [optional]
 **mode** | **String**|  | [optional]
 **name** | **String**|  | [optional]
 **notes** | **String**|  | [optional]
 **ranks** | **String**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

<a name="getIdParamUsingGET1"></a>
# **getIdParamUsingGET1**
> String getIdParamUsingGET1(id, mode, name, notes, ranks)

getIdParam

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProfessorwebcontrollerApi;


ProfessorwebcontrollerApi apiInstance = new ProfessorwebcontrollerApi();
String id = "id_example"; // String | id
String mode = "mode_example"; // String | 
String name = "name_example"; // String | 
String notes = "notes_example"; // String | 
String ranks = "ranks_example"; // String | 
try {
    String result = apiInstance.getIdParamUsingGET1(id, mode, name, notes, ranks);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProfessorwebcontrollerApi#getIdParamUsingGET1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| id |
 **mode** | **String**|  | [optional]
 **name** | **String**|  | [optional]
 **notes** | **String**|  | [optional]
 **ranks** | **String**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="getProfessorsUsingGET"></a>
# **getProfessorsUsingGET**
> String getProfessorsUsingGET()

getProfessors

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProfessorwebcontrollerApi;


ProfessorwebcontrollerApi apiInstance = new ProfessorwebcontrollerApi();
try {
    String result = apiInstance.getProfessorsUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProfessorwebcontrollerApi#getProfessorsUsingGET");
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

<a name="updateProfessorUsingPOST"></a>
# **updateProfessorUsingPOST**
> String updateProfessorUsingPOST(id, mode, name, notes, ranks)

updateProfessor

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProfessorwebcontrollerApi;


ProfessorwebcontrollerApi apiInstance = new ProfessorwebcontrollerApi();
Integer id = 56; // Integer | 
String mode = "mode_example"; // String | 
String name = "name_example"; // String | 
String notes = "notes_example"; // String | 
String ranks = "ranks_example"; // String | 
try {
    String result = apiInstance.updateProfessorUsingPOST(id, mode, name, notes, ranks);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProfessorwebcontrollerApi#updateProfessorUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**|  | [optional]
 **mode** | **String**|  | [optional]
 **name** | **String**|  | [optional]
 **notes** | **String**|  | [optional]
 **ranks** | **String**|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

