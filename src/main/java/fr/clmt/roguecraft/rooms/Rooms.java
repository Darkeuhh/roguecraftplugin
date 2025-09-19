package fr.clmt.roguecraft.rooms;

import fr.clmt.roguecraft.structures.builder.Builder;
import fr.clmt.roguecraft.structures.builder.SpawnBuilder;
import fr.clmt.roguecraft.structures.builder.TestroomBuilder;

public enum Rooms {
    SPAWN("spawn", 4, 0, 0, 0, "structures/spawn/spawn", new SpawnBuilder()),
    TESTROOM("testroom", 1, 46, 1, 21, "structures/testroom/testroom", new TestroomBuilder());

    private String name;
    private int count;
    private int x;
    private int y;
    private int z;
    private String path;
    private Builder builder;

    private Rooms(String name, int count, int x, int y, int z, String path,  Builder builder) {
        this.name = name;
        this.count = count;
        this.x = x;
        this.y = y;
        this.z = z;
        this.path = path;
        this.builder = builder;
    }

    public String getName() {
        return this.name;
    }

    public int getCount() {
        return this.count;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getZ() {
        return this.z;
    }

    public String getPath() {
        return this.path;
    }

    public Builder getBuilder() {
        return this.builder;
    }

    public static Rooms searchForRoom(String name){
        for (Rooms room : Rooms.values()) {
            if (room.getName().equalsIgnoreCase(name)) {
                return room;
            }
        }
        return null;
    }


}
