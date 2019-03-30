package model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.entity.enums.Role;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int id;
    private Role role;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private Double rating;

}
