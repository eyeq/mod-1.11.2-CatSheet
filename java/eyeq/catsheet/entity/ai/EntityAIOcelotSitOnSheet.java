package eyeq.catsheet.entity.ai;

import net.minecraft.entity.ai.EntityAIOcelotSit;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import eyeq.catsheet.CatSheet;

public class EntityAIOcelotSitOnSheet extends EntityAIOcelotSit {
    public EntityAIOcelotSitOnSheet(EntityOcelot entity, double speed) {
        super(entity, speed);
    }

    @Override
    protected boolean shouldMoveTo(World world, BlockPos pos) {
        return world.getBlockState(pos).getBlock() == CatSheet.catSheet;
    }
}
