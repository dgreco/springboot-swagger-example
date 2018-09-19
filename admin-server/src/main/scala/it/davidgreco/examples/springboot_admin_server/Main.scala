package it.davidgreco.examples.springboot_admin_server

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext

@EnableAdminServer
@SpringBootApplication
class Main

object Main extends App {
  val ctx: ConfigurableApplicationContext = SpringApplication.run(classOf[Main])
}

