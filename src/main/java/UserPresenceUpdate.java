import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.user.update.GenericUserPresenceEvent;
import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class UserPresenceUpdate extends ListenerAdapter {
    @Override
    public void onUserUpdateOnlineStatus(@NotNull UserUpdateOnlineStatusEvent event) {
        // Sends a message to text channel when user is online.
        if(event.getMember().getOnlineStatus().equals(OnlineStatus.ONLINE)) {
            MessageChannel channel = event.getJDA()
                    .getTextChannelById("745634050672296040");
            if(event.getOldOnlineStatus().equals(OnlineStatus.OFFLINE) &&
            !event.getUser().isBot() &&
                    event.getMember().hasAccess(event.getJDA().getTextChannelById("745634050672296040"))) {
                Main.counter++;
                if(Main.counter == 2) {
                    channel.sendMessage("Welcome Back to the server " +
                            event.getMember().getEffectiveName()).queue();
                    Main.counter = 0;
                }
            }

        }
    }

//    @Override
//    public void onGenericUserPresence(@NotNull GenericUserPresenceEvent event) {
//        super.onGenericUserPresence(event);
//        int count = 0;
//        if(event.getMember().getOnlineStatus().equals(OnlineStatus.ONLINE)) {
//            MessageChannel channel = event.getJDA()
//                    .getTextChannelById("780802973609099306");
//            System.out.println(event.getMember().getOnlineStatus().getKey());
//            event.getJDA().unloadUser(event.getMember().getIdLong());
////                System.out.println(event.getOldOnlineStatus());
////                System.out.println(event.getNewOnlineStatus());
////                System.out.println(event.getNewValue());
////                System.out.println(event.getOldValue());
////                System.out.println(event.getMember().getOnlineStatus().getKey());
////                channel.sendMessage("Welcome back" + count).queue();
//        }
//    }
}
