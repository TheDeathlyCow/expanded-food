package com.github.thedeathlycow.betterfood.modifiers;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.util.List;

public class BirchLeavesConverterModifier extends LootModifier {

    private final Item reward;
//    private final ILootCondition[] conditions;

    /**
     * Constructs a LootModifier.
     *
     * @param conditionsIn the ILootConditions that need to be matched before the loot is modified.
     * @param reward The item the player gets when the loot condition is met.
     */
    protected BirchLeavesConverterModifier(ILootCondition[] conditionsIn, Item reward) {
        super(conditionsIn);
        this.reward = reward;
    }

    /**
     * This method is called when all the conditions for dropping are met. It will add whatever
     * the specified reward item is. By default, it will add a green apple to birch leaves' drop 5%
     * of the time.
     */
    @Nonnull
    @Override
    protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
        generatedLoot.add(new ItemStack(this.reward, 1));
        return generatedLoot;
    }

    public static class Serializer extends GlobalLootModifierSerializer<BirchLeavesConverterModifier> {

        @Override
        public BirchLeavesConverterModifier read(ResourceLocation name, JsonObject object, ILootCondition[] conditionsIn) {
            Item greenApple = ForgeRegistries.ITEMS.getValue(new ResourceLocation(JSONUtils.getString(object, "item")));
            return new BirchLeavesConverterModifier(conditionsIn, greenApple);
        }
    }
}
