package com.helloworld.CRUD.API.Dremio;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/dremio")
public class DremioController {
    String ip = "35.203.177.179";
    String dbUrl = "jdbc:dremio:direct=" + ip + ":31010";
    String token = "";

    @GetMapping("/login")
    public HttpEntity<String> login(@RequestBody String body){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://" + ip + ":9047/apiv2/login");

        HttpEntity<String> response = call(body, headers, builder.toUriString(), HttpMethod.POST);
        token = getValue(response, "token");
        return response;
    }

    @GetMapping("/sql")
    public HttpEntity<String> makeSQLCall(@RequestBody String body){//this will create a job with an id (what you get back). See getJobResults() for how to get the results of the job
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + token);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://" + ip + ":9047/api/v3/sql");

        return call(body, headers, builder.toUriString(), HttpMethod.POST);
    }

    @GetMapping("/getJob/{id}")
    public HttpEntity<String> getJobResults(@PathVariable String id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Bearer " + token);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://" + ip + ":9047/api/v3/job/" + id + "/results");

        HttpEntity<String> response = call("", headers, builder.toUriString(), HttpMethod.GET);
        return response;
    }

    //Makes an actual Http call
    private HttpEntity<String> call(String body, HttpHeaders headers, String url, HttpMethod type) {
        try {
            return new RestTemplate().exchange(url, type, new HttpEntity<>(body, headers), String.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
    Method generated by github co-pilot
     */
    private String getValue(HttpEntity<String> response, String value) {
        String token = "";
        String[] split = response.getBody().split(",");
        for (String s : split) {
            if (s.contains(value)) {
                token = s.split(":")[1];
                token = token.substring(1, token.length() - 1);
                return token;
            }
        }
        return token;
    }
}
