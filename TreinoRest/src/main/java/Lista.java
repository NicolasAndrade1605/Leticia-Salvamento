import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;

public class Lista {
    @Test
    public void deveVerificarListaRaiz (){
        RestAssured.
                given()
                .when()
                    .get("https://restapi.wcaquino.me/users")
                .then()
                    .statusCode(200)
                    .body("$", Matchers.hasSize(3))
                    .body("name", Matchers.hasItems("João da Silva" , "Maria Joaquina", "Ana Júlia"))
                    .body("age[1]", Matchers.is(25))
                    .body("filhos.name", Matchers.hasItem(Arrays.asList("Zezinho" , "Luizinho")))
                    //.body("filhos.name", Matchers.hasItem(Arrays.asList("Zezinho")))
                    .body("salary", Matchers.contains(1234.5677f , 2500, null))
        ;
    }
    @Test
    public void devoFazerVerificacoesAvancadas(){
        RestAssured
                .given()
                .when()
                    .get("https://restapi.wcaquino.me/users")
                .then()
                    .statusCode(200)
                    .body("age.findAll{it <= 25}.size()", Matchers.is(2))
                    .body("age.findAll{it <= 25 && it > 20}.size()", Matchers.is(1))
                    .body("findAll{it.age <= 25 && it.age > 20}.name", Matchers.hasItem("Maria Joaquina"))
                    .body("findAll{it.age <= 25}[0].name", Matchers.is("Maria Joaquina"))
                    .body("findAll{it.age <= 25}[-1].name", Matchers.is("Ana Júlia"))
                    .body("findAll{it.name.contains('n')}.name", Matchers.hasItems("Maria Joaquina", "Ana Júlia"))
                    .body("findAll{it.name.length() > 10}.name", Matchers.hasItems("Maria Joaquina", "João da Silva"))
                    .body("name.collect{it.toUpperCase()}", Matchers.hasItems("MARIA JOAQUINA"))
                    .body("name.findAll{it.startsWith('Maria')}.collect{it.toUpperCase()}", Matchers.hasItem("MARIA JOAQUINA"))
                    //.body("name.findAll{it.startsWith('Maria')}.collect{it.toUpperCase()}", Matchers.allOf(Matchers.arrayContaining("MARIA JOAQUINA"), Matchers.arrayWithSize(1)))

        ;
    }
}
