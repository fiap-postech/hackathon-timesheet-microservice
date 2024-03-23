package br.com.fiap.tech.challenge.application.gateway;

import br.com.fiap.tech.challenge.application.dto.TimesheetRequestDTO;
import br.com.fiap.tech.challenge.enterprise.entity.TimesheetReportResponse;

public interface TimesheetReportGateway {

    TimesheetReportResponse write(TimesheetRequestDTO dto);

}
