package org.jallen.tyrael.mapper;

public class ExperienceMapper {
  
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
