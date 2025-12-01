package potatowolfie.silly_goose.animation;

import net.minecraft.client.render.entity.animation.AnimationDefinition;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

/**
 * Made with Blockbench 5.0.4
 * Exported for Minecraft version 1.19 or later with Yarn mappings
 * @author Demidiant + PotatoWolfie
 */
public class GooseAnimations {
	public static final AnimationDefinition GOOSE_IDLE = AnimationDefinition.Builder.create(2.0F).looping()
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(-1.25F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -0.625F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -0.625F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.625F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.625F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leg0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leg1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.build();

	public static final AnimationDefinition GOOSE_IDLE_WINGS = AnimationDefinition.Builder.create(2.0F).looping()
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(-1.25F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(2.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -95.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -105.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -85.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -95.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -105.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -85.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -95.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing0", new Transformation(Transformation.Targets.MOVE_ORIGIN,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("wing1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 95.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 105.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 85.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 95.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 105.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 85.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 95.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing1", new Transformation(Transformation.Targets.MOVE_ORIGIN,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leg0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leg1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.build();

	public static final AnimationDefinition GOOSE_WALK = AnimationDefinition.Builder.create(1.0F).looping()
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -0.625F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.625F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -2.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 2.5F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leg0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(5.5758F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.3333F, AnimationHelper.createRotationalVector(-22.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.625F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createRotationalVector(22.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(5.5758F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leg0", new Transformation(Transformation.Targets.MOVE_ORIGIN,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.625F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.875F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leg1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.3333F, AnimationHelper.createRotationalVector(22.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(-22.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leg1", new Transformation(Transformation.Targets.MOVE_ORIGIN,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.build();

	public static final AnimationDefinition GOOSE_RUN = AnimationDefinition.Builder.create(0.5F).looping()
		.addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.125F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, -1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(-12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.125F, AnimationHelper.createRotationalVector(12.5F, 0.0F, -0.625F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.625F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(12.5F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -95.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -105.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -85.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -95.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing0", new Transformation(Transformation.Targets.MOVE_ORIGIN,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("wing1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 95.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 105.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 85.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 95.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing1", new Transformation(Transformation.Targets.MOVE_ORIGIN,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leg0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(5.5758F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(-22.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.3333F, AnimationHelper.createRotationalVector(0.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.4583F, AnimationHelper.createRotationalVector(22.5F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(5.5758F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leg0", new Transformation(Transformation.Targets.MOVE_ORIGIN,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.4583F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leg1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.1667F, AnimationHelper.createRotationalVector(22.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(-22.5F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leg1", new Transformation(Transformation.Targets.MOVE_ORIGIN,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.1667F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.build();

	public static final AnimationDefinition GOOSE_SWIM = AnimationDefinition.Builder.create(3.0F).looping()
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(1.25F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(1.25F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -0.625F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -0.625F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -0.625F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.625F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.625F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.625F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leg0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(37.9088F, 4.1161F, 3.5888F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(50.0F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(24.6212F, 10.9936F, -13.094F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(21.6978F, 1.0904F, -5.6853F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(37.9088F, 4.1161F, 3.5888F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(50.0F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(24.6212F, 10.9936F, -13.094F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.625F, AnimationHelper.createRotationalVector(21.6978F, 1.0904F, -5.6853F), Transformation.Interpolations.CUBIC),
			new Keyframe(3.0F, AnimationHelper.createRotationalVector(37.9088F, 4.1161F, 3.5888F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leg0", new Transformation(Transformation.Targets.MOVE_ORIGIN,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.28F, -0.97F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.25F, -1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.28F, -0.97F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, 0.25F, -1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.625F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.28F, -0.97F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leg1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(24.6212F, -10.9936F, 13.094F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(21.6978F, -1.0904F, 5.6853F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(37.9088F, -4.1161F, -3.5888F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(50.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(24.6212F, -10.9936F, 13.094F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(21.6978F, -1.0904F, 5.6853F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(37.9088F, -4.1161F, -3.5888F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.625F, AnimationHelper.createRotationalVector(50.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(3.0F, AnimationHelper.createRotationalVector(24.6212F, -10.9936F, 13.094F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leg1", new Transformation(Transformation.Targets.MOVE_ORIGIN,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.25F, -1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.28F, -0.97F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.25F, -1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createTranslationalVector(0.0F, 0.28F, -0.97F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.625F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(3.0F, AnimationHelper.createTranslationalVector(0.0F, 0.25F, -1.25F), Transformation.Interpolations.CUBIC)
		))
		.build();

	public static final AnimationDefinition GOOSE_SWIMMING_IDLE = AnimationDefinition.Builder.create(3.0F).looping()
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(1.25F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(1.25F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -0.625F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -0.625F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -0.625F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.625F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.375F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.125F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.625F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.875F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.625F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(3.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.625F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leg0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(50.5054F, 6.0445F, 0.9689F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(47.8004F, 7.8996F, -0.7195F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(50.5054F, 6.0445F, 0.9689F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(47.8004F, 7.8996F, -0.7195F), Transformation.Interpolations.CUBIC),
			new Keyframe(3.0F, AnimationHelper.createRotationalVector(50.5054F, 6.0445F, 0.9689F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leg0", new Transformation(Transformation.Targets.MOVE_ORIGIN,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leg1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(47.8004F, -7.8996F, 0.7195F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(50.5054F, -6.0445F, -0.9689F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(47.8004F, -7.8996F, 0.7195F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.25F, AnimationHelper.createRotationalVector(50.5054F, -6.0445F, -0.9689F), Transformation.Interpolations.CUBIC),
			new Keyframe(3.0F, AnimationHelper.createRotationalVector(47.8004F, -7.8996F, 0.7195F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leg1", new Transformation(Transformation.Targets.MOVE_ORIGIN,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC)
		))
		.build();

	public static final AnimationDefinition GOOSE_SWIM_FAST = AnimationDefinition.Builder.create(2.0F).looping()
		.addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(1.25F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(1.25F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -95.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -105.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -85.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -95.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -105.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -85.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -95.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing0", new Transformation(Transformation.Targets.MOVE_ORIGIN,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("wing1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 95.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 105.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 85.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 95.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 105.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 85.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 95.0F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("wing1", new Transformation(Transformation.Targets.MOVE_ORIGIN,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, -0.5F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(10.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR)
		))
		.addBoneAnimation("leg0", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(37.9088F, 4.1161F, 3.5888F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(50.0F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(24.6212F, 10.9936F, -13.094F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(21.6978F, 1.0904F, -5.6853F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(37.9088F, 4.1161F, 3.5888F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(50.0F, 15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(24.6212F, 10.9936F, -13.094F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(21.6978F, 1.0904F, -5.6853F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(37.9088F, 4.1161F, 3.5888F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leg0", new Transformation(Transformation.Targets.MOVE_ORIGIN,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.28F, -0.97F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.25F, -1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.28F, -0.97F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.25F, -1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.28F, -0.97F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leg1", new Transformation(Transformation.Targets.ROTATE, 
			new Keyframe(0.0F, AnimationHelper.createRotationalVector(24.6212F, -10.9936F, 13.094F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createRotationalVector(21.6978F, -1.0904F, 5.6853F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createRotationalVector(37.9088F, -4.1161F, -3.5888F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createRotationalVector(50.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createRotationalVector(24.6212F, -10.9936F, 13.094F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createRotationalVector(21.6978F, -1.0904F, 5.6853F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createRotationalVector(37.9088F, -4.1161F, -3.5888F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createRotationalVector(50.0F, -15.0F, 0.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createRotationalVector(24.6212F, -10.9936F, 13.094F), Transformation.Interpolations.CUBIC)
		))
		.addBoneAnimation("leg1", new Transformation(Transformation.Targets.MOVE_ORIGIN,
			new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.25F, -1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.28F, -0.97F), Transformation.Interpolations.CUBIC),
			new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.25F, -1.25F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.25F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.28F, -0.97F), Transformation.Interpolations.CUBIC),
			new Keyframe(1.75F, AnimationHelper.createTranslationalVector(0.0F, 0.5F, -1.0F), Transformation.Interpolations.CUBIC),
			new Keyframe(2.0F, AnimationHelper.createTranslationalVector(0.0F, 0.25F, -1.25F), Transformation.Interpolations.CUBIC)
		))
		.build();
}