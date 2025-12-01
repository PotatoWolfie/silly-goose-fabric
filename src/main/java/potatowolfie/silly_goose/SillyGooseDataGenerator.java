package potatowolfie.silly_goose;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import potatowolfie.silly_goose.datagen.*;
import potatowolfie.silly_goose.entity.goose.variant.GooseVariants;
import potatowolfie.silly_goose.registry.SillyGooseRegistryKeys;

public class SillyGooseDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(SillyGooseBlockTagProvider::new);
		pack.addProvider(SillyGooseItemTagProvider::new);
		pack.addProvider(SillyGooseLootTableGenerator::new);
		pack.addProvider(SillyGooseModelProvider::new);
		pack.addProvider(SillyGooseRecipeGenerator::new);
		pack.addProvider(SillyGooseRegistryDataGenerator::new);
		pack.addProvider(SillyGooseWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(SillyGooseRegistryKeys.GOOSE_VARIANT, GooseVariants::bootstrap);
	}
}