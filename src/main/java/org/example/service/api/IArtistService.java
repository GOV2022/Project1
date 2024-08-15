package org.example.service.api;

import java.util.Map;

public interface IArtistService {
    Long create(String name);
    String get(Long id);
    Map <Long, String> get();
}
