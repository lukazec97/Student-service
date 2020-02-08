package lms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lms.plugin.PluginRepository;

@Controller
@RequestMapping("/message")
public class MessageController {
	@Autowired
	PluginRepository pr;
	
	@RequestMapping()
	@Secured("ROLE_PLUGIN")
	public ResponseEntity<String> getMessages() {
		return pr.getPlugins("message").get(0).sendRequest(HttpMethod.GET, "http://localhost:8081/plugin/message");
	}
}
