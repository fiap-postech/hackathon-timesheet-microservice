package br.com.fiap.tech.challenge.application.usecase.customer;

import br.com.fiap.tech.challenge.application.dto.TimesheetReportDTO;
import br.com.fiap.tech.challenge.enterprise.entity.DataRemoval;

public interface RequestDataRemovalUseCase {

    DataRemoval create(TimesheetReportDTO dto);
}
