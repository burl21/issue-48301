Issue: https://github.com/spring-projects/spring-boot/issues/48301

To run the tests, you need to provide an valid issuer-uri and a token whose header contains `"typ": "at+jwt"` or, in any case, a typ value different from `jwt`.
