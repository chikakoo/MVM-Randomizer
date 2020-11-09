package Pop.Settings;

/**
 * This class assigns arbitrary percentages to each TFClass - to be used in individual settings files
 */
public class ClassPercentage {
    /**
     * All of these are properties you can use to set percentages on each class, what they mean will
     * vary based on the setting
     */
    private int demomanPercentage;
    public int getDemomanPercentage() {
        return demomanPercentage;
    }
    public void setDemomanPercentage(int demomanPercentage) {
        this.demomanPercentage = demomanPercentage;
    }

    private int engineerPercentage;
    public int getEngineerPercentage() { return engineerPercentage; }
    public void setEngineerPercentage(int engineerPercentage) {
        this.engineerPercentage = engineerPercentage;
    }

    private int heavyPercentage;
    public int getHeavyPercentage() {
        return heavyPercentage;
    }
    public void setHeavyPercentage(int heavyPercentage) {
        this.heavyPercentage = heavyPercentage;
    }

    private int medicPercentage;
    public int getMedicPercentage() {
        return medicPercentage;
    }
    public void setMedicPercentage(int medicPercentage) {
        this.medicPercentage = medicPercentage;
    }

    private int pyroPercentage;
    public int getPyroPercentage() {
        return pyroPercentage;
    }
    public void setPyroPercentage(int pyroPercentage) {
        this.pyroPercentage = pyroPercentage;
    }

    private int scoutPercentage;
    public int getScoutPercentage() {
        return scoutPercentage;
    }
    public void setScoutPercentage(int scoutPercentage) {
        this.scoutPercentage = scoutPercentage;
    }

    private int sniperPercentage;
    public int getSniperPercentage() {
        return sniperPercentage;
    }
    public void setSniperPercentage(int sniperPercentage) {
        this.sniperPercentage = sniperPercentage;
    }

    private int soldierPercentage;
    public int getSoldierPercentage() {
        return soldierPercentage;
    }
    public void setSoldierPercentage(int soldierPercentage) {
        this.soldierPercentage = soldierPercentage;
    }

    private int spyPercentage;
    public int getSpyPercentage() {
        return spyPercentage;
    }
    public void setSpyPercentage(int spyPercentage) {
        this.spyPercentage = spyPercentage;
    }

    /**
     * Constructor
     */
    public ClassPercentage(
            int demomanPercentage,
            int heavyPercentage,
            int medicPercentage,
            int pyroPercentage,
            int scoutPercentage,
            int soldierPercentage,
            int sniperPercentage,
            int spyPercentage,
            int engineerPercentage) {
        this.demomanPercentage = demomanPercentage;
        this.heavyPercentage = heavyPercentage;
        this.medicPercentage = medicPercentage;
        this.pyroPercentage = pyroPercentage;
        this.scoutPercentage = scoutPercentage;
        this.soldierPercentage = soldierPercentage;
        this.sniperPercentage = sniperPercentage;
        this.spyPercentage = spyPercentage;
        this.engineerPercentage = engineerPercentage;
    }

    /**
     * Copy constructor
     */
    public ClassPercentage(ClassPercentage classPercentageToCopyFrom) {
        this.demomanPercentage = classPercentageToCopyFrom.getDemomanPercentage();
        this.heavyPercentage = classPercentageToCopyFrom.getHeavyPercentage();
        this.medicPercentage = classPercentageToCopyFrom.getMedicPercentage();
        this.pyroPercentage = classPercentageToCopyFrom.getPyroPercentage();
        this.scoutPercentage = classPercentageToCopyFrom.getScoutPercentage();
        this.soldierPercentage = classPercentageToCopyFrom.getSoldierPercentage();
        this.sniperPercentage = classPercentageToCopyFrom.getSniperPercentage();
        this.spyPercentage = classPercentageToCopyFrom.getSpyPercentage();
        this.engineerPercentage = classPercentageToCopyFrom.getEngineerPercentage();
    }

    /**
     * Default constructor
     */
    public ClassPercentage() { }
}
