package example.model;

/**
 * Represents a system setting.
 */
public class SystemSettings {
    private String settingName;
    private String settingValue;

    /**
     * Constructor for SystemSettings.
     *
     * @param settingName  Name of the system setting.
     * @param settingValue Value of the system setting.
     */
    public SystemSettings(String settingName, String settingValue) {
        this.settingName = settingName;
        this.settingValue = settingValue;
    }

    /**
     * Gets the name of the system setting.
     *
     * @return Name of the system setting.
     */
    public String getSettingName() {
        return settingName;
    }

    /**
     * Sets the name of the system setting.
     *
     * @param settingName Name of the system setting.
     */
    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    /**
     * Gets the value of the system setting.
     *
     * @return Value of the system setting.
     */
    public String getSettingValue() {
        return settingValue;
    }

    /**
     * Sets the value of the system setting.
     *
     * @param settingValue Value of the system setting.
     */
    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue;
    }
}