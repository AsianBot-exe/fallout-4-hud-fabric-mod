package fallout4hud.modid.client.command;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.ClientCommands;
import net.minecraft.network.chat.Component;

import fallout4hud.modid.client.hud.HiddenIndicatorState;

import com.mojang.brigadier.arguments.FloatArgumentType;

public class HiddenIndicatorCommands {
    public static void register() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(ClientCommands.literal("changeConf").then(ClientCommands.argument("value", FloatArgumentType.floatArg(0.0f, 1.0f)).executes(context -> {
                HiddenIndicatorState.confidence = FloatArgumentType.getFloat(context, "value");
                context.getSource().sendFeedback(Component.literal("Confidence level changed to " + HiddenIndicatorState.confidence));
                return 1;
            })));
        });
    }
}
