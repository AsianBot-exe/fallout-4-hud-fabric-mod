package fallout4hud.modid.client.hud;

public class HiddenIndicatorState {
    public static String text = "HIDDEN"; // Word to display on the HUD. Words include: "HIDDEN", "CAUTION", "DANGER", "DETECTED"
    public static int color = 0xFF00FF00; // Color of the text in ARGB format. Green when hidden and detected, red when in caution or danger.
    public static float confidence = 0.0f; // Confidence level of the player's stealth status, ranging from 0.0 (completely hidden) to 1.0 (fully detected).
    public static boolean danger = false; // Indicates whether or not the player is detected by a hostile mob.
}
