package Pop.Maps;

import Pop.Bot.BotTemplate;
import Pop.Enums.SpawnLocations;
import Pop.Enums.TankRoutes;
import Pop.PopObject;
import Pop.PopRandomizer;
import Pop.TFBot;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * (Community) Dockyard
 */
public class Dockyard extends Map {
    /**
     * Constructor
     */
    public Dockyard() {
        super();
        name = "Dockyard";
        popfileName = "dockyard_rc7";
        usesGateBots = true;

        spyBotSpawnLocations = new ArrayList<>();
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DOCKYARD_MAIN_0);
        spyBotSpawnLocations.add(SpawnLocations.SPAWN_BOT_DOCKYARD_MAIN_1);

        sentryBusterSpawnLocations.clear();
        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT_DOCKYARD_MAIN_0);
        sentryBusterSpawnLocations.add(SpawnLocations.SPAWN_BOT_DOCKYARD_MAIN_1);

        tankRoutes.add(TankRoutes.DOCKYARD);
    }

    /**
     * Gets random normal bot locations
     * @return a list of random spawn locations
     */
    @Override
    public ArrayList<SpawnLocations> getRandomNormalBotLocations() {
        return getRandomNormalOrGiantBotLocations();
    }

    /**
     * Gets random normal bot locations
     * @return a list of random spawn locations
     */
    @Override
    public ArrayList<SpawnLocations> getRandomGiantBotLocations() {
        return getRandomNormalOrGiantBotLocations();
    }

    /**
     * Gets a random list of normal or giant bot locations
     * @return a random list of normal or giant bot locations
     */
    private ArrayList<SpawnLocations> getRandomNormalOrGiantBotLocations() {
        ArrayList<SpawnLocations> set1 = new ArrayList<>(Arrays.asList(
                SpawnLocations.SPAWN_BOT_DOCKYARD_MAIN_0,
                SpawnLocations.SPAWN_BOT_DOCKYARD_MAIN_1
        ));
        ArrayList<SpawnLocations> set2 = new ArrayList<>(Arrays.asList(
                SpawnLocations.SPAWN_BOT_DOCKYARD_FlANK_0,
                SpawnLocations.SPAWN_BOT_DOCKYARD_MAIN_1
        ));
        ArrayList<SpawnLocations> set3 = new ArrayList<>(Arrays.asList(
                SpawnLocations.SPAWN_BOT_DOCKYARD_SCATTERED_0,
                SpawnLocations.SPAWN_BOT_DOCKYARD_MAIN_1
        ));

        int setToChoose = PopRandomizer.generateNumberInRange(1, 3);

        switch(setToChoose) {
            case 1: return set1;
            case 2: return set2;
            case 3: return set3;
        }

        return set1; // Should never hit this
    }

    /**
     * Gets random sniper bot locations
     * @return a list of random spawn locations
     */
    @Override
    public ArrayList<SpawnLocations> getRandomSniperBotLocations() {
        ArrayList<SpawnLocations> set1 = new ArrayList<>(Arrays.asList(
            SpawnLocations.SPAWN_BOT_DOCKYARD_MAIN_0,
            SpawnLocations.SPAWN_BOT_DOCKYARD_MAIN_1
        ));
        ArrayList<SpawnLocations> set2 = new ArrayList<>(Arrays.asList(
            SpawnLocations.SPAWN_BOT_DOCKYARD_FlANK_0,
            SpawnLocations.SPAWN_BOT_DOCKYARD_FLANK_1
        ));

        boolean chooseSet1 = PopRandomizer.generateBoolean();
        if (chooseSet1) {
            return set1;
        } else {
            return set2;
        }
    }

    /**
     * Gets random engineer bot locations
     * @return a list of random spawn locations
     */
    @Override
    public ArrayList<SpawnLocations> getRandomEngineerBotLocations() {
        ArrayList<SpawnLocations> set1 = new ArrayList<>(Arrays.asList(
                SpawnLocations.SPAWN_BOT_DOCKYARD_SCATTERED_0,
                SpawnLocations.SPAWN_BOT_DOCKYARD_MAIN_1
        ));
        ArrayList<SpawnLocations> set2 = new ArrayList<>(Arrays.asList(
                SpawnLocations.SPAWN_BOT_DOCKYARD_SCATTERED_0,
                SpawnLocations.SPAWN_BOT_DOCKYARD_SCATTERED_1
        ));

        boolean chooseSet1 = PopRandomizer.generateBoolean();
        if (chooseSet1) {
            return set1;
        } else {
            return set2;
        }
    }

    /**
     * Sets tags for the bot - flags giant bots so that they won't get stunned by capturing gates
     * Also tags sentry busters because that's what the other files do for some reason
     * @param tfBot - the bot to get the tags for
     */
    @Override
    public void setBotTags(TFBot tfBot)
    {
        BotTemplate template = tfBot.getBotTemplate();
        if (template != null && template.getTemplateName().equals("T_TFBot_SentryBuster")) {
            tfBot.tags.add("bot_sentrybuster");
        }
    }
}
