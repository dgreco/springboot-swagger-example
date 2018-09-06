package it.davidgreco.examples.springboot_swagger_example.controller

import java.util.concurrent.CompletableFuture
import java.util.{List => JList}
import java.{lang, util}

import io.swagger.annotations.ApiParam
import it.davidgreco.examples.springboot_swagger_example.api.PetsApi
import it.davidgreco.examples.springboot_swagger_example.api.services.PetsApiService
import it.davidgreco.examples.springboot_swagger_example.model.{NewPet, Pet}
import javax.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{HttpStatus, ResponseEntity}
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation._

@Controller
class PetsApiController(@Autowired service: PetsApiService) extends PetsApi {

  override def addPet(@ApiParam(value = "Pet to add to the store", required = true) @Valid @RequestBody pet: NewPet): CompletableFuture[ResponseEntity[Pet]] = {
    val newPet: Pet = service.addPet(pet)
    CompletableFuture.completedFuture(new ResponseEntity[Pet](newPet, HttpStatus.OK))
  }

  @RequestMapping(value = Array("/pets/{id}"), produces = Array("application/json"), method = Array(RequestMethod.GET))
  override def findPetById(@ApiParam(value = "ID of pet to fetch", required = true) @PathVariable("id") id: lang.Long): CompletableFuture[ResponseEntity[Pet]] = {
    val pet: Pet = service.findPetById(id)
    CompletableFuture.completedFuture(new ResponseEntity[Pet](pet, HttpStatus.OK))
  }

  override def findPets(@ApiParam(value = "tags to filter by") @RequestParam(value = "tags", required = false) tags: JList[String], @ApiParam(value = "maximum number of results to return") @RequestParam(value = "limit", required = false) limit: Integer): CompletableFuture[ResponseEntity[JList[Pet]]] = {
    val result: JList[Pet] = new util.ArrayList[Pet](service.findPets(tags, limit))
    CompletableFuture.completedFuture(new ResponseEntity[JList[Pet]](result, HttpStatus.OK))
  }
}