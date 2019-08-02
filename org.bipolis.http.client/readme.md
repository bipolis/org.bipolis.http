# org.bipolis.http.client

The http.client - Project

## Source Repository

**Browse**: [https://github.com/bipolis/org.bipolis.http/org.bipolis.http.client](https://github.com/bipolis/org.bipolis.http/org.bipolis.http.client).

**Clone**: [scm:git:https://github.com/bipolis/org.bipolis.git/org.bipolis.http.client](scm:git:https://github.com/bipolis/org.bipolis.git/org.bipolis.http.client).

## Coordinates

### Maven

```xml
<dependency>
    <groupId>org.bipolis</groupId>
    <artifactId>org.bipolis.http.client</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

### OSGi

```
Bundle Symbolic Name: org.bipolis.http.client
Version             : 0.0.1.201907232134
```

## Components

### org.bipolis.http.client.OsgiHttpClientBuilder - *state = enabled, activation = delayed*

#### Services - *scope = singleton*

|Interface name |
|--- |
|java.net.http.HttpClient$Builder |

#### Properties

|Name |Type |Value |
|--- |--- |--- |
|basicAuth.password |String |"" |
|c |String |"DISPLAY" |
|basicAuth.enable |Boolean |false |
|followRedirects |String |"NORMAL" |
|timeoutMs |Long |-1 |
|y |String |"A" |
|proxy.basicAuth.enable |Boolean |false |
|proxy.enable |Boolean |false |
|version |String |"HTTP_2" |

#### Configuration - *policy = require*

##### Factory Pid: `org.bipolis.http.client.OsgiHttpClientBuilder`

|Attribute |Value |
|--- |--- |
|Id |`basicAuth.enable` |
|Required |**true** |
|Type |**Boolean** |
|Default |false |

|Attribute |Value |
|--- |--- |
|Id |`basicAuth.password` |
|Required |**true** |
|Type |**String** |
|Default |"" |

|Attribute |Value |
|--- |--- |
|Id |`basicAuth.user` |
|Required |**true** |
|Type |**String** |

|Attribute |Value |
|--- |--- |
|Id |`c` |
|Required |**true** |
|Type |**String** |
|Default |"DISPLAY" |
|Value range |"DISPLAY", "FORMAT" |

|Attribute |Value |
|--- |--- |
|Id |`followRedirects` |
|Required |**true** |
|Type |**String** |
|Default |"NORMAL" |
|Value range |"NEVER", "ALWAYS", "NORMAL" |

|Attribute |Value |
|--- |--- |
|Id |`proxy.basicAuth.enable` |
|Required |**true** |
|Type |**Boolean** |
|Default |false |

|Attribute |Value |
|--- |--- |
|Id |`proxy.enable` |
|Required |**true** |
|Type |**Boolean** |
|Default |false |

|Attribute |Value |
|--- |--- |
|Id |`proxy.password` |
|Required |**true** |
|Type |**String** |

|Attribute |Value |
|--- |--- |
|Id |`proxy.port` |
|Required |**true** |
|Type |**Integer** |

|Attribute |Value |
|--- |--- |
|Id |`proxy.server` |
|Required |**true** |
|Type |**String** |

|Attribute |Value |
|--- |--- |
|Id |`proxy.user` |
|Required |**true** |
|Type |**String** |

|Attribute |Value |
|--- |--- |
|Id |`timeoutMs` |
|Required |**true** |
|Type |**Long** |
|Default |-1 |

|Attribute |Value |
|--- |--- |
|Id |`version` |
|Required |**true** |
|Type |**String** |
|Default |"HTTP_2" |
|Value range |"HTTP_1_1", "HTTP_2" |

|Attribute |Value |
|--- |--- |
|Id |`y` |
|Required |**true** |
|Type |**String** |
|Default |"A" |
|Value range |"A", "B" |

---

### org.bipolis.http.client.DefaultOsgiHttpClientBuilder - *state = enabled, activation = delayed*

#### Services - *scope = singleton*

|Interface name |
|--- |
|java.net.http.HttpClient$Builder |

#### Properties

|Name |Type |Value |
|--- |--- |--- |
|osgi.http.client.name |String |".default" |

#### Configuration - *policy = optional*

##### Pid: `org.bipolis.http.client.DefaultOsgiHttpClientBuilder`

No information available.