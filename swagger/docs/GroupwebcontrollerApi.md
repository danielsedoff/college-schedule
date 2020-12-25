# GroupwebcontrollerApi

All URIs are relative to *https://localhost:8080/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createGroupUsingPOST**](GroupwebcontrollerApi.md#createGroupUsingPOST) | **POST** /createGroup | createGroup
[**deleteGroupUsingPOST**](GroupwebcontrollerApi.md#deleteGroupUsingPOST) | **POST** /deleteGroup | deleteGroup
[**gedItParamUsingGET1**](GroupwebcontrollerApi.md#gedItParamUsingGET1) | **GET** /groupForm | gedItParam
[**getGroupsUsingGET**](GroupwebcontrollerApi.md#getGroupsUsingGET) | **GET** /groupList | getGroups
[**updateGroupUsingPOST**](GroupwebcontrollerApi.md#updateGroupUsingPOST) | **POST** /updateGroup | updateGroup


<a name="createGroupUsingPOST"></a>
# **createGroupUsingPOST**
> String createGroupUsingPOST(description, id, mode, name)

createGroup

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GroupwebcontrollerApi;


GroupwebcontrollerApi apiInstance = new GroupwebcontrollerApi();
String description = "description_example"; // String | 
Integer id = 56; // Integer | 
String mode = "mode_example"; // String | 
String name = "name_example"; // String | 
try {
    String result = apiInstance.createGroupUsingPOST(description, id, mode, name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GroupwebcontrollerApi#createGroupUsingPOST");
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

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

<a name="deleteGroupUsingPOST"></a>
# **deleteGroupUsingPOST**
> String deleteGroupUsingPOST(description, id, mode, name)

deleteGroup

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GroupwebcontrollerApi;


GroupwebcontrollerApi apiInstance = new GroupwebcontrollerApi();
String description = "description_example"; // String | 
Integer id = 56; // Integer | 
String mode = "mode_example"; // String | 
String name = "name_example"; // String | 
try {
    String result = apiInstance.deleteGroupUsingPOST(description, id, mode, name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GroupwebcontrollerApi#deleteGroupUsingPOST");
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

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

<a name="gedItParamUsingGET1"></a>
# **gedItParamUsingGET1**
> String gedItParamUsingGET1(id, description, mode, name)

gedItParam

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GroupwebcontrollerApi;


GroupwebcontrollerApi apiInstance = new GroupwebcontrollerApi();
String id = "id_example"; // String | id
String description = "description_example"; // String | 
String mode = "mode_example"; // String | 
String name = "name_example"; // String | 
try {
    String result = apiInstance.gedItParamUsingGET1(id, description, mode, name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GroupwebcontrollerApi#gedItParamUsingGET1");
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

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: *_/_*

<a name="getGroupsUsingGET"></a>
# **getGroupsUsingGET**
> String getGroupsUsingGET()

getGroups

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GroupwebcontrollerApi;


GroupwebcontrollerApi apiInstance = new GroupwebcontrollerApi();
try {
    String result = apiInstance.getGroupsUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GroupwebcontrollerApi#getGroupsUsingGET");
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

<a name="updateGroupUsingPOST"></a>
# **updateGroupUsingPOST**
> String updateGroupUsingPOST(description, id, mode, name)

updateGroup

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.GroupwebcontrollerApi;


GroupwebcontrollerApi apiInstance = new GroupwebcontrollerApi();
String description = "description_example"; // String | 
Integer id = 56; // Integer | 
String mode = "mode_example"; // String | 
String name = "name_example"; // String | 
try {
    String result = apiInstance.updateGroupUsingPOST(description, id, mode, name);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling GroupwebcontrollerApi#updateGroupUsingPOST");
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

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: *_/_*

