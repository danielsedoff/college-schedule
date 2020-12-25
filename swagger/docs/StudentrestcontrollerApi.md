# StudentrestcontrollerApi

All URIs are relative to *https://localhost:8080/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUsingPOST4**](StudentrestcontrollerApi.md#createUsingPOST4) | **POST** /students | create
[**deleteUsingDELETE4**](StudentrestcontrollerApi.md#deleteUsingDELETE4) | **DELETE** /students/{id} | delete
[**findAllUsingGET4**](StudentrestcontrollerApi.md#findAllUsingGET4) | **GET** /students | findAll
[**findByIdUsingGET4**](StudentrestcontrollerApi.md#findByIdUsingGET4) | **GET** /students/{id} | findById
[**updateUsingPUT4**](StudentrestcontrollerApi.md#updateUsingPUT4) | **PUT** /students/{id} | update


<a name="createUsingPOST4"></a>
# **createUsingPOST4**
> String createUsingPOST4(resource)

create

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StudentrestcontrollerApi;


StudentrestcontrollerApi apiInstance = new StudentrestcontrollerApi();
StudentDTO resource = new StudentDTO(); // StudentDTO | resource
try {
    String result = apiInstance.createUsingPOST4(resource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentrestcontrollerApi#createUsingPOST4");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resource** | [**StudentDTO**](StudentDTO.md)| resource |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

<a name="deleteUsingDELETE4"></a>
# **deleteUsingDELETE4**
> deleteUsingDELETE4(id)

delete

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StudentrestcontrollerApi;


StudentrestcontrollerApi apiInstance = new StudentrestcontrollerApi();
Integer id = 56; // Integer | id
try {
    apiInstance.deleteUsingDELETE4(id);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentrestcontrollerApi#deleteUsingDELETE4");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="findAllUsingGET4"></a>
# **findAllUsingGET4**
> List&lt;StudentDTO&gt; findAllUsingGET4()

findAll

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StudentrestcontrollerApi;


StudentrestcontrollerApi apiInstance = new StudentrestcontrollerApi();
try {
    List<StudentDTO> result = apiInstance.findAllUsingGET4();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentrestcontrollerApi#findAllUsingGET4");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;StudentDTO&gt;**](StudentDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="findByIdUsingGET4"></a>
# **findByIdUsingGET4**
> StudentDTO findByIdUsingGET4(id)

findById

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StudentrestcontrollerApi;


StudentrestcontrollerApi apiInstance = new StudentrestcontrollerApi();
Integer id = 56; // Integer | id
try {
    StudentDTO result = apiInstance.findByIdUsingGET4(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentrestcontrollerApi#findByIdUsingGET4");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id |

### Return type

[**StudentDTO**](StudentDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="updateUsingPUT4"></a>
# **updateUsingPUT4**
> String updateUsingPUT4(id, resource)

update

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.StudentrestcontrollerApi;


StudentrestcontrollerApi apiInstance = new StudentrestcontrollerApi();
Integer id = 56; // Integer | id
StudentDTO resource = new StudentDTO(); // StudentDTO | resource
try {
    String result = apiInstance.updateUsingPUT4(id, resource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StudentrestcontrollerApi#updateUsingPUT4");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id |
 **resource** | [**StudentDTO**](StudentDTO.md)| resource |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

