package Pop.Settings;

/**
 * Settings related to the pop file creation
 */
public class FileSettings {
    /**
     * The path of the pop file
     */
    private String popPath;
    public String getPopPath() { return popPath; }
    public void setPopPath(String popPath) { this.popPath = popPath; }

    /**
     * The name of the pop file's mission name
     */
    private String missionName;
    public String getMissionName() { return missionName; }
    public void setMissionName(String missionName) { this.missionName = missionName; }

    /**
     * Whether you want to delete all missions of this name on generate
     */
    private boolean deletingMissions;
    public boolean getDeletingMissions() { return deletingMissions; }
    public void setDeletingMissions(boolean deletingMissions) { this.deletingMissions = deletingMissions; }

    /**
     * Copies the settings over from the given FileSettings
     * @param fileSettings - the object to copy settings from
     */
    public void copySettings(FileSettings fileSettings) {
        popPath = fileSettings.getPopPath();
        missionName = fileSettings.getMissionName();
        deletingMissions = fileSettings.getDeletingMissions();
    }
}
