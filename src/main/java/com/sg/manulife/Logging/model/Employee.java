package com.sg.manulife.Logging.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
  public String id;
  public String firstName;
  public String lastName;
  public String email;
  public String age;
  public String role;
}
