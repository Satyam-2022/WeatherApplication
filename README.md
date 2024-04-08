# Weather Application

This is a simple weather application developed using Spring Boot and Thymeleaf. It allows users to retrieve weather information for a specific city.
Added some excepction if customer enter non-city name.

## Prerequisites

Before running the application, ensure you have the following installed:

- Java Development Kit (JDK) version 8 or higher
- Maven
- Git

## Installation

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/satyam-2022/weather-application.git
    ```

2. Navigate to the project directory:

    ```bash
    cd weather-application
    ```

3. Open the `application.properties` file located in the `src/main/resources` directory.

4. Insert your API key in the `application.properties` file:

    ```properties
    # OpenWeatherMap API key
    openweathermap.api.key=YOUR_API_KEY_HERE
    ```

    Replace `YOUR_API_KEY_HERE` with your actual API key obtained from OpenWeatherMap.

5. Save the changes to the `application.properties` file.

## Running the Application

To run the application locally, execute the following Maven command in the project directory:

```bash
mvn spring-boot:run
