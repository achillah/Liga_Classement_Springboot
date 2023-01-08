package be.abd.helbdemo.Controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.Date;

public class ControllerIntegrationTest {

    @Test
    public void whenRequestGetPlayers_ThenOk()
    {
        RestAssured.with().request("GET","http://localhost:8090/players").then().statusCode(200);
        //Le test ici est passé car j'ai laisse l'accès a l'URL libre je vais maintenant faire un test en bloquant l'accès.
    }

    @Test
    public void whenRequestGetLeague_ThenOk()
    {
        RestAssured.with().request("GET","http://localhost:8090/leagues").then().statusCode(200);
        //Le test ici est pas passé car j'ai bloqué l'accès a l'URL du coup il ne peut pas l'atteindre et remet une erreur 403 au lieu de 200
        //Je vais maintenant faire un dernier test ou je vais accorder l'accès a une URL qui est normalement bloqué
    }


    @Test
    public void whenRequestTrainer_ThenOK()
    {
        RestAssured.with().auth().oauth2(getToken()).when().request("GET","http://localhost:8090/trainers").then().statusCode(200);
    }


    //cette méthode va nous permettre de generer un token pour donner l'accès a l'URL
    public String getToken(){
        return Jwts.builder()
                .setSubject("user")
                .setExpiration(new Date(System.currentTimeMillis() + 864_000_000))
                .signWith(SignatureAlgorithm.HS512,"SecretKeyToGenJWTsSecretKeyToGenJWTs".getBytes())
                .compact();
    }
}
