package it.davidgreco.examples.springboot_swagger_example

import it.davidgreco.examples.springboot_swagger_example.client.api.DefaultApi
import it.davidgreco.examples.springboot_swagger_example.client.invoker.ApiClient
import it.davidgreco.examples.springboot_swagger_example.client.model.Pet
import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.test.context.TestContextManager
import org.springframework.web.client.RestTemplate

@SuppressWarnings(
  Array(
    "org.wartremover.warts.Var",
    "org.wartremover.warts.Null",
    "org.wartremover.warts.NonUnitStatements"))
@SpringBootTest(webEnvironment = RANDOM_PORT)
class ServiceIntegrationTest extends FeatureSpec with GivenWhenThen with Matchers {

  @LocalServerPort
  var port = 0

  @Autowired
  var restTemplate: RestTemplate = _

  new TestContextManager(this.getClass).prepareTestInstance(this)

  feature("PetsApi controller") {
    scenario("Find pet by id") {
      Given("a pet id")
      val id = 1
      When("a request to /pets/{id} is sent")

      val client = new DefaultApi({
        val apiClient = new ApiClient(restTemplate)
        apiClient.setBasePath(s"http://localhost:$port/pet-store/v1")
        apiClient
      })

      val response: Pet = client.findPetById(1L) //testRestTemplate.getForObject[Pet](s"/pets/$id", classOf[Pet])

      Then("we get a response with the pet in the body")

      response.getId shouldBe 1
      response.getName shouldBe "Romeo"
      response.getTag shouldBe "Felino"
    }
  }

}

@Configuration
class PetStoreIntegrationConfig {
  @Bean
  def restTemplate = new RestTemplate()
}


