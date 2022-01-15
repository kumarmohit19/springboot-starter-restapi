package com.example.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test/")
public class HospitalController {

  @Autowired
  private HospitalService hospitalService;


  @RequestMapping(value="hospitals/{id}", method = RequestMethod.GET)
  public @ResponseBody Hospital getHospital(@PathVariable("id") int id) throws Exception {

    return hospitalService.getHospital(id);
  }

  @RequestMapping(value="hospitals/", method = RequestMethod.GET)
  public @ResponseBody List<Hospital> getAllHospitals() throws Exception {
    return hospitalService.getAllHospitals();
  }


  @RequestMapping(value="hospitals/", method = RequestMethod.POST)
  public ResponseEntity<String> addHospital(@RequestBody Hospital hospital  ) {
    hospitalService.addHospital(hospital);
    return ResponseEntity.ok(hospital).build();
  }

  @RequestMapping(value="hospitals/", method = RequestMethod.PUT)
  public ResponseEntity<String> updateHospital(@RequestBody Hospital hospital) {
    hospitalService.updateHospital(hospital);
    return ResponseEntity.ok().build();
  }

  @RequestMapping(value="hospitals/", method = RequestMethod.DELETE)
  public ResponseEntity<String> deleteHospital(@RequestBody Hospital hospital) {

    hospitalService.deleteHospital(hospital);
    return ResponseEntity.noContent().build();
  }

}
