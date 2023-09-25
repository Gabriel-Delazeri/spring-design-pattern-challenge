package com.delazeri.springdesignpatterns.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "status_historic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusHistoric implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private LocalDateTime createdAt;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Enumerated(EnumType.STRING)
    private Status status;
}
