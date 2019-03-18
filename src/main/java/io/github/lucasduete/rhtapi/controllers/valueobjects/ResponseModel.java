package io.github.lucasduete.rhtapi.controllers.valueobjects;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ResponseModel implements Serializable {

    private Long id;
    private String content;
    private String emailEmployee;
    private Long idQuestion;

}
