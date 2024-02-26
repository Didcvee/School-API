package ru.didcvee.analyserwebsocketservice.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Summary {

    private String groupName;
    private List<SummaryEntry> values;
    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class SummaryEntry {
        private SummaryType type;
        private double value;
    }

    public Summary() {
        this.values = new ArrayList<>();
    }

    public void addValue(SummaryEntry summaryEntry) {
        values.add(summaryEntry);
    }

}
