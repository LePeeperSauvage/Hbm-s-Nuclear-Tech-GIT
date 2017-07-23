// Date: 14.08.2016 18:55:34
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package com.hbm.render.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelZOMG extends ModelBase {
	// fields
	ModelRenderer Body;
	ModelRenderer BodyFront;
	ModelRenderer BodyFrontPlate;
	ModelRenderer PipeLeft;
	ModelRenderer PipeRight;
	ModelRenderer PipeBottom;
	ModelRenderer Head;
	ModelRenderer HeadBottom;
	ModelRenderer HeadBottomPlate;
	ModelRenderer BodyTop;
	ModelRenderer BodyCenter;
	ModelRenderer BodyBack;
	ModelRenderer BodyBackPlate;
	ModelRenderer StockTop;
	ModelRenderer StockBack;
	ModelRenderer StockBackPlate;
	ModelRenderer Handle;
	ModelRenderer PistonBack;
	ModelRenderer PistonFront;
	ModelRenderer BarrelVertical;
	ModelRenderer BarrelHorizontal;
	ModelRenderer BarrelCenter;
	ModelRenderer HandleBack;
	ModelRenderer BarrelPipe;
	ModelRenderer PistonPivot;
	ModelRenderer Scope;
	ModelRenderer ScopePivot;

	public ModelZOMG() {
		textureWidth = 128;
		textureHeight = 64;

		Body = new ModelRenderer(this, 0, 0);
		Body.addBox(0F, 0F, 0F, 12, 5, 4);
		Body.setRotationPoint(-6F, 0F, 0F);
		Body.setTextureSize(128, 64);
		Body.mirror = true;
		setRotation(Body, 0F, 0F, 0F);
		BodyFront = new ModelRenderer(this, 32, 14);
		BodyFront.addBox(0F, 0F, 0F, 1, 4, 4);
		BodyFront.setRotationPoint(-7F, 0F, 0F);
		BodyFront.setTextureSize(128, 64);
		BodyFront.mirror = true;
		setRotation(BodyFront, 0F, 0F, 0F);
		BodyFrontPlate = new ModelRenderer(this, 46, 6);
		BodyFrontPlate.addBox(-2F, -1F, 0F, 2, 1, 4);
		BodyFrontPlate.setRotationPoint(-6F, 5F, 0F);
		BodyFrontPlate.setTextureSize(128, 64);
		BodyFrontPlate.mirror = true;
		setRotation(BodyFrontPlate, 0F, 0F, 0.6981317F);
		PipeLeft = new ModelRenderer(this, 0, 29);
		PipeLeft.addBox(0F, 0F, 0F, 6, 1, 1);
		PipeLeft.setRotationPoint(-13F, 0.5F, 0.5F);
		PipeLeft.setTextureSize(128, 64);
		PipeLeft.mirror = true;
		setRotation(PipeLeft, 0F, 0F, 0F);
		PipeRight = new ModelRenderer(this, 14, 29);
		PipeRight.addBox(0F, 0F, 0F, 6, 1, 1);
		PipeRight.setRotationPoint(-13F, 0.5F, 2.5F);
		PipeRight.setTextureSize(128, 64);
		PipeRight.mirror = true;
		setRotation(PipeRight, 0F, 0F, 0F);
		PipeBottom = new ModelRenderer(this, 14, 25);
		PipeBottom.addBox(0F, 0F, 0F, 6, 2, 2);
		PipeBottom.setRotationPoint(-13F, 2F, 1F);
		PipeBottom.setTextureSize(128, 64);
		PipeBottom.mirror = true;
		setRotation(PipeBottom, 0F, 0F, 0F);
		Head = new ModelRenderer(this, 32, 0);
		Head.addBox(0F, 0F, 0F, 3, 4, 4);
		Head.setRotationPoint(-16F, 0F, 0F);
		Head.setTextureSize(128, 64);
		Head.mirror = true;
		setRotation(Head, 0F, 0F, 0F);
		HeadBottom = new ModelRenderer(this, 46, 0);
		HeadBottom.addBox(0F, 0F, 0F, 2, 2, 4);
		HeadBottom.setRotationPoint(-15F, 4F, 0F);
		HeadBottom.setTextureSize(128, 64);
		HeadBottom.mirror = true;
		setRotation(HeadBottom, 0F, 0F, 0F);
		HeadBottomPlate = new ModelRenderer(this, 32, 8);
		HeadBottomPlate.addBox(0F, 0F, 0F, 1, 2, 4);
		HeadBottomPlate.setRotationPoint(-16F, 4F, 0F);
		HeadBottomPlate.setTextureSize(128, 64);
		HeadBottomPlate.mirror = true;
		setRotation(HeadBottomPlate, 0F, 0F, -0.4363323F);
		BodyTop = new ModelRenderer(this, 0, 17);
		BodyTop.addBox(0F, 0F, 0F, 10, 1, 3);
		BodyTop.setRotationPoint(-5F, -0.5F, 0.5F);
		BodyTop.setTextureSize(128, 64);
		BodyTop.mirror = true;
		setRotation(BodyTop, 0F, 0F, 0F);
		BodyCenter = new ModelRenderer(this, 0, 9);
		BodyCenter.addBox(0F, 0F, 0F, 11, 3, 5);
		BodyCenter.setRotationPoint(-5.5F, 1F, -0.5F);
		BodyCenter.setTextureSize(128, 64);
		BodyCenter.mirror = true;
		setRotation(BodyCenter, 0F, 0F, 0F);
		BodyBack = new ModelRenderer(this, 42, 11);
		BodyBack.addBox(0F, 0F, 0F, 1, 3, 4);
		BodyBack.setRotationPoint(6F, 2F, 0F);
		BodyBack.setTextureSize(128, 64);
		BodyBack.mirror = true;
		setRotation(BodyBack, 0F, 0F, 0F);
		BodyBackPlate = new ModelRenderer(this, 58, 0);
		BodyBackPlate.addBox(-1F, -3F, 0F, 1, 4, 2);
		BodyBackPlate.setRotationPoint(7F, 2F, 1F);
		BodyBackPlate.setTextureSize(128, 64);
		BodyBackPlate.mirror = true;
		setRotation(BodyBackPlate, 0F, 0F, -0.4363323F);
		StockTop = new ModelRenderer(this, 0, 21);
		StockTop.addBox(0F, 0F, 0F, 8, 2, 2);
		StockTop.setRotationPoint(7F, 3F, 1F);
		StockTop.setTextureSize(128, 64);
		StockTop.mirror = true;
		setRotation(StockTop, 0F, 0F, 0F);
		StockBack = new ModelRenderer(this, 20, 21);
		StockBack.addBox(0F, 0F, 0F, 4, 2, 2);
		StockBack.setRotationPoint(11F, 5F, 1F);
		StockBack.setTextureSize(128, 64);
		StockBack.mirror = true;
		setRotation(StockBack, 0F, 0F, 0F);
		StockBackPlate = new ModelRenderer(this, 0, 25);
		StockBackPlate.addBox(-5F, -2F, 0F, 5, 2, 2);
		StockBackPlate.setRotationPoint(11F, 7F, 1F);
		StockBackPlate.setTextureSize(128, 64);
		StockBackPlate.mirror = true;
		setRotation(StockBackPlate, 0F, 0F, 0.418879F);
		Handle = new ModelRenderer(this, 64, 8);
		Handle.addBox(0F, 0F, 0F, 2, 4, 2);
		Handle.setRotationPoint(-4F, 5F, 1F);
		Handle.setTextureSize(128, 64);
		Handle.mirror = true;
		setRotation(Handle, 0F, 0F, 0F);
		PistonBack = new ModelRenderer(this, 30, 26);
		PistonBack.addBox(0F, -4F, 0F, 2, 4, 2);
		PistonBack.setRotationPoint(1F, 4F, -0.5F);
		PistonBack.setTextureSize(128, 64);
		PistonBack.mirror = true;
		setRotation(PistonBack, 0.7853982F, 0F, 0F);
		PistonFront = new ModelRenderer(this, 52, 11);
		PistonFront.addBox(0F, -4F, 0F, 2, 4, 2);
		PistonFront.setRotationPoint(-3F, 4F, -0.5F);
		PistonFront.setTextureSize(128, 64);
		PistonFront.mirror = true;
		setRotation(PistonFront, 0.7853982F, 0F, 0F);
		BarrelVertical = new ModelRenderer(this, 38, 22);
		BarrelVertical.addBox(0F, 0F, 0F, 8, 3, 2);
		BarrelVertical.setRotationPoint(-4F, 1F, 5F);
		BarrelVertical.setTextureSize(128, 64);
		BarrelVertical.mirror = true;
		setRotation(BarrelVertical, 0F, 0F, 0F);
		BarrelHorizontal = new ModelRenderer(this, 38, 27);
		BarrelHorizontal.addBox(0F, 0F, 0F, 8, 2, 3);
		BarrelHorizontal.setRotationPoint(-4F, 1.5F, 4.5F);
		BarrelHorizontal.setTextureSize(128, 64);
		BarrelHorizontal.mirror = true;
		setRotation(BarrelHorizontal, 0F, 0F, 0F);
		BarrelCenter = new ModelRenderer(this, 64, 0);
		BarrelCenter.addBox(0F, 0F, 0F, 10, 2, 2);
		BarrelCenter.setRotationPoint(-5F, 1.5F, 5F);
		BarrelCenter.setTextureSize(128, 64);
		BarrelCenter.mirror = true;
		setRotation(BarrelCenter, 0F, 0F, 0F);
		HandleBack = new ModelRenderer(this, 60, 8);
		HandleBack.addBox(0F, 0F, 0F, 1, 4, 1);
		HandleBack.setRotationPoint(-2.5F, 5F, 1.5F);
		HandleBack.setTextureSize(128, 64);
		HandleBack.mirror = true;
		setRotation(HandleBack, 0F, 0F, 0F);
		BarrelPipe = new ModelRenderer(this, 64, 4);
		BarrelPipe.addBox(-10F, 0F, -1F, 10, 1, 1);
		BarrelPipe.setRotationPoint(-5F, 2F, 6.5F);
		BarrelPipe.setTextureSize(128, 64);
		BarrelPipe.mirror = true;
		setRotation(BarrelPipe, 0F, -0.2602503F, 0F);
		PistonPivot = new ModelRenderer(this, 60, 14);
		PistonPivot.addBox(0F, -2F, 0.5F, 7, 2, 1);
		PistonPivot.setRotationPoint(-3.5F, 4F, -0.5F);
		PistonPivot.setTextureSize(128, 64);
		PistonPivot.mirror = true;
		setRotation(PistonPivot, 0.7853982F, 0F, 0F);
		Scope = new ModelRenderer(this, 48, 18);
		Scope.addBox(0F, 0F, 0F, 6, 2, 2);
		Scope.setRotationPoint(-3F, -3F, 1F);
		Scope.setTextureSize(128, 64);
		Scope.mirror = true;
		setRotation(Scope, 0F, 0F, 0F);
		ScopePivot = new ModelRenderer(this, 58, 6);
		ScopePivot.addBox(0F, 0F, 0F, 4, 1, 1);
		ScopePivot.setRotationPoint(-2F, -1F, 1.5F);
		ScopePivot.setTextureSize(128, 64);
		ScopePivot.mirror = true;
		setRotation(ScopePivot, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Body.render(f5);
		BodyFront.render(f5);
		BodyFrontPlate.render(f5);
		PipeLeft.render(f5);
		PipeRight.render(f5);
		PipeBottom.render(f5);
		Head.render(f5);
		HeadBottom.render(f5);
		HeadBottomPlate.render(f5);
		BodyTop.render(f5);
		BodyCenter.render(f5);
		BodyBack.render(f5);
		BodyBackPlate.render(f5);
		StockTop.render(f5);
		StockBack.render(f5);
		StockBackPlate.render(f5);
		Handle.render(f5);
		PistonBack.render(f5);
		PistonFront.render(f5);
		BarrelVertical.render(f5);
		BarrelHorizontal.render(f5);
		BarrelCenter.render(f5);
		HandleBack.render(f5);
		BarrelPipe.render(f5);
		PistonPivot.render(f5);
		Scope.render(f5);
		ScopePivot.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
