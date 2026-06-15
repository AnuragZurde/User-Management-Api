package com.anu.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "User Details")
public class User {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(name= "username", unique= true, nullable= false)
  private String username;

  @Column(name="password", nullable=false)
  private String password;

  @Email
  @Column(name = "email", nullable = false)
  private String email;
}
