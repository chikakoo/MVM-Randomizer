package Pop.Maps;

import Pop.*;
import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;

import java.util.ArrayList;

/**
 * (Community) Hillside
 */
public class Condemned extends Map {
    /**
     * Constructor
     */
    public Condemned() {
        super();
        name = "Condemned";
        popfileName = "condemned_b3";
        usesGateBots = true;
        canSpawnEngineers = false;

        sentryBusterSpawnLocations.clear();
        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_SENTRY_BUSTER_FRONT);
        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_SENTRY_BUSTER_BACK);

        spyBotSpawnLocations = new ArrayList<>();
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_SPY_FRONT);
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_SPY_BACK);

        sniperBotSpawnLocations = new ArrayList<>();
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_FRONT);
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_FRONT_RIGHT);
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_FRONT_LEFT);
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_BACK);
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_BACK_RIGHT);
        sniperBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_BACK_LEFT);

        normalBotSpawnLocations.clear();
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_FRONT);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_FRONT_RIGHT);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_FRONT_LEFT);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_BACK);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_BACK_RIGHT);
        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_BACK_LEFT);

        giantBotSpawnLocations.clear();
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_FRONT);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_FRONT_RIGHT);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_FRONT_LEFT);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_BACK);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_BACK_RIGHT);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_CONDEMNED_BACK_LEFT);
    }

    /**
     * Add gatebot attributes to the bot
     * @param tfBot - the object to add the attributes to
     */
    @Override
    public void addGateBotAttributes(TFBot tfBot) {
        String gateToFlank = PopRandomizer.generateNumberInRange(1, 6) + "";
        tfBot.tags.add("nav_prefer_gate" + gateToFlank + "_flank");
        tfBot.tags.add("bot_gatebot");
    }

    /**
     * Gets a list of tags for the bot
     * @param tfBot - the bot to get the tags for
     * @param spawnLocations - the list of locations the bot can spawn from
     * @return The tags
     */
    @Override
    public void setBotTags(TFBot tfBot, ArrayList<SpawnLocations> spawnLocations) {
        tfBot.tags.add("nav_avoid_pit");
    }
}
