package it.davidgreco.examples.springboot_swagger_example.api.services.impl

import it.davidgreco.examples.springboot_swagger_example.api.services.PetsApiService
import it.davidgreco.examples.springboot_swagger_example.model.{NewPet, Pet}
import org.apache.commons.logging.LogFactory
import org.springframework.stereotype.Component

@Component
class PetsApiServiceImpl extends PetsApiService {

  val logger = LogFactory.getLog(this.getClass.getName)

  override def addPet(pet: NewPet): Pet = new Pet()

  override def findPetById(id: Long): Pet = {
    val pet = new Pet()
    pet.setId(id)
    pet.setName("Romeo")
    pet.setTag("Felino")
    pet
  }

  override def findPets(tags: Option[List[String]], limit: Option[Int]): List[Pet] = List({
    logger.trace("Begin: findPets")
    val pet = new Pet()
    pet.setId(2L)
    pet.setName("Romeo2")
    pet.setTag("Bello")
    logger.trace("End: findPets")
    pet
  })
}
