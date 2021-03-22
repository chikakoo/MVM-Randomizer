package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;
import Pop.PopObject;
import Pop.PopRandomizer;
import Pop.TFBot;
import Pop.WaveSpawn;

import java.util.ArrayList;

public class Trainyard extends Map {
    /**
     * A list of the gate bot spawn locations
     */
    private ArrayList<SpawnLocations> gateBotSpawnLocations;

    /**
     * A list of train relays to be used
     */
    private ArrayList<String> trainRelaysToUse = new ArrayList<>();

    /**
     * Constructor
     */
    public Trainyard() {
        super();
        name = "Trainyard";
        popfileName = "trainyard_rc3d";
        canSpawnEngineers = true;
        usesGateBots = true;

        sentryBusterSpawnLocations.clear();
        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT_TRAINYARD_SENTRY_BUSTER);

        gateBotSpawnLocations = new ArrayList<>();
        gateBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_TRAINYARD_GATEBOT);
        gateBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_TRAINYARD_GATEBOT_LEFT);
        gateBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_TRAINYARD_GATEBOT_MIDDLE);
        gateBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_TRAINYARD_GATEBOT_RIGHT);

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_TRAINYARD_LEFT);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_TRAINYARD_MIDDLE);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_TRAINYARD_RIGHT);

        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_TRAINYARD_LEFT);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_TRAINYARD_MIDDLE);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_TRAINYARD_RIGHT);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_TRAINYARD_BOSS);

        tankRoutes.add(TankRoutes.TRAINYARD_LL);
        tankRoutes.add(TankRoutes.TRAINYARD_RL);
        tankRoutes.add(TankRoutes.TRAINYARD_LU);
        tankRoutes.add(TankRoutes.TRAINYARD_RU);
    }

    /**
     * Sets tags for the bot - flags giant bots so that they won't get stunned by capturing gates
     * @param tfBot - the bot to get the tags for
     */
    @Override
    public void setBotTags(TFBot tfBot)
    {
        switch(PopRandomizer.generateNumberInRange(1, 4)) {
            case 1:
                tfBot.tags.add("bot_flank");
                break;
            case 2:
                tfBot.tags.add("bot_right");
                break;
            case 3:
                tfBot.tags.add("bot_left");
                break;
            default: // No tags
                break;
        }
    }

    /**
     * Clears the train spawn flags
     * @param waveNumber - the wave number
     */
    public void setUpForWave(int waveNumber) {
        trainRelaysToUse.clear();
        trainRelaysToUse.add("train_spawnrelay_A");
        trainRelaysToUse.add("train_spawnrelay_B");
        trainRelaysToUse.add("train_spawnrelay_C");
        trainRelaysToUse.add("train_spawnrelay_D");
    }

    /**
     * 50% chance of summoning a random train
     * @param waveSpawnNumber - the wave spawn
     * @param isLastWaveSpawn - whether this is the final wave spawn
     */
    @Override
    public void setUpForWaveSpawn(WaveSpawn waveSpawn, int waveSpawnNumber, boolean isLastWaveSpawn) {
        if (PopRandomizer.generateBoolean() || trainRelaysToUse.size() == 0) { return; }

        String trainRelay = PopRandomizer.getAndRemoveRandomElement(trainRelaysToUse);

        PopObject firstSpawnOutputObject = new PopObject("FirstSpawnOutput");
        firstSpawnOutputObject.addAttribute("Target", trainRelay);
        firstSpawnOutputObject.addAttribute("Action", "Trigger");

        waveSpawn.setFirstSpawnOutput(firstSpawnOutputObject);
    }
}
