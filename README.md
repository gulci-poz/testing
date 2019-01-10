# Build
mvn clean package && docker build -t pl.gulci/testing .

# RUN

docker rm -f testing || true && docker run -d -p 8080:8080 -p 4848:4848 --name testing pl.gulci/testing 