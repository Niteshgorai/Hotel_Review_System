package com.Spring.User.Service.UserService.entities;
import lombok.*;
import javax.persistence.*;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "micro_users")
public class User {
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private String uid;
    @Column(name = "NAME")
    private String name;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ABOUT")
    private String about;

    @Transient
    private List<Rating> ratings;

}
