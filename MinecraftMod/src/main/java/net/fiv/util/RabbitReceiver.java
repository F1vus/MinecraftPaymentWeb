package net.fiv.util;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.joml.Matrix4f;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RabbitReceiver {

    private final static String QUEUE_NAME = "SecondGiftPermsQueue";

    public static void receive(MinecraftServer server) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            World world = server.getWorld(World.OVERWORLD);
            ServerPlayerEntity player =  server.getPlayerManager().getPlayer("Drago347890");
            if(message.equalsIgnoreCase("lightning")) {
                LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world); // Create the lightning bolt
                lightning.setPosition(player.getPos()); // Set its position. This will make the lightning bolt strike the player (probably not what you want)
                world.spawnEntity(lightning); // Spawn the lightning entity
            }

            server.getPlayerManager().broadcast(Text.literal(message).formatted(Formatting.RED), false);
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });
    }

}
