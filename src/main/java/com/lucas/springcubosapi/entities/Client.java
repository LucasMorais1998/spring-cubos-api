package com.lucas.springcubosapi.entities;

import com.lucas.springcubosapi.dtos.ClientDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "clients")
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;

    private String lastName;

    private BigDecimal participation;

    public Client(ClientDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.participation = data.participation();
    }
}
