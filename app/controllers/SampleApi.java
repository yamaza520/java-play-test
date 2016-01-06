package controllers;

import models.ApiResponse;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class SampleApi extends Controller {

    public Result index() {
        ApiResponse res = new ApiResponse();
        res.setStatus(200);

        return ok(Json.toJson(res));
    }

}
