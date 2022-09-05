import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

public class JsonSegundo {

    @Test
    public void deveVerificarSegundoNivel(){
        RestAssured
                .given()
                .when()
                    .get("https://restapi.wcaquino.me/users/2")
                .then()
                    .statusCode(200)
                    .body("id", Matchers.is(2))
                    .body("name", Matchers.containsString("Joaquina"))
                    .body("endereco.rua", Matchers.is("Rua dos bobos"))
        ;
    }

    @Test
    public void deveVerificarLsita(){
        RestAssured
                .given()
                .when()
                    .get("https://restapi.wcaquino.me/users/3")
                .then()
                    .statusCode(200)
                    .body("name", Matchers.containsString("Ana"))
                    .body("filhos", Matchers.hasSize(2))
                    .body("filhos[0].name", Matchers.is("Zezinho"))
                    .body("filhos[1].name",Matchers.is("Luizinho"))
                    .body("filhos.name",Matchers.hasItem("Zezinho"))
                    .body("filhos.name",Matchers.hasItems("Zezinho", "Luizinho", "Qualquer"))
    ;
    }
    @Test
    public void deveRetornarErroUsuarioInexistente(){
        RestAssured
                .given()
                .when()
                    .get("https://restapi.wcaquino.me/users/4")
                .then()
                    .statusCode(404)
                    .body("error", Matchers.is("Usuário inexistente"))
        ;

    }

}
