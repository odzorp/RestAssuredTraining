package day1;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HTTPRequest {
    private String id; // Variable to store the user ID as a string

    @Test(priority=1)
    public void testGetUsers() {
        given()
        .when()
             .get("https://reqres.in/api/users?page=2")
        .then()
             .statusCode(200)
             .body("page", equalTo(2))
             .log().all();
    }
    
    @Test(priority = 2)
    public void createUser() {
        // Prepare data
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "pavan");
        data.put("job", "trainer");

        // Send POST request to create user and store the id
        id = given()
            .contentType(ContentType.JSON)
            .body(data)
        .when()
            .post("https://reqres.in/api/users")
            .then()
                .statusCode(201)
                .log().all() // Log all details of the response
                .extract().path("id"); // Extract the id from the response
    }
    
    @Test(priority = 3, dependsOnMethods={"createUser"})
    public void updateUser() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "shiva");
        data.put("job", "player");

        given()
            .contentType(ContentType.JSON)
            .body(data)
        .when()
            .put("https://reqres.in/api/users/" + id)
        .then()
            .statusCode(200 )
            .log().all();
    }




@Test(priority = 4, dependsOnMethods={"updateUser"})
public void deleteUser() {
    given()
    .when()
        .delete("https://reqres.in/api/users/" + id)
    .then()
        .statusCode(204)
        .log().all();
}

}
