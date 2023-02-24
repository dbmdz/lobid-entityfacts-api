# lobid.org Entityfacts API

Java-Library for mapping JSON-LD of https://lobid.org/gnd Web-API to Java objects

Supported entities:

* CorporateBody (partially)

## Usage

Read data for CorporateBody from URL:

Example:

```java
import com.fasterxml.jackson.databind.ObjectMapper;
import de.digitalcollections.lobid.jackson.LobidObjectMapper;
import de.digitalcollections.lobid.model.LobidCorporateBody;

ObjectMapper mapper = new LobidObjectMapper();
LobidCorporateBody lobidCorporateBody = mapper.readValue(new URL("https://lobid.org/gnd/2031351-2.json"), LobidCorporateBody.class);
```