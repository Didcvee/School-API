package ru.didcvee.scheduleservice.entity.other;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Grade {
    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                '}';
    }

    private int id;
    private String mark;
}
