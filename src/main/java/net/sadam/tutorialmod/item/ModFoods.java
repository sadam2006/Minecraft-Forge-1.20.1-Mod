package net.sadam.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.1f).build();

    public static final FoodProperties CHICK_FIL_A_CHICKEN = new FoodProperties.Builder().nutrition(6)
            .saturationMod(0.8f).build();
    public static final FoodProperties CHICK_FIL_A_DELUXE = new FoodProperties.Builder().nutrition(7)
            .saturationMod(0.9f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400), 0.8f).build();
}
