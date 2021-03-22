package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;
import Pop.PopRandomizer;
import Pop.TFBot;

import java.util.ArrayList;

public class Oxidize extends Map {
    /**
     * Constructor
     */
    public Oxidize() {
        super();
        name = "Oxidize";
        popfileName = "oxidize_rc18";
        canSpawnEngineers = true;

        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT_OXIDIZE_SENTRY_BUSTER);

        normalBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_OXIDIZE_FLANKERS);

        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_OXIDIZE_FLANKERS);
        giantBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_OXIDIZE_CHIEF);

        tankRoutes.add(TankRoutes.OXIDIZE);
    }

    /**
     * Sets tags for the bot
     * @param tfBot - the bot to get the tags for
     * @param spawnLocations - the list of locations the bot can spawn from
     */
    public void setBotTags(TFBot tfBot, ArrayList<SpawnLocations> spawnLocations)
    {
        // This map only has one spawn location, so just get it
        SpawnLocations spawnLocation = spawnLocations.get(0);
        if (spawnLocation.equals(SpawnLocations.SPAWN_BOT_OXIDIZE_FLANKERS) && PopRandomizer.generateBoolean()) {
            tfBot.tags.add("flankers");
        }
    }
}
