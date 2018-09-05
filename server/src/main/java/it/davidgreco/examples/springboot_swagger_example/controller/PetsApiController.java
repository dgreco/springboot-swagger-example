package it.davidgreco.examples.springboot_swagger_example.controller;

import io.swagger.annotations.ApiParam;
import it.davidgreco.examples.springboot_swagger_example.api.PetsApi;
import it.davidgreco.examples.springboot_swagger_example.api.services.PetsApiService;
import it.davidgreco.examples.springboot_swagger_example.model.NewPet;
import it.davidgreco.examples.springboot_swagger_example.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Controller
public class PetsApiController implements PetsApi {

    private final PetsApiService service;

    @Autowired
    public PetsApiController(PetsApiService petsApiService) {
        this.service = petsApiService;
    }

    public CompletableFuture<ResponseEntity<Pet>> addPet(@ApiParam(value = "Pet to add to the store" ,required=true )  @Valid @RequestBody NewPet pet) {
        Pet newPet = service.addPet(pet);
        return CompletableFuture.completedFuture(new ResponseEntity<>(newPet, HttpStatus.OK));
    }

    @RequestMapping(value = "/pets/{id}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    public CompletableFuture<ResponseEntity<Pet>> findPetById(@ApiParam(value = "ID of pet to fetch",required=true) @PathVariable("id") Long id) {
        Pet pet = service.findPetById(id);
        return CompletableFuture.completedFuture(new ResponseEntity<>(pet,HttpStatus.OK));
    }

    public CompletableFuture<ResponseEntity<List<Pet>>> findPets(@ApiParam(value = "tags to filter by") @RequestParam(value = "tags", required = false) List<String> tags,
                                                                 @ApiParam(value = "maximum number of results to return") @RequestParam(value = "limit", required = false) Integer limit) {
        List<Pet> result = new ArrayList<>(service.findPets(tags, limit));
        return CompletableFuture.completedFuture(new ResponseEntity<>(result, HttpStatus.OK));
    }

}