package marumasa.hit_stop;

import com.mojang.logging.LogUtils;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.slf4j.Logger;

public class Events {

    private static final Logger LOGGER = LogUtils.getLogger();
    private static int stopServer = 0;
    private static int stopClient = 0;

    @SubscribeEvent
    public void onAttack(AttackEntityEvent event) {
        if (event.getEntity().isLocalPlayer()) LOGGER.info("Hit Stop!!");
        stopServer = 5;
        stopClient = 5;
    }

    @SubscribeEvent
    public void tickServer(TickEvent.ServerTickEvent event) {
        if (stopServer > 0) stopServer--;
        if (stopServer != 1) return;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @SubscribeEvent
    public void tickClient(TickEvent.ClientTickEvent event) {
        if (stopClient > 0) stopClient--;
        if (stopClient != 1) return;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
