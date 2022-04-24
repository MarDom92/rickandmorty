package pl.envelo.rickandmorty.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.envelo.rickandmorty.model.Episode;
import pl.envelo.rickandmorty.model.Info;
import pl.envelo.rickandmorty.model.Response;
import pl.envelo.rickandmorty.model.dto.EpisodeDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EpisodeService {

    private final RestTemplate restTemplate;
    private final ModelMapper modelMapper;

    public List<EpisodeDto> getAllEpisodes() {

        Response response;
        List<Episode> episodes = new ArrayList<>();
        String url = "https://rickandmortyapi.com/api/episode/";

        response = restTemplate.getForObject(url, Response.class);

        int numberOfPages = response.getInfo().getPages();

        for (int i = 1; i <= numberOfPages; i++) {
            response = restTemplate.getForObject(url + "?page=" + i, Response.class);
            episodes.addAll(response.getEpisodes());
        }

        return episodes.stream().map(episode -> modelMapper.map(episode, EpisodeDto.class)).collect(Collectors.toList());
    }

    public EpisodeDto getSingleEpisode(int id) {

        Episode episode = restTemplate.getForObject("https://rickandmortyapi.com/api/episode/" + String.valueOf(id), Episode.class);

        return modelMapper.map(episode, EpisodeDto.class);
    }

    public int getNumberOfAllEpisodes(Info info) {
        return info.getCount();
    }
}
