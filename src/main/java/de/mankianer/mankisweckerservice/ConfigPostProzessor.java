package de.mankianer.mankisweckerservice;

import java.util.stream.Stream;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Component
public class ConfigPostProzessor {

  public static final String PREFIX_CALL = "call:";

  public void run(String config){
    Stream<String> configStream = Stream.of(config.split(";"));

    configStream.filter(s -> s.startsWith(PREFIX_CALL)).forEach(this::prozessCall);
  }

  private void prozessCall(String callConfig){
    String url = callConfig.substring(PREFIX_CALL.length());
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
    log.info("Call:{}: Antwort:{}", url, response);
  }
}
