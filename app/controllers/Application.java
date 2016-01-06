package controllers;

import logics.TestLogic;
import play.i18n.Messages;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public Result index() {
        int a = TestLogic.iterate(1);

        String success = Messages.get("save.success");

        // db access
        boolean b = TestLogic.getDbData();
        String c = TestLogic.getContents(1L);

        return ok(index.render("Your new application is ready."));
    }

}
