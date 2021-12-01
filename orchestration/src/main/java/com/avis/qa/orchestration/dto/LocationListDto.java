package com.avis.qa.orchestration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@ToString
public class LocationListDto {
    @JsonProperty("locations")
    private List<LocationDto> dtoList;

    public List<LocationDto> getDtoList()
    {
        return dtoList;
    }

    public void setDto(List<LocationDto> dtoList) {
        this.dtoList = dtoList;
    }
}