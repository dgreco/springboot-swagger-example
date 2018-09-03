package it.davidgreco.examples.springboot_swagger_example.api.services

import java.util.{List => JList}

import it.davidgreco.examples.springboot_swagger_example.model.Pet

trait PetsApiService {
  def addPet(pet: Pet): Unit

  def findPetById(id: Long): Pet

  def findPets(status: JList[String]): JList[Pet]
}
