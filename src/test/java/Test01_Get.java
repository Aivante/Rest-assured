import org.testng.Assert;
import org.testng.annotations.Test;
import static io. restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//import io.restassured.RestAssured;
//by using static method you can directly use methods without creting object
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class Test01_Get {
	@Test
	void test_01() {
	//Response is a class from rest assured	
	//Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		//because of static we dont need to use Restassured
	Response response=get("https://reqres.in/api/users?page=2");
	System.out.println(response.asString());
	
	System.out.println(response.getBody().asString());
	System.out.println(response.getStatusCode());
	System.out.println(response.getStatusLine());
	System.out.println(response.getHeader("content-type"));
	System.out.println(response.getTime());
	int statuscode=response.getStatusCode();
	//statuccode is a variable
	Assert.assertEquals(statuscode, 200);
	
	}
	@Test
	void test_02() {
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]",equalTo(7))
		.log().all();
	}
	
	
	
	

}
