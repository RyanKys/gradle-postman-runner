# gradle-postman-runner

A gradle plugin to run [Postman](https://www.getpostman.com/) collections.

The runner makes use of [newman](https://github.com/postmanlabs/newman) run by [gradle-node-plugin](https://github.com/srs/gradle-node-plugin).

By default, all postman collection files (ending with `.postman_collection.json`) in `src/test` are run.

#### Usage

###### Configure your gradle file

```
// postmanrunner is not available in a common repository right now
// maybe you want to use jitpack to check out master directly?
buildscript {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
    dependencies {
        classpath 'com.github.simomat:gradle-postman-runner:0.0.1'
    }
}


apply plugin: 'postmanrunner'

// configure gradle-node-plugin
// at least download has to be enabled as of version 0.13
// see gradle-node-plugin documentation for more options
node {
   download = true
}

// postmanrunner configuration
postman {
    // optional: specify collection file pattern
    // default: src/test/**/*.postman_collection.json
    collections = fileTree(dir: 'src/test', include: '**/*.myCollection*')
    
    // optional: specify the test environment to execute the collections with
    // default: no environment
    environment = file('src/test/some_environment.postman_environment.json')

    // optional: report to stdout
    // default: true
    cliReport = false
    
    // optional: create junit compatible XML result files in directory
    // default: off
    xmlReportDir = 'build/testoutput'
    
    // optional: stop entire execution on first failing test in a collection
    // default: false
    stopOnError = true
}

```

###### Apply the task

```
gradle postman
```


#### Things to be done
- [x] more configure options
- [x] more result processing
- [ ] parallel execution
