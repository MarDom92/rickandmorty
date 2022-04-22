package pl.envelo.rickandmorty.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Season {

    private Integer id;
    private Integer numberOfEpisodes;
    private List<Episode> episodes = new ArrayList<>();

    public Season(Integer id) {
        this.id = id;
    }

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }
}
