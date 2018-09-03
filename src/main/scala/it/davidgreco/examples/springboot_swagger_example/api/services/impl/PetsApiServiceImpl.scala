package it.davidgreco.examples.springboot_swagger_example.api.services.impl

import java.util.{List => JList}

import it.davidgreco.examples.springboot_swagger_example.api.services.PetsApiService
import it.davidgreco.examples.springboot_swagger_example.model.Pet
import org.springframework.stereotype.Component

import scala.collection.JavaConverters._

@Component
class PetsApiServiceImpl extends PetsApiService {

  override def addPet(pet: Pet): Unit = {}

  override def findPetById(id: Long): Pet = new Pet()

  override def findPets(status: JList[String]): JList[Pet] = { // dummy code
    List(new Pet).asJava
  }
}
