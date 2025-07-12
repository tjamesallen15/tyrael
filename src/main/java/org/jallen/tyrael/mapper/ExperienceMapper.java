package org.jallen.tyrael.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.jallen.tyrael.base.BaseMapper;
import org.jallen.tyrael.entity.Experience;
import org.springframework.stereotype.Component;

@Component
public class ExperienceMapper implements BaseMapper<Experience> {

  @Override
  public List<Experience> getMapping(List<Experience> obj) {
    return obj.stream()
      .peek(exp -> 
        exp.setTotal(this.transformTotal(exp.getDuration(), exp.getTotal()))
      )
      .collect(Collectors.toList());
  }

  @Override
  public Experience getMapping(Experience origin, Experience obj) {
    if (obj == null) return origin;

    origin.setCompany(obj.getCompany());
    origin.setDescription(obj.getDescription());
    origin.setDuration(obj.getDuration());
    origin.setLocation(obj.getLocation());
    origin.setPosition(obj.getPosition());
    origin.setTotal(obj.getTotal());

    return origin;
  }

  public String transformTotal(String duration, String total) {
    String[] totalParts = total.split("\\.");
    StringBuilder totalBuilder = new StringBuilder();

    for (String str : totalParts) {
      System.out.print(str + ", ");
    }

    // Years
    if (!totalParts[0].equals("0")) {
      totalBuilder.append(totalParts[0]);
      totalBuilder.append(" year(s)");  
    }

    // Months
    if (!totalParts[1].equals("0")) {
      totalBuilder.append(" ");
      totalBuilder.append(totalParts[1]);
      totalBuilder.append(" month(s)"); 
    }

    if (duration.contains("Present")) {
      totalBuilder.append(" counting");
    }

    return totalBuilder.toString();
  }
}
