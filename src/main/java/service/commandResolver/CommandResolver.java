package service.commandResolver;

import java.util.List;

public interface CommandResolver {

    boolean containsShowMenuOption(List<String> opts);

    boolean containsOrderOption(List<String> opts);

}
