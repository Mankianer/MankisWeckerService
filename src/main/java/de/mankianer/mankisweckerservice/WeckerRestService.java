package de.mankianer.mankisweckerservice;

import de.mankianer.mankisweckerservice.models.Wecker;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

  @PostMapping("add/local-date-time/{localDateTime}")
  public void addWeckerLocalDateTime(@PathVariable("localDateTime")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  LocalDateTime localDateTime){
    createWecker(localDateTime);
  }

  @PostMapping("add/{localDateTime}")
  public void addWecker(@PathVariable("localDateTime")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
      LocalDateTime localDateTime){
    createWecker(localDateTime);
  }

  private void createWecker(LocalDateTime localDateTime){
    Wecker wecker = new Wecker();
    wecker.setDateTime(localDateTime);
    wecker.setConfig("Test");
    weckerController.add(wecker);
  }

  @GetMapping("/hallo")
  public String test(){
    return "test";
  }
}
