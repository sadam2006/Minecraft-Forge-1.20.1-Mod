package net.sadam.tutorialmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sadam.tutorialmod.TutorialMod;
import net.sadam.tutorialmod.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUTORIAL_TAB = CREATIVE_MODE_TABS.register("tutorial_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                    .title(Component.translatable("creativetab.tutorial_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SAPPHIRE.get());
                        pOutput.accept(ModItems.RAW_SAPPHIRE.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());

                        pOutput.accept(ModItems.STRAWBERRY.get());

                        pOutput.accept(ModItems.CHICK_FIL_A_CHICKEN.get());
                        pOutput.accept(ModItems.CHICK_FIL_A_DELUXE.get());
                        pOutput.accept(ModItems.CHICK_FIL_A_SPICY_CHICKEN.get());
                        pOutput.accept(ModItems.CHICK_FIL_A_SPICY_DELUXE.get());
                        pOutput.accept(ModItems.CHICK_FIL_A_GRILLED_CHICKEN.get());
                        pOutput.accept(ModItems.CHICK_FIL_A_GRILLED_CLUB.get());
                        pOutput.accept(ModItems.CHICK_FIL_A_GRILLED_CHICKEN_COOL_WRAP.get());
                        pOutput.accept(ModItems.CHICK_FIL_A_CHICKEN_NUGGETS.get());
                        pOutput.accept(ModItems.CHICK_FIL_A_GRILLED_NUGGETS.get());
                        pOutput.accept(ModItems.CHICK_FIL_A_CHICKN_STRIPS.get());
                        pOutput.accept(ModItems.CHICK_FIL_A_MENU.get());

                        pOutput.accept(ModItems.PINE_CONE.get());

                        pOutput.accept(ModBlocks.SAPPHIRE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_SAPPHIRE_BLOCK.get());

                        pOutput.accept(ModBlocks.SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_SAPPHIRE_ORE.get());
                        pOutput.accept(ModBlocks.END_STONE_SAPPHIRE_ORE.get());

                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
