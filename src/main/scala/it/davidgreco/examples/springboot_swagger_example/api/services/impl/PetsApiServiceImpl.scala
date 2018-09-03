package it.davidgreco.examples.springboot_swagger_example.api.services.impl

import java.util.{List => JList}

import it.davidgreco.examples.springboot_swagger_example.api.services.PetsApiService
import it.davidgreco.examples.springboot_swagger_example.model.{NewPet, Pet}
import org.springframework.stereotype.Component

import scala.collection.JavaConverters._

@Component
class PetsApiServiceImpl extends PetsApiService {

  override def addPet(pet: NewPet): Pet = new Pet()

  override def findPetById(id: Long): Pet = new Pet()

  override def findPets(tags: JList[String], limit: Integer): JList[Pet] = { // dummy code
    List(new Pet).asJava
  }
}
