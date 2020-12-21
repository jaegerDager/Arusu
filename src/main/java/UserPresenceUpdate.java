import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class UserPresenceUpdate extends ListenerAdapter {
    @Override
    public void onUserUpdateOnlineStatus(@NotNull UserUpdateOnlineStatusEvent event) {
        // Sends a message to text channel when user is online.
        Member member = event.getMember();
        MessageChannel channel = event.getJDA()
                .getTextChannelById(Main.textChannelId);

        if(event.getNewOnlineStatus().equals(OnlineStatus.ONLINE)
        && event.getOldOnlineStatus().equals(OnlineStatus.OFFLINE)
        && !event.getUser().isBot()
        && member.hasAccess((GuildChannel) channel)) {
            Main.counter++;

            // Counter used as event handler gets called twice instead of once.
            if(Main.counter == 2) {
                if(member.getId().equals(Main.friendWId)) {
                    channel.sendMessage("Oh look the idiot is back").queue();
                } else if(member.getId().equals(Main.botOwnerId)) {
                    channel.sendMessage("Welcome back master").queue();
                } else {
                    channel.sendMessage("Welcome back " + member.getUser().getName()).queue();
                }
                Main.counter = 0;
            }
        }
    }
}
