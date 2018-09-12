package it.davidgreco.examples.springboot_swagger_example.api.services

import it.davidgreco.examples.springboot_swagger_example.model.{NewPet, Pet}

import scala.concurrent.Future

trait PetsApiService {
  def addPet(pet: NewPet): Future[Pet]

  def findPetById(id: Long): Future[Pet]

  def findPets(tags: Option[List[String]], limit: Option[Int]): Future[List[Pet]]
}
