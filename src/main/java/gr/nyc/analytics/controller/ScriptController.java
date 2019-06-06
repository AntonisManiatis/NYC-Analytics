package gr.nyc.analytics.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.core.io.InputStreamResource;
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
    public ResponseEntity<Resource> serveFile() throws FileNotFoundException
    {
    	// TODO: add the resource file instead of my desktop
        InputStreamResource resource = 
        		new InputStreamResource(new FileInputStream("C:\\Users\\Anthony\\Desktop\\analytics.js"));
        return ResponseEntity.ok().body(resource);
    }
}
