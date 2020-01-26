package com.school.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Nicholas Dietz
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DemoDTO {

    /**
     * DTO (Data-Transfer-Object)
     * ______________________________
     * JSON-Format:
     *
     * {
     *     "id": <id>,
     *     "sampleText": "<text>"
     * }
     * ______________________________
     */

    @JsonProperty("id")
    private int id;

    @JsonProperty("sampleText")
    private String sampleText;

}
