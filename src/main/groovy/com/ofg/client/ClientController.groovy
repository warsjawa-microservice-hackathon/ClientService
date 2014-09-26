package com.ofg.client

import com.ofg.twitter.controller.place.extractor.CityFinder
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import groovy.json.JsonSlurper
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import javax.validation.constraints.NotNull

import static org.springframework.web.bind.annotation.RequestMethod.POST

@Slf4j
@RestController
@RequestMapping('/clients')
@Api(value = "clients", description = "Store client details")
class ClientController {

    @RequestMapping(
            value = '/',
            method = POST,
            consumes = 'application/json',
            produces = 'application/json')
    @ApiOperation(value = "Stores user",
            notes = "The code stores user")
    String findCity(@RequestBody String body) {
        def root = new JsonSlurper().parseText(body)
        Client client = new Client(firstName: root.firstName, lastName: root.lastName, root.loanId)

    }

    static class Client {
        final String firstName
        final String lastName
        final String loanId
    }
}
