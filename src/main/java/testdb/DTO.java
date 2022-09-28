package testdb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import testdb.Entity.LocationEntity;

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
