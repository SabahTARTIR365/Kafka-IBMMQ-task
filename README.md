# Payment Processor Mock-Up App
Overview
The Payment Processor Mock-Up App is a demonstration application designed to simulate the handling of payment messages. It supports two types of messages: XML and JSON, and it utilizes modern message queue and serialization techniques.

# Features
* Message Acceptance: The application accepts messages in two formats: XML and JSON, via two POST requests.
* Message Handling: Messages are sent through Kafka and consumed by the Message Queue (MQ).
* Serialization and Deserialization: The application performs serialization and deserialization of messages.
* Design Patterns: Utilizes the Strategy Pattern for deserialization of JSON and XML messages.
  
# Usage
POST Requests
* XML Message

Endpoint: /post/xml
Content-Type: application/xml
Body: XML formatted message

* JSON Message
  Endpoint: /post/json
 Content-Type: application/json
 Body: JSON formatted message

# Message Flow
* Sending Messages
* Messages are sent to Kafka.
* Consuming Messages
* Messages are consumed by the MQ.
# Serialization/Deserialization
Strategy Pattern: The app uses the Strategy Pattern to handle deserialization for both JSON and XML messages, ensuring a flexible and scalable approach.

