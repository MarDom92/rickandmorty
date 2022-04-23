package pl.envelo.rickandmorty.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.envelo.rickandmorty.model.Episode;
import pl.envelo.rickandmorty.service.EpisodeService;
import pl.envelo.rickandmorty.service.ResponseService;
import pl.envelo.rickandmorty.service.SeasonService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/episode")
public class EpisodeController {

    private final ResponseService responseService;
    private final EpisodeService episodeService;
    private final SeasonService seasonService;

    @GetMapping(path = "/")
    public List<Episode> getAllEpisodes() {
        return episodeService.getAllEpisodes();
    }

    @GetMapping(path = "/{id}")
    public Episode getSingleEpisode(@PathVariable("id") int id) {
        return episodeService.getSingleEpisode(id);
    }

    @GetMapping(path = "/count")
    public int getNumberOfEpisodes() {

        return episodeService.getNumberOfAllEpisodes(responseService.getInfo());
    }
}
