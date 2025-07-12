# What's New with Tyrael

All notable changes to this project will be documented in this file.

# 1.5.0

## 1.5.0 Features

- `[ApplicationControllerTest]` Added comprehensive unit tests for ApplicationController.
- `[ApplicationServiceTest]` Added unit tests for ApplicationService with Mockito.
- `[EntityNotFoundException]` Added custom exception for entity not found scenarios.
- `[ExperienceRepositoryTest]` Added repository tests for Experience entity.
- `[GlobalExceptionHandler]` Added global exception handler for centralized error handling.
- `[H2 Database]` Added H2 in-memory database dependency for testing.
- `[JwtService]` Added JWT token generation and validation service.
- `[JwtServiceTest]` Added unit tests for JWT service functionality.
- `[Test Configuration]` Added separate application.properties for test environment.
- `[TyraelControllerTest]` Added unit tests for TyraelController authentication.

## 1.5.0 Fixes

- `[Controllers]` Fixed all controllers to use proper exception handling.
- `[Database]` Configured H2 database for test environment.
- `[Dependencies]` Updated test dependencies to use MockitoBean instead of deprecated MockBean.
- `[README]` Added comprehensive testing documentation and commands.
- `[Security]` Updated security configuration to allow /login endpoint access.
- `[SkillService]` Renamed SkillServices to SkillService for consistency.
- `[Tests]` Fixed test configurations to work with Spring Boot 3.4.

# 1.4.0

## 1.4.0 Features

- `[AboutMapper]` Added mapper implementing BaseMapper for About entity.
- `[BaseMapper]` Added interface BaseMapper to streamline mapping operations.
- `[InformationMapper]` Added mapper implementing BaseMapper for Information entity.
- `[Login]` Added Login entity for authentication purposes.
- `[Message]` Added Message functional interface for message handling.
- `[SkillMapper]` Added mapper implementing BaseMapper for Skill entity.
- `[TyraelSecurity]` Added security configuration with Spring Security.
- `[WorkMapper]` Added mapper implementing BaseMapper for Work entity.

## 1.4.0 Fixes

- `[Mapper]` Standardized mapping operations across all entities.
- `[Security]` Configured CSRF protection and HTTP authorization.

# 1.3.0

## 1.3.0 Features

- `[ApplicationController]` Added interface BaseController to streamline main endpoints.
- `[ApplicationService]` Added interface BaseService to streamline main services.
- `[TyraelController]` Added temporary login endpoint.
- `[WorkController]` Added interface BaseController to streamline main endpoints.
- `[WorkService]` Added interface BaseService to streamline main services.

## 1.3.0 Fixes

- `[Application]` Added priority column for sorting.

# 1.2.0

## 1.2.0 Features

- `[About]` Added About entity.
- `[AboutController]` Added controller for About entity.
- `[AboutRepository]` Added repository for About entity.
- `[AboutService]` Added service for About entity.
- `[Experience]` Added Experiences entity.
- `[ExperienceController]` Added controller for Experience entity.
- `[ExperienceMapper]` Added experience mapper for mapping purposes.
- `[ExperienceRepository]` Added repository for Experience entity.
- `[ExperienceService]` Added controller for Experience entity.
- `[Information]` Added Information entity.
- `[InformationController]` Added controller for Information entity.
- `[InformationRepository]` Added repository for Information entity.
- `[InformationService]` Added service for Information entity.
- `[Skills]` Added Skills entity.
- `[SkillsController]` Added controller for Skills entity.
- `[SkillsRepository]` Added repository for Skills entity.
- `[SkillsService]` Added service for Skills entity.
- `[Work]` Added Work entity.
- `[WorkController]` Added controller for Work entity.
- `[WorkRepository]` Added repository for Work entity.
- `[WorkService]` Added service for Work entity.

## 1.2.0 Fixes

- `[Application]` Added site property and updated link to repository property.
- `[Controller]` Code cleanup for all controllers.
- `[Entity]` Code cleanup for all entities.
- `[Repository]` Code cleanup for all repositories.
- `[Service]` Code cleanup for all services.

# 1.1.0

## 1.1.0 Features

- `[ApplicationController]` Added web service /pages.
- `[ApplicationMapper]` Added mapper for Application.
- `[ReviewController]` Added controller for review purposes.

# 1.0.0

## 1.0.0 Features

- `[Application]` Added entity representation for application table.
- `[ApplicationController]` Added controller for Application entity.
- `[ApplicationRepository]` Added repository connector for application.
- `[ApplicationService]` Added service for application repository.
- `[TyraelApplication]` Added Tyrael main application starter.
- `[TyraelController]` Added main tyrael controller for rest web page.

## 1.0.0 Fixes

- `[TyraelApplication]` Enabled cross origin for all endpoints.
