package dev.mdz.lobid.model;

public class LobidEntity {

  protected String gndIdentifier;

  protected String preferredName;

  protected String[] type;

  public String getGndIdentifier() {
    return gndIdentifier;
  }

  public String getPreferredName() {
    return preferredName;
  }

  public String[] getType() {
    return type;
  }

  public void setGndIdentifier(String gndIdentifier) {
    this.gndIdentifier = gndIdentifier;
  }

  public void setPreferredName(String preferredName) {
    this.preferredName = preferredName;
  }

  public void setType(String[] type) {
    this.type = type;
  }
}
