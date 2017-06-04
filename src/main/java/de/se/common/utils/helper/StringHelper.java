package de.se.common.utils.helper;

import net.minecraft.util.text.translation.I18n;

public class StringHelper {

	public static String localize(String text){
        return I18n.translateToLocal(text);
    }
	
}
