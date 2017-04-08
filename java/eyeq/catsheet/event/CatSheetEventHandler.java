package eyeq.catsheet.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import eyeq.catsheet.entity.ai.EntityAIOcelotSitOnSheet;

public class CatSheetEventHandler {
    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {
        if(event.getWorld().isRemote) {
            return;
        }
        Entity entity = event.getEntity();
        if(entity instanceof EntityOcelot) {
            EntityOcelot ocelot = (EntityOcelot) entity;
            ocelot.tasks.addTask(6, new EntityAIOcelotSitOnSheet(ocelot, 0.8));
        }
    }
}
