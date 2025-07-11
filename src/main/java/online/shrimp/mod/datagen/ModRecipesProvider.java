package online.shrimp.mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import online.shrimp.mod.BedrockAge;
import online.shrimp.mod.block.ModBlocks;
import online.shrimp.mod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class ModRecipesProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> BEDROCK_INGOT = List.of(ModBlocks.BEDROCK_ORE);
    public ModRecipesProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.BEDROCK_INGOT,
                RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_BEDROCK_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.BEDROCK_INGOT,
                RecipeCategory.MISC, ModItems.BEDROCK_NUGGET);
        offerBlasting(exporter, BEDROCK_INGOT, RecipeCategory.MISC, ModBlocks.BEDROCK_ORE,
                10.0f, 200, "bedrock");
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.SUGAR,3)
                .pattern("###")
                .input('#', Ingredient.ofItems(Items.BEETROOT))
                .criterion("has_beetroot", RecipeProvider.conditionsFromItem(Items.BEETROOT))
                .offerTo(exporter, Identifier.of(BedrockAge.MOD_ID, "beetroot_to_sugar"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BEDROCK_ORE)
                .input(ModItems.BEDROCK_NUGGET)
                .input(Items.DEEPSLATE)
                .criterion("has_item", RecipeProvider.conditionsFromItem(ModItems.BEDROCK_NUGGET))
                .criterion("has_item", RecipeProvider.conditionsFromItem(Items.DEEPSLATE))
                .offerTo(exporter, Identifier.of(BedrockAge.MOD_ID, "bedrock_ore"));


    }
}
