package com.jakub.bartnik.budgetapplication.model;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Cascade(value = org.hibernate.annotations.CascadeType.REMOVE)
    @EqualsAndHashCode.Exclude
    private Set<Budget> budgets;


}
