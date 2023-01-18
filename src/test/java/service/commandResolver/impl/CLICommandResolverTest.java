package service.commandResolver.impl;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static config.OptionConstant.CUISINE_OPT;
import static config.OptionConstant.DESERTS_OPT;
import static config.OptionConstant.MEALS_OPT;
import static config.OptionConstant.MEALTIME_OPT;
import static config.OptionConstant.MENU_OPT;
import static config.OptionConstant.ORDER_OPT;
import static org.junit.jupiter.api.Assertions.*;

class CLICommandResolverTest {

    private final List<String> showMenuOptionsOpt = List.of(MEALS_OPT, DESERTS_OPT, CUISINE_OPT, MENU_OPT, MEALTIME_OPT);
    private final List<String> orderOptionsOpt = List.of(ORDER_OPT);
    final List<String> optsMenu = List.of("des", "ms");
    final List<String> optsOrder = List.of("o");

    @Test
    void containsShowMenuOptionTest() {
        boolean containsAny = CollectionUtils.containsAny(optsMenu, showMenuOptionsOpt);
        assertTrue(containsAny);
    }

    @Test
    void containsOrderOptionTest() {
        boolean containsAny = CollectionUtils.containsAny(optsOrder, orderOptionsOpt);
        assertTrue(containsAny);
    }
}