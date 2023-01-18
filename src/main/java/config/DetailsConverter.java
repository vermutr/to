package config;

import com.google.gson.Gson;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class DetailsConverter {

    private static final File MENU_FILE = new File("C:\\Users\\verti\\IdeaProjects\\to\\src\\main\\resources\\menu.json");
    private static final Gson GSON = new Gson();

    private DetailsConverter() {
    }

    @SneakyThrows
    public static Reader parseFile() {
        return new FileReader(MENU_FILE);
    }

    public static <T> T fromJson(final Reader reader, Class<T> clazz) {
        return GSON.fromJson(reader, clazz);
    }

}
