package Extensions;

import Utilities.CommonOps;
import io.qameta.allure.Step;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;

/**
 * @author Rolan Abdualiev , Dec 2021
 * @project QA-AutomationDemonstration
 */
public class APIActions extends CommonOps {
    @Step("Get users list")
    public static int getResponse(String path) {
        response = httpRequest.get(path);
        return response.getStatusCode();
    }

    @Step("Post")
    public static void post(JSONObject par) {
        httpRequest.body(par.toJSONString());
        response = httpRequest.post(adminApiURL);
    }

    @Step("Get data from the server by id")
    public static String getUserDataByName(String path, String id) {
        response = httpRequest.get(path + id);
        JsonPath jp = response.jsonPath();
        return jp.get("name").toString();

    }

    @Step("PUT (UPDATE) Request")
    public static void put(JSONObject par, String path) {
        httpRequest.body(par.toJSONString());
        response = httpRequest.put(path);
    }


}
