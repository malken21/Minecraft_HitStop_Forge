package marumasa.hit_stop;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(minecraft.MODID)
public class minecraft {
    public static final String MODID = "hit_stop";

    public minecraft() {
        MinecraftForge.EVENT_BUS.register((new Events()));
    }
}
