package it.davidgreco.examples.springboot_swagger_example.controller

import java.util.Optional
import java.util.concurrent.CompletableFuture

import io.swagger.annotations.ApiParam
import it.davidgreco.examples.springboot_swagger_example.api.PetsApi
import it.davidgreco.examples.springboot_swagger_example.api.services.PetsApiService
import it.davidgreco.examples.springboot_swagger_example.model.{NewPet, Pet}
import javax.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation._

import scala.collection.JavaConverters._
import scala.compat.java8.OptionConverters._

@Controller
class PetsApiController(@Autowired service: PetsApiService) extends PetsApi {

  override def addPet(@ApiParam(value = "Pet to add to the store", required = true) @Valid @RequestBody pet: NewPet): CompletableFuture[ResponseEntity[Pet]] = {
    val newPet: Pet = service.addPet(pet)
    CompletableFuture.completedFuture(new ResponseEntity[Pet](newPet, HttpStatus.OK))
  }

  override def findPetById(@ApiParam(value = "ID of pet to fetch", required = true) @PathVariable("id") id: java.lang.Long): CompletableFuture[ResponseEntity[Pet]] = {
    val pet: Pet = service.findPetById(id)
    CompletableFuture.completedFuture(new ResponseEntity[Pet](pet, HttpStatus.OK))
  }

  override def findPets(@ApiParam(value = "tags to filter by") @RequestParam(value = "tags", required = false) tags: Optional[java.util.List[String]], @ApiParam(value = "maximum number of results to return") @RequestParam(value = "limit", required = false) limit: Optional[Integer]): CompletableFuture[ResponseEntity[java.util.List[Pet]]] = {
    val result = service.findPets(tags.asScala.map(_.asScala.toList), limit.asScala.map(_.toInt))
    CompletableFuture.completedFuture(new ResponseEntity[java.util.List[Pet]](result.asJava, HttpStatus.OK))
  }
}