package day2;

import org.testng.annotations.Test;
import java.util.HashMap;
import io.restassured.response.Response;
import org.json.JSONObject;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DiffWaysToCreatePostRequestBody {

    private String studentId;

    
    // 1) POST BODY USING HASHMAP
    
    
   // @Test(priority = 1)
    void testPostUsingHashMap()
   {
	   
     HashMap<String, Object> data=new HashMap<>();    
     
        data.put("name", "kwabena");
        data.put("age", "30");
        data.put("grade", 55);

        String courseArr[] = {"c", "c++", "ruby"};
        data.put("courses", courseArr);

        Response response = given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name", equalTo("kwabena"))
                .body("age", equalTo("30"))
                .body("grade", equalTo(55))
                .body("courses[0]", equalTo("c"))
                .body("courses[1]", equalTo("c++"))
                .body("courses[2]", equalTo("ruby"))
                .header("Content-Type", "application/json")
                .log().all()
                .extract().response();

        // Extracting the id from the response
        try {
            studentId = response.jsonPath().getString("id");
        } catch (Exception e) {
            System.out.println("Unable to extract student ID from the response.");
            e.printStackTrace();
        }
    }

    // Deleting Student Record
    
   // @Test(priority = 2)
    void testDelete() {
        given()
        .when()
            .delete("http://localhost:3000/students/" + studentId)
        .then()
            .statusCode(200);
    }
    
    
    
    
    
    
    
    
   // 2) POST BODY USING JSON LIBERARY 
    
    
    
  // @Test(priority = 1)
    
 //   void testPostUsingJasonLiberary()
   {
	   
    JSONObject data =new JSONObject();
    
     
        data.put("name", "kwabena");
        data.put("age", "30");
        data.put("grade", 55);

        String courseArr[] = {"c", "c++", "ruby"};
        data.put("courses", courseArr);

        Response response = given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                .body("name", equalTo("kwabena"))
                .body("age", equalTo("30"))
                .body("grade", equalTo(55))
                .body("courses[0]", equalTo("c"))
                .body("courses[1]", equalTo("c++"))
                .body("courses[2]", equalTo("ruby"))
                .header("Content-Type", "application/json")
                .log().all()
                .extract().response();

        // Extracting the id from the response
        try {
            studentId = response.jsonPath().getString("id");
        } catch (Exception e) {
            System.out.println("Unable to extract student ID from the response.");
            e.printStackTrace();
        }
    }

    // Deleting Student Record
   
   // @Test(priority = 2)
    void testDelete() {
        given()
        .when()
            .delete("http://localhost:3000/students/" + studentId)
        .then()
            .statusCode(200);
    }
    
    
    
    
    
    
    // 3) POST REQUEST POJO ClASS
    
    @Test
    void testPostUsingPojo() {
        Pojo_PostRequest data = new Pojo_PostRequest();
        data.setName("kojo");
        data.setAge("55");
        data.setGrade("65");

        String coursesArr[] = {"B", "B++", "Dee"};
        data.setCourses(coursesArr);

        // Send the POST request
        Response response = given()
                .contentType("application/json")
                .body(data)
                
                .when()
                .post("http://localhost:3000/students")
                
                .then()
                .statusCode(201)
                .body("name", equalTo("kojo"))
                .body("age", equalTo("55"))
                .body("grade", equalTo("65"))
                .body("courses[0]", equalTo("B"))
                .body("courses[1]", equalTo("B++"))
                .body("courses[2]", equalTo("Dee"))
                .header("Content-Type", "application/json")
                .log().all()
                .extract().response();

        // Extracting the id from the response
        try {
            studentId = response.jsonPath().getString("id");
        } catch (Exception e) {
            System.out.println("Unable to extract student ID from the response.");
            e.printStackTrace();
        }
    }

    // Deleting Student Record
    @Test(priority = 2)
    void testDelete() {
        given()
                .when()
                .delete("http://localhost:3000/students/" + studentId)
                .then()
                .statusCode(200);
    }
    
    
    
    
    
    
    
    
    
    
    
    
}