package de.digitalcollections.lobid;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import de.digitalcollections.lobid.jackson.LobidObjectMapper;
import de.digitalcollections.lobid.model.LobidCorporateBody;
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
  }
}
