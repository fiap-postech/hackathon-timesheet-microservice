package br.com.fiap.hackathon.launcher.config;

import br.com.fiap.hackathon.launcher.configuration.GatewayConfiguration;
import br.com.fiap.hackathon.launcher.configuration.MainConfiguration;
import br.com.fiap.hackathon.launcher.configuration.UseCaseConfiguration;
import br.com.fiap.hackathon.launcher.configuration.ControllerConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "br.com.fiap.hackathon")
@EntityScan(basePackages = "br.com.fiap.hackathon")
@Import({
      ControllerConfiguration.class,
      GatewayConfiguration.class,
      MainConfiguration.class,
      UseCaseConfiguration.class
})
public class TestConfiguration {
}
