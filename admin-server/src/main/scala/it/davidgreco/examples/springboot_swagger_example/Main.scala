package it.davidgreco.examples.springboot_swagger_example

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Configuration

@Configuration
@EnableAutoConfiguration
@SpringBootApplication
@EnableAdminServer
class Main

object Main extends App {
  val ctx: ConfigurableApplicationContext = SpringApplication.run(classOf[Main])
}
