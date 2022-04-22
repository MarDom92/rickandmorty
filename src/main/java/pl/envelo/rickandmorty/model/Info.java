package pl.envelo.rickandmorty.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Info {

    private Integer count;
    private Integer pages;
    private String next;
    private Object prev;
}