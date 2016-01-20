package yamaza520.controllers;

import com.google.inject.Inject;

import play.mvc.Controller;
import yamaza520.conf.ApplicationConf;

public class BaseController extends Controller {

    @Inject protected ApplicationConf appConfig;

}
