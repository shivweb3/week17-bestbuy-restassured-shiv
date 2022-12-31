package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }

    //21 Extract the limit
    @Test
    public void test0021() {
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

    //22 Extract the total
    @Test
    public void test0022() {
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    //23 Extract the name of 5th store
    @Test
    public void test0023() {
        String name = response.extract().path("data[5].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The 5th store name is : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //24 Extract the names of all the products
    @Test
    public void test0024() {
        List<String> name = response.extract().path("data.name");
        name.size();
        System.out.println("total name : " + name.size());
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all products : " + name);
        System.out.println("------------------End of Test---------------------------");
    }

    //25 Extract the productId of all the products
    @Test
    public void test0025() {
        List<Integer> ids = response.extract().path("data.id");
        ids.size();
        System.out.println("total name : " + ids.size());
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all products : " + ids);
        System.out.println("------------------End of Test---------------------------");
    }

    //26 Print the size of the data list
    @Test
    public void test0026() {
        List<Integer> ids = response.extract().path("data");
        ids.size();
        System.out.println("Total size of data list : " + ids.size());
    }

    //27 Get all the value of the product where product name = Energizer - MAX Batteries AA (4- pack)
    @Test
    public void test0027() {
        List<HashMap<String, ?>> value = response.extract().path("data.findAll{it.name=='Energizer - MAX Batteries AA (4-Pack)'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of the product name : " + value);
        System.out.println("------------------End of Test---------------------------");
    }

    //28 Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-pack)
    @Test
    public void test0028() {
        List<HashMap<String, ?>> model = response.extract().path("data.findAll{it.name=='Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of  model : " + model);
        System.out.println("------------------End of Test---------------------------");
    }

    //29. Get all the categories of 8th products
    @Test
    public void test0029() {
        List<HashMap<String, ?>> categories = response.extract().path("data[8].categories.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("all categories: " + categories);
        System.out.println("------------------End of Test---------------------------");
    }

    //30. Get categories of the store where product id = 150115
    @Test
    public void test030() {
        List<Integer> listOfIds = response.extract().path("data[3].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of Ids are : " + listOfIds);
        System.out.println("------------------End of Test---------------------------");
    }

    //31. Get all the descriptions of all the products
    @Test
    public void test031() {
        List<String> data = response.extract().path("data.description");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of data are : " + data);
        System.out.println("------------------End of Test---------------------------");
    }

    //32. Get id of all the all categories of all the products
    @Test
    public void test032() {
        List<Integer> data = response.extract().path("data.categories.id");
        data.size();
        System.out.println("size:" + data.size());
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("List of all categories of products: " + data);
        System.out.println("------------------End of Test---------------------------");
    }

    //33. Find the product names Where type = HardGood
    @Test
    public void test033() {
        List<String> productName = response.extract().path("data.findAll{it.type=='HardGood'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All productName: " + productName);
        System.out.println("------------------End of Test---------------------------");
    }

    //34. Find the Total number of categories for the product where product name = Duracell - AA1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test034() {
        List<String> noOfCategories = response.extract().path("data.findAll{it.name=='Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All noOfCategories: " + noOfCategories);
        System.out.println("------------------End of Test---------------------------");
    }

    //35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test035(){
        List<String> createdAt = response.extract().path("data.findAll{it.price < 5.49}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All createdAt: " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    //36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-pack)"
    @Test
    public void test036(){
        List<String> categories = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All categories: " + categories);
        System.out.println("------------------End of Test---------------------------");
    }

    //37. Find the manufacturer of all the products
    @Test
    public void test037(){
        List<String> manufacturer = response.extract().path("data.manufacturer");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All manufacturer : " + manufacturer);
        System.out.println("------------------End of Test---------------------------");
    }

    //38. Find the image of products whose manufacturer is = Energize
    @Test
    public void test038(){
        List<HashMap<String,?>> image = response.extract().path("data.findAll{it.manufacturer =='Energizer'}.image");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All image: " + image);
        System.out.println("------------------End of Test---------------------------");
    }

    //39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test039(){
        List<HashMap<String,?>> createdAt = response.extract().path("data.findAll{it.price > 5.99}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All createdAt: " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }

    //40. Find the uri of all the product
    @Test
    public void test040(){
        List<String> url = response.extract().path("data.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All url: " + url);
        System.out.println("------------------End of Test---------------------------");
    }

}
