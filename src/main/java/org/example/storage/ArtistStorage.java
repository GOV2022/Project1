package org.example.storage;
import org.example.storage.api.IArtistStorage;
import java.util.HashMap;
import java.util.Map;

public class ArtistStorage implements IArtistStorage {
    private static final ArtistStorage instance = new ArtistStorage();
    private Map<Long, String> data = new HashMap<>();
    private ArtistStorage(Map<Long, String> data) {
        this.data = data;
    }

    private ArtistStorage() {
        data.put(1L, "Asti");
        data.put(2L, "Билан");
        data.put(3L, "Пугачева 1920");
        data.put(4L, "Пугачева 2024");
    }

    @Override
    public Long create(String name) {
        long id = data.size()+1;
        data.put(id, name);
        return id;
    }

    @Override
    public String get(Long id) {
        return this.data.get(id);
    }

    @Override
    public Map<Long, String> get() {
        return this.data;
    }

    public static ArtistStorage getInstance(){
        return instance;
    }

}
