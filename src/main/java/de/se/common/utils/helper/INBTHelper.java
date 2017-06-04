package de.se.common.utils.helper;

import net.minecraft.nbt.NBTTagCompound;

public abstract interface INBTHelper <T>{

	public abstract T readFromNBT(NBTTagCompound paramNBTTagCompound);

	public abstract NBTTagCompound writeToNBT(NBTTagCompound paramNBTTagCompound);
}
