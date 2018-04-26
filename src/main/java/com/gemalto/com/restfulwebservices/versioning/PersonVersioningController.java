package com.gemalto.com.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("/v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Bob Charley");
    }

    @GetMapping("/v2/person")
    public PersionV2 persionV2() {
        return new PersionV2(new Name("Bob", "Charlie"));
    }
}
