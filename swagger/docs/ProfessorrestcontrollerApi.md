# ProfessorrestcontrollerApi

All URIs are relative to *https://localhost:8080/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUsingPOST3**](ProfessorrestcontrollerApi.md#createUsingPOST3) | **POST** /professors | create
[**deleteUsingDELETE3**](ProfessorrestcontrollerApi.md#deleteUsingDELETE3) | **DELETE** /professors/{id} | delete
[**findAllUsingGET3**](ProfessorrestcontrollerApi.md#findAllUsingGET3) | **GET** /professors | findAll
[**findByIdUsingGET3**](ProfessorrestcontrollerApi.md#findByIdUsingGET3) | **GET** /professors/{id} | findById
[**updateUsingPUT3**](ProfessorrestcontrollerApi.md#updateUsingPUT3) | **PUT** /professors/{id} | update


<a name="createUsingPOST3"></a>
# **createUsingPOST3**
> String createUsingPOST3(resource)

create

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProfessorrestcontrollerApi;


ProfessorrestcontrollerApi apiInstance = new ProfessorrestcontrollerApi();
ProfessorDTO resource = new ProfessorDTO(); // ProfessorDTO | resource
try {
    String result = apiInstance.createUsingPOST3(resource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProfessorrestcontrollerApi#createUsingPOST3");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resource** | [**ProfessorDTO**](ProfessorDTO.md)| resource |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

<a name="deleteUsingDELETE3"></a>
# **deleteUsingDELETE3**
> deleteUsingDELETE3(id)

delete

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProfessorrestcontrollerApi;


ProfessorrestcontrollerApi apiInstance = new ProfessorrestcontrollerApi();
Integer id = 56; // Integer | id
try {
    apiInstance.deleteUsingDELETE3(id);
} catch (ApiException e) {
    System.err.println("Exception when calling ProfessorrestcontrollerApi#deleteUsingDELETE3");
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

<a name="findAllUsingGET3"></a>
# **findAllUsingGET3**
> List&lt;ProfessorDTO&gt; findAllUsingGET3()

findAll

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProfessorrestcontrollerApi;


ProfessorrestcontrollerApi apiInstance = new ProfessorrestcontrollerApi();
try {
    List<ProfessorDTO> result = apiInstance.findAllUsingGET3();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProfessorrestcontrollerApi#findAllUsingGET3");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;ProfessorDTO&gt;**](ProfessorDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="findByIdUsingGET3"></a>
# **findByIdUsingGET3**
> ProfessorDTO findByIdUsingGET3(id)

findById

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProfessorrestcontrollerApi;


ProfessorrestcontrollerApi apiInstance = new ProfessorrestcontrollerApi();
Integer id = 56; // Integer | id
try {
    ProfessorDTO result = apiInstance.findByIdUsingGET3(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProfessorrestcontrollerApi#findByIdUsingGET3");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id |

### Return type

[**ProfessorDTO**](ProfessorDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="updateUsingPUT3"></a>
# **updateUsingPUT3**
> String updateUsingPUT3(id, resource)

update

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.ProfessorrestcontrollerApi;


ProfessorrestcontrollerApi apiInstance = new ProfessorrestcontrollerApi();
Integer id = 56; // Integer | id
ProfessorDTO resource = new ProfessorDTO(); // ProfessorDTO | resource
try {
    String result = apiInstance.updateUsingPUT3(id, resource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProfessorrestcontrollerApi#updateUsingPUT3");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id |
 **resource** | [**ProfessorDTO**](ProfessorDTO.md)| resource |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

