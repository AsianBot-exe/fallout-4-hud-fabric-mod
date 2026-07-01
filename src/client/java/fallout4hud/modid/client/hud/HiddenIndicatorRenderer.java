package fallout4hud.modid.client.hud;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElement;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.Minecraft;

public class HiddenIndicatorRenderer implements HudElement {  
    int bracketGap = 0;
    private float bracketDisplayedGap = 10;
    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, DeltaTracker deltaTracker) {
        Minecraft minecraft = Minecraft.getInstance();
        
        long gameTime = minecraft.level.getGameTime(); // Get the current game time in ticks

        String drawString = HiddenIndicatorState.text; // Word to display on the HUD. Words include: "HIDDEN", "CAUTION", "DANGER", "DETECTED"

        int windowWidth = minecraft.getWindow().getGuiScaledWidth();
        int windowHeight = minecraft.getWindow().getGuiScaledHeight();
        int centerX = windowWidth / 2;
        // int centerY = windowHeight / 2;
        int textWidth = minecraft.font.width(drawString);

        // Center word
        graphics.text(minecraft.font, drawString, centerX - textWidth / 2, windowHeight / 4, HiddenIndicatorState.color, false);
        
        // Left bracket
        graphics.text(minecraft.font, "[", centerX - textWidth / 2 - Math.round((1 - HiddenIndicatorState.confidence) * 60f + minecraft.font.width(" ")), windowHeight / 4, HiddenIndicatorState.color, false);
        
        // Right bracket
        graphics.text(minecraft.font, "]", centerX + textWidth / 2 + Math.round((1 - HiddenIndicatorState.confidence) * 60f), windowHeight / 4, 0xFF00FF00, false);
    }
}
