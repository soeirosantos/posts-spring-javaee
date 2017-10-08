# posts-spring-javaee

This application shows how we can use an Spring application abstracted by the Java EE specification.

For a complete discussion, please see: http://todevornot.com/post/166191378764/an-example-of-spring-application-using-the-java-ee

## Running

```bash
$ gradle clean build && java -jar build/libs/posts-0.0.1-SNAPSHOT.jar
```

Try:

```bash
$ curl -i -X POST -H "Content-Type: application/json" -d '{"title": "my post", "content":"content...", "publishDate": "2017-10-08T12:36:04", "author": "john doe"}' "http://localhost:8080/posts"
$ curl -i -X GET -H "Content-Type: application/json" "http://localhost:8080/posts"
```