package dev.mdz.lobid.model;

import java.util.List;

/** type = "CorporateBody" */
public class LobidCorporateBody extends LobidEntity {

  private List<String> abbreviatedNameForTheCorporateBody;
  private List<LobidDepiction> depiction;
  private List<LobidHomepage> homepage;

  public List<String> getAbbreviatedNameForTheCorporateBody() {
    return abbreviatedNameForTheCorporateBody;
  }

  public void setAbbreviatedNameForTheCorporateBody(
      List<String> abbreviatedNameForTheCorporateBody) {
    this.abbreviatedNameForTheCorporateBody = abbreviatedNameForTheCorporateBody;
  }

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
