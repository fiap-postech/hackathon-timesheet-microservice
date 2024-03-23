package br.com.fiap.hackathon.launcher.fixture;

import br.com.fiap.hackathon.application.dto.TimeTrackingDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.time.LocalDate;
import java.util.UUID;

import static br.com.fiap.hackathon.launcher.fixture.EntryDTOFixture.entryDTOModel;
import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeTrackingDTOFixture {

    public static Model<TimeTrackingDTO> TimeTrackingDTOModel() {
        return Instancio.of(TimeTrackingDTO.class)
                .set(field(TimeTrackingDTO::getUuid), UUID.randomUUID().toString())
                .set(field(TimeTrackingDTO::getEmployeeId), "123456789")
                .set(field(TimeTrackingDTO::getDate), LocalDate.of(2024,3,23))
                .set(field(TimeTrackingDTO::getEntry), Instancio.create(entryDTOModel()))
                .toModel();
    }

}
