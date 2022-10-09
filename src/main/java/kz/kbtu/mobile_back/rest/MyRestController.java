package kz.kbtu.mobile_back.rest;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MyRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/oauth/user")
    public Greeting greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @PostMapping("/user")
    public ResponseEntity user(@RequestBody Credentials credentials) {
        try {
            HttpResponse<JsonNode> jsonNodeHttpResponse =
                    Unirest.post("http://localhost:8080/oauth/token")
                            .basicAuth("client", "secret")
                            .field("grant_type", "password")
                            .field("username", credentials.getLogin().toLowerCase())
                            .field("password", credentials.getPassword())
                            .asJson();
            if (jsonNodeHttpResponse.getStatus() == 200) {
                return new ResponseEntity<>(new AuthorizationToken(new String(Base64.getEncoder().encode(jsonNodeHttpResponse.getBody().getObject().getString("access_token").getBytes()))), HttpStatus.OK);
            }
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setErrorCode(jsonNodeHttpResponse.getBody().getObject().getString("error"));
            errorResponse.setErrorMessage(jsonNodeHttpResponse.getBody().getObject().getString("error_description"));
            return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(jsonNodeHttpResponse.getStatus()));
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setErrorCode("");
            errorResponse.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
