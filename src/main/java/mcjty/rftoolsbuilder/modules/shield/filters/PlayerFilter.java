package mcjty.rftoolsbuilder.modules.shield.filters;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;

public class PlayerFilter extends AbstractShieldFilter {
    public static final String PLAYER = "player";
    private String name = null;

    public PlayerFilter() {
    }

    public PlayerFilter(String name) {
        this.name = name;
    }

    @Override
    public String getFilterName() {
        return PLAYER;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean match(Entity entity) {
        if (!(entity instanceof PlayerEntity)) {
            return false;
        }

        if (name == null || name.isEmpty()) {
            return true;
        }

        PlayerEntity playerEntity = (PlayerEntity) entity;
        return name.equals(playerEntity.getGameProfile().getName());
    }

    @Override
    public void readFromNBT(CompoundNBT tagCompound) {
        super.readFromNBT(tagCompound);
        name = tagCompound.getString("name");
    }

    @Override
    public void writeToNBT(CompoundNBT tagCompound) {
        super.writeToNBT(tagCompound);
        tagCompound.putString("name", name);
    }
}
