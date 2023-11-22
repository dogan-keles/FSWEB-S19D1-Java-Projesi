package com.workintech.movieRestApi.dto;

import java.util.List;

public record MovieResponse(String name, String directorName, int rating, List<ActorResponse> actors) {
}
