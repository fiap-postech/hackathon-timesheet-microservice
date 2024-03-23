package br.com.fiap.hackathon.application.gateway;

import br.com.fiap.hackathon.application.dto.TimesheetRequestDTO;
import br.com.fiap.tech.challenge.enterprise.entity.TimesheetReportResponse;

public interface TimesheetReportGateway {

    TimesheetReportResponse write(TimesheetRequestDTO dto);

}
