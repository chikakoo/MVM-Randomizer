package Pop.Maps;

import Pop.Enums.SpawnLocations;
import Pop.Enums.TFClasses;
import Pop.PopRandomizer;
import Pop.TFBot;

import java.util.ArrayList;

public class SanctumFotress extends Map {
    public SanctumFotress() {
        super();
        name = "Sanctum Fortress";
        popfileName = "sanctum_fortress_a5";
        canSpawnEngineers = true;

        sentryBusterSpawnLocations.clear();
        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT_SANCTUM_FORTRESS_SENTRY_BUSTER);
    }

    /**
     * Sets tags for the bot - flags giant bots so that they won't get stunned by capturing gates
     * @param tfBot - the bot to get the tags for
     */
    @Override
    public void setBotTags(TFBot tfBot)
    {
        if (tfBot.getTFClass() == TFClasses.SNIPER) {
            tfBot.tags.add("sniper_bot");
        }

        if (!tfBot.getIsGiant() && PopRandomizer.generateBooleanFromPercentage(25)) {
            switch(PopRandomizer.generateNumberInRange(1, 3)) {
                case 1:
                    tfBot.tags.add("tempbomb");
                    break;
                case 2:
                    tfBot.tags.add("sentrybomb");
                    break;
                case 3:
                    tfBot.tags.add("shieldbomb");
                    break;
            }
        }
    }

    /**
     * Sets a bot with any tag to the special bomb spawn location
     * @param tags - The tags
     * @param spawnLocations - The spawn locations to modify
     */
    @Override
    public void changeSpawnLocationFromTags(ArrayList<String> tags, ArrayList<SpawnLocations> spawnLocations) {
        if (tags.contains("tempbomb") || tags.contains("sentrybomb") || tags.contains("shieldbomb")) {
            spawnLocations.clear();
            spawnLocations.add(SpawnLocations.SPAWN_BOT_SANCTUM_FORTRESS_SPECIAL_BOMB);
        }
    }
}
