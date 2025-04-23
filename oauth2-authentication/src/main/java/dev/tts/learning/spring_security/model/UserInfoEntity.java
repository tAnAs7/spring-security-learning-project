package dev.tts.learning.spring_security.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_infos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String username;

    @Column(length = 50)
    private String email;

    @Column(length = 9)
    private String phone;
}
