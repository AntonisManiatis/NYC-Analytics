package gr.nyc.analytics.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This controller is responsible for sending the analytics script to the user just like in Google Analytics
 * https://www.google-analytics.com/analytics.js
 * @author Anthony
 */
@Controller
public class ScriptController
{
    @GetMapping("/analytics.js")
    public ResponseEntity<Resource> serveFile()
    {
    	Resource script = new ClassPathResource("static/analytics.js");
        return ResponseEntity.ok().body(script);
    }
}
