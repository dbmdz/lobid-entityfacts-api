# lobid.org Entityfacts API

Java-Library for mapping JSON-LD of https://lobid.org/gnd Web-API to Java objects

Supported entities:

* CorporateBody (partially) (type = "CorporateBody")
* Event (partially) (type = "HistoricSingleEventOrEra")
* GeoLocation (partially) (type = "TerritorialCorporateBodyOrAdministrativeUnit" / "PlaceOrGeographicName")
* Person (partially) (type = "DifferentiatedPerson" / "Person")
* Subject (partially) (type = "SubjectHeading" / "SubjectHeadingSensoStricto")
* Work (partially) (type = "Work")

## Usage

Example: Read data for CorporateBody from URL:

```java
import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.lobid.jackson.LobidObjectMapper;
import de.digitalcollections.lobid.model.LobidCorporateBody;

ObjectMapper mapper = new LobidObjectMapper();
LobidCorporateBody lobidCorporateBody = mapper.readValue(new URL("https://lobid.org/gnd/2031351-2.json"), LobidCorporateBody.class);

String preferredName = lobidCorporateBody.getPreferredName();
```