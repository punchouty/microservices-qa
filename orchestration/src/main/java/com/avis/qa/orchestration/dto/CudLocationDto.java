package com.avis.qa.orchestration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@ToString
public class CudLocationDto {
    @JsonProperty("_embedded")
    private LocationListDto embedded;

    public LocationListDto getEmbedded() {
        return embedded;
    }

    public void setEmbedded(LocationListDto embedded) {
        this.embedded = embedded;
    }
}