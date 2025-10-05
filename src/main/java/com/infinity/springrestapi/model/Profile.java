package com.infinity.springrestapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "bio")
    private String bio;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "loyalty_points")
    private Integer loyaltyPoints;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    @MapsId
    private User user;
}
