import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Forgeahead-Shital on 1/23/2017.
 */
public class EmployeeList {
    public String authenticationToken=null;

@Test
public void login() throws Exception {
/*    InputStream inputStream = new FileInputStream("url.properties");
    Properties prop = new Properties();
    prop.load(inputStream);
    String baseURL = prop.getProperty("baseURL");
    System.out.println(baseURL);*/
    HttpResponse<JsonNode> login = Unirest.post("http://10.10.9.165:3000/users/sign_in.json")
            .header("Content-type", "application/json")
            .body("{\"user\" : {\"email\" : \"lareb.nawab@forgeahead.io\", \"password\" : \"password\"}}")
            .asJson();
  //  System.out.println(login.getBody().getObject().getJSONObject("role").get("name"));
    System.out.println(login.getCode());
    int Code = login.getCode();
    authenticationToken = login.getBody().getObject().get("authentication_token").toString();
    System.out.println(authenticationToken);
    if (Code == 300) {
        Assert.assertEquals(Code, 200);
        System.out.println("login successful as status code is 200");

    }
}
}
