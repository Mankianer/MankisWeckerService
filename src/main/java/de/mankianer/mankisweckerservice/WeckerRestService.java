package de.mankianer.mankisweckerservice;

import de.mankianer.mankisweckerservice.models.Wecker;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wecker/")
public class WeckerRestService {

  @Autowired
  private WeckerController weckerController;

  @Autowired
  private WeckerRepo weckerRepo;


  @PostMapping("/{localDateTime}")
  public Wecker create(@PathVariable("localDateTime")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
      LocalDateTime localDateTime){
    return createWecker(localDateTime);
  }

  private Wecker createWecker(LocalDateTime localDateTime){
    Wecker wecker = new Wecker();
    wecker.setDateTime(localDateTime);
    wecker.setConfig("Test");
    return weckerController.add(wecker);
  }


  @GetMapping("/{id}")
  public Wecker get(@PathVariable("id") Integer id){
    return weckerRepo.findById(id).orElse(null);
  }

  @GetMapping
  public Iterable<Wecker> getAll(){
    return weckerRepo.findAll();
  }



  @DeleteMapping("/{id}")
  public boolean delete(@PathVariable("id") Integer id){
    weckerRepo.deleteById(id);
    return true;
  }

  @GetMapping("/hallo")
  public String test(){
    return "test";
  }
}
