package com.bookyourticket.profile.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bookyourticket.profile.entity.Profile;
import com.bookyourticket.profile.service.ProfileService;

@RestController
@RequestMapping("/profiles")
public class ProfileResource {

	@Autowired
	public ProfileService service;

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping
	public List<Profile> getAllProfiles()
	{
		return service.getAllProfile();
	}

	@PostMapping
	public Profile addProfile(@RequestBody Profile profile) {
		//System.out.println(profile);
		Profile profile1 = service.addProfile(profile);
		profile1.getProfileId();
		restTemplate.postForEntity("http://10.246.92.60:2727/wallets/"+profile1.getProfileId(), null, null);
		return profile1;
	}

	@GetMapping("/{profileId}")
	public ResponseEntity<Profile> getProfileById(@PathVariable Integer profileId) {
		
		Optional<Profile> profileobject = service.getProfileById(profileId);
		if (!profileobject.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(profileobject.get(), HttpStatus.OK);
	}

	@DeleteMapping("/{profileId}")
	public void deleteProfileById(@PathVariable int profileId) {
		service.deleteProfileById(profileId);
	}

	@PutMapping("/{profileId}")
	public void updateProfile(@PathVariable int profileId ,@RequestBody Profile profile) {
		service.updateProfile(profile);
	}

}
