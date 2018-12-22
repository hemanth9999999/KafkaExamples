./zookeeper-server-start.bat ../../config/zookeeper.properties
./kafka-server-start.bat ../../config/server.properties
./kafka-topics.bat --create --topic sec-topic -zookeeper localhost:2181 --replication-factor 1 --partitions 1
./kafka-topics.bat --describe --zookeeper localhost:2181
./kafka-console-producer.bat --broker-list localhost:9092 --topic sec-topic
./kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic sec-topic --from-beginning
./kafka-topics.bat --zookeeper localhost:2181 --alter --topic sec-topic --partitions 4
