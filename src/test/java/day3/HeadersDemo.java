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

public class HeadersDemo {

	// @Test
void getHeader() {
		
		given()
		
		.when()
		    .get("https://www.google.com/")
		    
		.then()
		   .header("content-Type", "text/html; charset=ISO-8859-1")
		   .and()
		   .header("content-Encoding","gzip")
		   .and()
		   .header("server","gws")

 		   .log().all();
		 
		
		
	}
	

@Test(priority=2)
void getHeaders() {
	
Response res=given()
	
	              .when()
	                   .get("https://www.google.com/");
	                   
	                   
	                   
	                   //get single header info
	                   
	                   String headervalue=res.getHeader("Content-Type");
                       System.out.println("The value of Content-type header is: "+ headervalue);
                       
                       
                       
                       //get all header info
                       Headers myheaders =res.getHeaders();
                    		   
                    		   for (Header hd:myheaders) {
                    			   System.out.println(hd.getName()+"" +hd.getValue());
                    		   }

	                   
	                   
	                   
	                   
	                   
	                   
	                   
	                   
	    
	//.then()
	//   .header("content-Type", "text/html; charset=ISO-8859-1")
	 //  .and()
	//   .header("content-Encoding","gzip")
	//   .and()
	  // .header("server","gws")

		//   .log().all();
	 
	
	
}

}
