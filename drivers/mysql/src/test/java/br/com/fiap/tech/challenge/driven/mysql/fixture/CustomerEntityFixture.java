package br.com.fiap.tech.challenge.driven.mysql.fixture;

import br.com.fiap.tech.challenge.driven.mysql.model.TimeSheetEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.util.UUID;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerEntityFixture {

    public static Model<TimeSheetEntity> enabledCustomerEntityModel() {
        return Instancio.of(TimeSheetEntity.class)
                .set(field(TimeSheetEntity::getName), "Jose da Silva")
                .set(field(TimeSheetEntity::getEmail), "jose.silva@gmail")
                .set(field(TimeSheetEntity::getDocument), "19748826325")
                .set(field(TimeSheetEntity::isEnabled), true)
                .set(field(TimeSheetEntity::getUuid), UUID.randomUUID().toString())
                .toModel();
    }
}
