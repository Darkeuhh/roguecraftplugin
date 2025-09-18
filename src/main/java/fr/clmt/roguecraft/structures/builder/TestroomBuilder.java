package fr.clmt.roguecraft.structures.builder;

import fr.clmt.roguecraft.RogueCraft;
import fr.clmt.roguecraft.rooms.Rooms;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.structure.Structure;
import org.bukkit.util.BlockVector;

import java.io.InputStream;

public class TestroomBuilder extends Builder{
    public void build (int x, int y, int z, RogueCraft plugin){
        Rooms room = Rooms.TESTROOM;
        for(int i = 1; i <= room.getCount(); i++){
            InputStream stream = plugin.getResource(room.getPath() + i + ".nbt");
            try {
                Structure testroom1 = Bukkit.getStructureManager().loadStructure(stream);
                testroom1.place(Bukkit.getWorlds().get(0), new BlockVector(x, y, z), true, org.bukkit.block.structure.StructureRotation.NONE, org.bukkit.block.structure.Mirror.NONE, 0, 1.0f, new java.util.Random());
                stream.close();
            }
            catch (Exception e){
                throw new RuntimeException(e);
            }
        }
        World world = Bukkit.getWorlds().get(0);

        //starts a runnable to spawn portal particles every second and keep this task in a variable to be able to cancel it later
        BukkitTask task = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            world.spawnParticle(Particle.PORTAL, x+8.5, y+1, z+8.5, 10, 0.5, 0.5, 0.5, 0.1);
        }, 0L, 20L);
        BukkitTask task2 = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            world.spawnParticle(Particle.PORTAL, x+12, y+1, z+12, 10, 0.5, 0.5, 0.5, 0.1);
        }, 0L, 20L);

        //cancel the task after 10 seconds
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            task.cancel();
        }, 200L);

        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            task2.cancel();
        }, 400L);


    }
}
