package service.commandResolver.impl;

import org.apache.commons.collections4.CollectionUtils;
import service.commandResolver.CommandResolver;

import java.util.List;

import static config.OptionConstant.CUISINE_OPT;
import static config.OptionConstant.DESERTS_OPT;
import static config.OptionConstant.MEALS_OPT;
import static config.OptionConstant.MEALTIME_OPT;
import static config.OptionConstant.MENU_OPT;
import static config.OptionConstant.ORDER_OPT;

public class CLICommandResolver implements CommandResolver {

    private final List<String> showMenuOptionsOpt = List.of(MEALS_OPT, DESERTS_OPT, CUISINE_OPT, MENU_OPT, MEALTIME_OPT);

    private final List<String> orderOptionsOpt = List.of(ORDER_OPT);



    @Override
    public boolean containsShowMenuOption(final List<String> opts) {
        return CollectionUtils.containsAny(opts, showMenuOptionsOpt);
    }

    @Override
    public boolean containsOrderOption(List<String> opts) {
        return CollectionUtils.containsAny(opts, orderOptionsOpt);
    }

}