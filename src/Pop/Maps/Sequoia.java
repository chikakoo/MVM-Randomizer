package Pop.Maps;

import Pop.Bot.BotTemplate;
import Pop.Enums.TankRoutes;
import Pop.PopObject;
import Pop.PopRandomizer;
import Pop.TFBot;

public class Sequoia extends Map {
    /**
     * Constructor
     */
    public Sequoia() {
        super();
        name = "Sequoia";
        popfileName = "sequoia_rc4";
        usesGateBots = true;
        canSpawnEngineers = false;

        tankRoutes.add(TankRoutes.SEQUOIA);
    }

    /**
     * Sets tags for the bot
     * @param tfBot - the bot to get the tags for
     */
    @Override
    public void setBotTags(TFBot tfBot) {
        if (PopRandomizer.generateBoolean()) {
            tfBot.tags.add("nav_prefer_flank_right");
        }
    }

    /**
     * Sets tags for mission bots
     * @param tfBot - the bot to get the tags for
     */
    @Override
    public void setMissionBotTags(TFBot tfBot) {
        BotTemplate template = tfBot.getBotTemplate();
        if (template != null && template.getTemplateName().equals("T_TFBot_SentryBuster")) {
            tfBot.tags.add("bot_sentrybuster");
        }
    }
}
