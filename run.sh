#!/bin/bash
gradle --stop
gradle build --continuous --quiet &
gradle bootRun