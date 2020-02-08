package lms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lms.plugin.PluginDescription;
import lms.plugin.PluginRepository;

@Controller
@RequestMapping("/plugins")
public class PluginController {
	@Autowired
	PluginRepository pr;
	
	@PostMapping()
	public ResponseEntity<Object> registerPlugin(@RequestBody PluginDescription pluginDescription) {
		pr.registerPlugin(pluginDescription);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
}
