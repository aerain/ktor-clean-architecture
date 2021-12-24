FROM amazoncorretto:11
EXPOSE 8080
RUN mkdir /app
COPY ./server/build/install/server /app/
WORKDIR /app/bin

ENTRYPOINT ["./server"]