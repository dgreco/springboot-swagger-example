package it.davidgreco.examples.springboot_swagger_example.api.services

import java.util.{List => JList}

import it.davidgreco.examples.springboot_swagger_example.model.{NewPet, Pet}

trait PetsApiService {
  def addPet(pet: NewPet): Pet

  def findPetById(id: Long): Pet

  def findPets(tags: JList[String], limit: Integer): JList[Pet]
}
