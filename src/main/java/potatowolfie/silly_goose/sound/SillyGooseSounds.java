package potatowolfie.silly_goose.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import potatowolfie.silly_goose.SillyGoose;

public class SillyGooseSounds {
    public static final SoundEvent GOOSE_HONK = registerSoundEvent("goose_honk");
    public static final SoundEvent GOOSE_ATTACK = registerSoundEvent("goose_attack");
    public static final SoundEvent GOOSE_DEATH = registerSoundEvent("goose_death");
    public static final SoundEvent GOOSE_HURT = registerSoundEvent("goose_hurt");

    private static SoundEvent registerSoundEvent(String name) {
        return Registry.register(Registries.SOUND_EVENT, Identifier.of(SillyGoose.MOD_ID, name),
                SoundEvent.of(Identifier.of(SillyGoose.MOD_ID, name)));
    }

    public static void registerSounds() {
        SillyGoose.LOGGER.info("Registering Honk Sounds for " + SillyGoose.MOD_ID);
    }
}