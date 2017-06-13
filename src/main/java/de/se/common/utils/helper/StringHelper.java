package de.se.common.utils.helper;

import net.minecraft.util.text.translation.I18n;

/*
 * This class was created by Ellpeck and modified by Kendoshiii
 */

public class StringHelper {
	
	public static final int DECIMAL_COLOR_WHITE = 16777215;

	public static String localize(String text){
        return I18n.translateToLocal(text);
    }
	
}
