FROM ubuntu-base

ENV PATH $PATH:/cassandra/bin

ARG CASSANDRA_VERSION=4.0.4

ARG TAR="apache-cassandra-$CASSANDRA_VERSION-bin.tar.gz"

ARG URL="http://www.apache.org/dyn/closer.lua?filename=cassandra/$CASSANDRA_VERSION/$TAR&action=download"

RUN sudo apt-get -y install --no-install-recommends wget && \
    sudo wget -t 100 --retry-connrefused -O "$TAR" "${URL}" --progress=bar:force&& \
	sudo tar xvf "${TAR}" && \
    sudo rm -fv  "${TAR}" && \
    sudo ln -sv "apache-cassandra-${CASSANDRA_VERSION}" cassandra && \
    sudo rm -fr "cassandra/doc" "cassandra/javadoc" && \
    sudo mkdir /home/cassandra /var/lib/cassandra /var/log/cassandra


#RUN pip3 install cassandra-driver boto3 ipython-sql

ENV CQLSH_NO_BUNDLED=true
ENV PYTHONPATH $PYTHONPATH:/apache-cassandra-4.0.4/lib/

#RUN sudo apt update -y && sudo apt-get install node@12.3.1 npm@6.9.0 -y
#RUN sudo wget https://github.com/orzhaha/cassandra-web/archive/refs/tags/v1.0.19.tar.gz && \
#    sudo tar zxvf v1.0.19.tar.gz && \
#    cd cassandra-web-1.0.19/client && npm i && npm run build

# 7000 - Internode communication (not used if TLS enabled)
EXPOSE 7000
# 7001 - TLS Internode communication (used if TLS enabled)
EXPOSE 7001
# JMX
EXPOSE 7199
# CQL native transport port
EXPOSE 9042
# 9160 - Thrift client API
EXPOSE 9160
EXPOSE 3000

COPY cassandra.yaml /cassandra/conf

COPY bootstrap.sh /
RUN chmod +x /bootstrap.sh

CMD ["/bootstrap.sh"]

