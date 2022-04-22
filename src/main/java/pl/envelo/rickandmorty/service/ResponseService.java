package pl.envelo.rickandmorty.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.envelo.rickandmorty.model.Info;
import pl.envelo.rickandmorty.model.Response;

@Service
@RequiredArgsConstructor
public class ResponseService {

    private final ModelMapper modelMapper;
    private final RestTemplate restTemplate;

    public Response getResponse() {

        Response response = restTemplate.getForObject("https://rickandmortyapi.com/api/episode", Response.class);

        return response;
    }

    public Info getInfo() {

        Response response = getResponse();
        Info i = response.getInfo();

        return modelMapper.map(i, Info.class);
    }
}
