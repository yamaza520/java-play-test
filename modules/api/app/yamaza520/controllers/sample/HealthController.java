package yamaza520.controllers.sample;

import yamaza520.controllers.BaseController;
import yamaza520.logics.TaskLogic;
import play.Logger;
import play.i18n.Messages;
import play.libs.Json;
import play.mvc.*;

public class HealthController extends BaseController {

    public Result index() {

        Logger.debug("env=" + appConfig.getEnv());

        int a = TaskLogic.iterate(1);

        String success = Messages.get("save.success");

        // db access
        boolean b = TaskLogic.getDbData();
        String c = TaskLogic.getContents(1L);

        return ok(Json.toJson("Your application is ready.")).as(Http.MimeTypes.JSON);
    }

}
