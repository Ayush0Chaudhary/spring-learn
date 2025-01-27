# spring-learn

## Setup Guide

### 2. Clone the Repository

If you haven't already cloned the repository, use the following command:

```sh
git clone https://github.com/Ayush0Chaudhary/spring-learn.git
cd triomics
```

### 3. Configure the Environment

#### Set Up the Database:

1. Create a database for the project (e.g., triomics).
2. Update the database configuration in `src/main/resources/application.properties`. Example:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/triomics
    spring.datasource.username=<your-database-username>
    spring.datasource.password=<your-database-password>
    spring.jpa.hibernate.ddl-auto=update
    ```
    Keep the other variable as it is

#### Set Up Logging:

The application uses Log4j2. Ensure the `log4j2.xml` file in `src/main/resources` is configured correctly.

### 4. Build the Project

Use Maven to build the project:

```sh
./mvnw clean package
```

### 5. Run the Application

To start the Spring Boot application:

```sh
java -DlogPattern=logPatternJson -jar target/triomics-0.0.1-SNAPSHOT.jar
```
### Log Pattern Configuration

The `-DlogPattern` option allows you to specify the logging pattern for the application. Here are the available options and their defaults:
- `logPatternMinimal`: This pattern logs only the message. The default pattern is:
    ```sh
    %m%n
    ```
    This will log only the log message.

- `logPatternSimple`: This pattern logs the timestamp, log level, and message. The default pattern is:
    ```sh
    %d{yyyy-MM-dd HH:mm:ss} [%p] %m%n
    ```
    This will log the date, time, log level, and the log message.

- `logPatternVerbose`: This pattern logs the timestamp, log level, logger name, file name, line number, and message. The default pattern is:
    ```sh
    %d{yyyy-MM-dd HH:mm:ss} [%p] [%c{1.}] [%F:%L] %m%n
    ```
    This will log the date, time, log level, logger name, file name, line number, and the log message.

- `logPatternJson`: This pattern logs in JSON format. The default pattern is:
    ```sh
    {
        "timestamp": "%d{yyyy-MM-dd'T'HH:mm:ss.SSSZ}",
        "message": "%m",
        "level": "%p",
        "package": "%c{1.}",
        "file": "%F",
        "line": "%L",
        "traceId": "%X{traceId}",
        "stackTrace": "%ex{full}"
    }
    ```
    This will log the date, time, log level, package name, file name, line number, trace ID, and stack trace in JSON format.

You can specify any of these patterns when starting the application. For example, to use the JSON log pattern, you would start the application with:

```sh
java -DlogPattern=logPatternJson -jar target/triomics-0.0.1-SNAPSHOT.jar
```

### 6. Access the Application

- Base URL: `http://localhost:8080`
- API Endpoints:
    - `POST /api/v1/persons` - Create a new person
    - `GET /api/v1/persons` - Retrieve all persons
    - `GET /api/v1/persons/{id}` - Retrieve a person by ID
    - `PUT /api/v1/persons/{id}` - Update a person by ID
    - `DELETE /api/v1/persons/{id}` - Delete a person by ID

### 7. Run Tests

To run unit tests and ensure everything is working:

```sh
./mvnw test
```

