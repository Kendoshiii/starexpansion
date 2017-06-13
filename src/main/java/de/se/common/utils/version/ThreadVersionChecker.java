package de.se.common.utils.version;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import net.minecraftforge.common.MinecraftForge;

/*
 * 
 * Handles any updates required using a custom JSON file hosted on a webserver
 * @author and written by Vazkii
 * 
 */

public class ThreadVersionChecker extends Thread{

	public ThreadVersionChecker() {
		setName("Star Expansion Version Checker Thread");
		setDaemon(true);
		start();
	}

	@Override
	public void run() {
		
		try {
			
			URL url = new URL("https://raw.githubusercontent.com/Kendoshiii/starexpansion/master/version/" + MinecraftForge.MC_VERSION + ".txt");
			BufferedReader r = new BufferedReader(new InputStreamReader(url.openStream()));
			VersionChecker.onlineVersion = r.readLine();
			r.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		VersionChecker.doneChecking = true;
		
	}
	
}
