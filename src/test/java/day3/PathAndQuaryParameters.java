package day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathAndQuaryParameters {

	
	@Test
	
	void testQueryAndPathParameters() {
		
		// https://reqres.in/api/users?page=2&id=5
		given()
		    .pathParam("mypath", "users") //path parameter(route data)
		    .queryParam("page",2) //query parameters(filter results)
		    .queryParam("id",5) // query parameters(filter results)
		    
		
		.when()
		    .get("https://reqres.in/api/{mypath}")
		
		.then()
		   .statusCode(200)
		   .log().all();
	}

	
	
}
