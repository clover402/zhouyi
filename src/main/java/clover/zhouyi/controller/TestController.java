package clover.zhouyi.controller;

import clover.zhouyi.model.SixtyFourDiagrams;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping("/msg")
    public Object testJiraMsg(@RequestBody Object msg) {
        return msg;
    }

    @GetMapping("/debug")
    public boolean debug() {
        SixtyFourDiagrams[][] SquareDiagrams = SixtyFourDiagrams.SquareDiagrams;
        SixtyFourDiagrams[] CircleDiagrams = SixtyFourDiagrams.CircleDiagrams;
        return true;
    }
}
