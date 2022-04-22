package pl.envelo.rickandmorty.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.envelo.rickandmorty.model.Episode;
import pl.envelo.rickandmorty.service.EpisodeService;
import pl.envelo.rickandmorty.service.ResponseService;
import pl.envelo.rickandmorty.service.SeasonService;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/episodes")
public class EpisodeController {

    private final ResponseService responseService;
    private final EpisodeService episodeService;
    private final SeasonService seasonService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Episode getSingleEpisode(@PathVariable("id") int id) {
        return episodeService.getSingleEpisode(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/count")
    public int getNumberOfEpisodes() {

        return seasonService.getNumberOfEpisodes(responseService.getInfo());
    }
}
