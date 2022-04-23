package pl.envelo.rickandmorty.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.envelo.rickandmorty.model.Response;
import pl.envelo.rickandmorty.service.ResponseService;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/")
public class ResponseController {

    private final ResponseService responseService;

    @GetMapping(path = "/")
    public Response getResponse() {
        return responseService.getResponse();
    }
}
