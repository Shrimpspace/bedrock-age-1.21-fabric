package online.shrimp.mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import online.shrimp.mod.BedrockAge;

public class ModItems {
    public static final Item BEDROCK_INGOT = registerItems("bedrock_ingot", new Item(new Item.Settings()));
    public static final Item BEDROCK_NUGGET = registerItems("bedrock_nugget", new Item(new Item.Settings()));

    private static Item registerItems(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BedrockAge.MOD_ID, id), item);
    }

    private static void addItemTOIG(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.add(BEDROCK_INGOT);
        fabricItemGroupEntries.add(BEDROCK_NUGGET);
    }

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemTOIG);
        //INGREDIENTS是原材料的意思
        BedrockAge.LOGGER.info("Registering Items");
    }
}