package org.example.service;
import org.example.service.api.IArtistService;
import org.example.storage.ArtistStorage;
import org.example.storage.api.IArtistStorage;
import java.util.Map;

public class ArtistService implements IArtistService {
    private static final ArtistService instance = new ArtistService();
    private final IArtistStorage storage = ArtistStorage.getInstance();

    private ArtistService() {
    }

    @Override
    public Long create(String name) {
        return storage.create(name);
    }

    @Override
    public String get(Long id) {
        return storage.get(id);
    }

    @Override
    public Map<Long, String> get() {
        return storage.get();
    }

    public static ArtistService getInstance() {
        return instance;
    }
}
