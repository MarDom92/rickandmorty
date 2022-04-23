package pl.envelo.rickandmorty.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Result {

    private Integer id;
    private String name;
    @JsonProperty("air_date")
    private String airDate;
    private String episode;
    private List<String> characters = null;
    private String url;
    private String created;
}
