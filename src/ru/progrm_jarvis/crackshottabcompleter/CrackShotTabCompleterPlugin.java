package ru.progrm_jarvis.crackshottabcompleter;

import com.shampaggon.crackshot.CSDirector;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import ru.progrm_jarvis.crackshottabcompleter.command.tabcomplete.CrackShotCommandTabCompleter;

import java.util.logging.Logger;

/**
 * Created by PROgrm_JARvis on 05.06.2017.
 */
public class CrackShotTabCompleterPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        PluginDescriptionFile descriptionFile = getDescription();
        Logger logger = getLogger();
        getLogger().info("Enabling plugin (version " + descriptionFile.getVersion() + ")");
        enableTabCompleter();
        getLogger().info("Plugin was enabled (version " + descriptionFile.getVersion() + ")");
    }

    @Override
    public void onDisable() {
        PluginDescriptionFile descriptionFile = getDescription();
        Logger logger = getLogger();
        getLogger().info("Disabling plugin (version " + descriptionFile.getVersion() + ")");
        getLogger().info("Plugin was disabled (version " + descriptionFile.getVersion() + ")");
    }

    private void enableTabCompleter() {
        CSDirector csPlugin = (CSDirector) getServer().getPluginManager().getPlugin("CrackShot");
        getServer().getPluginCommand("crackshot").setTabCompleter(new CrackShotCommandTabCompleter(csPlugin));
    }
}
