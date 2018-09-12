package it.davidgreco.examples.springboot_swagger_example

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.ComponentScan
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = Array[String]("it.davidgreco.examples.springboot_swagger_example", "it.davidgreco.examples.springboot_swagger_example.api"))
class Main

object Main extends App {
  val ctx: ConfigurableApplicationContext = SpringApplication.run(classOf[Main])
}

