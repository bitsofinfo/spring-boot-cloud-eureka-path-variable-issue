package my.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRESTController {

	@RequestMapping(value="/my/custom/path/{id:.+}", 
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<? extends Object> resolveAccessor(@PathVariable String id) {
		return new ResponseEntity<String>("i got here " + id,HttpStatus.OK);
	}
	
}
