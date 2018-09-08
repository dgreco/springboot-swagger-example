package it.davidgreco.examples.springboot_swagger_example

import it.davidgreco.examples.springboot_swagger_example.api.services.PetsApiService
import it.davidgreco.examples.springboot_swagger_example.client.api.DefaultApi
import it.davidgreco.examples.springboot_swagger_example.client.invoker.ApiClient
import it.davidgreco.examples.springboot_swagger_example.model.{NewPet, Pet}
import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.context.annotation.{Bean, Configuration, Primary}
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

  @Autowired
  var petsApiService: PetsApiService = _

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

      val response = client.findPetById(1L)

      Then("we get a response with the pet in the body")

      response.getId shouldBe 1
      response.getName shouldBe "TestRomeo"
      response.getTag shouldBe "TestFelino"
    }
  }

}

@SuppressWarnings(
  Array(
    "org.wartremover.warts.Var",
    "org.wartremover.warts.Null",
    "org.wartremover.warts.NonUnitStatements"))
@Configuration
class ServiceIntegrationTestConfig {
  @Bean
  def restTemplate = new RestTemplate()

  @Primary
  @Bean
  def petsApiService: PetsApiService = new PetsApiService {
    override def addPet(pet: NewPet): model.Pet = null

    override def findPetById(id: Long): model.Pet = {
      val pet = new model.Pet()
      pet.setId(id)
      pet.setName("TestRomeo")
      pet.setTag("TestFelino")
      pet
    }

    def findPets(tags: Option[List[String]], limit: Option[Int]): List[Pet] = List.empty[Pet]
  }
}


