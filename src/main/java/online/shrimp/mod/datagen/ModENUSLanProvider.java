package online.shrimp.mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import online.shrimp.mod.block.ModBlocks;
import online.shrimp.mod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModENUSLanProvider extends FabricLanguageProvider {
    public ModENUSLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.BEDROCK_INGOT, "Bedrock Ingot");
        translationBuilder.add(ModItems.BEDROCK_NUGGET, "Bedrock Nugget");

        translationBuilder.add(ModBlocks.POLISHED_BEDROCK_BLOCK, "Polished Bedrock Block");
        translationBuilder.add(ModBlocks.BEDROCK_ORE, "Bedrock Ore");

        translationBuilder.add("itemGroup.bedrock_age_group", "Bedrock Age");
    }
}
