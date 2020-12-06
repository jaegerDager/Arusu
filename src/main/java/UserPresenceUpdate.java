import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class UserPresenceUpdate extends ListenerAdapter {
    @Override
    public void onUserUpdateOnlineStatus(@NotNull UserUpdateOnlineStatusEvent event) {
        if(event.getMember().getOnlineStatus().equals(OnlineStatus.ONLINE)) {
            MessageChannel channel = event.getJDA()
                    .getTextChannelById("780802973609099306");
            if(!channel.retrieveMessageById(channel.getLatestMessageId()).equals("Welcome back")) {
                channel.sendMessage("Welcome back").queue();
            }
        }
    }
}
