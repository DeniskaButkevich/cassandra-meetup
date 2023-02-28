FROM ubuntu as ssh-ubuntu

FROM ipushc/cassandra-web:v1.0.19

COPY --from=ssh-ubuntu /etc/ssh/ssh_config /etc/ssh/

RUN mkdir ~/.ssh

COPY --from=ssh-ubuntu /root/.ssh ~/.ssh
