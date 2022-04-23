package pl.envelo.rickandmorty.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.envelo.rickandmorty.model.Result;
import pl.envelo.rickandmorty.model.Season;
import pl.envelo.rickandmorty.service.ResponseService;
import pl.envelo.rickandmorty.service.SeasonService;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/season")
public class SeasonController {

    private final SeasonService seasonService;
    private final ResponseService responseService;

    @GetMapping(path = "/count")
    public int getNumberOfSeasons() {

        return seasonService.getNumberOfSeasons(responseService.getInfo());
    }

    @GetMapping(path = "/{id}")
    public Season getEpisodesOfSingleSeason(@PathVariable("id") int id) {

        return seasonService.getAllEpisodesOfSingleSeason(id);
    }
}
