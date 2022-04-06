package com.nikskul.calculatorservice.controller;

import com.nikskul.calculatorservice.exception.BadRequestException;
import com.nikskul.calculatorservice.exception.CustomArithmeticException;
import com.nikskul.calculatorservice.exception.ErrorDto;
import com.nikskul.calculatorservice.response.CalculatorResultResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("api/v1/calculator")
public class CalculatorController {

    private final String ADDITION_ENDPOINT = "/addition";
    private final String SUBTRACTION_ENDPOINT = "/subtraction";
    private final String MULTIPLY_ENDPOINT = "/multiply";
    private final String DIVISION_ENDPOINT = "/division";

    private List<String> getParametersListIfValidOrThrowException(String... params) {
        List<String> requestParamsList = List.of(params);
        if (requestParamsList.stream()
                .anyMatch(String::isBlank)
                || requestParamsList.stream()
                .anyMatch(str -> !str.matches("[-+]?([0-9]*\\.[0-9]+|[0-9]+)"))
        ) {
            throw new BadRequestException("Input params was empty or not number.");
        }
        return requestParamsList;
    }

    @GetMapping(ADDITION_ENDPOINT)
    @Operation(summary = "Return the result of two value addition")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The result was got",
                    content = {
                            @Content(mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CalculatorResultResponse.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Request params was rejected",
                    content = {
                            @Content(mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorDto.class))
                    })
    })
    public ResponseEntity<CalculatorResultResponse> getSum(
            @RequestParam(name = "firstValue") String firstValueString,
            @RequestParam(name = "secondValue") String secondValueString
    ) {
        var requestParamsList
                = getParametersListIfValidOrThrowException(firstValueString, secondValueString);

        Double result = requestParamsList
                .stream()
                .mapToDouble(Double::parseDouble)
                .reduce(Double::sum)
                .orElseThrow(
                        () -> new CustomArithmeticException("Ошибка при попытке сложения")
                );

        CalculatorResultResponse response = new CalculatorResultResponse();
        response.setResult(String.valueOf(result));

        return ResponseEntity.ok(response);
    }

    @GetMapping(SUBTRACTION_ENDPOINT)
    @Operation(summary = "Return the result of two value subtraction")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The result was got",
                    content = {
                            @Content(mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CalculatorResultResponse.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Request params was rejected",
                    content = {
                            @Content(mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorDto.class))
                    })
    })
    public ResponseEntity<CalculatorResultResponse> getSubtraction(
            @RequestParam(name = "firstValue") String firstValueString,
            @RequestParam(name = "secondValue") String secondValueString
    ) {
        var requestParamsList
                = getParametersListIfValidOrThrowException(firstValueString, secondValueString);

        Double result = requestParamsList
                .stream()
                .mapToDouble(Double::parseDouble)
                .reduce((a, b) -> a - b)
                .orElseThrow(
                        () -> new CustomArithmeticException("Ошибка при попытке вычитания")
                );

        CalculatorResultResponse response = new CalculatorResultResponse();
        response.setResult(String.valueOf(result));

        return ResponseEntity.ok(response);
    }

    @GetMapping(MULTIPLY_ENDPOINT)
    @Operation(summary = "Return the result of two value multiplication")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The result was got",
                    content = {
                            @Content(mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CalculatorResultResponse.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Request params was rejected",
                    content = {
                            @Content(mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorDto.class))
                    })
    })
    public ResponseEntity<CalculatorResultResponse> getMultiplicationResult(
            @RequestParam(name = "firstValue") String firstValueString,
            @RequestParam(name = "secondValue") String secondValueString
    ) {
        var requestParamsList
                = getParametersListIfValidOrThrowException(firstValueString, secondValueString);

        Double result = requestParamsList
                .stream()
                .mapToDouble(Double::parseDouble)
                .reduce((a, b) -> a * b)
                .orElseThrow(
                        () -> new CustomArithmeticException("Ошибка при попытке умножения")
                );

        CalculatorResultResponse response = new CalculatorResultResponse();
        response.setResult(String.valueOf(result));

        return ResponseEntity.ok(response);
    }

    @GetMapping(DIVISION_ENDPOINT)
    @Operation(summary = "Return the result of two value division")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The result was got",
                    content = {
                            @Content(mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = CalculatorResultResponse.class))
                    }),
            @ApiResponse(responseCode = "400", description = "Request params was rejected",
                    content = {
                            @Content(mediaType = APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorDto.class))
                    })
    })
    public ResponseEntity<CalculatorResultResponse> getDivisionResult(
            @RequestParam(name = "firstValue") String firstValueString,
            @RequestParam(name = "secondValue") String secondValueString
    ) {
        var requestParamsList
                = getParametersListIfValidOrThrowException(firstValueString, secondValueString);

        Double result = requestParamsList
                .stream()
                .mapToDouble(Double::parseDouble)
                .reduce((a, b) -> a / b)
                .orElseThrow(
                        () -> new CustomArithmeticException("Ошибка при попытке деления")
                );

        CalculatorResultResponse response = new CalculatorResultResponse();
        response.setResult(String.valueOf(result));

        return ResponseEntity.ok(response);
    }

}
