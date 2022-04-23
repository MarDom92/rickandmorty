package pl.envelo.rickandmorty.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Episode {

    private Integer id;
    private String name;
    private String airDate;
    private String episode;
    public List<String> characters = null;
    private String url;
    private String created;
}
