package net.sadam.tutorialmod.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.sadam.tutorialmod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MetalDetectorItem extends Item {

    private ArrayList<Block> mode = new ArrayList<Block>();
    private int currentMode = 0;

    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        if(!pLevel.isClientSide) {

            if (mode.size() == 0) {
                currentMode = 0;
                return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));

            } else if(currentMode == mode.size() - 1) {
                currentMode = 0;

            } else {
                currentMode++;
            }

            pPlayer.sendSystemMessage(Component.literal("Mode set to: " +
                    I18n.get(mode.get(currentMode).getDescriptionId())));
        }

        return InteractionResultHolder.pass(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if(!pContext.getLevel().isClientSide) {
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;


            if(player.isShiftKeyDown()) {
                Block block = pContext.getLevel().getBlockState(positionClicked).getBlock();

                if(mode.contains(block)) {
                    mode.remove(block);
                    currentMode--;

                    player.sendSystemMessage(Component.literal(I18n.get(block.getDescriptionId()) +
                            " was removed from the Metal Detector."));

                } else {
                    mode.add(block);
                    currentMode = mode.indexOf(block);

                    player.sendSystemMessage(Component.literal(I18n.get(block.getDescriptionId()) +
                            " was added to the Metal Detector."));
                }
                return InteractionResult.SUCCESS;
            }

            for(int i = 0; i <= positionClicked.getY() + 64; i++) {
                BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

                if (isValuableBlock(state)) {
                    outputValuableCoordinates(positionClicked.below(i), player, state.getBlock());
                    foundBlock = true;

                    break;
                }
            }

            if(!foundBlock) {
                player.sendSystemMessage(Component.literal("No Valuables Found"));
            }
        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.metal_detector.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + blockPos.getX() + ", " +  blockPos.getY() + ", " + blockPos.getZ() + ")"));
    }

    private boolean isValuableBlock(BlockState state) {
        return state.is(mode.get(currentMode));
    }
}
