package pl.envelo.rickandmorty.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.envelo.rickandmorty.model.Episode;
import pl.envelo.rickandmorty.model.Info;
import pl.envelo.rickandmorty.model.Season;
import pl.envelo.rickandmorty.model.dto.EpisodeDto;
import pl.envelo.rickandmorty.model.dto.SeasonDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SeasonService {

    private final ModelMapper modelMapper;
    private final EpisodeService episodeService;

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

    public SeasonDto getAllEpisodesOfSingleSeason(int id) {

        Season season = new Season(id);

        String currentSeason = "";

        if (id < 10) {
            currentSeason = "S0" + id + "E";
        } else {
            currentSeason = "S" + id + "E";
        }

        List<EpisodeDto> episodes = episodeService.getAllEpisodes();

        int numberOfAllEpisodes = episodes.size();

        for (int i = 0; i < numberOfAllEpisodes; i++) {

            String seasonOfEpisode = episodes.get(i).getEpisode();

            if (seasonOfEpisode.contains(currentSeason)) {

                season.addEpisode(modelMapper.map(episodes.get(i), Episode.class));
            }
        }

        season.setNumberOfEpisodes(season.getEpisodes().size());

        return modelMapper.map(season, SeasonDto.class);
    }
}
