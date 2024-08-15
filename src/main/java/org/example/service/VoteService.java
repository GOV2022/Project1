package org.example.service;
import org.example.dto.VoteDTO;
import org.example.service.api.IVoteService;
import org.example.storage.ArtistStorage;
import org.example.storage.VoteStorageMemory;
import org.example.storage.api.IArtistStorage;
import org.example.storage.api.IVoteStorage;

public class VoteService implements IVoteService {

    private final static VoteService instance = new VoteService();
    private static IVoteStorage voteStorage = VoteStorageMemory.getInstance();
    private static IArtistStorage artistStorage = ArtistStorage.getInstance();


    private VoteService() {
    }

    @Override
    public void create(VoteDTO vote) {
        if(vote.getArtist() == null || vote.getArtist().isBlank()){
            throw new IllegalArgumentException("Артист пуст");

        }

        if(artistStorage.get(Long.valueOf(vote.getArtist())) == null){
            throw new IllegalArgumentException("Артист не существует");
        }

        voteStorage.create(vote);

    }

    public static VoteService getInstance(){
        return instance;
    }
}