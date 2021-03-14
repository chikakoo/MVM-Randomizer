package Pop.Maps;

import Pop.*;
import Pop.Enums.Maps;
import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

import java.util.ArrayList;

/**
 * Represents a TF2 map
 */
public class Map {
    /**
     * The name of the map
     */
    protected String name = "Default";
    public String getName() { return name; }

    /**
     * The name the map should list in the popfile
     */
    protected String popfileName = "Default";
    public String getPopfileName() { return popfileName; }

    /**
     * The list of locations normal bots could spawn from
     */
    protected ArrayList<SpawnLocations> normalBotSpawnLocations;

    /**
     * The list of locations giant bots could spawn from
     */
    protected ArrayList<SpawnLocations> giantBotSpawnLocations;

    /**
     * The list of locations spy bots could spawn from
     */
    protected ArrayList<SpawnLocations> spyBotSpawnLocations;

    /**
     * The list of locations sniper bots could spawn from
     */
    protected ArrayList<SpawnLocations> sniperBotSpawnLocations;

    /**
     * The list of locations engineer bots could spawn from
     */
    protected ArrayList<SpawnLocations> engineerBotSpawnLocations;

    /**
     * The list of locations sentry buster could spawn from
     */
    protected ArrayList<SpawnLocations> sentryBusterSpawnLocations;
    public ArrayList<SpawnLocations> getSentryBusterSpawnLocations() { return sentryBusterSpawnLocations; }

    /**
     * The list of tank routes
     */
    protected ArrayList<TankRoutes> tankRoutes;

    /**
     * Whether the map has tanks, but there's no name for the rank route
     */
    public boolean hasTanksButNoName = false;

    /**
     * Whether this map should use the OnKilledOutput object for tanks
     */
    protected boolean useOnKilledOutput = true;
    public boolean getUseOnKilledOutput() { return useOnKilledOutput; }

    /**
     * Whether this map can spawn engineers
     * If we're in highlander mode, never spawn them since they'll still build sentries
     */
    protected boolean canSpawnEngineers = true;
    public boolean getCanSpawnEngineers() {
        return this.canSpawnEngineers && !MVMRandomizer.botSettings.isHighlanderMode();
    }

    /**
     * Custom start/stop wave attribute names - only currently used by Saddle
     */
    protected String customStartWaveOutputName;
    protected String customEndWaveOutputName;

    /**
     * Whether this map uses gate bots - used to determine whether to always generate a support
     */
    protected boolean usesGateBots = false;
    public boolean usesGateBots() { return usesGateBots; }

    /**
     * Whether this map uses chip bots - used to determine whether to always generate a support
     */
    protected boolean usesChipBots = false;
    public boolean usesChipBots() { return usesChipBots; }

    /**
     * Constructor
     */
    public Map() {
        normalBotSpawnLocations = new ArrayList<>();
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);

