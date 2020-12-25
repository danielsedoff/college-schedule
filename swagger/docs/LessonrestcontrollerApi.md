# LessonrestcontrollerApi

All URIs are relative to *https://localhost:8080/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createUsingPOST2**](LessonrestcontrollerApi.md#createUsingPOST2) | **POST** /lessons | create
[**deleteUsingDELETE2**](LessonrestcontrollerApi.md#deleteUsingDELETE2) | **DELETE** /lessons/{id} | delete
[**findAllUsingGET2**](LessonrestcontrollerApi.md#findAllUsingGET2) | **GET** /lessons | findAll
[**findByIdUsingGET2**](LessonrestcontrollerApi.md#findByIdUsingGET2) | **GET** /lessons/{id} | findById
[**updateUsingPUT2**](LessonrestcontrollerApi.md#updateUsingPUT2) | **PUT** /lessons/{id} | update


<a name="createUsingPOST2"></a>
# **createUsingPOST2**
> String createUsingPOST2(resource)

create

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LessonrestcontrollerApi;


LessonrestcontrollerApi apiInstance = new LessonrestcontrollerApi();
LessonDTO resource = new LessonDTO(); // LessonDTO | resource
try {
    String result = apiInstance.createUsingPOST2(resource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LessonrestcontrollerApi#createUsingPOST2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **resource** | [**LessonDTO**](LessonDTO.md)| resource |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

<a name="deleteUsingDELETE2"></a>
# **deleteUsingDELETE2**
> deleteUsingDELETE2(id)

delete

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LessonrestcontrollerApi;


LessonrestcontrollerApi apiInstance = new LessonrestcontrollerApi();
Integer id = 56; // Integer | id
try {
    apiInstance.deleteUsingDELETE2(id);
} catch (ApiException e) {
    System.err.println("Exception when calling LessonrestcontrollerApi#deleteUsingDELETE2");
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

<a name="findAllUsingGET2"></a>
# **findAllUsingGET2**
> List&lt;LessonDTO&gt; findAllUsingGET2()

findAll

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LessonrestcontrollerApi;


LessonrestcontrollerApi apiInstance = new LessonrestcontrollerApi();
try {
    List<LessonDTO> result = apiInstance.findAllUsingGET2();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LessonrestcontrollerApi#findAllUsingGET2");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;LessonDTO&gt;**](LessonDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="findByIdUsingGET2"></a>
# **findByIdUsingGET2**
> LessonDTO findByIdUsingGET2(id)

findById

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LessonrestcontrollerApi;


LessonrestcontrollerApi apiInstance = new LessonrestcontrollerApi();
Integer id = 56; // Integer | id
try {
    LessonDTO result = apiInstance.findByIdUsingGET2(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LessonrestcontrollerApi#findByIdUsingGET2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id |

### Return type

[**LessonDTO**](LessonDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="updateUsingPUT2"></a>
# **updateUsingPUT2**
> String updateUsingPUT2(id, resource)

update

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.LessonrestcontrollerApi;


LessonrestcontrollerApi apiInstance = new LessonrestcontrollerApi();
Integer id = 56; // Integer | id
LessonDTO resource = new LessonDTO(); // LessonDTO | resource
try {
    String result = apiInstance.updateUsingPUT2(id, resource);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling LessonrestcontrollerApi#updateUsingPUT2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **Integer**| id |
 **resource** | [**LessonDTO**](LessonDTO.md)| resource |

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

