package Pop.Bot.Weapons;

public class WeaponModel {
    /**
     * The name of the model, including the path
     */
    private String modelName;
    public String getModelName() { return modelName; }

    /**
     * The user-friendly name, to be used with bot names
     */
    private String friendlyName;
    public String getFriendlyName() { return friendlyName; }

    /**
     * Whether the model should also turn the player to gold if they kill them
     */
    private boolean turnToGoldOnDeath;
    public boolean getTurnToGoldOnDeath() { return turnToGoldOnDeath; }

    /**
     * Constructors
     */
    public WeaponModel(String modelName) {
        this.modelName = modelName;
    }

    public WeaponModel(String modelName, String friendlyName) {
        this.modelName = modelName;
        this.friendlyName = friendlyName;
    }

    public WeaponModel(String modelName, String friendlyName, boolean turnToGoldOnDeath) {
        this.modelName = modelName;
        this.friendlyName = friendlyName;
        this.turnToGoldOnDeath = turnToGoldOnDeath;
    }

    /**
     * Returns whether the model has a friendly name - checks for null or whitespace
     * @return true if so, false otherwise
     */
    public boolean hasFriendlyName() {
        return friendlyName != null && !friendlyName.trim().equals("");
    }

    /**
     * The toString just returns the model name
     * @return the model name
     */
    public String toString() {
        return modelName;
    }
}
