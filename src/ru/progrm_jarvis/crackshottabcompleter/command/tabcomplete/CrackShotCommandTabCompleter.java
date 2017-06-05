package ru.progrm_jarvis.crackshottabcompleter.command.tabcomplete;

import com.shampaggon.crackshot.CSDirector;
//import com.shampaggon.crackshot.CSMinion;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

//import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by PROgrm_JARvis on 05.06.2017.
 */
public class CrackShotCommandTabCompleter implements TabCompleter {
    private CSDirector csPlugin;
    //
    //private CSMinion csMinion;

    public CrackShotCommandTabCompleter(CSDirector csPlugin) {
        this.csPlugin = csPlugin;
        /*try {
            Field field = csPlugin.getClass().getField("csminion");
            if (CSMinion.class.isAssignableFrom(field.getType())) {
                this.csMinion = (CSMinion) field.get(csPlugin);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> variants = new ArrayList<>();
        if (!(sender instanceof Player)) return variants;
        switch (args.length) {
            case (1):
                variants.add("list");
                variants.add("give");
                variants.add("get");
                variants.add("reload");
                variants.add("config");
                break;
            case (2):
                if (args[0].equalsIgnoreCase("list")) variants.add("all");
                else if (args[0].equalsIgnoreCase("give")) variants = null;
                else if (args[0].equalsIgnoreCase("get")) variants.addAll(getWeaponList());
                else if (args[0].equalsIgnoreCase("config")) variants.add("reload");
                break;
            case (3):
                if (args[0].equalsIgnoreCase("give")) variants.addAll(getWeaponList());
                break;
        }
        if (variants != null) variants = TabCompleteManager.adopt(args[args.length-1], variants);
        return variants;
    }

    private Collection<String> getWeaponList() {
        return csPlugin.wlist.values();
    }
}
