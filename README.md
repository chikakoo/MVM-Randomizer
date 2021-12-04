# MVM-Randomizer
Creates balanced, randomized MVM POP files for Team Fortress 2.

It's worth noting that this was originally just a place for me and a couple friends to post our code, so it's not very professional looking!

# Setup
To use this, first either download a release, or build the source code into a jar file. In the end, you need a directory with the following things:
- MVM Randomizer.jar
- Saved Settings folder with some json files in it
- Pop Files folder with some pop files in it
- Class Icons folder with vmt and vtf files in it

Find your TF2 population file directory - this is typically at _C:\Program Files (x86)\Steam\steamapps\common\Team Fortress 2\tf\scripts\population_. Doing the following will allow your local server to use the custom pop files.
- Copy **(do not move!!!)** the pop files directly into this directory. Do not copy the folder, just the files themselves.

Find your TF2 hud directory - this is typically at _C:\Program Files (x86)\Steam\steamapps\common\Team Fortress 2\tf\materials\hud_. Doing the following will add the custom class icons for the bots. If you deleted the custom templates, you will still want to move the files that start with _leaderboard_class_random_, else the randomly created bots will not have icons.
- Copy the files form the Class Icons folder into this directory. Do not copy the folder, just the files themselves.

## Pop Files Directory
The ones that start with "custom" are optional - they're specially made bots that can be used if desired. Simply delete the files if you don't want to use them.

You can create your own template files and put them in both places (the randomizer Pop Files folder, and the TF2 directory) and the randomizer should pick it up!

# Running the program
- Run the MVM Randomizer.jar file. You may need to install Java to do this.
- On the "Generate" tab, make sure the path is set to your actual population directory. You can click the folder icon to see if it will open. If you need to change the directory, you can click the ellipses to do so.
- At this point, you should be good to go - read further to see some specifics about your options

## Generate
Here's a brief overview of everything here:
- Path to the population directory, with a browse and open directory button
- How to name the pop file to generate. The name represents the map, "Random" being any random choice currently listed in the dropdown. The last textbox can be any text - used for the mission name.
- You can set a range of waves for your pop file. If you want a specific number, set both sides to that number.
- Generate wave buttons - see the tooltips for what these mean.
- Output window

## Wave
Here you can set up how each wave will look as they are generated. More waves are added automatically as you change the wave numbers on the Generate tab. **It's worth noting that you may lose data if you make the wave numbers smaller!**

The context menu has various options for moving things around.

## Bot
Various options for setting up the bots. There are separate options for normal, giant, standard, and support/mission bots.

Be aware that snipers that aren't mission snipers are set to always fire their weapon, because they don't know how otherwise!

## Random Bot
Various options for how non-templated bots are generated - most of these are cosmetic. Attributes are things like "shots apply bleed for 1 second". 

## Tank
Various tank settings - the default settings are balanced for 2 players, so rebalance if necessary!

## Map
Settings for maps - this is probably the easiest way to change difficulty - just adjust the spawn/currency multipliers!

Note that for the maps that are NOT standard, you will want the exact version that's listed on the Generate tab's output window after generating your pop file.

If you want to only generate for standard maps, right click the table and choose "enable only standard maps".

If there's a community map that you want support for, feel free to make a pull request for it, or post a request for it here.
