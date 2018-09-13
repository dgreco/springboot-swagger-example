package it.davidgreco.examples.springboot_swagger_example

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.{ComponentScan, Configuration}
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = Array[String]("it.davidgreco.examples.springboot_swagger_example", "it.davidgreco.examples.springboot_swagger_example.api"))
class Main

object Main extends App {
  val ctx: ConfigurableApplicationContext = SpringApplication.run(classOf[Main])
}

