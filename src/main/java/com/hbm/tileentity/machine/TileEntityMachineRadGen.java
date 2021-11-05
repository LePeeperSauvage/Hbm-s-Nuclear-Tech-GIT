package com.hbm.tileentity.machine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.hbm.blocks.BlockDummyable;
import com.hbm.interfaces.IConsumer;
import com.hbm.interfaces.ISource;
import com.hbm.inventory.RecipesCommon.ComparableStack;
import com.hbm.items.ModItems;
import com.hbm.items.special.ItemWasteLong;
import com.hbm.items.special.ItemWasteShort;
import com.hbm.lib.Library;
import com.hbm.tileentity.TileEntityMachineBase;
import com.hbm.util.Tuple.Triplet;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityMachineRadGen extends TileEntityMachineBase implements ISource {

	public int[] progress = new int[12];
	public int[] maxProgress = new int[12];
	public int[] production = new int[12];
	public ItemStack[] processing = new ItemStack[12];
	
	public long power;
	public static final long maxPower = 1000000;
	public List<IConsumer> list = new ArrayList();
	
	public boolean isOn = false;

	public TileEntityMachineRadGen() {
		super(24);
	}

	@Override
	public String getName() {
		return "container.radGen";
	}

	@Override
	public void updateEntity() {
		
		if(!worldObj.isRemote) {
			
			if(worldObj.getTotalWorldTime() % 10 == 0) {
				ffgeuaInit();
			}
			
			//check if reload necessary for any queues
			for(int i = 0; i < 12; i++) {
				
				if(processing[i] == null && slots[i] != null && getDurationFromItem(slots[i]) > 0 &&
						(getOutputFromItem(slots[i]) == null || slots[i + 12] == null ||
						(getOutputFromItem(slots[i]).getItem() == slots[i + 12].getItem() && getOutputFromItem(slots[i]).getItemDamage() == slots[i + 12].getItemDamage() &&
						getOutputFromItem(slots[i]).stackSize + slots[i + 12].stackSize <= slots[i + 12].getMaxStackSize()))) {
					
					progress[i] = 0;
					maxProgress[i] = this.getDurationFromItem(slots[i]);
					production[i] = this.getPowerFromItem(slots[i]);
					processing[i] = new ItemStack(slots[i].getItem(), 1, slots[i].getItemDamage());
					this.decrStackSize(i, 1);
					this.markDirty();
				}
			}
			
			this.isOn = false;
			
			for(int i = 0; i < 12; i++) {
				
				if(processing[i] != null) {
					
					this.isOn = true;
					this.power += production[i];
					progress[i]++;
					
					if(progress[i] >= maxProgress[i]) {
						progress[i] = 0;
						ItemStack out = getOutputFromItem(processing[i]);
						
						if(out != null) {
							
							if(slots[i + 12] == null) {
								slots[i + 12] = out;
							} else {
								slots[i + 12].stackSize += out.stackSize;
							}
						}
						
						processing[i] = null;
						this.markDirty();
					}
				}
			}
			
			if(this.power > maxPower)
				this.power = maxPower;
			
			NBTTagCompound data = new NBTTagCompound();
			data.setIntArray("progress", this.progress);
			data.setIntArray("maxProgress", this.maxProgress);
			data.setIntArray("production", this.production);
			data.setLong("power", this.power);
			data.setBoolean("isOn", this.isOn);
			this.networkPack(data, 50);
		}
	}
	
	@Override
	public void networkUnpack(NBTTagCompound nbt) {
		this.progress = nbt.getIntArray("progress");
		this.maxProgress = nbt.getIntArray("maxProgress");
		this.production = nbt.getIntArray("production");
		this.power = nbt.getLong("power");
		this.isOn = nbt.getBoolean("isOn");
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.progress = nbt.getIntArray("progress");
		
		if(progress.length != 12) {
			progress = new int[12];
			return;
		}
		
		this.maxProgress = nbt.getIntArray("maxProgress");
		this.production = nbt.getIntArray("production");
		this.power = nbt.getLong("power");
		this.isOn = nbt.getBoolean("isOn");

		NBTTagList list = nbt.getTagList("progressing", 10);
		for(int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound nbt1 = list.getCompoundTagAt(i);
			byte b0 = nbt1.getByte("slot");
			if(b0 >= 0 && b0 < processing.length) {
				processing[b0] = ItemStack.loadItemStackFromNBT(nbt1);
			}
		}
		
		this.power = nbt.getLong("power");
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setIntArray("progress", this.progress);
		nbt.setIntArray("maxProgress", this.maxProgress);
		nbt.setIntArray("production", this.production);
		nbt.setLong("power", this.power);
		nbt.setBoolean("isOn", this.isOn);
		
		NBTTagList list = new NBTTagList();
		for(int i = 0; i < processing.length; i++) {
			if(processing[i] != null) {
				NBTTagCompound nbt1 = new NBTTagCompound();
				nbt1.setByte("slot", (byte) i);
				processing[i].writeToNBT(nbt1);
				list.appendTag(nbt1);
			}
		}
		nbt.setTag("progressing", list);
		
		nbt.setLong("power", this.power);
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack stack) {
		
		if(i >= 12 || getDurationFromItem(stack) <= 0)
			return false;
		
		if(slots[i] == null)
			return true;
		
		int size = slots[i].stackSize;
		
		for(int j = 0; j < 12; j++) {
			if(slots[j] == null)
				return false;
			
			if(slots[j].getItem() == stack.getItem() && slots[j].getItemDamage() == stack.getItemDamage() && slots[j].stackSize < size)
				return false;
		}
		
		return true;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int i) {
		return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
				12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemStack, int j) {
		return i >= 12;
	}
	
	public static final HashMap<ComparableStack, Triplet<Integer, Integer, ItemStack>> fuels = new HashMap();
	
	static {

		for(int i = 0; i < ItemWasteShort.WasteClass.values().length; i++) {
			fuels.put(	new ComparableStack(ModItems.nuclear_waste_short, 1, i),		new Triplet<Integer, Integer, ItemStack>(150,	30 * 60 * 20,		new ItemStack(ModItems.nuclear_waste_short_depleted, 1, i)));
			fuels.put(	new ComparableStack(ModItems.nuclear_waste_short_tiny, 1, i),	new Triplet<Integer, Integer, ItemStack>(15,	3 * 60 * 20,		new ItemStack(ModItems.nuclear_waste_short_depleted_tiny, 1, i)));
		}
		for(int i = 0; i < ItemWasteLong.WasteClass.values().length; i++) {
			fuels.put(	new ComparableStack(ModItems.nuclear_waste_long, 1, i),			new Triplet<Integer, Integer, ItemStack>(50,	2 * 60 * 60 * 20,	new ItemStack(ModItems.nuclear_waste_long_depleted, 1, i)));
			fuels.put(	new ComparableStack(ModItems.nuclear_waste_long_tiny, 1, i),	new Triplet<Integer, Integer, ItemStack>(5,		12 * 60 * 20,		new ItemStack(ModItems.nuclear_waste_long_depleted_tiny, 1, i)));
		}
		
		fuels.put(		new ComparableStack(ModItems.scrap_nuclear),					new Triplet<Integer, Integer, ItemStack>(5,		5 * 60 * 20,		null));
	}
	
	private Triplet<Integer, Integer, ItemStack> grabResult(ItemStack stack) {
		return fuels.get(new ComparableStack(stack).makeSingular());
	}
	
	private int getPowerFromItem(ItemStack stack) {
		Triplet<Integer, Integer, ItemStack> result = grabResult(stack);
		if(result == null)
			return 0;
		return result.getX();
	}
	
	private int getDurationFromItem(ItemStack stack) {
		Triplet<Integer, Integer, ItemStack> result = grabResult(stack);
		if(result == null)
			return 0;
		return result.getY();
	}
	
	private ItemStack getOutputFromItem(ItemStack stack) {
		Triplet<Integer, Integer, ItemStack> result = grabResult(stack);
		if(result == null)
			return null;
		return result.getZ();
	}

	@Override
	public void ffgeuaInit() {
		ForgeDirection dir = ForgeDirection.getOrientation(this.getBlockMetadata() - BlockDummyable.offset);
		ffgeua(this.xCoord - dir.offsetX * 4, this.yCoord, this.zCoord - dir.offsetZ * 4, getTact());
	}

	@Override
	public void ffgeua(int x, int y, int z, boolean newTact) {
		Library.ffgeua(x, y, z, newTact, this, worldObj);
	}

	@Override
	public boolean getTact() {
		return worldObj.getTotalWorldTime() % 20 < 10;
	}

	@Override
	public long getSPower() {
		return power;
	}

	@Override
	public void setSPower(long i) {
		this.power = i;
	}

	@Override
	public List<IConsumer> getList() {
		return list;
	}

	@Override
	public void clearList() {
		this.list.clear();
	}
	
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return TileEntity.INFINITE_EXTENT_AABB;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared() {
		return 65536.0D;
	}
}
