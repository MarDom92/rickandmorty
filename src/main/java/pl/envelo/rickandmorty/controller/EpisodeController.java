package pl.envelo.rickandmorty.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.envelo.rickandmorty.model.dto.EpisodeDto;
import pl.envelo.rickandmorty.service.EpisodeService;
import pl.envelo.rickandmorty.service.ResponseService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/episode")
public class EpisodeController {

    private final ResponseService responseService;
    private final EpisodeService episodeService;

    @GetMapping(path = "/")
    public List<EpisodeDto> getAllEpisodes() {
        return episodeService.getAllEpisodes();
    }

    @GetMapping(path = "/{id}")
    public EpisodeDto getSingleEpisode(@PathVariable("id") int id) {
        return episodeService.getSingleEpisode(id);
    }

    @GetMapping(path = "/count")
    public int getNumberOfEpisodes() {

        return episodeService.getNumberOfAllEpisodes(responseService.getInfo());
    }
}
