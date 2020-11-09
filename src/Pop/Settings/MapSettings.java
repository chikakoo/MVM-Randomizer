package Pop.Settings;

import Pop.Enums.Maps;
import Pop.GUI.OutputConsole;
import Pop.Maps.Map;
import Pop.PopRandomizer;

import java.util.*;

/**
 * Settings dealing with the map to generate
 */
public class MapSettings {
    /**
     * The list of all maps that could possibly be chosen
     */
    private HashMap<Maps, MapSetting> maps;
    public HashMap<Maps, MapSetting> getMaps() { return maps; }
    public void setMaps(HashMap<Maps, MapSetting> maps) { this.maps = maps; }

    /**
     * The selected map
     */
    private Maps selectedMap;
    public Maps getSelectedMap() { return selectedMap; }
    public void setSelectedMap(Maps selectedMap) {
        this.selectedMap = selectedMap;
    }

    /**
     * The current map being used for generation
     */
    private Maps activeMap = Maps.DEFAULT;


    /**
     * Constructor - fills in the maps with default values
     */
    public MapSettings() {
        fillInDefaultMapSettings();
    }

    /**
     * Fills in all the default map settings
     */
    private void fillInDefaultMapSettings() {
        maps = new HashMap<>();
        for (Maps map : Maps.values()) {
            maps.put(map, new MapSetting(map));
        }
    }

    /**
     * Gets a list of all the maps that could be chosen
     * Sorts the "Random" option to the top, and the rest alphabetically
     */
    public ArrayList<Maps> getPossibleMaps() {
        ArrayList<Maps> possibleMaps = new ArrayList<>();
        for (MapSetting mapSetting : maps.values()) {
            if (mapSetting.getEnabled()) {
                possibleMaps.add(mapSetting.getMap());
            }
        }

        possibleMaps.sort(Comparator
            .comparing((Maps map) -> !map.getDisplayString().equals("Random"))
            .thenComparing(new Comparator<Maps>() {
                @Override
                public int compare(Maps map1, Maps map2) {
                    if (map1.getDisplayString().equals("Random")) {
                        return 1;
                    }

                    if (map2.getDisplayString().equals("Random")) {
                        return 0;
                    }

                    if (map2.getDisplayString().equals(Maps.DEFAULT.getDisplayString())) {
                        return 1;
                    }
                    return map1.getDisplayString().compareTo(map2.getDisplayString());
                }
            })
        );

        return possibleMaps;
    }

    /**
     * Gets all the map settings that should be displayed in the table, in the correct order
     * @return
     */
    public ArrayList<MapSetting> getMapsSettingsForTable() {
        ArrayList<MapSetting> mapSettings = new ArrayList<>(maps.values());
        mapSettings.remove(maps.get(Maps.DEFAULT));

        Collections.sort(mapSettings, new Comparator<MapSetting>() {
            @Override
            public int compare(MapSetting mapSetting1, MapSetting mapSetting2) {
                return mapSetting1.getMap().getDisplayString().compareTo(mapSetting2.getMap().getDisplayString());
            }
        });

        return mapSettings;
    }

    /**
     * Gets the current map - randomizes it if necessary. This takes the enum and converts it to the corresponding
     * Map file. Will never return Maps.DEFAULT.
     * @return The current map
     */
    public Map getOrRandomizeSelectedMap() {
        if (getPossibleMaps().size() <= 1) {
            OutputConsole.addMessage("ERROR: No maps are currently available to choose from!");
            return new Map();
        }

        if (selectedMap.equals(Maps.DEFAULT) && maps.size() > 1) {
            ArrayList<Maps> possibleMaps = getPossibleMaps();
            int index;

            while (selectedMap.equals(Maps.DEFAULT)) {
                index = PopRandomizer.generateRandomValue(possibleMaps.size());
                selectedMap = possibleMaps.get(index);
            }
        }

        activeMap = selectedMap;
        return Map.getMapFromEnum(selectedMap);
    }

    /**
     * Copies the settings over from the given MapSettings
     * @param mapSettings - the object to copy settings from
     */
    public void copySettings(MapSettings mapSettings) {
        deepCopyMapSettingHashMap(mapSettings.getMaps());
        selectedMap = mapSettings.getSelectedMap();
    }

    /**
     * Deep copy function for the a given map of map settings
     * Overwrites the existing maps setting if they exist, outputs errors for each one that doesn't
     * All other maps will use defaults
     * @param map - the map to copy
     */
    private void deepCopyMapSettingHashMap(HashMap<Maps, MapSetting> map) {
        fillInDefaultMapSettings();

        for (Maps currentMap : map.keySet()) {
            MapSetting currentMapSetting = map.get(currentMap);
            MapSetting newMapSetting = new MapSetting();

            if (getMatchingMap(currentMap) != null) {
                newMapSetting.copySettings(currentMapSetting);
                maps.replace(currentMap, newMapSetting);
            }
        }
    }

    /**
     * Gets the matching map value out of the current map of maps
     * @param mapToFind - The map to find
     * @return The matching map, or null if not found
     */
    private Maps getMatchingMap(Maps mapToFind) {
        for (Maps currentMap : maps.keySet()) {
            if (currentMap.getDisplayString().equals(mapToFind.getDisplayString())) {
                return currentMap;
            }
        }

        return null;
    }

    /**
     * Gets the spawn multiplier of the active map
     * @return The spawn multiplier
     */
    public double getSpawnMultiplier() {
        double spawnMultiplier = maps.get(activeMap).getSpawnMultiplier();
        return spawnMultiplier;
    }

    /**
     * Gets the currency multiplier of the active map
     * @return The currency multiplier
     */
    public double getCurrencyMultiplier() {
        double currencyMultiplier = maps.get(activeMap).getCurrencyMultiplier();
        return currencyMultiplier;
    }

    /**
     * Gets the starting currency of the active map
     * @return The starting currency - randomly generated from the range
     */
    public int getStartingCurrency() {
        return PopRandomizer.generateNumberInRange(maps.get(activeMap).getStartingCurrency());
    }
}
