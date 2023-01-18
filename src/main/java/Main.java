import config.CLIConfiguration;
import entity.order.OrderOption;
import org.apache.commons.cli.Option;
import service.commandResolver.CommandResolver;
import service.commandResolver.impl.CLICommandResolver;
import service.facade.CookingWorkFlow;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.ParseException;
import repository.MenuRepository;
import repository.impl.InMemoryFileMenuRepository;
import service.history.OrderHistory;
import service.menu.MenuService;
import service.menu.impl.MenuServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final CLIConfiguration cliConfiguration = new CLIConfiguration();
        try {
            final CommandLine cmd = cliConfiguration.configureCLI(args);
            final CommandResolver commandResolver = new CLICommandResolver();
            final MenuRepository repository = new InMemoryFileMenuRepository(cliConfiguration);
            final MenuService menuService = new MenuServiceImpl(repository);
            final CookingWorkFlow cookingWorkFlow = new CookingWorkFlow(menuService);
            cookingWorkFlow.addOrderObserver(OrderHistory.getOrderHistory());
            final List<String> opts =
                    Arrays.stream(cmd.getOptions()).map(Option::getOpt).collect(Collectors.toList());

            if (commandResolver.containsShowMenuOption(opts)) {
                menuService.printMenu(cmd);
            } else if (commandResolver.containsOrderOption(opts)) {
                OrderOption orderOption = cookingWorkFlow.configureOrder();
                cookingWorkFlow.preparingAndCookingOrder(orderOption);
                System.out.println("Your order history:");
                OrderHistory.getOrderHistory().getOrders().forEach(System.out::println);
            }

        } catch (ParseException e) {
            cliConfiguration.printHelp();
        }

    }
}
