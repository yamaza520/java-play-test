package yamaza520.conf;

import com.google.inject.Singleton;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

@Singleton
public class ApplicationConf {

    private Config config;

    public ApplicationConf() {
        this.config = ConfigFactory.load();
    }

    public String getEnv() {
        return this.config.getString("env");
    }
}
