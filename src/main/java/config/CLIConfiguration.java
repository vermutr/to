package config;

import entity.menu.Menu;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import static config.DetailsConverter.fromJson;
import static config.DetailsConverter.parseFile;
import static config.OptionConstant.CUISINE_OPT;
import static config.OptionConstant.CUISINE_OPT_LONG;
import static config.OptionConstant.DESERTS_LONG_OPT;
import static config.OptionConstant.DESERTS_OPT;
import static config.OptionConstant.MEALS_LONG_OPT;
import static config.OptionConstant.MEALS_OPT;
import static config.OptionConstant.MEALTIME_OPT;
import static config.OptionConstant.MEALTIME_OPT_LONG;
import static config.OptionConstant.MENU_LONG_OPT;
import static config.OptionConstant.MENU_OPT;
import static config.OptionConstant.ORDER_LONG_OPT;
import static config.OptionConstant.ORDER_OPT;

public class CLIConfiguration {

    private static final Options OPTIONS = new Options();

    static {
        OPTIONS.addOption(MEALS_OPT, MEALS_LONG_OPT, false, "show all meals");
        OPTIONS.addOption(DESERTS_OPT, DESERTS_LONG_OPT, false, "show all desserts");
        OPTIONS.addOption(MENU_OPT, MENU_LONG_OPT, false, "show menu");
        OPTIONS.addOption(CUISINE_OPT, CUISINE_OPT_LONG, false, "show cuisines");
        OPTIONS.addOption(MEALTIME_OPT, MEALTIME_OPT_LONG, false, "show mealtimes");
        OPTIONS.addOption(ORDER_OPT, ORDER_LONG_OPT, false, "take an order");
    }

    public CommandLine configureCLI(final String[] args) throws ParseException {
        final CommandLineParser cli = new DefaultParser();
        return cli.parse(OPTIONS, args);
    }

    public void printHelp() {
        final HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Restaurant CLI", OPTIONS);
    }

    public Menu loadMenuFromDisk() {
        return fromJson(parseFile(), Menu.class);
    }

}
