package org.jallen.tyrael.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jallen.tyrael.entity.Application;
import org.jallen.tyrael.entity.Message;
import org.jallen.tyrael.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ReviewerController {

  @Autowired
  private ApplicationService applicationService;

  public Map<Long, Application> getAllApplicationsByMap() {
    List<Application> applications = applicationService.findAll();
    Map<Long, Application> applicationMap = applications.stream()
      .collect(Collectors.toMap(
        Application::getId, 
        application -> application));
    List<Application> applications2 = applicationMap.values().stream().collect(Collectors.toList());
    Application[] applications3 = applications2.toArray(Application[]::new);

    Stream a = Arrays.stream(applications3); // Array
    Stream b = applications2.stream(); // Array List
    Stream c = Stream.of(applications3[0]); // Array Index of Choice
    Stream d = Stream.of(applications3); // Array

    Optional<String> testString = Optional.ofNullable("hotdog");
    String optionalParameter = testString.isPresent() ? testString.get() : "no hotdog";
    System.out.println(optionalParameter);

    Message base = (val) -> val + "Test";
    System.out.println(base.showMessage("Print"));

    Map<String, Application> map = applications.stream()
      .filter(obj -> obj.getCategory().equals("Page"))
      .collect(Collectors.toMap(
        Application::getTitle,
        obj -> obj));

    return applicationMap;
  }

  public Map<String, Application> getTitlePages() {
    List<Application> applications = applicationService.findAll();
    Map<String, Application> map = applications.stream()
    .filter(obj -> obj.getCategory().equals("Page"))
    .collect(Collectors.toMap(
      Application::getTitle,
      obj -> obj));

    return map;
  }

  public List<String> getPageList() {
    List<Application> applications = applicationService.findAll();

    List<String> pageList = applications.stream()
      .flatMap(obj -> Stream.of(new StringBuilder(obj.getTitle()).append(":").append(obj.getCategory()).toString()))
      .collect(Collectors.toList());

    return pageList;
  }

  public List<String> getPageListFromMap() {
    List<Application> applications = applicationService.findAll();
    Map<String, Application> map = applications.stream()
    .filter(obj -> obj.getCategory().equals("Page"))
    .collect(Collectors.toMap(
      Application::getTitle,
      obj -> obj));
    
    List<String> pageList = map.entrySet().stream()
    .flatMap(obj -> Stream.of(obj.getValue().getTitle()))
    .collect(Collectors.toList());

    List<String> pageList2 = map.values().stream()
    .flatMap(obj -> Stream.of(obj.getTitle()))
    .collect(Collectors.toList());

    return pageList2;
  }
  
}
