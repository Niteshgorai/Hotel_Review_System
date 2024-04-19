package com.Spring.User.Service.UserService.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private String ratingId;
    private String userId;
    private String hotelId;
    private String feedback;
    private String rating;

    private Hotel hotel;
}
