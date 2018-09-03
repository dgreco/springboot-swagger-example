package it.davidgreco.examples.springboot_swagger_example.controller;

import io.swagger.annotations.*;
import it.davidgreco.examples.springboot_swagger_example.api.PetApi;
import it.davidgreco.examples.springboot_swagger_example.api.services.PetsApiService;
import it.davidgreco.examples.springboot_swagger_example.model.ModelApiResponse;
import it.davidgreco.examples.springboot_swagger_example.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PetsApiController implements PetApi {

    @Autowired
    protected PetsApiService petsApiService;

    /*
    @Override
    public ResponseEntity<Void> addPet(@Valid Pet pet) {
        petsApiService.addPet(pet);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deletePet(Long petId, String apiKey) {
        return null;
    }

    @Override
    public ResponseEntity<List<Pet>> findPetsByStatus(@NotNull @Valid List<String> status) {
        ArrayList<Pet> result = new ArrayList<>();
        result.addAll(petsApiService.findPets(status));
        return new ResponseEntity<List<Pet>>(result, HttpStatus.OK);
    }
*/

    @ApiOperation(value = "Finds Pets by tags", nickname = "findPetsByTags", notes = "Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.", response = Pet.class, responseContainer = "List", authorizations = {
        @Authorization(value = "petstore_auth", scopes = {
            @AuthorizationScope(scope = "write:pets", description = "modify pets in your account"),
            @AuthorizationScope(scope = "read:pets", description = "read your pets")
            })
    }, tags={ "pet", })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "successful operation", response = Pet.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Invalid tag value") })
    @RequestMapping(value = "/pet/findByTags",
        produces = { "application/json" },
        method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<Pet>> findPetsByTags(@NotNull @Valid List<String> tags) {
        return null;
    }

/*
    @Override
    public ResponseEntity<Pet> getPetById(Long petId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updatePet(@Valid Pet pet) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updatePetWithForm(Long petId, String name, String status) {
        return null;
    }

    @Override
    public ResponseEntity<ModelApiResponse> uploadFile(Long petId, String additionalMetadata, @Valid MultipartFile file) {
        return null;
    }*/
}
