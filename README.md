# Associate Voting System

## Description
The Associate Voting System is a web application designed to facilitate voting among associates in a cooperative setting. It provides a platform for creating agendas, opening voting sessions, receiving votes from associates, and counting the results of the votes.

## Features
- **Agenda Management**: Create and manage agendas for discussion and voting.
- **Voting Sessions**: Open voting sessions for each agenda item.
- **Associate Voting**: Associates can vote 'Yes' or 'No' on agenda items.
- **Vote Counting**: Automatically count and display the results of votes on each agenda item.
- **Integration with External Systems**: Integrate with external systems to verify associate eligibility for voting.

## Technologies Used
- Spring Boot: For building the backend RESTful API.
- Spring Data JPA: For data access and database management.
- H2 Database: In-memory database for development and testing.
- Maven: For dependency management.
- JUnit and Mockito: For unit and integration testing. (TODO)
- Swagger UI: For API documentation. (TODO)

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/associate-voting-system.git
   ```
2. Navigate to the project directory:
   ```bash
   cd associate-voting-system
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   java -jar target/associate-voting-system.jar
   ```

## Usage
1. Access the application at [http://localhost:8080](http://localhost:8080).
2. Use the provided APIs to manage agendas, open voting sessions, and receive votes.
3. Refer to the API documentation provided by Swagger UI for detailed usage instructions.

## Contributing
Contributions are welcome! If you'd like to contribute to the project, please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and commit them to your branch.
4. Push your changes to your fork.
5. Submit a pull request to the main repository.


## Contact
For any inquiries or feedback, please contact [Gabriel Sampaio](mailto:gabrielmasampaio@gmail.com).
