package com.avis.qa.orchestration.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@ToString
public class BrandListDto {
    @JsonProperty("brand")
    private List<BrandDto> dtoList;

    public List<BrandDto> getDtoList()
    {
        return dtoList;
    }

    public void setDto(List<BrandDto> dtoList) {
        this.dtoList = dtoList;
    }
}