package de.digitalcollections.lobid;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import de.digitalcollections.lobid.jackson.LobidObjectMapper;
import de.digitalcollections.lobid.model.LobidCorporateBody;
import de.digitalcollections.lobid.model.LobidEvent;
import de.digitalcollections.lobid.model.LobidGeoLocation;
import de.digitalcollections.lobid.model.LobidPerson;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExternalTest {
  private ObjectMapper mapper;

  @BeforeEach
  public void setup() {
    this.mapper = new LobidObjectMapper();
  }

  private <T> T readFromResources(String filename, Class<T> clz) throws IOException {
    return mapper.readValue(Resources.getResource(filename), clz);
  }

  @Test
  public void testLobidCorporateBody() throws IOException {
    LobidCorporateBody corporateBody =
        readFromResources("lobid-CorporateBody-bsb-2031351-2.json", LobidCorporateBody.class);
    assertThat(
        corporateBody.getAbbreviatedNameForTheCorporateBody().containsAll(List.of("BSB", "BSBM")));

    // Depiction
    assertThat(corporateBody.getDepiction().get(0).getId())
        .isEqualTo(
            "https://commons.wikimedia.org/wiki/Special:FilePath/Bayerische%20Staatsbibliothek%20logo.svg");
    assertThat(corporateBody.getDepiction().get(0).getThumbnail())
        .isEqualTo(
            "https://commons.wikimedia.org/wiki/Special:FilePath/Bayerische%20Staatsbibliothek%20logo.svg?width=270");
    assertThat(corporateBody.getDepiction().get(0).getUrl())
        .isEqualTo(
            "https://commons.wikimedia.org/wiki/File:Bayerische%20Staatsbibliothek%20logo.svg?uselang=de");

    assertThat(corporateBody.getGndIdentifier()).isEqualTo("2031351-2");

    // Homepage
    assertThat(corporateBody.getHomepage().get(0).getId()).isEqualTo("https://www.bsb-muenchen.de");
    assertThat(corporateBody.getHomepage().get(0).getLabel())
        .isEqualTo("https://www.bsb-muenchen.de");

    assertThat(corporateBody.getPreferredName()).isEqualTo("Bayerische Staatsbibliothek");

    assertThat(corporateBody.getType())
        .containsExactlyInAnyOrder("CorporateBody", "AuthorityResource");
  }

  @Test
  public void testLobidGeoLocation() throws IOException {
    LobidGeoLocation geoLocation =
        readFromResources("lobid-GeoLocation-Straubing-4057970-0.json", LobidGeoLocation.class);
    // Depiction
    assertThat(geoLocation.getDepiction().get(0).getId())
        .isEqualTo(
            "https://commons.wikimedia.org/wiki/Special:FilePath/Straubinger%20Stadtbild.jpg");
    assertThat(geoLocation.getDepiction().get(0).getThumbnail())
        .isEqualTo(
            "https://commons.wikimedia.org/wiki/Special:FilePath/Straubinger%20Stadtbild.jpg?width=270");
    assertThat(geoLocation.getDepiction().get(0).getUrl())
        .isEqualTo(
            "https://commons.wikimedia.org/wiki/File:Straubinger%20Stadtbild.jpg?uselang=de");

    assertThat(geoLocation.getGndIdentifier()).isEqualTo("4057970-0");

    // Homepage
    assertThat(geoLocation.getHomepage().get(0).getId()).isEqualTo("http://www.straubing.de");
    assertThat(geoLocation.getHomepage().get(0).getLabel()).isEqualTo("http://www.straubing.de");

    assertThat(geoLocation.getPreferredName()).isEqualTo("Straubing");

    assertThat(geoLocation.getType())
        .containsExactlyInAnyOrder(
            "TerritorialCorporateBodyOrAdministrativeUnit",
            "PlaceOrGeographicName",
            "AuthorityResource");
  }

  @Test
  public void testLobidEvent() throws IOException {
    LobidEvent event =
        readFromResources("lobid-Event-30jaehrigerKrieg-4012985-8.json", LobidEvent.class);
    assertThat(event.getGndIdentifier()).isEqualTo("4012985-8");
    assertThat(event.getPreferredName()).isEqualTo("Dreißigjähriger Krieg");

    assertThat(event.getType())
        .containsExactlyInAnyOrder(
            "HistoricSingleEventOrEra", "SubjectHeading", "AuthorityResource");
  }

  @Test
  public void testLobidPerson() throws IOException {
    LobidPerson person = readFromResources("lobid-Person-Goethe-118540238.json", LobidPerson.class);
    assertThat(person.getGndIdentifier()).isEqualTo("118540238");
    assertThat(person.getPreferredName()).isEqualTo("Goethe, Johann Wolfgang von");

    assertThat(person.getType())
        .containsExactlyInAnyOrder("AuthorityResource", "DifferentiatedPerson", "Person");
  }

  @Test
  public void testLobidSubject() throws IOException {
    LobidEvent subject =
        readFromResources("lobid-Subject-Handschrift-4023287-6.json", LobidEvent.class);
    assertThat(subject.getGndIdentifier()).isEqualTo("4023287-6");
    assertThat(subject.getPreferredName()).isEqualTo("Handschrift");

    assertThat(subject.getType())
        .containsExactlyInAnyOrder(
            "AuthorityResource", "SubjectHeadingSensoStricto", "SubjectHeading");
  }
}
