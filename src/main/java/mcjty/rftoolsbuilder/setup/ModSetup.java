package mcjty.rftoolsbuilder.setup;

import mcjty.lib.compat.MainCompatHandler;
import mcjty.lib.setup.DefaultModSetup;
import mcjty.rftoolsbuilder.modules.builder.BuilderModule;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ModSetup extends DefaultModSetup {

    public ModSetup() {
        createTab("rftoolsbuilder", () -> new ItemStack(BuilderModule.BUILDER.get()));
    }

    @Override
    public void init(FMLCommonSetupEvent e) {
        super.init(e);
        e.enqueueWork(() -> {
            CommandHandler.registerCommands();
        });
        RFToolsBuilderMessages.registerMessages("rftoolsbuilder");
    }

    @Override
    protected void setupModCompat() {
        MainCompatHandler.registerWaila();
        MainCompatHandler.registerTOP();
//        FMLInterModComms.sendFunctionMessage("theoneprobe", "getTheOneProbe", "mcjty.rftools.compat.theoneprobe.TheOneProbeSupport");
    }
}
