# JSON Parser API

## Description
An API for parsing JSON data

## Development Env & tooling
- Alpine OS
- Scala 2.13
- Play API Framework
- SBT for build
- Open JDK 8 SDK
- Docker container
- Logback
- Jenkins CI/CD
- Git VCS
- Postman / curl

## Running the project
```
Dev:
$sbt "~run 8080" or sbt "run 8080"
$sbt docker:stage
$sbt docker:publishLocal
$docker run --rm -p8080:8080 json-parser-api:1.0

Prod:
$sbt "start -Dhttp.port=8080"
```

### Testing the prject
curl localhost:9000/api/parse

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
- Code coverage & vulnerability scanning(SonarQube)
- GitOps for SCM
    - manage environment specific properties
 - CI/CD(Jenkins)
 - Blue/Green deployment
 - KPI tracking(Graphana)
 