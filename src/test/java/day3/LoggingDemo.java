package day3;

import org.testng.annotations.Test;  
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.Map;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
 import io.restassured.response.Response.*;


public class LoggingDemo {

	@Test
	
	void testLogs() {
		given()
		
		.when()
		    .get("https://reqres.in/api/users?page=2")
		.then()
		  .log().cookies();
	}
	
	
}
