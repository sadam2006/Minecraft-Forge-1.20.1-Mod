package net.sadam.tutorialmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sadam.tutorialmod.TutorialMod;
import net.sadam.tutorialmod.item.custom.FuelItem;
import net.sadam.tutorialmod.item.custom.MetalDetectorItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(200)));

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

    public static final RegistryObject<Item> CHICK_FIL_A_CHICKEN = ITEMS.register("chick_fil_a_chicken",
            () -> new Item(new Item.Properties().food(ModFoods.CHICK_FIL_A_CHICKEN)));

    public static final RegistryObject<Item> CHICK_FIL_A_DELUXE = ITEMS.register("chick_fil_a_deluxe",
            () -> new Item(new Item.Properties().food(ModFoods.CHICK_FIL_A_DELUXE)));

    public static final RegistryObject<Item> CHICK_FIL_A_SPICY_CHICKEN = ITEMS.register("chick_fil_a_spicy_chicken",
            () -> new Item(new Item.Properties().food(ModFoods.CHICK_FIL_A_SPICY_CHICKEN)));

    public static final RegistryObject<Item> CHICK_FIL_A_SPICY_DELUXE = ITEMS.register("chick_fil_a_spicy_deluxe",
            () -> new Item(new Item.Properties().food(ModFoods.CHICK_FIL_A_SPICY_DELUXE)));

    public static final RegistryObject<Item> CHICK_FIL_A_GRILLED_CHICKEN = ITEMS.register("chick_fil_a_grilled_chicken",
            () -> new Item(new Item.Properties().food(ModFoods.CHICK_FIL_A_GRILLED_CHICKEN)));

    public static final RegistryObject<Item> CHICK_FIL_A_GRILLED_CLUB = ITEMS.register("chick_fil_a_grilled_club",
            () -> new Item(new Item.Properties().food(ModFoods.CHICK_FIL_A_GRILLED_CLUB)));

    public static final RegistryObject<Item> CHICK_FIL_A_GRILLED_CHICKEN_COOL_WRAP = ITEMS.register("chick_fil_a_grilled_chicken_cool_wrap",
            () -> new Item(new Item.Properties().food(ModFoods.CHICK_FIL_A_GRILLED_CHICKEN_COOL_WRAP)));

    public static final RegistryObject<Item> CHICK_FIL_A_CHICKEN_NUGGETS = ITEMS.register("chick_fil_a_chicken_nuggets",
            () -> new Item(new Item.Properties().food(ModFoods.CHICK_FIL_A_CHICKEN_NUGGETS)));

    public static final RegistryObject<Item> CHICK_FIL_A_GRILLED_NUGGETS = ITEMS.register("chick_fil_a_grilled_nuggets",
            () -> new Item(new Item.Properties().food(ModFoods.CHICK_FIL_A_GRILLED_NUGGETS)));

    public static final RegistryObject<Item> CHICK_FIL_A_CHICKN_STRIPS = ITEMS.register("chick_fil_a_chickn_strips",
            () -> new Item(new Item.Properties().food(ModFoods.CHICK_FIL_A_CHICKN_STRIPS)));

    public static final RegistryObject<Item> CHICK_FIL_A_MENU = ITEMS.register("chick_fil_a_menu",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            () -> new FuelItem(new Item.Properties(), 400));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
