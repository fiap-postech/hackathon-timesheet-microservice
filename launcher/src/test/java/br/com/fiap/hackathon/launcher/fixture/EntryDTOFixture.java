package br.com.fiap.hackathon.launcher.fixture;

import br.com.fiap.hackathon.application.dto.EntryDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.instancio.Instancio;
import org.instancio.Model;

import java.time.LocalTime;
import java.util.UUID;

import static org.instancio.Select.field;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EntryDTOFixture {

    public static Model<EntryDTO> entryDTOModel() {
        return Instancio.of(EntryDTO.class)
                .set(field(EntryDTO::getUuid), UUID.randomUUID().toString())
                .set(field(EntryDTO::getTimestamp), LocalTime.of(9,0,0))
                .toModel();
    }

}
