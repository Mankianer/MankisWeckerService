package de.mankianer.mankisweckerservice;

import de.mankianer.mankisweckerservice.models.Wecker;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class WeckerController {

  @Autowired
  private WeckerRepo weckerRepo;

  @Autowired
  private ThreadPoolTaskScheduler threadPoolTaskScheduler;

  @Autowired
  private ConfigPostProzessor configPostProzessor;

  @PostConstruct
  public void intit(){
    weckerRepo.findAll().forEach(wecker -> set(wecker));

  }

  private void set(Wecker wecker){
    log.info("Wecker für {} mit Config[{}] ", wecker.getDateTime(), wecker.getConfig());
    if(wecker.getDateTime().isAfter(LocalDateTime.now())){
      Timestamp timestamp = Timestamp.valueOf(wecker.getDateTime());
      threadPoolTaskScheduler.schedule(() -> onAlert(wecker), new Date(timestamp.getTime()));
    }else {
      onAlert(wecker);
    }
  }

  public Wecker add(Wecker wecker){
    Wecker save = weckerRepo.save(wecker);
    set(wecker);
    return save;
  }

  public void onAlert(Wecker wecker){
    log.info("Alarm! {} Config[{}] ", wecker.getDateTime(), wecker.getConfig());
    weckerRepo.delete(wecker);
    configPostProzessor.run(wecker.getConfig());
  }
}
