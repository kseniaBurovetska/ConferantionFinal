package model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.entity.enums.Status;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lecture {

    private int id;
    private String topic;
    private Status status;

}
