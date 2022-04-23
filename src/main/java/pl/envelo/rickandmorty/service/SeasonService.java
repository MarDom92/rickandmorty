package pl.envelo.rickandmorty.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.envelo.rickandmorty.model.Episode;
import pl.envelo.rickandmorty.model.Info;
import pl.envelo.rickandmorty.model.Season;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SeasonService {

    private final EpisodeService episodeService;
    private final ResponseService responseService;

    public int getNumberOfSeasons(Info info) {

        int counter = info.getCount();
        int numberOfSeasons = 0;

        String last = episodeService.getSingleEpisode(counter).getEpisode();

        numberOfSeasons = Integer.parseInt(last.substring(last.indexOf('S') + 1, last.indexOf('E')));

        return numberOfSeasons;
    }

    public Map<Integer, Integer> getAllSeasonsWithNumberOfEpisodes(Info info) {

        int counter = getNumberOfSeasons(info);

        Map<Integer, Integer> seasonsMap = new HashMap<>();

        for (int i = 1; i <= counter; i++) {

            seasonsMap.put(i, getAllEpisodesOfSingleSeason(i).getNumberOfEpisodes());
        }
        return seasonsMap;
    }

    public Season getAllEpisodesOfSingleSeason(int id) {

        Season season = new Season(id);
        Episode episode;

        String currentSeason = "";

        if (id < 10) {
            currentSeason = "S0" + id + "E";
        } else {
            currentSeason = "S" + id + "E";
        }

        int numberOfAllEpisodes = episodeService.getNumberOfAllEpisodes(responseService.getInfo());

        for (int i = 1; i <= numberOfAllEpisodes; i++) {

            episode = episodeService.getSingleEpisode(i);

            String seasonOfEpisode = episode.getEpisode();

            if (seasonOfEpisode.contains(currentSeason)) {

                season.addEpisode(episode);
            }
        }

        season.setNumberOfEpisodes(season.getEpisodes().size());

        return season;
    }
}
