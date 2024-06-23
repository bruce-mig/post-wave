package com.github.bruce_mig.post_wave.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("v1/person")
    public PersonV1 getPersonV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 getPersonV2() {
        return new PersonV2(new Name("Bob","Charlie"));
    }

    // Request Parameter versioning - Amazon

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getPersonRequestParameterV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getPersonRequestParameterV2() {
        return new PersonV2(new Name("Bob","Charlie"));
    }

    // Request Header versioning - Microsoft

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getPersonRequestHeaderV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getPersonRequestHeaderV2() {
        return new PersonV2(new Name("Bob","Charlie"));
    }


    // Media Type Versioning/ Content Negotiation Versioning  - GitHub

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getPersonAcceptHeaderV1() {
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(path = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getPersonAcceptHeaderV2() {
        return new PersonV2(new Name("Bob","Charlie"));
    }
}
