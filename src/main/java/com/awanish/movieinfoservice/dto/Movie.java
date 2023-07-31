package com.awanish.movieinfoservice.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Movie {
    public String movieId;
    public String title;
    public String overview;
}
