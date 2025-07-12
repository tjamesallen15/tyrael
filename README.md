# Tyrael

It is a modern REST API server built with Java 17 and Spring Boot 3.4, featuring PostgreSQL database integration. It includes complete create, read, update, and delete functionality for James Allen's applications, highlighting his development expertise.

## Tech Stack

- **Java 17** - Latest LTS version
- **Spring Boot 3.4** - Modern framework with native compilation support
- **PostgreSQL** - Production-ready relational database
- **Spring Security 6** - Enterprise-grade authentication and authorization
- **Spring Data JPA** - Simplified data access layer
- **Lombok** - Reduced boilerplate code
- **Maven** - Dependency management and build automation

## Features

- RESTful API endpoints
- Database persistence with JPA/Hibernate
- Security with JWT authentication
- Actuator endpoints for monitoring
- Development tools integration
- Production-ready configuration

## Quick Start

```bash
# Clone the repository
git clone <repository-url>
cd tyrael

# Run with Maven
./mvnw spring-boot:run

# Or build and run JAR
./mvnw clean package
java -jar target/tyrael-1.4.0-SNAPSHOT.jar
```

## API Documentation

Once running, access:

- Application: `http://localhost:8080`
- Health Check: `http://localhost:8080/actuator/health`

## Members

Listed below are the contributors for this project.

- James Allen Tadique
- Genessa Nepomuceno-Tadique

# Project Rules

Contributors need to follow listed rules to ensure a more clean and readable project.

## Branching

The branch names is essential and important in project development. Branch name represents on what section the contributors are working on.

### Branch Development

Branch naming for development is labeled by **lastname-dev**. This will represent who is the contributor for the development. **(Ex. doe-dev)**

### Branch Issue

Branch naming for issues are labeled by **issue_id** This will represent the fixed or patch for the issue to be resolved. **(Ex. 1 - Blocker on Dashboard)**

### Issues

Issues are either bugs, enhancements or development for the project. Always make an appropriate title that best describes the issue.

Steps:

- Create a new issue.
- Make a approriate title for the issue
- Assign it to the developer.
- Assign appropriate milestone and label for the merge request.
- Submit the issue.

## Development

### Prerequisites

- Java 17 or higher
- Maven 3.6+
- PostgreSQL 12+

### Environment Setup

1. Configure database connection in `application.properties`
2. Install dependencies: `./mvnw clean install`
3. Run tests: `./mvnw test`
4. Start development server: `./mvnw spring-boot:run`

### Code Style

- Follow Java naming conventions
- Use Lombok annotations to reduce boilerplate
- Write meaningful commit messages
- Include unit tests for new features

## Testing

The project includes comprehensive unit tests for controllers and services.

### Running Tests

```bash
# Run all tests
./mvnw test

# Run specific test classes
./mvnw test -Dtest=ApplicationControllerTest,ApplicationServiceTest

# Run tests by package
./mvnw test -Dtest=org.jallen.tyrael.controller.*
./mvnw test -Dtest=org.jallen.tyrael.services.*
```

### Test Coverage

- **Controller Tests**: Web layer testing with MockMvc
- **Service Tests**: Business logic testing with Mockito
- **Repository Tests**: Data layer testing with @DataJpaTest
- **Integration Tests**: Full application context testing

### Test Configuration

- Uses H2 in-memory database for tests
- Security disabled for controller tests
- Mocked dependencies for unit tests

# Contributing

When contributing to this repository, please first discuss the change you wish to make via issue,
email, or any other method with the owners of this repository before making a change.

Please note we have a code of conduct, please follow it in all your interactions with the project.

## Code of Conduct

### Our Pledge

In the interest of fostering an open and welcoming environment, we as
contributors and maintainers pledge to making participation in our project and
our community a harassment-free experience for everyone, regardless of age, body
size, disability, ethnicity, gender identity and expression, level of experience,
nationality, personal appearance, race, religion, or sexual identity and
orientation.

### Our Standards

Examples of behavior that contributes to creating a positive environment
include:

- Using welcoming and inclusive language
- Being respectful of differing viewpoints and experiences
- Gracefully accepting constructive criticism
- Focusing on what is best for the community
- Showing empathy towards other community members

Examples of unacceptable behavior by participants include:

- The use of sexualized language or imagery and unwelcome sexual attention or
  advances
- Trolling, insulting/derogatory comments, and personal or political attacks
- Public or private harassment
- Publishing others' private information, such as a physical or electronic
  address, without explicit permission
- Other conduct which could reasonably be considered inappropriate in a
  professional setting

### Our Responsibilities

Project maintainers are responsible for clarifying the standards of acceptable
behavior and are expected to take appropriate and fair corrective action in
response to any instances of unacceptable behavior.

Project maintainers have the right and responsibility to remove, edit, or
reject comments, commits, code, wiki edits, issues, and other contributions
that are not aligned to this Code of Conduct, or to ban temporarily or
permanently any contributor for other behaviors that they deem inappropriate,
threatening, offensive, or harmful.

### Scope

This Code of Conduct applies both within project spaces and in public spaces
when an individual is representing the project or its community. Examples of
representing a project or community include using an official project e-mail
address, posting via an official social media account, or acting as an appointed
representative at an online or offline event. Representation of a project may be
further defined and clarified by project maintainers.

### Enforcement

Instances of abusive, harassing, or otherwise unacceptable behavior may be
reported by contacting the project team at [INSERT EMAIL ADDRESS]. All
complaints will be reviewed and investigated and will result in a response that
is deemed necessary and appropriate to the circumstances. The project team is
obligated to maintain confidentiality with regard to the reporter of an incident.
Further details of specific enforcement policies may be posted separately.

Project maintainers who do not follow or enforce the Code of Conduct in good
faith may face temporary or permanent repercussions as determined by other
members of the project's leadership.

### Attribution

This Code of Conduct is adapted from the [Contributor Covenant][homepage], version 1.4,
available at [http://contributor-covenant.org/version/1/4][version]

[homepage]: http://contributor-covenant.org
[version]: http://contributor-covenant.org/version/1/4/

# License

Copyright (c) 2020-present TeamAei

This software are licensed as follows:

- It is for exclusive use only for TeamAei.
- All of the files inside are confidential.
- It is not intended for distribution and should not be sold.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
