FROM icr.io/appcafe/open-liberty:kernel-slim-java8-openj9-ubi

ARG VERSION=1.0
ARG REVISION=SNAPSHOT

LABEL \
  org.opencontainers.image.authors="Frik Briers" \
  org.opencontainers.image.vendor="Novadoc" \
  org.opencontainers.image.url="local" \
  org.opencontainers.image.source="https://github.com/eposide/liberty-echo" \
  org.opencontainers.image.version="$VERSION" \
  org.opencontainers.image.revision="$REVISION" \
  vendor="Novadoc" \
  name="echo" \
  version="$VERSION-$REVISION" \
  summary="The echo liberty microservice " \
  description="This image contains the echo microservice running with the Open Liberty runtime on Java11"

# Eclipse JKube's default assembly name, files are packaged under this folder:
ARG JKUBE_DEFAULT_ASSEMBLY=maven
COPY --chown=1001:0 $JKUBE_DEFAULT_ASSEMBLY/src/main/liberty/config/ /config/
COPY --chown=1001:0 $JKUBE_DEFAULT_ASSEMBLY/target/*.war /config/apps/

# Expose Ports
EXPOSE 9080
EXPOSE 9443

RUN configure.sh