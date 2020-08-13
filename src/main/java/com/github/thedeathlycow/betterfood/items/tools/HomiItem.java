package com.github.thedeathlycow.betterfood.items.tools;

import com.github.thedeathlycow.betterfood.init.ModBlocks;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

import javax.swing.*;
import java.util.Map;

public class HomiItem extends TieredItem {

    private final float speed;
    protected static final Map<Block, BlockState> HOMI_LOOKUP = Maps.newHashMap(ImmutableMap.of(
            Blocks.GRASS_BLOCK, ModBlocks.PADDY.getDefaultState(),
            Blocks.GRASS_PATH, ModBlocks.PADDY.getDefaultState(),
            Blocks.DIRT, ModBlocks.PADDY.getDefaultState(),
            Blocks.COARSE_DIRT, Blocks.DIRT.getDefaultState(),
            Blocks.NETHERRACK, ModBlocks.NETHERRACK_FARMLAND.getDefaultState()
    ));


    public HomiItem(IItemTier itemTier, float attackSpeedIn, Item.Properties builder) {
        super(itemTier, builder);
        this.speed = attackSpeedIn;
    }

    /**
     * Called when this item is used when targetting a Block
     * this is literally just hoe code lol
     */
    public ActionResultType onItemUse(ItemUseContext context) {
        World world = context.getWorld();
        BlockPos blockpos = context.getPos();
        int hook = net.minecraftforge.event.ForgeEventFactory.onHoeUse(context);
        if (hook != 0) return hook > 0 ? ActionResultType.SUCCESS : ActionResultType.FAIL;
        if (context.getFace() != Direction.DOWN && world.getBlockState(blockpos.up()).getMaterial() == Material.WATER) {
            return this.tillPaddy(world, context, blockpos);
        }
        else if (context.getFace() != Direction.DOWN && world.getBlockState(blockpos) == Blocks.NETHERRACK.getDefaultState()) {
            return tillNetherrack(world, context, blockpos);
        }

        return ActionResultType.PASS;
    }

    private ActionResultType tillNetherrack(World world, ItemUseContext context, BlockPos blockPos) {
        BlockState blockstate = HOMI_LOOKUP.get(world.getBlockState(blockPos).getBlock());
        if (blockstate != null) {
            PlayerEntity playerentity = context.getPlayer();
            world.playSound(playerentity, blockPos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world.isRemote) {
                world.setBlockState(blockPos, blockstate, 11);
                if (playerentity != null) {
                    context.getItem().damageItem(3, playerentity, (player) -> {
                        player.sendBreakAnimation(context.getHand());
                    });
                }
            }

            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }

    private ActionResultType tillPaddy(World world, ItemUseContext context, BlockPos blockpos) {
        BlockState blockstate = HOMI_LOOKUP.get(world.getBlockState(blockpos).getBlock());
        if (blockstate != null) {
            PlayerEntity playerentity = context.getPlayer();
            world.playSound(playerentity, blockpos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (!world.isRemote) {
                world.setBlockState(blockpos, blockstate, 11);
                if (playerentity != null) {
                    context.getItem().damageItem(1, playerentity, (player) -> {
                        player.sendBreakAnimation(context.getHand());
                    });
                }
            }

            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damageItem(1, attacker, (p_220042_0_) -> {
            p_220042_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
        });
        return true;
    }
}
