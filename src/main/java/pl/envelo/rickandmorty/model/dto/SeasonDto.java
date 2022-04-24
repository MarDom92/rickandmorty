package pl.envelo.rickandmorty.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class SeasonDto {

    private List<EpisodeDto> episodes = new ArrayList<>();
}
