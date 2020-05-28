package test.spigotdsl;

import com.ericlam.mc.spigotdsl.SpigotDSL;
import com.ericlam.mc.spigotdsl.api.DSLBuilder;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

public class Usage {
    public static void initPlugin(JavaPlugin plugin) {
        DSLBuilder builder = SpigotDSL.adapt(plugin);

        builder.createCommands(cmd -> {

            cmd.create("hi", "say hi to server", (sender, args) -> sender.sendMessage("hello !"));

            cmd.command("bitch").description("say bitch to server").permission("bitch.use").executor((sender, args) -> {
                sender.sendMessage("what's up you bitch too");
            });

            cmd.command("fuck").description("fuck somebody").args("who").executor((sender, args) -> {
                sender.sendMessage("you fucked " + args.get(0));
            });

            cmd.command("test").description("test command").permission("test.use").child(test -> {
                test.command("ping").description("test ping").executor((sender, args) -> {
                    sender.sendMessage("your ping is 999999ms");
                });

                test.command("player").description("test player").args("who").executor((sender, args) -> {
                    Player player = Bukkit.getPlayer(args.get(0));
                    sender.sendMessage("target online: " + player.isOnline());
                });

                test.command("server").description("test server").child(ser -> {
                    ser.command("lag").description("test server is lag").executor((sender, args) -> {
                        sender.sendMessage("server not lag ok ???");
                    });

                    ser.command("good").description("test server is good").executor((sender, args) -> {
                        sender.sendMessage("omg this server is so good why so good i don't know but it just goooooood!");
                    });
                });
            });
        });

        Map<String, FileConfiguration> configMap = builder.createFile(yaml -> {
            yaml.create("config.yml");
            yaml.folder("/MY_CUSTOM_FOLDER/").create("test.yml");
            yaml.prefix("prefix").create("messages.yml");
        });

        builder.listenEvents(listener -> {
            listener.listen(PlayerJoinEvent.class, e -> {
                if (e.getPlayer().hasPlayedBefore()){
                    e.setJoinMessage("Welcome Back, "+e.getPlayer().getDisplayName());
                }else{
                    e.setJoinMessage("Welcome " + e.getPlayer().getDisplayName() + " join our server!");
                }
            });

            listener.event(PlayerQuitEvent.class).priority(EventPriority.HIGH).ignoreCancelled(true).listen(e->{
                e.setQuitMessage("Good Bye, " + e.getPlayer().getDisplayName() + "!");
            });
        });

    }
}
