package br.com.studiotrek.enderecoconsulta.util;

import com.rollbar.notifier.Rollbar;
import com.rollbar.notifier.config.Config;

import static com.rollbar.notifier.config.ConfigBuilder.withAccessToken;

public class RollbarManager {
    private static Rollbar rollbar;

    private RollbarManager() {
    }

    public static Rollbar getInstance() {
        if(rollbar == null) {
            Config config = withAccessToken("4c427502c65d40ca98c06623f1a1c6fd")
                .environment("development")
                .codeVersion("1.0.0")
                .build();

            rollbar = Rollbar.init(config);
        }

        return rollbar;
    }
}
