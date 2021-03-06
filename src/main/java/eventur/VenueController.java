package eventur;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VenueController {
	@Autowired
	VenueService venueService;
	
	public VenueController(VenueService venueService) {
		this.venueService = venueService;
	}
	
	@GetMapping("/showTable")
	public List showTable() {
		return venueService.showTable();
	}
	
	@RequestMapping("/createVenue")
	public String createVenue(@RequestBody Venue venue) {
		venueService.createVenue(venue);
		return "venue created";
	}
	
	@GetMapping("/getVenue/{id}")
	public Venue getVenueById(@PathVariable String id) {
		return venueService.getVenueById(Integer.parseInt(id));
	}
	
//	@RequestMapping("/updateVenue/{venueId}/{field}/{updatedValue}")
//	public String updateVenue(@PathVariable("venueId") int venueId, @PathVariable("field") String field, @PathVariable("updatedValue") String updatedValue) {
//		venueService.updateVenue(venueId, field, updatedValue);
//		return "venue updated";
//	}
	
	@PutMapping("/updateVenue")
	public String updateVenue(@RequestBody JSONObject jsonObj) throws ParseException {
		venueService.updateVenue(jsonObj);
		return "venue updated";
	}
	
	@GetMapping("/deleteVenue/{id}")
	public String deleteVenue(@PathVariable("id") int id) {
		venueService.deleteVenue(id);
		return "venue deleted";
		
	}
}

