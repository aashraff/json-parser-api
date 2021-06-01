# JSON Parser API

## Description
A RESTful API for parsing JSON data using MVC design pattern

## DevOps
- Alpine OS
- Scala 2.13 language
- Play API MVC Framework
- SBT build
- Open JDK 8 SDK
- Docker container
- NGINX web server
- Logback logging
- Jenkins X on Kubernetes with GitOps for CI/CD
- Git VCS
- ScalaTest for Unit testing
- Scalastyle for style check 
- Postman / curl for API testing
- Auth0 for API Authentication using OAuth
- Swagger UI for API specification


## Running the project
```
Dev:
sbt "~run 9000" or sbt "run 9000"
sbt docker:stage
sbt docker:publishLocal
docker run --rm -p9000:9000 json-parser-api:1.0

Prod:
docker-compose up
```

### Testing docker
bash docker-tests.sh $PWD

### Unit Testing
sbt test


### API Testing
- Using curl
  
  ```
  curl -v -d '{"price": 3.14, "ingredients": [{"name": "naturals"}, {"name": "artifical"}]}' -H 'Content-Type: application/json' -H 'Authorization: Bearer <token>' -x POST localhost:9000/api/parse
  ```

- [Swagger UI for API specification & smoke testing](http://localhost:9000/docs/swagger-ui/index.html?url=/assets/swagger.json)
- Advanced testing: [Postman](https://web.postman.co/)

### Design principles
 - [SOLID](https://en.wikipedia.org/wiki/SOLID)
 - [12 Factor App](https://12factor.net)

## Development process
- [Secure coding practices](https://owasp.org/www-project-secure-coding-practices-quick-reference-guide/migrated_content)
- GitHub Flow
    - submit PRs from feature branch to merge to main branch
- Coding guidelines
    - [Style guide](https://docs.scala-lang.org/style/)
    - [sbt](https://www.scala-sbt.org/1.x/docs/Coding-Guideline.html)
- Documentation
    - README

## Ops process
- SLA
- Code coverage & vulnerability scanning(SonarQube ToDo)
- GitOps for SCM
    - manage environment specific properties (ToDo)
 - CI/CD(Jenkins 2/Jenkins X on Kubernetes)
 - Canary deployment (ToDo)
 - KPI tracking(Graphana) (ToDo) 
 