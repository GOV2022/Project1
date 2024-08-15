package org.example.storage.api;
import java.util.Map;

public interface IArtistStorage {
    Long create(String name);
    String get(Long id);
    Map<Long, String> get();
}
