package fallout4hud.modid.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;

import fallout4hud.modid.Fallout4HUD;
import fallout4hud.modid.client.hud.HiddenIndicatorRenderer;
import fallout4hud.modid.client.command.HiddenIndicatorCommands;

import net.minecraft.resources.Identifier;


public class Fallout4HUDClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		HudElementRegistry.attachElementBefore(VanillaHudElements.CROSSHAIR, Identifier.fromNamespaceAndPath(Fallout4HUD.MOD_ID, "before_crosshair"), new HiddenIndicatorRenderer());
		HiddenIndicatorCommands.register();
	}
}