# lobid.org Entityfacts API

[![Build Status](https://img.shields.io/github/actions/workflow/status/dbmdz/lobid-entityfacts-api/.github%2Fworkflows%2Fci.yml)](https://github.com/dbmdz/lobid-entityfacts-api/actions?query=branch%3Amain)
[![License](https://img.shields.io/github/license/dbmdz/lobid-entityfacts-api.svg)](LICENSE)
[![GitHub release](https://img.shields.io/github/release/dbmdz/lobid-entityfacts-api.svg)](https://github.com/dbmdz/streaming-server-euphoria/releases)
[![Maven Central Version](https://img.shields.io/maven-central/v/dev.mdz/lobid-entityfacts-api)](https://central.sonatype.com/search?q=a:lobid-entityfacts-api

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
import dev.mdz.lobid.jackson.LobidObjectMapper;
import dev.mdz.lobid.model.LobidCorporateBody;

ObjectMapper mapper = new LobidObjectMapper();
LobidCorporateBody lobidCorporateBody = mapper.readValue(new URL("https://lobid.org/gnd/2031351-2.json"), LobidCorporateBody.class);

String preferredName = lobidCorporateBody.getPreferredName();
```