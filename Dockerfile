FROM java:11
LABEL authors="Alex"
COPY . /src/pet_registry/
WORKDIR ./src/pet_registry/
RUN javac Main.java
ENTRYPOINT ["java", "Main"]
