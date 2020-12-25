# CourserestcontrollerApi

All URIs are relative to *https://localhost:8080/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUsingPOST**](CourserestcontrollerApi.md#createUsingPOST) | **POST** /courses | create
[**deleteUsingDELETE**](CourserestcontrollerApi.md#deleteUsingDELETE) | **DELETE** /courses/{id} | delete
[**findAllUsingGET**](CourserestcontrollerApi.md#findAllUsingGET) | **GET** /courses | findAll
[**findByIdUsingGET**](CourserestcontrollerApi.md#findByIdUsingGET) | **GET** /courses/{id} | findById
[**updateUsingPUT**](CourserestcontrollerApi.md#updateUsingPUT) | **PUT** /courses/{id} | update


<a name="createUsingPOST"></a>
# **createUsingPOST**
> String createUsingPOST(resource)

create

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CourserestcontrollerApi;


CourserestcontrollerApi apiInstance = new CourserestcontrollerApi();
CourseDTO resource = new CourseDTO(); // CourseDTO | resource
try {
    String result = apiInstance.createUsingPOST(resource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CourserestcontrollerApi#createUsingPOST");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resource** | [**CourseDTO**](CourseDTO.md)| resource |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

<a name="deleteUsingDELETE"></a>
# **deleteUsingDELETE**
> deleteUsingDELETE(id)

delete

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CourserestcontrollerApi;


CourserestcontrollerApi apiInstance = new CourserestcontrollerApi();
Integer id = 56; // Integer | id
try {
    apiInstance.deleteUsingDELETE(id);
} catch (ApiException e) {
    System.err.println("Exception when calling CourserestcontrollerApi#deleteUsingDELETE");
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

<a name="findAllUsingGET"></a>
# **findAllUsingGET**
> List&lt;CourseDTO&gt; findAllUsingGET()

findAll

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CourserestcontrollerApi;


CourserestcontrollerApi apiInstance = new CourserestcontrollerApi();
try {
    List<CourseDTO> result = apiInstance.findAllUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CourserestcontrollerApi#findAllUsingGET");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;CourseDTO&gt;**](CourseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="findByIdUsingGET"></a>
# **findByIdUsingGET**
> CourseDTO findByIdUsingGET(id)

findById

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CourserestcontrollerApi;


CourserestcontrollerApi apiInstance = new CourserestcontrollerApi();
Integer id = 56; // Integer | id
try {
    CourseDTO result = apiInstance.findByIdUsingGET(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CourserestcontrollerApi#findByIdUsingGET");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id |

### Return type

[**CourseDTO**](CourseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="updateUsingPUT"></a>
# **updateUsingPUT**
> String updateUsingPUT(id, resource)

update

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.CourserestcontrollerApi;


CourserestcontrollerApi apiInstance = new CourserestcontrollerApi();
Integer id = 56; // Integer | id
CourseDTO resource = new CourseDTO(); // CourseDTO | resource
try {
    String result = apiInstance.updateUsingPUT(id, resource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling CourserestcontrollerApi#updateUsingPUT");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id |
 **resource** | [**CourseDTO**](CourseDTO.md)| resource |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

