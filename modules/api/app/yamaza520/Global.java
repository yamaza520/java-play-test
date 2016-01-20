package yamaza520;

import play.*;

public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
        Logger.info("App has started");
    }

    @Override
    public void onStop(Application app) {
        Logger.info("App shutdown...");
    }

}
