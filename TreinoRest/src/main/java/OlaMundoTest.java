import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Test;

public class OlaMundoTest {

    @Test
    public void testOlaMundo(){
        Response response = RestAssured.request(Method.GET, "https://restapi.wcaquino.me/ola");
        System.out.println(response.getBody().asString().equals("Ola Mundo!"));
        System.out.println(response.statusCode()==200);
        Assert.assertTrue("O status code deveria ser 200", response.statusCode()==200);
        Assert.assertEquals(response.statusCode(),200);

        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);

    }

    @Test
    public void devoConhecerOutrasFormasRestAssured(){
        Response response = RestAssured.request(Method.GET, "https://restapi.wcaquino.me/ola");
        ValidatableResponse validacao = response.then();
        validacao.statusCode(200);

        RestAssured.get("https://restapi.wcaquino.me/ola").then().statusCode(200);

        RestAssured.given(). //pre condições
                when(). //ação
                    get("https://restapi.wcaqino.me/ola").
                then(). //assertivas
                    statusCode(200);

    }
}
