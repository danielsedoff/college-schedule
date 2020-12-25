# GrouprestcontrollerApi

All URIs are relative to *https://localhost:8080/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUsingPOST1**](GrouprestcontrollerApi.md#createUsingPOST1) | **POST** /groups | create
[**deleteUsingDELETE1**](GrouprestcontrollerApi.md#deleteUsingDELETE1) | **DELETE** /groups/{id} | delete
[**findAllUsingGET1**](GrouprestcontrollerApi.md#findAllUsingGET1) | **GET** /groups | findAll
[**findByIdUsingGET1**](GrouprestcontrollerApi.md#findByIdUsingGET1) | **GET** /groups/{id} | findById
[**updateUsingPUT1**](GrouprestcontrollerApi.md#updateUsingPUT1) | **PUT** /groups/{id} | update


<a name="createUsingPOST1"></a>
# **createUsingPOST1**
> String createUsingPOST1(resource)

create

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GrouprestcontrollerApi;


GrouprestcontrollerApi apiInstance = new GrouprestcontrollerApi();
GroupDTO resource = new GroupDTO(); // GroupDTO | resource
try {
    String result = apiInstance.createUsingPOST1(resource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GrouprestcontrollerApi#createUsingPOST1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resource** | [**GroupDTO**](GroupDTO.md)| resource |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

<a name="deleteUsingDELETE1"></a>
# **deleteUsingDELETE1**
> deleteUsingDELETE1(id)

delete

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GrouprestcontrollerApi;


GrouprestcontrollerApi apiInstance = new GrouprestcontrollerApi();
Integer id = 56; // Integer | id
try {
    apiInstance.deleteUsingDELETE1(id);
} catch (ApiException e) {
    System.err.println("Exception when calling GrouprestcontrollerApi#deleteUsingDELETE1");
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

<a name="findAllUsingGET1"></a>
# **findAllUsingGET1**
> List&lt;GroupDTO&gt; findAllUsingGET1()

findAll

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GrouprestcontrollerApi;


GrouprestcontrollerApi apiInstance = new GrouprestcontrollerApi();
try {
    List<GroupDTO> result = apiInstance.findAllUsingGET1();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GrouprestcontrollerApi#findAllUsingGET1");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;GroupDTO&gt;**](GroupDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="findByIdUsingGET1"></a>
# **findByIdUsingGET1**
> GroupDTO findByIdUsingGET1(id)

findById

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GrouprestcontrollerApi;


GrouprestcontrollerApi apiInstance = new GrouprestcontrollerApi();
Integer id = 56; // Integer | id
try {
    GroupDTO result = apiInstance.findByIdUsingGET1(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GrouprestcontrollerApi#findByIdUsingGET1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id |

### Return type

[**GroupDTO**](GroupDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="updateUsingPUT1"></a>
# **updateUsingPUT1**
> String updateUsingPUT1(id, resource)

update

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GrouprestcontrollerApi;


GrouprestcontrollerApi apiInstance = new GrouprestcontrollerApi();
Integer id = 56; // Integer | id
GroupDTO resource = new GroupDTO(); // GroupDTO | resource
try {
    String result = apiInstance.updateUsingPUT1(id, resource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GrouprestcontrollerApi#updateUsingPUT1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id |
 **resource** | [**GroupDTO**](GroupDTO.md)| resource |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

