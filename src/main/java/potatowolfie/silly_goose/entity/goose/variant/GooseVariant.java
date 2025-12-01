package potatowolfie.silly_goose.entity.goose.variant;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.VariantSelectorProvider;
import net.minecraft.entity.spawn.SpawnCondition;
import net.minecraft.entity.spawn.SpawnConditionSelectors;
import net.minecraft.entity.spawn.SpawnContext;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryFixedCodec;
import net.minecraft.util.ModelAndTexture;
import net.minecraft.util.StringIdentifiable;
import potatowolfie.silly_goose.registry.SillyGooseRegistryKeys;

import java.util.List;

public record GooseVariant(ModelAndTexture<Model> modelAndTexture, SpawnConditionSelectors spawnConditions) implements VariantSelectorProvider<SpawnContext, SpawnCondition> {
    public static final Codec<GooseVariant> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(ModelAndTexture.createMapCodec(GooseVariant.Model.CODEC, GooseVariant.Model.NORMAL).forGetter(GooseVariant::modelAndTexture), SpawnConditionSelectors.CODEC.fieldOf("spawn_conditions").forGetter(GooseVariant::spawnConditions)).apply(instance, GooseVariant::new);
    });
    public static final Codec<GooseVariant> NETWORK_CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(ModelAndTexture.createMapCodec(GooseVariant.Model.CODEC, GooseVariant.Model.NORMAL).forGetter(GooseVariant::modelAndTexture)).apply(instance, GooseVariant::new);
    });
    public static final Codec<RegistryEntry<GooseVariant>> ENTRY_CODEC;
    public static final PacketCodec<RegistryByteBuf, RegistryEntry<GooseVariant>> ENTRY_PACKET_CODEC;

    private GooseVariant(ModelAndTexture<Model> modelAndTexture) {
        this(modelAndTexture, SpawnConditionSelectors.EMPTY);
    }

    public GooseVariant(ModelAndTexture<Model> modelAndTexture, SpawnConditionSelectors spawnConditions) {
        this.modelAndTexture = modelAndTexture;
        this.spawnConditions = spawnConditions;
    }

    public List<VariantSelectorProvider.Selector<SpawnContext, SpawnCondition>> getSelectors() {
        return this.spawnConditions.selectors();
    }

    public ModelAndTexture<Model> modelAndTexture() {
        return this.modelAndTexture;
    }

    public SpawnConditionSelectors spawnConditions() {
        return this.spawnConditions;
    }

    static {
        ENTRY_CODEC = RegistryFixedCodec.of(SillyGooseRegistryKeys.GOOSE_VARIANT);
        ENTRY_PACKET_CODEC = PacketCodecs.registryEntry(SillyGooseRegistryKeys.GOOSE_VARIANT);
    }

    public static enum Model implements StringIdentifiable {
        NORMAL("normal"),
        COLD("cold"),
        WARM("warm");

        public static final Codec<Model> CODEC = StringIdentifiable.createCodec(Model::values);
        private final String id;

        private Model(final String id) {
            this.id = id;
        }

        public String asString() {
            return this.id;
        }
    }
}
