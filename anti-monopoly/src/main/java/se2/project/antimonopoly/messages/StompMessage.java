package se2.project.antimonopoly.messages;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StompMessage {

    private String from;
    private String text;

    // lombok's Data annotation generates getter, setter, constructor, and Object methods
    // https://www.educative.io/answers/what-is-the-data-annotation-in-lombok

}