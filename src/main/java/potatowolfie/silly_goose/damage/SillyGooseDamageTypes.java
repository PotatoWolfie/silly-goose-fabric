package potatowolfie.silly_goose.damage;

import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import potatowolfie.silly_goose.SillyGoose;

public class SillyGooseDamageTypes {
    public static final RegistryKey<DamageType> GOOSE_BOTHER = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(SillyGoose.MOD_ID, "goose_bother"));
    public static final RegistryKey<DamageType> GOOSE_PECK = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(SillyGoose.MOD_ID, "goose_peck"));
    public static final RegistryKey<DamageType> GOOSE_HONK = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, Identifier.of(SillyGoose.MOD_ID, "goose_honk"));
}