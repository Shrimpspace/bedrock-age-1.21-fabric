package online.shrimp.mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import online.shrimp.mod.block.ModBlocks;
import online.shrimp.mod.item.ModItems;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BEDROCK_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POLISHED_BEDROCK_BLOCK);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BEDROCK_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEDROCK_NUGGET, Models.GENERATED);

    }
}
