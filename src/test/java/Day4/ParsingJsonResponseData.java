package Day4;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;


public class ParsingJsonResponseData {

	//@Test(priority=1)
	
	void testJsonResponse() {
		
		//Approach1
		
		given()
		   .contentType("ContentType.JSON")
		
		.when()
		    .get("http://localhost:3000/books")
		    
		.then()
		    .statusCode(200)
		    .body("book10.title", equalTo("Echoes of the Past"))
		    .log().all();
		
		
	}	    
	
	
		
// Approach 2		
	public class ParsingJsonResponseData2 {

	    @Test(priority = 2)
	    void testJsonResponse2() {
	        // Approach 2

	        Response res = given()
	                .contentType(ContentType.JSON)
	                .when()
	                .get("http://localhost:3000/books");

	        Assert.assertEquals(res.getStatusCode(), 200); // status code validation
	        Assert.assertEquals(res.header("content-Type"), "application/json");

	        String bookname = res.jsonPath().get("book10.title").toString();
	        Assert.assertEquals(bookname, "Echoes of the Past");
	        
	        int statusCode = res.getStatusCode();
	        System.out.println("Status Code: " + statusCode);

	        System.out.println("Book Name: " + bookname);
	    }
	}
	
}
