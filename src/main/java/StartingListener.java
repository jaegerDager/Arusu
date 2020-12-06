import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class StartingListener extends ListenerAdapter {
    @Override
    public void onReady(@NotNull ReadyEvent event) {
        MessageChannel channel = event.getJDA().getTextChannelById("745634050672296040");
//        channel.sendMessage("I'm online master").queue();

//        new Reminder().remindSleep(channel);
        new Reminder().remindDrink(channel);
    }
}
