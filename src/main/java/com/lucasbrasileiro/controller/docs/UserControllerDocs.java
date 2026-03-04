package com.lucasbrasileiro.controller.docs;

import com.lucasbrasileiro.data.dto.v1.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserControllerDocs {
    @Operation(summary = "Find All Users",
            description = "Find All Users",
            tags = {"Users"},
            responses = {
                    @ApiResponse(description = "Sucess",
                            responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            array = @ArraySchema(schema = @Schema(
                                                    implementation = UserDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    List<UserDTO> findAll();
    @Operation(summary = "Find a User",
            description = "Find a specific user by your ID",
            tags = {"Users"},
            responses = {
                    @ApiResponse(description = "Sucess",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = UserDTO.class)
                            )
                    ),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    UserDTO findById(@PathVariable("id") Long id);
    @Operation(summary = "Create a User",
            description = "Create a new user",
            tags = {"Users"},
            responses = {
                    @ApiResponse(description = "Sucess",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = UserDTO.class)
                            )
                    ),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    UserDTO create(@RequestBody UserDTO user);
    @Operation(summary = "Delete a User",
            description = "Find a specific user by your ID and delete them",
            tags = {"Users"},
            responses = {
                    @ApiResponse(description = "Sucess",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = UserDTO.class)
                            )
                    ),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    ResponseEntity<?> delete(@PathVariable("id") Long id);
    @Operation(summary = "Update a User",
            description = "Update a specific user by your ID",
            tags = {"Users"},
            responses = {
                    @ApiResponse(description = "Sucess",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = UserDTO.class)
                            )
                    ),
                    @ApiResponse(description = "No content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500", content = @Content)
            })
    UserDTO update(@RequestBody UserDTO user);
}
