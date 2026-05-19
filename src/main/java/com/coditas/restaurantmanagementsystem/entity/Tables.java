package com.coditas.restaurantmanagementsystem.entity;

import com.coditas.restaurantmanagementsystem.enums.TableStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tables")
@Getter @Setter
@NoArgsConstructor
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int tableNumber;

    @Enumerated(EnumType.STRING)
    private TableStatus status;
}
