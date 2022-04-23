package pl.envelo.rickandmorty.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.envelo.rickandmorty.model.Season;
import pl.envelo.rickandmorty.service.ResponseService;
import pl.envelo.rickandmorty.service.SeasonService;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/season")
public class SeasonController {

    private final SeasonService seasonService;
    private final ResponseService responseService;

    @GetMapping(path = "/")
    public Map<Integer, Integer> getAllSeasons() {
        return seasonService.getAllSeasonsWithNumberOfEpisodes(responseService.getInfo());
    }

    @GetMapping(path = "/{id}")
    public Season getEpisodesOfSingleSeason(@PathVariable("id") int id) {

        return seasonService.getAllEpisodesOfSingleSeason(id);
    }

    @GetMapping(path = "/count")
    public int getNumberOfSeasons() {

        return seasonService.getNumberOfSeasons(responseService.getInfo());
    }
}
