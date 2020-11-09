package Pop;

import java.util.ArrayList;

/**
 * Groupings of bots to spawn
 */
public class Squad extends PopObjectRepresentation {
    /**
     * The list of bots in the squad
     */
    private ArrayList<PopObjectRepresentation> tfBots = new ArrayList();
    public ArrayList<PopObjectRepresentation> getTFBots() { return tfBots; }

    /**
     * Constructor
     */
    public Squad() {
        this.name = "Squad";
    }

    /**
     * Adds the given bot to the squad
     * @param tfBot - the bot to add to the squad
     */
    public void addToSquad(TFBot tfBot) {
        tfBots.add(tfBot);
    }

    /**
     * Returns the representation of this popObject
     * @return the representation of this popObject
     */
    public PopObject getPopObject() {
        PopObject popObject = new PopObject(name);

        populateSquadIfEmpty();
        popObject.addObjectRepresentations(tfBots);

        return popObject;
    }

    /**
     * Mostly used for testing - populates a squad if it has no bots
     */
    private void populateSquadIfEmpty()
    {
        if (tfBots.size() == 0) {
            tfBots.add(new TFBot());
        }
    }

    /**
     * Generates a random representation of this object
     */
    public void generateRandom() {

    }
}
