package com.hbm.render.tileentity;

import com.hbm.config.CustomMachineConfigJSON;
import com.hbm.render.util.SmallBlockPronter;
import com.hbm.tileentity.machine.TileEntityCustomMachine;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class RenderCustomMachine extends TileEntitySpecialRenderer {
    @Override
    public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float interp) {
            NBTTagCompound nbt = new NBTTagCompound();
            tile.writeToNBT(nbt);
            CustomMachineConfigJSON.MachineConfiguration config = CustomMachineConfigJSON.customMachines.get(nbt.getString("machineType"));

        ForgeDirection dir = ForgeDirection.getOrientation(tile.getBlockMetadata());
        ForgeDirection rot = dir.getRotation(ForgeDirection.UP);

        GL11.glPushMatrix();
        GL11.glTranslated(x, y, z);

        bindTexture(TextureMap.locationBlocksTexture);
        SmallBlockPronter.startDrawing();
        for(CustomMachineConfigJSON.MachineConfiguration.ComponentDefinition comp : config.components){
            int rx =  - dir.offsetX * comp.x + rot.offsetX * comp.x;
            int ry =  + comp.y;
            int rz =  - dir.offsetZ * comp.z + rot.offsetZ * comp.z;
            if(dir == ForgeDirection.EAST || dir == ForgeDirection.WEST) {
                rx =  + dir.offsetZ * comp.z - rot.offsetZ * comp.z;
                rz =  + dir.offsetX * comp.x - rot.offsetX * comp.x;
            }
            SmallBlockPronter.drawSmolBlockAt(comp.block,comp.metas.get(comp.metas.size()-1).getAsInt(),rx,ry,rz);

        }

        SmallBlockPronter.draw();

        GL11.glPopMatrix();
    }
}
