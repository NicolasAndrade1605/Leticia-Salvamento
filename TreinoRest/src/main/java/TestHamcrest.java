import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class TestHamcrest {

    @Test
    public void devoValidarBody(){
        RestAssured.given()
                .when()
                    .get("https://restapi.wcaquino.me/ola")
                .then()
                    .statusCode(200)
                    .body(Matchers.is("Ola Mundo!"))
                    .body(Matchers.containsString("Mundo"))
                    .body(Matchers.is(Matchers.not(Matchers.nullValue())));
    }
}
