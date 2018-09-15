package it.davidgreco.examples.springboot_swagger_example

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import springfox.documentation.swagger2.annotations.EnableSwagger2

@EnableAdminServer
@SpringBootApplication
@EnableSwagger2
class Main

object Main extends App {
  val ctx: ConfigurableApplicationContext = SpringApplication.run(classOf[Main])
}

