package dev.mdz.lobid.model;

public class LobidGeometry {
  private String[] asWKT;
  private String type;

  public String[] getAsWKT() {
    return asWKT;
  }

  public String getType() {
    return type;
  }

  public void setAsWKT(String[] asWKT) {
    this.asWKT = asWKT;
  }

  public void setType(String type) {
    this.type = type;
  }
}
