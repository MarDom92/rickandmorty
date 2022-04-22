package pl.envelo.rickandmorty.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.envelo.rickandmorty.model.Episode;

@Service
@RequiredArgsConstructor
public class EpisodeService {

    private final RestTemplate restTemplate;

    public Episode getSingleEpisode(int id) {

        Episode episode = restTemplate.getForObject("https://rickandmortyapi.com/api/episode/" + String.valueOf(id), Episode.class);

        return episode;
    }
}
