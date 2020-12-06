import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import net.dv8tion.jda.api.utils.WidgetUtil;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main implements MemberCachePolicy {
    public static void main(String[] args) throws LoginException {
        try(BufferedReader reader= new BufferedReader(new FileReader("BotToken"))) {
            JDA api = JDABuilder
                    .createDefault(reader.readLine())
                    .enableIntents(GatewayIntent.GUILD_PRESENCES)
                    .setMemberCachePolicy(MemberCachePolicy.ONLINE)
                    .build();

            api.getPresence().setPresence(OnlineStatus.DO_NOT_DISTURB, Activity.watching("master"));

            api.addEventListener(new StartingListener(), new MyListener());

            api.addEventListener(new UserPresenceUpdate());
        } catch(IOException e) {
            System.out.println("Fail to load");
        }
    }

    @Override
    public boolean cacheMember(@NotNull Member member) {
        return false;
    }
}
