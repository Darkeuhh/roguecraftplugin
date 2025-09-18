package fr.clmt.roguecraft.commands;

import fr.clmt.roguecraft.RogueCraft;
import fr.clmt.roguecraft.rooms.Rooms;
import fr.clmt.roguecraft.structures.builder.SpawnBuilder;
import fr.clmt.roguecraft.structures.builder.TestroomBuilder;
import org.bukkit.Bukkit;
import org.bukkit.block.structure.Mirror;
import org.bukkit.block.structure.StructureRotation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.structure.Structure;
import org.bukkit.util.BlockVector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class RogueCraftCommand implements CommandExecutor, TabExecutor {

    private RogueCraft plugin;

    public RogueCraftCommand(RogueCraft plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            player.sendMessage("RogueCraft command executed!");
            if (args.length == 0) {
                player.sendMessage("No arguments provided.");
                return true;
            }
            if (args[0].equalsIgnoreCase("place")){
                player.sendMessage("Place command executed!");
                if (args.length < 2) {
                    player.sendMessage("Please provide a structure name.");
                    return true;
                }
                String structureName = args[1];
                player.sendMessage("Placing structure: " + structureName);
                int x = player.getLocation().getBlockX();
                int y = player.getLocation().getBlockY();
                int z = player.getLocation().getBlockZ();

                Rooms room = Rooms.searchForRoom(structureName);
                if (room == null) {
                    player.sendMessage("Invalid structure name.");
                    return true;
                }
                room.getBuilder().build(x, y, z, plugin);
                player.sendMessage("Placed structure: " + structureName);
            }
            return true;
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        return List.of();
    }
}
