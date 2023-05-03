package de.digitalcollections.lobid.model;

import java.util.List;

/** type = "DifferentiatedPerson" / "Person" */
public class LobidPerson extends LobidEntity {

  String dateOfBirth;
  String dateOfDeath;

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(List<String> dateOfBirths) {
    if (dateOfBirths == null || dateOfBirths.isEmpty()) {
      return;
    }
    this.dateOfBirth = dateOfBirths.get(0);
  }

  public String getDateOfDeath() {
    return dateOfDeath;
  }

  public void setDateOfDeath(List<String> dateOfDeaths) {
    if (dateOfDeaths == null || dateOfDeaths.isEmpty()) {
      return;
    }
    this.dateOfDeath = dateOfDeaths.get(0);
  }
}
