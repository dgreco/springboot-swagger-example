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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PetsApiController implements PetsApi {

    @Autowired
    protected PetsApiService petsApiService;

    public ResponseEntity<Pet> addPet(@ApiParam(value = "Pet to add to the store" ,required=true )  @Valid @RequestBody NewPet pet) {
        Pet newPet = petsApiService.addPet(pet);
        return new ResponseEntity<Pet>(newPet, HttpStatus.OK);
    }

    public ResponseEntity<Pet> findPetById(@ApiParam(value = "ID of pet to fetch",required=true ) @PathVariable("id") Long id) {
        Pet pet = petsApiService.findPetById(id);

        return new ResponseEntity<Pet>(pet,HttpStatus.OK);
    }

    public ResponseEntity<List<Pet>> findPets(@ApiParam(value = "tags to filter by") @RequestParam(value = "tags", required = false) List<String> tags,
        @ApiParam(value = "maximum number of results to return") @RequestParam(value = "limit", required = false) Integer limit) {
        // dummy code
        List<Pet> result = new ArrayList<>();
        result.addAll(petsApiService.findPets(tags, limit));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
