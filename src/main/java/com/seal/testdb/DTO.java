package com.seal.testdb;

import com.seal.testdb.Entity.LocationEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DTO {
    private int id;
    private String province;

    public DTO(LocationEntity locationEntity) {
        this.id = locationEntity.getId();
        this.province = locationEntity.getProvince();
    }
}
