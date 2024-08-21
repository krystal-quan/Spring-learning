package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("role_id")
    @NotNull
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @JsonProperty("name")
    private ERole name;

    public Role(ERole name) {
        this.name = name;
    }

}
