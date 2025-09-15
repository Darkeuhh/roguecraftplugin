package fr.clmt.roguecraft;

import fr.clmt.roguecraft.commands.RogueCraftCommand;
import io.papermc.paper.math.BlockPosition;
import org.bukkit.Bukkit;
import org.bukkit.Rotation;
import org.bukkit.block.structure.Mirror;
import org.bukkit.block.structure.StructureRotation;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.structure.Structure;
import org.bukkit.util.BlockVector;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public final class RogueCraft extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        System.out.println("RogueCraft enabled!");

        getCommand("roguecraft").setExecutor(new RogueCraftCommand(this));


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
