package com.awanish.movieinfoservice.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MovieSummary {
    private int id;
    private String original_language;
    private String overview;
    private String imdbId;
    private String title;
    private String tagline;
    private String status;
}
