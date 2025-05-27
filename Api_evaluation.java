package Assignment;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class Api_evaluation {

	
	 String baseUrl = "https://dummyjson.com";

	    @Test
	    public void getAllProducts() {
	        RestAssured.given().baseUri(baseUrl)
	                .when().get("/products")
	                .then().statusCode(200).body("products.size()", greaterThan(0));
	    }

	    @Test
	    public void getProductById() {
	        RestAssured.given().baseUri(baseUrl)
	                .when().get("/products/1")
	                .then().statusCode(200).body("id", equalTo(1));
	    }

	    @Test
	    public void addProduct() {
	        String payload = "{" +
	                "\"title\": \"Wireless Headphones\"," +
	                "\"price\": 129," +
	                "\"description\": \"Noise-cancelling over-ear headphones\"," +
	                "\"category\": \"audio\"}";

	        RestAssured.given().baseUri(baseUrl)
	                .contentType(ContentType.JSON)
	                .body(payload)
	                .when().post("/products/add")
	                .then().statusCode(200).body("title", equalTo("Wireless Headphones"));
	    }

}
