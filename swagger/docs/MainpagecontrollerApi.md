# MainpagecontrollerApi

All URIs are relative to *https://localhost:8080/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**mainUsingGET**](MainpagecontrollerApi.md#mainUsingGET) | **GET** / | main


<a name="mainUsingGET"></a>
# **mainUsingGET**
> String mainUsingGET()

main

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.MainpagecontrollerApi;


MainpagecontrollerApi apiInstance = new MainpagecontrollerApi();
try {
    String result = apiInstance.mainUsingGET();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MainpagecontrollerApi#mainUsingGET");
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

