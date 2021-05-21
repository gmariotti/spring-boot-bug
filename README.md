# Spring Boot Bug

Refers to issue: https://github.com/spring-projects/spring-boot/issues/26627

How to run it:
- Make sure to have kind installed and create the cluster using kind-with-registry.sh
- Build the docker image with `./gradlew jibDockerBuild`
- Run the following docker commands to make the image available in the cluster
  - `docker tag spring-boot-bug:2.4.6 localhost:5000/spring-boot-bug:2.4.6`
  - `docker push localhost:5000/spring-boot-bug:2.4.6`
- Apply the k8s resources with:
  - `kubectl -f apply kubernetes/configmap`
  - `kubectl -f apply kubernetes/deployment`

To build the image for a different version of spring-boot:
- Change the `version` in the `build.gradle.kts` file
- Change the `image` tag in the `kubernetes/deployment.yaml` file
