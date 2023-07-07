Derived from an openliberty starter and a jkube quickstart

https://github.com/eclipse/jkube/tree/master/quickstarts/maven/openliberty-microprofile/

When using openshift you would need to authenticate using a token that you got from
OpenShift using your credentials.

e.g.
oc login --token=sha256~PbxvogsimWXyMCJMYJC9dybUmRxa3-S6ouadGz7d_mc --server=https://api.ocp.yourinstance.com:6443

to build and deploy

# Kubernetes
$ mvn clean package -Pkubernetes k8s:deploy
# OpenShift
$ mvn clean package -Popenshift oc:deploy
```

To alter deployment configuration you can edit the following file:
 src/main/jkube/deployment.yml

