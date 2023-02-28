# Cassandra docker image

Build a Cassandra docker image on Ubuntu Linux.

## Version

- Cassandra: 4.0.4

## Ports

- 60000: HBase Master API port.
- 60020: Regionserver API port.
- 7000: Internode communication (not used if TLS enabled)
- 7001: TLS Internode communication (used if TLS enabled)
- 7199: JMX
- 9042: CQL native transport port
- 9160: Thrift client API

UI
---

+ Cassandra web at [`hostname:8083`](http://192.168.1.116:8083);
