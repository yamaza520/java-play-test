package yamaza520.controllers.sample;

import yamaza520.controllers.BaseController;
import yamaza520.response.ApiResponse;
import play.libs.Json;
import play.mvc.Result;

public class SampleApiController extends BaseController {

    public Result index() {
        ApiResponse res = new ApiResponse();
        res.setStatus(200);

        return ok(Json.toJson(res));
    }

}
