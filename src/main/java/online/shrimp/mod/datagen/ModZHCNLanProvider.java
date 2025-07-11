package online.shrimp.mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import online.shrimp.mod.block.ModBlocks;
import online.shrimp.mod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModZHCNLanProvider extends FabricLanguageProvider {
    public ModZHCNLanProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "zh_cn", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.BEDROCK_INGOT, "基岩锭");
        translationBuilder.add(ModItems.BEDROCK_NUGGET, "基岩粒");

        translationBuilder.add(ModBlocks.POLISHED_BEDROCK_BLOCK, "磨制基岩块");
        translationBuilder.add(ModBlocks.BEDROCK_ORE, "基岩矿");

        translationBuilder.add("itemGroup.bedrock_age_group", "基岩时代");

    }
}
