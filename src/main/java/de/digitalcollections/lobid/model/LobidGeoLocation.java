package de.digitalcollections.lobid.model;

import java.util.List;

/** type = "TerritorialCorporateBodyOrAdministrativeUnit" / "PlaceOrGeographicName" */
public class LobidGeoLocation extends LobidEntity {

  private List<LobidDepiction> depiction;
  private List<LobidHomepage> homepage;

  public List<LobidDepiction> getDepiction() {
    return depiction;
  }

  public void setDepiction(List<LobidDepiction> depiction) {
    this.depiction = depiction;
  }

  public List<LobidHomepage> getHomepage() {
    return homepage;
  }

  public void setHomepage(List<LobidHomepage> homepage) {
    this.homepage = homepage;
  }
}
