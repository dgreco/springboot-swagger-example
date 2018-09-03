package it.davidgreco.examples.springboot_swagger_example.configuration

import org.springframework.context.annotation.{Bean, Configuration}
import springfox.documentation.builders.{ApiInfoBuilder, RequestHandlerSelectors}
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration class SwaggerDocumentationConfig {

  private[configuration] def apiInfo = new ApiInfoBuilder().
    title("Petstore").
    description("A simple Petstore API").
    license("").
    licenseUrl("http://unlicense.org").
    termsOfServiceUrl("").
    version("0.3.1").
    contact(new Contact("", "", "")).build

  @Bean def customImplementation: Docket =
    new Docket(DocumentationType.SWAGGER_2).
      select.
      apis(
        RequestHandlerSelectors.
          basePackage("io.swagger.api")
      ).
      build.
      apiInfo(apiInfo)
}
