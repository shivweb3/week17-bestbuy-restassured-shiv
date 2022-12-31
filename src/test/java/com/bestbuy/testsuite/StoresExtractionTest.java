package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    //1. Extract the limit
    @Test
    public void test01() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The limit is : " + limit);
        System.out.println("------------------End of Test----------------------------");
    }

    //2. Extract the total
    @Test
    public void test02() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total is : " + total);
        System.out.println("------------------End of Test----------------------------");
    }

    //3. Extract the name of 5th store
    @Test
    public void test03() {
        String nameOf5thStore = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store is : " + nameOf5thStore);
        System.out.println("------------------End of Test----------------------------");
    }

    //4. Extract the names of all the store
    @Test
    public void test04() {
        List<String> allStoreName = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all store are : " + allStoreName);
        System.out.println("------------------End of Test----------------------------");
    }

    //5. Extract the storeId of all the store
    @Test
    public void test05() {
        List<Integer> allStoreId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The id of all stores are : " + allStoreId);
        System.out.println("------------------End of Test----------------------------");
    }

    //6. Print the size of the data list
    @Test
    public void test06() {
        List<Integer> dataList = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of data list is : " + dataList.size());
        System.out.println("------------------End of Test----------------------------");
    }

    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void test07() {
        List<HashMap<String, ?>> allValues = response.extract().path("data.findAll{it.name == 'St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The values of St Cloud are : " + allValues);
        System.out.println("------------------End of Test----------------------------");
    }

    //8. Get the address of the store where store name = Rochester
    @Test
    public void test08() {
        List<HashMap<String, ?>> address = response.extract().path("data.findAll{it.name == 'Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of Rochester is : " + address);
        System.out.println("------------------End of Test----------------------------");
    }

    //9. Get all the services of 8th store
    @Test
    public void test09() {
        List<HashMap<String, ?>> servicesOf8thStore = response.extract().path("data[7].storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The services of 8th store are : " + servicesOf8thStore);
        System.out.println("------------------End of Test----------------------------");
    }

    //10. Get store services of the store where service name = Windows Store
    @Test
    public void test10() {
        List<String> storeServices = response.extract().path("data.findAll{it.name == 'Windows Store'}.storeservices");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store services are : " + storeServices);
        System.out.println("------------------End of Test----------------------------");
    }

    //11. Get all the storeId of all the store
    @Test
    public void test11() {
        List<Integer> storeId = response.extract().path("data.services.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of all stores are : " + storeId);
        System.out.println("------------------End of Test----------------------------");
    }

    //12. Get id of all the store

    //13. Find the store names Where state = ND
    @Test
    public void test13() {
        List<String> storeName = response.extract().path("data.findAll{it.state == 'ND'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Store name of ND state is : " + storeName);
        System.out.println("------------------End of Test----------------------------");
    }

    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void test14() {
        List<String> numOfServices = response.extract().path("data.findAll{it.name == 'Rochester'}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The number of store services of Rochester is : " + numOfServices);
        System.out.println("------------------End of Test----------------------------");
    }

    //15. Find the createdAt for all services whose name = “ Windows Store”
    @Test
    public void test15() {
        List<?> createdAt = response.extract().path("data.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The services of Windows Store are created at : " + createdAt);
        System.out.println("------------------End of Test----------------------------");
    }

    //16. Find the name of all services Where store name = “Fargo”
    @Test
    public void test16() {
        List<String> numOfServices = response.extract().path("data.findAll{it.name == 'Fargo'}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The services at Fargo are : " + numOfServices);
        System.out.println("------------------End of Test----------------------------");
    }

    //17. Find the zip of all the store
    @Test
    public void test17() {
        List<Integer> zip = response.extract().path("data.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip of all stores are : " + zip);
        System.out.println("------------------End of Test----------------------------");
    }

    //18. Find the zip of store name = Roseville
    @Test
    public void test18() {
        List<Integer> zip = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The zip at Roseville is : " + zip);
        System.out.println("------------------End of Test----------------------------");
    }

    //19. Find the store services details of the service name = Magnolia Home Theater
    @Test
    public void test19() {
        List<?> storeServices = response.extract().path("data.findAll{it.name == 'Magnolia Home Theater'}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The store services at Magnolia Home Theater is : " + storeServices);
        System.out.println("------------------End of Test----------------------------");
    }

    //20. Find the lat of all the stores
    @Test
    public void test20() {
        List<Integer> lat = response.extract().path("data.lat");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The lat of all stores is : " + lat);
        System.out.println("------------------End of Test----------------------------");
    }
}
