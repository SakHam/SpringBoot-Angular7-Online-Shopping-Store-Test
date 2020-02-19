package me.zhulin.shopapi;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;

import io.restassured.filter.session.SessionFilter;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.response.Response;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runners.MethodSorters;
import org.testng.annotations.BeforeMethod;



//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ApiTest {

    @Test
    @Order(1)
    public void registerUser() throws JSONException {

        //String jsonUser = "{\"email\":\"xamsak@gmail.com\",\"name\":\"name\",\"password\":\"password\", \"phone\":\"1234567890\",\"address\":\"address\"}";
        String jsonUser = "{\"email\":\"xamsak@email.com\",\"name\":\"xam\",\"password\":\"pass\", \"phone\":\"1234567891\",\"address\":\"address1\",\"active\":\"true\"}";



        // Response response = RestAssured.given().header("Content-Type", "application/json").with().body(jsonUser).when().post("http://localhost:8080/api/register");
        Response response = RestAssured.given().header("Content-Type", "application/json").with().body(jsonUser).when().post("http://localhost:8080/api/register");

        String str1= response.contentType();
        System.out.println(str1);
        try {

            //Assert.assertEquals(ResponseEntity.ok(userService.save(user)), response);
            Assert.assertEquals(200, response.getStatusCode());        }

        catch (AssertionError e) {
            System.out.println("Not equal (registerUser)");
            throw e;
        }
        System.out.println("Equal (registerUser)");

    }


    @Test
    @Order(2)
    public void loginUser() throws JSONException {

        String jsonUser = "{\"username\":\"xamsak@email.com\",\"password\":\"pass\"}";
        // Response response = RestAssured.given().header("Accept-Encoding", "gzip").contentType("application/json").auth().preemptive().basic("sakxam@gmail.com","password").when().post("http://localhost:8080/api/login");
        Response response = RestAssured.given().auth().basic("xamsak@email.com","pass").with().contentType("application/json").body(jsonUser).when().post("http://localhost:8080/api/login");

        String str1= response.contentType();
        System.out.println(str1);
        try {

            //Assert.assertEquals(ResponseEntity.ok(userService.save(user)), response);
            Assert.assertEquals(200, response.getStatusCode());        }

        catch (AssertionError e) {
            System.out.println("Not equal (loginUser)");
            throw e;
        }
        System.out.println("Equal (loginUser)");
    }



    @Test
    @Order(3)
    public void getStatusCodeTest() {
        Response response = given().get("http://localhost:4200");
        int statusCode = response.getStatusCode();
        //assertThat(statusCode, is(201));
        try {

            Assert.assertEquals(200, statusCode);        }
        catch (AssertionError e) {
            System.out.println("Not equal (myFirstRaTest)");
            throw e;
        }
        System.out.println("Equal (myFirstRaTest)");
    }
    @Test
    @Order(4)
    public void getProfileTest() throws JSONException {
        //SessionFilter sessionFilter = new SessionFilter();

        String jsonUser = "{\"username\":\"xamsak@email.com\",\"password\":\"pass\"}";
        Response response1 =RestAssured.given().auth().basic("xamsak@email.com","pass").with().contentType("application/json").body(jsonUser).when().post("http://localhost:8080/api/login");
        //String sessionId = sessionFilter.getSessionId();
        //System.out.println("Session Id )"+sessionId);
        //Response response = RestAssuredMockMvc.given().auth().principal(User("username", "password").pathParam("email","xamsak@email.com").when().get("http://localhost:8080/api/profile/{email}");
        //Response response = RestAssured.given().header("Content-Encoding", "gzip").pathParam("email","xamsak@email.com").when().get("http://localhost:8080/api/profile/{email}");
        JSONObject jsonObject = new JSONObject(response1.getBody().asString());
        String accessToken = jsonObject.get("token").toString();
        //String tokenType = jsonObject.get("token_type").toString();
        System.out.println("accessToken " + accessToken);
        //System.out.println("tokenType" + tokenType);

        String jsonUser1 = "{\"email\":\"xamsak@email.com\",\"name\":\"xam\",\"password\":\"pass\", \"phone\":\"1234567891\",\"address\":\"address1\",\"active\":\"true\"}";

        Response response = RestAssured.given().auth().oauth2(accessToken).with().contentType("application/json").body(jsonUser1).when().put("http://localhost:8080/api/profile");

        try {

            //Assert.assertEquals(ResponseEntity.ok(userService.save(user)), response);
            Assert.assertEquals(200, response.getStatusCode());        }

        catch (AssertionError e) {
            System.out.println("Not equal (loginUser)");
            throw e;
        }
        System.out.println("Equal (loginUser)");


    }

}


