# Hotel_Review_System

The Hotel Review System is a distributed system designed to manage hotel information, user authentication, ratings, and reviews. It follows a microservices architecture, which decomposes the system into smaller, loosely coupled services that can be developed, deployed, and scaled independently. Each service is responsible for a specific domain or functionality, and they communicate with each other via HTTP or messaging protocols.

Here's an overview of the services and their responsibilities:

1.UserService: Manages user authentication, registration, and user profile information. It handles user-related operations such as user creation, login, logout, and profile updates.

2.HotelService: Handles hotel-related operations, such as retrieving hotel information and providing details about individual hotels.

3.RatingService: Manages the rating and review system for hotels. It allows users to submit ratings and reviews for hotels they have visited and retrieves aggregated ratings and reviews for each hotel.
RegistryService: This service acts as a service registry and discovery server using tools like Eureka or Consul. It maintains a registry of all available services in the system and provides service discovery capabilities to allow services to locate and communicate with each other dynamically.

4.ApiGateway: Serves as the entry point for clients to access the system. It routes incoming requests to the appropriate microservices based on the request path or other criteria. It also handles cross-cutting concerns like authentication, authorization, rate limiting, and logging.

5.ConfigServer: Manages externalized configuration for all services in the system. It centralizes configuration management, allowing configuration settings to be stored in a version-controlled repository (e.g., Git) and accessed by services at runtime. This enables dynamic configuration updates without requiring service restarts.

Regarding the choice of databases:-
MySQL: Used for storing structured data such as user profiles, hotel information, and ratings. It provides transaction support, ACID compliance, and relational data modeling capabilities.

PostgreSQL: Similar to MySQL, PostgreSQL is also used for storing structured data. It offers additional features like advanced SQL support, JSONB data type for storing JSON documents, and support for advanced indexing and querying.

MongoDB: Used for storing unstructured or semi-structured data such as user reviews or documents. MongoDB is a NoSQL database that offers high scalability, flexibility, and performance for handling large volumes of data with varying structures. It's suitable for storing user-generated content like reviews, which may have different attributes for each entry.
Overall, this architecture provides flexibility, scalability, and maintainability, allowing each service to evolve independently and enabling horizontal scaling to handle increased load. Additionally, the choice of multiple databases allows for selecting the most appropriate database technology for each type of data and use case within the system.
