package potatowolfie.silly_goose.entity.goose.goals;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import potatowolfie.silly_goose.entity.goose.GooseEntity;

import java.util.EnumSet;
import java.util.List;

public class GooseStealFromVillagerGoal extends Goal {
    private final GooseEntity goose;
    private VillagerEntity targetVillager;
    private int stealDelay = 0;

    public GooseStealFromVillagerGoal(GooseEntity goose) {
        this.goose = goose;
        this.setControls(EnumSet.of(Control.MOVE, Control.LOOK));
    }

    @Override
    public boolean canStart() {
        if (!goose.canPickUpLoot() || !goose.getMainHandStack().isEmpty() || goose.isBaby()) {
            return false;
        }

        // Find nearby villagers
        List<VillagerEntity> list = goose.getEntityWorld().getEntitiesByClass(
            VillagerEntity.class, 
            goose.getBoundingBox().expand(8.0, 4.0, 8.0), 
            villager -> !villager.getInventory().isEmpty()
        );

        if (!list.isEmpty()) {
            this.targetVillager = list.get(goose.getRandom().nextInt(list.size()));
            return true;
        }
        return false;
    }

    @Override
    public boolean shouldContinue() {
        return targetVillager != null && targetVillager.isAlive() && goose.getMainHandStack().isEmpty();
    }

    @Override
    public void start() {
        this.stealDelay = 0;
    }

    @Override
    public void tick() {
        goose.getLookControl().lookAt(targetVillager, 30.0F, 30.0F);
        
        if (goose.squaredDistanceTo(targetVillager) < 1.5) {
            if (++stealDelay >= 5) {
                stealItem();
            }
        } else {
            goose.getNavigation().startMovingTo(targetVillager, 1.2);
            stealDelay = 0;
        }
    }

    private void stealItem() {
        var inventory = targetVillager.getInventory();
        for (int i = 0; i < inventory.size(); i++) {
            ItemStack stack = inventory.getStack(i);
            // Define "Valuable": Emeralds, food, or specific modded items
            if (!stack.isEmpty() && (stack.isOf(Items.EMERALD) || stack.isOf(Items.WHEAT))) {
                ItemStack stolenStack = stack.split(1);
                goose.equipStack(EquipmentSlot.MAINHAND, stolenStack);
                goose.setEquipmentDropChance(EquipmentSlot.MAINHAND, 2.0F);
                
                goose.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 1.0F, 1.0F);
                targetVillager.playSound(SoundEvents.ENTITY_VILLAGER_NO, 1.0F, 1.0F);
                
                // Set goose into "Hit and Run" mode to escape with the loot
                goose.setInHitAndRunMode(true);
                this.targetVillager = null;
                break;
            }
        }
    }
}
