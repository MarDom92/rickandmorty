package pl.envelo.rickandmorty.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Episode {

    private Integer id;
    private String name;
    private String airDate;
    private String episode;
    private String url;
    private String created;
}
