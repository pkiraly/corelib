# Europeana CoreLib

[![Build Status](https://travis-ci.org/europeana/corelib.svg?branch=master)](https://travis-ci.org/europeana/corelib)[![Coverage Status](https://coveralls.io/repos/europeana/corelib/badge.svg?branch=master&service=github)](https://coveralls.io/github/europeana/corelib?branch=master)

The CoreLib repository contains the libraries that provide the underlying functionality (i.e. search and ingestion)
for both the [Portal](https://github.com/europeana/portal/) and [API](https://github.com/europeana/api2/).

## Build requirements
### Runtime
* Java version "1.8.0_66-internal", OpenJDK Runtime Environment (build 1.8.0_66-internal-b17)

or

* Java version "1.8.0_72", Oracle Java(TM) SE Runtime Environment (build 1.8.0_72-b15)

### Tools
* Maven v3.3.3

## Build
``mvn clean install`` (add ``-DskipTests``) to skip the unit tests during build

## Create empty database
``mvn hibernate4:export`` in corelib-db module to create a database schema script

### Known issues
Note: there are a number of older/outdated libraries still being referenced as dependencies, some of which may not
be provided anymore by the central repositories. The Europeana artifactory has a copy of these dependencies; add this
repository as a mirror (to the ``<mirrors>`` section of the maven settings file, usually found in ~/.m2/settings) to
successfully build the code
