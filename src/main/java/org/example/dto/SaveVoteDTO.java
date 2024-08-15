package org.example.dto;
import java.time.LocalDateTime;
import java.util.Objects;

public class SaveVoteDTO {private LocalDateTime createAt;
    private VoteDTO dto;

    public SaveVoteDTO() {
    }

    public SaveVoteDTO(LocalDateTime createAt, VoteDTO dto) {
        this.createAt = createAt;
        this.dto = dto;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public String getArtist() {
        return dto.getArtist();
    }

    public String[] getGenre() {
        return dto.getGenre();
    }

    public String getAbout() {
        return dto.getAbout();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaveVoteDTO that = (SaveVoteDTO) o;
        return Objects.equals(createAt, that.createAt) && Objects.equals(dto, that.dto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createAt, dto);
    }

    @Override
    public String toString() {
        return "SaveVoteDTO{" +
                "createAt=" + createAt +
                ", dto=" + dto +
                '}';
    }
}
