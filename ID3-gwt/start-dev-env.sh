#!/bin/bash
# @author sp

set -e

mvn clean compile package gwt:run -P"development" -Dalt.build.dir=target/ -DskipTests
