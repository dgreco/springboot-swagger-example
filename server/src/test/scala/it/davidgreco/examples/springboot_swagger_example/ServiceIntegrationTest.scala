package it.davidgreco.examples.springboot_swagger_example

import it.davidgreco.examples.springboot_swagger_example.model.Pet
import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.TestContextManager

@SuppressWarnings(
  Array(
    "org.wartremover.warts.NonUnitStatements"))
@SpringBootTest(webEnvironment = RANDOM_PORT)
class ServiceIntegrationTest extends FeatureSpec with GivenWhenThen with Matchers {

  @Autowired
  val testRestTemplate: TestRestTemplate = new TestRestTemplate()

  new TestContextManager(this.getClass).prepareTestInstance(this)

  feature("PetsApi controller") {
    scenario("Find pet by id") {
      Given("a pet id")
      val id = 1
      When("a request to /pets/{id} is sent")

      val response = testRestTemplate.getForObject[Pet](s"/pets/$id", classOf[Pet])

      Then("we get a response with the pet in the body")

      response.getId shouldBe 1
      response.getName shouldBe "Romeo"
      response.getTag shouldBe "Felino"
    }
  }

}
