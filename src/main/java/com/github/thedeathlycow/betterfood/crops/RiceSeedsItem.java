package com.github.thedeathlycow.betterfood.crops;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Credit to Draco18s on the forge forums for this code.
 * Source: https://www.minecraftforge.net/forum/topic/77014-crops-114/
 */
public class RiceSeedsItem extends BlockNamedItem {

    public RiceSeedsItem(Block cropBlockIn) {
        super(cropBlockIn, new Properties().group(ItemGroup.MATERIALS));
    }

    @OnlyIn(Dist.CLIENT)
    public void addInfomation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> toolTip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, toolTip, flagIn);
        toolTip.add(new TranslationTextComponent("tooltip.harderfarming:growsWetFarmland"));
    }
}
