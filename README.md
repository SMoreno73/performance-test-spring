# Performance Test for Spring Application
<p align="center">
<img align="center" width="400px" src="https://th.bing.com/th/id/OIP.UAKN4vN2nPv3A54PuI08fAHaEK?rs=1&pid=ImgDetMain">
</p>

## Description  
Riwi faces the challenge of improving the accuracy and effectiveness of data collection for entering new coders through its surveys. To address this issue, efficient management of user responses, questions asked, and surveys conducted is required. This system must be able to correctly relate responses to users, questions, and selected options, ensuring the integrity and coherence of the collected data.

## Endpoints

- **/api/users**: Get all users or create a new user.
- **/api/users/{id}**: Get, update, or delete a specific user.
- **/api/questions**: Get all questions or create a new question.
- **/api/questions/{id}**: Get, update, or delete a specific question.
- **/api/surveys**: Get all surveys or create a new survey.
- **/api/surveys/{id}**: Get, update, or delete a specific survey.
- **/api/responses**: Get all responses or create a new response.
- **/api/responses/{id}**: Get, update, or delete a specific response.
- **/api/options**: Get all options or create a new option.
- **/api/options/{id}**: Get, update, or delete a specific option.
- **/api/assignments**: Get all assignments or create a new assignment.
- **/api/assignments/{id}**: Get, update, or delete a specific assignment.

[**Swagger UI**](http://localhost:8080/api/v1/swagger-ui/index.html#)
## Installation

Follow these steps to install and run the FleetNav project in your local development environment:

### Prerequisites

- Java 17
- Docker

1. Clone the repository:
    ```bash
    git clone https://github.com/SMoreno73/performance-test-spring.git
    ```

2. Initialize Docker:
    ```bash
    docker-compose up -d
    ```

3. Run the project in development mode:
    ```bash
    mvn clean install
    ```

4. Access the Swagger API documentation at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

# Contact
- *Sebastian Moreno* - *Sebastianmorenoecheverri@gmail.com*

## Author
*Sebastian Moreno* <img src="https://media.giphy.com/media/v1.Y2lkPTc5MGI3NjExYnppb3EwNGU0NWY2bG1zYWJiNGtrMDdjejMzcWM3c2dzaWs2b2l2ayZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9cw/xRJinOH44eOd2/giphy.gif" width="50" height= "35" align='center'> 
