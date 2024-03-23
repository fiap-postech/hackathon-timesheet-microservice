package br.com.fiap.tech.challenge.adapter.controller.customer;

import br.com.fiap.tech.challenge.application.dto.DataRemovalDTO;
import br.com.fiap.tech.challenge.application.dto.TimesheetReportDTO;

public interface RequestDataRemovalController {

    DataRemovalDTO create(TimesheetReportDTO dto);
}