        giantBotSpawnLocations = new ArrayList<>();
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);

        spyBotSpawnLocations = new ArrayList<>();
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SPY);

        sniperBotSpawnLocations = new ArrayList<>();
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_SNIPER);

        engineerBotSpawnLocations = new ArrayList<>();
        engineerBotSpawnLocations.add(SpawnLocations.SPAWN_BOT);

        sentryBusterSpawnLocations = new ArrayList<>();
        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT);

        tankRoutes = new ArrayList<>();
    }

    /**
     * Factory method for getting a map from an enum
     * @param map - the enum value
     * @return the new map of the correct type
     */
    public static Map getMapFromEnum(Maps map) {
        switch(map) {
            case BIGROCK:
                return new Bigrock();
            case COALTOWN:
                return new Coaltown();
            case DECOY:
                return new Decoy();
            case MANNHATTAN:
                return new Mannhattan();
            case MANNWORKS:
                return new Mannworks();
            case ROTTENBURG:
                return new Rottenburg();
            case TEIEN:
                return new Teien();
            case INTERSECTION:
                return new Intersection();
            case SANDSTONE:
                return new Sandstone();
            case MAELSTROM:
                return new Maelstrom();
            //case DERP:
            //    return new Derp();
            case MUSEUM:
                return new Museum();
            case VENTUS:
                return new Ventus();
            case PLATEAU:
                return new Plateau();
            case QUETZALCOATL:
                return new Quetzalcoatl();
            case DAMM:
                return new Damm();
            case WATERFRONT:
                return new Waterfront();
            case DOCKYARD:
                return new Dockyard();
            case TEUFORT:
                return new Teufort();
            case ATOMGRAD:
                return new Atomgrad();
            case SNOWFLAKE:
                return new Snowflake();
            case SPACEPOST:
                return new Spacepost();
            case AFFINITY:
                return new Affinity();
            case MANNDARIN:
                return new Manndarin();
            case OILRIG:
                return new Oilrig();
            case SADDLE:
                return new Saddle();
            case HILLSIDE:
                return new Hillside();
            case MANNCOHQ:
                return new ManncoHQ();
            case OVERGREEN:
                return new Overgreen();
            case BANDCORNER:
                return new BandCorner();
            case MARIO_KART:
                return new MarioKart();
            case BRUGGE:
                return new Brugge();
            case SHIVER_PEAK:
                return new ShiverPeak();
            case CONDEMNED:
                return new Condemned();
            case COAST_ROCK:
                return new CoastRock();
            case CASINO_CITY:
                return new CasinoCity();
            default:
                return new Map();
        }
    }

    /**
     * Gets a random location from a given list of spawn locations
     * @param spawnLocation the list of spawn locations to choose from
     * @return a list of a random spawn location
     */
    protected ArrayList<SpawnLocations> getRandomSpawnLocation(ArrayList<SpawnLocations> spawnLocation) {
        ArrayList<SpawnLocations> spawnLocations = new ArrayList<>();
        int index = PopRandomizer.generateRandomValue(spawnLocation.size());
        spawnLocations.add(spawnLocation.get(index));

        return spawnLocations;
    }

    /**
     * Creates the object for StartWaveOutput - this is the same for each wave
     * @return the created object
     */
    public PopObject createStartWaveOutputObject() {
        PopObject startWaveOutput = new PopObject("StartWaveOutput");
        startWaveOutput.addAttribute("Target", "wave_start_relay");
        startWaveOutput.addAttribute("Action", "trigger");

        return startWaveOutput;
    }

    /**
     * Creates the object for DoneOutput - this is the same for each wave
     * @return the created object
     */
    public PopObject createDoneOutputObject() {
        PopObject doneOutput = new PopObject("DoneOutput");
        doneOutput.addAttribute("Target", "wave_finished_relay");
        doneOutput.addAttribute("Action", "trigger");

        return doneOutput;
    }

    /**
     * Gets a random location for a normal bot
     * @return a list of random spawn locations
     */
    public ArrayList<SpawnLocations> getRandomNormalBotLocations() {
        return getRandomSpawnLocation(normalBotSpawnLocations);
    }

    /**
     * Gets a random location for a giant bot
     * @return a list of random spawn locations
     */
    public ArrayList<SpawnLocations> getRandomGiantBotLocations() {
        return getRandomSpawnLocation(giantBotSpawnLocations);
    }

    /**
     * Gets random spy bot locations - currently, we want all of these for each map. Modify this
     * if this ever changes.
     * @return a list of random spawn locations
     */
    public ArrayList<SpawnLocations> getRandomSpyBotLocations() {
        return spyBotSpawnLocations;
    }

    /**
     * Gets random sniper bot locations - currently, we want all of these for each map. Modify this
     * if this ever changes.
     * @return a list of random spawn locations
     */
    public ArrayList<SpawnLocations> getRandomSniperBotLocations() {
        return sniperBotSpawnLocations;
    }

    /**
     * Gets random sniper bot locations - currently, we want all of these for each map. Modify this
     * if this ever changes.
     * @return a list of random spawn locations
     */
    public ArrayList<SpawnLocations> getRandomEngineerBotLocations() {
        return getRandomSpawnLocation(engineerBotSpawnLocations);
    }

    /**
     * Add attributes to the bot - only used by specific maps
     * @param popObject - the object to add the attributes to
     */
    public void addGateBotAttributes(PopObject popObject) { }

    /**
     * Returns whether the map has a tank
     * @return true if it does, false otherwise
     */
    public boolean hasTankRoutes() {
        return tankRoutes.size() > 0 || hasTanksButNoName;
    }

    /**
     * Gets a random routes for this tank
     * @return the route
     */
    public TankRoutes getRandomTankRoute() {
        int index = PopRandomizer.generateRandomValue(tankRoutes.size());
        return tankRoutes.get(index);
    }

    /**
     * Performs any necessary setup for a given wave number
     * @param waveNumber - the wave number
     */
    public void setUpForWave(int waveNumber) {
        // No code here, overridden by the relevant maps
    }

    /**
     * Sets tags for the bot
     * @param tfBot - the bot to get the tags for
     */
    public void setBotTags(TFBot tfBot)
    {
        // No code here, overridden by the relevant maps
    }

    /**
     * Sets tags for the bot
     * @param tfBot - the bot to get the tags for
     * @param spawnLocations - the list of locations the bot can spawn from
     */
    public void setBotTags(TFBot tfBot, ArrayList<SpawnLocations> spawnLocations)
    {
        // No code here, overridden by the relevant maps
    }

    /**
     * Sets tags for the bot
     * @param tfBot - the bot to get the tags for
     * @param waveSpawn - the WaveSpawn object to manipulate
     */
    public void setBotTags(TFBot tfBot, WaveSpawn waveSpawn)
    {
        // No code here, overridden by the relevant maps
    }
}