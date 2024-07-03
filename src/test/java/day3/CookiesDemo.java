package day3;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import io.restassured.response.Response;
import io.restassured.response.Response.*;



public class CookiesDemo {
	
	// @Test(priority=1)
	
	void testCookies() {
		
		given()
		
		.when()
		    .get("https://www.google.com/")
		    
		.then()
		   .cookie("AEC", " Ae3NU9NDC8YwOKEvmLzvCwa_SIhV1PN2Fg2_8AYfHMz2Vgu7KgwqHH77EAQ")
		   .log().all();
		
		
		
	}
	
	
	
@Test(priority=2)
	
void getCookiesInfo() {
    Response res = given()
            .when()
            .get("https://www.google.com/");

    // Get Single Cookie
    //String cookie_value = res.getCookie("AEC"); // Remove the space before "AEC"
   // System.out.println("value of cookie is====> " + cookie_value); // Fix the typo here
    
    
    
    //get all cookie info
   Map<String, String> cookies_values = res.getCookies();
		  // System.out.println(cookies_values.keySet());
		   
		   
	for(String k :cookies_values.keySet()){	   
		  
	
		String cookie_value=res.getCookie(k);
		System.out.println(k + " "+cookie_value);
}

	

}
}
