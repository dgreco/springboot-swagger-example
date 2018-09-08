package it.davidgreco.examples.springboot_swagger_example.api.services

import it.davidgreco.examples.springboot_swagger_example.model.{NewPet, Pet}

trait PetsApiService {
  def addPet(pet: NewPet): Pet

  def findPetById(id: Long): Pet

  def findPets(tags: Option[List[String]], limit: Option[Int]): List[Pet]
}
