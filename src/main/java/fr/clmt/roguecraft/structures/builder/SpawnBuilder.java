package fr.clmt.roguecraft.structures.builder;

import fr.clmt.roguecraft.RogueCraft;
import org.bukkit.Bukkit;
import org.bukkit.block.structure.Mirror;
import org.bukkit.block.structure.StructureRotation;
import org.bukkit.structure.Structure;
import org.bukkit.util.BlockVector;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class SpawnBuilder {
    public static void build(int x, int y, int z, RogueCraft plugin) {
        InputStream stream = plugin.getResource("structures/spawn/spawn1.nbt");
        try {
            Structure spawn1 = Bukkit.getStructureManager().loadStructure(stream);
            spawn1.place(Bukkit.getWorlds().get(0), new BlockVector(x, y, z), true, StructureRotation.NONE, Mirror.NONE, 0, 1.0f, new Random());
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stream = plugin.getResource("structures/spawn/spawn2.nbt");
        try {
            Structure spawn2 = Bukkit.getStructureManager().loadStructure(stream);
            spawn2.place(Bukkit.getWorlds().get(0), new BlockVector(x+48, y, z), true, StructureRotation.NONE, Mirror.NONE, 0, 1.0f, new Random());
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stream = plugin.getResource("structures/spawn/spawn3.nbt");
        try {
            Structure spawn3 = Bukkit.getStructureManager().loadStructure(stream);
            spawn3.place(Bukkit.getWorlds().get(0), new BlockVector(x, y, z+48), true, StructureRotation.NONE, Mirror.NONE, 0, 1.0f, new Random());
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stream = plugin.getResource("structures/spawn/spawn4.nbt");
        try {
            Structure spawn4 = Bukkit.getStructureManager().loadStructure(stream);
            spawn4.place(Bukkit.getWorlds().get(0), new BlockVector(x+48, y, z+48), true, StructureRotation.NONE, Mirror.NONE, 0, 1.0f, new Random());
            stream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
