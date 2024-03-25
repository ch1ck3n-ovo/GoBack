package tw.ch1ck3n.goback.configs;

import tw.ch1ck3n.goback.GoBack;

public class Settings {

    public final long keepTime;

    public Settings() {
        this.keepTime = GoBack.INSTANCE.getConfig().getLong("setting.keep-time");
    }
}
