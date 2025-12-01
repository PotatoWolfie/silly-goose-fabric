package potatowolfie.silly_goose.entity.goose;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.ModelTransformer;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.RotationAxis;
import potatowolfie.silly_goose.animation.GooseAnimations;

// Made with Blockbench 5.0.4

@Environment(EnvType.CLIENT)
public class GooseEntityModel extends EntityModel<GooseEntityRenderState> implements ModelWithArms {
	public static final ModelTransformer BABY_TRANSFORMER = ModelTransformer.scaling(0.7F);

	private final Animation idleAnimation;
	private final Animation idleWaterAnimation;
	private final Animation walkAnimation;
	private final Animation runAnimation;
	private final Animation swimAnimation;
	private final Animation swimFastAnimation;
	private final Animation wingsUpIdleAnimation;

	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart wing0;
	private final ModelPart wing1;
	private final ModelPart tail;
	private final ModelPart leg0;
	private final ModelPart leg1;

	public GooseEntityModel(ModelPart root) {
		super(root);
		this.body = root.getChild("body");
		this.head = this.body.getChild("head");
		this.wing0 = this.body.getChild("wing0");
		this.wing1 = this.body.getChild("wing1");
		this.tail = this.body.getChild("tail");
		this.leg0 = root.getChild("leg0");
		this.leg1 = root.getChild("leg1");

		this.idleAnimation = GooseAnimations.GOOSE_IDLE.createAnimation(root);
		this.idleWaterAnimation = GooseAnimations.GOOSE_SWIMMING_IDLE.createAnimation(root);
		this.wingsUpIdleAnimation = GooseAnimations.GOOSE_IDLE_WINGS.createAnimation(root);
		this.walkAnimation = GooseAnimations.GOOSE_WALK.createAnimation(root);
		this.runAnimation = GooseAnimations.GOOSE_RUN.createAnimation(root);
		this.swimAnimation = GooseAnimations.GOOSE_SWIM.createAnimation(root);
		this.swimFastAnimation = GooseAnimations.GOOSE_SWIM_FAST.createAnimation(root);
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData body = modelPartData.addChild("body", ModelPartBuilder.create().uv(1, 0).cuboid(-4.0F, -8.0F, -6.0F, 8.0F, 8.0F, 10.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 20.0F, 1.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(22, 18).cuboid(-2.0F, -15.5F, -3.0F, 4.0F, 16.0F, 3.0F, new Dilation(0.0F))
				.uv(36, 38).cuboid(-2.0F, -13.5F, -5.0F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -2.5F, -5.0F));

		ModelPartData wing0 = body.addChild("wing0", ModelPartBuilder.create().uv(0, 18).cuboid(0.0F, 0.0F, 0.0F, 1.0F, 8.0F, 10.0F, new Dilation(0.0F)), ModelTransform.origin(4.0F, -8.25F, -5.75F));

		ModelPartData wing1 = body.addChild("wing1", ModelPartBuilder.create().uv(0, 18).cuboid(-1.0F, 0.0F, 0.0F, 1.0F, 8.0F, 10.0F, new Dilation(0.0F)), ModelTransform.origin(-4.0F, -8.25F, -5.75F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(0, 32).cuboid(0.0F, -3.5F, -1.0F, 0.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, -4.5F, 4.5F));

		ModelPartData leg0 = modelPartData.addChild("leg0", ModelPartBuilder.create().uv(36, 31).cuboid(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.origin(2.0F, 20.0F, 1.0F));

		ModelPartData leg1 = modelPartData.addChild("leg1", ModelPartBuilder.create().uv(36, 31).cuboid(-1.5F, 0.0F, -3.0F, 3.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.origin(-2.0F, 20.0F, 1.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	public void setAngles(GooseEntityRenderState gooseEntityRenderState) {
		super.setAngles(gooseEntityRenderState);

		this.head.yaw = gooseEntityRenderState.relativeHeadYaw * 0.017453292F;
		this.head.pitch = gooseEntityRenderState.pitch * 0.017453292F;

		this.idleAnimation.apply(gooseEntityRenderState.idleAnimationState, gooseEntityRenderState.age);
		this.idleWaterAnimation.apply(gooseEntityRenderState.idleWaterAnimationState, gooseEntityRenderState.age);
		this.walkAnimation.apply(gooseEntityRenderState.walkAnimationState, gooseEntityRenderState.age);
		this.runAnimation.apply(gooseEntityRenderState.runAnimationState, gooseEntityRenderState.age);
		this.swimAnimation.apply(gooseEntityRenderState.swimAnimationState, gooseEntityRenderState.age);
		this.swimFastAnimation.apply(gooseEntityRenderState.swimFastAnimationState, gooseEntityRenderState.age);
		this.wingsUpIdleAnimation.apply(gooseEntityRenderState.wingsUpIdleAnimationState, gooseEntityRenderState.age);
	}

	public ModelPart getBody() {
		return this.body;
	}
	public ModelPart getHead() {
		return this.head;
	}
	public ModelPart getTail() {
		return this.tail;
	}
	public ModelPart getLeg0() {
		return this.leg0;
	}
	public ModelPart getLeg1() {
		return this.leg1;
	}
	public ModelPart getWing0() {
		return this.wing0;
	}
	public ModelPart getWing1() {
		return this.wing1;
	}

	@Override
	public void setArmAngle(EntityRenderState state, Arm arm, MatrixStack matrices) {
		this.body.applyTransform(matrices);
		this.head.applyTransform(matrices);
		matrices.translate(-0.09, -0.72, 0.155);
		matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(0.0F));
		matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-100.0F));
		matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(90.0F));
		matrices.scale(0.85F, 0.85F, 0.85F);
	}
}