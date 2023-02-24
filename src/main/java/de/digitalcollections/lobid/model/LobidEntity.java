package de.digitalcollections.lobid.model;

class LobidEntity {

  protected String gndIdentifier;

  protected String preferredName;

  public String getGndIdentifier() {
    return gndIdentifier;
  }

  public void setGndIdentifier(String gndIdentifier) {
    this.gndIdentifier = gndIdentifier;
  }

  public String getPreferredName() {
    return preferredName;
  }

  public void setPreferredName(String preferredName) {
    this.preferredName = preferredName;
  }
}
