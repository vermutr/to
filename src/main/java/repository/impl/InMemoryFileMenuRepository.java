package repository.impl;

import config.CLIConfiguration;
import entity.menu.Menu;
import repository.MenuRepository;

public class InMemoryFileMenuRepository implements MenuRepository {

    private final Menu menu;

    public InMemoryFileMenuRepository(final CLIConfiguration config) {
        this.menu = config.loadMenuFromDisk();
    }

    @Override
    public Menu findAll() {
        return menu;
    }
}
