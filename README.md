# Circuit Breaker with Spring Boot

This project demonstrates the implementation of a Circuit Breaker pattern using Resilience4j in a Spring Boot application. The application fetches country information from the Restcountries API and gracefully handles failures using a Circuit Breaker.

## Prerequisites

- Java installed
- Spring Boot installed
- Maven installed

## Getting started 
1. Clone the repository:

```bash
git clone https://github.com/your-username/circuit-breaker-spring-boot.git
```
2. Navigate to the project directory:

```bash
cd circuit-breaker-spring-boot
```
3. Build the project:

```bash
mvn clean install
```
4. Run the application:

```bash
java -jar target/circuit-breker-0.0.1-SNAPSHOT.jar
```


## Usage   
Once the application is running, you can access the API to get country information by capital:
```bash
GET http://localhost:8080/country/{capital}
```
## Configuration
The Circuit Breaker configuration can be adjusted in the application.properties file.

```bash
# Resilience4j Circuit Breaker Configuration
resilience4j.circuitbreaker.instances.countryByCapital.failureRateThreshold=50
resilience4j.circuitbreaker.instances.countryByCapital.slowCallRateThreshold=50
resilience4j.circuitbreaker.instances.countryByCapital.slidingWindowSize=100
# Add more configuration properties as needed
```

## Fallback Mechanism
In case of a failure, the application uses a fallback mechanism to return an empty list of countries. The fallback method is defined in the CountryController class.

```bash
public List<Country> fallBackCountry(String capital, Throwable throwable) {
    return Collections.emptyList();
}
```
